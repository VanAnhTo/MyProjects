package seleniumDigitest;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;
import seleniumDigitestObject.*;

public class LoginDigitest {
	@BeforeTest
	@Parameters("browser")
	public void lunchBrowser (String browser) throws Exception
	{
		OpenBrowser.multi_browser(browser);
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void doLoginOnDigitest() throws Exception
	{
		try{
			//login
			Util.driver.get(Util.URL_DIGITEST+"/wp-login.php");
			XSSFSheet ExcelWSheetLogin = ExcelCommon_POI.setExcelFile("testData.xlsx", "Login");		
			String Email = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetLogin);
			String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetLogin);

			Util.driver.findElement(LoginDigitestPageObject.txtUsername).clear();
			Util.driver.findElement(LoginDigitestPageObject.txtUsername).sendKeys(Email);
			Util.driver.findElement(LoginDigitestPageObject.txtPassword).sendKeys(Password);
			Util.driver.findElement(LoginDigitestPageObject.btnLogin).click();
		}
		catch(Exception e)
		{}
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();

	}
}
