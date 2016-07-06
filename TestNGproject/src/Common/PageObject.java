package Common;

import org.openqa.selenium.By;

public class PageObject {
	public static class LoginPage
	{
		public static By txtUsername = By.id("user_login");
		public static By txtPass = By.id("user_pass");
		public static By btnSubmit = By.id("wp-submit");
	}
	public static class  PluginPage
	{
		//menu plugin
		public static By menuPlugin = By.xpath(".//*[@id='menu-plugins']/a/div[3]");
		//add new plugin
		public static By addNewPlugin = By.xpath(".//*[@id='menu-plugins']/ul/li[3]/a");
		//link text installer
		public static By linkActivePlugin = By.cssSelector(".wrap > p:nth-child(5) > a:nth-child(1)");		
		//link text deactive plugin
		public static By linkDeactivePlugin = By.cssSelector("#advanced-custom-fields > td.plugin-title.column-primary > div > span.deactivate > a");
		
	}
	public static class UserPage
	{
		//menu user
		public static By menuUser = By.cssSelector("#menu-users > a > div.wp-menu-name");	
		//menu add new user
		public static By addNewUser = By.cssSelector("#menu-users > ul > li:nth-child(3) > a");	
		//infor user
		public static By txtUserLogin = By.id("user_login");
		public static By txtEmail = By.id("user_pass");
		public static By txtFirstName = By.id("first_name");
		public static By txtLastName = By.id("last_name");
		public static By txtUrl = By.id("url");
		//button show pass
		public static By btnShowPass = By.cssSelector("#createuser > table > tbody > tr.form-field.form-required.user-pass1-wrap > td > button");	
		public static By txtPass = By.id("pass1-text");
		public static By ckbWeak = By.name("pw_weak");
		public static By ckbNotification = By.name("send_user_notification");
		public static By cbRole = By.cssSelector("#menu-users > ul > li:nth-child(3) > a");	
		public static By btnCreat = By.id("createusersub");
		
		public static By actualMess = By.cssSelector("#message > p");	
		
	}
}
