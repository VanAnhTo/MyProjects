package Guru99Prac;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Common.Util;

public class LoginAndVerify {
	
	private WebDriver  driver;
	
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void testLoginBank() throws Exception
	{
		driver.get(Util.URL);
		driver.findElement(By.name("uid")).sendKeys("mngr39278");
		driver.findElement(By.name("password")).sendKeys("bUdEguh");
		driver.findElement(By.name("btnLogin")).click();
		
		String exTitle = "Guru99 Bank Manager HomePage";
		String acTitle = driver.getTitle();
		assertEquals(exTitle, acTitle);
		if(exTitle.contentEquals(acTitle))
		{
			System.out.println("Logined");
		}
		else
		{
			System.out.println("Failed");
		}
		
	}
	@After
	public void tearDown() throws Exception
	{
		//driver.quit();
	}
		
}
