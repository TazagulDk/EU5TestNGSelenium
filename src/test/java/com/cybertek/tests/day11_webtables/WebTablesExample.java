package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.className("jyfHyd")).click();
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("John"));
    }
    @Test
    public void getAllHeaders(){
        //how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Headers size = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }
    @Test
    public void printTableSize(){
        //how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Headers size = " + headers.size());

        //number of rows with Headers
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
    }
    @Test
    public void getRow(){
        //print the second row information
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());

        //get all rows dynamically
        //1.find number of rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2.iterate one by one
        for (int i = 1; i <= numRows.size(); i++) {
             WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i + "-" + row.getText());
        }
    }
    @Test
    public void  getAllCellInOneRow(){
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());
    }

    @Test
    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRow();
        int colNumber =getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through each cell in the row (column)
            for (int j = 1; j <= colNumber; j++) {
                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }

        }
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstName = "Jason";

        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRow() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();
    }

}
