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

public class GiftСardsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@item-id='501']")
    private ExtendedWebElement linkGiftCards;

    public GiftСardsPage(WebDriver driver) {
        super(driver);
    }



    public void clickLinkGiftCards() {
        linkGiftCards.click();
    }

    public String getTitleFromGiftCardsPage() {
        String newWindow = getDriver().getWindowHandle();
        LOGGER.info(getDriver().switchTo().window(newWindow).getTitle());
        return getDriver().switchTo().window(newWindow).getTitle();

    }

    public WeValueAdvertising getWeValueAdvertising() {

        return new WeValueAdvertising(driver);
    }
}
