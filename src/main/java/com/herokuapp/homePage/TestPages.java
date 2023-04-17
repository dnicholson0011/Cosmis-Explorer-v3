package com.herokuapp.homePage;

import com.herokuapp.pages.BasicWebPageExamplePage;
import com.herokuapp.pages.ElementAttributesExamplesPage;
import com.herokuapp.pages.LocatorsExamplesPage;
import com.herokuapp.pages.alerts.AlertsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPages {

    private WebDriver driver;
    private By Basic_Web_Page_Example_Url = By.id("basicpagetest");
    private By Element_Attributes_Examples_Url = By.id("elementattributestest");
    private By Locator_Examples_Url = By.id("findbytest");
    private By alerts_Url = By.id("alerttest");

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

    public ElementAttributesExamplesPage getElement_Attributes_Examples_Url() {
        driver.findElement(Element_Attributes_Examples_Url).click();
        return new ElementAttributesExamplesPage(driver);
    }

    public LocatorsExamplesPage getLocator_Examples_Url() {
        driver.findElement(Locator_Examples_Url).click();
        return new LocatorsExamplesPage(driver);
    }

    public AlertsPage getAlerts_Url() {
        driver.findElement(alerts_Url).click();
        return new AlertsPage(driver);
    }
}
