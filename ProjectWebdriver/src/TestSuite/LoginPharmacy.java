package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPharmacy {
	
		private WebDriver driver;
		private String baseUrl;
		
		@Before
		public void setUp() throws Exception{
			driver  = new FirefoxDriver();
			driver.manage().window().maximize();
			baseUrl  = "http://10.61.68.32:8080/thongtinthuoc/Pages/login.zul";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		
		@Test
		public void testLogin() throws Exception{
			driver.get(baseUrl);
			driver.findElement(By.cssSelector(" .bginput input[type=text]")).clear();;
			driver.findElement(By.cssSelector(" .bginput input[type=text]")).sendKeys("01020356");
			driver.findElement(By.cssSelector(" .bginput input[type=password]")).clear();;
			driver.findElement(By.cssSelector(" .bginput input[type=password]")).sendKeys("123");			
			driver.findElement(By.cssSelector(" .btn-login button:nth-child(1)")).click();
			
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(" #tabContent .group:nth-child(1)")).click();
			
			
			driver.findElements(By.cssSelector(" .SpanTag .z-groupbox .z-groupbox-cnt .z-textbox")).get(2).sendKeys("CV1212/DNV/2016");
			driver.findElements(By.cssSelector(".z-groupbox-cnt table .z-combobox input")).get(0).sendKeys("Exirol Injection-250mg/5ml");
			driver.findElements(By.cssSelector(" .z-groupbox .z-groupbox-cnt table .z-textbox")).get(11).sendKeys("VN-2345-16");
			driver.findElements(By.cssSelector(" .z-groupbox .z-groupbox-cnt table .z-textbox")).get(12).sendKeys("Thông tin cho cán bộ y tế");
			driver.findElements(By.cssSelector(" .z-groupbox .z-groupbox-cnt table .z-textbox")).get(13).sendKeys("1");
			driver.findElements(By.cssSelector(" .z-groupbox .z-groupbox-cnt table .z-textbox")).get(14).sendKeys("Hoat chat");
			driver.findElements(By.cssSelector(" .z-groupbox .z-groupbox-cnt table .z-textbox")).get(15).sendKeys("Dang bao che");
			driver.findElements(By.cssSelector(" .z-groupbox .z-groupbox-cnt table .z-textbox")).get(16).sendKeys("Ham luong");
			driver.findElements(By.cssSelector(" .z-groupbox-cnt table .z-combobox input")).get(1).sendKeys("Kolon International Corp.");
			
			driver.findElement(By.cssSelector(" .z-groupbox-cnt .button-add-medicince.z-button-os:nth-child(1)")).click();
			
			driver.findElements(By.cssSelector(" .z-groupbox-cnt .z-listbox .z-listbox-body .z-listcell-cnt.z-overflow-hidden img.z-image")).get(0).click();
			
			//driver.findElements(By.cssSelector(" .z-tabs-header .z-tabs-cnt .z-tab-hm")).get(1).click();
			
			
			// Nhan nut sua chi tiet danh muc thuoc:
			//$$(' .z-groupbox-cnt .z-listbox .z-listbox-body .z-listcell-cnt.z-overflow-hidden')
			// Nut sua cho truong hop copy ho so:
			//$$('div.z-window-embedded:not([style*="display: none"]) .z-tabpanel:not([style*="display:none"]) .z-listbox-body .z-listcell .z-listcell-cnt.z-overflow-hidden img.z-image')
			//$(' .group .selected')
		}
		
		@After
		public void teatDown() throws Exception{
			//driver.quit();
		}
}
