package page.material;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import page.AddBasePage;
import util.PropertiesStore;

public class SpecialNormalMaterialPage extends AddBasePage {

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
			verifyInvalidMessage("Trường bắt buộc nhập");
			return true;
		}
		return false;
	}

	public void verifyEmptyMessage() {
		waitForElement(".z-popup-cnt .z-errbox-center");
		verifyInvalidMessage("Trường bắt buộc nhập");
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
		verifySuccessMessage("Lưu thông tin thành công");
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
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
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
}
