package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.*;
import pageObject.*;

public class TestLogin {
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		
		OpenBrowser.multi_browser(browser);	
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1, enabled = true)
	public void loginSuccessfull() throws Exception 
	{
		Util.driver.get(Util.URL);
		
		
		// Get data from Excel
		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("1903_TestData.xlsx", "login");
				
		String Email = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
		String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		
		
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys(Email);
		Util.driver.findElement(ObjLogin.txtPass).sendKeys(Password);
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		
		try{
			String actualTitle = Util.driver.getTitle();
			assertEquals(ObjLogin.expectedTitle,actualTitle);
			ExcelCommon_POI.writeDataToExcel(1, 3, "1903_TestData.xlsx", "login", "Pass");
			System.out.println("Pass");
		}
		catch (Exception e)
		{
			System.out.println("log in fail");
			ExcelCommon_POI.writeDataToExcel(1, 3, "1903_TestData.xlsx", "login", "Fail");
			System.out.println("Fail");
		}
		
		Thread.sleep(3000);
		
		//Util.driver.findElement(ObjLogin.linkLogOut).click();
		
	}
	private void assertEquals(String expectedtitle, String actualTitle) {
		// TODO Auto-generated method stub
		
	}
	@Test(priority = 2, enabled = false)
	public void loginInvalidEmail() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Thread.sleep(3000);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Thread.sleep(3000);
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys("email");
		Util.driver.findElement(ObjLogin.txtPass).sendKeys("123");
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = Util.driver.findElement(ObjLogin.actualMessInvalidEmail).getText();
		if(ObjLogin.expectedMessInvalidEmail.contentEquals(actualMess))
		{
			System.out.println("Validated invalid email");
		}
		else
		{
			System.out.println("Not Validated invalid email");
		}
		
		
	}
	@Test(priority = 3, enabled = false)
	public void loginIncorectEmail() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys("w@gmai.com");
		Util.driver.findElement(ObjLogin.txtPass).sendKeys("123");
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = Util.driver.findElement(ObjLogin.actualMessIncorrEmail).getText();
		if(ObjLogin.expectedMessIncorrEmail.contentEquals(actualMess))
		{
			System.out.println("Validated incorrect email");
		}
		else
		{
			System.out.println("Not Validated incorrect email");
		}		
	}
	@Test(priority = 4, enabled = false)
	public void loginWithoutPass() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys("22@gmai.com");
		Util.driver.findElement(ObjLogin.txtPass).sendKeys("");
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = Util.driver.findElement(ObjLogin.actualMessWithoutPass).getText();
		if(ObjLogin.expectedMessWithoutPass.contentEquals(actualMess))
		{
			System.out.println("Validated without pass");
		}
		else
		{
			System.out.println("Not Validated without pass");
		}		
	}
	@Test(priority = 5, enabled = false)
	public void loginInvalidPass() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys("q@gmai.com");
		Util.driver.findElement(ObjLogin.txtPass).sendKeys("222");
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = Util.driver.findElement(ObjLogin.actualMessInvalidPass).getText();
		if(ObjLogin.expectedMessInvalidPass.contentEquals(actualMess))
		{
			System.out.println("Validated invalid pass");
		}
		else
		{
			System.out.println("Not Validated invalid pass");
		}		
	}
	@Test(priority = 6, enabled = false)
	public void loginWithoutEmail() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys("");
		Util.driver.findElement(ObjLogin.txtPass).sendKeys("222");
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = Util.driver.findElement(ObjLogin.actualMessWithoutEmail).getText();
		if(ObjLogin.expectedMessWithoutEmail.contentEquals(actualMess))
		{
			System.out.println("Validated without email");
		}
		else
		{
			System.out.println("Not Validated without email");
		}	
		Thread.sleep(3000);
	}
	@Test(priority = 7, enabled = false)
	public void loginForgotPass() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.linkForgotPass).click();
		
		String actualMess = Util.driver.findElement(ObjLogin.actualMessForgotPass).getText();
		if(ObjLogin.expectMessForgotPass.contentEquals(actualMess))
		{	
			System.out.println("Show popup forgot pass success");
		}
		else
		{
			System.out.println("Show popup forgot pass fail");
		}		
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();
		
	}
}
