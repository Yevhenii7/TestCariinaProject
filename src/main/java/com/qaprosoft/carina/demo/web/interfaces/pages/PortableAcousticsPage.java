package com.qaprosoft.carina.demo.web.interfaces.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.interfaces.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class PortableAcousticsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@class='el-checkbox__input']")
    private List<ExtendedWebElement> checkBox;

    @FindBy(xpath = "/html/head/link[19]")
    private ExtendedWebElement linkFromPageLayout;

    @FindBy(xpath = "//div[@class='product-card__name']")
    private List<ExtendedWebElement> productName;

    @FindBy(xpath = "/html/head/link[21]")
    private ExtendedWebElement linkFromProductsPage;

    public PortableAcousticsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/uk/akustika/vid-akustiki_portativnaya/");
    }


    public void clickCheckBox() {
        checkBox.get(1).click();
    }

    public boolean isLinkFromPageLayoutVisible() {
        linkFromPageLayout.isVisible();
        return true;
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

    public boolean isLinkFromProductsPageVisible() {
        linkFromProductsPage.isVisible();
        return true;
    }


    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
