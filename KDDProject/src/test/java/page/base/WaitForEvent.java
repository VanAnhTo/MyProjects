package page.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.material.add.MaterialPageBase;

public class WaitForEvent extends MaterialPageBase {

	protected static WebDriver driver;

	public WaitForEvent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForDataFillOnTableComplete(int i) {
		waitForElement(".z-listbox-body table tbody:nth-child(2) tr:nth-child(" + i + ")");
	}

	public void waitForTextboxFeildAppear() {
		waitForElement(".z-groupbox-cnt .z-textbox");
	}

	public void waitForAlert() {
		waitForElement(".z-notification");
	}

	public void waitForDropdown() {
		waitForElement(".z-chosenbox-pp.z-chosenbox-pp-hidden");
	}

	public static void waitForElement(String selector) {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(selector));
	}

	public void waitForLoad() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForLoad();
	}

	public void waitForReady() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForReady();
	}

	public void waitForHidden(String selector) {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(selector));
	}

	public static void waitForJSandJQueryToLoad() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForJSandJQueryToLoad();
	}
	
}
