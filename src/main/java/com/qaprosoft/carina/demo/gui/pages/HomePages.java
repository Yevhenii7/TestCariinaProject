package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePages extends AbstractPage {

    @FindBy(id = "footmenu")
    private FooterMenuPage footMenu;

    private static final Logger LOGGER = LogManager.getRootLogger();


    public HomePages(WebDriver driver) {
        super(driver);
    }

    public FooterMenuPage getFooterMenu() {
        return footMenu;
    }

}
