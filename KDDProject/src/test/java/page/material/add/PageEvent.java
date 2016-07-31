package page.material.add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageEvent extends PageBase {

	WebDriver driver;

	public PageEvent(WebDriver driver) {
		this.driver = driver;
		
	}
	
	protected void waitForDataFillOnTableComplete(int i) {
		waitForElement(".z-listbox-body table tbody:nth-child(2) tr:nth-child(" + i + ")");
	}

	protected void waitForTextboxFeildAppear() {
		waitForElement(".z-groupbox-cnt .z-textbox");
	}
	
	protected void waitForAlert() {
		waitForElement(".z-notification");
	}
	
	protected void waitForDropdown() {
		waitForElement(".z-chosenbox-pp.z-chosenbox-pp-hidden");
	}

	protected void waitForElement(String selector)
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(selector));
	}
	
	protected void waitForLoad()
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForLoad();
	}
	
	protected void waitForReady()
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForReady();
	}
	
	protected void waitForHidden(String selector)
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(selector));
	}
	
	protected void waitForJSandJQueryToLoad()
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForJSandJQueryToLoad();
	}

}
