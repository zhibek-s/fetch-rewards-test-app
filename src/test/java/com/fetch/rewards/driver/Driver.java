package com.fetch.rewards.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private static final String DEVICE = "Android Emulator";
    private static final String PLATFORM = "Android";
    private static final String APP = "/Users/zhibeksabyrova/Downloads/facebook-294-0-0-16-118.apk";

    public static WebDriver getDriver(String device) throws InterruptedException {
        if (driver != null) {
            return driver;
        }
        if ("android".equalsIgnoreCase(device)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", DEVICE);
            capabilities.setCapability("app", APP);
            capabilities.setCapability("platformName", PLATFORM);

            AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
            appiumServiceBuilder.withCapabilities(capabilities)
                    .withIPAddress("0.0.0.0")
                    .usingPort(4723);
            AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
            service.start();
            Thread.sleep(10000);

            AndroidDriver<WebElement> androidDriver = new AndroidDriver<WebElement>(service.getUrl(), capabilities);

            androidDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            androidDriver.resetApp();
            Thread.sleep(30000);
            androidDriver.context("NATIVE_APP");
            driver = androidDriver;
        }
        return driver;
    }

}