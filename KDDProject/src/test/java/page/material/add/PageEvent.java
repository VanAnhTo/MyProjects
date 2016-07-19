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
