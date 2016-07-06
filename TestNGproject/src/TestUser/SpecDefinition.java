package TestUser;

import org.testng.Assert;
import page.HomePageObject;
import page.LoginPageObject;

public class SpecDefinition {
	
	LoginPageObject onLoginPage;
    HomePageObject onHomePage;
	

    public SpecDefinition(LoginPageObject onLoginPage) {
        this.onLoginPage = onLoginPage;
    }

    public SpecDefinition loginWith(LoginDetails loginDetails) {
    	onHomePage = onLoginPage.login(loginDetails);
        return this;
    }

    public SpecDefinition hasOptionsAvailableForHisCrendtial() throws InterruptedException {
    	Assert.assertTrue(onHomePage.resultsAppearForOutboundJourney());
        return this;
    }

}
