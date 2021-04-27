package com.qaprosoft.carina.demo.allo.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
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

public class BrandModelPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//h1[@class='v-catalog__title']")
    private ExtendedWebElement title;

    private final By sliderMin = By.xpath("//div[@class='noUi-handle noUi-handle-lower']");

    private final By sliderMax = By.xpath("//div[@class='noUi-handle noUi-handle-upper']");


    @FindBy(xpath = "//div[@class='price-slider']")
    private ExtendedWebElement priceSlider;

    @FindBy(xpath = "//*[@class='product-card__title' and contains(text(),'Apple iPhone 12 64GB Black (MGJ53)')]")
    private List<ExtendedWebElement> productName;

    public BrandModelPage(WebDriver driver) {
        super(driver);
    }

    public String readTitle() {
        assertElementPresent(title);
        return title.getText();
    }

    public void movePriceRangeSlider() {
        WebElement elementRight = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sliderMin));
        new Actions(driver).dragAndDropBy(elementRight, 30, 0).build().perform();
        LOGGER.info("Price selected");
        WebElement elementLeft = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sliderMax));
        new Actions(driver).dragAndDropBy(elementLeft, -30, 0).build().perform();
    }

    public boolean isPriceRangeVisible() {
        return priceSlider.isVisible();

    }

    public ModelPhonePage selectPhone(String namePhone) {
        LOGGER.info("selecting '" + namePhone + "' namePhone...");
        for (ExtendedWebElement element : productName) {
            String currentPhoneName = element.getText();
            if (namePhone.equalsIgnoreCase(currentPhoneName))
                element.click();
            return new ModelPhonePage(driver);
        }
        throw new RuntimeException("Unable to open page with phone: " + namePhone);
    }
}

