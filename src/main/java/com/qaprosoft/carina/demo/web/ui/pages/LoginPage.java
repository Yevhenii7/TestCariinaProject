package com.qaprosoft.carina.demo.web.ui.pages;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.demo.web.ui.components.WeValueAdvertising;
import com.qaprosoft.carina.demo.web.ui.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//div[@class='auth']/div")
    private ExtendedWebElement userIconProfile;

    @FindBy(xpath = "//div[@class='form']//descendant::button[5]")
    private ExtendedWebElement buttonRegistration;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    private ExtendedWebElement inputName;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private ExtendedWebElement inputMobileNumber;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private ExtendedWebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private ExtendedWebElement fieldPassword;

    @FindBy(css = ".register__submit")
    private ExtendedWebElement buttonSubmitRegistration;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        open();
        LOGGER.info("Login page opened");
        return this;
    }

    public HomePage login(User user) {
        userIconProfile.click();
        buttonRegistration.click();
        inputName.type(user.getUserName());
        inputMobileNumber.type(user.getMobileNumber());
        inputEmail.type(user.getEmail());
        fieldPassword.type(user.getPassword());
        buttonSubmitRegistration.click();
        LOGGER.info("Login performed");
        return new HomePage(driver);
    }



}
