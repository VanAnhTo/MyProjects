package pageObject;

import org.openqa.selenium.By;

public class ObjLoginDigitestForum {
	public static By linkTextLogin = By.cssSelector("a.concealed.noOutline");
	public static By txtEmailorName = By.id("LoginControl");
	public static By txtPassWord = By.id("ctrl_password");
	public static By btnLogin = By.cssSelector("dl.submitUnit:nth-child(3) > dd:nth-child(2) > input:nth-child(1)");
	
	public static final String expectedMess = "Inbox";
	public static By actualMess = By.linkText("Inbox");
}
