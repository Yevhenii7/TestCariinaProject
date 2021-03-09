package com.qaprosoft.carina.demo.web.interfaces.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.interfaces.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class TelevisionPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


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
        menuIcon.isClickable();
        return true;
    }

    public void selectSectionTelevision() {
        sectionTelevision.hover();

    }

    public boolean isLinkOnSectionTelevisionClickable() {
        sectionTelevision.isClickable();
        return true;
    }

    public void clickSectionBrandSamsung() {
        sectionBrandSamsung.click();
    }

    public boolean isLinkOnSectionBrandSamsungClickable() {
        sectionBrandSamsung.isClickable();
        return true;
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
        dialogPopUpWindow.isVisible();
        return true;
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
