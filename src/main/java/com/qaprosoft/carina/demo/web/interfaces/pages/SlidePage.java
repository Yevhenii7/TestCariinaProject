package com.qaprosoft.carina.demo.web.interfaces.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.interfaces.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SlidePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = ".swiper-button-next")
    private ExtendedWebElement buttonArrowRightNext;

    @FindBy(xpath = "//li[@class='swiper-item swiper-slide swiper-slide-active']/a[@href='/actions/apple-na-24-dolki-s-pumb/']")
    private ExtendedWebElement slideBannerActive;


    public SlidePage(WebDriver driver) {
        super(driver);
    }

    public boolean isArrowButtonVisible() {
        buttonArrowRightNext.isVisible();
        return true;
    }

    public void clickNextButton() {
        buttonArrowRightNext.click();
    }

    public boolean isArrowButtonClickable() {
        buttonArrowRightNext.isClickable();
        return true;
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

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
