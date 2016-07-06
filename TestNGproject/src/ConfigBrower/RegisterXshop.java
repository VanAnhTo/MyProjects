package ConfigBrower;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterXshop {
	private WebDriver driver;
	String baseUrl;
	
	@BeforeTest
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseUrl = "http://digitest.vn/xshop/?target=profile&mode=register";
	}
	@Test(priority = 6, enabled = true)
	public void testRegister() throws Exception
	{
		driver.get(baseUrl);
		driver.findElement(By.id("login")).sendKeys("email1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("password-conf")).sendKeys("password");
		driver.findElement(By.cssSelector(".btn.regular-main-button.submit.btn-warning")).click();
		
		driver.quit();
	}
	@Test(priority = 1, enabled = true)
	public void testVerifyEmailNull() throws Exception
	{	
		driver.get(baseUrl);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(" ");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("password-conf")).clear();
		driver.findElement(By.id("password-conf")).sendKeys("password");
		driver.findElement(By.cssSelector(".btn.regular-main-button.submit.btn-warning")).click();
		
		String exMess = "This field is required";
		String acMess= driver.findElement(By.className("error inline-error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed email");
		}
		else
		{
			System.out.println("Not verifed email");
		}
		driver.quit();
	}
	@Test(priority = 2, enabled = true)
	public void testVerifyEmailFormat() throws Exception
	{	
		driver.get(baseUrl);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("a");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("password-conf")).clear();
		driver.findElement(By.id("password-conf")).sendKeys("password");
		driver.findElement(By.cssSelector(".btn.regular-main-button.submit.btn-warning")).click();
		
		String exMess = "Invalid email address";
		String acMess= driver.findElement(By.className("error inline-error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed format email");
		}
		else
		{
			System.out.println("Not verifed format email");
		}
		driver.quit();
	}
	@Test(priority = 3, enabled = true)
	public void testVerifyPaswordNull() throws Exception
	{
		driver.get(baseUrl);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("email1@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("password-conf")).clear();
		driver.findElement(By.id("password-conf")).sendKeys("password");
		driver.findElement(By.cssSelector(".btn.regular-main-button.submit.btn-warning")).click();
		
		String exMess = "This field is required";
		String acMess= driver.findElement(By.className("error inline-error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed password");
		}
		else
		{
			System.out.println("Not verifed password");
		}
		driver.quit();
	}
	@Test(priority = 4, enabled = true)
	public void testVerifyRePasword() throws Exception
	{	
		driver.get(baseUrl);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("email1@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("password-conf")).clear();
		driver.findElement(By.id("password-conf")).sendKeys("");
		driver.findElement(By.cssSelector(".btn.regular-main-button.submit.btn-warning")).click();
		
		String exMess = "This field is required";
		String acMess= driver.findElement(By.className("error inline-error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed repassword");
		}
		else
		{
			System.out.println("Not verifed repassword");
		}
		driver.quit();
		
	}
	@Test(priority = 5, enabled = true)
	public void testVerifyRePaswordNotMatch() throws Exception
	{	
		driver.get(baseUrl);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("email1@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("password-conf")).clear();
		driver.findElement(By.id("password-conf")).sendKeys("pass");
		driver.findElement(By.cssSelector(".btn.regular-main-button.submit.btn-warning")).click();
		
		String exMess = "Error:Personal info: Password and its confirmation do not match";
		String acMess= driver.findElement(By.className("error")).getText();
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Verifed match password");
		}
		else
		{
			System.out.println("Not verifed match repassword");
		}
		driver.quit();
	}
	@AfterTest
	public void closeBrowser() {		
		driver.close();
	}
}
