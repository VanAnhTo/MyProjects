package page.material.add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	protected void waitForElement(String selector)
	{
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(selector));
	}

}
