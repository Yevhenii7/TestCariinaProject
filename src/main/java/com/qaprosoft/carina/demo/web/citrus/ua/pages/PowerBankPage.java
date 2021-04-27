package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.citrus.ua.components.WeValueAdvertising;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PowerBankPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private final By sliderMax = By.xpath("//div[@class='el-slider__runway']/descendant::div[5]");

    @FindBy(xpath = "//div[@class='el-slider__bar']")
    private ExtendedWebElement priceRange;

    @FindBy(xpath = "//span[@class='el-checkbox__input']")
    private List<ExtendedWebElement> checkBox;

    @FindBy(xpath = "//div[@class='catalog__breadcrumbs shadow']")
    private ExtendedWebElement linkFromPageLayout;


    public PowerBankPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/portativnye-batarei/");
    }

    public void selectPriceRangeSlider() throws InterruptedException {
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sliderMax));
        new Actions(getDriver()).dragAndDropBy(element, -30, 0).build().perform();

    }

    public boolean isPriceRangeVisible() {
        return priceRange.isVisible();

    }

    public void clickCheckBox() {
        checkBox.get(3).click();
    }

    public boolean isLinkFromPageLayoutVisible() {
        return linkFromPageLayout.isVisible();
    }


    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
