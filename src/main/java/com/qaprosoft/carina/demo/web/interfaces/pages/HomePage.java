package com.qaprosoft.carina.demo.web.interfaces.pages;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.web.interfaces.components.WeValueAdvertising;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//div[@class='auth']/div")
    private ExtendedWebElement userIconProfile;

    @FindBy(xpath = "//div[@class='form']//descendant::button[5]")
    private ExtendedWebElement buttonRegistration;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    private ExtendedWebElement fieldName;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private ExtendedWebElement fieldNumberPhone;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private ExtendedWebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private ExtendedWebElement fieldPassword;

    @FindBy(css = ".register__submit")
    private ExtendedWebElement buttonSubmitRegistration;
    @FindBy(xpath = "//div[@class='name' and contains(@title, 'Yevheniy')]")
    private ExtendedWebElement userDisplays;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickUserIconProfile() {
        userIconProfile.click();
    }

    public void clickButtonRegistration() {
        buttonRegistration.click();
    }

    public void inputName(String name) {
        LOGGER.info("input name " + name);
        fieldName.type(name);
    }

    public void inputMobileNumber(String number) {
        LOGGER.info("input number " + number);
        fieldNumberPhone.type(number);
    }

    public void inputEmail(String email) {
        LOGGER.info("input email " + email);
        fieldEmail.type(email);
    }

    public void inputPassword(String password) {
        LOGGER.info("input password " + password);
        fieldPassword.type(password);

    }

    public void submitRegistration() {
        buttonSubmitRegistration.click();
    }

    public WeValueAdvertising getWeValueAdvertising() {
        return new WeValueAdvertising(driver);
    }

    public String readButtonRegistration() {
        assertElementPresent(buttonRegistration);
        return buttonRegistration.getText();
    }

    public String readFieldName() {
        assertElementPresent(fieldName);
        return fieldName.getAttribute("placeholder");
    }

    public String readFieldMobileNumber() {
        assertElementPresent(fieldNumberPhone);
        return fieldNumberPhone.getAttribute("placeholder");
    }

    public String readFieldEmail() {
        assertElementPresent(fieldEmail);
        return fieldEmail.getAttribute("placeholder");
    }

    public String readFieldPassword() {
        assertElementPresent(fieldPassword);
        return fieldPassword.getAttribute("placeholder");
    }
    public String displayUserOnHomePage() {
        assertElementPresent(userDisplays);
        return userDisplays.getText();
    }

}
