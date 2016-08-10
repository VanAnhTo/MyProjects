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
	}
	public void saveMaterialWith(PageDetail new2ddDetails) {
		waitForTextboxFeildAppear();
		this.clickCopporateCheckBox();
		this.enterFileNumberFieldAs(new2ddDetails.getFileNumber());
		this.enterSignWhereFieldAs(new2ddDetails.getSignWhere());

		int i = 1;
		for (MaterialDetail materialDetail : new2ddDetails.getMaterialDetailList()) {
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImportl());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());

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
		waitForAlert();
	}

}
