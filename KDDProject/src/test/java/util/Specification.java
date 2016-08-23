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

	public void verifyInvalidMessage(PageDetail pageDetail) throws InterruptedException {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifyInvalidMessage();

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
		// onSearchPage.assertAlertDatePickerInvalid();
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

	public void clickAddWithoutMaterialName(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickAddWithoutMaterialName(pageDetail);
	}

	public void verifyErrorMessage(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifyErrorMessage(pageDetail);
	}

	public void clickSaveOrder() {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveOrder();
	}

	public void verifySuccessMessage(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifySuccessMessage(pageDetail);

	}

	public void verifyErrorMessageForMaterialName(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifyInvalidMessage();

	}

	public void clickSaveWithoutOderNumber(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutOrderNumber(pageDetail);
	}

	public void clickSaveWithoutSignPlace(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutSignPlace(pageDetail);
	}

	public void clickSaveWithoutMaterialDetais(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutMaterialDetais(pageDetail);
	}

	public void clickSaveWithoutContentMaterial(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutContentMaterial(pageDetail);
	}

	public void clickSaveWithoutAmount(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutAmount(pageDetail);
	}

	public void clickSaveWithoutQuality(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutQuality(pageDetail);
	}

	public void verifyWarningMessage(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifyWarningMessage(pageDetail);
	}

	public void saveOrder(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickSaveWithoutMaterialDetais(pageDetail);
	}

	public void verifyMaterialOnGrid(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifyMaterialOnGrid(pageDetail);
	}

	public void clickAddOrderWithoutCheckbox(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickAddOrderWithoutCheckbox(pageDetail);
	}

	public void verifyWarningCheckboxRequireCheckCheckbox(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.verifyWarningCheckboxRequireCheckCheckbox(pageDetail);
	}

	public void clickAddOrderToGrid(PageDetail pageDetail) {
		SpecialNormalMaterialPage onNew2ddPage = pageStore.get(SpecialNormalMaterialPage.class);
		onNew2ddPage.clickAddOrderToGrid(pageDetail);
	}

}
