package seleniumDigitestObject;

import org.openqa.selenium.By;

public class AddNewUserPage {
	public static By menuUser = By.cssSelector("#menu-users > a > div.wp-menu-name");	
	//menu add new user
	public static By addNewUser = By.cssSelector("#menu-users > ul > li:nth-child(3) > a");	
	//infor user
	public static By txtUserLogin = By.id("user_login");
	public static By txtEmail = By.id("email");
	public static By txtFirstName = By.id("first_name");
	public static By txtLastName = By.id("last_name");
	public static By txtUrl = By.id("url");
	//button show pass
	public static By btnShowPass = By.cssSelector("#createuser > table > tbody > tr.form-field.form-required.user-pass1-wrap > td > button");	
	public static By txtPass = By.id("pass1-text");
	public static By ckbWeak = By.name("pw_weak");
	//public static By ckbNotification = By.name("send_user_notification");
	public static By cbRole = By.id("role");	
	public static By btnCreatUser = By.id("createusersub");
	
	public static By actualMess = By.cssSelector("#message > p");
	
	public static String expectedMess ="New user created. Edit user";
}
