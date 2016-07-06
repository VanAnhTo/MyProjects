package pageFactoryImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.AddNew2ddDetails;
import domain.MaterialDetail;

public class AddNew2ddPage extends AddNewBase {
	WebDriver driver;

    public AddNew2ddPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void save2ddWith(AddNew2ddDetails new2ddDetails)
    {
    	waitForTextboxFeildAppear();
    	this.clickCopporateCheckBox(new2ddDetails.getMucdich);
    	this.enterFileNumberFieldAs(new2ddDetails.getFileNumber());
    	this.enterSignWhereFieldAs(new2ddDetails.getSignWhere());
    	
    	int i =0;
    	for(MaterialDetail materialDetail : new2ddDetails.getMaterialDetailList()){
        	
    		this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
        	this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
        	this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
        	this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
        	this.enterRegistrationNumberFeildAs(materialDetail.getRegistrationNumber());
        	this.enterContentImportFieldFeildAs(materialDetail.getContentImportl());
        	this.enterContentrationFieldAs(materialDetail.getContentration());
        	this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
        	this.clickCommitedCheckbox();
        	this.focusOnProviderMaterialField();
        	this.chooseProviderMaterialCombobox();
        	this.focusManufacturalMaterialField();
        	this.choosemanufacturalMaterialCombobox();
        	this.clickAddMaterialButton();
        	i++;
        	waitForDataFillComplete(i);
    	}
    	waitForDataFillComplete();
    	this.clickSaveListMaterialButton();  	
    }
    
    private void waitForDataFillComplete(int i) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector(".button. tr:nthchild(" + i + ")")));
	}
    
    private void waitForTextboxFeildAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.t(".z-groupbox-cnt .z-textbox")));
	}


    private ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement toReturn = driver.findElement(locator);
				if (toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
		};
	}
    
}
