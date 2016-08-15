package page.material.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.BasePage;

public class SpecialNormalDetailSearchMap extends BasePage{

	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(2) > td:nth-child(2) .z-select")
	public WebElement cbxOrderType;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(2) > td:nth-child(4) .z-select")
	public WebElement cbxStatus;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(3) > td:nth-child(2) .z-textbox")
	public WebElement txtCertificateNumber;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(3) > td:nth-child(4) .z-textbox")
	public WebElement txtMaterialName;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(4) > td:nth-child(2) .z-datebox-inp")
	public WebElement dprIssuedFrom;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(4) > td:nth-child(4) .z-datebox-inp")
	public WebElement dprIssuedTo;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(5) > td:nth-child(2) .z-datebox-inp")
	public WebElement dprCreatedFrom;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(5) > td:nth-child(4) .z-datebox-inp")
	public WebElement dprCreatedTo;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(6) > td:nth-child(2) .z-textbox")
	public WebElement txtOrderNumber;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(7) > td:nth-child(4) .z-select")
	public WebElement cbxSubstance;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(8) button:nth-child(1)")
	public WebElement btnSearch;
	
	@FindBy(css = ".z-groupbox-cnt > table > tbody > tr:nth-child(8) button:nth-child(2)")
	public WebElement btnClear;
	
	public SpecialNormalDetailSearchMap(WebDriver driver) {
		super(driver);
	}

}
