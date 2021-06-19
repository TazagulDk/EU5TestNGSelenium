package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("driver.getTitle()  before new window = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        //System.out.println("driver.getTitle() after new window = " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("driver.getTitle() after new window = " + driver.getTitle());

    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("driver.getTitle()  before new window = " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);

            //whenever ur title equals to ur expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }

        }
        System.out.println("After switch title: " + driver.getTitle());
    }
}
