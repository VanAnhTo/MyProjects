package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;
import pageObject.ObjSign;

public class TestSign {

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);		
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1, enabled = true)
	public void signSuccessfull() throws Exception 
	{
		
		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("1903_TestData.xlsx", "register");
		
		String Email = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
		String Pass = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		String ConfPass = ExcelCommon_POI.getCellData(1, 3, ExcelWSheet);
		
		
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys(Email);
		Util.driver.findElement(ObjSign.txtPass).sendKeys(Pass);
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys(ConfPass);
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		
		try {
			String ActualMessage = Util.driver.findElement(ObjSign.actualMessSuccess).getText();
			assertEquals(ActualMessage, ObjSign.expectedMessSuccess);
			ExcelCommon_POI.writeDataToExcel(1, 4, "1903_TestData.xlsx", "register", "Passed");
			System.out.println("Pass");
		}
		catch (Exception e) {
			ExcelCommon_POI.writeDataToExcel(1, 4, "1903_TestData.xlsx", "register", "Failed");
			System.out.println("Fail");
		}
		
		
//		//String expectedMess = Util.driver.findElement(ObjSign.actualMessSuccess).getText();
//		String actualTile= Util.driver.getTitle();
//		if(ObjSign.expectedTitle.contentEquals(actualTile))
//		{
//			System.out.println("sign success");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
//		
//		Util.driver.findElement(ObjLogin.linkLogOut).click();
	}
	private void assertEquals(String actualMessage, String expectMessage) {
		// TODO Auto-generated method stub
		
	}
	@Test(priority = 2, enabled = false)
	public void signInvalidEmail() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys("email");
		Util.driver.findElement(ObjSign.txtPass).sendKeys("123");
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys("123");
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = Util.driver.findElement(ObjSign.actualMessInvalidEmail).getText();
		if(ObjSign.expectedMessInvalidEmail.contentEquals(actualMess))
		{
			System.out.println("Validated invalid email");
		}
		else
		{
			System.out.println("Not Validated invalid email");
		}
	}
	@Test(priority = 3, enabled = false)
	public void signInvalidConfirmPass() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys("email@gmail.com");
		Util.driver.findElement(ObjSign.txtPass).sendKeys("123");
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys("321");
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = Util.driver.findElement(ObjSign.actualMessInvalidConPass).getText();
		if(ObjSign.expectedMessInvalidConPass.contentEquals(actualMess))
		{
			System.out.println("Validated invalid confirm pass");
		}
		else
		{
			System.out.println("Not Validated invalid confirm pass");
		}
	}
	@Test(priority = 4, enabled = false)
	public void signWithoutEmail() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys("");
		Util.driver.findElement(ObjSign.txtPass).sendKeys("123");
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys("321");
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = Util.driver.findElement(ObjSign.actualMessWithoutEmail).getText();
		if(ObjSign.expectedMessWithoutEmail.contentEquals(actualMess))
		{
			System.out.println("Validated without email");
		}
		else
		{
			System.out.println("Not Validated without email");
		}
	}
	@Test(priority = 5, enabled = false)
	public void signWithoutPass() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys("cc@gmail.com");
		Util.driver.findElement(ObjSign.txtPass).sendKeys("");
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys("321");
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = Util.driver.findElement(ObjSign.actualMessWithoutPass).getText();
		if(ObjSign.expectedMessWithoutPass.contentEquals(actualMess))
		{
			System.out.println("Validated without pass");
		}
		else
		{
			System.out.println("Not Validated without pass");
		}
	}
	@Test(priority = 6, enabled = false)
	public void signWithoutConfPass() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys("q@gmail.com");
		Util.driver.findElement(ObjSign.txtPass).sendKeys("123");
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys("");
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = Util.driver.findElement(ObjSign.actualMessWithoutConfPass).getText();
		if(ObjSign.expectedMessWithoutConfPass.contentEquals(actualMess))
		{
			System.out.println("Validated without confirm pass");
		}
		else
		{
			System.out.println("Validated without confirm pass");
		}
	}
	@Test(priority = 7, enabled = false)
	public void signExistEmail() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL+"?target=profile&mode=register");
		Util.driver.findElement(ObjSign.txtEmail).sendKeys("q@gmail.com");
		Util.driver.findElement(ObjSign.txtPass).sendKeys("123");
		Util.driver.findElement(ObjSign.txtConfirmPass).sendKeys("123");
		Util.driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = Util.driver.findElement(ObjSign.actualMessExistEmail).getText();
		if(ObjSign.expectedMessExistEmail.contentEquals(actualMess))
		{
			System.out.println("Validated exist email");
		}
		else
		{
			System.out.println("Not Validated exist email");
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();
		
	}
	
}
