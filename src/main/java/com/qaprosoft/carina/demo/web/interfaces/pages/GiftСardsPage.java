package com.qaprosoft.carina.demo.web.interfaces.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class GiftСardsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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

}
