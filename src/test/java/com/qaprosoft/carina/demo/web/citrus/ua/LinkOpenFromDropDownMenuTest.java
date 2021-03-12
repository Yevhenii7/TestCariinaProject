package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.HomePage;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.SupportServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkOpenFromDropDownMenuTest extends AbstractTest {
    String expectedTextFromSupportServicePage = "Служба поддержки";

    @Test(description = "JIRA#AUTO-0010")
    private void openLinkFromDropDownMenu() {
        SupportServicePage servicePage = new SupportServicePage(getDriver());
        servicePage.open();
        Assert.assertTrue(servicePage.isPageOpened(), "Home page is not opened");
//        servicePage.getWeValueAdvertising().closeAdvertisingIfOpen();

        servicePage.clickLinkClients();
        servicePage.clickLinkSupportService();
        servicePage.switchToNewWindow();
        Assert.assertEquals(servicePage.readTextFromSupportServicePage(), expectedTextFromSupportServicePage, "Service page is not available");


    }
}
