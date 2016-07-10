package spec;


import domain.detail.account.LoginDetails;
import domain.detail.material.AddNew2ddDetails;
import page.account.HomePage;
import page.account.LoginPage;
import page.material.AddAttachFile2ddPage;
import page.material.AddNew2aPage;
import page.material.AddNew2ddPage;
import scenarios.PageStore;


public class SpecWithPageStoreImplementation {


    LoginPage onLoginPage;

    PageStore pageStore;
    HomePage onHomePage;
    AddAttachFile2ddPage onAttachPage;

    public SpecWithPageStoreImplementation(PageStore pageStore) {
        this.pageStore = pageStore;
    }


    public SpecWithPageStoreImplementation(LoginPage onLoginPage) {
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
    
    public void clickAddNew2ddWith(AddNew2ddDetails new2ddDetails) throws InterruptedException
    {
    	 AddNew2ddPage onNew2ddPage = pageStore.get(AddNew2ddPage.class);
    	 onNew2ddPage.save2ddWith(new2ddDetails);
    	 
    }
    
    public void clickAddNew2aWith(AddNew2ddDetails new2ddDetails) throws InterruptedException
    {
    	 AddNew2aPage onNew2ddPage = pageStore.get(AddNew2aPage.class);
    	 onNew2ddPage.save2ddWith(new2ddDetails);
    	 
    }
    public void goToAttachPage() throws Exception{
    	onAttachPage = pageStore.get(AddAttachFile2ddPage.class);
    	onAttachPage.saveAllAttachFiles();
    }
    
    
}
