package com.herokuapp.tests;

import com.herokuapp.base.Base;
import com.herokuapp.pages.LocatorsExamplesPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LocatorsExamplesTest extends Base {

    @Parameters("locatorsPageTitle")
    @Test
    public void verifyLocators(String locatorsPageTitle) throws InterruptedException {

        // Navigate to page
        LocatorsExamplesPage locatorsExamplesPage = testPages.getLocator_Examples_Url();

        // Verify title
        String actualTitle = locatorsExamplesPage.getPageTitle();
        Assert.assertEquals(actualTitle, locatorsPageTitle, "Page title does not match expected title");

        // Expected paragraph texts
        List<String> expectedParagraphTexts = Arrays.asList(
                "This is a paragraph text",
                "This is b paragraph text",
                "This is c paragraph text",
                "This is d paragraph text",
                "This is e paragraph text",
                "This is f paragraph text",
                "This is g paragraph text",
                "This is h paragraph text",
                "This is i paragraph text",
                "This is j paragraph text",
                "This is k paragraph text",
                "This is l paragraph text",
                "This is m paragraph text",
                "This is n paragraph text",
                "This is o paragraph text",
                "This is p paragraph text",
                "This is q paragraph text",
                "This is r paragraph text",
                "This is s paragraph text",
                "This is t paragraph text",
                "This is u paragraph text",
                "This is v paragraph text",
                "This is w paragraph text",
                "This is x paragraph text",
                "This is y paragraph text"
        );

        // Verify paragraph texts
        List<String> actualParagraphTexts = locatorsExamplesPage.getParagraphTextList();
        Assert.assertEquals(actualParagraphTexts, expectedParagraphTexts, "Paragraph texts do not match expected texts");

        // Expected nested paragraph text
        String expectedNestedParagraphText = "nested para text";

        // Verify nested paragraph texts
        List<String> actualNestedParagraphTexts = locatorsExamplesPage.getNestedParagraphTextList();
        for (String actualNestedParagraphText : actualNestedParagraphTexts) {
            Assert.assertEquals(actualNestedParagraphText, expectedNestedParagraphText, "Nested paragraph text does not match expected text");
        }
    }

    @Test(dependsOnMethods = "verifyLocators")
    public void verifyJumpLinks() {
        // Navigate to page
        LocatorsExamplesPage locatorsExamplesPage = testPages.getLocator_Examples_Url();

        // Click each jump link and verify if the corresponding paragraph is displayed in the viewport
        for (int i = 0; i <= 24; i++) {
            boolean isParagraphVisible = locatorsExamplesPage.clickJumpLinkAndCheckParagraph(i);
            Assert.assertTrue(isParagraphVisible, "Paragraph " + (i + 1) + " is not in viewport after clicking the jump link.");
        }

        // Navigate to homepage
        locatorsExamplesPage.getIndexUrl().click();
    }
}
