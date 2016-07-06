package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

public class Util {
	public static WebDriver driver;
	public static final String URL = "http://10.61.68.32:8080/kinhdoanhduoc/Pages/login.zul";
	public static final String USERNAME ="010203123";
	public static final String PASSWORD = "123";
	
	public static final String getDefauldTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String GetDateTime = dateFormat.format(cal.getTime());
	    return GetDateTime;
	}
}
