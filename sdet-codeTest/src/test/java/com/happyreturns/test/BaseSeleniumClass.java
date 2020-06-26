package com.happyreturns.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseSeleniumClass extends DriverBase {

    public static void main(String[] args) throws Exception {

        System.out.println(navigateToGoogle());

    }

    /**
     *  CHALLENGE :
     *  For our challenge, we need to create a Selenium test that navigates to Google.com
     *  and performs a search for "Happy Returns".
     *
     *  After the results are displayed, assert that www.happyreturns.com is the first result
     *  returned from Google.
     *
     *  Notes : Feel free to create classes, rename this class, approach this challenge however you'd like.
     *  Keep it simple or get fancy with it if you have time.
     *
     *  Time: 30 minutes
     *
     **/



    public static Boolean navigateToGoogle() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");


        WebElement searchButton = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        searchButton.sendKeys("Happy Returns" + Keys.ENTER);

        List<WebElement> links = new ArrayList<>();
        links = driver.findElements(By.xpath("//cite"));
        String expected = "www.happyreturns.com/";
        String actualLink = links.get(0).getText().toString();
        System.out.println("actualLink = " + actualLink);

        if (expected.contains(actualLink)) {
            return true;

        } else {
            return false;
        }

    }
}

