package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_5 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        regForm.click();

        WebElement birthInput = driver.findElement(By.name("birthday"));
        birthInput.sendKeys("wrong_dob");

        WebElement text = driver.findElement(By.xpath("//div[8]/div/small[2]"));
        Assert.assertTrue(text.isDisplayed(),"The date of birth is not valid text is displayed");
    }

    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        regForm.click();

        WebElement checkbox1 = driver.findElement(By.id("inlineCheckbox1"));
        Assert.assertTrue(checkbox1.isDisplayed(),"checkbox1 is displayed");

        WebElement checkbox2 = driver.findElement(By.id("inlineCheckbox2"));
        Assert.assertTrue(checkbox2.isDisplayed(),"checkbox2 is displayed");

        WebElement checkbox3 = driver.findElement(By.id("inlineCheckbox3"));
        Assert.assertTrue(checkbox3.isDisplayed(),"checkbox3 is displayed");
    }
    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        regForm.click();

        WebElement input = driver.findElement(By.name("firstname"));
        input.sendKeys("T");

        WebElement warningMessage = driver.findElement(By.xpath("//form/div[1]/div/small[2]"));
        Assert.assertTrue(warningMessage.isDisplayed(), "first name must be more than 2 and less than 64 characters long is displayed");
    }

    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("lastname")).sendKeys("s");

        WebElement warning = driver.findElement(By.xpath("//form/div[2]/div/small[2]"));
        Assert.assertTrue(warning.isDisplayed(), "first name must be more than 2 and less than 64 characters long is displayed");
    }

    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("firstname")).sendKeys("Tazagul");
        driver.findElement(By.name("lastname")).sendKeys("Duishobai");
        driver.findElement(By.name("username")).sendKeys("Tazagul");
        driver.findElement(By.name("email")).sendKeys("kg.tazagul@gmail.com");
        driver.findElement(By.name("password")).sendKeys("09072018");
        driver.findElement(By.name("phone")).sendKeys("367-209-4411");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("06/26/1990");

        WebElement dropdownElement = driver.findElement(By.name("department"));
        Select departmentDropdown = new Select(dropdownElement);
        departmentDropdown.selectByVisibleText("Accounting Office");

        WebElement dropdownElement2 = driver.findElement(By.name("job_title"));
        Select jobDropdown = new Select(dropdownElement2);
        jobDropdown.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        WebElement text = driver.findElement(By.xpath("//div/p"));
        Assert.assertTrue(text.isDisplayed(), "verify text is displayed");
    }
}
