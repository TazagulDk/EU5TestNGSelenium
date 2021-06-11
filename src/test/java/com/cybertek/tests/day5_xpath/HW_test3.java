package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW_test3 {
    /*
    Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)'
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.get("https://www.wikipedia.org/");
        WebElement searchtab = driver.findElement(By.id("searchInput"));
        searchtab.sendKeys("selenium webdriver");

        WebElement searchButton = driver.findElement(By.xpath("//button/i"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//span[@class='searchmatch']"));
        searchResult.click();

        String url = driver.getCurrentUrl();

        if(url.endsWith("Selenium_(software)")){
            System.out.println("URL ends with Selenium_(software)");
        }else{
            System.out.println("URL does not end with Selenium_(software)");
        }

        driver.quit();
    }
}
