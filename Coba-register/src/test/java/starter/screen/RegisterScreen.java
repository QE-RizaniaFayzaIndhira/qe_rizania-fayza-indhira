package starter.screen;

import io.appium.java_client.AppiumBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.automation.pageobject.BasePageObject;

public class RegisterScreen extends BasePageObject {
    private By emailField(){
        return AppiumBy.id("textInputEditTextEmail");
    }

    private By passwordField(){
        return AppiumBy.id("textInputEditTextPassword");
    }

    private By nameField(){
        return AppiumBy.id("textInputEditTextName");
    }

    private By confirmPasswordField(){
        return AppiumBy.id("textInputEditTextConfirmPassword");
    }

    private By registerButton(){
        return AppiumBy.id("appCompatButtonRegister");
    }

    private By registrationSuccess(){
        return AppiumBy.id("snackbar_text");
    }

    @Step
    public void inputName(String name){
        onType(nameField(), name);
    }

    @Step
    public void inputEmail(String email){
        onType(emailField(),email);
    }

    @Step
    public void inputPassword(String password){
        onType(passwordField(),password);
    }

    @Step
    public void inputConfirmPassword(String confirmPassword){
        onType(confirmPasswordField(), confirmPassword);
    }

    @Step
    public void tapRegisterButton(){
        onClick(registerButton());
    }

    @Step
    public String viewRegistrationSuccess(){
        return waitUntilVisible(registrationSuccess()).getText();
    }
}
