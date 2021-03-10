package com.qaprosoft.carina.demo.web.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.ui.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class LaptopPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//a[contains(@href,'/uk/planshety/')][2]")
    private ExtendedWebElement linkTablets;

    @FindBy(xpath = "//button[@class='product-card__to-basket']")
    private List<ExtendedWebElement> buttonBuy;

    @FindBy(xpath = "//div[@class='el-dialog__body']")
    private ExtendedWebElement dialogPopUpWindow;

    @FindBy(xpath = "//a[@class='btn orange full ctrs-basket-footer__order-purchase']")
    private ExtendedWebElement buttonCheckout;

    @FindBy(xpath = "//div[@class='contacts__name']//child::input")
    private ExtendedWebElement fieldNameAndSurname;

    @FindBy(xpath = "//div[@class='contacts__phone']//child::input")
    private ExtendedWebElement fieldMobilePhone;

    @FindBy(xpath = "//div[@class='contacts__email']//child::input")
    private ExtendedWebElement fieldEmail;

    @FindBy(xpath = "//button[@class='btn-default btn-md to-confirm-step']")
    private ExtendedWebElement buttonNext;

    @FindBy(xpath = "//div[@class='region__cities']")
    private ExtendedWebElement fieldCities;

    @FindBy(xpath = "//li[@class='item as-link--bordered'][1]")
    private ExtendedWebElement linkDeliveryRegion;

    @FindBy(xpath = "//div[contains(@class, 'ms-sel-ctn')]//*[text() = 'Київ']")
    private ExtendedWebElement selectedCity;

    @FindBy(xpath = "//input[@type='text'][@placeholder='Вкажіть відділення']")
    private ExtendedWebElement fieldDelivery;

    @FindBy(xpath = "//div[@class='ms-res-ctn dropdown-menu']")
    private ExtendedWebElement dropDownMenu;

    @FindBy(xpath = "//div[contains(@class, 'ms-res-ctn dropdown-menu')]//*[text() = 'Відділення №1: вул. Пирогівський шлях, 135']")
    private ExtendedWebElement deliveryLocation;
    @FindBy(xpath = "//div[contains(@class, 'ms-sel-ctn')]//*[text() = 'Відділення №1: вул. Пирогівський шлях, 135']")
    private ExtendedWebElement fieldDeliveryLocation;

    @FindBy(xpath = "//button[@class='btn-default btn-md to-confirm' and text()='Далі']")
    private List<ExtendedWebElement> buttonCurrentDelivery;

    @FindBy(xpath = "//div[@class='step__description delivery__current-delivery']")
    private ExtendedWebElement currentDelivery;


    public LaptopPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.citrus.ua/uk/planshety-noutbuki-i-kompyutery/");
    }

    public void clickLinkTablets() {
        linkTablets.click();
    }

    public String getTitleFromTabletsPage() {
        String newWindow = getDriver().getWindowHandle();
        LOGGER.info(getDriver().switchTo().window(newWindow).getTitle());
        return getDriver().switchTo().window(newWindow).getTitle();
    }


    public void clickButtonBuy() {
        buttonBuy.get(0).click();
    }

    public boolean isDialogPopUpWindowAppears() {
        return dialogPopUpWindow.isVisible();
    }

    public void clickButtonCheckout() {
        buttonCheckout.click();
    }

    public void switchToNewWindow() {
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
    }

    public String getTitleFromCheckoutPage() {
        return getDriver().getTitle();

    }

    public void inputNameAndSurname(String nameAndSurname) {
        LOGGER.info("input name and surname " + nameAndSurname);
        fieldNameAndSurname.type(nameAndSurname);
    }

    public void inputMobilePhone(String mobilePhone) {
        LOGGER.info("input mobile number " + mobilePhone);
        fieldMobilePhone.type(mobilePhone);
    }

    public void inputEmail(String email) {
        LOGGER.info("input email " + email);
        fieldEmail.type(email);
    }

    public String readFieldNameAndSurname() {
        assertElementPresent(fieldNameAndSurname);
        return fieldNameAndSurname.getAttribute("autocomplete");
    }

    public String readFieldMobilePhone() {
        assertElementPresent(fieldMobilePhone);
        return fieldMobilePhone.getAttribute("autocomplete");
    }

    public String readFieldEmail() {
        assertElementPresent(fieldEmail);
        return fieldEmail.getAttribute("autocomplete");
    }

    public void clickButtonNext() {
        buttonNext.click();
    }

    public boolean isFieldCitiesVisible() {
        return fieldCities.isVisible();
    }

    public void clickLinkDeliveryRegion() {
        linkDeliveryRegion.click();
    }

    public String readSelectedCity() {
        assertElementPresent(selectedCity);
        return selectedCity.getText();
    }

    public void clickFieldDelivery() {
        fieldDelivery.click();
    }

    public boolean isDropDownMenuVisible() {
        return dropDownMenu.isVisible();
    }

    public void clickForDeliveryLocation() {
        deliveryLocation.click();
    }

    public String readSelectedDeliveryLocation() {
        assertElementPresent(fieldDeliveryLocation);
        return fieldDeliveryLocation.getText();
    }

    public void clickButtonConfirm() {
        buttonCurrentDelivery.get(1).click();
    }

    public String readConfirmationDeliveryLocation() {
        assertElementPresent(currentDelivery);
        return currentDelivery.getText();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
