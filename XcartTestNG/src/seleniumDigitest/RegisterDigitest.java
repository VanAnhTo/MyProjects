package seleniumDigitest;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import seleniumDigitestObject.*;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;


public class RegisterDigitest {
	@BeforeTest
	@Parameters("browser")
	public void lunchBrowser (String browser) throws Exception
	{
		OpenBrowser.multi_browser(browser);
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	
	public void doRegisterOnDigitest() throws Exception
	{
		try{
			XSSFSheet ExcelWSheetLogin = ExcelCommon_POI.setExcelFile("testData.xlsx", "Register");		
			String username = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetLogin);
			String email = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetLogin);
			//Register
			Util.driver.get(Util.URL_DIGITEST+"/wp-login.php");
			Util.driver.findElement(RegisterDigitestPageObject.linkRegister).click();
			Util.driver.findElement(RegisterDigitestPageObject.txtUsername).clear();
			Util.driver.findElement(RegisterDigitestPageObject.txtUsername).sendKeys(username);
			Util.driver.findElement(RegisterDigitestPageObject.txtEmail).clear();;
			Util.driver.findElement(RegisterDigitestPageObject.txtEmail).sendKeys(email);
			Util.driver.findElement(RegisterDigitestPageObject.btnRegister).click();
		}
		catch(Exception e)
		{}
	}
}
