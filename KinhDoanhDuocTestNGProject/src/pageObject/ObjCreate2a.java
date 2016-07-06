package pageObject;

import org.openqa.selenium.By;

public class ObjCreate2a {
	
	public static By menuCreateNL = By.cssSelector("#tabContent .group:nth-child(1)");
	public static By labelCreate2a = By.cssSelector(".z-div .z-label");
	
	public static By txtSoDonHang = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtNoiKy = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By ckbMucDich = By.cssSelector(".z-checkbox input");
	
	public static By txtTenNguyenLieu = By.cssSelector(".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge");
	public static By txtHamLuongDangBaoChe = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtDonViTinh = By.cssSelector(".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge");
	public static By txtQuyCachDongGoi = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtSoLuong = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtTCCL = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtSDKCungHoatChat = By.cssSelector(".z-groupbox-cnt .z-textbox");
	//Nha SX
	public static By txtNSX = By.cssSelector(" .z-chosenbox .z-chosenbox-inp");
	public static By cmbNSX = By.cssSelector(".z-chosenbox-sel div:nth-child(2)");
	
	//Nha Cung cap
	public static By txtNCC = By.cssSelector(" .z-chosenbox .z-chosenbox-inp");
	public static By cmbNCC = By.cssSelector(".z-chosenbox-sel .z-chosenbox-option");
	
	public static By btnThem = By.cssSelector(".button.z-button-os");
	
	public static By btnLuuDonHang = By.cssSelector(".button.z-button-os");
	
}
