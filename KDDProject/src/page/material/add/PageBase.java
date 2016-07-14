package page.material.add;

import java.util.List;

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
	// @FindBy(css = ".z-checkbox input")
	protected WebElement commitedCheckbox;

	// button them nguyen lieu
	// @FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	protected WebElement addMaterialButton;

	// button luu don hang
	// @FindBy(css = ".z-window-embedded-cnt-noborder .button.z-button-os")
	protected WebElement saveListMaterialButton;

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
	protected int positionOfAmountMaterialField;
	protected int positionOfQualityMaterialField;
	protected int positionOfSignWhereField;
	
	public void enterFileNumberFieldAs(String fileNumber){
		enterTextBoxField(fileNumberField, positionOfFileNumberField, fileNumber);
	}
	
	public void enterAmountMaterialFieldAs(String amountMaterial){
		enterTextBoxField(amountMaterialField, positionOfAmountMaterialField, amountMaterial);
	}

	public void enterQualityMaterialFieldAs(String qualityMaterial){
		enterTextBoxField(qualityMaterialField, positionOfQualityMaterialField, qualityMaterial);
	}
	
	public void enterSignWhereFieldAs(String signWhere){
		enterTextBoxField(signWhereField, positionOfSignWhereField, signWhere);
	}
	protected int positionOfContenMaterialField;
	
	public void enterContenMaterialFieldAs(String contenMaterial){
		enterTextBoxField(contenMaterialField, positionOfContenMaterialField, contenMaterial);
	}
	/*public void enterContenMaterialFieldAs(String contentMaterial) {
		contenMaterialField = allTextbox.get(2);
		contenMaterialField.clear();
		contenMaterialField.sendKeys(contentMaterial);
	}*/
	protected int positionOfRegistrationNumberFeild;
	public void enterRegistrationNumberFeildAs(String registrationNumber){
		enterTextBoxField(registrationNumberFeild, positionOfRegistrationNumberFeild, registrationNumber);
	}
	
	/*public void enterRegistrationNumberFeildAs(String registrationNumner) {
		registrationNumberFeild = allTextbox.get(5);
		registrationNumberFeild.clear();
		registrationNumberFeild.sendKeys(registrationNumner);
	}*/
	protected int positionOfContentrationFeild;
	public void enterContentrationFeildAs(String contentration){
		enterTextBoxField(contentrationField, positionOfContentrationFeild, contentration);
	}
	/*public void enterContentrationFieldAs(String contentration) {
		contentrationField = allTextbox.get(6);
		contentrationField.clear();
		contentrationField.sendKeys(contentration);
	}*/
	protected int positionOfContentImportFeild;
	public void enterContentImportFeildAs(String contentration){
		enterTextBoxField(contentImportField, positionOfContentImportFeild, contentration);
	}
	/*public void enterContentImportFieldFeildAs(String contentImport) {
		contentImportField = allTextbox.get(7);
		contentImportField.clear();
		contentImportField.sendKeys(contentImport);
	}*/
/*
	public void enterSignWhereFieldAs(String signWhere) {
		signWhereField = allTextbox.get(1);
		signWhereField.clear();
		signWhereField.sendKeys(signWhere);
	}
*/
	
	//allCheckbox
	
	protected int positionOfCopporateCheckBox;
	public void clickCopporateCheckBox(){
		clickCheckbox(copporateCheckBox, positionOfCopporateCheckBox);
	}
	/*public void clickCopporateCheckBox() {
		copporateCheckBox = allCheckbox.get(1);
		copporateCheckBox.click();
	}*/

	
	//allCOmbobox
	protected int positionOfMaterialNameFeild;
	public void enterMaterialNameFieldAs(String materialName){
		enterComboboxFeild(materialNameField, positionOfMaterialNameFeild, materialName);
	}
	/*public void enterMaterialNameFieldAs(String materialName) {
		materialNameField = allCombobox.get(1);
		materialNameField.clear();
		materialNameField.sendKeys(materialName);
	}*/
	protected int positionOfUnitMaterialFeild;
	public void enterUnitMaterialFieldAs(String unitMaterial){
		enterComboboxFeild(unitMaterialField, positionOfUnitMaterialFeild, unitMaterial);
	}
	/*public void enterUnitMaterialFieldAs(String unitMaterial) {
		unitMaterialField = allCombobox.get(2);
		unitMaterialField.clear();
		unitMaterialField.sendKeys(unitMaterial);
	}*/
//allchosenbox
	//Cong ty cung cap
	
	protected int positionOfProviderMaterialField;
	public void focusOnProviderMaterialField(){
		clickOnChosenTextBox(providerMaterialField, positionOfProviderMaterialField);
	}
	/*public void focusOnProviderMaterialField() {
		providerMaterialField = allChosenbox.get(0);
		providerMaterialField.click();
	}*/
	protected int positionOfProviderMaterialCombobox;
	public void chooseProviderMaterialCombobox(){
		clickSelectProviderFromCombobox(providerMaterialCombobox, positionOfProviderMaterialCombobox);
	}
	/*public void chooseProviderMaterialCombobox() {
		providerMaterialCombobox = allChosenComboboxChildCungCap.get(2);
		providerMaterialCombobox.click();
	}*/

	//Cong ty san xuat
	protected int positionOfManufacturalMaterialField;
	public void focusManufacturalMaterialField(){
		clickOnChosenTextBox(manufacturalMaterialField, positionOfManufacturalMaterialField);
	}
	/*public void focusManufacturalMaterialField() {
		manufacturalMaterialField = allChosenbox.get(1);
		manufacturalMaterialField.click();
	}*/

	protected int positionOfManufacturalMaterialCombobox;
	public void chooseManufacturalMaterialCombobox(){
		clickSelectManufactureFromCombobox(manufacturalMaterialCombobox, positionOfManufacturalMaterialCombobox);
	}
	/*public void chooseManufacturalMaterialCombobox() {
		manufacturalMaterialCombobox = allChosenComboboxChildSanXuat.get(2);
		manufacturalMaterialCombobox.click();
	}*/
	

	// cam ket
	protected int positionOfCommitedCheckbox;
	public void clickCommitedCheckbox(){
		clickCheckbox(commitedCheckbox, positionOfCommitedCheckbox);
	}
	/*public void clickCommitedCheckbox() {
		commitedCheckbox = allCheckbox.get(4);
		commitedCheckbox.click();
	}*/

	//allButton
	// Luu khoan don hang
	protected int positionOfAddMaterialButton;
	public void clickAddMaterialButton(){
		clickButton(addMaterialButton, positionOfAddMaterialButton);
	}
	
	/*public void clickAddMaterialButton() {
		addMaterialButton = allButton.get(3);
		addMaterialButton.click();
	}*/

	// Luu don hang
	protected int positionOfaveListMaterialButton;
	public void clickSaveListMaterialButton(){
		clickButton(saveListMaterialButton, positionOfaveListMaterialButton);
	}
	/*public void clickSaveListMaterialButton() {
		saveListMaterialButton = allButton.get(6);
		saveListMaterialButton.click();

	}*/

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
