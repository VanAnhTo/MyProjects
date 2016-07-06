package TestPlugin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Util;
import Common.PageObject.*;

public class InstallPlugin {
	
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",Util.CHROME_DRIVER);
		driver = new ChromeDriver();		
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test(priority = 0, enabled = true)
	public void installPlugin() throws InterruptedException, IOException {
		
		driver.get(Util.URL+"wp-login.php");
		driver.findElement(LoginPage.txtUsername).sendKeys(Util.USENAME);
		driver.findElement(LoginPage.txtPass).sendKeys(Util.PASS);
		driver.findElement(LoginPage.btnSubmit).click();	
		Thread.sleep(3000);
		
		driver.findElement(PluginPage.menuPlugin).click();
		
		driver.findElement(PluginPage.addNewPlugin).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".upload")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("pluginzip")).click();				
		Thread.sleep(3000);
		Process p=Runtime.getRuntime().exec(Util.PATH_TESTDATA);
		p.waitFor();        
		Thread.sleep(3000);
		driver.findElement(By.id("install-plugin-submit")).click();
		
		Thread.sleep(3000);
		driver.findElement(PluginPage.linkActivePlugin).click();
		
		String exMess = "Plugin activated.";
		String acMess = driver.findElement(By.cssSelector("#message > p:nth-child(1)")).getText();
		
		if(exMess.contentEquals(acMess))
		{
			System.out.println("Success");
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
