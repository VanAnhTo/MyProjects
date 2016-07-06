package Test;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Util;
import PageObject.ObjAddNewAcc;

public class TestAddNewAcc {

	private WebDriver  driver;
	@BeforeTest
	public void launchBrowser() {
		//System.setProperty("webdriver.chrome.driver",Util.CHROME_DRIVER);
		driver = new FirefoxDriver();		
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test (priority = 1, enabled = true )
	public void testAddNewAcc() throws Exception{
		driver.get(Util.URL+"/V4/");
	  Thread.sleep(2000);
	  driver.findElement(By.name("uid")).sendKeys("mngr39278");
	  driver.findElement(By.name("password")).sendKeys("bUdEguh");
	  driver.findElement(By.name("btnLogin")).click();
	  Thread.sleep(3000);
	  String acMessAl;
	  String acTitle;
	  try
	  {
		  Alert al = driver.switchTo().alert();
		  acMessAl = al.getText();
		  al.accept();
		  assertEquals(acMessAl, Util.EXPECTED_ERROR);
	  }
	  catch(Exception e)
	  {
		  acTitle = driver.getTitle();
		  assertEquals(acTitle, Util.EXPECTED_TITLE);
	  }
	  
	  driver.findElement(By.xpath("html/body/div[2]/div/ul/li[5]/a")).click();
	  driver.findElement(ObjAddNewAcc.txtCustomerId).sendKeys("123");	  
	  Select menudrop = new Select(driver.findElement(ObjAddNewAcc.typeAcc));
	  menudrop.selectByVisibleText("Current");	  
	  driver.findElement(ObjAddNewAcc.txtinideposit).sendKeys("321");
	  driver.findElement(ObjAddNewAcc.btnsubmit).click();
	  
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		//driver.close();
		
	}
	  
	  
}
