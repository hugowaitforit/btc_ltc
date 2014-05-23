package trade;

import java.io.IOException;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import log.MyFormatter;
import btcChina.BTCChina;
import btcChina.constant.Market;
import btcChina.model.AccountInfo;
import btcChina.model.Depth;

public class MyTrader {
	static Logger log = Logger.getLogger("Trade");
	static public void main(String[] args) {
		initLoger();
		
		AccountInfo info =  BTCChina.getAccountInfo();
		if (info!=null) {
			System.out.println(info);
		}
		Depth depth = BTCChina.getMarketDepth(10, Market.LTCCNY);
		if (depth!=null) {
			System.out.println(depth);
		}
	}
	
	private static void initLoger(){
		log.setLevel(Level.INFO);
		log.setUseParentHandlers(false);
		try {
			FileHandler handler = new FileHandler(String.format("log/Trade %tc.log", new Date()));
			ConsoleHandler consoleHandler = new ConsoleHandler();
			log.addHandler(handler);
			log.addHandler(consoleHandler);
			for (Handler h : log.getHandlers()) {
				h.setFormatter(new MyFormatter());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
