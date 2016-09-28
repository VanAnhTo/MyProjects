package util;

import domain.detail.material.PageDetail;
import page.account.HomePage;
import page.material.NormalMaterialPage;

public class Specification_Normal {
	PageStore pageStore;

	public Specification_Normal(PageStore pageStore) {
		this.pageStore = pageStore;
	}
	
	public void goToAddNew2aPage() {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToCreate2aPage();
	}
	public void clickSaveMaterialOrder(PageDetail pageDetail) {
		NormalMaterialPage onNormalPage = pageStore.get(NormalMaterialPage.class);
		onNormalPage.saveMaterialWith(pageDetail);	
	}
	
}
