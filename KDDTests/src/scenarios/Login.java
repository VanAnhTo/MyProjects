package scenarios;

import org.testng.annotations.Test;

import domain.LoginDetailBuilder;
import domain.LoginDetails;



public class Login extends BaseScenario{

    @Test
    public void testLoginSucessfull(){
        LoginDetails loginDetails = new LoginDetailBuilder().
        		withUsername("010203123").withPassword("123")
        		.build();
       
        given(user).clickLoginWith(loginDetails);

    }
}
