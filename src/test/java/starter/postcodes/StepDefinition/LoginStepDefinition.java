package starter.postcodes.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.postcodes.step.Login;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition {

    @Steps
    Login login;

    @When("I click login button with valid email is {string} and valid password is {string}")
    public void iClickLogin(String email, String password) {
        login.PostLogin(email, password);
    }

    @Then("Login Success")
    public void loginSuccess() {
        SerenityRest.then()
                .statusCode(200);
    }

    @Then("Login Account with token is {string}")
    public void VerifyUserLogin(String token) {
        SerenityRest.then()
                .body("token",equalTo(token));
    }


}