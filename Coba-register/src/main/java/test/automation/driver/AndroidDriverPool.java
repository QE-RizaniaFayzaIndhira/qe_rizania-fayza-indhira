package test.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverPool {
    public static AndroidDriver create() {
        String appiumUrl = "http://0.0.0.0:4723/wd/hub/";
        AndroidDriver driver = null;

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
//        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        caps.setCapability(MobileCapabilityType.NO_RESET, false);
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + File.separator + "app/app.apk");
//        caps.setCapability(String.valueOf(Setting.WAIT_FOR_IDLE_TIMEOUT), 100);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");

        try {
            driver = new AndroidDriver(new URL(appiumUrl), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
