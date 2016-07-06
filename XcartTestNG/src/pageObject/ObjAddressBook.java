package pageObject;

import org.openqa.selenium.By;

public class ObjAddressBook {
	
	public static By menuMyAccount = By.cssSelector("div.navbar:nth-child(3) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)");
	public static By tabAddressBook = By.cssSelector("li.tab:nth-child(2) > a:nth-child(1)");
	public static By btnAdddressBook = By.cssSelector(".popup-button.add-address");
	
	//popup address detail
	public static By txtFisrtName = By.id("-firstname");
	public static By txtLastName = By.id("-lastname");
	public static By txtAddress = By.id("-street");
	public static By txtCity = By.id("-city");
	
	public static By comboCountry = By.id("-country-code");
	public static By txtState = By.id("-custom-state");
	public static By txtZipcode = By.id("-zipcode");
	public static By txtPhone = By.id("-phone");
	
	public static By btnSubmit = By.cssSelector(".regular-main-button.action.submit");
	
	//public static final String expectMess = "Luc Nam Bac Giang";
	public static By ActualMess= By.cssSelector(".address-book:nth-last-child(2) .address-text-cell.address-text-phone .address-text-value");
	

}
