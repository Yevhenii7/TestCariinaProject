package com.qaprosoft.carina.demo.allo.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.allo.ua.pages.BrandModelPage;
import com.qaprosoft.carina.demo.allo.ua.pages.CatalogPage;
import com.qaprosoft.carina.demo.allo.ua.pages.HomePage;
import com.qaprosoft.carina.demo.allo.ua.pages.ModelPhonePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BrandModelTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001")
    public void selectBrandPhoneTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CatalogPage catalogPage = homePage.clickSection("Смартфони та телефони");
        BrandModelPage brandModelPage = catalogPage.clickBrand("Apple");
        Assert.assertEquals(brandModelPage.readTitle(), "Смартфони і мобільні телефони Apple", "The brand is not displayed");
    }


    @Test(description = "JIRA#AUTO-0002")
    public void selectFilterPriceTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CatalogPage catalogPage = homePage.selectSection("Смартфони та телефони");
        BrandModelPage brandModelPage = catalogPage.clickBrand("Apple");
        Assert.assertEquals(brandModelPage.readTitle(), "Смартфони і мобільні телефони Apple", "The brand is not displayed");

        brandModelPage.movePriceRangeSlider();
        Assert.assertTrue(brandModelPage.isPriceRangeVisible(), "The toolbar filter price is not find");

    }

    @Test(description = "JIRA#AUTO-0003")
    public void selectModelPhone() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CatalogPage catalogPage = homePage.selectSection("Смартфони та телефони");
        BrandModelPage brandModelPage = catalogPage.clickBrand("Apple");
        Assert.assertEquals(brandModelPage.readTitle(), "Смартфони і мобільні телефони Apple", "The brand is not displayed");

        ModelPhonePage modelPhonePage = brandModelPage.selectPhone("Apple iPhone 12 64GB Black (MGJ53)");

        Assert.assertEquals(modelPhonePage.readDisplay(), "6.1\"", "Display info is not correct");
        Assert.assertEquals(modelPhonePage.readCamera(), "12 Мп + 12 Мп", "Camera info is not correct");
        Assert.assertEquals(modelPhonePage.readRam(), "64 ГБ", "Ram info is not correct");


    }


}
