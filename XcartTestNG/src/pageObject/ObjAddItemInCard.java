package pageObject;

import org.openqa.selenium.By;

public class ObjAddItemInCard {
	public static final By txtSearch = By.id("substring-default");
	public static final By items = By.cssSelector(".product-cell:nth-child(4) .product-name a");
	public static final By btnAddToCart = By.cssSelector(".btn.regular-button.regular-main-button.add2cart.submit");
	public static final By linktextCart = By.linkText("your cart");
	public static final By linktextEmptyCart = By.linkText("Empty your cart");
	
	public static final String expectedMessCart ="Coffee Cup Power Inverter V2.0" ;
	
}
