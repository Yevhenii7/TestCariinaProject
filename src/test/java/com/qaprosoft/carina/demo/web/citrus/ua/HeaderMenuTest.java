package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.model.HeaderMenu;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.BunsPage;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.HomePage;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.GiftСardsPage;
import com.qaprosoft.carina.demo.web.citrus.ua.service.HeaderMenuCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderMenuTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0009")
    public void checkHeaderPage() {
        HeaderMenu headerMenu = HeaderMenuCreator.withCredentialsFromProperty();
        GiftСardsPage giftСardsPage = new GiftСardsPage(getDriver());
        giftСardsPage.open();
        Assert.assertTrue(giftСardsPage.isPageOpened(), "Home page is not opened");

//        giftСardsPage.getWeValueAdvertising().closeAdvertisingIfOpen();

        BunsPage bunsPage = new BunsPage(getDriver());
        bunsPage.clickLinkBuns();
        Assert.assertEquals(bunsPage.getTitleFromBunsPage(), headerMenu.getTextFromBunsPage(), "Buns page is not available");
        bunsPage.returnBack();

        giftСardsPage.clickLinkGiftCards();
        Assert.assertEquals(giftСardsPage.getTitleFromGiftCardsPage(), headerMenu.getTextFromGiftsCardsPage(), "Gift cards page is not available");

    }

}
