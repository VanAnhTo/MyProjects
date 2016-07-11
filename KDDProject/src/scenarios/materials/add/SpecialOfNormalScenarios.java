package scenarios.materials.add;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import domain.builder.account.LoginDetailBuilder;
import domain.builder.material.PageDetailBuilder;
import domain.builder.material.MaterialDetailBuilder;
import domain.detail.account.LoginDetails;
import domain.detail.material.PageDetail;
import domain.detail.material.MaterialDetail;
import scenarios.base.BaseScenario;

public class SpecialOfNormalScenarios extends BaseScenario {
	
	@Test
	public void testLoginSucessfull() throws Exception {

		LoginDetails loginDetails = new LoginDetailBuilder().withUsername("010203123").withPassword("123").build();
		// Thread.sleep(4000);
		given(user).clickLoginWith(loginDetails);
		// then(user).goToAddNew2ddPage();

		PageDetailBuilder builder = new PageDetailBuilder();

		for (int j = 0; j <= 1; j++) {
			builder.withFileNumber("SODH/2017").withSignWhere("Ha Noi");
			List<MaterialDetail> materialDetailList = new ArrayList<MaterialDetail>();
			MaterialDetailBuilder materialDetailBuilder = new MaterialDetailBuilder();
			for (int i = 0; i <= 1; i++) {
				materialDetailBuilder.withMaterialName("Nguyen lieu san xuat 1").withAmountMaterial("20")
						.withContenMaterial("Ham Luong").withQualityMateriall("TCCL").withUnitMaterial("kg");
				materialDetailBuilder.withContentration("Ham luong SDK thuoc tu nguyen lieu")
						.withContentImportl("Dang bao che SDK thuoc tu NL")
						.withRegistrationNumber("SDK cua thuoc tu nl");
				materialDetailList.add(materialDetailBuilder.build());

			}

			builder.withMaterialDetailList(materialDetailList);
			PageDetail pageDetail = builder.build();
			then(user).goToAddNew2ddPage();
			then(user).clickAddNew2ddWith(pageDetail);
			then(user).goToAttachPage();

		}
	}
}
