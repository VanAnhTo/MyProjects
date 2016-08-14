package page.material;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import domain.detail.material.SearchDetail;
import page.BasePage;
import util.DatetimeUtil;
import util.MaterialEnum;
import util.PropertiesStore;

public class NormalMaterialSearchPage extends BasePage {
	// Search

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-textbox")
	private List<WebElement> textBoxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-datebox-inp")
	private List<WebElement> dateBoxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-datebox-btn")
	private List<WebElement> datePicker;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	private List<WebElement> buttons;

	@CacheLookup
	@FindBy(css = ".z-listbox-empty-body")
	private WebElement tbdEmpty;

	@CacheLookup
	@FindBy(css = ".z-listbox-empty-body tr td")
	private WebElement tdMessage;

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
	private GridPage grid;

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

	//private String expectedErrorInDatePicker;
	private String dateFormat;

	public NormalMaterialSearchPage(WebDriver driver) throws NumberFormatException, IOException {
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
		//expectedErrorInDatePicker = PropertiesStore.getProperty("ExpectedErrorInDatePicker");
		dateFormat = PropertiesStore.getProperty("DateFormat");
	}

	private void selectOrderType(int orderType) {
		Select sltOrderType = new Select(this.comboboxes.get(0));
		sltOrderType.selectByIndex(orderType);
	}

	private void selectStatus() {
		Select sltOrderType = new Select(this.comboboxes.get(1));
		sltOrderType.selectByVisibleText("Đã nộp");
	}

	private void selectSubstance() {
		Select sltOrderType = new Select(this.comboboxes.get(2));
		int Min = 1;
		int Max = 10;
		sltOrderType.selectByIndex(Min + (int) (Math.random() * ((Max - Min) + 1)));
	}

	public void searchOrderSpecialOfNormal(SearchDetail searchDetail) {
		excuteJavaScript("document.getElementsByClassName(\"z-textbox\")[2].setAttribute('maxlength','60');");

		int orderType = MaterialEnum.OrderType.valueOf(searchDetail.getOrderType()).value;
		this.selectOrderType(orderType);
		this.selectStatus();
		this.selectSubstance();
		this.enterCertificateNumberFieldAs(searchDetail.getCertificateNumber());
		this.enterMaterialNameFieldAs(searchDetail.getMaterialName());
		this.enterOrderNumberFieldAs(searchDetail.getOrderNumber());
		this.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		this.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		this.enterIssuedDateFromFieldAs(searchDetail.getIssuedDateFrom());
		this.enterIssuedDateToFieldAs(searchDetail.getIssuedDateTo());
		this.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		this.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		this.enterIssuedDateFromFieldAs(searchDetail.getIssuedDateFrom());
		this.enterIssuedDateToFieldAs(searchDetail.getIssuedDateTo());
		this.clickSearchButton();
		if (isValidInput(searchDetail)) {
			waitForJSandJQueryToLoad();
		}
		//grid.verifyTotalDocument();
	}

	private boolean isValidInput(SearchDetail searchDetail) {
		/*
		 * if (!(validateMaxlength(searchDetail.getCertificateNumber(), 50) ||
		 * validateMaxlength(searchDetail.getMaterialName(), 100) ||
		 * validateMaxlength(searchDetail.getOrderNumber(), 50) &&
		 * validateInvalidDate(searchDetail) ||
		 * compareRangeDate(searchDetail.getCreatedDateFrom(),
		 * searchDetail.getCreatedDateTo()) ||
		 * compareRangeDate(searchDetail.getIssuedDateFrom(),
		 * searchDetail.getIssuedDateTo()))) { return false; } return true;
		 */
		/*
		 * if (validateMaxlength(searchDetail.getCertificateNumber(), 50) &&
		 * validateMaxlength(searchDetail.getMaterialName(), 100) &&
		 * validateMaxlength(searchDetail.getOrderNumber(), 50) &&
		 * validateInvalidDate(searchDetail) &&
		 * compareRangeDate(searchDetail.getCreatedDateFrom(),
		 * searchDetail.getCreatedDateTo()) &&
		 * compareRangeDate(searchDetail.getIssuedDateFrom(),
		 * searchDetail.getIssuedDateTo())) { return true; } return false;
		 */
		if (!validateMaxlength(searchDetail.getCertificateNumber(), 50))
			return false;
		if (!validateMaxlength(searchDetail.getMaterialName(), 100))
			return false;
		if (!validateMaxlength(searchDetail.getOrderNumber(), 50))
			return false;
		if (!validateInvalidDate(searchDetail))
			return false;
		if (!validateInvalidDate(new String[] { 
				searchDetail.getCreatedDateFrom(),
				searchDetail.getCreatedDateTo() ,
				searchDetail.getIssuedDateFrom(),
				searchDetail.getIssuedDateTo() 
				}))
			return false;
		if (!compareRangeDate(searchDetail.getCreatedDateFrom(), searchDetail.getCreatedDateTo()))
			return false;
		if (!compareRangeDate(searchDetail.getIssuedDateFrom(), searchDetail.getIssuedDateTo()))
			return false;
		return true;
	}

	private boolean validateInvalidDate(SearchDetail searchDetail) {
		if (!DatetimeUtil.isThisDateValid(searchDetail.getCreatedDateTo(), dateFormat)
				|| !DatetimeUtil.isThisDateValid(searchDetail.getCreatedDateFrom(), dateFormat)
				|| !DatetimeUtil.isThisDateValid(searchDetail.getIssuedDateFrom(), dateFormat)
				|| !DatetimeUtil.isThisDateValid(searchDetail.getIssuedDateTo(), dateFormat)) {
			verifyInvalidMessage("Bạn vui lòng nhập đúng định dạng ngày: dd/MM/yyyy");
			return false;
		}
		return true;
	}

	private boolean validateInvalidDate(String[] dates) {
		for (int i = 0; i < dates.length; i++) {
			if (!DatetimeUtil.isThisDateValid(dates[i], dateFormat)) {
				verifyInvalidMessage("Bạn vui lòng nhập đúng định dạng ngày: dd/MM/yyyy");
				return false;
			}
		}
		return true;
	}

	private boolean validateMaxlength(String property, int maxlength) {
		if (property.length() > maxlength) {
			assertMaxlength(maxlength);
			return false;
		}
		return true;
	}

	private boolean compareRangeDate(String fromDate, String toDate) {
		if (fromDate != null && toDate != null) {
			try {
				Date createdDateFrom = DatetimeUtil.convertToDate(fromDate);
				Date createdDateTo = DatetimeUtil.convertToDate(toDate);
				if (createdDateFrom.compareTo(createdDateTo) > 0) {
					waitForElement(".z-notification.z-notification-warning");
					assertRangDateWarning();
					return false;
				}

			} catch (java.text.ParseException e) {

				e.printStackTrace();
			}
		}

		return true;
	}

	public void assertRangDateWarning() {
		String actualErrorAlert = divNotification.getText();
		String expectedErrorAlert = "Thời gian từ ngày không được lớn hơn đến ngày";
		Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
	}

	public void assertMaxlength(int length) {
		String actualErrorAlert = getErrorAlertBox();
		String expectedErrorAlert = "Bạn nhập nội dung quá độ dài cho phép"
				+ length + " ký tự.";
		Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
	}


	public void assertEmptyMessage() {
		if (tbdEmpty.isDisplayed()) {
			String actualErrorAlert = tdMessage.getText();
			String expectedErrorAlert = "Không có đơn hàng nào";
			Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
		} else {
			Assert.assertEquals(1, 2);
		}
	}

	/*private String getExpectedErrorAlert(String exError) {
		return this.expectedErrorInDatePicker = exError;
	}*/

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
