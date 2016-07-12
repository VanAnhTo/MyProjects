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

public class PageEvent extends PageBase {

	WebDriver driver;

	public PageEvent(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void save2ddWith(PageDetail new2ddDetails) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
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
			
			this.enterQuyCachDongGoiFieldAs(materialDetail.getQuyCachDongGoi());
			
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
			waitForDataFillOnTableComplete(i);
			i++;
		}
		this.clickSaveListMaterialButton();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".z-notification")));
	}
	
	protected void waitForDataFillOnTableComplete(int i) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(
				By.cssSelector(".z-listbox-body table tbody:nth-child(2) tr:nth-child(" + i + ")")));
	}

	protected void waitForTextboxFeildAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector(".z-groupbox-cnt .z-textbox")));
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

	@Override
	public void enterFileNumberFieldAs(String fileNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterQuyCachDongGoiFieldAs(String quyCachDongGoi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterAmountMaterialFieldAs(String amountMaterial) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterQualityMaterialFieldAs(String qualityMaterial) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusOnProviderMaterialField() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void chooseProviderMaterialCombobox() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusManufacturalMaterialField() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void choosemanufacturalMaterialCombobox() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enterRegistrationNumberFeildAs(String registrationNumner) {
		// TODO Auto-generated method stub
		
	}
}
