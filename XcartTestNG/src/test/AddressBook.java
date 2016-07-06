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
import pageObject.ObjAddressBook;
import pageObject.ObjLogin;

public class AddressBook {

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);		
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1 , enabled = true)
	public void updateAddressBook() throws Exception
	{
		// 1 ho ten 3 dia chi 4 thanh mpho

		String testData ="1903_TestData.xlsx";
		String addressSheet = "addressbook";
		String loginSheet = "login";



		//Login	
		Util.driver.get(Util.URL);

		XSSFSheet ExcelWSheetLogin = ExcelCommon_POI.setExcelFile(testData, loginSheet);

		String Username = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetLogin);
		String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetLogin);

		Util.driver.findElement(ObjLogin.linkLogin).click();
		Util.driver.findElement(ObjLogin.txtEmail).clear();
		Util.driver.findElement(ObjLogin.txtEmail).sendKeys(Username);
		Util.driver.findElement(ObjLogin.txtPass).sendKeys(Password);
		Util.driver.findElement(ObjLogin.btnSignIn).click();
		Thread.sleep(4000);

		//Address

		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile(testData, addressSheet);

		int columnStart = 1;
		int rowsInSheet = ExcelWSheet.getLastRowNum();
		System.out.println(rowsInSheet);
		String temp;

		int column = columnStart;

		for(int rowStart = 1; rowStart <= rowsInSheet; rowStart++){
			temp = ExcelCommon_POI.getCellData(rowStart,column,ExcelWSheet);
			if(temp == "") break;
			Util.driver.get(Util.URL+"?target=contact_us");				
			Util.driver.findElement(ObjAddressBook.menuMyAccount).click();
			Util.driver.findElement(ObjAddressBook.tabAddressBook).click();
			Util.driver.findElement(ObjAddressBook.btnAdddressBook).click();
			Thread.sleep(3000);
			Util.driver.findElement(ObjAddressBook.txtFisrtName).clear();

			temp = ExcelCommon_POI.getCellData(rowStart,column++,ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtFisrtName).sendKeys(temp);


			Util.driver.findElement(ObjAddressBook.txtLastName).clear();
			temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtLastName).sendKeys(temp);

			Util.driver.findElement(ObjAddressBook.txtAddress).clear();
			temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtAddress).sendKeys(temp);

			//Util.driver.findElement(ObjAddressBook.txtAddress).clear();
			temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.comboCountry).sendKeys(temp);

			Util.driver.findElement(ObjAddressBook.txtCity).clear();
			temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtCity).sendKeys(temp);

			Util.driver.findElement(ObjAddressBook.txtState).clear();
			temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtState).sendKeys(temp);

			Util.driver.findElement(ObjAddressBook.txtZipcode).clear();
			temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtZipcode).sendKeys(temp);

			Util.driver.findElement(ObjAddressBook.txtPhone).clear();
			String phone = temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
			Util.driver.findElement(ObjAddressBook.txtPhone).sendKeys(temp);

			Util.driver.findElement(ObjAddressBook.btnSubmit).click();
			Thread.sleep(4000);
			try{
				
				String actualTitle = Util.driver.findElement(ObjAddressBook.ActualMess).getText();
				System.out.println(actualTitle);
				System.out.println(phone);
				System.out.println(column);
				assertEquals(phone,actualTitle);
				//temp = ExcelCommon_POI.getCellData(rowStart, column++, ExcelWSheet);
				ExcelCommon_POI.writeDataToExcel(rowStart, 9,testData,addressSheet, "Pass");
				
				System.out.println("Pass");
			}
			catch (Exception e)
			{
				System.out.println("log in fail");
				ExcelCommon_POI.writeDataToExcel(rowStart, 9, testData, addressSheet, "Fail");
				System.out.println("Fail");
			}
			
			column = columnStart;
		}
		
	

}
private void assertEquals(String expectedtitle, String actualTitle) {
	// TODO Auto-generated method stub

}
@AfterTest
public void tearDown() throws Exception
{
	//Util.driver.close();		
}

}
