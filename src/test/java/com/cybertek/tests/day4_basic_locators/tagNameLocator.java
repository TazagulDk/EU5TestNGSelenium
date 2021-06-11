package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browser fullscreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        //sendkeys to fullname
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith with TagName");

        //sendkeys to email
        WebElement emailInput = driver.findElement(By.tagName("input"));
        emailInput.sendKeys("mike@smith.com");

        //lazy way to click button
        driver.findElement(By.tagName("button")).click();
    }
}
