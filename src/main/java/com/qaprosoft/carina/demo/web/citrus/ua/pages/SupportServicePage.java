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

public class SupportServicePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//li[@class='item parent'][1]")
    private ExtendedWebElement linkClients;

    @FindBy(xpath = "//li[@class='item parent']//li[6]")
    private ExtendedWebElement linkSupportService;

    @FindBy(xpath = "//p[@class='text_on_img_1']")
    private ExtendedWebElement textOnImage;


    public SupportServicePage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkClients() {
        linkClients.click();
    }

    public void clickLinkSupportService() {
        linkSupportService.click();
    }

    public void switchToNewWindow() {
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
    }

    public String readTextFromSupportServicePage() {
        assertElementPresent(textOnImage);
        LOGGER.info(textOnImage.getText());
        return textOnImage.getText();
    }

    public WeValueAdvertising getWeValueAdvertising() {

        return new WeValueAdvertising(driver);
    }
}
