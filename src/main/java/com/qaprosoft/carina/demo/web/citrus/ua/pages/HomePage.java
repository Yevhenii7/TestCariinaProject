package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.citrus.ua.components.WeValueAdvertising;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    @FindBy(xpath = "//a[@class='link-to' and contains(text(), 'Yevheniy')]")
    private ExtendedWebElement textLoggedInUser;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedUserName() {
        assertElementPresent(textLoggedInUser);
        LOGGER.info("User logged");
        return textLoggedInUser.getText();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
