package com.qaprosoft.carina.demo.web.interfaces;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.interfaces.pages.LaptopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryLocationTest extends AbstractTest {
    String expectedTitleFromTabletsPage = "Планшети - Купити планшет за вигідною ціною від2999 грн. " +
            "в інтернет-магазині Цитрус з доставкою по Україні: Київ, Харків, Дніпро, Одесу, Львів, Запоріжжя, Миколаїв";
    String expectedTitleFromCheckoutPage = "Інтернет-магазин “Цитрус” - гаджети та аксесуари";

    String nameAndSurname = "Zigor Ivan";
    String mobilePhone = "0978567895";
    String email = "dron@gmail.com";

    @Test(description = "JIRA#AUTO-0008")
    private void selectDeliveryLocation() {
        LaptopPage laptopPage = new LaptopPage(getDriver());
        laptopPage.open();
        Assert.assertTrue(laptopPage.isPageOpened(), "Laptop page is not opened");

        laptopPage.getWeValueAdvertising().closeAdvertisingIfOpen();

        laptopPage.clickLinkTablets();
        Assert.assertEquals(laptopPage.getTitleFromTabletsPage(), expectedTitleFromTabletsPage, "Tablets page is not available");

        laptopPage.clickButtonBuy();
        Assert.assertTrue(laptopPage.isDialogPopUpWindowAppears(), "Dialog pop up window is not visible");

        laptopPage.clickButtonCheckout();
        laptopPage.switchToNewWindow();
        Assert.assertEquals(laptopPage.getTitleFromCheckoutPage(), expectedTitleFromCheckoutPage, "Checkout page is not available");

        laptopPage.inputNameAndSurname(nameAndSurname);
        laptopPage.inputMobilePhone(mobilePhone);
        laptopPage.inputEmail(email);

        Assert.assertEquals(laptopPage.readFieldNameAndSurname(), "name", "Invalid field name and surname info!");
        Assert.assertEquals(laptopPage.readFieldMobilePhone(), "mobile tel", "Invalid field mobile phone info!");
        Assert.assertEquals(laptopPage.readFieldEmail(), "home email", "Invalid field email info!");

        laptopPage.clickButtonNext();
        Assert.assertTrue(laptopPage.isFieldCitiesVisible(), "Field cities is not visible");

        laptopPage.clickLinkDeliveryRegion();
        Assert.assertEquals(laptopPage.readSelectedCity(), "Київ", "Invalid field city info!");

        laptopPage.clickFieldDelivery();
        Assert.assertTrue(laptopPage.isDropDownMenuVisible(), "Drop down menu is not visible");

        laptopPage.clickForDeliveryLocation();
        Assert.assertEquals(laptopPage.readSelectedDeliveryLocation(), "Відділення №1: вул. Пирогівський шлях, 135", "Delivery location is not available");

        laptopPage.clickButtonConfirm();
        Assert.assertEquals(laptopPage.readConfirmationDeliveryLocation(), "Київ, Доставка у відділення «Нової Пошти», Відділення №1: вул. Пирогівський шлях, 135", "Delivery location is not available");

    }


}
