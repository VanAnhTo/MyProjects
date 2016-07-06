package pageObject;

import org.openqa.selenium.By;

public class ObjLogin {
	public static By txtUserName = By.cssSelector(" .bginput input[type=text]");
	public static By txtPassWord = By.cssSelector(".bginput input[type=password]");
	public static By btnLogin = By.cssSelector(".btn-login button:nth-child(1)");
}
