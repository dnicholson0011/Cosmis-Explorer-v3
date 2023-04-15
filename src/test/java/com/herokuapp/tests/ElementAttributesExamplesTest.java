package com.herokuapp.tests;

import com.herokuapp.base.Base;
import com.herokuapp.pages.ElementAttributesExamplesPage;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementAttributesExamplesTest extends Base {

    @Parameters({"elementAttributesPageTitle", "paragraphAttributesText", "paragraphDynamicAttributesText"})
    @Test
    public void verifyAttributes(String elementAttributesPageTitle, String paragraphAttributesText, String paragraphDynamicAttributesText) {

        try {
            // Navigate to page
            ElementAttributesExamplesPage elementAttributesExamplesPage = testPages.getElement_Attributes_Examples_Url();

            // Verify title
            String actualTitle = elementAttributesExamplesPage.getPageTitle();
            Assert.assertEquals(actualTitle, elementAttributesPageTitle, "Page title does not match expected title");

            // Verify the paragraph text
            String actualParagraphText = elementAttributesExamplesPage.getParagraphAttributes().getText();
            Assert.assertEquals(actualParagraphText, paragraphAttributesText, "Paragraph text does not match expected text");

            // Verify the dynamic paragraph text
            String dynamicAttributeValue = elementAttributesExamplesPage.getParagraphDynamicAttributes().getText();
            Assert.assertEquals(dynamicAttributeValue, paragraphDynamicAttributesText, "Dynamic paragraph text does not match expected text");

            // Verify the custom attribute
            for (int i = 1; i < 5; i++) {
                String expectedCustomAttributeValue = "value-" + i;
                elementAttributesExamplesPage.getAttributeButton().click();
                WebElement customAttribute = elementAttributesExamplesPage.getCustomAttribute(i);
                String actualCustomAttributeValue = customAttribute.getAttribute("custom-" + i);
                Assert.assertEquals(actualCustomAttributeValue, expectedCustomAttributeValue, "Custom attribute value does not match expected value");
            }

            // Navigate to homepage
            elementAttributesExamplesPage.getIndexUrl().click();
        } catch (WebDriverException e) {
            System.out.println("Error: WebDriverException: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
}

