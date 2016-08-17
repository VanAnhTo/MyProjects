package step_definitions.material;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
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

	@When("^I go to specical of nomaral page$")
	public void i_go_to_special_of_normal_page() {
		user.goToAddNew2ddPage();
	}

	@When("^I enter file number field with value \"(.*)\" and sign where field with value \"(.*)\"$")
	public void i_enter_file_number_value_and_sign_where_value(String fileNumber, String signWhere) {
		pageDetailBuilder.withFileNumber(fileNumber).withSignWhere(signWhere);
	}

	@And("I enter material info list")
	public void i_enter_material_info_list(List<MaterialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
	}

	
	
	@And("I add material to grid")
	public void i_add_material_to_grid() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddMaterialToGrid(pageDetail);
	}
	
	
	
	@And("I save order")
	public void i_save_order() {
		/*pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();*/
		user.clickSaveOrder();
	}
	
	

	@And("^I save document info$")
	public void i_save_document_info() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddNew2ddWith(pageDetail);
	}

	@And("^I upload attachment files for document$")
	public void i_upload_attachment_files_document(List<AttachmentDetail> attachmentDetail) {
		user.goToAttachPage(attachmentDetail);
	}
	
	@And("^I see the message invalid value$")
	public void i_see_message_invalid_values() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyInvalidMessage(pageDetail);
	}
	
	
	@Then("I see an error message")
	public void i_see_an_error_message() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifyErrorMessageForMaterialName(pageDetail);
	}
	
	@Then("I see an success message")
	public void i_see_an_success_message() throws InterruptedException {
		PageDetail pageDetail = pageDetailBuilder.build();
		user.verifySuccessMessage(pageDetail);
	}

}
