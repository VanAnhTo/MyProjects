package pageObject;

import org.openqa.selenium.By;

public class LoginPage {
	public static By txtUsername = By.id("user_login");
	public static By txtPassword = By.id("user_pass");
	public static By btnLogin = By.id("wp-submit");
	
	public static By imgLogout = By.xpath(".//*[@id='wp-admin-bar-my-account']/a/img");
	public static By linkLogout = By.linkText("Log Out");
}
