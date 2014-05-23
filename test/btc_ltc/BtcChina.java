package btc_ltc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import btcChina.BTCChina;
import btcChina.constant.Market;

public class BtcChina {
	
	@Before
	public void callBefore(){
		System.out.println("A New Test begin...");
	}
	
	@After
	public void callAfter(){
	}

	@Test
	public void testGetAccountInfo() {
		assertNotNull("getAccountInfo error", BTCChina.getAccountInfo());
	}
	
	@Test
	public void testGetMarketDepth() {
		assertNull("getMarketDepth BTCCNY error", BTCChina.getMarketDepth(0, Market.BTCCNY));
		assertNotNull("getMarketDepth LTCBTC error", BTCChina.getMarketDepth(100, Market.LTCBTC));
		assertNotNull("getMarketDepth LTCCNY error", BTCChina.getMarketDepth(1000, Market.LTCCNY));
	}
	
	@Test
	public void testGetPersonalOrders() {
		assertNotNull("getPersonalOrders BTCCNY error", BTCChina.getPersonalOrders(false, Market.BTCCNY, 10));
		assertNotNull("getPersonalOrders LTCBTC error", BTCChina.getPersonalOrders(false, Market.LTCBTC, 100));
		assertNotNull("getPersonalOrders LTCCNY error", BTCChina.getPersonalOrders(false, Market.LTCCNY, 1000));
		
		assertNotNull("getPersonalOrders BTCCNY error", BTCChina.getPersonalOrders(true, Market.BTCCNY, 1000));
		assertNotNull("getPersonalOrders LTCBTC error", BTCChina.getPersonalOrders(true, Market.LTCBTC, 100));
		assertNotNull("getPersonalOrders LTCCNY error", BTCChina.getPersonalOrders(true, Market.LTCCNY, 10));
	}
	
	@Test
	public void testLTCOperations() {
		int orderid = BTCChina.buy(1, 0.01f, Market.LTCCNY);
		assertNotEquals("buy LTCCNY error", -1,orderid);
		assertNotNull("getPersonalOrder LTCCNY error", BTCChina.getPersonalOrder(orderid, Market.LTCCNY));
		assertNotEquals("cancelOrder LTCCNY error", false,BTCChina.cancelOrder(orderid, Market.LTCCNY));
		
		int orderid2 = BTCChina.buy(0, 0.01f, Market.LTCCNY);
		assertNotEquals("buy LTCCNY with market price error", -1,orderid2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertNotEquals("sell LTCCNY with market price error", -1,BTCChina.sell(0, 0.01f, Market.LTCCNY));
	}

}
