package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Util;
import pageObject.*;

public class Create2a {
	private WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAdd2a() throws Exception
	{

		// dang nhap
		driver.get(Util.URL);
		driver.findElement(ObjLogin.txtUserName).clear();;
		driver.findElement(ObjLogin.txtUserName).sendKeys(Util.USERNAME);
		driver.findElement(ObjLogin.txtPassWord).clear();;
		driver.findElement(ObjLogin.txtPassWord).sendKeys(Util.PASSWORD);			
		driver.findElement(ObjLogin.btnLogin).click();
		//them moi nguyen lieu
		int n =2;
		for(int i=1; i<=n; i++)
		{
			Thread.sleep(2000);
			driver.findElement(ObjCreate2a.menuCreateNL).click();
			//them moi 2a
			driver.findElements(ObjCreate2a.labelCreate2a).get(0).click();
			Thread.sleep(2000);
			//thong tin chung don hang
			//driver.findElements(By.cssSelector(".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge")).get(0).sendKeys("Cong ty co phan duoc Nam Ha");
			driver.findElements(ObjCreate2a.txtSoDonHang).get(0).sendKeys("SDH/2016/"+Util.getDefauldTime());
			driver.findElements(ObjCreate2a.txtNoiKy).get(1).sendKeys("Ha Noi");
			driver.findElements(ObjCreate2a.ckbMucDich).get(0).click();
			//*******Chi tieet don hang
			int n1 =3;
			for(int j=1 ; j<=n1; j++)
			{
				//Thread.sleep(2000);
				//Ten nguyen lieu
				driver.findElements(ObjCreate2a.txtTenNguyenLieu).get(1).sendKeys("Nguyen lieu thuong 2a "+ Util.getDefauldTime());
				//Hamluong, dang bao che
				driver.findElements(ObjCreate2a.txtHamLuongDangBaoChe).get(2).sendKeys("Ham luong, dang bao che"+Util.getDefauldTime());
				// dpn vi tinh
				driver.findElements(ObjCreate2a.txtDonViTinh).get(2).sendKeys("lit");
				//quy cach dong goi
				driver.findElements(ObjCreate2a.txtQuyCachDongGoi).get(3).sendKeys("Quy cach dong goi"+Util.getDefauldTime());
				//so luong
				driver.findElements(ObjCreate2a.txtSoLuong).get(4).sendKeys(Util.getDefauldTime());
				//tieu chuan chat luong
				driver.findElements(ObjCreate2a.txtTCCL).get(5).sendKeys("Tieu chuan chat luong"+Util.getDefauldTime());
				//So dang ky cua 
				driver.findElements(ObjCreate2a.txtSDKCungHoatChat).get(6).sendKeys("SDK"+Util.getDefauldTime());
				//Nha san xuat
				driver.findElements(ObjCreate2a.txtNSX).get(0).click();
				driver.findElements(ObjCreate2a.cmbNSX).get(1).click();
				//driver.findElements(ObjCreate2a.txtNSX).get(0).click();
				//driver.findElements(By.cssSelector(".z-chosenbox-sel div:nth-child(3)")).get(1).click();
				//driver.findElements(By.cssSelector(".z-chosenbox-pp.z-chosenbox-pp-hidden .z-chosenbox-option:nth-child(10)")).get(0).click();
				//Cty cung cap
				//driver.findElements(By.cssSelector(".z-chosenbox-pp.z-chosenbox-pp-hidden .z-chosenbox-option:nth-child(10)")).get(1).click();
				driver.findElements(ObjCreate2a.txtNCC).get(1).click();
				driver.findElements(ObjCreate2a.cmbNCC).get(20).click();
				//driver.findElements(By.cssSelector(".z-chosenbox-sel .z-chosenbox-option")).get(19).click();
				//Them
				driver.findElements(ObjCreate2a.btnThem).get(2).click();
				Thread.sleep(2000);

			}	

			//luu
			driver.findElements(ObjCreate2a.btnLuuDonHang).get(5).click();

		}
	}

	@AfterTest
	public void teatDown() throws Exception{
		driver.quit();
	}
}
