package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW_test2 {
    /*
    Go to Ebay
search Selenium
click on search button
verify title contains Selenium
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.get("https://www.ebay.com/");
        WebElement searchtab = driver.findElement(By.xpath("//input[@type='text']"));
        searchtab.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();

        String title = driver.getTitle();

        if(title.contains("selenium")){
            System.out.println("Title contains Selenium");
        }else{
            System.out.println("no Selenium in the title");
        }

        driver.quit();
    }
}
