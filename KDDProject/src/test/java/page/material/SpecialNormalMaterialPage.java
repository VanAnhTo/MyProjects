package page.material;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import page.AddBasePage;
import util.AppLogger;
import util.PropertiesStore;

public class SpecialNormalMaterialPage extends AddBasePage {

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(2) div")
	private WebElement tdTenNguyenLieu;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(3) div span.z-label")
	private WebElement tdDonViTinh;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(4) div span.z-label")
	private WebElement tdSoLuong;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(5) div span.z-label")
	private WebElement tdTieuChuanChatLuong;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(6) div")
	private WebElement tdCongTySanXuat;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(7) div")
	private WebElement tdCongTyCungCap;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(8) div span.z-label")
	private WebElement tdSoDangKy;

	@FindBy(css = ".z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(9) div")
	private WebElement tdNongDoHamLuong;

	@FindBy(css = "div.z-chosenbox-pp div.z-chosenbox-sel div.z-chosenbox-option")
	private WebElement droplist;
	
	@FindBy(css = ".z-chosenbox")
	private List<WebElement> chosenbox;

	private String actualManufactural;
	private String actualProvider;
	private String actualSubstance;
	private int positionOfSubstance;
	private int positionOfSubstanceField;
	
	public SpecialNormalMaterialPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		positionOfFileNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfFileNumberField_SpecialOfNormalPage"));
		positionOfSignWhereField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfSignWhereField_SpecialOfNormalPage"));
		positionOfCopporateCheckBox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCopporateCheckBox_SpecialOfNormalPage"));

		positionOfMaterialNameFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfMaterialNameFeild_SpecialOfNormalPage"));
		positionOfContenMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfContenMaterialField_SpecialOfNormalPage"));
		positionOfAmountMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfAmountMaterialField_SpecialOfNormalPage"));
		positionOfQualityMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfQualityMaterialField_SpecialOfNormalPage"));
		positionOfUnitMaterialFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfUnitMaterialFeild_SpecialOfNormalPage"));

		positionOfProviderMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfProviderMaterialField_SpecialOfNormalPage"));
		positionOfProviderMaterialCombobox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfProviderMaterialCombobox_SpecialOfNormalPage"));

		positionOfManufacturalMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfManufacturalMaterialField_SpecialOfNormalPage"));
		positionOfManufacturalMaterialCombobox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfManufacturalMaterialCombobox_SpecialOfNormalPage"));

		positionOfContentrationFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfContentrationFeild_SpecialOfNormalPage"));
		positionOfRegistrationNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfRegistrationNumberFeild_SpecialOfNormalPage"));
		positionOfContentImportFeild = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfContentImportFeild_SpecialOfNormalPage"));

		positionOfCommitedCheckbox = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfCommitedCheckbox_SpecialOfNormalPage"));
		positionOfAddMaterialButton = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfAddMaterialButton_SpecialOfNormalPage"));
		positionOfaveListMaterialButton = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfaveListMaterialButton_SpecialOfNormalPage"));

		positionOfEditButton = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfEditButton_SpecialOfNormalPage"));
		
		positionOfSubstance = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfSubstance_SpecialOfNormalPage"));

		positionOfSubstanceField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfSubstanceField_SpecialOfNormalPage"));
	}

	public void saveMaterialWith(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.clickCopporateCheckBox();
		if (pageDetail.getFileNumber() != null) {
			this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		}
		if (pageDetail.getSignWhere() != null) {
			this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		}

		int i = 1;
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			if (materialDetail.getAmountMaterial() != null) {
				this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			}
			if (materialDetail.getContenMaterial() != null) {
				this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			}
			if (materialDetail.getMaterialName() != null) {
				this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			}
			if (materialDetail.getUnitMaterial() != null) {
				this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			}
			if (materialDetail.getRegistrationNumber() != null) {
				this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			}
			if (materialDetail.getContentImport() != null) {
				this.enterContentImportFeildAs(materialDetail.getContentImport());
			}
			if (materialDetail.getContentration() != null) {
				this.enterContentrationFeildAs(materialDetail.getContentration());
			}
			if (materialDetail.getQualityMateriall() != null) {
				this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			}
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();

			this.clickAddMaterialButton();
			waitForDataFillOnTableComplete(i);
			i++;
		}
		this.clickSaveListMaterialButton();

	}

	public void verifyEmptyMessage(PageDetail pageDetail) {
		if (validateEmptyField(pageDetail.getFileNumber())) {
			return;
		}
		if (validateEmptyField(pageDetail.getSignWhere())) {
			return;
		}
		int i = 1;
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			if (validateEmptyField(materialDetail.getAmountMaterial())) {
				return;
			}
			if (validateEmptyField(materialDetail.getContenMaterial())) {
				return;
			}
			if (validateEmptyField(materialDetail.getMaterialName())) {
				return;
			}
			i++;
		}
		waitForAlert();
	}

	private boolean validateEmptyField(String materialDetail) {
		if (materialDetail == null || materialDetail.equals("")) {
			waitForElement(".z-popup-cnt .z-errbox-center");
			verifyInvalidMessage("Trường bắt buộc nhập");
			return true;
		}
		return false;
	}

	public void verifyInvalidMessage() {
		waitForElement(".z-popup-cnt .z-errbox-center");
		verifyInvalidMessage("Trường bắt buộc nhập");
	}

	public void verifyErrorMessage(PageDetail pageDetail) {
		if (validateEmptyField(pageDetail.getFileNumber())) {
			return;
		}
		if (validateEmptyField(pageDetail.getSignWhere())) {
			return;
		}
		int i = 1;
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			if (validateEmptyField(materialDetail.getAmountMaterial())) {
				return;
			}
			if (validateEmptyField(materialDetail.getQualityMateriall())) {
				return;
			}
			if (validateEmptyField(materialDetail.getMaterialName())) {
				return;
			}
			if (validateEmptyField(materialDetail.getRegistrationNumber())) {
				return;
			}
			i++;
		}
		waitForAlert();

	}

	public void clickSaveOrder() {
		this.clickSaveListMaterialButton();
	}

	public void verifySuccessMessage(PageDetail pageDetail) {
		verifySuccessMessage("Lưu thông tin thành công");
		return;
	}

	public void clickSaveWithoutOrderNumber(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		this.clickSaveListMaterialButton();
	}

	public void clickSaveWithoutSignPlace(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		this.clickSaveListMaterialButton();
	}

	public void clickSaveWithoutMaterialDetais(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		this.clickSaveListMaterialButton();
	}

	public void clickAddWithoutMaterialName(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImport());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}
	}

	public void clickSaveWithoutContentMaterial(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImport());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}
	}

	public void clickSaveWithoutAmount(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImport());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}

	}

	public void clickSaveWithoutQuality(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImport());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.clickCommitedCheckbox();
			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();
			this.clickAddMaterialButton();
		}
	}

	public void verifyWarningMessage(PageDetail pageDetail) {
		verifyWarningMessage("Bạn phải nhập ít nhất 01 nguyên liệu");
		return;
	}

	public void verifyMaterialOnGrid(PageDetail pageDetail) {
		waitForDataFillOnTableComplete(1);
		verifyMaterialNameOnGrid(pageDetail);
		verifyUnitOnGrid(pageDetail);
		verifyAmountOnGrid(pageDetail);
		verifyQualityOnGrid(pageDetail);
		verifyRegistrationOnGrid(pageDetail);
		verifyContentOnGrid(pageDetail);
		verifyProviderOnGrid(pageDetail);
		verifyManufacturalOnGrid(pageDetail);
		
	}

	private void verifyMaterialNameOnGrid(PageDetail pageDetail) {
		
		String actualMaterialName =  pageDetail.getMaterialDetailList().get(0).getMaterialName()
				+ pageDetail.getMaterialDetailList().get(0).getContenMaterial();
		AppLogger.logMessage("actual result: " + actualMaterialName);
		String expectedMaterialName = getTenNguyenLieu();
		AppLogger.logMessage("expected result: " + expectedMaterialName);
		Assert.assertEquals(actualMaterialName, expectedMaterialName);
	}

	private void verifyContentOnGrid(PageDetail pageDetail) {
		String actualSubs = actualSubstance;
		String actualContent = actualSubs+" "+ pageDetail.getMaterialDetailList().get(0).getContentration() + " "
				+ pageDetail.getMaterialDetailList().get(0).getContentImport();
		AppLogger.logMessage("AAA actual result: " + actualContent);
		String expectedContent = getNongDoHamLuong();
		AppLogger.logMessage("AAA expected result: " + expectedContent);
		Assert.assertEquals(actualContent, expectedContent);
	}

	private void verifyRegistrationOnGrid(PageDetail pageDetail) {
		String actualRegistration = pageDetail.getMaterialDetailList().get(0).getRegistrationNumber();
		AppLogger.logMessage("actual result: " + actualRegistration);
		String expectedRegistration = getSoDangKy();
		AppLogger.logMessage("expected result: " + expectedRegistration);
		Assert.assertEquals(actualRegistration, expectedRegistration);
	}

	private void verifyQualityOnGrid(PageDetail pageDetail) {
		String actualQuality = pageDetail.getMaterialDetailList().get(0).getQualityMateriall();
		AppLogger.logMessage("actual result: " + actualQuality);
		String expectedQuality = getTieuChuanChatLuong();
		AppLogger.logMessage("expected result: " + expectedQuality);
		Assert.assertEquals(actualQuality, expectedQuality);
	}

	private void verifyAmountOnGrid(PageDetail pageDetail) {
		String actualAmount = pageDetail.getMaterialDetailList().get(0).getAmountMaterial();
		AppLogger.logMessage("actual result: " + actualAmount);
		String expectedAmount = getSoLuong();
		AppLogger.logMessage("expected result: " + expectedAmount);
		Assert.assertEquals(actualAmount, expectedAmount);
	}

	private void verifyUnitOnGrid(PageDetail pageDetail) {
		String actualUnit = pageDetail.getMaterialDetailList().get(0).getUnitMaterial();
		AppLogger.logMessage("actual result: " + actualUnit);
		String expectedUnit = getDonViTinh();
		AppLogger.logMessage("expected result: " + expectedUnit);
		Assert.assertEquals(actualUnit, expectedUnit);
	}

	private void verifyProviderOnGrid(PageDetail pageDetail) {
		String expectedProvider = getCongTyCungCap();
		String actual = actualProvider;
		AppLogger.logMessage("actual result: " + actualProvider);
		AppLogger.logMessage("expected result: " + expectedProvider);
		Assert.assertEquals(actual, expectedProvider);
	}

	private void verifyManufacturalOnGrid(PageDetail pageDetail) {
		String expectedManufactural = getCongTySanXuat();
		String actual = actualManufactural;
		AppLogger.logMessage("expected result manufactural: " + expectedManufactural);
		Assert.assertEquals(actual, expectedManufactural);
	}

	private String getNongDoHamLuong() {
		String temp = tdNongDoHamLuong.findElement(By.xpath(".//span[normalize-space()]")).getText();
		return replaceNewLine(temp);
	}

	private String getTenNguyenLieu() {
		String temp = tdTenNguyenLieu.findElement(By.xpath(".//span[normalize-space()]")).getText();
		return replaceNewLine(temp);
	}

	protected String getExcuteJavaScript() {
		String s = "var text = ''; "
				+ "text = document.querySelector('.z-listbox-body table tbody:nth-child(2) tr:nth-child(1) td:nth-child(2) span').innerHTML;  "
				+ "text.replace('\\n',''); " + "return text;";
		return (String) ((JavascriptExecutor) driver).executeScript(s);
	}

	private String getCongTyCungCap() {
		String temp = tdCongTyCungCap.findElement(By.xpath(".//span[normalize-space()]")).getText();
		// return temp.replaceAll("\\r\\n|\\r|\\n", "");
		return replaceNewLine(temp);
	}

	private String getCongTySanXuat() {
		return tdCongTySanXuat.getText();
	}

	private String getSoDangKy() {
		return tdSoDangKy.getText();
	}

	private String getTieuChuanChatLuong() {
		return tdTieuChuanChatLuong.getText();
	}

	private String getSoLuong() {
		return tdSoLuong.getText();
	}

	private String getDonViTinh() {
		return tdDonViTinh.getText();
	}

	public void clickAddOrderWithoutCheckbox(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		this.clickCopporateCheckBox();
		this.enterFileNumberFieldAs(pageDetail.getFileNumber());
		this.enterSignWhereFieldAs(pageDetail.getSignWhere());
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImport());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());

			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			this.chooseProviderMaterialCombobox();
			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			this.chooseManufacturalMaterialCombobox();

			this.clickAddMaterialButton();
		}
	}

	public void verifyWarningCheckboxRequireCheckCheckbox(PageDetail pageDetail) {
		verifyWarningMessage("Bạn phải chọn cam kết của doanh nghiệp");
		return;
	}

	public void clickAddOrderToGrid(PageDetail pageDetail) {
		waitForTextboxFeildAppear();
		for (MaterialDetail materialDetail : pageDetail.getMaterialDetailList()) {
			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
			this.enterRegistrationNumberFieldAs(materialDetail.getRegistrationNumber());
			this.enterContentImportFeildAs(materialDetail.getContentImport());
			this.enterContentrationFeildAs(materialDetail.getContentration());
			
			this.focusOnSubstanceField();
			this.waitForDropdown();
			this.getActualSubstance("3");
			this.chooseSubstanceDrodown("3");
			this.clickCommitedCheckbox();

			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			String a = this.randomIndex();
			this.getActualProvider(a);
			this.chooseProviderMaterialDrodown(a);

			this.focusManufacturalMaterialField();
			this.waitForDropdown();
			String i = this.randomIndex();
			this.getActualManufactural(i);
			this.chooseManufacturalMaterialCombobox(i);

			this.focusOnProviderMaterialField();
			this.waitForDropdown();
			String b = this.randomIndex();
			this.getActualProvider(b);
			this.chooseProviderMaterialDrodown(b);

			this.clickAddMaterialButton();
		}
	}

	protected void getActualProvider(String index) {
		this.waitForDropdown();
		String choosenSelector = ChoosenSelector.replace("%INDEX%", index);
		WebElement element = driver.findElements(By.cssSelector(choosenSelector)).get(2);
		actualProvider = (actualProvider == null ? "" : actualProvider) + "+ " + element.getText();
		AppLogger.logMessage("actualProvider: " + actualProvider);
	}

	protected void getActualManufactural(String index) {
		this.waitForDropdown();
		String choosenSelector = ChoosenSelector.replace("%INDEX%", index);
		WebElement element = driver.findElements(By.cssSelector(choosenSelector)).get(2);
		actualManufactural = (actualManufactural == null ? "" : actualManufactural) + "+ " + element.getText();
		AppLogger.logMessage("actualManufactural: " + actualManufactural);
	}
	
	protected void getActualSubstance(String index) {
		this.waitForDropdown();
		String choosenSelector = ChoosenSelector.replace("%INDEX%", index);
		WebElement element = driver.findElements(By.cssSelector(choosenSelector)).get(2);
		actualSubstance = (actualSubstance == null ? "" : actualSubstance) + element.getText();
		AppLogger.logMessage("actualSubstance: " + actualSubstance);
	}

	private String randomIndex() {
		Random rand = new Random();
		int index = rand.nextInt(15) + 1;
		AppLogger.logMessage("random index " + index);
		return Integer.toString(index);
	}

	public void clickEdit() {
		waitForDataFillOnTableComplete(1);
		this.clickImgEditButton();
		this.getProvider();
		this.getManufactural();
		AppLogger.logMessage("get provider: " + getProvider());
		AppLogger.logMessage("get provider: " + getManufactural());
	}

	public String getProvider() {
		return chosenbox.get(1).getText();
	}
	public String getManufactural() {
		return chosenbox.get(2).getText();
	}
	
	
	protected WebElement txtSubstance;
	
	@FindBy(css = ".z-chosenbox .z-chosenbox-inp")
	private List<WebElement> allChosenbox;
	
	private WebElement cbxHoatChat;
	
	public void chooseSubstanceDrodown(String index) {
		clickSelectFromDropdown(cbxHoatChat, positionOfSubstance, index);
	}
	public void focusOnSubstanceField() {
		clickOnChosenTextBox(allChosenbox, txtSubstance, positionOfSubstanceField);
	}

}
