package ConfigBrower;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IELogin {
	private WebDriver driver;
	String baseUrl;

	@BeforeTest
	public void launchBrowser() {
		
		System.setProperty("webdriver.ie.driver",
				"F:/Selenium/N8/TestNG/IEDriverServer32.exe");

		driver = new InternetExplorerDriver();		
		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseUrl = "http://localhost/selenium-digitest/wp-login.php";
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyLogin() throws InterruptedException, IOException {
		driver.get(baseUrl);
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("123456");
		driver.findElement(By.id("wp-submit")).click();			
		
		String exMess = "Welcome to WordPress!";
		String acMess= driver.findElement(By.xpath(".//*[@id='welcome-panel']/div/h2")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Login Passed");
		}
		else
		{
			System.out.println("Login Failed");
		}
	}
		
	@Test(priority = 0, enabled = true)
	public void verifyPass() throws InterruptedException, IOException {
		driver.get(baseUrl);
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("456");
		driver.findElement(By.id("wp-submit")).click();			
		
		String exMess = "ERROR: The password you entered for the username admin is incorrect. Lost your password?";
		String acMess= driver.findElement(By.id("login_error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed password");
		}
		else
		{
			System.out.println("Not verifed password");
		}
		
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyUsername() throws InterruptedException, IOException {
		driver.get(baseUrl);
		driver.findElement(By.id("user_login")).sendKeys("admin1");
		driver.findElement(By.id("user_pass")).sendKeys("123456");
		driver.findElement(By.id("wp-submit")).click();			
		
		String exMess = "ERROR: Invalid username. Lost your password?";
		String acMess= driver.findElement(By.id("login_error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed usename");
		}
		else
		{
			System.out.println("Not verifed usename");
		}
		
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyUsernamePass() throws InterruptedException, IOException {
		driver.get(baseUrl);
		driver.findElement(By.id("user_login")).sendKeys("admin1");
		driver.findElement(By.id("user_pass")).sendKeys("123456");
		driver.findElement(By.id("wp-submit")).click();			
		
		String exMess = "ERROR: Invalid username. Lost your password?";
		String acMess= driver.findElement(By.id("login_error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed password, usename");
		}
		else
		{
			System.out.println("Not verifed password, usename");
		}
		
	}
	
	@AfterTest
	public void closeBrowser() {		
		driver.close();
	}
}
