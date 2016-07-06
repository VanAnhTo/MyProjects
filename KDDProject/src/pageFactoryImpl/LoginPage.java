package pageFactoryImpl;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.LoginDetails;


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
	    }

}

