package com.hike.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumCapabilities {

    protected static AndroidDriver driver;


    public AppiumCapabilities() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
			try {
				createNewDriverInstance();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    private void createNewDriverInstance() throws MalformedURLException {
    	boolean sessionCreated = false;
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/" + System.getProperty("user.name") + "/Downloads/hike.apk");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bsb.hike");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ui.HomeActivity");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		desiredCapabilities.setCapability("udid", "b9ab9b86");
		desiredCapabilities.setCapability("chromedriverExecutable","./res/chromedriver");
		while(!sessionCreated) {
			try {
				driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
				sessionCreated = true;
			} catch(SessionNotCreatedException e) {
				sessionCreated = false;
			}
		}
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}