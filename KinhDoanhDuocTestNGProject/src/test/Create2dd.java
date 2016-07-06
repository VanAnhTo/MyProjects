package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Util;
import pageObject.ObjCreate2dd;
import pageObject.ObjLogin;

public class Create2dd {

	@BeforeTest
	public void setUp() throws Exception
	{
		Util.driver = new FirefoxDriver();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAdd2dd() throws Exception
	{
		//Dang nhap
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.txtUserName).clear();;
		Util.driver.findElement(ObjLogin.txtUserName).sendKeys(Util.USERNAME);
		Util.driver.findElement(ObjLogin.txtPassWord).clear();;
		Util.driver.findElement(ObjLogin.txtPassWord).sendKeys(Util.PASSWORD);			
		Util.driver.findElement(ObjLogin.btnLogin).click();

		int n=2;
		for(int i=1; i<=n ; i++)
		{		
			//them moi nguyen lieu
			Thread.sleep(2000);
			Util.driver.findElement(ObjCreate2dd.menuCreateNL).click();

			//them moi 2dd
			Util.driver.findElements(ObjCreate2dd.labelCreate2dd).get(1).click();

			//thong tin chung don hang
			//Util.driver.findElements(By.cssSelector(".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge")).get(0).sendKeys("Cong ty co phan duoc Nam Ha");
			Util.driver.findElements(ObjCreate2dd.txtSoDonHang).get(0).sendKeys("SDH/2016/"+Util.getDefauldTime());
			Util.driver.findElements(ObjCreate2dd.txtNoiKy).get(1).sendKeys("Ha Noi");
			Util.driver.findElements(ObjCreate2dd.ckbMucDich).get(0).click();
			//Chi tiet don hang
			int n1 = 3;
			for (int j =1; j<=n1; j++)
			{
				//Ten nguyen lieu
				Util.driver.findElements(ObjCreate2dd.txtTenNguyenLieu).get(1).sendKeys("Nguyen lieu 2dd"+Util.getDefauldTime());
				//ham luong
				Util.driver.findElements(ObjCreate2dd.txtHamLuongDangBaoChe).get(2).sendKeys("Ham Luong, dang bao che "+Util.getDefauldTime());
				//don vi tinh
				Util.driver.findElements(ObjCreate2dd.txtDonViTinh).get(2).sendKeys("kg");
				//so luong
				Util.driver.findElements(ObjCreate2dd.txtSoLuong).get(3).sendKeys(Util.getDefauldTime());
				//Tieu chuan chat luong
				Util.driver.findElements(ObjCreate2dd.txtTCCL).get(4).sendKeys("Tieu chuan chat luong "+Util.getDefauldTime());

				//Ten cy CC
				Util.driver.findElements(ObjCreate2dd.txtNCC).get(0).click();
				Util.driver.findElements(ObjCreate2dd.cmbNCC).get(2).click();
				//Util.driver.findElements(By.cssSelector(".z-chosenbox-sel div:nth-child(2)")).get(2).click();

				//ten cty SX
				Util.driver.findElements(ObjCreate2dd.txtNSX).get(1).click();
				Util.driver.findElements(ObjCreate2dd.cmbNSX).get(2).click();		
				//Util.driver.findElements(By.cssSelector(" .z-chosenbox .z-chosenbox-inp")).get(1).click();
				//Util.driver.findElements(By.cssSelector(".z-chosenbox-sel div:nth-child(3)")).get(2).click();	

				//Them		
				//SKD
				Util.driver.findElements(ObjCreate2dd.txtSDK).get(5).sendKeys("SDK/"+Util.getDefauldTime());
				//Hoat chat
				//Util.driver.findElements(By.cssSelector(" .z-chosenbox .z-chosenbox-inp")).get(2).click();
				//Util.driver.findElements(By.cssSelector(".z-chosenbox-sel div:nth-child(2)")).get(1).click();
				//nong do
				Util.driver.findElements(ObjCreate2dd.txtNongDo).get(6).sendKeys("Nong do"+Util.getDefauldTime());
				//ham luong
				Util.driver.findElements(ObjCreate2dd.txtHamLuongSDK).get(7).sendKeys("Ham luong"+Util.getDefauldTime());		
				//check cam ket
				Util.driver.findElements(ObjCreate2dd.ckbCamKet).get(4).click();		

				//Luu ho so khoan donhang
				Util.driver.findElements(ObjCreate2dd.btnThem).get(3).click();

			}

			//Luu toan bo don hang
			Util.driver.findElements(ObjCreate2dd.btnLuuDonHang).get(6).click();

		}

	}

	@AfterTest
	public void teatDown() throws Exception{
		Util.driver.quit();
	}
}
