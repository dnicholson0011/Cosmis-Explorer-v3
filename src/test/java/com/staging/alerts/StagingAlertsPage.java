package com.staging.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class StagingAlertsPage {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        driver.manage().window().maximize();

        // Verify alert box

        driver.findElement(By.id("alertexamples")).click();

        Alert alert = driver.switchTo().alert();

        String actualAlertText = alert.getText();
        String expectedAlertText = "I am an alert box!";

        Assert.assertEquals(actualAlertText, expectedAlertText, "Actual text does not match expected text");

        alert.accept();

        // Verify confirm box

        driver.findElement(By.id("confirmexample")).click();

        String actualDismissText = alert.getText();
        String expectedDismissText = "You clicked Cancel, confirm returned ";
        System.out.println(actualDismissText);

        alert.dismiss();

        driver.findElement(By.id("confirmexample")).click();

        String actualAcceptText = alert.getText();
        String expectedAcceptText = "You clicked OK, confirm returned ";
        System.out.println(actualAcceptText);

        alert.accept();

        // Verify prompt box

        // Teardown

//        driver.quit();
    }
}
