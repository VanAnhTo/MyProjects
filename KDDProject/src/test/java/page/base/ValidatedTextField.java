package page.base;

import org.openqa.selenium.WebElement;


import org.testng.Assert;

public class ValidatedTextField {

	protected WebElement alertInvalid;

	protected WebElement tbdEmpty;

	protected WebElement tdMessage;

	protected WebElement divNotification;
	
	protected String expectedErrorInDatePicker;
	protected String expectedErrorDateFromBigerDateTo;
	protected String dateFormat;
	
	public void assertRangDateWarning() {
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
	}
}
