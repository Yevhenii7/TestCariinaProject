package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.citrus.ua.components.WeValueAdvertising;
import com.qaprosoft.carina.demo.web.citrus.ua.model.Banner;
import com.qaprosoft.carina.demo.web.citrus.ua.service.BannerCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class BannerPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    Banner testBanner = BannerCreator.withCredentialsFromProperty();


    @FindBy(css = ".swiper-button-next")
    private ExtendedWebElement buttonArrowRightNext;

    @FindBy(xpath = "//li[@class='swiper-item swiper-slide swiper-slide-active']/a[@title='Apple на 24 дольки с ПУМБ']")
    private ExtendedWebElement slideBannerActive;


    public BannerPage(WebDriver driver) {
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
        if (testBanner.getTextFromBanner().equalsIgnoreCase(getTitleFromBanner())) {
            clickSlideBanner();
        } else {
            for (int i = 1; i < numberOfBanners; i++) {
                clickNextButton();
                if (testBanner.getTextFromBanner().equalsIgnoreCase(getTitleFromBanner())) {
                    isBannerClickable = testBanner.getTextFromBanner().equalsIgnoreCase(getTitleFromBanner());
                }
                if (testBanner.getTextFromBannerPage().equalsIgnoreCase(getTitleFromPageLayout())) {
                    clickSlideBanner();
                    isBannerClickable = testBanner.getTextFromBannerPage().equalsIgnoreCase(getTitleFromPageLayout());
                }
            }
        }
        return isBannerClickable;
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
