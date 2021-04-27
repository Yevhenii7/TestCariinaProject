package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class BunsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//li[@class ='item'][1]")
    private ExtendedWebElement linkBuns;

    public BunsPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkBuns() {
        linkBuns.click();
    }

    public String getTitleFromBunsPage() {
        String newWindow = getDriver().getWindowHandle();
        LOGGER.info(getDriver().switchTo().window(newWindow).getTitle());
        return getDriver().switchTo().window(newWindow).getTitle();

    }
    public void returnBack(){
        getDriver().navigate().back();
    }

}
