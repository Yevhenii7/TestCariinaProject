package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class HeadphonesPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private final By sliderMax = By.xpath("//div[@class='el-slider__runway']/descendant::div[5]");

    @FindBy(xpath = "//div[@class='el-slider__bar']")
    private ExtendedWebElement priceRange;

    @FindBy(xpath = "//div[@class='catalog__breadcrumbs shadow']")
    private ExtendedWebElement linkFromPageLayout;

    public HeadphonesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/naushniki/");
    }

    public void selectPriceRangeSlider() {
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sliderMax));
        new Actions(getDriver()).dragAndDropBy(element, -30, 0).build().perform();
        LOGGER.info("Price selected");

    }

    public boolean isPriceRangeVisible() {
        return priceRange.isVisible();
    }

    public void openLinkInOtherWindow() {
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get("https://www.citrus.ua/naushniki/?prices%5Bmax%5D=16281");
        LOGGER.info("Link is opened");
    }

    public boolean isLinkFromNewWindowVisible() {
        return linkFromPageLayout.isVisible();
    }
}
