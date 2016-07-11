package page.material.add;

import org.openqa.selenium.WebDriver;

public class NormalPage extends PageEvent {

	WebDriver driver;

	public NormalPage(WebDriver driver) {
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
		amountMaterialField = allTextbox.get(4);
		amountMaterialField.clear();
		amountMaterialField.sendKeys(amountMaterial);
	}
	
	@Override
	public  void enterQuyCachDongGoiFieldAs(String quyCachDongGoi)
	{
		fileNumberField = allTextbox.get(3);
		fileNumberField.clear();
		fileNumberField.sendKeys(quyCachDongGoi);
	}
	
	@Override
	public void enterQualityMaterialFieldAs(String qualityMaterial)
	{
		qualityMaterialField = allTextbox.get(5);
		qualityMaterialField.clear();
		qualityMaterialField.sendKeys(qualityMaterial);
	}


}
