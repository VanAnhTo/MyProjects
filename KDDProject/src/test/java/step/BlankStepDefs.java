package step;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.account.LoginDetailBuilder;
import domain.detail.account.LoginDetails;
import scenarios.base.BaseScenario;
import spec.Specification;

public class BlankStepDefs {
	public WebDriver driver;
	public LoginDetailBuilder builder;
	protected BaseScenario baseScenario;
	
	public BlankStepDefs() throws IOException {
		driver = Hooks.driver;
		builder = new LoginDetailBuilder();
		baseScenario = new BaseScenario(driver);
	}

	@Given("^I open pharmacy website$")
	public void i_open_pharmacy_website() throws Throwable {
		driver.get("http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul");
	}

	@When("^I enter username: \"(.*)\"$")
	public void i_enter_username(String username) throws Throwable {
		builder.withUsername(username);

	}

	@And("^I enter password: \"(.*)\"$")
	public void i_enter_password(String password) throws Throwable {
		builder.withPassword(password);

	}

	@Then("^I get homepage$")
	public void i_get_homepage() throws Throwable {
		LoginDetails loginDetails = builder.build();
		baseScenario.user.clickLoginWith(loginDetails);
	}

}