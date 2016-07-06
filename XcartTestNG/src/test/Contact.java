package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Util;
import pageObject.ObjContact;

import org.openqa.selenium.By;

public class Contact {
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);		
		//driver.manage().window().maximize();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test (priority = 1, enabled = true)
	public void doContact() throws Exception
	{
		//Util.driver.get(Util.URL+"?target=contact_us");
		XSSFSheet ExcelWsheet = ExcelCommon_POI.setExcelFile("1903_TestData.xlsx", "contact");
		int columnStart = 1;
		int rowsInSheet = ExcelWsheet.getLastRowNum();
		String temp;
		try{
			int column = columnStart;
			By[] controls = new By[]{
					ObjContact.txtYourName,
					ObjContact.txtYourMail,
					ObjContact.txtSubject,
					ObjContact.txtMessage
			};
			for(int rowStart = 1; rowStart <= rowsInSheet; rowStart++){
				Util.driver.get(Util.URL_DIGITEST+"contact/");				
				for(int i = 0; i < controls.length; i++){
					temp = ExcelCommon_POI.getCellData(rowStart,column++,ExcelWsheet);
					Util.driver.findElement(controls[i]).sendKeys(temp);
				}	
				Util.driver.findElement(ObjContact.btbSend).click();
				column = columnStart;
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


	}


}
