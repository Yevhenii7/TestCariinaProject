package com.qaprosoft.carina.demo.web.ui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.ui.pages.SlidePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BannerTest extends AbstractTest {
    SlidePage slidePage = new SlidePage(getDriver());


    @Test(description = "JIRA#AUTO-0002")
    public void clickOnBannerInSlider() {
        slidePage.open();
        Assert.assertTrue(slidePage.isPageOpened(), "Slide page is not opened");
        Assert.assertTrue(slidePage.isArrowButtonVisible(), "Arrow button is not visible");
        slidePage.isBannerClickable();

    }

}