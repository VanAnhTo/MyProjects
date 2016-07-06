package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;
import pageObject.ObjLoginDigitestForum;


public class LoginDigitestForum {
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);		
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1 , enabled = true)
	public void doLoginGroupDigitest() throws Exception
	{
		Util.driver.get(Util.URL);
		// Get data from Excel
		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("GroupDegitest_DataTest.xlsx", "Login");

		String userName = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
		String password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		try
		{
			Util.driver.findElement(ObjLoginDigitestForum.linkTextLogin).click();
			Thread.sleep(2000);
			Util.driver.findElement(ObjLoginDigitestForum.txtEmailorName).sendKeys(userName);
			Util.driver.findElement(ObjLoginDigitestForum.txtPassWord).sendKeys(password);
			Util.driver.findElement(ObjLoginDigitestForum.btnLogin).click();


			String actualMess = Util.driver.findElement(ObjLoginDigitestForum.actualMess).getText();
			Assert.assertEquals(actualMess, ObjLoginDigitestForum.expectedMess);
			ExcelCommon_POI.writeDataToExcel(1, 3, "GroupDegitest_DataTest.xlsx", "Login", "Pass");
			System.out.println("Pass");
		}
		catch(Exception e)
		{
			ExcelCommon_POI.writeDataToExcel(1, 3, "GroupDegitest_DataTest.xlsx", "Login", "Pass");
			System.out.println("Pass");
		}
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();
	}
}
