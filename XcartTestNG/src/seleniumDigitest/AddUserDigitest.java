package seleniumDigitest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import seleniumDigitestObject.*;
import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;
import seleniumDigitestObject.LoginDigitestPageObject;

public class AddUserDigitest {

	public class UserModel
	{
		public String username;
		public String email;
		public String firstName;
		public String lastname;		
		public String website;
		public String password;
		public String role;

	}	

	@BeforeTest
	@Parameters("browser")
	public void lunchBrowser (String browser) throws Exception
	{
		OpenBrowser.multi_browser(browser);
		Util.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void doAddNewUser() throws Exception
	{
		//login
		Util.driver.get(Util.URL_DIGITEST+"/wp-login.php");
		XSSFSheet ExcelWSheetLogin = ExcelCommon_POI.setExcelFile("testData.xlsx", "Login");	

		String Email = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetLogin);
		String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetLogin);

		Util.driver.findElement(LoginDigitestPageObject.txtUsername).clear();
		Util.driver.findElement(LoginDigitestPageObject.txtUsername).sendKeys(Email);
		Util.driver.findElement(LoginDigitestPageObject.txtPassword).sendKeys(Password);
		Util.driver.findElement(LoginDigitestPageObject.btnLogin).click();

		//add new user
		XSSFSheet ExcelWSheetAddNewUser = ExcelCommon_POI.setExcelFile("testData.xlsx", "AddNewUser");		

		int firstRow =  ExcelWSheetAddNewUser.getFirstRowNum();
		int lastRow =  ExcelWSheetAddNewUser.getLastRowNum();

		UserModel user;
		List<UserModel> listA = new ArrayList<UserModel>();
		for (int indexR = firstRow; indexR <= lastRow; indexR++) {
			user = new UserModel();
			user.username = ExcelCommon_POI.getCellData(indexR, 1, ExcelWSheetAddNewUser);
			user.email = ExcelCommon_POI.getCellData(indexR, 2, ExcelWSheetAddNewUser);
			user.firstName = ExcelCommon_POI.getCellData(indexR, 3, ExcelWSheetAddNewUser);	
			user.lastname = ExcelCommon_POI.getCellData(indexR, 4, ExcelWSheetAddNewUser);
			user.website = ExcelCommon_POI.getCellData(indexR, 5, ExcelWSheetAddNewUser);
			user.password = ExcelCommon_POI.getCellData(indexR, 6, ExcelWSheetAddNewUser);	
			user.role = ExcelCommon_POI.getCellData(indexR, 7, ExcelWSheetAddNewUser);	

			listA.add(user);
		}

		ExcelWSheetAddNewUser = null;

		for (int index = 1; index < listA.size(); index++) {
			user = listA.get(index);

			Util.driver.findElement(AddNewUserPage.menuUser).click();
			//click add user
			Util.driver.findElement(AddNewUserPage.addNewUser).click();
			//add infor user
			Util.driver.findElement(AddNewUserPage.txtUserLogin).sendKeys(user.username);
			Util.driver.findElement(AddNewUserPage.txtEmail).sendKeys(user.email);
			Util.driver.findElement(AddNewUserPage.txtFirstName).sendKeys(user.firstName);
			Util.driver.findElement(AddNewUserPage.txtLastName).sendKeys(user.lastname);
			Util.driver.findElement(AddNewUserPage.txtUrl).sendKeys(user.website);
			Util.driver.findElement(AddNewUserPage.btnShowPass).click();
			Util.driver.findElement(AddNewUserPage.txtPass).clear();
			Util.driver.findElement(AddNewUserPage.txtPass).sendKeys(user.password);

			Util.driver.findElement(AddNewUserPage.ckbWeak).click();
			//Util.driver.findElement(AddNewUserPage.ckbNotification).click();
			//Util.driver.findElement(AddNewUserPage.cbRole).click();
			Util.driver.findElement(AddNewUserPage.cbRole).sendKeys(user.role);
			Util.driver.findElement(AddNewUserPage.btnCreatUser).click();

			try 
			{
				String ActualMessage = Util.driver.findElement(AddNewUserPage.actualMess).getText();
				System.out.println(ActualMessage);
				Assert.assertEquals(ActualMessage, AddNewUserPage.expectedMess);
				ExcelCommon_POI.writeDataToExcel(index, 8, "testData.xlsx", "AddNewUser", "Passed");
				System.out.println("Pass");
			}

			catch (Exception e) {
				ExcelCommon_POI.writeDataToExcel(index, 8, "testData.xlsx", "AddNewUser", "Failed");
				System.out.println("Fail");
			}

		}

		/*			String actualMess = Util.driver.findElement(AddNewUserPage.actualMess).getText();
			Assert.assertEquals(actualMess, AddNewUserPage.expectedMess);
			ExcelCommon_POI.writeDataToExcel(1, 8, "testData.xlsx", "AddNewUser", "Pass");
			System.out.println("Pass");
		}
		catch (Exception e)
		{
			ExcelCommon_POI.writeDataToExcel(1, 8, "testData.xlsx", "AddNewUser", "Fail");
			System.out.println("Fail");
		}*/



	}


	@AfterTest
	public void tearDown() throws Exception
	{
		Util.driver.close();

	}
}
