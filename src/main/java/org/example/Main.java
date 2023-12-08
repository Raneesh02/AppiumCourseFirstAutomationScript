package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:automationName","UIAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.android.settings");
        capabilities.setCapability("newCommandTimeout",120);
        capabilities.setCapability("appActivity","com.android.settings.Settings");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("com.android.settings:id/search_action_bar_title")).click();
        driver.findElement(By.id("com.google.android.settings.intelligence:id/open_search_view_edit_text")).sendKeys("Battery");
        driver.findElement(By.id("android:id/switch_widget")).click();
        driver.quit();

    }
}