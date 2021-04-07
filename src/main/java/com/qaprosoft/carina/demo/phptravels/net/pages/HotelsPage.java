package com.qaprosoft.carina.demo.phptravels.net.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HotelsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//li[@class='active']")
    private ExtendedWebElement nextSection;

    @FindBy(xpath = "//div[@class='product-long-item']")
    private List<HotelName> hotels;

    @FindBy(xpath = "//a[@class='anchor btn btn-primary btn-wide mt-5']")
    private ExtendedWebElement buttonPriceAndDate;

    @FindBy(xpath = "//div[@class='panel-body']")
    private ExtendedWebElement bodyResult;


    public HotelsPage(WebDriver driver) {
        super(driver);
    }

    public void clickNextPage() {
        nextSection.click();
    }

    public DetailInfoPage selectHotel(String hotelName) {
        for (HotelName hotel : hotels) {
            if (hotelName.equalsIgnoreCase(hotel.readHotelLocation()))
                return hotel.openHotelPage();
        }
        throw new RuntimeException("Unable to open hotel: " + hotelName);

    }





}
