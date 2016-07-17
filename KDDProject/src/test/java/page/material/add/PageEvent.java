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
	
	public void saveMaterialWith(PageDetail new2ddDetails) {
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
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImportl());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterQuyCachDongGoiAs(materialDetail.getQuyCachDongGoi());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			//waitUtilItemOnComboboxAppear();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			//waitUtilItemOnComboboxAppear();
			this.chooseManufacturalMaterialCombobox();
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
	/*protected void waitUtilItemOnComboboxAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(
				By.cssSelector(".z-chosenbox-pp.z-chosenbox-pp-hidden       ")));
	}*/

	protected void waitForTextboxFeildAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector(".z-groupbox-cnt .z-textbox")));
	}
	
	protected void waitForAlert() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".z-notification")));
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
