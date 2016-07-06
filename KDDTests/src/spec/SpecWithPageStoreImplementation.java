package spec;


import domain.LoginDetails;
import pageFactoryImpl.LoginPage;

import scenarios.PageStore;


public class SpecWithPageStoreImplementation {


    LoginPage onLoginPage;

    PageStore pageStore;


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

    
}
