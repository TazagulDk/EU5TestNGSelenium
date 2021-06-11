package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW2 {
/*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
   a. “Home” link
   b. “Forgot password” header
   c. “E-mail” text
   d. E-mail input box
   e. “Retrieve password” button
4.Print text of a,b,c,e and put some email to d
 */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement home = driver.findElement(By.xpath("//li/a[@class='nav-link']"));
        System.out.println("HOME button: " + home.getText());

        WebElement forgotPassword = driver.findElement(By.xpath("//div/h2"));
        System.out.println("Forgot Password Header: " + forgotPassword.getText());

        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println("email text: " + emailText.getText());

        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("email input box: " + emailBox.getText());
        emailBox.sendKeys("taza@gmail.com");

        WebElement retrievePassword = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        System.out.println("Retrieve Password Button: " + retrievePassword.getText());

        driver.quit();
    }
}
