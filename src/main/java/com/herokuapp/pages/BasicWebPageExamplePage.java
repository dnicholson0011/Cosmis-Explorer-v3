package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicWebPageExamplePage {
    private WebDriver driver;
    private By paragraph01 = By.id("para1");
    private By paragraph02 = By.id("para2");
    private By indexUrl = By.cssSelector("a[href='index.html']");

    public BasicWebPageExamplePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickIndexUrl() {
        driver.findElement(indexUrl).click();
    }

    public String getParagraph01Text() {
        return driver.findElement(paragraph01).getText();
    }

    public String getParagraph02Text() {
        return driver.findElement(paragraph02).getText();
    }
}
