package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;
import pageObject.ObjSigupDigitestForum;

public class SignupDigitestForum {
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);		
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1 , enabled = true)
	public void doSignUpInGroupDigitest() throws Exception
	{
		Util.driver.get(Util.URL);
		// Get data from Excel
		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("GroupDegitest_DataTest.xlsx", "SignUp");

		String name = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
		String email = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		String password = ExcelCommon_POI.getCellData(1,3, ExcelWSheet);
		String rePassword = ExcelCommon_POI.getCellData(1, 4, ExcelWSheet);
		String month = ExcelCommon_POI.getCellData(1, 5, ExcelWSheet);
		String day = ExcelCommon_POI.getCellData(1, 6, ExcelWSheet);
		String year = ExcelCommon_POI.getCellData(1, 7, ExcelWSheet);
		
		Util.driver.findElement(ObjSigupDigitestForum.btnSignup).click();
		Util.driver.findElement(ObjSigupDigitestForum.cmbCreateAccount).click();
		Util.driver.findElement(ObjSigupDigitestForum.btnSubSigup).click();
		
		Util.driver.findElements(ObjSigupDigitestForum.txtName).get(1).sendKeys(name);
		
		Util.driver.findElements(ObjSigupDigitestForum.txtEmail).get(2).sendKeys(email);
		
		Util.driver.findElements(ObjSigupDigitestForum.txtPassWord).get(3).sendKeys(password);
		
		Util.driver.findElements(ObjSigupDigitestForum.txtRePassWord).get(4).sendKeys(rePassword);
		Util.driver.findElement(ObjSigupDigitestForum.radioGender).click();
		Util.driver.findElement(ObjSigupDigitestForum.cmbMonth).sendKeys(month);
		Util.driver.findElement(ObjSigupDigitestForum.txtDay).sendKeys(day);
		Util.driver.findElement(ObjSigupDigitestForum.txtYear).sendKeys(year);
		Thread.sleep(10000);
		Util.driver.findElement(ObjSigupDigitestForum.ckbAgree).click();
		Util.driver.findElement(ObjSigupDigitestForum.btnSubmit);

	}
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();
		
	}
}
