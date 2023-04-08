package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.User.POST_a_new_user;

public class POST_a_new_userSteps {
    @Steps
    POST_a_new_user post_a_new_user;
    @Given("user set POST endpoint for new user")
    public void userSetPOSTEndpointForNewUser() {
        post_a_new_user.setPostEndpointForNewUser();
    }

    @When("user send POST HTTP request for new user")
    public void userSendPOSTHTTPRequestForNewUser() {
        post_a_new_user.sendPOSTHTTPRequestForNewUser();
    }

    @Then("user received HTTP response code {int} for new user")
    public void userReceivedHTTPResponseCodeForNewUser(int arg0) {
        post_a_new_user.validateHTTPResponseCode200ForNewUser();
    }

    @Given("user set POST endpoint with invalid query parameter for new user")
    public void userSetPOSTEndpointWithInvalidQueryParameterForNewUser() {
        post_a_new_user.setPostEndpointWithInvalidQueryParameterForNewUser();
    }

    @When("user send POST HTTP request with invalid query parameter for new user")
    public void userSendPOSTHTTPRequestWithInvalidQueryParameterForNewUser() {
        post_a_new_user.sendPOSTHTTPRequestWithInvalidQueryParameterForNewUser();
    }

    @Then("user received POST HTTP response code {int} for new user")
    public void userReceivedPOSTHTTPResponseCodeForNewUser(int arg0) {
        post_a_new_user.validatePOSTHTTPResponseCode404ForNewUser();
    }

    @And("user received valid data for new user")
    public void userReceivedValidDataForNewUser() {
        post_a_new_user.validateValidNewUser();
    }
}
