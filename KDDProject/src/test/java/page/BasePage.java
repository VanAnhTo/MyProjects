package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import util.PropertiesStore;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		try {
			dateFormat = PropertiesStore.getProperty("DateFormat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FindBy(css = ".z-notification.z-notification-warning div div")
	protected WebElement divNotification;

	@FindBy(css = ".z-popup-cnt .z-errbox-center")
	private WebElement divErrorBox;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-select")
	protected List<WebElement> comboboxes;


	protected String getErrorAlertBox() {
		return divErrorBox.getText();
	}

	protected String dateFormat;
	
	protected void waitForDataFillOnTableComplete(int i) {
		waitForElement(".z-listbox-body table tbody:nth-child(2) tr:nth-child(" + i + ")");
	}

	protected void excuteJavaScript(String script) {
		((JavascriptExecutor) driver).executeScript(script);
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

	protected void waitForElement(String selector) {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(selector));
	}

	protected void waitForLoad() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForLoad();
	}

	protected void waitForReady() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForReady();
	}

	protected void waitForHidden(String selector) {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(selector));
	}

	protected void waitForJSandJQueryToLoad() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.waitForJSandJQueryToLoad();
	}

	protected void enterTextBoxField(List<WebElement> allTextbox, WebElement textBox, int position, String content) {
		textBox = allTextbox.get(position);
		textBox.clear();
		textBox.sendKeys(content);
	}

	protected void clickCheckbox(List<WebElement> allCheckbox, WebElement checkBox, int position) {
		checkBox = allCheckbox.get(position);
		checkBox.click();
	}

	protected void enterComboboxFeild(List<WebElement> allCombobox, WebElement comboBox, int position, String content) {
		comboBox = allCombobox.get(position);
		comboBox.clear();
		comboBox.sendKeys(content);
	}

	protected void clickButton(List<WebElement> allButton, WebElement button, int position) {
		button = allButton.get(position);
		button.click();
	}

	protected void clickOnChosenTextBox(List<WebElement> allChosenbox, WebElement chosenTextBox, int position) {
		chosenTextBox = allChosenbox.get(position);
		chosenTextBox.click();
	}
}
