package Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Util {
	
	public static final String URL ="http://www.demo.guru99.com/V4/";
	
	
	//Get a random number	
	public static final int DefaulNumber()
	{
		Random rd = new Random();
		int DefaulNumber = 0;
		for (int idx = 1000; idx <= 100000; ++idx) 
		{
			DefaulNumber = rd.nextInt(100000);
		}
		return DefaulNumber;
		
	}
	
	//Get the system datetime
	public static final String DefaulStringTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String getDatetime = dateFormat.format(cal.getTime());
		
		return getDatetime;
	}
	
}
