package Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
	
	public static final String URL ="http://localhost/selenium-digitest/";
	public static final String USENAME="admin";
	public static final String PASS="123456";	
	public static final long TIMEOUT = 30; //delay time for web	
	public static final String PATH_TESTDATA = "F:\\Selenium\\N7\\uploadplugin.exe";
	public static final String CHROME_DRIVER ="F:/Selenium/N8/TestNG/chromedriver.exe";
	
	//get defaul number by time
	public static final String DefaulStringTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
		Calendar cal = Calendar.getInstance();
		String getDatetime = dateFormat.format(cal.getTime());
		
		return getDatetime;
	}
}
