package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("title","title ");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {

        System.out.println("Second test case");
        Assert.assertEquals("text", "text");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
}
