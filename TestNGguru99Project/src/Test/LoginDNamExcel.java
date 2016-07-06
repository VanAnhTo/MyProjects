package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.Util;

public class LoginDNamExcel {
	private WebDriver driver; 
	
	@DataProvider(name = "GuruTest")
	public Object[][] testData() throws Exception {
		return Util.getDataFromExcel(Util.FILE_PATH, Util.SHEET_NAME,
				Util.TABLE_NAME);
	}
	@Test(dataProvider = "GuruTest")
	public void TestLogin(String username, String password) throws Exception {
		//String actualTitle;
		//String actualBoxMsg;
		driver.get(Util.URL);
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(5000);
		String acMess; 
		String acTitle;
		try
		{
			Alert al = driver.switchTo().alert();
			acMess = al.getText();
			al.accept();
			 Assert.assertEquals(acMess, Util.EXPECTED_ERROR);
		}
		catch(Exception e)
		{
			acTitle = driver.getTitle();
			Assert.assertEquals(acTitle, Util.EXPECTED_TITLE);
		}
	}
	@BeforeTest
	  public void beforeTest() {		
			//System.setProperty("webdriver.chrome.driver",
			//		"F:/Selenium/N8/TestNG/chromedriver.exe");
			//driver = new ChromeDriver();	
		driver = new FirefoxDriver() ;		
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
