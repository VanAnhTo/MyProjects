package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class LogonZingId {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		//river.manage().window().maximize();
		baseUrl = "https://id.zing.vn/v2/register";
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testLogonZing() throws Exception
	{
		driver.get(baseUrl);
		driver.findElement(By.id("regacc_fullname")).sendKeys("Van Anh To");
		driver.findElement(By.id("regacc_account")).sendKeys("vananhto112233");
		driver.findElement(By.id("regacc_pwd")).sendKeys("123321");
		driver.findElement(By.id("regacc_re_pwd")).sendKeys("123321");
		driver.findElement(By.xpath(".//*[@id='dob']/option[5]")).click();
		driver.findElement(By.xpath(".//*[@id='mob']/option[7]")).click();;
		driver.findElement(By.xpath(".//*[@id='yob']/option[18]")).click();;
		driver.findElement(By.xpath(".//*[@id='frmRegAcc']/div[12]/label[2]/input")).click();		
		if(driver.findElement(By.id("check_account_valid")).isDisplayed())
		{
			System.out.println("Ten tai khoan da ton tai");
		}
		else 
		{
			System.out.println("Co the dung tai khoan nay");
			driver.findElement(By.xpath(".//*[@id='frmRegAcc']/div[15]/a")).click();
		}

	}
	@After
	public void tearDown() throws Exception
	{
		//driver.quit();
	}
}
