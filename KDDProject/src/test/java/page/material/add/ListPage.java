package page.material.add;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.AppLogger;
import util.PropertiesStore;

public class ListPage extends PageEvent {

	private int itemsPerPage;
	
	private WebElement numberOfPage;

	@FindBy(css = ".z-listbox-body table tr.z-listitem")
	private List<WebElement> trList;

	@FindBy(css = ".z-paging-info")
	private WebElement pagingInfo;

	@FindBy(css = ".z-paging-text")
	private List<WebElement> listNumberOfPage;

	@FindBy(css = "button.z-paging-last")
	private WebElement buttonLastPage;

	@FindBy(css = "input.z-paging-inp")
	private WebElement valuePage;

	public ListPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		itemsPerPage = Integer.parseInt(PropertiesStore.getProperty("itemsPerPage"));
	}

	public void verifyTotalDocument() {
		try {
			int totalItemsInList = getTotalItemsByLabel();
			clickButtonToLastPage();
			int totalItems = getTotalItemsByGrid();
			Assert.assertEquals(totalItemsInList, totalItems);
		} catch (NumberFormatException e) {
			AppLogger.logMessage(e.getMessage());
		}
	}
	
	private int getTotalItemsByLabel() {
		String totalPerPage = getPageInfo().substring(getPageInfo().indexOf('/') + 1, getPageInfo().length());
		int totalItemsOfList = Integer.parseInt(totalPerPage);
		return totalItemsOfList;
	}

	private void clickButtonToLastPage() {
		buttonLastPage.click();
		waitForLastPageAppear();
	}

	private int getTotalItemsByGrid() {
		int totalPage = getTotalPageByLabel();
		int numberOfElementInLastPage = getListItemsPerPage();
		int totalItems = (totalPage - 1) * itemsPerPage + numberOfElementInLastPage;
		return totalItems;
	}
	
	private String getNumberOfPage() {
		numberOfPage = listNumberOfPage.get(1);
		return numberOfPage.getText();
	}

	private int getListItemsPerPage() {
		return trList.size();
	}

	private String getPageInfo() {
		String pageInfo = pagingInfo.getText();
		pageInfo = pageInfo.replace("[", "").replace("]", "").replace(" ", "");
		return pageInfo;
	}

	private int getTotalPageByLabel() {
		String numberPaging = getNumberOfPage();
		numberPaging = numberPaging.replace("/", "").replace(" ", "");
		int numberPage = Integer.parseInt(numberPaging);
		return numberPage;
	}

	private String getNumberOfPageOnTextBox() {
		return valuePage.getText();
	}

	private void waitForLastPageAppear() {
		waitForElement("table td:nth-child(9) .z-paging-btn.z-paging-btn-disd");

	}

}
