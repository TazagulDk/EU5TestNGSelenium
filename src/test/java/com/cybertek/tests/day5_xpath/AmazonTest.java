package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /*
    go to Amazon
    search for selenium
    click search button
    verify 1-48 of 304 results for selenium
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.get("https://www.amazon.com/");
        WebElement searchtab = driver.findElement(By.id("twotabsearchtextbox"));
        searchtab.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String resultText = result.getText();
        System.out.println("Text = " + resultText);

        String expectedResult = "1-48 of over 348 results for";


        if(expectedResult.equals(resultText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
