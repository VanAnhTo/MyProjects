package pageObject;

import org.openqa.selenium.By;

public class ChangeSettingPage {
	public static By menuSettings = By.cssSelector("#menu-settings > a > div.wp-menu-name");
	public static By txtSiteTitle = By.id("blogname");
	public static By txtEmail = By.id("admin_email");
	public static By ckbMembership = By.id("users_can_register");
	public static By cmbTimeZone = By.id("timezone_string");
	public static By radioDateFormat = By.id("date_format_custom_radio");
	public static By radioTimeFormat = By.id("time_format_custom_radio");
	public static By cmbStartDayOfWeek = By.id("start_of_week");
	public static By cmbSiteLanguage = By.id("WPLANG");	
	public static By btnSubmit = By.id("submit");
	
	public static final String expectedMess = "Settings saved.";
	public static By actualMess = By.cssSelector("#setting-error-settings_updated > p > strong");
}
