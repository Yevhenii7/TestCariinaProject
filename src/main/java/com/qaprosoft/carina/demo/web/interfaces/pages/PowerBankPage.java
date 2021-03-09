package com.qaprosoft.carina.demo.web.interfaces.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.interfaces.components.WeValueAdvertising;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PowerBankPage extends AbstractPage {

//    @FindBy(xpath = "//div[@class='el-slider price-filter']/descendant::div[5]")
//    private ExtendedWebElement sliderMax;

    @FindBy(xpath = "//div[@class='el-slider__bar']")
    private ExtendedWebElement priceRange;

    @FindBy(xpath = "//span[@class='el-checkbox__input']")
    private List<ExtendedWebElement> checkBox;

    @FindBy(xpath = "/html/head/link[22]")
    private ExtendedWebElement linkFromPageLayout;


    public PowerBankPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/portativnye-batarei/");
    }

    public void selectPriceRangeSlider() throws InterruptedException {
        WebElement sliderMax = driver.findElement(By.xpath("//div[@class='el-slider price-filter']/descendant::div[5]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((sliderMax)));
        new Actions(getDriver()).dragAndDropBy(sliderMax, -30, 0).build().perform();


    }

    public boolean isPriceRangeVisible() {
        priceRange.isVisible();

        return true;
    }

    public void clickCheckBox() {
        checkBox.get(3).click();
    }

    public boolean isLinkFromPageLayoutVisible() {
        linkFromPageLayout.isVisible();
        return true;
    }


    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
