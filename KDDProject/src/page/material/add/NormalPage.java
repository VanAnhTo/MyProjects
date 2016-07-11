package page.material.add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.detail.material.PageDetail;
import domain.detail.material.MaterialDetail;

public class NormalPage extends PageEvent {

	WebDriver driver;
	
	public NormalPage(WebDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
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
	

	@Override
	public void Run() {
		// TODO Auto-generated method stub
		
	}

}
