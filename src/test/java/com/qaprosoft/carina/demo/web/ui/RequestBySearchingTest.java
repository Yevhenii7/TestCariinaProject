package com.qaprosoft.carina.demo.web.ui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.ui.pages.SmartphonePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RequestBySearchingTest extends AbstractTest {
    SmartphonePage smartphonePage = new SmartphonePage(getDriver());


    @Test(description = "JIRA#AUTO-0003")
    public void searchByRequestResult() {
        smartphonePage.open();
        Assert.assertTrue(smartphonePage.isPageOpened(), "Smartphone page is not opened");

        smartphonePage.inputInSearchBoxNameOfProduct("iphone 12");
        Assert.assertTrue(smartphonePage.isSearchBoxVisible(), "Search Box is not visible");

        smartphonePage.clickButtonSubmit();
        Assert.assertEquals(smartphonePage.readResultNameFromLoadPage(), "Результаты поиска: iphone 12", "Search name is not available");

    }

    @AfterMethod
    public void closeAdvertising() {
        smartphonePage.getWeValueAdvertising().closeAdvertisingIfOpen();
    }
}
