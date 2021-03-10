package com.qaprosoft.carina.demo.web.ui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.ui.pages.HomePage;
import com.qaprosoft.carina.demo.web.ui.pages.LoginPage;
import com.qaprosoft.carina.demo.web.ui.pages.SupportServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkOpenFromDropDownMenuTest extends AbstractTest {
    String expectedTextFromSupportServicePage = "Служба поддержки";

    @Test(description = "JIRA#AUTO-0010")
    private void openLinkFromDropDownMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValueAdvertising().closeAdvertisingIfOpen();

        SupportServicePage servicePage = new SupportServicePage(getDriver());
        servicePage.clickLinkClients();
        servicePage.clickLinkSupportService();
        servicePage.switchToNewWindow();
        Assert.assertEquals(servicePage.readTextFromSupportServicePage(), expectedTextFromSupportServicePage, "Service page is not available");


    }
}
