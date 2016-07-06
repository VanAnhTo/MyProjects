package Test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import Common.Util;
import PageObject.ObjLogin;

public class LoginBank {
	
	private WebDriver driver;
	
  @Test(priority = 2, enabled = true)
  public void testVerifyUserId() throws Exception 
  {
	  
	  driver.get(Util.URL+"/V4/");
	  Thread.sleep(2000);
	  driver.findElement(ObjLogin.txtusername).sendKeys("mngr39278111");
	  driver.findElement(ObjLogin.txtpass).sendKeys("bUdEguh");
	  driver.findElement(ObjLogin.btnlogin).click();
	  Thread.sleep(3000);
	  String acMessAl;
	  String acTitle;
	  try
	  {
		  Alert al = driver.switchTo().alert();
		  acMessAl = al.getText();
		  al.accept();
		  assertEquals(acMessAl, Util.EXPECTED_ERROR);
	  }
	  catch(Exception e)
	  {
		  acTitle = driver.getTitle();
		  assertEquals(acTitle, Util.EXPECTED_TITLE);
	  }
  }
  @Test(priority = 0, enabled = true)
  public void testVerifyPass() throws Exception 
  {	  
	  driver.get(Util.URL+"/V4/");
	  Thread.sleep(2000);
	  driver.findElement(By.name("uid")).sendKeys("mngr39278");
	  driver.findElement(By.name("password")).sendKeys("bUdEguh3");
	  driver.findElement(By.name("btnLogin")).click();
	  Thread.sleep(3000);
	  
	  String acMessAl;
	  String acTitle;
	  try
	  {
		  Alert al = driver.switchTo().alert();
		  acMessAl = al.getText();
		  al.accept();
		  assertEquals(acMessAl, Util.EXPECTED_ERROR);
	  }
	  catch(Exception e)
	  {
		  acTitle = driver.getTitle();
		  assertEquals(acTitle, Util.EXPECTED_TITLE);
	  }
  }
  @Test(priority = 3, enabled = true)
  public void testVerifyUserIdPass() throws Exception 
  {
	  
	  driver.get(Util.URL+"/V4/");
	  Thread.sleep(2000);
	  driver.findElement(By.name("uid")).sendKeys("mngr39278111");
	  driver.findElement(By.name("password")).sendKeys("bUdEguh111");
	  driver.findElement(By.name("btnLogin")).click();
	  Thread.sleep(3000);
	  String acMessAl;
	  String acTitle;
	  try
	  {
		  Alert al = driver.switchTo().alert();
		  acMessAl = al.getText();
		  al.accept();
		  assertEquals(acMessAl, Util.EXPECTED_ERROR);
	  }
	  catch(Exception e)
	  {
		  acTitle = driver.getTitle();
		  assertEquals(acTitle, Util.EXPECTED_TITLE);
	  }
  }
  @Test(priority = 1, enabled = true)
  public void testLoginSucess() throws Exception 
  {
	  
	  driver.get(Util.URL+"/V4/");
	  Thread.sleep(2000);
	  driver.findElement(By.name("uid")).sendKeys("mngr39278");
	  driver.findElement(By.name("password")).sendKeys("bUdEguh");
	  driver.findElement(By.name("btnLogin")).click();
	  Thread.sleep(3000);
	  String acMessAl;
	  String acTitle;
	  try
	  {
		  Alert al = driver.switchTo().alert();
		  acMessAl = al.getText();
		  al.accept();
		  assertEquals(acMessAl, Util.EXPECTED_ERROR);
	  }
	  catch(Exception e)
	  {
		  acTitle = driver.getTitle();
		  assertEquals(acTitle, Util.EXPECTED_TITLE);
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
