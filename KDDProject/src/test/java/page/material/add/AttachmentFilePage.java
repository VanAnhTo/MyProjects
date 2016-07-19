package page.material.add;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttachmentFilePage extends PageEvent {

	WebDriver driver;

	public AttachmentFilePage(WebDriver driver) {
		super(driver);
	}

	protected WebElement tabTepDinhKem;

	protected WebElement buttonThemTep;

	@FindBy(css = ".z-tabs-header .z-tab-hm span")
	protected List<WebElement> allTabLable;

	@FindBy(css = "input[type=file]")
	protected WebElement buttonChonTep;

	@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
	protected List<WebElement> allButton;

	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(1)")
	protected WebElement fileTypeGCNKinhDoanh;

	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(2)")
	protected WebElement fileTypeTCCL;

	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(3)")
	protected WebElement fileTypePhuongPhapKiemNghiem;

	@FindBy(css = ".z-groupbox-cnt .z-select .z-option:nth-child(4)")
	protected WebElement fileTypeOther;

	public void chonTabTepDinhKem() {
		tabTepDinhKem = allTabLable.get(1);
		tabTepDinhKem.click();
	}

	public void clickButtonChonTep(String pathFile)  {
		buttonChonTep.sendKeys(pathFile);
		waitForUploadFileComplete();
		clickButtonThemTep();

	}

	public void clickButtonThemTep() {

		buttonThemTep = allButton.get(5);
		buttonThemTep.click();
		// waitForSaveFileUploadFileCoplete() ;
	}

	public void chonLoaiTepDangKyKinhDoanh()  {
		fileTypeGCNKinhDoanh.click();
	}

	public void chonLoaiTepTieuChuanChatLuong()  {
		fileTypeTCCL.click();
	}

	public void chonLoaiTepPPKiemNghiem()  {
		fileTypePhuongPhapKiemNghiem.click();
	}

	public void chonLoaiTepKhac()  {
		fileTypeOther.click();
	}

	int i = 1;

	public void saveAllAttachFiles(String pathFile) {
		chonTabTepDinhKem();

		chonLoaiTepDangKyKinhDoanh();
		clickButtonChonTep(pathFile);
		waitForSaveFileUploadFileCoplete(i);
		i++;
		chonLoaiTepTieuChuanChatLuong();
		clickButtonChonTep(pathFile);
		waitForSaveFileUploadFileCoplete(i);
		i++;
		chonLoaiTepPPKiemNghiem();
		clickButtonChonTep(pathFile);
		waitForSaveFileUploadFileCoplete(i);
		i++;
		chonLoaiTepKhac();
		clickButtonChonTep(pathFile);
		waitForSaveFileUploadFileCoplete(i);
		i++;
	}

	private void waitForUploadFileComplete() {
		waitForElement(".newFile.z-hlayout .z-hlayout-inner .z-label");
	}

	private void waitForSaveFileUploadFileCoplete(int i) {
		waitForElement(".z-groupbox-cnt .z-listbox-body table tbody:nth-child(2) tr:nth-child(" + i + ")");
	}

}
