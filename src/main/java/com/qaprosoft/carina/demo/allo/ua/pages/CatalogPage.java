package com.qaprosoft.carina.demo.allo.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();


    @FindBy(xpath = "//*[@class='portal-card__link-container']//child::a")
    private List<ExtendedWebElement> listPhoneBrand;

    @FindBy(xpath = "//*[@href='https://allo.ua/ua/products/mobile/proizvoditel-apple/'][@title='Apple']")
    private ExtendedWebElement appleBrand;


    public CatalogPage(WebDriver driver) {
        super(driver);
    }


    public BrandModelPage clickBrand(String brandApple) {
        LOGGER.info("selecting '" + brandApple + "' brand...");
        appleBrand.click();
        return new BrandModelPage(driver);
    }
}
