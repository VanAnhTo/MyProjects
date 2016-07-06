package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.OpenBrowser;
import common.Util;
import pageObject.ObjAddItemInCard;
import pageObject.ObjLogin;

public class AddItemToCart {
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);		
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1, enabled = true)
	public void addItemToCart() throws InterruptedException, IOException 
	{
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys("q@gmail.com");
		Util.driver.findElement(ObjLogin.txtPass).sendKeys("123");
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualTitle = Util.driver.getTitle();
		if(ObjLogin.expectedTitle.contentEquals(actualTitle))
		{
			System.out.println("login success");
		}
		else
		{
			System.out.println("log in fail");
		}
		Thread.sleep(3000);
		
		Util.driver.findElement(ObjAddItemInCard.txtSearch).sendKeys("star");
		Util.driver.findElement(ObjAddItemInCard.txtSearch).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		Util.driver.findElement(ObjAddItemInCard.items).click();
		Thread.sleep(7000);
		Util.driver.findElement(ObjAddItemInCard.btnAddToCart).click();
		Thread.sleep(7000);
		Util.driver.findElement(ObjAddItemInCard.linktextCart).click();
		Thread.sleep(7000);
		
		String actualMessCart = Util.driver.findElement(ObjAddItemInCard.items).getText();
		
		System.out.println(actualMessCart);
		
		if(ObjAddItemInCard.expectedMessCart.contentEquals(actualMessCart))
		{
			System.out.println("Item was added sucessfully");
		}
		else
		{
			System.out.println("Item was not added");
		}
		Thread.sleep(3000);

		
		Util.driver.findElement(ObjAddItemInCard.linktextEmptyCart).click();
		Thread.sleep(7000);
		
		Alert al = Util.driver.switchTo().alert();
		al.accept();
		
		Thread.sleep(4000);
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();
		
	}
}
