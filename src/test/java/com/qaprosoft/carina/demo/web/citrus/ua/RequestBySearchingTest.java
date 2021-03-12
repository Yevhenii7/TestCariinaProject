package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.SmartphonePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RequestBySearchingTest extends AbstractTest {
    SmartphonePage smartphonePage = new SmartphonePage(getDriver());
    String modelMobilePhone = "iphone 12";
    String searchingResults = "Результаты поиска: iphone 12";


    @Test(description = "JIRA#AUTO-0003")
    public void searchByRequestResult() {
        smartphonePage.open();
        Assert.assertTrue(smartphonePage.isPageOpened(), "Smartphone page is not opened");

        smartphonePage.inputInSearchBoxNameOfProduct(modelMobilePhone);
        Assert.assertTrue(smartphonePage.isSearchBoxVisible(), "Search Box is not visible");

        smartphonePage.clickButtonSubmit();
        Assert.assertEquals(smartphonePage.readResultNameFromLoadPage(), searchingResults, "Search name is not available");

    }

//    @AfterMethod
//    public void closeAdvertising() {
//        smartphonePage.getWeValueAdvertising().closeAdvertisingIfOpen();
//    }
}
