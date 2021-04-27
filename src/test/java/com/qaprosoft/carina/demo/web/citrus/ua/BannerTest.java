package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.BannerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BannerTest extends AbstractTest {


    @Test(description = "JIRA#AUTO-0002")
    public void clickOnBannerInSlider() {
        BannerPage bannerPage = new BannerPage(getDriver());
        bannerPage.open();
        Assert.assertTrue(bannerPage.isPageOpened(), "Slide page is not opened");
        Assert.assertTrue(bannerPage.isArrowButtonVisible(), "Arrow button is not visible");
        bannerPage.isBannerClickable();

    }

}