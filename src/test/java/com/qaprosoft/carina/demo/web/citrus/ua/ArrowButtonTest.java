package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.PortableAcousticsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrowButtonTest extends AbstractTest {
    String expectedTitleFromProductPage = "Акустика Meizu Lifeme-BTS30 Bluetooth (Grey). " +
            "Купити Акустика Meizu Lifeme-BTS30 Bluetooth (Grey) за вигідною ціною в Києві, Харкові, Одесі, Дніпрі, Миколаєві, Запоріжжі, Україна | Цитрус";


    @Test(description = "JIRA#AUTO-0006")
    private void checkArrowButton() {
        PortableAcousticsPage portableAcousticsPage = new PortableAcousticsPage(getDriver());
        portableAcousticsPage.open();
        Assert.assertTrue(portableAcousticsPage.isPageOpened(), "Portable acoustics page is not opened");

//        portableAcousticsPage.getWeValueAdvertising().closeAdvertisingIfOpen();

        portableAcousticsPage.clickCheckBox();
        Assert.assertTrue(portableAcousticsPage.isTitleFromBrandPageVisible(), "Link from page layout is not visible");

        portableAcousticsPage.clickForAnyAvailableProduct();
        Assert.assertEquals(portableAcousticsPage.getTitleFromProductPage(), expectedTitleFromProductPage, "Product page is not find");

        portableAcousticsPage.clickBackArrowButton();
        Assert.assertTrue(portableAcousticsPage.isTitleFromBrandPageVisible(), "Title from Brand page is not visible");


    }

}
