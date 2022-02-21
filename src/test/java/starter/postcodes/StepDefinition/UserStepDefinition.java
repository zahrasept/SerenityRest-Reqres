package starter.postcodes.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.postcodes.step.SingleUser;
import starter.postcodes.step.UserList;
import starter.postcodes.utility.UserResponse.UserDetailResponse;
import starter.postcodes.utility.UserResponse.UserListResponse;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;


public class UserStepDefinition {

    @Steps
    UserList userList;

    @Steps
    SingleUser singleUser;

    @When("I request list of user in page {int}")
    public void irequestListOfUserInPage(int pageNumber){
        userList.fetchUserList(pageNumber);
    }

    @Then("The system send {int} user in the list")
    public void theSystemSendUserInTheList (int totalUser){
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(UserListResponse.total,equalTo(totalUser)));
    }

    @And("the first user is {string}")
    public void theFirstUserIsMichael (String firstUser) {
    }

    @When("I click on user number {int}")
    public void iClickOnUserNumber(int userNumber){

        singleUser.fetchSingleUser(userNumber);
    }

    @Then("The system send user with name {string}")
    public void theSystemSendUserWithnName (String userName){
        restAssuredThat(response->response.statusCode(200));
        restAssuredThat(response-> response.body(UserDetailResponse.userName,equalTo(userName)));
    }

}
