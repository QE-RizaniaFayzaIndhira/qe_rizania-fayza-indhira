package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.screen.LoginScreen;
import starter.screen.RegisterScreen;

public class RegisterSteps {
    @Steps
    LoginScreen loginScreen;
    RegisterScreen registerScreen;

    @Given("user on the login screen")
    public void userOnTheLoginScreen() {
        loginScreen.onLoginScreen();
    }

    @And("user click {string}")
    public void userClick(String arg0) {
        loginScreen.tapRegister();
    }

    @When("user input valid name")
    public void userInputValidName() {
        registerScreen.inputName("riza");
    }

    @And("user input valid email for register")
    public void userInputValidEmailForRegister() {
        registerScreen.inputEmail("riza@gmail.com");
    }

    @And("user input valid password for register")
    public void userInputValidPasswordForRegister() {
        registerScreen.inputPassword("riza");
    }

    @And("user input valid confirm password")
    public void userInputValidConfirmPassword() {
        registerScreen.inputConfirmPassword("riza");
    }

    @And("user click register button")
    public void userClickRegisterButton() {
        registerScreen.tapRegisterButton();
    }

    @Then("user view {string}")
    public void userView(String arg0) {
        registerScreen.viewRegistrationSuccess();
    }
}
