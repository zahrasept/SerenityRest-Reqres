package starter.postcodes.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.postcodes.step.Register;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegistrasiStepDefinition {

    @Steps
    Register register;

    @When("I create new Account with a valid email is {string} and password is {string}")
    public void iCreateNewAccount(String email, String password) {
        register.PostNewAccount(email,password);
    }

    @Then("Register Successful")
    public void registerSuccessful(){
        SerenityRest.then()
                .statusCode(200);
    }

    @And("New Account with token is {string}")
    public void VerifyNewAccount(String token){
        SerenityRest.then()
                .body("token",equalTo(token));
    }

}