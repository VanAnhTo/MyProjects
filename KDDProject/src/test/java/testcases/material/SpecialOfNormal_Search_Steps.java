package testcases.material;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.material.SearchDetailBuilder;
import domain.detail.material.SearchDetail;
import page.account.HomePage;
import page.material.search.SpecialNormalDetailSearchPage;
import util.PageStore;

public class SpecialOfNormal_Search_Steps {
	public WebDriver driver;

	SearchDetailBuilder searchDetailBuilder;
	SpecialNormalDetailSearchPage onSearchPage;
	PageStore pageStore;

	public SpecialOfNormal_Search_Steps() {
		this.searchDetailBuilder = new SearchDetailBuilder();
		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.onSearchPage = pageStore.get(SpecialNormalDetailSearchPage.class);
	}
	
	@Given("I navigate to search form")
	public void i_navigate_to_search()
			throws InterruptedException {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToListPage();

	}

	@When("I fill created date from: \"(.*)\", created date to: \"(.*)\"")
	public void i_search_with_order_number(String createdDateFrom, String createdDateTo)
			throws InterruptedException {
		searchDetailBuilder.withCreatedDate(createdDateFrom, createdDateTo);

	}

	@And("I click the search button")
	public void i_click_search_button() {
		SearchDetail searchDetail = searchDetailBuilder.build();
		onSearchPage.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		onSearchPage.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		onSearchPage.clickSearchButton();
		
	}
	
	@Then("I verify range date warning")
	public void i_verify_range_date_warning(){
		onSearchPage.Validate.verifyRangDateWarning();
	}

}
