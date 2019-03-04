import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class AppiumTestClass {
    public AppiumDriver<MobileElement> driver;
//    public WebDriver webDriver;


    @Before
    public void setup(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5X API 28");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("appPackage", "com.hv.totalmama");
        caps.setCapability("appActivity","com.hv.totalmama.MainActivity");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
//            webDriver =  new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClicks() throws Exception{
        MobileElement e1 = driver.findElementById("txtHello");
        e1.click();
    }
}
