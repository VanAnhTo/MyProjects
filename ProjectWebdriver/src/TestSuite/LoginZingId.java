package TestSuite;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginZingId {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		baseUrl = "https://id.zing.vn/";
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
	}
	
	@Test
	public void testLoginZing() throws Exception
	{
		try
		{
			driver.get(baseUrl);
			driver.findElement(By.id("login_account")).sendKeys("vananhto112233");
			driver.findElement(By.id("login_pwd")).sendKeys("123321");
			driver.findElement(By.className("zidsignin_btn")).click();
			
			String exLogin ="vananhto112233";
			String actualLogin = driver.findElement(By.className("infotext")).getText();
			assertEquals(exLogin,actualLogin);
			
			if (actualLogin.contentEquals(exLogin))
			{
			System.out.println("Test Passed.");
			} 
			else {
			System.out.println("Test Failed!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed");
		}	
		
	}
	
	@After
	public void tearDown() throws Exception
	{
		//driver.close();
	}
}
