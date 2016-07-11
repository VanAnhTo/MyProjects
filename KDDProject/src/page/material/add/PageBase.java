package page.material.add;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public abstract class PageBase {
	
	// Thuoc tinh
	//===============================================
    //@FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected WebElement fileNumberField;

    //@FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected WebElement signWhereField;

    //@FindBy(css = ".z-checkbox input")
    protected WebElement copporateCheckBox;

   // @FindBy(css = ".z-groupbox-cnt .z-combobox-inp.z-combobox-right-edge")
    protected WebElement materialNameField;
    
    //ham luong dang bao che
   // @FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected WebElement contenMaterialField;
    
    //Don vi tinh
    //@FindBy(css = ".z-combobox .z-combobox-inp")
    protected WebElement unitMaterialField;
    
    //So luong
    //@FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected WebElement amountMaterialField;
    
    //TCCL
    //@FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected WebElement qualityMaterialField;
    
    //Nha cung cap
   //@FindBy(css = ".z-chosenbox .z-chosenbox-inp")
    protected WebElement providerMaterialField;
    
    //@FindBy(css = ".z-chosenbox-sel div:nth-child(1)")
    protected WebElement providerMaterialCombobox;
    
    //Nha san xuat
    //@FindBy(css = ".z-chosenbox .z-chosenbox-inp")
    protected WebElement manufacturalMaterialField;
    
    //@FindBy(css = ".z-chosenbox-sel div:nth-child(2)")
    protected WebElement manufacturalMaterialCombobox;
    
    //THong tin thuoc duoc san xuat tu nguyen lieu duoc nhap
    //SDK
    //@FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected WebElement registrationNumberFeild; 
    //Nong do:
    //@FindBy(css = "z-groupbox-cnt .z-textbox")
    protected WebElement contentrationField;

    //ham luong
    //@FindBy(css = "z-groupbox-cnt .z-textbox")
    protected WebElement contentImportField;
    
    //check box cam ket
    //@FindBy(css = ".z-checkbox input")
    protected WebElement commitedCheckbox;
    
    //button them nguyen lieu
    //@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
    protected WebElement addMaterialButton;

    //button luu don hang
    //@FindBy(css = ".z-window-embedded-cnt-noborder .button.z-button-os")
    protected WebElement saveListMaterialButton;

    
    //cung cap
    @FindBy(css = ".z-chosenbox-sel div:nth-child(1)")
    protected List<WebElement> allChosenComboboxChild1;
    //san xuat
    @FindBy(css = ".z-chosenbox-sel div:nth-child(2)")
    protected List<WebElement> allChosenComboboxChild2;
    
    @FindBy(css = ".z-groupbox-cnt .z-textbox")
    protected List<WebElement> allTextbox;
    
    @FindBy(css = ".z-checkbox input")
    protected List<WebElement> allCheckbox;
    
    @FindBy(css = ".z-combobox .z-combobox-inp")
    protected List<WebElement> allCombobox;   
    
    @FindBy(css = ".z-chosenbox .z-chosenbox-inp")
    protected List<WebElement> allChosenbox;
    
    @FindBy(css = ".button.z-button-os")
    protected List<WebElement> allButton;
    
	// End Thuoc tinh
	//===============================================
    
    public abstract void enterFileNumberFieldAs(String fileNumber);
    
    public abstract void enterQuyCachDongGoiFieldAs(String quyCachDongGoi);
//    {
//        fileNumberField = allTextbox.get(0);
//        fileNumberField.clear();
//        fileNumberField.sendKeys(fileNumber);
//    }
    
    public void enterSignWhereFieldAs(String signWhere) {
    	signWhereField = allTextbox.get(1);
    	signWhereField.clear();
        signWhereField.sendKeys(signWhere);
    }
    
    public void clickCopporateCheckBox() {
    	copporateCheckBox = allCheckbox.get(1);
    	copporateCheckBox.click();
    }
    //ten nglieu
    public void enterMaterialNameFieldAs(String materialName){
    	materialNameField = allCombobox.get(1);
    	materialNameField.clear();
    	materialNameField.sendKeys(materialName);
    }
    //ham luong, dang bao che
    public void enterContenMaterialFieldAs(String contentMaterial){
    	contenMaterialField = allTextbox.get(2);
    	contenMaterialField.clear();
    	contenMaterialField.sendKeys(contentMaterial);
    }
    //don vi tinh
    public void enterUnitMaterialFieldAs(String unitMaterial){
    	unitMaterialField = allCombobox.get(2);
    	unitMaterialField.clear();
    	unitMaterialField.sendKeys(unitMaterial);
    }
    //so luong
    public abstract void enterAmountMaterialFieldAs(String amountMaterial);
    /*{
    	amountMaterialField = allTextbox.get(3);
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }*/
    //tieu chuan chat luong
    public abstract void enterQualityMaterialFieldAs(String qualityMaterial);
    /*{
    	qualityMaterialField = allTextbox.get(4);
    	qualityMaterialField.clear();
    	qualityMaterialField.sendKeys(qualityMaterial);
    }*/
    //cty cung cap
     public void focusOnProviderMaterialField(){
    	 providerMaterialField = allChosenbox.get(0);
    	 providerMaterialField.click();
     }
     public void chooseProviderMaterialCombobox(){
    	 providerMaterialCombobox = allChosenComboboxChild1.get(2);
    	 providerMaterialCombobox.click();
     }
     //ct san xuat
     public void focusManufacturalMaterialField(){
    	 manufacturalMaterialField = allChosenbox.get(1);
    	 manufacturalMaterialField.click();
     }
     public void choosemanufacturalMaterialCombobox(){
    	 manufacturalMaterialCombobox = allChosenComboboxChild2.get(2);
    	 manufacturalMaterialCombobox.click();
     }

    //SDK thuoc cung cung
    
    public void enterRegistrationNumberFeildAs(String registrationNumner){
    	registrationNumberFeild = allTextbox.get(5);
    	registrationNumberFeild.clear();
    	registrationNumberFeild.sendKeys(registrationNumner);
    }
    public void enterContentrationFieldAs(String contentration){
    	contentrationField = allTextbox.get(6);
    	contentrationField.clear();
    	contentrationField.sendKeys(contentration);
    }
    public void enterContentImportFieldFeildAs(String contentImport){
    	contentImportField = allTextbox.get(7);
    	contentImportField.clear();
    	contentImportField.sendKeys(contentImport);
    }
    //cam ket
    public void clickCommitedCheckbox() {
    	commitedCheckbox = allCheckbox.get(4);
    	commitedCheckbox.click();
    }
    //Luu khoan don hang
    public void clickAddMaterialButton() {
    	addMaterialButton = allButton.get(3);    	
    	addMaterialButton.click();
    }
    //Luu don hang
    public void clickSaveListMaterialButton() {
    	saveListMaterialButton = allButton.get(6);
    	saveListMaterialButton.click();
    	
    }
    
    public abstract void Run();
    
    
   
}
