package page.material.add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageBase {

	// Thuoc tinh
	// ===============================================
	// @FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected WebElement fileNumberField;

	// @FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected WebElement signWhereField;

	// @FindBy(css = ".z-checkbox input")
	protected WebElement copporateCheckBox;

	// @FindBy(css = ".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge")
	protected WebElement materialNameField;

	// ham luong dang bao che
	// @FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected WebElement contenMaterialField;

	// Don vi tinh
	// @FindBy(css = ".z-combobox .z-combobox-inp")
	protected WebElement unitMaterialField;

	// So luong
	// @FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected WebElement amountMaterialField;

	// TCCL
	// @FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected WebElement qualityMaterialField;

	// Nha cung cap
	// @FindBy(css = ".z-chosenbox .z-chosenbox-inp")
	protected WebElement providerMaterialField;

	// @FindBy(css = ".z-chosenbox-sel div:nth-child(1)")
	protected WebElement providerMaterialCombobox;

	// Nha san xuat
	// @FindBy(css = ".z-chosenbox .z-chosenbox-inp")
	protected WebElement manufacturalMaterialField;

	// @FindBy(css = ".z-chosenbox-sel div:nth-child(2)")
	protected WebElement manufacturalMaterialCombobox;

	// THong tin thuoc duoc san xuat tu nguyen lieu duoc nhap
	// SDK
	// @FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected WebElement registrationNumberFeild;
	// Nong do:
	// @FindBy(css = "z-groupbox-cnt .z-textbox")
	protected WebElement contentrationField;

	// ham luong
	// @FindBy(css = "z-groupbox-cnt .z-textbox")
	protected WebElement contentImportField;

	// check box cam ket
	// @FindBy(css = ".z-checkbox input ")
	protected WebElement commitedCheckbox;

	// button them nguyen lieu
	// @FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	protected WebElement addMaterialButton;

	// button luu don hang
	// @FindBy(css = ".z-window-embedded-cnt-noborder .button.z-button-os")
	protected WebElement saveListMaterialButton;

	protected WebElement quyCachDongGoiField;

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
		enterTextBoxField(fileNumberField, positionOfFileNumberField, fileNumber);
	}

	public void enterAmountMaterialFieldAs(String amountMaterial) {
		enterTextBoxField(amountMaterialField, positionOfAmountMaterialField, amountMaterial);
	}

	public void enterQualityMaterialFieldAs(String qualityMaterial) {
		enterTextBoxField(qualityMaterialField, positionOfQualityMaterialField, qualityMaterial);
	}

	public void enterSignWhereFieldAs(String signWhere) {
		enterTextBoxField(signWhereField, positionOfSignWhereField, signWhere);
	}

	public void enterContenMaterialFieldAs(String contenMaterial) {
		enterTextBoxField(contenMaterialField, positionOfContenMaterialField, contenMaterial);
	}

	public void enterRegistrationNumberFieldAs(String registrationNumber) {
		enterTextBoxField(registrationNumberFeild, positionOfRegistrationNumberField, registrationNumber);
	}

	public void enterContentrationFeildAs(String contentration) {
		enterTextBoxField(contentrationField, positionOfContentrationFeild, contentration);
	}

	public void enterContentImportFeildAs(String contentration) {
		enterTextBoxField(contentImportField, positionOfContentImportFeild, contentration);
	}

	public void clickCopporateCheckBox() {
		clickCheckbox(copporateCheckBox, positionOfCopporateCheckBox);
	}

	public void enterMaterialNameFieldAs(String materialName) {
		enterComboboxFeild(materialNameField, positionOfMaterialNameFeild, materialName);
	}

	public void enterUnitMaterialFieldAs(String unitMaterial) {
		enterComboboxFeild(unitMaterialField, positionOfUnitMaterialFeild, unitMaterial);
	}

	public void enterQuyCachDongGoiAs(String quyCachDongGoi) {
		enterTextBoxField(quyCachDongGoiField, positionOfQuyCachDongGoi, quyCachDongGoi);
	}

	// Cong ty cung cap
	public void focusOnProviderMaterialField() {
		clickOnChosenTextBox(providerMaterialField, positionOfProviderMaterialField);
	}

	public void chooseProviderMaterialCombobox() {
		clickSelectProviderFromCombobox(providerMaterialCombobox, positionOfProviderMaterialCombobox);
	}

	// Cong ty san xuat
	public void focusManufacturalMaterialField() {
		clickOnChosenTextBox(manufacturalMaterialField, positionOfManufacturalMaterialField);
	}

	public void chooseManufacturalMaterialCombobox() {
		clickSelectManufactureFromCombobox(manufacturalMaterialCombobox, positionOfManufacturalMaterialCombobox);
	}

	// cam ket
	public void clickCommitedCheckbox() {
		clickCheckbox(commitedCheckbox, positionOfCommitedCheckbox);
	}

	// Luu khoan don hang
	public void clickAddMaterialButton() {
		clickButton(addMaterialButton, positionOfAddMaterialButton);
	}

	// Luu don hang
	public void clickSaveListMaterialButton() {
		clickButton(saveListMaterialButton, positionOfaveListMaterialButton);
	}

	protected void enterTextBoxField(WebElement textBox, int position, String content) {
		textBox = allTextbox.get(position);
		textBox.clear();
		textBox.sendKeys(content);
	}

	protected void clickCheckbox(WebElement checkBox, int position) {
		checkBox = allCheckbox.get(position);
		checkBox.click();
	}

	protected void enterComboboxFeild(WebElement comboBox, int position, String content) {
		comboBox = allCombobox.get(position);
		comboBox.clear();
		comboBox.sendKeys(content);
	}

	protected void clickButton(WebElement button, int position) {
		button = allButton.get(position);
		button.click();
	}

	protected void clickOnChosenTextBox(WebElement chosenTextBox, int position) {
		chosenTextBox = allChosenbox.get(position);
		chosenTextBox.click();
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