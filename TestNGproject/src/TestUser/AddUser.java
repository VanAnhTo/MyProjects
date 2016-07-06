package TestUser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.PageObject.LoginPage;
import Common.PageObject.UserPage;
import Common.Util;


public class AddUser {
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",Util.CHROME_DRIVER);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test(priority = 0, enabled = true)
	public void addUser() throws InterruptedException, IOException {
		
		driver.get(Util.URL+"wp-login.php");
		driver.findElement(LoginPage.txtUsername).sendKeys(Util.USENAME);
		driver.findElement(LoginPage.txtPass).sendKeys(Util.PASS);
		driver.findElement(LoginPage.btnSubmit).click();	
		Thread.sleep(3000);
		
		//click menu user
		driver.findElement(UserPage.menuUser).click();
		//click add user
		driver.findElement(UserPage.addNewUser).click();
		//add infor user
		driver.findElement(UserPage.txtUserLogin).sendKeys("TestNG"+Util.DefaulStringTime());
		driver.findElement(UserPage.txtEmail).sendKeys("testng"+Util.DefaulStringTime()+"@gmail.com");
		driver.findElement(UserPage.txtFirstName).sendKeys("To");
		driver.findElement(UserPage.txtLastName).sendKeys("Anh");
		driver.findElement(UserPage.txtUrl).sendKeys("www.digitest.vn");
		driver.findElement(UserPage.btnShowPass).click();
		driver.findElement(UserPage.txtPass).clear();
		driver.findElement(UserPage.txtPass).sendKeys("NewPassword3");
		
		driver.findElement(UserPage.ckbWeak).click();
		driver.findElement(UserPage.ckbNotification).click();
		driver.findElement(UserPage.cbRole).click();
		
		driver.findElement(UserPage.btnCreat).click();
		
		String exMess ="New user created. Edit user";
		String acMess = driver.findElement(UserPage.actualMess).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Add user success");
		}
		else
		{
			System.out.println("Failed");
		}
		
		//thay cho nut dang xuat
		driver.get(Util.URL+"wp-login.php");
	
		
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		driver.close();
		
	}
}

