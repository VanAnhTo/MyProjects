package page.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.detail.account.LoginDetails;

public class LoginPage {
	WebDriver driver;

	@FindBy(css = " .bginput input[type=text]")
	private WebElement usernameField;

	@FindBy(css = ".bginput input[type=password]")
	private WebElement passwordFiel;

	@FindBy(css = ".btn-login button:nth-child(1)")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsernameAs(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public void enterPasswordAs(String password) {
		passwordFiel.clear();
		passwordFiel.sendKeys(password);
	}

	public void loginToMainPage() {
		loginButton.click();
	}

	public void loginToMainPage(LoginDetails loginDetails) {
		this.enterUsernameAs(loginDetails.getUsername());
		this.enterPasswordAs(loginDetails.getPassword());
		loginButton.click();
		waitForHomePageAppear();

	}

	private void waitForHomePageAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(visibilityOfElementLocated(By.cssSelector("#tabContent .group:nth-child(1)")));
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
