package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementAttributesExamplesPage {

    private WebDriver driver;
    private By paragraphAttributes = By.cssSelector("p[custom-attrib='attrib in source at load']");
    private By paragraphDynamicAttributes = By.id("jsattributes");
    private By addAnotherAttributeButton = By.className("styled-click-button");
    private By indexUrl = By.cssSelector("a[href='index.html']");

    public ElementAttributesExamplesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getIndexUrl() {
        return driver.findElement(indexUrl);
    }

    public WebElement getParagraphAttributes() {
        return driver.findElement(paragraphAttributes);
    }

    public WebElement getParagraphDynamicAttributes() {
        return driver.findElement(paragraphDynamicAttributes);
    }

    public WebElement getAttributeButton() {
        return driver.findElement(addAnotherAttributeButton);
    }

    public WebElement getCustomAttribute(int i) {
        String customAttribute = "p[custom-" + i + "='value-" + i + "']";
        return driver.findElement(By.cssSelector(customAttribute));
    }
}
