package com.qaprosoft.carina.demo.web.interfaces.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class HeadphonesPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='el-slider__bar']")
    private ExtendedWebElement priceRange;

    @FindBy(xpath = "/html/head/link[22]")
    private ExtendedWebElement linkFromPageLayout;

    public HeadphonesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/naushniki/");
    }

    public void selectPriceRangeSlider() {
        WebElement sliderMax = driver.findElement(By.xpath("//div[@class='el-slider price-filter']/descendant::div[5]"));
        new Actions(getDriver()).dragAndDropBy(sliderMax, -30, 0).build().perform();

    }

    public boolean isPriceRangeVisible() {
        priceRange.isVisible();
        return true;
    }

    public void openLinkInIncognitoWindow() {
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get("https://www.citrus.ua/naushniki/?prices%5Bmax%5D=16281");
    }

    public boolean isLinkFromPageLayoutVisible() {
        linkFromPageLayout.isVisible();
        return true;
    }
}
