package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogOnGroup {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		baseUrl = "http://group.digitest.vn/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void testLogOnGroup() throws Exception
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='SignupButton']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ctrl_not_registered']")).click();
		driver.findElement(By.xpath(".//*[@id='login']/div/dl[3]/dd/input")).click();
		Thread.sleep(3000);
	
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) .textCtrl")).get(0).sendKeys("vananhto");
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) .textCtrl")).get(1).sendKeys("vananhto.bg@gmail.com");
		
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) .textCtrl")).get(2).sendKeys("password");
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) .textCtrl")).get(3).sendKeys("password");
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) input[type=radio]")).get(1).click();
		driver.findElement(By.cssSelector("select.autoSize > option:nth-child(13)")).click();
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) .textCtrl")).get(5).sendKeys("29");
		driver.findElements(By.cssSelector("div .ctrlUnit:not(.limited) .textCtrl")).get(6).sendKeys("1992");
		
		Thread.sleep(20000);
		
		driver.findElement(By.id("ctrl_agree")).click();
		driver.findElement(By.id("SubmitButton")).click();
	}
	
	@After
	public void tearDown() throws Exception
	{
		//driver.close();
		
	}
}
