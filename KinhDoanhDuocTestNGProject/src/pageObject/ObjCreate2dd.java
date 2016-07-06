package pageObject;

import org.openqa.selenium.By;

public class ObjCreate2dd {
	public static By menuCreateNL = By.cssSelector("#tabContent .group:nth-child(1)");
	public static By labelCreate2dd = By.cssSelector(".z-div .z-label");
	
	public static By txtSoDonHang = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtNoiKy = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By ckbMucDich = By.cssSelector(".z-checkbox input");
	
	public static By txtTenNguyenLieu = By.cssSelector(".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge");
	public static By txtHamLuongDangBaoChe = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtDonViTinh = By.cssSelector(".z-combobox .z-combobox-inp");	
	public static By txtSoLuong = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtTCCL = By.cssSelector(".z-groupbox-cnt .z-textbox");
	
	//Cong ty CC
	public static By txtNCC = By.cssSelector(" .z-chosenbox .z-chosenbox-inp");
	public static By cmbNCC = By.cssSelector(" .z-chosenbox-sel div:nth-child(1)");
	//Cong ty SX
	public static By txtNSX = By.cssSelector(" .z-chosenbox .z-chosenbox-inp");
	public static By cmbNSX = By.cssSelector(" .z-chosenbox-sel div:nth-child(2)");
	
	//Thong tin thuoc duoc san xuat tu nguyen lieu duoc nhap
	public static By txtSDK = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtNongDo = By.cssSelector(".z-groupbox-cnt .z-textbox");
	public static By txtHamLuongSDK = By.cssSelector(".z-groupbox-cnt .z-textbox");
	
	
	public static By ckbCamKet = By.cssSelector(" .z-checkbox input");
	
	public static By btnThem = By.cssSelector(".z-groupbox-cnt .button.z-button-os");
	
	public static By btnLuuDonHang = By.cssSelector(".z-window-embedded-cnt-noborder .button.z-button-os");
}
