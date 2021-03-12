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
import java.util.List;

public class PortableAcousticsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@class='el-checkbox__input']")
    private List<ExtendedWebElement> checkBox;

    @FindBy(xpath = "//h1[@class='main-content__promotion-title']")
    private ExtendedWebElement titleFromBrandPage;

    @FindBy(xpath = "//div[@class='product-card__name']")
    private List<ExtendedWebElement> productName;

    @FindBy(xpath = "//h1[@class='product__title']")
    private ExtendedWebElement productTitleFromProductsPage;

    public PortableAcousticsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/uk/akustika/vid-akustiki_portativnaya/");
    }


    public void clickCheckBox() {
        checkBox.get(1).click();
    }

    public boolean isTitleFromBrandPageVisible() {
        return titleFromBrandPage.isVisible();
    }

    public void clickForAnyAvailableProduct() {
        productName.get(0).click();

    }

    public String getTitleFromProductPage() {
        String newWindow = getDriver().getWindowHandle();
        LOGGER.info(getDriver().switchTo().window(newWindow).getTitle());
        return getDriver().switchTo().window(newWindow).getTitle();
    }

    public void clickBackArrowButton() {
        getDriver().navigate().back();
    }



    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
