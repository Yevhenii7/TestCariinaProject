package com.qaprosoft.carina.demo.web.interfaces;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.interfaces.pages.SlidePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BannerClickingTest extends AbstractTest {
    String expectedTitleFromBanner = "Apple на 24 дольки с ПУМБ";
    String expectedTitleFromPageLayout = "Apple на 24 дольки с ПУМБ Купить по цене от 4999 " +
            "в Киеве, Харькове, Днепре, Одессе, Полтаве, Запорожье, Николаеве, Украине | Цитрус";
    SlidePage slidePage = new SlidePage(getDriver());


    @Test(description = "JIRA#AUTO-0002")
    public void clickOnBannerInSlider() {
        slidePage.open();
        Assert.assertTrue(slidePage.isPageOpened(), "Slide page is not opened");
        Assert.assertTrue(slidePage.isArrowButtonVisible(), "Arrow button is not visible");
        Assert.assertEquals(slidePage.getTitleFromBanner(), expectedTitleFromBanner, "Banner title is not find");

        if (expectedTitleFromBanner.equals(slidePage.getTitleFromBanner())) {
            slidePage.clickSlideBanner();
            Assert.assertEquals(slidePage.getTitleFromPageLayout(), expectedTitleFromPageLayout, "Page layout is not find");
        } else {
            for (int i = 1; i < 17; i++) {
                slidePage.clickNextButton();
                Assert.assertTrue(slidePage.isArrowButtonClickable(), "Arrow button is not clickable");
                if (expectedTitleFromBanner.equals(slidePage.getTitleFromBanner())) {
                    Assert.assertEquals(slidePage.getTitleFromBanner(), expectedTitleFromBanner, "Banner title is not find");
                }
                if (expectedTitleFromPageLayout.equals(slidePage.getTitleFromPageLayout())) {
                    slidePage.clickSlideBanner();
                    Assert.assertEquals(slidePage.getTitleFromPageLayout(), expectedTitleFromPageLayout, "Page layout is not appears");
                }
            }
        }
    }

//    @AfterMethod
//    public void closeAdvertising() {
//        slidePage.getWeValueAdvertising().closeAdvertisingIfOpen();
//    }
}
