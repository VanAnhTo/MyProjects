package step_definitions.material;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.material.MaterialDetailBuilder;
import domain.builder.material.PageDetailBuilder;
import domain.detail.material.MaterialDetail;
import util.PageStore;
import util.Specification;

public class SpecialOfNormal_List_Steps {

	public WebDriver driver;

	PageDetailBuilder pageDetailBuilder;
	MaterialDetailBuilder materialDetailBuilder;
	List<MaterialDetail> materialDetailList;
	Specification user;
	PageStore pageStore;

	public SpecialOfNormal_List_Steps() {
		this.pageDetailBuilder = new PageDetailBuilder();
		this.materialDetailBuilder = new MaterialDetailBuilder();
		this.materialDetailList = new ArrayList<MaterialDetail>();

		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
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
