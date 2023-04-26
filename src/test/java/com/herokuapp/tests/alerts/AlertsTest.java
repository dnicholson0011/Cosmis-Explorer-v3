package com.herokuapp.tests.alerts;

import com.herokuapp.base.Base;
import com.herokuapp.pages.alerts.AlertsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class AlertsTest extends Base {
    @Parameters ("alertsPageTitle")
    @Test
    public void verifyAlerts(String alertsPageTitle) {

        // Navigate to page
        AlertsPage alerts = testPages.getAlerts_Url();

        // Verify title
        String actualTitle = alerts.getPageTitle();
        Assert.assertEquals(actualTitle,alertsPageTitle, "Page title does not match expected title");

        // Verify alert box

        alerts.getAlertBox().click();

        // Verify confirm box

        // Verify prompt box

        // Navigate to homepage
    }
}
