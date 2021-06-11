package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW_test1 {
    /*
    Go to Ebay
enter search term
click on search button
print number of results
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.get("https://www.ebay.com/");
        WebElement searchtab = driver.findElement(By.xpath("//input[@type='text']"));
        searchtab.sendKeys("search");

        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();

        WebElement text = driver.findElement(By.xpath("//div/h1"));
        System.out.println(text.getText());

        driver.quit();

    }
}
