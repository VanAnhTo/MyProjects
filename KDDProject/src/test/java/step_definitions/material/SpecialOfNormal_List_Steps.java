package step_definitions.material;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.material.MaterialDetailBuilder;
import domain.builder.material.PageDetailBuilder;
import domain.detail.account.LoginDetails;
import domain.detail.material.AttachmentDetail;
import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import util.PageStore;
import util.Specification;

public class SpecialOfNormal_List_Steps {

	public WebDriver driver;

	LoginDetailBuilder builder;
	PageDetailBuilder pageDetailBuilder;
	MaterialDetailBuilder materialDetailBuilder;
	List<MaterialDetail> materialDetailList;
	Specification user;
	PageStore pageStore;

	public SpecialOfNormal_List_Steps() {
		this.builder = new LoginDetailBuilder();
		this.pageDetailBuilder = new PageDetailBuilder();
		this.materialDetailBuilder = new MaterialDetailBuilder();
		this.materialDetailList = new ArrayList<MaterialDetail>();

		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}

	@Given("^I open website \"(.*)\"$")
	public void i_open_browser_and_enter_link_website(String linkWeb) {
		driver.get(linkWeb);
	}

	@And("I enter login form")
	public void i_fill_login_form(DataTable loginDataTable) {
		List<List<String>> result = loginDataTable.raw();
		String username = result.get(1).get(0);
		String password = result.get(1).get(1);
		builder.withUsername(username).withPassword(password);
	}

	@And("^I logged in$")
	public void i_get_homepage() {
		LoginDetails loginDetails = builder.build();
		user.clickLoginWith(loginDetails);
	}

	@When("I go to specical of list page")
	public void i_go_to_special_of_normal_list_page() throws InterruptedException {
		user.goToListPage();
	}

	@Then("I see total of documents per page")
	public void i_see_total() throws InterruptedException {
		user.verifyTotalDocument();
	}
	
	@And("I see page number on grid")
	public void i_see_page_number() throws InterruptedException {
		user.verifyNumberOfItemOnGrid();
	}

}
