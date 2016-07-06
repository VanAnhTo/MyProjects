package pageObject;

import org.openqa.selenium.By;

public class ObjLogin {
	
	public static By linkLogin = By.cssSelector("#header-bar > ul > li.account-link-1.first > a");
	
	
	public static By txtEmail = By.id("login-email");
	public static By txtPass = By.id("login-password");
	public static By btnSignIn = By.cssSelector("table > tbody > tr:nth-child(3) > td:nth-child(2) > button > span");
	
	public static By linkLogOut = By.cssSelector("#header-bar > ul > li.account-link-1.last > a");
	public static By linkForgotPass = By.linkText("Forgot password?");
	
	
	
	//success
	public static final String expectedTitle = "Catalog";
	//invalid email	
	public static final String expectedMessInvalidEmail = "Invalid email address";
	public static By actualMessInvalidEmail = By.cssSelector(".error");
	//without password
	public static final String expectedMessWithoutPass = "This field is required";
	public static By actualMessWithoutPass = By.cssSelector("table > tbody > tr:nth-child(2) > td.password-field.field > div > span > p");
	//incorrect email
	public static final String expectedMessIncorrEmail ="Invalid login or password";
	public static By actualMessIncorrEmail = By.cssSelector("table > tbody > tr:nth-child(3) > td:nth-child(2) > div");
	
	//invalid password
	public static final String expectedMessInvalidPass ="Invalid login or password";
	public static By actualMessInvalidPass = By.cssSelector("table > tbody > tr:nth-child(3) > td:nth-child(2) > div");
	
	//without email
	public static final String expectedMessWithoutEmail ="This field is required";
	public static By actualMessWithoutEmail = By.cssSelector("table > tbody > tr:nth-child(1) > td.email-field.field > div > span > p");
	
	//forgot password
	public static final String expectMessForgotPass= "Back to Login form";
	public static By actualMessForgotPass = By.linkText("Back to Login form");
}
