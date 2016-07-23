package util;

import page.material.add.AttachmentFilePage;
import page.material.add.NormalPage;
import page.material.add.SpecialOfNormalPage;

import java.util.List;

import domain.detail.account.LoginDetails;
import domain.detail.material.AttachmentDetail;
import domain.detail.material.PageDetail;
import page.account.HomePage;
import page.account.LoginPage;

public class Specification {

    PageStore pageStore;

    public Specification(PageStore pageStore) {
        this.pageStore = pageStore;
    }

    public void clickLoginWith(LoginDetails loginDetails) {
        LoginPage onLoginPage = pageStore.get(LoginPage.class);
        onLoginPage.loginToMainPage(loginDetails);
        
    }
    
    public void goToAddNew2ddPage(){
    	HomePage onHomePage = pageStore.get(HomePage.class);
    	onHomePage.goToCreate2ddPage();
    }
    public void goToAddNew2aPage() throws InterruptedException{
    	HomePage onHomePage = pageStore.get(HomePage.class);
    	onHomePage.goToCreate2aPage();
    }
    
    public void clickAddNew2ddWith(PageDetail new2ddDetails)
    {
    	 SpecialOfNormalPage onNew2ddPage = pageStore.get(SpecialOfNormalPage.class);
    	 onNew2ddPage.saveMaterialWith(new2ddDetails);
    	 
    }
    
    public void clickAddNew2aWith(PageDetail new2ddDetails) throws InterruptedException
    {
    	 NormalPage onNew2ddPage = pageStore.get(NormalPage.class);
    	 onNew2ddPage.saveMaterialWith(new2ddDetails);
    	 
    }
    public void goToAttachPage(List<AttachmentDetail> attachmentDetail) {
    	AttachmentFilePage onAttachPage = pageStore.get(AttachmentFilePage.class);
    	onAttachPage.saveAllAttachFiles(attachmentDetail);
    }
    
    
}
