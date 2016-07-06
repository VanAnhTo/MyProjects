package pageFactoryImpl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAttachFile2ddPage {

	protected WebElement fileNumberField;

	@FindBy(css = ".z-groupbox-cnt .z-textbox")
	protected List<WebElement> allTabLable;
	
	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(1)")
	protected WebElement fileTypeGCNKinhDoanh;
	
	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(2)")
	protected WebElement fileTypeTCCL;
	
	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(3)")
	protected WebElement fileTypePhuongPhapKiemNghiem;
	
	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(4)")
	protected WebElement fileTypeOther;
	
	
	
	
}
