package pageObject;

import org.openqa.selenium.By;


public class ObjCreate5 {
	
	public static By menuTabThuoc = By.name("li1");
	public static By subMenuThemMoi = By.name("group1");
	
	public static By labelThemThuocHiem = By.cssSelector(".z-div .z-label");
	
	public static By txtSoDonHang = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtNoiKy = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtSoCVCamKet = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtNgayKyCV = By.cssSelector(".z-datebox input.z-datebox-inp");
	
	public static By txtTenThuoc = By.cssSelector(".z-groupbox-cnt .z-combobox-inp");
	public static By txtDangBaoChe = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtHamLuong = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtQuyCachDongGoi = By.cssSelector(".z-groupbox-cnt .z-textbox");
	//Hoat chat
	public static By txtHoatChat = By.cssSelector(".z-chosenbox .z-chosenbox-inp");
	public static By cmbHoatChat = By.cssSelector("div:nth-child(10)");
	
	public static By txtDonViTinh = By.cssSelector(".z-groupbox-cnt .z-combobox-inp");
	public static By txtSoLuong = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtHanDung = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtTCCL = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtCongDung = By.cssSelector(".z-groupbox-cnt .z-textbox");
	//Cty SX
	public static By txtCTSX = By.cssSelector(".z-chosenbox .z-chosenbox-inp");
	public static By cmbCTSX = By.cssSelector(".z-chosenbox-sel div:nth-child(4)");
	//Cty CC
	public static By txtCTCC = By.cssSelector(".z-chosenbox .z-chosenbox-inp");
	public static By cmbCTCC = By.cssSelector(".z-chosenbox-sel div:nth-child(5)");
	
	public static By txtDonViUyThac = By.cssSelector(".z-groupbox-cnt .z-textbox");
	//Thong tin don vi du tru
	public static By txtSoLuongDuTru = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtDonViTinhSLDTru = By.cssSelector(".z-groupbox-cnt .z-combobox-inp");
	public static By txtDonViDuTru = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtSoDuTru = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtNgayDuTru = By.cssSelector(".z-datebox input.z-datebox-inp");
	public static By btnThemDonViDuTru = By.cssSelector(".button.z-button-os");
	
	public static By btnThemThuoc = By.cssSelector(".button.z-button-os");
	
	public static By btnLuuDonHang = By.cssSelector(".button.z-button-os");
}
