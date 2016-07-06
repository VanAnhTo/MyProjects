package pageFactoryImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNew2ddPage {
	WebDriver driver;

    @FindBy(css = "#tabContent .group:nth-child(1)")
    private WebElement menuCreateNL;

    @FindBy(css = ".z-div .z-label")
    private WebElement labelCreate2dd;

    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    private WebElement fileNumberField;

    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    private WebElement signWhereField;

    @FindBy(css = ".z-checkbox input")
    private WebElement copporateCheckBox;

    @FindBy(css = ".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge")
    private WebElement materialNameField;
    
    //ham luong dang bao che
    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    private WebElement contenMaterialField;
    
    //Don vi tinh
    @FindBy(css = ".z-combobox .z-combobox-inp")
    private WebElement unitMaterialField;
    
    //So luong
    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    private WebElement amountMaterialField;
    
    //TCCL
    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    private WebElement qualityMaterialField;
    
    //Nha cung cap
    @FindBy(css = ".z-chosenbox .z-chosenbox-inp")
    private WebElement providerMaterialField;
    
    @FindBy(css = ".z-chosenbox-sel div:nth-child(1)")
    private WebElement providerMaterialCombobox;
    
    //Nha san xuat
    @FindBy(css = ".z-chosenbox .z-chosenbox-inp")
    private WebElement manufacturalMaterialField;
    
    @FindBy(css = ".z-chosenbox-sel div:nth-child(2)")
    private WebElement manufacturalMaterialCombobox;
    
    //THong tin thuoc duoc san xuat tu nguyen lieu duoc nhap
    //SDK
    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    private WebElement registrationNumnerFeild; 
    //Nong do:
    @FindBy(css = "z-groupbox-cnt .z-textbox")
    private WebElement contentrationField;

    //ham luong
    @FindBy(css = "z-groupbox-cnt .z-textbox")
    private WebElement contentImportField;
    
    //check box cam ket
    @FindBy(css = ".z-checkbox input")
    private WebElement commitedCheckbox;
    
    //button them nguyen lieu
    @FindBy(css = ".z-groupbox-cnt .button.z-button-os")
    private WebElement addMaterialButton;

    //button luu don hang
    @FindBy(css = ".z-window-embedded-cnt-noborder .button.z-button-os")
    private WebElement saveListMaterialButton;
    
    
    public AddNew2ddPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuCreateNL() {
        menuCreateNL.click();
    }
    
    public void clickLabelCreat2dd() {
        labelCreate2dd.click();
    }

    public void enterFileNumberFieldAs(String fileNumber) {
        fileNumberField.clear();
        fileNumberField.sendKeys(fileNumber);
    }
    public void enterSignWhereFieldAs(String signWhere) {
        signWhereField.clear();
        signWhereField.sendKeys(signWhere);
    }
    
    public void clickCopporateCheckBox() {
        commitedCheckbox.click();
    }
    
    public void enterMaterialNameFieldAs(String materialName){
    	materialNameField.clear();
    	materialNameField.sendKeys(materialName);
    }
    
    public void enterContenMaterialFieldAs(String contentMaterial){
    	contenMaterialField.clear();
    	contenMaterialField.sendKeys(contentMaterial);
    }
    
    public void enterUnitMaterialFieldAs(String unitMaterial){
    	unitMaterialField.clear();
    	unitMaterialField.sendKeys(unitMaterial);
    }
    
    public void enterAmountMaterialFieldAs(String amountMaterial){
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
    
    public void enterQualityMaterialFieldAs(String qualityMaterial){
    	qualityMaterialField.clear();
    	qualityMaterialField.sendKeys(qualityMaterial);
    }
    public void chooseProviderMaterialFieldAs(){
    	providerMaterialField.click();
    	amountMaterialField.sendKeys(amountMaterial);
    }
    public void enterAmountMaterialFieldAs(String amountMaterial){
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
    public void enterAmountMaterialFieldAs(String amountMaterial){
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
    public void enterAmountMaterialFieldAs(String amountMaterial){
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
    public void enterAmountMaterialFieldAs(String amountMaterial){
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
    
    
    
}
