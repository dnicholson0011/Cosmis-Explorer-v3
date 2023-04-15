package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class LocatorsExamplesPage {

    WebDriver driver;
    private By indexUrl = By.cssSelector("a[href='index.html']");

    public LocatorsExamplesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getIndexUrl() {
        return driver.findElement(indexUrl);
    }

    public List<String> getParagraphTextList() {
        List<String> paragraphTextList = new ArrayList<String>();
        for (int i = 1; i <= 25; i++) {
            String paragraphId = "p" + i;
            By paragraphLocator = By.cssSelector("p[id='" + paragraphId + "']");
            WebElement paragraph = driver.findElement(paragraphLocator);
            String paragraphText = paragraph.getText();
            paragraphTextList.add(paragraphText);
        }
        return paragraphTextList;
    }

    public List<String> getNestedParagraphTextList() {
        List<String> nestedParagraphTextList = new ArrayList<String>();
        for (int i = 26; i <= 41; i++) {
            String paragraphId = "p" + i;
            By paragraphLocator = By.cssSelector("p[id='" + paragraphId + "'] > p");
            List<WebElement> nestedParagraphElements = driver.findElements(paragraphLocator);
            for (WebElement nestedParagraphElement : nestedParagraphElements) {
                String nestedParagraphText = nestedParagraphElement.getText();
                nestedParagraphTextList.add(nestedParagraphText);
            }
        }
        return nestedParagraphTextList;
    }

    public boolean clickJumpLinkAndCheckParagraph(int index) {
        String linkId = "a" + (index + 26);
        By linkLocator = By.cssSelector("a[id='" + linkId + "']");
        WebElement link = driver.findElement(linkLocator);
        link.click();

        String paragraphId = "p" + (index + 1);
        By paragraphLocator = By.cssSelector("p[id='" + paragraphId + "']");
        WebElement paragraph = driver.findElement(paragraphLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", paragraph);

        return paragraph.isDisplayed();
    }
}
