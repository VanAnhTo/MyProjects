package TestUser;


import org.testng.Assert;

import page.HomePageObject;
import page.LoginPageObject;



public class SpecWithPageStoreImplementation {


	LoginPageObject onLoginPage;
    HomePageObject onHomePage;
    PageStore pageStore;


    public SpecWithPageStoreImplementation(PageStore pageStore) {
        this.pageStore = pageStore;
    }


    public SpecWithPageStoreImplementation(LoginPageObject onLoginPage) {
        this.onLoginPage = onLoginPage;
    }
    public void enterLoginForm() {
    	onLoginPage = pageStore.get(LoginPageObject.class);
       
    }
    public void loginWith(LoginDetails loginDetails) {
 
        
        LoginPageObject onLoginPage = pageStore.get(LoginPageObject.class);
        onLoginPage.login(loginDetails);
        
    }
    
    public void hasOptionsAvailableForHisCrendtial() throws InterruptedException {

        Assert.assertTrue(pageStore.get(HomePageObject.class).resultsAppearForOutboundJourney());
    }

}
