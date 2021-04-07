package com.qaprosoft.carina.demo.phptravels.net.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DetailInfoPage extends AbstractPage {

    @FindBy(xpath = "//h2[@class='name']")
    private ExtendedWebElement nameHotel;


    public DetailInfoPage(WebDriver driver) {
        super(driver);
    }

    public String readNameHotel() {
        assertElementPresent(nameHotel);
        return nameHotel.getText();
    }

}
