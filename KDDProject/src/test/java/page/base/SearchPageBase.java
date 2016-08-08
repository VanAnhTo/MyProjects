package page.base;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import domain.detail.material.SearchDetail;
import page.base.WaitForEvent;
import util.ValidatedDatetime;

public class SearchPageBase extends ValidatedTextField{
	WebDriver driver;
	// Search
	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-select")
	protected List<WebElement> comboboxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected List<WebElement> textBoxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-datebox-inp")
	protected List<WebElement> dateBoxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-datebox-btn")
	protected List<WebElement> datePicker;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	protected List<WebElement> buttons;

	@FindBy(css = ".z-popup-cnt .z-errbox-center")
	protected WebElement alertInvalid;

	@CacheLookup
	@FindBy(css = ".z-listbox-empty-body")
	protected WebElement tbdEmpty;

	@CacheLookup
	@FindBy(css = ".z-listbox-empty-body tr td")
	protected WebElement tdMessage;

	@FindBy(css = ".z-notification.z-notification-warning div div")
	protected WebElement divNotification;

	protected WebElement cbxOrderType;
	protected WebElement cbxStatus;
	protected WebElement txtCertificateNumber;
	protected WebElement txtMaterialName;
	protected WebElement dprIssuedFrom;
	protected WebElement dprIssuedTo;
	protected WebElement dprCreatedFrom;
	protected WebElement dprCreatedTo;
	protected WebElement txtOrderNumber;
	protected WebElement cbxSubstance;

	protected WebElement btnSearch;
	protected WebElement btnClear;

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

	protected String expectedErrorInDatePicker;
	protected String expectedErrorDateFromBigerDateTo;
	protected String dateFormat;

	public SearchPageBase(WebDriver driver) {
	}

	protected void selectOrderType(int orderType) {
		Select sltOrderType = new Select(this.comboboxes.get(0));
		sltOrderType.selectByIndex(orderType);
	}

	protected void selectStatus() {
		Select sltOrderType = new Select(this.comboboxes.get(1));
		sltOrderType.selectByVisibleText("Đã nộp");
	}

	protected void selectSubstance() {
		Select sltOrderType = new Select(this.comboboxes.get(2));
		int Min = 1;
		int Max = 10;
		sltOrderType.selectByIndex(Min + (int)(Math.random() * ((Max - Min) + 1)));
	}

	protected boolean isValidInput(SearchDetail searchDetail) {

		if (searchDetail.getCertificateNumber().length() > 50) {
			assertMaxlength(50);
			return false;
		}
		if (searchDetail.getMaterialName().length() > 100) {
			assertMaxlength(100);
			return false;
		}
		if (searchDetail.getOrderNumber().length() > 50) {
			assertMaxlength(50);
			return false;
		}

		if (!ValidatedDatetime.isThisDateValid(searchDetail.getCreatedDateTo()) || !ValidatedDatetime.isThisDateValid(searchDetail.getCreatedDateFrom())
				|| !ValidatedDatetime.isThisDateValid(searchDetail.getIssuedDateFrom())
				|| !ValidatedDatetime.isThisDateValid(searchDetail.getIssuedDateTo())) {
			assertAlertDatePickerInvalid();
			return false;
		}
		if (searchDetail.getCreatedDateTo() != null && searchDetail.getCreatedDateFrom() != null) {
			try {
				Date createdDateFrom = ValidatedDatetime.convertToDate(searchDetail.getCreatedDateFrom());
				Date createdDateTo = ValidatedDatetime.convertToDate(searchDetail.getCreatedDateTo());
				if (createdDateFrom.compareTo(createdDateTo) > 0) {
					WaitForEvent.waitForElement(".z-notification.z-notification-warning");
					assertRangDateWarning();
					return false;
				}

			} catch (java.text.ParseException e) {

				e.printStackTrace();
			}
		}
		if (searchDetail.getIssuedDateFrom() != null && searchDetail.getIssuedDateTo() != null) {
			try {
				Date createdDateFrom = ValidatedDatetime.convertToDate(searchDetail.getIssuedDateFrom());
				Date createdDateTo = ValidatedDatetime.convertToDate(searchDetail.getIssuedDateTo());
				if (createdDateFrom.compareTo(createdDateTo) > 0) {
					WaitForEvent.waitForElement(".z-notification.z-notification-warning");
					assertRangDateWarning();
					return false;
				}

			} catch (java.text.ParseException e) {

				e.printStackTrace();
			}
		}
		return true;
	}

/*	public void assertRangDateWarning() {
		String actualErrorAlert = divNotification.getText();
		String expectedErrorMessage = getExpectedErrorMessage(expectedErrorDateFromBigerDateTo);
		Assert.assertEquals(actualErrorAlert, expectedErrorMessage);
	}

	public void assertMaxlength(int length) {
		String actualErrorAlert = getErrorAlertBox();
		String expectedErrorAlert = "Bạn nhập nội dung quá dài, Độ dài cho phép " + length + " ký tự.";
		Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
	}

	public void assertAlertDatePickerInvalid() {
		String actualErrorAlert = getErrorAlertBox();
		String expectedErrorAlert = getExpectedErrorAlert(expectedErrorInDatePicker);
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

	protected String getErrorAlertBox() {
		return alertInvalid.getText();
	}
	
	protected String getExpectedErrorMessage(String exError) {
		return this.expectedErrorDateFromBigerDateTo = exError;
	}

	protected String getExpectedErrorAlert(String exError) {
		return this.expectedErrorInDatePicker = exError;
	}*/

	protected void enterCertificateNumberFieldAs(String certificateNumber) {
		enterTextBoxField(txtCertificateNumber, positionOfCertificateNumberField, certificateNumber);
	}

	protected void enterMaterialNameFieldAs(String materialName) {
		enterTextBoxField(txtMaterialName, positionOfMaterialNameField, materialName);
	}

	protected void enterOrderNumberFieldAs(String orderNumber) {
		enterTextBoxField(txtOrderNumber, positionOfOrderNumberField, orderNumber);
	}

	protected void enterIssuedDateFromFieldAs(String issuedDateFrom) {
		enterDatePickerField(dprIssuedFrom, positionOfIssuedDateFromField, issuedDateFrom);
	}

	protected void enterIssuedDateToFieldAs(String issuedDateTo) {
		enterDatePickerField(dprIssuedTo, positionOfIssuedDateToField, issuedDateTo);
	}

	protected void enterCreatedDateFromFieldAs(String createdDateFrom) {
		enterDatePickerField(dprCreatedFrom, positionOfCreatedDateFromField, createdDateFrom);
	}

	protected void enterCreatedDateToFieldAs(String createdDateTo) {
		enterDatePickerField(dprCreatedTo, positionOfCreatedDateToField, createdDateTo);
	}

	protected void clickSearchButton() {
		clickButton(btnSearch, positionOfSearchButton);
	}

	protected void clickClearButton() {
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
