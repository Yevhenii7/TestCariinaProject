package com.qaprosoft.carina.demo.web.interfaces;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.interfaces.pages.BunsPage;
import com.qaprosoft.carina.demo.web.interfaces.pages.GiftСardsPage;
import com.qaprosoft.carina.demo.web.interfaces.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderMenuTest extends AbstractTest {
    String expectedTitleFromBunsPage = "Цитрус Плюшки - Специальные бонусы на покупки в интернет-магазине Цитрус";
    String expectedTitleFromGiftCardsPage = "Подарочные сертификаты и карты в интернет-магазине Цитрус. " +
            "Сертификаты на подарок на покупку гаджетов в Украине: Киев, Харьков, Днепр, Одесса, Львов, Николаев, Винница, Сумы, Запорожье";


    @Test(description = "JIRA#AUTO-0009")
    public void checkHeaderPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getWeValueAdvertising().closeAdvertisingIfOpen();

        BunsPage bunsPage = new BunsPage(getDriver());
        bunsPage.clickLinkBuns();
        Assert.assertEquals(bunsPage.getTitleFromBunsPage(), expectedTitleFromBunsPage, "Buns page is not available");
        bunsPage.returnBack();

        GiftСardsPage giftСardsPage = new GiftСardsPage(getDriver());
        giftСardsPage.clickLinkGiftCards();
        Assert.assertEquals(giftСardsPage.getTitleFromGiftCardsPage(), expectedTitleFromGiftCardsPage, "Gift cards page is not available");

    }

}
