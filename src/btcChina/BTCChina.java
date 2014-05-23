package btcChina;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;

import btcChina.constant.JsonRpcMethod;
import btcChina.constant.Market;
import btcChina.model.AccountInfo;
import btcChina.model.BuyResponse;
import btcChina.model.Depth;
import btcChina.model.PersonalOrder;
import btcChina.response.AccountInfoResponse;
import btcChina.response.CancelOrderResponse;
import btcChina.response.GetOrderResponse;
import btcChina.response.GetOrdersResponse;
import btcChina.response.MarketDepthResponse;
import btcChina.response.SellResponse;

import com.alibaba.fastjson.JSON;

public class BTCChina {
	static Logger log = Logger.getLogger("Trade");
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	private static final String url = "https://api.btcchina.com/api_trade_v1.php";
	private static final Properties properties = new Properties();
	static{
		try {
			properties.load(BTCChina.class.getResourceAsStream("btcchina.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Set price to 0.0 when you'd like to buy with the market price
	//Return the order Id or -1 which means failed
	public static int buy(float _price, float _amount, Market market) {
		int orderId = -1;
		String price = floatFormat(_price, 2);
		String amount = floatFormat(_amount, 3);
		String param = String.format("%s,%s,\"%s\"", price,amount,market.toString());
		String sparam = String.format("%s,%s,%s", price,amount,market.toString());
		if(_price==0){
			param = String.format("null,%s,\"%s\"",amount,market.toString());
			sparam = String.format(",%s,%s",amount,market.toString());
		}

		try {
			String result =jsonRPC(JsonRpcMethod.BUYORDER.toString(), sparam, param);
			if (!result.equals("ERROR")) {
				BuyResponse res = JSON.parseObject(result,
						BuyResponse.class);
				orderId = res.getResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orderId = -1;
		}
		
		return orderId;
	}

	private static String bytArrayToHex(byte[] a) {
		StringBuilder sb = new StringBuilder();
		for (byte b : a)
			sb.append(String.format("%02x", b & 0xff));
		return sb.toString();
	}

	public static boolean cancelOrder(int orderId, Market market){
		boolean re = false;
		String param = orderId + ",\"" + market + "\"";
		String sparam = orderId + "," + market;

		try {
			String result =jsonRPC(JsonRpcMethod.CANCEL.toString(), sparam, param);
			if (!result.equals("ERROR")) {
				CancelOrderResponse res = JSON.parseObject(result,
						CancelOrderResponse.class);
				re = res.isResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re = false;
		}
		
		return re;
	}

	public static AccountInfo getAccountInfo() {
		AccountInfo info = null;
		try {
			String result = jsonRPC("getAccountInfo", "", "");
			if (!result.equals("ERROR")) {
				AccountInfoResponse res = JSON.parseObject(result,
						AccountInfoResponse.class);
				info = res.getResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
			info = null;
		}
		return info;
	}
	
	public static Depth getMarketDepth(int limit, Market market) {
		if(limit<=0){
			return null;
		}
		Depth depth = null;
		String sparam = String.format("%d,%s", limit,market.toString());
		String param = String.format("%d,\"%s\"", limit,market.toString());
		try {
			String result =jsonRPC(JsonRpcMethod.GETMARKETDEPTH.toString(), sparam, param);
			if (!result.equals("ERROR")) {
				MarketDepthResponse res = JSON.parseObject(result,
						MarketDepthResponse.class);
				depth = res.getResult().getMarket_depth();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			depth = null;
		}
		
		return depth;
	}
	
	private static String getSignature(String data, String key)
			throws Exception {

		// get an hmac_sha1 key from the raw key bytes
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(),
				HMAC_SHA1_ALGORITHM);

		// get an hmac_sha1 Mac instance and initialize with the signing key
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);

		// compute the hmac on input data bytes
		byte[] rawHmac = mac.doFinal(data.getBytes());

		return bytArrayToHex(rawHmac);
	}
	
	public static PersonalOrder getPersonalOrder(int orderId,Market market){
		PersonalOrder order = null;
		String param = String.format("%d,\"%s\"", orderId,market);
		String sparam = String.format("%d,%s", orderId,market);

		try {
			String result =jsonRPC(JsonRpcMethod.GETORDER.toString(), sparam, param);
			if (!result.equals("ERROR")) {
				GetOrderResponse res = JSON.parseObject(result,
						GetOrderResponse.class);
				order = res.getResult().getOrder();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			order = null;
		}
		return order;	
	}

	public static List<PersonalOrder> getPersonalOrders(boolean openonly,Market market,int limit){
		//Do not support offset
		List<PersonalOrder> orders = null;
		String param = String.format("%b,\"%s\",%d", openonly,market,limit);
		String sparam = String.format(",%s,%d",market,limit);
		if(openonly){
			sparam = String.format("1,%s,%d",market,limit);
		}

		try {
			String result =jsonRPC(JsonRpcMethod.GETORDERS.toString(), sparam, param);
			if (!result.equals("ERROR")) {
				GetOrdersResponse res = JSON.parseObject(result,
						GetOrdersResponse.class);
				orders = res.getResult().getOrder();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orders = null;
		}
		return orders;	
	}
	
	private static String jsonRPC(String method, String signatureParams,
			String params2) throws Exception {
		String tonce = "" + (System.currentTimeMillis() * 1000);
		String params = "tonce=" + tonce.toString() + "&accesskey="
				+ properties.getProperty("ACCESS_KEY") + "&requestmethod=post&id=1&method=" + method
				+ "&params=" + signatureParams;
		String hash = getSignature(params, properties.getProperty("SECRET_KEY"));
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		String userpass = properties.getProperty("ACCESS_KEY") + ":" + hash;
		String basicAuth = "Basic "
				+ DatatypeConverter.printBase64Binary(userpass.getBytes());

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Json-Rpc-Tonce", tonce.toString());
		con.setRequestProperty("Authorization", basicAuth);

		String postdata = "{\"method\": \"" + method + "\", \"params\": ["
				+ params2 + "], \"id\": 1}";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postdata);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		if (responseCode != 200) {
			System.out.println("\n" + responseCode +"\n"+ con.getResponseMessage() + "\nError in " + method
					+ ",--params1:" + signatureParams + "--params2:" + params2 + "\n");
			return "ERROR";
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
	
	
	//Set price to 0.0 when you'd like to sell with the market price
	//Return the order Id or -1 which means failed
	public static int sell(float _price, float _amount, Market market) {
		int orderId = -1;
		String price = floatFormat(_price, 2);
		String amount = floatFormat(_amount, 3);
		String param = String.format("%s,%s,\"%s\"", price,amount,market.toString().toLowerCase());
		String sparam = String.format("%s,%s,%s", price,amount,market.toString().toLowerCase());
		if(_price==0){
			param = String.format("null,%s,\"%s\"",amount,market.toString().toLowerCase());
			sparam = String.format(",%s,%s",amount,market.toString().toLowerCase());
		}

		try {
			String result =jsonRPC(JsonRpcMethod.SELLORDERS.toString(), sparam, param);
			if (!result.equals("ERROR")) {
				SellResponse res = JSON.parseObject(result,
						SellResponse.class);
				orderId = res.getResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orderId = -1;
		}
		
		return orderId;
	}
	
	// correct to "num" decimal places 
	private static String floatFormat(float f, int num){
		String pattern = "%." + num + "f";
		float floor_f = Float.valueOf(String.format(pattern, f));
		if(floor_f==(int)floor_f){
			return String.valueOf((int)floor_f);
		}else{
			return String.valueOf(floor_f);
		}
	}
}
