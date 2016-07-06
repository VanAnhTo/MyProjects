package pageObject;

import org.openqa.selenium.By;

public class ObjSigupDigitestForum {
	public static By btnSignup = By.cssSelector("#SignupButton a");
	public static By cmbCreateAccount = By.id("ctrl_not_registered");
	public static By btnSubSigup = By.cssSelector("#login > div > dl.ctrlUnit.submitUnit > dd > input");
	
	public static By txtName = By.cssSelector(".xenForm.AutoValidator .ctrlUnit input.textCtrl"); //1
	public static By txtEmail = By.cssSelector(".xenForm.AutoValidator .ctrlUnit input.textCtrl"); //2
	public static By txtPassWord = By.cssSelector(".xenForm.AutoValidator .ctrlUnit input.textCtrl"); //3
	public static By txtRePassWord = By.cssSelector(".xenForm.AutoValidator .ctrlUnit input.textCtrl"); //4
	public static By radioGender = By.cssSelector("li:nth-child(2) > label:nth-child(1) > input:nth-child(1)");
	public static By cmbMonth = By.name("dob_month");
	public static By txtDay= By.name("dob_day");
	public static By txtYear = By.name("dob_year");
	
	public static By ckbAgree = By.name("agree");
	public static By btnSubmit = By.id("SubmitButton");
	
}	
