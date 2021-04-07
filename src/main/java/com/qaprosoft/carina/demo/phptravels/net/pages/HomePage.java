package com.qaprosoft.carina.demo.phptravels.net.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.citrus.ua.components.WeValueAdvertising;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdfwriter.COSWriterXRefEntry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    @FindBy(xpath = "//div[@class='select2-container form-control hotelsearch locationlistHotels']")
    private ExtendedWebElement formDestination;

    @FindBy(xpath = "//div[@class='select2-result-label' and contains(text(),'Alzer Hotel Istanbul, Istanbul')]")
    private ExtendedWebElement nameOfHotels;

    @FindBy(id = "checkin")
    private ExtendedWebElement formDataDeparture;

    @FindBy(id = "checkout")
    private ExtendedWebElement formDataReturn;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block']")
    private ExtendedWebElement searchButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HotelsPage selectHotel(String hotel) {
        LOGGER.info("selecting '" + hotel + "' hotel...");
        formDestination.click();
        nameOfHotels.click();
        formDataDeparture.type("10/04/2021");
        formDataReturn.type("17/04/2021");
        searchButton.click();

        return new HotelsPage(driver);
    }


}
