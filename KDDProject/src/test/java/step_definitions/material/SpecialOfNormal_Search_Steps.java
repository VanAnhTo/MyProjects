package step_definitions.material;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	/*
	 * @When(
	 * "I want to search with order number: \"(.*)\", created date from: \"(.*)\", created date to: \"(.*)\""
	 * ) public void i_search_with_order_number(String orderNumber, String
	 * createdDateFrom, String createdDateTo) throws InterruptedException {
	 * searchDetailBuilder.withOrderNumber(orderNumber).withCreatedDateFrom(
	 * createdDateFrom) .withCreatedDateTo(createdDateTo); }
	 */

	@When("I want to search with order number: \"(.*)\", created date from: \"(.*)\", created date to: \"(.*)\"")
	public void i_search_with_order_number(String orderNumber, String createdDateFrom, String createdDateTo)
			throws InterruptedException {
		searchDetailBuilder.withOrderNumber(orderNumber).withCreatedDate(createdDateFrom, createdDateTo);

	}

	@When("I search with invalid issued date: \"(.*)\"")
	public void i_search_with_invalid_date(String createdDateFrom) throws InterruptedException {
		searchDetailBuilder.withCreatedDate(createdDateFrom, "");
	}
	
	@When("I search with a order number not in database : \"(.*)\"")
	public void i_search_with_order_number_not_in_database(String orderNumber) throws InterruptedException {
		searchDetailBuilder.withOrderNumber(orderNumber);
	}

	@And("I click the button Search$")
	public void i_search_the_orders_invalid_time() {
		SearchDetail searchDetail = searchDetailBuilder.build();
		user.clickSearchOrder(searchDetail);
	}

	@Then("I see the results of searching on the list")
	public void i_see_total() throws InterruptedException {
		user.verifyTotalDocument();
	}


	
	@Then("I see empty message")
	public void i_see_empty_message() throws InterruptedException {
		user.verifyEmptyMessage();
	}
	
	@And("Empty order on the grid")
	public void i_verify_grid_empty() throws InterruptedException {
		user.verifyEmptyList();
	}
	
	@Then("I see a warning message")
	public void i_see_warning_message() throws InterruptedException {
		user.verifyWarningMessaage();
	}
	
	@Then("(I see the over maxlength messsage|I see the error tooltip)")
	public void i_see_over_maxthlength_message() throws InterruptedException {
		user.verifyOverMaxMessaage();
	}
	
	@Then("I see the error tooltip")
	public void i_see_error_tooltip() throws InterruptedException {
		user.verifyAlertDate();
	}

}
