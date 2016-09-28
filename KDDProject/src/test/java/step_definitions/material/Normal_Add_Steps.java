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
import util.Specification_Normal;

public class Normal_Add_Steps {

	public WebDriver driver;

	PageDetailBuilder pageDetailBuilder;
	MaterialDetailBuilder materialDetailBuilder;
	List<MaterialDetail> materialDetailList;
	Specification user;
	Specification_Normal userNormal;
	PageStore pageStore;

	public Normal_Add_Steps() {
		this.pageDetailBuilder = new PageDetailBuilder();
		this.materialDetailBuilder = new MaterialDetailBuilder();
		this.materialDetailList = new ArrayList<MaterialDetail>();

		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}
	@Given("I go to nomaral page")
	public void i_go_to_normal_page() {
		userNormal.goToAddNew2aPage();
	}
	@And("I enter materials info")
	public void i_enter_materials_info(List<MaterialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
	}
	@And("I save normal material order")
	public void i_save_normal_material_order() {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		userNormal.clickSaveMaterialOrder(pageDetail);
	}
	
	
}