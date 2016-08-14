package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddBasePage extends BasePage {

	public AddBasePage(WebDriver driver) {
		super(driver);
	}

	protected WebElement txtSoDonHang;
	protected WebElement txtNoiKy;
	protected WebElement cbxMucDich;
	protected WebElement txtTenNguyenLieu;
	protected WebElement txtHamLuong;
	protected WebElement txtDonViTinh;
	protected WebElement txtSoLuong;
	protected WebElement txtTieuChuanChatLuong;
	protected WebElement txtCongTyCungCap;
	protected WebElement cbxCongTyCungCap;
	protected WebElement txtNhaSanXuat;
	protected WebElement cbxNhaSanXuat;
	protected WebElement txtSoDangKyThuoc;
	protected WebElement txtHamLuongThuoc;
	protected WebElement txtNongDo;
	protected WebElement cbxCamKet;
	protected WebElement btnAdd;
	protected WebElement btnSave;
	protected WebElement txtQuyCachDongGoi;
	
	
	
	// cung cap
	@FindBy(css = ".z-chosenbox-sel div:nth-child(2)")
	private List<WebElement> allChosenComboboxChildCungCap;
	// san xuat
	@FindBy(css = ".z-chosenbox-sel div:nth-child(2)")
	private List<WebElement> allChosenComboboxChildSanXuat;

	@FindBy(css = ".z-groupbox-cnt .z-textbox")
	private List<WebElement> allTextbox;

	@FindBy(css = ".z-checkbox input")
	private List<WebElement> allCheckbox;

	@FindBy(css = ".z-combobox .z-combobox-inp")
	private List<WebElement> allCombobox;

	@FindBy(css = ".z-chosenbox .z-chosenbox-inp")
	private List<WebElement> allChosenbox;

	@FindBy(css = ".button.z-button-os")
	private List<WebElement> allButton;

	// End Thuoc tinh
	// ===============================================

	protected int positionOfFileNumberField;
	protected int positionOfSignWhereField;
	protected int positionOfCopporateCheckBox;

	protected int positionOfMaterialNameFeild;
	protected int positionOfContenMaterialField;
	protected int positionOfAmountMaterialField;
	protected int positionOfQualityMaterialField;
	protected int positionOfUnitMaterialFeild;

	protected int positionOfProviderMaterialField;
	protected int positionOfProviderMaterialCombobox;

	protected int positionOfManufacturalMaterialField;
	protected int positionOfManufacturalMaterialCombobox;

	protected int positionOfContentrationFeild;
	protected int positionOfRegistrationNumberField;
	protected int positionOfContentImportFeild;

	protected int positionOfCommitedCheckbox;
	protected int positionOfAddMaterialButton;
	protected int positionOfaveListMaterialButton;

	protected int positionOfQuyCachDongGoi;

	public void enterFileNumberFieldAs(String fileNumber) {
		enterTextBoxField(allTextbox, txtSoDonHang, positionOfFileNumberField, fileNumber);
	}

	public void enterAmountMaterialFieldAs(String amountMaterial) {
		enterTextBoxField(allTextbox, txtSoLuong, positionOfAmountMaterialField, amountMaterial);
	}

	public void enterQualityMaterialFieldAs(String qualityMaterial) {
		enterTextBoxField(allTextbox, txtTieuChuanChatLuong, positionOfQualityMaterialField, qualityMaterial);
	}

	public void enterSignWhereFieldAs(String signWhere) {
		enterTextBoxField(allTextbox, txtNoiKy, positionOfSignWhereField, signWhere);
	}

	public void enterContenMaterialFieldAs(String contenMaterial) {
		enterTextBoxField(allTextbox, txtHamLuong, positionOfContenMaterialField, contenMaterial);
	}

	public void enterRegistrationNumberFieldAs(String registrationNumber) {
		enterTextBoxField(allTextbox, txtSoDangKyThuoc, positionOfRegistrationNumberField, registrationNumber);
	}

	public void enterContentrationFeildAs(String contentration) {
		enterTextBoxField(allTextbox, txtHamLuongThuoc, positionOfContentrationFeild, contentration);
	}

	public void enterContentImportFeildAs(String contentration) {
		enterTextBoxField(allTextbox, txtNongDo, positionOfContentImportFeild, contentration);
	}

	public void clickCopporateCheckBox() {
		clickCheckbox(allCheckbox, cbxMucDich, positionOfCopporateCheckBox);
	}

	public void enterMaterialNameFieldAs(String materialName) {
		enterComboboxFeild(allCombobox, txtTenNguyenLieu, positionOfMaterialNameFeild, materialName);
	}

	public void enterUnitMaterialFieldAs(String unitMaterial) {
		enterComboboxFeild(allCombobox, txtDonViTinh, positionOfUnitMaterialFeild, unitMaterial);
	}

	public void enterQuyCachDongGoiAs(String quyCachDongGoi) {
		enterTextBoxField(allTextbox, txtQuyCachDongGoi, positionOfQuyCachDongGoi, quyCachDongGoi);
	}

	// Cong ty cung cap
	public void focusOnProviderMaterialField() {
		clickOnChosenTextBox(allChosenbox, txtCongTyCungCap, positionOfProviderMaterialField);
	}

	public void chooseProviderMaterialCombobox() {
		clickSelectProviderFromCombobox(cbxCongTyCungCap, positionOfProviderMaterialCombobox);
	}

	// Cong ty san xuat
	public void focusManufacturalMaterialField() {
		clickOnChosenTextBox(allChosenbox, txtNhaSanXuat, positionOfManufacturalMaterialField);
	}

	public void chooseManufacturalMaterialCombobox() {
		clickSelectManufactureFromCombobox(cbxNhaSanXuat, positionOfManufacturalMaterialCombobox);
	}

	// cam ket
	public void clickCommitedCheckbox() {
		clickCheckbox(allCheckbox, cbxCamKet, positionOfCommitedCheckbox);
	}

	// Luu khoan don hang
	public void clickAddMaterialButton() {
		clickButton(allButton, btnAdd, positionOfAddMaterialButton);
	}

	// Luu don hang
	public void clickSaveListMaterialButton() {
		clickButton(allButton, btnSave, positionOfaveListMaterialButton);
	}

	protected void clickSelectProviderFromCombobox(WebElement choosenComboboxProvider, int position) {
		choosenComboboxProvider = allChosenComboboxChildCungCap.get(position);
		choosenComboboxProvider.click();
	}

	protected void clickSelectManufactureFromCombobox(WebElement choosenComboboxManufacture, int position) {
		choosenComboboxManufacture = allChosenComboboxChildSanXuat.get(position);
		choosenComboboxManufacture.click();
	}
	
	
	

}
