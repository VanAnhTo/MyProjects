package pageObject;

import org.openqa.selenium.By;

public class ObjSign {
	public static By txtEmail = By.id("login");
	public static By txtPass = By.id("password");
	public static By txtConfirmPass = By.id("password-conf");
	public static By btnCreat = By.cssSelector(".model-form-buttons .btn.regular-main-button.submit.btn-warning");
	
	//1
	public static final String expectedTitle ="Address book";
	public static final String expectedMessSuccess= "The data have been save successfully";
	public static By actualMessSuccess = By.cssSelector("#status-messages > ul > li");
	//2
	public static final String expectedMessInvalidEmail= "Invalid email address";
	public static By actualMessInvalidEmail = By.cssSelector("li.input.input-text-email.first > div.table-value.login-value > span > p");
	//3
	public static final String expectedMessInvalidConPass= "Error:Personal info: Password and its confirmation do not match";
	public static By actualMessInvalidConPass = By.cssSelector("#status-messages > ul > li");
	//4
	public static final String expectedMessWithoutEmail = "This field is required";
	public static By actualMessWithoutEmail = By.cssSelector("li.input.input-text-email.first > div.table-value.login-value > span > p");
	//
	public static final String expectedMessWithoutPass = "This field is required";
	public static By actualMessWithoutPass = By.cssSelector("li.input.input-password.even > div.table-value.password-value > span > p");
	//
	public static final String expectedMessWithoutConfPass ="This field is required";
	public static By actualMessWithoutConfPass = By.cssSelector("ul > li.input.input-password.last > div.table-value.password-conf-value > span > p");
	//7
	public static final String expectedMessExistEmail = "Error:This email address is already in use by another user.";
	public static By actualMessExistEmail = By.cssSelector("#status-messages > ul > li");
}

