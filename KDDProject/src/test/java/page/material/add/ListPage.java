package page.material.add;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.sun.org.apache.bcel.internal.generic.Select;

import util.AppLogger;
import util.PropertiesStore;

public class ListPage extends PageEvent {

	private int itemsPerPage;
	private WebElement firstOrderNumber;
	private WebElement lastOrderNumber;

	private WebElement pageNumberOnInput;

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
	private List<WebElement> currentPage;

	@FindBy(css = "table tbody:nth-child(2) tr:first-child td:nth-child(2)")
	private WebElement startIndex;

	@FindBy(css = "table tbody:nth-child(2) tr:last-child td:nth-child(2)")
	private WebElement endIndex;

	public ListPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		itemsPerPage = Integer.parseInt(PropertiesStore.getProperty("itemsPerPage"));
	}

	public void verifyTotalDocument() {
		try {
			int totalItemsInList = getTotalItemsByLabel();
			clickButtonToLastPage();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//waitForLastPageButton();
			int totalItems = getTotalItemsByGrid();
			Assert.assertEquals(totalItemsInList, totalItems);
		} catch (NumberFormatException e) {
			AppLogger.logMessage(e.getMessage());
		}
	}

	public void verifyNumberOfItemOnGrid() {
		// try {
		clickButtonToLastPage();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int firstNumberOnGrid = getStartIndex();
		int startIndex = getFirstNumberOnLabel();
		int lastNumberOnGri = getEndIndex();
		int endINdex = getEndNumberOnLabel();
		
		int index = getIndex();
		
		Assert.assertEquals(firstNumberOnGrid, startIndex);
		Assert.assertEquals(lastNumberOnGri, endINdex);
		
		Assert.assertEquals(index, endINdex);

		// } catch (NumberFormatException e) {
		// AppLogger.logMessage(e.getMessage());
		// }
	}

	private int getTotalItemsByLabel() {
		String totalPerPage = getPageInfo().substring(getPageInfo().indexOf('/') + 1, getPageInfo().length());
		int totalItemsOfList = Integer.parseInt(totalPerPage);
		return totalItemsOfList;
	}

	private void clickButtonToLastPage() {
		buttonLastPage.click();
		// int numberOnTextBox = getNumberOfPageOnTextBox();
		// waitForNextPageAppear(numberOnTextBox);
	}

	private int getTotalItemsByGrid() {
		int totalPage = getTotalPageByLabel();
		int numberOfElementInLastPage = getListItemsPerPage();
		int totalItems = (totalPage - 1) * itemsPerPage + numberOfElementInLastPage;
		return totalItems;
	}
	
	private int getIndex() {
		int currentPage = getNumberOfPageOnTextBox();
		int numberOfElementInLastPage = getListItemsPerPage();
		int totalItems = (currentPage - 1) * itemsPerPage + numberOfElementInLastPage;
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

	private int getFirstNumberOnGrid() {
		int numberOnTextBox = getNumberOfPageOnTextBox();
		int totalPage = getTotalPageByLabel();
		int firstNumberOnGrid = (totalPage - numberOnTextBox) * itemsPerPage + 1;
		return firstNumberOnGrid;
	}

	private int getLastNumberOnGrid() {
		int numberOnTextBox = getNumberOfPageOnTextBox();
		int totalPage = getTotalPageByLabel();
		int itemsPerPage = getListItemsPerPage();
		int firstNumberOnGrid = (totalPage - numberOnTextBox) * itemsPerPage + itemsPerPage;
		return firstNumberOnGrid;
	}

	private int getStartIndex() {
		return Integer.parseInt(startIndex.getText());
	}

	private int getEndIndex() {
		return Integer.parseInt(endIndex.getText());
	}

	private int getFirstNumberOnLabel() {
		String pageInfo = getPageInfo();
		String range = pageInfo.substring(0, pageInfo.indexOf('/'));
		String begin = range.substring(0, range.indexOf('-'));
		int startIndex = Integer.parseInt(begin);
		return startIndex;
	}

	private int getEndNumberOnLabel() {
		String pageInfo = getPageInfo();
		String range = pageInfo.substring(0, pageInfo.indexOf('/'));
		String end = range.substring(range.indexOf('-') + 1, range.length());
		int endIndex = Integer.parseInt(end);
		return endIndex;
	}

	private String getNumberOnInput() {
		pageNumberOnInput = currentPage.get(0);
		return pageNumberOnInput.getAttribute("value");
	}

	private int getNumberOfPageOnTextBox() {
		String numberOnTextBoxList = getNumberOnInput();
		int numberOnTextBox = Integer.parseInt(numberOnTextBoxList);
		return numberOnTextBox;
	}

	private void waitForNextPageAppear() {
		waitForElement("table td:nth-child(9) .z-paging-btn.z-paging-btn-disd");

	}

	private void waitForLastPageButton() {
		waitForUnclickableElement("button.z-paging-last");
	}

}
