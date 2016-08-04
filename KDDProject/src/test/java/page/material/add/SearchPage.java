package page.material.add;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import domain.detail.material.SearchDetail;
import util.PropertiesStore;

public class SearchPage extends PageEvent {
	// Search

	@FindBy(css = ".z-groupbox-cnt .z-select")
	private List<WebElement> comboboxes;

	@FindBy(css = ".z-groupbox-cnt .z-textbox")
	private List<WebElement> textBoxes;

	@FindBy(css = ".z-groupbox-cnt .z-datebox-inp")
	private List<WebElement> dateBoxes;

	@FindBy(css = ".z-groupbox-cnt .z-datebox-btn")
	private List<WebElement> datePicker;

	@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	private List<WebElement> buttons;

	@FindBy(css = ".z-popup-cnt .z-errbox-center")
	private WebElement alertInvalidDate;

	private WebElement cbxOrderType;
	private WebElement cbxStatus;
	private WebElement txtCertificateNumber;
	private WebElement txtMaterialName;
	private WebElement dprIssuedFrom;
	private WebElement dprIssuedTo;
	private WebElement dprCreatedFrom;
	private WebElement dprCreatedTo;
	private WebElement txtOrderNumber;
	private WebElement cbxSubstance;

	private WebElement btnSearch;
	private WebElement btnClear;

	protected int positionOfOrderTypeField;
	protected int positionOfStatusField;
	protected int positionOfCertificateNumberField;
	protected int positionOfMaterialNameField;
	protected int positionOfIssuedDateFromField;
	protected int positionOfIssuedDateToField;
	protected int positionOfCreatedDateFromField;
	protected int positionOfCreatedDateToField;
	protected int positionOfOrderNumberField;

	protected int positionOfSubstanceField;

	protected int positionOfSearchButton;
	protected int positionOfClearButton;

	private String expectedErrorInDatePicker;

	public SearchPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		positionOfOrderTypeField = Integer.parseInt(PropertiesStore.getProperty("PositionOfOrderTyPeField"));
		positionOfStatusField = Integer.parseInt(PropertiesStore.getProperty("PositionOfStatusField"));
		positionOfCertificateNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCertificateNumberField"));
		positionOfMaterialNameField = Integer.parseInt(PropertiesStore.getProperty("PositionOfMaterialNameField"));
		positionOfIssuedDateFromField = Integer.parseInt(PropertiesStore.getProperty("PositionOfIssuedDateFromField"));
		positionOfIssuedDateToField = Integer.parseInt(PropertiesStore.getProperty("PositionOfIssuedDateToField"));
		positionOfCreatedDateFromField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCreatedDateFromField"));
		positionOfCreatedDateToField = Integer.parseInt(PropertiesStore.getProperty("PositionOfCreatedDateToField"));
		positionOfOrderNumberField = Integer.parseInt(PropertiesStore.getProperty("PositionOfOrderNumberField"));

		positionOfSubstanceField = Integer.parseInt(PropertiesStore.getProperty("PositionOfSubstanceField"));

		positionOfSearchButton = Integer.parseInt(PropertiesStore.getProperty("PositionOfSearchButton"));
		positionOfClearButton = Integer.parseInt(PropertiesStore.getProperty("PositionOfClearButton"));

		expectedErrorInDatePicker = PropertiesStore.getProperty("ExpectedErrorInDatePicker");
	}

	public void searchOrderSpecialOfNormal(SearchDetail searchDetail) {
		this.enterCertificateNumberFieldAs(searchDetail.getCertificateNumber());
		this.enterMaterialNameFieldAs(searchDetail.getMaterialName());
		this.enterOrderNumberFieldAs(searchDetail.getOrderNumber());
		this.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		this.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		this.enterIssuedDateFromFieldAs(searchDetail.getIssuedDateFrom());
		this.enterIssuedDateToFieldAs(searchDetail.getIssuedDateTo());
		this.clickSearchButton();
		waitForJSandJQueryToLoad();
	}

	public void assertAlertDatePickerInvalid() {
		String actualErrorAlert = getErrorAlertBox();
		String expectedErrorAlert = getExpectedErrorAlert(expectedErrorInDatePicker);
		Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
	}

	public void selectOrderType(int fileType) {
		this.comboboxes.get(fileType).click();
	}

	private String getErrorAlertBox() {
		return alertInvalidDate.getText();
	}

	private String getExpectedErrorAlert(String exError) {
		return this.expectedErrorInDatePicker = exError;
	}

	public void enterCertificateNumberFieldAs(String certificateNumber) {
		enterTextBoxField(txtCertificateNumber, positionOfCertificateNumberField, certificateNumber);
	}

	public void enterMaterialNameFieldAs(String materialName) {
		enterTextBoxField(txtMaterialName, positionOfMaterialNameField, materialName);
	}

	public void enterOrderNumberFieldAs(String orderNumber) {
		enterTextBoxField(txtOrderNumber, positionOfOrderNumberField, orderNumber);
	}

	public void enterIssuedDateFromFieldAs(String issuedDateFrom) {
		enterDatePickerField(dprIssuedFrom, positionOfIssuedDateFromField, issuedDateFrom);
	}

	public void enterIssuedDateToFieldAs(String issuedDateTo) {
		enterDatePickerField(dprIssuedTo, positionOfIssuedDateToField, issuedDateTo);
	}

	public void enterCreatedDateFromFieldAs(String createdDateFrom) {
		enterDatePickerField(dprCreatedFrom, positionOfCreatedDateFromField, createdDateFrom);
	}

	public void enterCreatedDateToFieldAs(String createdDateTo) {
		enterDatePickerField(dprCreatedTo, positionOfCreatedDateToField, createdDateTo);
	}

	public void clickSearchButton() {
		clickButton(btnSearch, positionOfSearchButton);
	}

	public void clickClearButton() {
		clickButton(btnClear, positionOfClearButton);
	}

	protected void enterTextBoxField(WebElement textBox, int position, String content) {
		textBox = textBoxes.get(position);
		textBox.clear();
		textBox.sendKeys(content);
	}

	protected void enterDatePickerField(WebElement datePicker, int position, String dateMonth) {
		datePicker = dateBoxes.get(position);
		datePicker.clear();
		datePicker.sendKeys(dateMonth);
	}

	protected void clickButton(WebElement button, int position) {
		button = buttons.get(position);
		button.click();
	}

	protected void selectCombobox(WebElement combobox, int position) {
		combobox = comboboxes.get(position);
		combobox.click();
	}

}
