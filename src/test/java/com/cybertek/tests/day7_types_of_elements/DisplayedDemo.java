package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("username is displayed: " + usernameInput.isDisplayed());

       Assert.assertFalse(usernameInput.isDisplayed(),"verify username is not displayed on the screen");

        driver.findElement(By.cssSelector("#start>button")).click();

        Thread.sleep(6000);

        Assert.assertTrue(usernameInput.isDisplayed(), "verify username is displayed on the screen");

        driver.quit();
       }
    }

