package com.qaprosoft.carina.demo.web.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.ui.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SmartphonePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@id='search-input']")
    private ExtendedWebElement searchBoxInput;

    @FindBy(xpath = "//form[@class='global-search']//descendant::button[3]")
    private ExtendedWebElement buttonSubmit;

    @FindBy(xpath = "//*[@class='result-title' and contains(text(),': iphone 12')]")
    private ExtendedWebElement resultName;

    public SmartphonePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/smartfony/");
    }


    public void inputInSearchBoxNameOfProduct(String nameOfProduct) {
        searchBoxInput.type(nameOfProduct);
    }

    public boolean isSearchBoxVisible() {
       return searchBoxInput.isVisible();
    }


    public void clickButtonSubmit() {
        buttonSubmit.click();

    }

    public String readResultNameFromLoadPage() {
        assertElementPresent(resultName);
        return resultName.getText();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }

}
