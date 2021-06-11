package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) {

//        we have to enter this line every time we want to open chrome
//        her webdrivermanager, can you make chrome ready for my automation
       WebDriverManager.chromedriver().setup();

        //webdriver represents the driver
        //we are creating driver for chrome browser
        //new ChromeDriver()->this part will open chrome browser
       WebDriver driver = new ChromeDriver();

       driver.get("https://cybertekschool.com");




    }
}
