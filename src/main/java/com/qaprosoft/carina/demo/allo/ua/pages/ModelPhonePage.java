package com.qaprosoft.carina.demo.allo.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModelPhonePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='product-details__value' and contains(text(),'6.1')]")
    private ExtendedWebElement displayInfo;

    @FindBy(xpath = "//*[@class='product-details__value' and contains(text(),'12 Мп + 12 Мп')]")
    private ExtendedWebElement cameraInfo;

    @FindBy(xpath = "//*[@class='product-details__value' and contains(text(),'64 ГБ')]")
    private ExtendedWebElement ramInfo;


    public ModelPhonePage(WebDriver driver) {
        super(driver);
    }

    public String readDisplay() {
        assertElementPresent(displayInfo);
        return displayInfo.getText();
    }

    public String readCamera() {
        assertElementPresent(cameraInfo);
        return cameraInfo.getText();
    }

    public String readRam() {
        assertElementPresent(ramInfo);
        return ramInfo.getText();
    }
}
