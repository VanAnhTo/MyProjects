package page.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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


	public void goToCreate2ddPage()
	{
		clickMenuCreateNL();
		waitForLabelToAppear();
		clickLabelCreat2dd();
		waitForTabLableToAppear();
	}
	
	public void goToCreate2aPage()
	{
		clickMenuCreateNL();
		waitForLabelToAppear();
		clickLabelCreat2a();
		waitForTabLableToAppear();
	}

	private void waitForTabLableToAppear() {
		waitForElement(".container.z-div .z-div");	
	}

	private void waitForLabelToAppear() {
		waitForElement(".container.z-div .z-div");
	}
	
	private void waitForElement(String selector)
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(selector));
	}



}
