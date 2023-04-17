package com.herokuapp.tests.alerts;

import com.herokuapp.base.Base;
import com.herokuapp.pages.alerts.AlertsPage;
import org.testng.annotations.Test;

public class AlertsTest extends Base {
    @Test
    public void verifyAlerts() {

        // Navigate to page
        AlertsPage alerts = testPages.getAlerts_Url();
        
    }
}
