package spec;


import domain.detail.account.LoginDetails;
import domain.detail.material.PageDetail;
import page.account.HomePage;
import page.account.LoginPage;
import page.material.add.AttachmentFilePage;
import page.material.add.NormalPage;
import page.material.add.SpecialOfNormalPage;
import util.PageStore;


public class Specification {


    LoginPage onLoginPage;

    PageStore pageStore;
    HomePage onHomePage;
    AttachmentFilePage onAttachPage;

    public Specification(PageStore pageStore) {
        this.pageStore = pageStore;
    }


    public Specification(LoginPage onLoginPage) {
        this.onLoginPage = onLoginPage;
    }

    public void clickLoginWith(LoginDetails loginDetails) {
        LoginPage onLoginPage = pageStore.get(LoginPage.class);
        onLoginPage.loginToMainPage(loginDetails);
        
    }
    
    public void goToAddNew2ddPage() throws InterruptedException{
    	onHomePage = pageStore.get(HomePage.class);
    	onHomePage.goToCreate2ddPage();
    }
    public void goToAddNew2aPage() throws InterruptedException{
    	onHomePage = pageStore.get(HomePage.class);
    	onHomePage.goToCreate2aPage();
    }
    
    public void clickAddNew2ddWith(PageDetail new2ddDetails) throws InterruptedException
    {
    	 SpecialOfNormalPage onNew2ddPage = pageStore.get(SpecialOfNormalPage.class);
    	 onNew2ddPage.save2ddWith(new2ddDetails);
    	 
    }
    
    public void clickAddNew2aWith(PageDetail new2ddDetails) throws InterruptedException
    {
    	 NormalPage onNew2ddPage = pageStore.get(NormalPage.class);
    	 onNew2ddPage.save2ddWith(new2ddDetails);
    	 
    }
    public void goToAttachPage() throws Exception{
    	onAttachPage = pageStore.get(AttachmentFilePage.class);
    	onAttachPage.saveAllAttachFiles();
    }
    
    
}
