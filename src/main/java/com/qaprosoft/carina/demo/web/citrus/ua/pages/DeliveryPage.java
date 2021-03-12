package com.qaprosoft.carina.demo.web.citrus.ua.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.citrus.ua.components.WeValueAdvertising;
import com.qaprosoft.carina.demo.web.citrus.ua.model.UserDelivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class DeliveryPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();


    @FindBy(xpath = "//a[contains(@href,'/planshety/')][2]")
    private ExtendedWebElement linkTablets;

    @FindBy(xpath = "//button[@class='product-card__to-basket']")
    private List<ExtendedWebElement> buttonBuy;

    @FindBy(xpath = "//div[@class='el-dialog__body']")
    private ExtendedWebElement dialogPopUpWindow;

    @FindBy(xpath = "//a[@class='btn orange full ctrs-basket-footer__order-purchase']")
    private ExtendedWebElement buttonCheckout;

    @FindBy(xpath = "//div[@class='contacts__name']//child::input")
    private ExtendedWebElement inputNameAndSurname;

    @FindBy(xpath = "//div[@class='contacts__phone']//child::input")
    private ExtendedWebElement inputMobilePhone;

    @FindBy(xpath = "//div[@class='contacts__email']//child::input")
    private ExtendedWebElement inputEmail;

    @FindBy(xpath = "//button[@class='btn-default btn-md to-confirm-step']")
    private ExtendedWebElement buttonNext;
    @FindBy(xpath = "//div[@class='step__description contacts__current-contacts']")
    private ExtendedWebElement descriptionContact;

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
    private ExtendedWebElement deliveryDepartment;

    @FindBy(xpath = "//div[contains(@class, 'ms-sel-ctn')]//*[text() = 'Відділення №1: вул. Пирогівський шлях, 135']")
    private ExtendedWebElement formDeliveryDepartment;

    @FindBy(xpath = "//button[@class='btn-default btn-md to-confirm' and text()='Далі']")
    private List<ExtendedWebElement> buttonCurrentDelivery;

    @FindBy(xpath = "//div[@class='step__description delivery__current-delivery']")
    private ExtendedWebElement currentDelivery;


    public DeliveryPage(WebDriver driver) {
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

    public HomePage checkoutDeliveryLocation(UserDelivery userDelivery) {
        inputNameAndSurname.type(userDelivery.getNameAndSurname());
        inputMobilePhone.type(userDelivery.getMobilePhone());
        inputEmail.type(userDelivery.getEmail());
        LOGGER.info("checkout delivery location performed");
        return new HomePage(driver);


    }

    public void clickButtonNext() {
        buttonNext.click();
    }

    public String readFormDescriptionContact() {
        assertElementPresent(descriptionContact);
        return descriptionContact.getText();
    }

    public boolean isFieldCitiesVisible() {
        return fieldCities.isVisible();
    }

    public void clickLinkDeliveryCity() {
        linkDeliveryRegion.click();
    }

    public String readSelectedFormDeliveryCity() {
        assertElementPresent(selectedCity);
        return selectedCity.getText();
    }

    public void clickFieldDelivery() {
        fieldDelivery.click();
    }

    public boolean isDropDownMenuVisible() {
        return dropDownMenu.isVisible();
    }

    public void clickDeliveryDepartment() {
        deliveryDepartment.click();
    }

    public String readSelectedFormDeliveryDepartment() {
        assertElementPresent(formDeliveryDepartment);
        return formDeliveryDepartment.getText();
    }

    public void clickButtonConfirm() {
        buttonCurrentDelivery.get(1).click();
    }

    public String readFormDeliveryLocation() {
        assertElementPresent(currentDelivery);
        return currentDelivery.getText();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }
}
