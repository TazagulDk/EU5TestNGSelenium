package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate ur dropdown
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
    }

        @Test
        public void test2() throws InterruptedException {

            driver.get("http://practice.cybertekschool.com/dropdown");

            //1.locate ur dropdown
            WebElement dropdownElement = driver.findElement(By.id("state"));

            //2.create Select object by passing that element as a constructor
            Select stateDropdown = new Select(dropdownElement);

            //verify that first selection is Select a state
            String expectedOption = "Select a State";
            String actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify first selection");

            //HOW TO SELECT OPTIONS FROM DROPDOWN?
            //1. select using visible text
            Thread.sleep(2000);
            stateDropdown.selectByVisibleText("Virginia");

            expectedOption = "Virginia";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify selected option");

            //2. select using index
            Thread.sleep(2000);
            stateDropdown.selectByIndex(51);

            expectedOption = "Wyoming";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify selected option");

            //3. select by value
            Thread.sleep(2000);
            stateDropdown.selectByValue("TX");

            expectedOption = "Texas";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify selected option");

        }
    }

