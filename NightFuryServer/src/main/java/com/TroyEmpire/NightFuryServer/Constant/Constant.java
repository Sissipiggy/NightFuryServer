package com.TroyEmpire.NightFuryServer.Constant;



/**
 * Hold all the constants used in the NightFury Webserver
 */
public class Constant {
	public static final String DB_PATH = "C:/NightFuryServer/DBData";
	
	// Grab News Constants
	public static final String JWC_NEWS_PORTAL_URL = "http://jwcweb.jnu.edu.cn/SmallClass_index.asp?SmallClassName=%CD%A8%D6%AA&BigClassName=%BD%CC%CE%F1%B4%A6";
	public static final String XSC_PORTAL_URL = "http://xsc.jnu.edu.cn/";
	public static final String JWC_ROOT_URL = "http://jwcweb.jnu.edu.cn/";
	// the interval to grab the news
	public static final int INTERVAL_GRAB_NEWS = 5*60*1000;
	
	// the number of returned news to the client side
	public static final int NUMBER_UPDATE_NEWS_TO_CLIENT = 20;
	
	
	
	
	
}
