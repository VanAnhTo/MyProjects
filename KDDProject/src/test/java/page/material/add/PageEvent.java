package page.material.add;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public boolean isThisDateValid(String dateToValidate) {

		if (dateToValidate == "") {
			return true;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

}
