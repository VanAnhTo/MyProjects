package step_definitions.material;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.material.SearchDetailBuilder;
import domain.detail.material.SearchDetail;
import util.PageStore;
import util.Specification;

public class SpecialOfNormal_Search_Steps {
	public WebDriver driver;

	SearchDetailBuilder searchDetailBuilder;

	Specification user;
	PageStore pageStore;

	public SpecialOfNormal_Search_Steps() {
		this.searchDetailBuilder = new SearchDetailBuilder();
		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}

	@And("I click the button Search$")
	public void i_search_the_orders() {
		SearchDetail searchDetail = searchDetailBuilder.build();
		user.clickSearchOrder(searchDetail);
	}

	@Then("I see the results of searching on the list")
	public void i_see_total() throws InterruptedException {
		user.verifyTotalDocument();
	}

	@When("I want to search with order number: \"(.*)\", created date from: \"(.*)\", created date to: \"(.*)\"")
	public void i_search_with_order_number(String orderNumber, String createdDateFrom, String createdDateTo)
			throws InterruptedException {
		searchDetailBuilder.withOrderNumber(orderNumber).withCreatedDateFrom(createdDateFrom)
				.withCreatedDateTo(createdDateTo);
	}
}
