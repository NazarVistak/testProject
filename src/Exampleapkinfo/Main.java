package Exampleapkinfo;

import Exampleapkinfo.HomePage;
import Exampleapkinfo.Preferences;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
public static AndroidDriver<MobileElement> driver;
public static DesiredCapabilities capabilities;
    public static void main(String[] args) {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        

        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName","UIAutomator1");

        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        HomePage h = new HomePage(driver);
        Preferences p = new Preferences(driver);
        Dependencies d = new Dependencies(driver);
        //driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        h.Apidemos.click();
        h.Preferences.click();
        p.PreferenceDependencies.click();
        d.WifiCheckbox.get(0).click();
        driver.findElementById("android:id/checkbox").click();
        //Our specific statements (Find element using Id property)
        //driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        //driver.findElementById("com.google.android.calculator:id/digit_1").click();


    }
}
