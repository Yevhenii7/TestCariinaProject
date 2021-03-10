package com.qaprosoft.carina.demo.web.ui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.ui.pages.PowerBankPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterSearchTest extends AbstractTest {
    PowerBankPage powerBankPage = new PowerBankPage(getDriver());

    @Test(description = "JIRA#AUTO-0004")
    private void searchFilterTest() throws InterruptedException {
        powerBankPage.open();
        Assert.assertTrue(powerBankPage.isPageOpened(), "Slide page is not opened");
        powerBankPage.getWeValueAdvertising().closeAdvertisingIfOpen();

        powerBankPage.selectPriceRangeSlider();
        Assert.assertTrue(powerBankPage.isPriceRangeVisible(), "Price range is not visible ");


        powerBankPage.clickCheckBox();
        Assert.assertTrue(powerBankPage.isLinkFromPageLayoutVisible(), "Link from page layout is not visible");


    }


}
