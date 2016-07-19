package step_definitions.material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.material.MaterialDetailBuilder;
import domain.builder.material.PageDetailBuilder;
import domain.detail.account.LoginDetails;
import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import util.Hooks;
import util.PageStore;
import util.Specification;

public class SpecialOfNormal_Add_Steps {

	public WebDriver driver;

	LoginDetailBuilder builder;
	PageDetailBuilder pageDetailBuilder;
	MaterialDetailBuilder materialDetailBuilder;
	List<MaterialDetail> materialDetailList;
	Specification user;
	PageStore pageStore;

	public SpecialOfNormal_Add_Steps() throws IOException {
		builder = new LoginDetailBuilder();
		pageDetailBuilder = new PageDetailBuilder();
		materialDetailBuilder = new MaterialDetailBuilder();
		materialDetailList = new ArrayList<MaterialDetail>();

		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}

	@Given("^I open browser and enter link website \"(.*)\"$")
	public void i_open_browser_and_enter_link_website(String linkWeb) throws Throwable {
		driver.get(linkWeb);
	}

	@And("^After I enter username: \"(.*)\" and password: \"(.*)\"$")
	public void i_enter_username_and_password(String username, String password) throws Throwable {
		builder.withUsername(username).withPassword(password);
	}

	@And("I fill login form")
	public void i_fill_login_form(DataTable loginDataTable) throws Throwable {
		List<List<String>> result = loginDataTable.raw();
		String username = result.get(1).get(0);
		String password = result.get(1).get(1);
		builder.withUsername(username).withPassword(password);
	}

	@And("^I login$")
	public void i_get_homepage() throws Throwable {
		LoginDetails loginDetails = builder.build();
		user.clickLoginWith(loginDetails);
	}

	@When("^I go to specical of nomaral page$")
	public void i_go_to_special_of_normal_page() throws Throwable {
		user.goToAddNew2ddPage();
	}

	@When("^I enter file number field with value \"(.*)\" and sign where field with value \"(.*)\"$")
	public void i_enter_file_number_value_and_sign_where_value(String fileNumber, String signWhere) throws Throwable {
		pageDetailBuilder.withFileNumber(fileNumber).withSignWhere(signWhere);
	}

	@And("I enter material info list")
	public void i_enter_material_info_list(List<MaterialDetail> materialDetailList) throws Throwable {
		this.materialDetailList = materialDetailList;
	}

	@And("^I enter material name: \"(.*)\" , ham luong:\"(.*)\", so luong: \"(.*)\", don vi tinh: \"(.*)\" TCCL: \"(.*)\"$")
	public void i_enter_info_material(String materialName, String content, String amount, String quality, String unit)
			throws Throwable {
		materialDetailBuilder.withMaterialName(materialName).withContenMaterial(content).withAmountMaterial(amount)
				.withQualityMateriall(quality).withUnitMaterial(unit);
	}

	@And("^I enter SDK cua thuoc: \"(.*)\" , ham luong cua thuoc: \"(.*)\" , dang bao che cua thuoc: \"(.*)\"$")
	public void i_enter_import_number(String registration, String contenImport, String contrentration)
			throws Throwable {
		materialDetailBuilder.withContentImportl(contenImport).withRegistrationNumber(registration)
				.withContentration(contrentration);
	}

	@And("^I save document info$")
	public void i_save_document_info() throws Throwable {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		user.clickAddNew2ddWith(pageDetail);
	}

	@And("^I upload attachment files for document$")
	public void i_upload_attachment_files_document() throws Throwable {
		user.goToAttachPage();
	}

}
