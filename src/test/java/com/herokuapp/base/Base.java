package com.herokuapp.base;

import com.herokuapp.homePage.TestPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Base {

    private WebDriver driver;

    protected TestPages testPages;

    @Parameters({"testPageUrl", "homePageTitle"})
    @BeforeMethod
    public void setUp(String testPageUrl, String homePageTitle) {

        try {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(testPageUrl);

            testPages = new TestPages(driver);

            String actualTitle = testPages.getPageTitle();
            Assert.assertEquals(actualTitle, homePageTitle, "Page title does not match expected title");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {

        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

}
