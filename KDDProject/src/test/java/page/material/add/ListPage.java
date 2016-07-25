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

	public ListPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		itemsPerPage = Integer.parseInt(PropertiesStore.getProperty("itemsPerPage"));
	}

	protected int itemsPerPage;

	@FindBy(css = ".z-listbox-body table tr.z-listitem")
	private List<WebElement> trList;

	@FindBy(css = ".z-paging-info")
	private WebElement pagingInfo;

	@FindBy(css = ".z-paging-text")
	private List<WebElement> listNumberOfPage;


	private WebElement numberOfPage;


	@FindBy(css = "button.z-paging-last")
	private WebElement buttonLastPage;

	protected void clickButtonToLastPage() {
		buttonLastPage.click();
		waitForLastPageAppear();
	}

	protected String getNumberOfPage() {
		numberOfPage = listNumberOfPage.get(1);
		return numberOfPage.getText();
	}

	protected int getListDocumnetPerPage() {
		return trList.size();
	}

	protected String getPageInfo() {
		String pageInfo = pagingInfo.getText();
		pageInfo = pageInfo.replace("[", "").replace("]", "").replace(" ", "");
		return pageInfo;
	}
	
	public void verifyTotalDocument() {
		try {
			
//			String range = getPageInfo().substring(0, getPageInfo().indexOf('/'));
//			String begin = range.substring(0, range.indexOf('-'));
//			String end = range.substring(range.indexOf('-') + 1, range.length());

			// int startIndex = Integer.parseInt(begin);
			// int endIndex = Integer.parseInt(end);;
			

			Assert.assertEquals(findTotalItemsOfList(),countTotalItemsByPage());
		
			
			
		} catch (NumberFormatException e) {
			AppLogger.logMessage(e.getMessage());
		}

	}

	public int findTotalItemsOfList() {	
		String totalPerPage = getPageInfo().substring(getPageInfo().indexOf('/') + 1, getPageInfo().length());
		int totalItemsOfList = Integer.parseInt(totalPerPage);
		return totalItemsOfList;
	}

	public int totalPageOfList() {
		String numberPaging = getNumberOfPage();
		numberPaging = numberPaging.replace("/", "").replace(" ", "");
		int numberPage = Integer.parseInt(numberPaging);
		return numberPage;
	}

	public int countTotalItemsByPage() {
		clickButtonToLastPage();
		int totalItems = ((totalPageOfList() - 1) * itemsPerPage + getListDocumnetPerPage());
		return totalItems;
	}
	
	@FindBy(css="input.z-paging-inp")
	private WebElement valuePage;
	
	public String getNumberOfPageOnTextBox()
	{
		return valuePage.getText();
	}
	
	private void waitForLastPageAppear() {
		waitForElement("table td:nth-child(9) .z-paging-btn.z-paging-btn-disd");
		
	}

}
