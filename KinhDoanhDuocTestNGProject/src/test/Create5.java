package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Util;
import pageObject.ObjCreate5;
import pageObject.ObjLogin;

public class Create5 {
	@BeforeTest
	public void setUp() throws Exception
	{
		Util.driver = new FirefoxDriver();		
		Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAdd5() throws Exception
	{
		//Dang nhap
		Util.driver.get(Util.URL);
		Util.driver.findElement(ObjLogin.txtUserName).clear();
		Util.driver.findElement(ObjLogin.txtUserName).sendKeys(Util.USERNAME);
		Util.driver.findElement(ObjLogin.txtPassWord).clear();
		Util.driver.findElement(ObjLogin.txtPassWord).sendKeys(Util.PASSWORD);			
		Util.driver.findElement(ObjLogin.btnLogin).click();		

		//them thuoc
//		int n1 = 2;
//		for(int i=1; i<=n1; i++)
//		{
			Util.driver.findElements(ObjCreate5.menuTabThuoc).get(0).click();
			Util.driver.findElement(ObjCreate5.subMenuThemMoi).click();
			Util.driver.findElement(ObjCreate5.labelThemThuocHiem).click();

			//thong tin chung don hang
			//Util.driver.findElement(By.cssSelector(".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge")).sendKeys("Cong ty co phan duoc Nam Ha");
			Util.driver.findElements(ObjCreate5.txtSoDonHang).get(0).sendKeys("SDH/2016/"+Util.getDefauldTime());
			Util.driver.findElements(ObjCreate5.txtNoiKy).get(1).sendKeys("Ha Noi");
			Util.driver.findElements(ObjCreate5.txtSoCVCamKet).get(2).sendKeys("CVCK/2016/"+Util.getDefauldTime());
			Util.driver.findElements(ObjCreate5.txtNgayKyCV).get(0).sendKeys("30/6/2016");
			//thong tin chi tiet don hang

			int n = 3;
			for(int j=1; j<=n; j++)
			{
				//ten thuoc
				Util.driver.findElements(ObjCreate5.txtTenThuoc).get(1).sendKeys("Thuoc hiem 5 "+Util.getDefauldTime());
				//dang bao che
				Util.driver.findElements(ObjCreate5.txtDangBaoChe).get(3).clear();;
				Util.driver.findElements(ObjCreate5.txtDangBaoChe).get(3).sendKeys("Dang bao che " +Util.getDefauldTime());
				//ham luong
				Util.driver.findElements(ObjCreate5.txtHamLuong).get(4).sendKeys("Ham luong "+Util.getDefauldTime());
				//Quy cach dong goi
				Util.driver.findElements(ObjCreate5.txtQuyCachDongGoi).get(5).sendKeys("Quy cach dong goi "+Util.getDefauldTime());
				//Hoat chat
				Util.driver.findElements(ObjCreate5.txtHoatChat).get(0).click();
				Util.driver.findElements(ObjCreate5.cmbHoatChat).get(2).click();
				//don vi tinh
				Util.driver.findElements(ObjCreate5.txtDonViTinh).get(2).sendKeys("lit");
				//so luong
				Util.driver.findElements(ObjCreate5.txtSoLuong).get(6).sendKeys(Util.getDefauldTime());
				//han dung
				Util.driver.findElements(ObjCreate5.txtHanDung).get(7).sendKeys(Util.getDefauldTime()+" thang");
				//tieu chuan chat luong
				Util.driver.findElements(ObjCreate5.txtTCCL).get(8).sendKeys("tieu chuan chat luong "+Util.getDefauldTime());
				//cong dung
				Util.driver.findElements(ObjCreate5.txtCongDung).get(9).sendKeys("Cong dung "+Util.getDefauldTime());
				// Ct sx
				Util.driver.findElements(ObjCreate5.txtCTSX).get(1).click();
				Util.driver.findElements(ObjCreate5.cmbCTSX).get(2).click();
				//Util.driver.findElements(By.cssSelector(" .z-chosenbox .z-chosenbox-inp")).get(1).click();
				//Util.driver.findElements(By.cssSelector(".z-chosenbox-sel div:nth-child(5)")).get(2).click();
				//CT CC
				Util.driver.findElements(ObjCreate5.txtCTCC).get(2).click();
				Util.driver.findElements(ObjCreate5.cmbCTCC).get(2).click();
				//Util.driver.findElements(By.cssSelector(" .z-chosenbox .z-chosenbox-inp")).get(2).click();
				//Util.driver.findElements(By.cssSelector(".z-chosenbox-sel div:nth-child(4)")).get(2).click();
				//don vi uy thac
				Util.driver.findElements(ObjCreate5.txtDonViUyThac).get(10).sendKeys("Don vi uy thac "+Util.getDefauldTime());

				// Don vi du tru
				//SO luong du tru
				Util.driver.findElements(ObjCreate5.txtSoLuongDuTru).get(11).sendKeys(Util.getDefauldTime());
				//don vi tinh so luong
				Util.driver.findElements(ObjCreate5.txtDonViTinhSLDTru).get(3).sendKeys("lit");
				//don vi du tru
				Util.driver.findElements(ObjCreate5.txtDonViDuTru).get(12).sendKeys("Don vi du tru "+Util.getDefauldTime());
				//So du tru
				Util.driver.findElements(ObjCreate5.txtSoDuTru).get(13).sendKeys("BV/2016/"+Util.getDefauldTime());		
				//Ngay du tru
				Util.driver.findElements(ObjCreate5.txtNgayDuTru).get(1).sendKeys("4/5/2016");
				Thread.sleep(2000);
				//nhan them don vidu tru
				Util.driver.findElements(ObjCreate5.btnThemDonViDuTru).get(3).click();
				
				//nhan them thuoc
				Util.driver.findElements(ObjCreate5.btnThemThuoc).get(5).click();		
			
			}

			//Nhan luu don hang
			Util.driver.findElements(ObjCreate5.btnLuuDonHang).get(8).click();
//		}

	}
	@AfterTest
	public void teatDown() throws Exception{
		Util.driver.quit();
	}
}
