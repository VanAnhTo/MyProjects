package page.material.add;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.PropertiesStore;

public class SpecialOfNormalPage extends PageEvent {

	WebDriver driver;

	public SpecialOfNormalPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);

		positionOfFileNumberField= Integer.parseInt(PropertiesStore.getProperty("PositionOfFileNumberField_SpecialOfNormalPage"));
		positionOfSignWhereField= Integer.parseInt(PropertiesStore.getProperty("PositionOfSignWhereField_SpecialOfNormalPage"));
		positionOfCopporateCheckBox= Integer.parseInt(PropertiesStore.getProperty("PositionOfCopporateCheckBox_SpecialOfNormalPage"));
		
		positionOfMaterialNameFeild= Integer.parseInt(PropertiesStore.getProperty("PositionOfMaterialNameFeild_SpecialOfNormalPage"));
		positionOfContenMaterialField= Integer.parseInt(PropertiesStore.getProperty("PositionOfContenMaterialField_SpecialOfNormalPage"));
		positionOfAmountMaterialField= Integer.parseInt(PropertiesStore.getProperty("PositionOfAmountMaterialField_SpecialOfNormalPage"));
		positionOfQualityMaterialField= Integer.parseInt(PropertiesStore.getProperty("PositionOfQualityMaterialField_SpecialOfNormalPage"));
		positionOfUnitMaterialFeild= Integer.parseInt(PropertiesStore.getProperty("PositionOfUnitMaterialFeild_SpecialOfNormalPage"));
		
		positionOfProviderMaterialField= Integer.parseInt(PropertiesStore.getProperty("PositionOfProviderMaterialField_SpecialOfNormalPage"));
		positionOfProviderMaterialCombobox= Integer.parseInt(PropertiesStore.getProperty("PositionOfProviderMaterialCombobox_SpecialOfNormalPage"));
		
		positionOfManufacturalMaterialField= Integer.parseInt(PropertiesStore.getProperty("PositionOfManufacturalMaterialField_SpecialOfNormalPage"));
		positionOfManufacturalMaterialCombobox= Integer.parseInt(PropertiesStore.getProperty("PositionOfManufacturalMaterialCombobox_SpecialOfNormalPage"));
		
		positionOfContentrationFeild= Integer.parseInt(PropertiesStore.getProperty("PositionOfContentrationFeild_SpecialOfNormalPage"));
		positionOfRegistrationNumberField= Integer.parseInt(PropertiesStore.getProperty("PositionOfFileNumberField_SpecialOfNormalPage"));
		positionOfContentImportFeild= Integer.parseInt(PropertiesStore.getProperty("PositionOfContentImportFeild_SpecialOfNormalPage"));
		
		positionOfCommitedCheckbox= Integer.parseInt(PropertiesStore.getProperty("PositionOfCommitedCheckbox_SpecialOfNormalPage"));
		positionOfAddMaterialButton= Integer.parseInt(PropertiesStore.getProperty("PositionOfAddMaterialButton_SpecialOfNormalPage"));
		positionOfaveListMaterialButton= Integer.parseInt(PropertiesStore.getProperty("PositionOfaveListMaterialButton_SpecialOfNormalPage"));
 	}


}


/*package page.material.add;

import org.openqa.selenium.WebDriver;

public class SpecialOfNormalPage extends PageEvent {
	WebDriver driver;

	public SpecialOfNormalPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void enterFileNumberFieldAs(String fileNumber)
	{
		fileNumberField = allTextbox.get(0);
		fileNumberField.clear();
		fileNumberField.sendKeys(fileNumber);
	}
	@Override
	public void enterAmountMaterialFieldAs(String amountMaterial)
    {
    	amountMaterialField = allTextbox.get(3);
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
	@Override
	public  void enterQuyCachDongGoiFieldAs(String quyCachDongGoi)
	{}
	
	@Override
	public void enterQualityMaterialFieldAs(String qualityMaterial)
    {
    	qualityMaterialField = allTextbox.get(4);
    	qualityMaterialField.clear();
    	qualityMaterialField.sendKeys(qualityMaterial);
    }
	
	//cong ty cung cap
	@Override
	public void focusOnProviderMaterialField()
	{
		providerMaterialField = allChosenbox.get(0);
		providerMaterialField.click();
	}
	@Override
	public void chooseProviderMaterialCombobox() {
		providerMaterialCombobox = allChosenComboboxChild1.get(2);
		providerMaterialCombobox.click();
	}

	// ct san xuat
	@Override
		public void focusManufacturalMaterialField() {
			manufacturalMaterialField = allChosenbox.get(1);
			manufacturalMaterialField.click();
		}
	@Override
	public void choosemanufacturalMaterialCombobox() 
	{
		manufacturalMaterialCombobox = allChosenComboboxChild2.get(2);
		manufacturalMaterialCombobox.click();
	}
	@Override
	public void enterRegistrationNumberFeildAs(String registrationNumner) {
		registrationNumberFeild = allTextbox.get(5);
		registrationNumberFeild.clear();
		registrationNumberFeild.sendKeys(registrationNumner);
	}
}*/
