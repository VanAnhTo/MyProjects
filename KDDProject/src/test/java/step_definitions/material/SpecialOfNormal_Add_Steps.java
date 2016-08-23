package step_definitions.material;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.material.MaterialDetailBuilder;
import domain.builder.material.PageDetailBuilder;
import domain.detail.material.AttachmentDetail;
import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import util.PageStore;
import util.Specification;

public class SpecialOfNormal_Add_Steps {

	public WebDriver driver;

	PageDetailBuilder pageDetailBuilder;
	MaterialDetailBuilder materialDetailBuilder;
	List<MaterialDetail> materialDetailList;
	Specification user;
	PageStore pageStore;

	public SpecialOfNormal_Add_Steps() {
		this.pageDetailBuilder = new PageDetailBuilder();
		this.materialDetailBuilder = new MaterialDetailBuilder();
		this.materialDetailList = new ArrayList<MaterialDetail>();

		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}

	@Given("^I go to specical of nomaral page$")
	public void i_go_to_special_of_normal_page() {
		user.goToAddNew2ddPage();
	}

	@When("I enter file number field with value \"(.*)\" and sign where field with value \"(.*)\"")
	public void i_enter_file_number_value_and_sign_where_value(String fileNumber, String signWhere) {
		pageDetailBuilder.withFileNumber(fileNumber).withSignWhere(signWhere);
	}

	@When("I fill sign where field with value \"(.*)\"")
	public void i_enter_file_number_value(String signWhere) {
		pageDetailBuilder.withSignWhere(signWhere);
	}

	@When("I fill file number field with value \"(.*)\"")
	public void i_enter_sign_where_value(String fileNumber) {
		pageDetailBuilder.withFileNumber(fileNumber);
	}
	
	@When("I enter material detail")
	public void i_add_material_detail_to_grid(List<MaterialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
	}
	
	@And("I enter material info list")
	public void i_enter_material_info_list(List<MaterialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
	}
	
	@And("I save without order number")
	public void i_save_without_order_number() {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickSaveWithoutOderNumber(pageDetail);
	}

	@And("I save without sign place")
	public void i_save_without_sign_place() {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickSaveWithoutSignPlace(pageDetail);
	}
	
	@And("I save without material details")
	public void i_save_without_material_details() {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickSaveWithoutMaterialDetais(pageDetail);
	}

	@And("I add without material name")
	public void i_save_without_material_name() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddWithoutMaterialName(pageDetail);
	}
	
	@And("I save without content material")
	public void i_save_without_content_material() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickSaveWithoutContentMaterial(pageDetail);
	}
	
	@And("I save without amount of material")
	public void i_save_without_amount() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickSaveWithoutAmount(pageDetail);
	}
	
	@And("I save without quality of material")
	public void i_save_without_quality() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickSaveWithoutQuality(pageDetail);
	}

	@And("^I save document info$")
	public void i_save_document_info() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddNew2ddWith(pageDetail);
	}
	
	@And("I save order")
	public void i_save_order() {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.saveOrder(pageDetail);
	}
	
	@And("I add to grid")
	public void i_add_order_to_grid() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddOrderToGrid(pageDetail);
	}
		
	@And("I add order to grid without checkbox commited")
	public void i_save_order_without_check_checkbox() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddOrderWithoutCheckbox(pageDetail);
	}

	@And("^I upload attachment files for document$")
	public void i_upload_attachment_files_document(List<AttachmentDetail> attachmentDetail) {
		user.goToAttachPage(attachmentDetail);
	}

	@Then("^I see the invalid message$")
	public void i_see_message_invalid_values() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyInvalidMessage(pageDetail);
	}

	@Then("I see an error message")
	public void i_see_an_error_message() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyErrorMessageForMaterialName(pageDetail);
	}

	@Then("I see the success message")
	public void i_see_an_success_message() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifySuccessMessage(pageDetail);
	}
	
	@Then("I see a warning message require check checkbox")
	public void i_see_a_warning_message_require_checkbox_commited() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyWarningCheckboxRequireCheckCheckbox(pageDetail);
	}
	
	@Then("I see the warning message")
	public void i_see_the_warning_message() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyWarningMessage(pageDetail);
	}
	
	@Then("I see a material on grid")
	public void i_see_the_material_on_grid() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyMaterialOnGrid(pageDetail);
	}

}
