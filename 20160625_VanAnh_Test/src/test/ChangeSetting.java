package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
/*import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;*/
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.*;
import pageObject.*;

public class ChangeSetting {

	public class UserModel
	{
		public String siteTitle;
		public String emailAdress;
		public String timeZone;
		public String dayStartOfWeek;		
		public String siteLanguage;

	}	

	@BeforeTest
	@Parameters("browser")
	public void lunchBrowser (String browser) throws Exception
	{
		OpenBrowers.multi_browser(browser);
		Util.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void doChangeSetting() throws Exception
	{
		//login
		Util.driver.get(Util.URL);
		XSSFSheet ExcelWSheetLogin = ExcelCommon_POI.setExcelFile("testData.xlsx", "Login");		
		String Email = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetLogin);
		String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetLogin);

		Util.driver.findElement(LoginPage.txtUsername).clear();
		Util.driver.findElement(LoginPage.txtUsername).sendKeys(Email);
		Util.driver.findElement(LoginPage.txtPassword).sendKeys(Password);
		Util.driver.findElement(LoginPage.btnLogin).click();
		
		//change setting
		XSSFSheet ExcelSheetChangeSetting = ExcelCommon_POI.setExcelFile("testData.xlsx", "ChangeSettings");
		int firstRow =  ExcelSheetChangeSetting.getFirstRowNum();
		int lastRow =  ExcelSheetChangeSetting.getLastRowNum();

		UserModel user;
		List<UserModel> listA = new ArrayList<UserModel>();
		for (int indexR = firstRow; indexR <= lastRow; indexR++) {
			user = new UserModel();

			user.siteTitle = ExcelCommon_POI.getCellData(indexR, 1, ExcelSheetChangeSetting);
			user.emailAdress = ExcelCommon_POI.getCellData(indexR, 2, ExcelSheetChangeSetting);
			user.timeZone = ExcelCommon_POI.getCellData(indexR, 3, ExcelSheetChangeSetting);	
			user.dayStartOfWeek = ExcelCommon_POI.getCellData(indexR, 4, ExcelSheetChangeSetting);	
			user.siteLanguage = ExcelCommon_POI.getCellData(indexR, 5, ExcelSheetChangeSetting);		

			listA.add(user);
		}
		ExcelSheetChangeSetting = null;

		for (int index = 1; index < listA.size(); index++) {
			user = listA.get(index);
			Util.driver.findElement(ChangeSettingPage.menuSettings).click();
			Util.driver.findElement(ChangeSettingPage.txtSiteTitle).clear();
			Util.driver.findElement(ChangeSettingPage.txtSiteTitle).sendKeys(user.siteTitle);
			Util.driver.findElement(ChangeSettingPage.txtEmail).clear();
			Util.driver.findElement(ChangeSettingPage.txtEmail).sendKeys(user.emailAdress);
			Util.driver.findElement(ChangeSettingPage.ckbMembership).click();
			Util.driver.findElement(ChangeSettingPage.cmbTimeZone).sendKeys(user.timeZone);
			Util.driver.findElement(ChangeSettingPage.radioDateFormat).click();
			Util.driver.findElement(ChangeSettingPage.radioTimeFormat).click();
			Util.driver.findElement(ChangeSettingPage.cmbStartDayOfWeek).sendKeys(user.dayStartOfWeek);
			Util.driver.findElement(ChangeSettingPage.cmbSiteLanguage).sendKeys(user.siteLanguage);
			Util.driver.findElement(ChangeSettingPage.btnSubmit).click();

			try 
			{
				String ActualMessage = Util.driver.findElement(ChangeSettingPage.actualMess).getText();
				System.out.println(ActualMessage);
				Assert.assertEquals(ActualMessage, ChangeSettingPage.expectedMess);
				ExcelCommon_POI.writeDataToExcel(index, 6, "testData.xlsx", "ChangeSettings", "Passed");
				System.out.println("Pass");
			}

			catch (Exception e) {
				ExcelCommon_POI.writeDataToExcel(index, 6, "testData.xlsx", "ChangeSettings", "Failed");
				System.out.println("Fail");
			}
		}
		
		
		

		/*try{
			
			//Change settings

			XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("testData.xlsx", "ChangeSettings");		
			String siteTitle = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
			String emailAdress = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
			String timeZone = ExcelCommon_POI.getCellData(1, 3, ExcelWSheet);
			String dayStartOfWeek = ExcelCommon_POI.getCellData(1, 4, ExcelWSheet);
			String siteLanguage = ExcelCommon_POI.getCellData(1, 5, ExcelWSheet);

			Util.driver.findElement(ChangeSettingPage.menuSettings).click();
			Util.driver.findElement(ChangeSettingPage.txtSiteTitle).clear();
			Util.driver.findElement(ChangeSettingPage.txtSiteTitle).sendKeys(siteTitle);
			Util.driver.findElement(ChangeSettingPage.txtEmail).clear();
			Util.driver.findElement(ChangeSettingPage.txtEmail).sendKeys(emailAdress);
			Util.driver.findElement(ChangeSettingPage.ckbMembership).click();
			Util.driver.findElement(ChangeSettingPage.cmbTimeZone).sendKeys(timeZone);
			Util.driver.findElement(ChangeSettingPage.radioDateFormat).click();
			Util.driver.findElement(ChangeSettingPage.radioTimeFormat).click();
			Util.driver.findElement(ChangeSettingPage.cmbStartDayOfWeek).sendKeys(dayStartOfWeek);
			Util.driver.findElement(ChangeSettingPage.cmbSiteLanguage).sendKeys(siteLanguage);
			Util.driver.findElement(ChangeSettingPage.btnSubmit).click();
			Thread.sleep(3000);

			String actualMess = Util.driver.findElement(ChangeSettingPage.actualMess).getText();
			Assert.assertEquals(actualMess, ChangeSettingPage.expectedMess);
			ExcelCommon_POI.writeDataToExcel(1, 6, "testData.xlsx", "ChangeSettings", "Change setting pass");
			System.out.println("Pass");
		}
		catch (Exception e)
		{
			ExcelCommon_POI.writeDataToExcel(1, 6, "testData.xlsx", "ChangeSettings", "Change setting fail");
			System.out.println("Fail");
		}*/

		//logout =]]]]
		Util.driver.get(Util.URL);

		/*WebElement element = Util.driver.findElement(LoginPage.imgLogout);
		Actions action = new Actions(Util.driver);
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		WebElement subElement = Util.driver.findElement(LoginPage.linkLogout);
		action.moveToElement(subElement);
		action.click();
		action.perform();*/

	}
	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();

	}
}
