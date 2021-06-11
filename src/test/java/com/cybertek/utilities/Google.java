package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Google {

    public static void acceptGoogle() {
        WebDriver driverX = WebDriverFactory.getDriver("chrome");
        driverX.get("https://www.google.com/");
        driverX.findElement(By.className("jyfHyd")).click();
        driverX.quit();
    }
}
