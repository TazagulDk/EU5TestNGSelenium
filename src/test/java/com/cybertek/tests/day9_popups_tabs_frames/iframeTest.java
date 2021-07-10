package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to witch frames
        //1.switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);

        //put mike smith
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //we have to switch back to main html
        //it is useful when we have multiple frames
        driver.switchTo().defaultContent();


        //2.switching with INDEX
        driver.switchTo().frame(0);
        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        //put mike smith
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame();


        //3.way of switching - by using webelement
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH WEBELEMENT");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //switching to frame-top
        driver.switchTo().frame("frame-top");

        //top has 3 frames under: left, middle and right
        //switch to middle frame
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        /*
        -we can only switch to child, cannot switch to grandchild
        -we cannot switch to sibling, it should go to parent in order to see child frames
        HTML (Default content)
           frame-top (parent frame)
               0 left
               1 middle
               2 right
           frame-bottom
         */

        //goes back to top frame
        driver.switchTo().parentFrame();

        //switching right index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //switching to frame-bottom
        driver.switchTo().defaultContent();

        //switching bottom frame
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
