package page.material.add;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.material.AttachmentDetail;

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

	@FindBy(css = ".z-groupbox-cnt .z-select .z-option")
	protected List<WebElement> fileType;

	public void chonTabTepDinhKem() {
		tabTepDinhKem = allTabLable.get(1);
		tabTepDinhKem.click();
	}

	public void clickButtonChonTep(String pathFile) {
		buttonChonTep.sendKeys(pathFile);
		waitForUploadFileComplete();
		clickButtonThemTep();

	}

	public void clickButtonThemTep() {
		buttonThemTep = allButton.get(5);
		buttonThemTep.click();
	}

	public void saveAllAttachFiles(List<AttachmentDetail> attachmentDetailList) {
		chonTabTepDinhKem();
		int i = 1;
		for (AttachmentDetail attachmentDetail : attachmentDetailList) {
			int fileType = Enum.AttachmentEnum.valueOf(attachmentDetail.getFileType()).value - 1;
			selectAttachmentFile(fileType);
			clickButtonChonTep(attachmentDetail.getFilePath());
			waitForSaveFileUploadFileCoplete(i);
			i++;
		}
	}

	private void selectAttachmentFile(int fileType) {
		this.fileType.get(fileType).click();

	}

	private void waitForUploadFileComplete() {
		waitForElement(".newFile.z-hlayout .z-hlayout-inner .z-label");
	}

	private void waitForSaveFileUploadFileCoplete(int i) {
		waitForElement(".z-groupbox-cnt .z-listbox-body table tbody:nth-child(2) tr:nth-child(" + (i) + ")");
	}

}
