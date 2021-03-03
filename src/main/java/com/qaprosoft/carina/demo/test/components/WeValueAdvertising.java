package com.qaprosoft.carina.demo.test.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WeValueAdvertising extends AbstractUIObject {
    @FindBy(xpath = "//button[@class='el-dialog__headerbtn']")
    private ExtendedWebElement buttonCloseAdvertising;

    public WeValueAdvertising(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WeValueAdvertising(WebDriver driver) {
        super(driver);
    }

    public void closeAdvertisingIfOpen() {
        buttonCloseAdvertising.click();
    }
}
