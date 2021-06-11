package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

       //task open chrome and navigate to webpage

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        //ALT+enter enter --> shortcut
        //getTitle() --> gets a title of the page
        String title = driver.getTitle();
        System.out.println("title = " + title); //soutv --> shortcut

        //to get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        
        //to get the source code of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


        


    }
}
