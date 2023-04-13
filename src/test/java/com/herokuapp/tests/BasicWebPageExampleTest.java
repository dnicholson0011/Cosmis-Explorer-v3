package com.herokuapp.tests;

import com.herokuapp.base.Base;
import com.herokuapp.pages.BasicWebPageExamplePage;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicWebPageExampleTest extends Base {

    @Parameters({"basicWebPageTitle", "paragraph01Text", "paragraph02Text"})
    @Test
    public void verifyParagraphs(String basicWebPageTitle, String paragraph01Text, String paragraph02Text) {
        try {
            // Navigate to page
            BasicWebPageExamplePage basicWebPageExamplePage = testPages.getBasic_Web_Page_Example_Url();

            // Verify title
            String actualTitle = basicWebPageExamplePage.getPageTitle();
            Assert.assertEquals(actualTitle, basicWebPageTitle, "Page title does not match expected title");

            // Verify paragraph 1 text
            String actualParagraph01Text = basicWebPageExamplePage.getParagraph01Text().getText();
            Assert.assertEquals(actualParagraph01Text, paragraph01Text, "Paragraph 01 text does not match expected text");

            // Verify paragraph 2 text
            String actualParagraph02Text = basicWebPageExamplePage.getParagraph02Text().getText();
            Assert.assertEquals(actualParagraph02Text, paragraph02Text, "Paragraph 02 text does not match expected text");

            // Navigate to homepage
            basicWebPageExamplePage.getIndexUrl().click();
        } catch (WebDriverException e) {
            System.out.println("Error: WebDriverException: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
