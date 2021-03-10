package com.qaprosoft.carina.demo.web.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.ui.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//a[@class='link-to' and contains(text(), 'Yevheniy')]")
    private ExtendedWebElement textLoggedInUser;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
        assertElementPresent(textLoggedInUser);
        return textLoggedInUser.getText();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
