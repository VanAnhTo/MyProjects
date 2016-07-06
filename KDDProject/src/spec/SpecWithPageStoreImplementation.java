package spec;


import domain.AddNew2ddDetails;
import domain.LoginDetails;
import pageFactoryImpl.AddNew2ddPage;
import pageFactoryImpl.HomePage;
import pageFactoryImpl.LoginPage;

import scenarios.PageStore;


public class SpecWithPageStoreImplementation {


    LoginPage onLoginPage;

    PageStore pageStore;
    HomePage onHomePage;

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
    	onHomePage.goToCreate2dddPage();
    }
    
    public void clickAddNew2ddWith(AddNew2ddDetails new2ddDetails) throws InterruptedException
    {
    	 AddNew2ddPage onNew2ddPage = pageStore.get(AddNew2ddPage.class);
    	 onNew2ddPage.save2ddWith(new2ddDetails);
    	 
    }

    
}
