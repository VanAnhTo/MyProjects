package TestSuite;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Common.Common;


public class UploadFileZamzar {
	
		private WebDriver driver;
		
		
		@Before
		public void setUp() throws Exception
		{
			driver = new FirefoxDriver();			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		@Test
		public void testUploadFileZamzar() throws Exception
		{
			driver.get(Common.URL);					
			driver.findElement(By.id("inputFile")).click();
			Thread.sleep(3000);
			Process p=Runtime.getRuntime().exec(Common.Path_TestData);
			p.waitFor();        
			Thread.sleep(3000);
			
			driver.findElement(By.id("toExtensionSel")).sendKeys("doc");;
			driver.findElement(By.id("toEmail")).sendKeys("vananhto.bg@gmail.com");
			driver.findElement(By.id("uploadButton")).click();
			
			String exMess = "File upload complete";
			String acMess= driver.findElement(By.cssSelector(".largeHeader")).getText();
			assertEquals(exMess,acMess);
			
			if(exMess.contentEquals(acMess))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}			
		}
		
		@After
		public void tearDown() throws Exception
		{
			//driver.close();
			
		}
}
