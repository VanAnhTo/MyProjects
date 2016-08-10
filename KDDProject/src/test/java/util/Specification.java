package util;


import java.util.List;

import domain.detail.account.LoginDetails;
import domain.detail.material.AttachmentDetail;
import domain.detail.material.PageDetail;
import domain.detail.material.SearchDetail;
import page.account.HomePage;
import page.account.LoginPage;
import page.material.AttachmentFilePage;
import page.material.GridPage;
import page.material.NormalMaterialPage;
import page.material.NormalMaterialSearchPage;
import page.material.SpecialNormalMaterialPage;

public class Specification {

	PageStore pageStore;

	public Specification(PageStore pageStore) {
		this.pageStore = pageStore;
	}

	public void clickLoginWith(LoginDetails loginDetails) {
		LoginPage onLoginPage = pageStore.get(LoginPage.class);
		onLoginPage.loginToMainPage(loginDetails);

	}

	public void goToAddNew2ddPage() {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToCreate2ddPage();
	}

	public void goToAddNew2aPage() throws InterruptedException {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToCreate2aPage();
	}

	public void goToListPage() throws InterruptedException {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToListPage();
	}

	public void verifyTotalDocument() throws InterruptedException {
		GridPage onListPage = pageStore.get(GridPage.class);
		onListPage.verifyTotalDocument();
	}

	public void verifyResultOfSearch() throws InterruptedException {
		GridPage onListPage = pageStore.get(GridPage.class);
		onListPage.verifyTotalDocument();
	}

	public void verifyNumberOfItemOnGrid() throws InterruptedException {
		GridPage onListPage = pageStore.get(GridPage.class);
		onListPage.verifyNumberOfItemOnGrid();
	}

	public void clickAddNew2ddWith(PageDetail new2ddDetails) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.saveMaterialWith(new2ddDetails);

	}

	public void clickAddNew2aWith(PageDetail new2ddDetails) throws InterruptedException {
		NormalMaterialPage onNew2ddPage = pageStore.get(NormalMaterialPage.class);
		onNew2ddPage.saveMaterialWith(new2ddDetails);

	}

	public void goToAttachPage(List<AttachmentDetail> attachmentDetail) {
		AttachmentFilePage onAttachPage = pageStore.get(AttachmentFilePage.class);
		onAttachPage.saveAllAttachFiles(attachmentDetail);
	}

	public void clickSearchOrder(SearchDetail searchDetail) {
		NormalMaterialSearchPage onSearchPage = pageStore.get(NormalMaterialSearchPage.class);
		onSearchPage.searchOrderSpecialOfNormal(searchDetail);
	}

	public void verifyAlertDate() {
		NormalMaterialSearchPage onSearchPage = pageStore.get(NormalMaterialSearchPage.class);
		onSearchPage.assertAlertDatePickerInvalid();
	}
	public void verifyEmptyMessage() {
		NormalMaterialSearchPage onSearchPage = pageStore.get(NormalMaterialSearchPage.class);
		onSearchPage.assertEmptyMessage();
	}
	
	public void verifyEmptyList() {
		GridPage onListPage = pageStore.get(GridPage.class);
		onListPage.verifyEmptyList();
	}
	
	public void verifyWarningMessaage() {
		NormalMaterialSearchPage onSearchPage = pageStore.get(NormalMaterialSearchPage.class);
		onSearchPage.assertRangDateWarning();
	}
	
	public void verifyOverMaxMessaage() {
		NormalMaterialSearchPage onSearchPage = pageStore.get(NormalMaterialSearchPage.class);
		onSearchPage.assertMaxlength(50);
	}
	
	

}
