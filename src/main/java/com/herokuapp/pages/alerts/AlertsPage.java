package com.herokuapp.pages.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsPage {

    private WebDriver driver;
    private By alertBox = By.id("alertexamples");
    private By confirmBox = By.id("confirmexample");
    private By confirmReturnMessage = By.id("confirmreturn");
    private By confirmExplanation = By.id("confirmexplanation");
    private By promptBox = By.id("promptexample");
    private By promptReturnMessage = By.id("promptreturn");
    private By promptExplanation = By.id("promptexplanation");
    private By indexUrl = By.cssSelector("a[href='../index.html']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getIndexUrl() {
        return driver.findElement(indexUrl);
    }

    public WebElement getAlertBox() {
        return driver.findElement(alertBox);
    }

    public WebElement getConfirmBox() {
        return driver.findElement(confirmBox);
    }

    public WebElement getConfirmReturnMessage() {
        return driver.findElement(confirmReturnMessage);
    }

    public WebElement getConfirmExplanation() {
        return driver.findElement(confirmExplanation);
    }

    public WebElement getPromptBox() {
        return driver.findElement(promptBox);
    }

    public WebElement getPromptReturnMessage() {
        return driver.findElement(promptReturnMessage);
    }

    public WebElement getPromptExplanation() {
        return driver.findElement(promptExplanation);
    }
}
