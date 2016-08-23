package page.material;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import page.AddBasePage;
import util.AppLogger;
import util.PropertiesStore;

public class SpecialNormalMaterialPage extends AddBasePage {

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(2) div")
	private WebElement tdTenNguyenLieu;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(3) span.z-label")
	private WebElement tdDonViTinh;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(4) span.z-label")
	private WebElement tdSoLuong;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(5) span.z-label")
	private WebElement tdTieuChuanChatLuong;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(8) span.z-label")
	private WebElement tdSoDangKy;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(9) span.z-label")
	private WebElement tdNongDoHamLuong;

	public SpecialNormalMaterialPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		positionOfFileNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfFileNumberField_SpecialOfNormalPage"));
		positionOfSignWhereField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfSignWhereField_SpecialOfNormalPage"));
		positionOfCopporateCheckBox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCopporateCheckBox_SpecialOfNormalPage"));

		positionOfMaterialNameFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfMaterialNameFeild_SpecialOfNormalPage"));
		positionOfContenMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfContenMaterialField_SpecialOfNormalPage"));
		positionOfAmountMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfAmountMaterialField_SpecialOfNormalPage"));
		positionOfQualityMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfQualityMaterialField_SpecialOfNormalPage"));
		positionOfUnitMaterialFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfUnitMaterialFeild_SpecialOfNormalPage"));

		positionOfProviderMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfProviderMaterialField_SpecialOfNormalPage"));
		positionOfProviderMaterialCombobox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfProviderMaterialCombobox_SpecialOfNormalPage"));

		positionOfManufacturalMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfManufacturalMaterialField_SpecialOfNormalPage"));
		positionOfManufacturalMaterialCombobox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfManufacturalMaterialCombobox_SpecialOfNormalPage"));

		positionOfContentrationFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfContentrationFeild_SpecialOfNormalPage"));
		positionOfRegistrationNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfRegistrationNumberFeild_SpecialOfNormalPage"));
		positionOfContentImportFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfContentImportFeild_SpecialOfNormalPage"));

		positionOfCommitedCheckbox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCommitedCheckbox_SpecialOfNormalPage"));
		positionOfAddMaterialButton = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfAddMaterialButton_SpecialOfNormalPage"));
		positionOfaveListMaterialButton = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfaveListMaterialButton_SpecialOfNormalPage"));
	}

	public void saveMaterialWith(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.clickCopporateCheckBox();
		if (pageDetail.getFileNumber() != null) {
			this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		}
		if (pageDetail.getSignWhere() != null) {
			this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		}

		int i = 1;
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			if (materialDetail.getAmountMaterial() != null) {
				this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			}
			if (materialDetail.getContenMaterial() != null) {
				this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			}
			if (materialDetail.getMaterialName() != null) {
				this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			}
			if (materialDetail.getUnitMaterial() != null) {
				this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			}
			if (materialDetail.getRegistrationNumber() != null) {
				this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			}
			if (materialDetail.getContentImportl() != null) {
				this.enterContentImportFeildAs(materialDetail.getContentImportl());
			}
			if (materialDetail.getContentration() != null) {
				this.enterContentrationFeildAs(materialDetail.getContentration());
			}
			if (materialDetail.getQualityMateriall() != null) {
				this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			}
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();

			this.clickAddMaterialButton();
			waitForDataFillOnTableComplete(i);
			i++;
		}
		this.clickSaveListMaterialButton();

	}

	public void verifyEmptyMessage(PageDetail pageDetail) {
		if (validateEmptyField(pageDetail.getFileNumber())) {
			return;
		}
		if (validateEmptyField(pageDetail.getSignWhere())) {
			return;
		}
		int i = 1;
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			if (validateEmptyField(materialDetail.getAmountMaterial())) {
				return;
			}
			if (validateEmptyField(materialDetail.getContenMaterial())) {
				return;
			}
			if (validateEmptyField(materialDetail.getMaterialName())) {
				return;
			}
			i++;
		}
		waitForAlert();
	}

	private boolean validateEmptyField(String materialDetail) {
		if (materialDetail == null || materialDetail.equals("")) {
			waitForElement(".z-popup-cnt .z-errbox-center");
			verifyInvalidMessage("TrÆ°á»�ng báº¯t buá»™c nháº­p");
			return true;
		}
		return false;
	}

	public void verifyInvalidMessage() {
		waitForElement(".z-popup-cnt .z-errbox-center");
		verifyInvalidMessage("TrÆ°á»�ng báº¯t buá»™c nháº­p");
	}

	public void verifyErrorMessage(PageDetail pageDetail) {
		if (validateEmptyField(pageDetail.getFileNumber())) {
			return;
		}
		if (validateEmptyField(pageDetail.getSignWhere())) {
			return;
		}
		int i = 1;
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			if (validateEmptyField(materialDetail.getAmountMaterial())) {
				return;
			}
			if (validateEmptyField(materialDetail.getQualityMateriall())) {
				return;
			}
			if (validateEmptyField(materialDetail.getMaterialName())) {
				return;
			}
			if (validateEmptyField(materialDetail.getRegistrationNumber())) {
				return;
			}
			i++;
		}
		waitForAlert();

	}

	public void clickSaveOrder() {
		this.clickSaveListMaterialButton();
	}

	public void verifySuccessMessage(PageDetail pageDetail) {
		verifySuccessMessage("LÆ°u thÃ´ng tin thÃ nh cÃ´ng");
		return;
	}

	public void clickSaveWithoutOrderNumber(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		this.clickSaveListMaterialButton();
	}

	public void clickSaveWithoutSignPlace(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		this.clickSaveListMaterialButton();
	}

	public void clickSaveWithoutMaterialDetais(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		this.clickSaveListMaterialButton();
	}

	public void clickAddWithoutMaterialName(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImportl());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}
	}

	public void clickSaveWithoutContentMaterial(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImportl());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}
	}

	public void clickSaveWithoutAmount(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImportl());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}

	}

	public void clickSaveWithoutQuality(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImportl());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}
	}

	public void verifyWarningMessage(PageDetail pageDetail) {
		verifyWarningMessage("Báº¡n pháº£i nháº­p Ã­t nháº¥t 01 nguyÃªn liá»‡u");
		return;
	}

	protected String getExcuteJavaScript() {
		String s = "var text = ''; "
				+ "text = document.querySelector('.z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(2) span').innerHTML;  "
				+ "text.replace('\\n',''); "
				+ "return text;";
		 return (String) ((JavascriptExecutor) driver).executeScript(s);
	}
	
	public void verifyMaterialOnGrid(PageDetail pageDetail) {
		waitForDataFillOnTableComplete(1);
//		String js = "document.querySelector('.z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(2) span.z-label').innerHTML;";
//		excuteJavaScript(js);
		String actualResult = pageDetail.getMaterialDetailList().get(0).getMaterialName() 
				+ pageDetail.getMaterialDetailList().get(0).getContenMaterial();
		AppLogger.logMessage("actual result: " + actualResult);
		AppLogger.logMessage("js: " + getExcuteJavaScript());
		String expectedResult = getTenNguyenLieu();
		AppLogger.logMessage("expected result: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	private String getTenNguyenLieu() {
		//AppLogger.logMessage(tdTenNguyenLieu.getText());
		//return driver.findElement(By.xpath("//table/tbody[2]/tr[1]/td[2]/div/span[normalize-space()]")).getText();
		return tdTenNguyenLieu.findElement(By.xpath(".//span[normalize-space()]")).getText();
	}
}
