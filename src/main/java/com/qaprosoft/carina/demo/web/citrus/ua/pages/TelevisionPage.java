package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.citrus.ua.components.WeValueAdvertising;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class TelevisionPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();


    @FindBy(xpath = "//div[@class='menu--desktop__title']//child::i")
    private ExtendedWebElement menuIcon;

    @FindBy(xpath = "//a[@href='/uk/televizory-photo-video/']")
    private ExtendedWebElement sectionTelevision;

    @FindBy(xpath = "//a[@href='/uk/televizory/brand-samsung/']")
    private ExtendedWebElement sectionBrandSamsung;

    @FindBy(xpath = "//div[@class='product-card__name']")
    private List<ExtendedWebElement> productName;

    @FindBy(xpath = "//div[@id='buy-block']//descendant::button[1]")
    private ExtendedWebElement buttonBuy;
    @FindBy(xpath = "//div[@class='el-dialog__body']")
    private ExtendedWebElement dialogPopUpWindow;


    public TelevisionPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/uk/televizory-i-mediapleery/");
    }

    public void clickIconMenu() {
        menuIcon.click();
    }

    public boolean isMenuIconClickable() {
        return menuIcon.isClickable();
    }

    public void selectSectionTelevision() {
        sectionTelevision.hover();

    }

    public boolean isLinkOnSectionTelevisionClickable() {
        return sectionTelevision.isClickable();
    }

    public void clickSectionBrandSamsung() {
        sectionBrandSamsung.click();
    }

    public boolean isLinkOnSectionBrandSamsungClickable() {
        return sectionBrandSamsung.isClickable();
    }

    public void clickProductName() {
        productName.get(3).click();
    }

    public String getTitleFromProductPage() {
        String newWindow = getDriver().getWindowHandle();
        LOGGER.info(getDriver().switchTo().window(newWindow).getTitle());
        return getDriver().switchTo().window(newWindow).getTitle();
    }

    public void clickButtonBuy() {
        buttonBuy.click();
    }

    public boolean isDialogPopUpWindowAppears() {
        return dialogPopUpWindow.isVisible();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
