package page.material.search;

import org.openqa.selenium.WebDriver;

import page.BasePage;

public class SpecialNormalDetailSearchPage extends BasePage {

	public SpecialNormalDetailSearchPage(WebDriver driver) {
		super(driver);
		Map = new SpecialNormalDetailSearchMap(driver);
		Validate = new SpecialNormalDetailSearchValidator(driver);
	}

	protected SpecialNormalDetailSearchMap Map;
	
	public SpecialNormalDetailSearchValidator Validate;
	
	public void enterCertificateNumberFieldAs(String certificateNumber) {
		this.Map.txtCertificateNumber.clear();
		this.Map.txtCertificateNumber.sendKeys(certificateNumber);
	}

	public void enterMaterialNameFieldAs(String materialName) {
		this.Map.txtMaterialName.clear();
		this.Map.txtMaterialName.sendKeys(materialName);
	}

	public void enterOrderNumberFieldAs(String orderNumber) {
		this.Map.txtOrderNumber.clear();
		this.Map.txtOrderNumber.sendKeys(orderNumber);
	}

	public void enterIssuedDateFromFieldAs(String issuedDateFrom) {
		this.Map.dprIssuedFrom.clear();
		this.Map.dprIssuedFrom.sendKeys(issuedDateFrom);
	}

	public void enterIssuedDateToFieldAs(String issuedDateTo) {
		this.Map.dprIssuedTo.clear();
		this.Map.dprIssuedTo.sendKeys(issuedDateTo);
	}

	public void enterCreatedDateFromFieldAs(String createdDateFrom) {
		this.Map.dprCreatedFrom.clear();
		this.Map.dprCreatedFrom.sendKeys(createdDateFrom);
	}

	public void enterCreatedDateToFieldAs(String createdDateTo) {
		this.Map.dprCreatedTo.clear();
		this.Map.dprCreatedTo.sendKeys(createdDateTo);
	}

	public void clickSearchButton() {
		this.Map.btnSearch.click();
	}

	public void clickClearButton() {
		this.Map.btnClear.click();
	}
}
