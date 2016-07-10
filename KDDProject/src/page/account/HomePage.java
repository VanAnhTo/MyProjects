package page.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	@FindBy(css = "#tabContent .group:nth-child(1)")
	private WebElement menuCreateNL;

	@FindBy(css = ".container.z-div .z-div span")
	private List<WebElement> allLabel;

	private WebElement labelCreate2dd;
	
	private WebElement labelCreate2a;

	public void clickMenuCreateNL() {
		menuCreateNL.click();
	}

	public void clickLabelCreat2dd() {
		labelCreate2dd = allLabel.get(1);
		labelCreate2dd.click();
	}
	
	public void clickLabelCreat2a() {
		labelCreate2a = allLabel.get(0);
		labelCreate2a.click();
	}


	public void goToCreate2ddPage() throws InterruptedException
	{
		clickMenuCreateNL();
		waitForLabelToAppear();
		clickLabelCreat2dd();
		waitForTabLableToAppear();
	}
	
	public void goToCreate2aPage() throws InterruptedException
	{
		clickMenuCreateNL();
		waitForLabelToAppear();
		clickLabelCreat2a();
		waitForTabLableToAppear();
	}

	private void waitForTabLableToAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector(".container.z-div .z-div")));	
	}

	private void waitForLabelToAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector(".container.z-div .z-div")));
	}
	
	/*private void waitForMenuOnHomePageAppear()
	{
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector("#tabContent .group:nth-child(1)")));
	}
*/
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
