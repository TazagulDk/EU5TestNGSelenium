package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) {
       /*Verify URL not changed
       -open chrome browser
       - go to http://practice.cybertekschool.com/forgot_password
       - click on  Retrieve password button
       - verify that url did not change
        */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();

        //click on  Retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save expected url afterclicking button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not change
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close ur browser
        driver.quit();






    }
}
