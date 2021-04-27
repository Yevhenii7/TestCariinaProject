package com.qaprosoft.carina.demo.allo.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//li[@class='menu__item item js-item js-item--active-current-level ']")
    private List<ExtendedWebElement> sectionLink;

    @FindBy(xpath = "//li[@class='menu__item item js-item js-item--active-current-level '][1]")
    private ExtendedWebElement sectionSmartphone;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage clickSection(String section) {
        LOGGER.info("selecting '" + section + "' section...");
        for (ExtendedWebElement element : sectionLink) {
            String currentSection = element.getText();
            if (section.equalsIgnoreCase(currentSection))
                element.click();
            return new CatalogPage(driver);
        }
        throw new RuntimeException("Unable to open section: " + section);
    }

    public CatalogPage selectSection(String section) {
        LOGGER.info("selecting '" + section + "' section...");
        sectionSmartphone.hover();
        return new CatalogPage(driver);
    }
}
