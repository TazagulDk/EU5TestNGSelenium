package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {
    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        //how to verify checkbox is selected or not?
        System.out.println("checkbox1: " + checkbox1.isSelected());
        System.out.println("checkbox2: " + checkbox2.isSelected());

        //verify checkbox 1 is not selected, 2 is selected
        Assert.assertFalse((checkbox1.isSelected()),"verify checkbox 1 is not selected");
        Assert.assertTrue((checkbox2.isSelected()),"verify checkbox 2 is selected");

        //how to click checkboxes?
        checkbox1.click();

    }
}
