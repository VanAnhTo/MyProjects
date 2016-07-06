package TestPlugin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.PageObject.LoginPage;
import Common.PageObject.PluginPage;
import Common.Util;


public class DeactivePlugin {
	
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",Util.CHROME_DRIVER);
		driver = new ChromeDriver();		
		//driver.manage().window().maximize();		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Util.TIMEOUT, TimeUnit.SECONDS);
		
	}
	@Test(priority = 0, enabled = true)
	public void deactivePlugin() throws InterruptedException, IOException {
		
		driver.get(Util.URL+"wp-login.php");
		driver.findElement(LoginPage.txtUsername).sendKeys(Util.USENAME);
		driver.findElement(LoginPage.txtPass).sendKeys(Util.PASS);
		driver.findElement(LoginPage.btnSubmit).click();	
		Thread.sleep(3000);
		
		driver.findElement(PluginPage.menuPlugin).click();
		
		driver.findElement(PluginPage.linkDeactivePlugin).click();
		Thread.sleep(2000);		
		
		String exMess = "Plugin deactivated.";
		String acMess = driver.findElement(By.cssSelector("#message > p:nth-child(1)")).getText();
		
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Deactived");
		}
		else
		{
			System.out.println("Failed");
		}
		
		driver.get("http://localhost/selenium-digitest/wp-login.php");
	
	}
	@Test(priority = 1, enabled = true)
	public void deletePlugin() throws InterruptedException, IOException {
		
		driver.get(Util.URL+"wp-login.php");
		driver.findElement(LoginPage.txtUsername).clear();
		driver.findElement(LoginPage.txtUsername).sendKeys(Util.USENAME);
		driver.findElement(LoginPage.txtPass).clear();
		driver.findElement(LoginPage.txtPass).sendKeys(Util.PASS);
		driver.findElement(LoginPage.btnSubmit).click();	
		Thread.sleep(3000);
		
		driver.findElement(PluginPage.menuPlugin).click();
		//delete in table
		driver.findElement(By.cssSelector("#advanced-custom-fields > td.plugin-title.column-primary > div > span.delete > a")).click();
		//submit delete plugin
		driver.findElement(By.id("submit")).click();
		
		//driver.findElement(DashPage.linkDeactivePlugin).click();
		//Thread.sleep(2000);		
		
		String exMess = "The selected plugin has been deleted.";
		String acMess = driver.findElement(By.cssSelector("#message > p")).getText();
		
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Failed");
		}
		
		driver.get("http://localhost/selenium-digitest/wp-login.php");
	
	}
	
	
	@AfterTest
	public void tearDown() throws Exception
	{
		driver.close();
		
	}
}
