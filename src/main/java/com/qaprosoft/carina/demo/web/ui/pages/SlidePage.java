package com.qaprosoft.carina.demo.web.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.ui.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

public class SlidePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    String expectedTitleFromBanner = "Apple на 24 дольки с ПУМБ";
    String expectedTitleFromPageLayout = "Apple на 24 дольки с ПУМБ Купить по цене от 4999 " +
            "в Киеве, Харькове, Днепре, Одессе, Полтаве, Запорожье, Николаеве, Украине | Цитрус";

    @FindBy(css = ".swiper-button-next")
    private ExtendedWebElement buttonArrowRightNext;

    @FindBy(xpath = "//li[@class='swiper-item swiper-slide swiper-slide-active']/a[@title='Apple на 24 дольки с ПУМБ']")
    private ExtendedWebElement slideBannerActive;


    public SlidePage(WebDriver driver) {
        super(driver);
    }

    public boolean isArrowButtonVisible() {
        return buttonArrowRightNext.isVisible();
    }

    public void clickNextButton() {
        buttonArrowRightNext.click();
    }


    public String getTitleFromBanner() {
        LOGGER.info(slideBannerActive.getAttribute("title"));
        return slideBannerActive.getAttribute("title");
    }

    public void clickSlideBanner() {
        slideBannerActive.click();
    }


    public String getTitleFromPageLayout() {
        String newWindow = getDriver().getWindowHandle();
        LOGGER.info(getDriver().switchTo().window(newWindow).getTitle());
        return getDriver().switchTo().window(newWindow).getTitle();
    }

    public boolean isBannerClickable() {
        boolean isBannerClickable = false;
        int numberOfBanners = 0;
        if (expectedTitleFromBanner.equalsIgnoreCase(getTitleFromBanner())) {
            clickSlideBanner();
        } else {
            for (int i = 1; i < numberOfBanners; i++) {
                clickNextButton();
                if (expectedTitleFromBanner.equalsIgnoreCase(getTitleFromBanner())) {
                    isBannerClickable = expectedTitleFromBanner.equalsIgnoreCase(getTitleFromBanner());
                }
                if (expectedTitleFromPageLayout.equalsIgnoreCase(getTitleFromPageLayout())) {
                    clickSlideBanner();
                    isBannerClickable = expectedTitleFromPageLayout.equalsIgnoreCase(getTitleFromPageLayout());
                }
            }
        }
        return isBannerClickable;
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
