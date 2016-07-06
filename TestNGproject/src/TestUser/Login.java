package TestUser;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePageObject;
import page.LoginPageObject;



public class Login extends BaseScenario  {

	// Use the application driver
/*	WebDriver driver;
	LoginPageObject onLoginPage;
	HomePageObject onHomePage;
	// SpecDefinition user ;
	SpecWithPageStoreImplementation user ;
	PageStore pageStore;

	@BeforeMethod
	public void setup(){
		 //launch the application under test
        driver = new AppDriver().getDriver();
        driver.get("http://localhost/selenium-digitest/wp-login.php");
        //onLoginPage = new LoginPageObject(driver);
        onLoginPage = PageFactory.initElements(driver, LoginPageObject.class);
        user = new SpecDefinition(onLoginPage);
		 

		//chap 9
		pageStore = new PageStore();
		user = new SpecWithPageStoreImplementation(pageStore);
		//launch the application under test
		driver = pageStore.getDriver();
		driver.get("http://localhost/selenium-digitest/wp-login.php");
		given(user).enterLoginForm();


	}*/
	
	//CHap 11
	@Test
	public void testLogin() throws InterruptedException{
		LoginDetails loginDetails = new LoginDetailsBuilder().
				withUsername("admin").withPassword("123456").
				build();
		given(user).enterLoginForm();
		when(user).loginWith(loginDetails);
		then(user).hasOptionsAvailableForHisCrendtial();

	}
	
	@Test
	public void testLoginFail() throws InterruptedException{
		LoginDetailsBuilder builder =   new LoginDetailsBuilder();
		// thong tin thuoc
		builder.withUsername("hoangnl");
		builder.withPassword("1233");
		
		// thong tin don hang
		builder.withUsername("hoangnl");
		builder.withPassword("1233");
		builder.withUsername("hoangnl");
		builder.withPassword("1233");
		builder.withUsername("hoangnl");
		builder.withPassword("1233");
		
		LoginDetails loginDetails = builder.build();
		given(user).enterLoginForm();
		when(user).loginWith(loginDetails);
		then(user).hasOptionsAvailableForHisCrendtial();

	}
	

	/*@Test
	public void testLogin() throws InterruptedException{

		onLoginPage.enterUserName("admin");
    	onLoginPage.enterPassword("123456");
    	onHomePage = onLoginPage.login();
    	AssertJUnit.assertTrue(onHomePage.resultsAppearForOutboundJourney());

		 chap  4+2 
		LoginDetails loginDetails = new LoginDetailsBuilder().
				withUsername("admin").withPassword("123456").
				build();
		 chap 7
    	onHomePage = onLoginPage.login(loginDetails);
    	Assert.assertTrue(onHomePage.resultsAppearForOutboundJourney());
		 

		 chap 8
		when(user).loginWith(loginDetails);
		then(user).hasOptionsAvailableForHisCrendtial();

	}*/



/*	@AfterMethod
	public void teardown(){
		//close the browser
		driver.close();

	}*/
	
	
    /* CHap 10
    protected <T extends SpecWithPageStoreImplementation> T given(T dsl) {
        return dsl;
    }

    protected <T extends SpecWithPageStoreImplementation> T when(T dsl) {
        return dsl;
    }

    protected <T extends SpecWithPageStoreImplementation> T then(T dsl) {
        return dsl;
    }

    protected <T extends SpecWithPageStoreImplementation> T and(T dsl) {
        return dsl;
    }*/





}
