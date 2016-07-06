package scenarios;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import domain.AddNew2ddDetailBuilder;
import domain.AddNew2ddDetails;
import domain.LoginDetailBuilder;
import domain.LoginDetails;
import domain.MaterialDetail;
import domain.MaterialDetailBuilder;
public class AddNew2dd  extends BaseScenario{
	@Test
	public void testLoginSucessfull() throws InterruptedException{
		LoginDetails loginDetails = new LoginDetailBuilder().
				withUsername("010203123").withPassword("123")
				.build();
		Thread.sleep(4000);
		given(user).clickLoginWith(loginDetails); 

		AddNew2ddDetailBuilder builder =   new AddNew2ddDetailBuilder();
		
		for(int j = 0; j <= 2; j++){
			builder.withFileNumber("SODH/2017").withSignWhere("Ha Noi");
			List<MaterialDetail> materialDetailList = new ArrayList<MaterialDetail>();
			MaterialDetailBuilder materialDetailBuilder=   new MaterialDetailBuilder();
			for(int i = 0; i <= 3; i++){
				materialDetailBuilder.withMaterialName("Nguyen lieu san xuat 1").withAmountMaterial("20").withContenMaterial("Ham Luong").withQualityMateriall("TCCL").withUnitMaterial("kg");
				materialDetailBuilder.withContentration("Ham luong SDK thuoc tu nguyen lieu").withContentImportl("Dang bao che SDK thuoc tu NL")
				.withRegistrationNumber("SDK cua thuoc tu nl");
				materialDetailList.add(materialDetailBuilder.build());
			}

			builder.withMaterialDetailList(materialDetailList);
			AddNew2ddDetails new2ddDetails = builder.build();
			then(user).goToAddNew2ddPage();
			then(user).clickAddNew2ddWith(new2ddDetails);
			
		}
	}
}
