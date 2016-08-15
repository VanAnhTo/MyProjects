package page.material.search;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import page.BasePage;

public class SpecialNormalDetailSearchValidator extends BasePage {

	public SpecialNormalDetailSearchValidator(WebDriver driver) {
		super(driver);
		Map = new SpecialNormalDetailSearchMap(driver);
	}

	protected SpecialNormalDetailSearchMap Map;

	
	public void verifyRangDateWarning() {
		String actualErrorAlert = divNotification.getText();
		String expectedErrorAlert = "Thời gian từ ngày không được lớn hơn đến ngày";
		Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
	}

	public void verifyMaxlength(int length) {
		String actualErrorAlert = getErrorAlertBox();
		String expectedErrorAlert = "Bạn nhập nội dung quá độ dài cho phép"
				+ length + " kÃ½ tá»±.";
		Assert.assertEquals(actualErrorAlert, expectedErrorAlert);
	}
}
