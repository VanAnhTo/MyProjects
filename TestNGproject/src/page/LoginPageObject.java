package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestUser.LoginDetails;



public class LoginPageObject {
	WebDriver driver;
	
	@FindBy(id = "user_login")
    private WebElement usernameField;

    @FindBy(id = "user_pass")
    private WebElement passwordField;

    @FindBy(id = "wp-submit")
    private WebElement loginButton;

	
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
   

    public void enterUserName(String username) {
    	usernameField.clear();
    	usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public HomePageObject login() {
    	loginButton.click();
        return new HomePageObject(driver);
    }


	public HomePageObject login(LoginDetails loginDetails) {
	        this.enterUserName(loginDetails.getUsername());
	        this.enterPassword(loginDetails.getPassword());
	        HomePageObject homePageObject = this.login();
	        return homePageObject;
	}

}
