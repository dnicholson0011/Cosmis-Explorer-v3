package com.herokuapp.homePage;

import com.herokuapp.pages.BasicWebPageExamplePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPages {

    private WebDriver driver;

    By Basic_Web_Page_Example_Url = By.id("basicpagetest");
    public TestPages(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public BasicWebPageExamplePage getBasic_Web_Page_Example_Url() {
        driver.findElement(Basic_Web_Page_Example_Url).click();
        return new BasicWebPageExamplePage(driver);
    }

    public void getUrl() {

    }
}
