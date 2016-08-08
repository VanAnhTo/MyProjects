package page.material.add;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import domain.detail.material.SearchDetail;
import page.base.WaitForEvent;
import page.base.SearchPageBase;
import util.PropertiesStore;
import util.ValidatedDatetime;

public class MaterialSearchPage extends SearchPageBase {
	WebDriver driver;
	// Search

	/*@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-select")
	private List<WebElement> comboboxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-textbox")
	private List<WebElement> textBoxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-datebox-inp")
	private List<WebElement> dateBoxes;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .z-datebox-btn")
	private List<WebElement> datePicker;

	@CacheLookup
	@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	private List<WebElement> buttons;

	@FindBy(css = ".z-popup-cnt .z-errbox-center")
	private WebElement alertInvalid;

	@CacheLookup
	@FindBy(css = ".z-listbox-empty-body")
	private WebElement tbdEmpty;

	@CacheLookup
	@FindBy(css = ".z-listbox-empty-body tr td")
	private WebElement tdMessage;

	@FindBy(css = ".z-notification.z-notification-warning div div")
	private WebElement divNotification;*/

	

/*	protected int positionOfOrderTypeField;
	protected int positionOfStatusField;
	protected int positionOfCertificateNumberField;
	protected int positionOfMaterialNameField;
	protected int positionOfIssuedDateFromField;
	protected int positionOfIssuedDateToField;
	protected int positionOfCreatedDateFromField;
	protected int positionOfCreatedDateToField;
	protected int positionOfOrderNumberField;

	protected int positionOfSubstanceField;

	protected int positionOfSearchButton;
	protected int positionOfClearButton;

	private String expectedErrorInDatePicker;
	private String dateFormat;*/

	public MaterialSearchPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		positionOfOrderTypeField = Integer.parseInt(PropertiesStore.getProperty("PositionOfOrderTyPeField"));
		positionOfStatusField = Integer.parseInt(PropertiesStore.getProperty("PositionOfStatusField"));
		positionOfCertificateNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCertificateNumberField"));
		positionOfMaterialNameField = Integer.parseInt(PropertiesStore.getProperty("PositionOfMaterialNameField"));
		positionOfIssuedDateFromField = Integer.parseInt(PropertiesStore.getProperty("PositionOfIssuedDateFromField"));
		positionOfIssuedDateToField = Integer.parseInt(PropertiesStore.getProperty("PositionOfIssuedDateToField"));
		positionOfCreatedDateFromField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCreatedDateFromField"));
		positionOfCreatedDateToField = Integer.parseInt(PropertiesStore.getProperty("PositionOfCreatedDateToField"));
		positionOfOrderNumberField = Integer.parseInt(PropertiesStore.getProperty("PositionOfOrderNumberField"));

		positionOfSubstanceField = Integer.parseInt(PropertiesStore.getProperty("PositionOfSubstanceField"));

		positionOfSearchButton = Integer.parseInt(PropertiesStore.getProperty("PositionOfSearchButton"));
		positionOfClearButton = Integer.parseInt(PropertiesStore.getProperty("PositionOfClearButton"));

		expectedErrorInDatePicker = PropertiesStore.getProperty("ExpectedErrorInDatePicker");

		dateFormat = PropertiesStore.getProperty("DateFormat");

	}

	public void searchOrderSpecialOfNormal(SearchDetail searchDetail) {
		/*((JavascriptExecutor) driver)
		.executeScript("document.getElementsByClassName(\"z-textbox\")[2].setAttribute('maxlength','60');");*/
		
		int orderType = MaterialEnum.OrderTypeEnum.valueOf(searchDetail.getOrderType()).value;
		this.selectOrderType(orderType);
		this.selectStatus();
		this.selectSubstance();
		this.enterCertificateNumberFieldAs(searchDetail.getCertificateNumber());
		this.enterMaterialNameFieldAs(searchDetail.getMaterialName());
		this.enterOrderNumberFieldAs(searchDetail.getOrderNumber());
		this.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		this.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		this.enterIssuedDateFromFieldAs(searchDetail.getIssuedDateFrom());
		this.enterIssuedDateToFieldAs(searchDetail.getIssuedDateTo());
		this.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		this.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		this.enterIssuedDateFromFieldAs(searchDetail.getIssuedDateFrom());
		this.enterIssuedDateToFieldAs(searchDetail.getIssuedDateTo());
		this.clickSearchButton();
		if (isValidInput(searchDetail)) {
			WaitForEvent.waitForJSandJQueryToLoad();
		}
	}

}
