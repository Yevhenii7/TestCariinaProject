package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.TelevisionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemAddingToBasketTest extends AbstractTest {
    TelevisionPage televisionPage = new TelevisionPage(getDriver());
    String expectedTitleFromProductPage = "Телевізор Samsung 55'' 4K UHD Smart TV (UE55TU8500UXUA). " +
            "Купити Телевізор Samsung 55'' 4K UHD Smart TV (UE55TU8500UXUA) за вигідною ціною в Києві, Харкові, Одесі, Дніпрі, Миколаєві, Запоріжжі, Україна | Цитрус";

    @Test(description = "JIRA#AUTO-0007")
    private void addItemToBasket() {
        televisionPage.open();
        Assert.assertTrue(televisionPage.isPageOpened(), "Smartphone case page is not opened");

        televisionPage.getWeValueAdvertising().closeAdvertisingIfOpen();


        televisionPage.clickIconMenu();
        Assert.assertTrue(televisionPage.isMenuIconClickable(), "Menu icon is not clickable");

        televisionPage.selectSectionTelevision();
        Assert.assertTrue(televisionPage.isLinkOnSectionTelevisionClickable(), "Selected section television is not clickable");

        televisionPage.clickSectionBrandSamsung();
        Assert.assertTrue(televisionPage.isLinkOnSectionBrandSamsungClickable(), "Section brand samsung is not clickable ");

        televisionPage.getWeValueAdvertising().closeAdvertisingIfOpen();

        televisionPage.clickProductName();
        Assert.assertEquals(televisionPage.getTitleFromProductPage(), expectedTitleFromProductPage, "Title from product page is not available");


        televisionPage.clickButtonBuy();
        Assert.assertTrue(televisionPage.isDialogPopUpWindowAppears(), "Dialog pop up window is not visible");
    }
}

