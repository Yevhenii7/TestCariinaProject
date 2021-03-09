package com.qaprosoft.carina.demo.web.interfaces;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.interfaces.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserRegistrationTest extends AbstractTest {
    private String name = "Yevheniy";
    private String mobileNumber = "0979581550";
    private String email = "gladiatordd@gmail.com";
    private String password = "qwerty1235657897969";

    @Test(description = "JIRA#AUTO-0001")
    public void createUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getWeValueAdvertising().closeAdvertisingIfOpen();
        homePage.clickUserIconProfile();
        Assert.assertEquals(homePage.readButtonRegistration(), "Зарегистрироваться", "Invalid fieldName info!");

        homePage.clickButtonRegistration();

        homePage.inputName(name);
        homePage.inputMobileNumber(mobileNumber);
        homePage.inputEmail(email);
        homePage.inputPassword(password);

        homePage.submitRegistration();

        Assert.assertEquals(homePage.readFieldName(), "Имя", "Invalid fieldName info!");
        Assert.assertEquals(homePage.readFieldMobileNumber(), "Номер телефона", "Invalid fieldMobileNumber info!");
        Assert.assertEquals(homePage.readFieldEmail(), "Email", "Invalid fieldEmail info!");
        Assert.assertEquals(homePage.readFieldPassword(), "Пароль", "Invalid fieldPassword info!");
        Assert.assertEquals(homePage.displayUserOnHomePage(), "Здравствуйте,\n" + "Yevheniy", "Invalid displayUser info!");

    }


}
