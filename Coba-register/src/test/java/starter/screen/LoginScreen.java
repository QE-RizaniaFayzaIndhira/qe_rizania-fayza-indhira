package starter.screen;

import io.appium.java_client.AppiumBy;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import test.automation.pageobject.BasePageObject;

public class LoginScreen extends BasePageObject {
    private By loginButton() {
        return AppiumBy.id("appCompatButtonLogin");
    }

    private By register(){
        return AppiumBy.id("textViewLinkRegister");
    }

    @Step
    public void onLoginScreen() {
        Assert.assertTrue(waitUntilVisible(loginButton()).isDisplayed());
    }

    @Step
    public void tapRegister(){
        onClick(register());
    }
}
