package com.qaprosoft.carina.demo.phptravels.net.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HotelName extends AbstractUIObject {

    @FindBy(xpath = "//p[@class='location go-text-right']")
    private ExtendedWebElement placeLocation;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm btn-wide']")
    private ExtendedWebElement buttonDetail;


    public HotelName(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readHotelLocation() {
        return placeLocation.getText();

    }

    public DetailInfoPage openHotelPage() {
        buttonDetail.click();
        return new DetailInfoPage(driver);
    }
}
