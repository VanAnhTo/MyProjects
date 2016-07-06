package pageObject;

import org.openqa.selenium.By;

public class ObjContact {
	public static By txtYourName = By.id("name");
	public static By txtYourMail = By.id("email");
	public static By txtSubject = By.id("subject");
	public static By txtMessage = By.id("message");
	public static By btbSend = By.cssSelector(".btn.regular-button.submit");
}
