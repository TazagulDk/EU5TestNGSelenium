package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC6_8 {
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
    public void test6(){
        driver.get("https://www.fakemail.net/");

        WebElement email= driver.findElement(By.id("email"));
        String mail = email.getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Tazagul Duishobai");
        driver.findElement(By.name("email")).sendKeys(mail);

        driver.findElement(By.name("wooden_spoon")).click();

        String text = driver.findElement(By.xpath("//body/h1")).getText();
        System.out.println(text);

        driver.navigate().to("https://www.fakemail.net/");

        WebElement fakeMail = driver.findElement(By.xpath("//tr[2]/td[1]/span[2]"));
        Assert.assertTrue(fakeMail.equals(fakeMail));

        driver.findElement(By.xpath("//tr[2]/td[1]/span[1]")).click();

        WebElement firstMail = driver.findElement(By.cssSelector("#odesilatel"));
        Assert.assertTrue(firstMail.equals(driver.findElement(By.cssSelector("#odesilatel"))));

        WebElement subject = driver.findElement(By.cssSelector("#predmet"));
        String subjectText = subject.getText();
        Assert.assertEquals(subjectText,"Welcome to FakeMail");

    }

    @Test
    public void test7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();

        driver.findElement(By.name("file")).sendKeys("C:\\Users\\59645\\OneDrive - Grundfos\\Desktop\\file.txt");

        driver.findElement(By.id("file-submit")).click();

        WebElement header = driver.findElement(By.xpath("//h3"));
        String headerText = header.getText();
        Assert.assertEquals(headerText, "File Uploaded!");

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,"file.txt");
    }

    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.xpath("//form/input")).click();

        String text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, "You selected: United States of America");
    }
}
