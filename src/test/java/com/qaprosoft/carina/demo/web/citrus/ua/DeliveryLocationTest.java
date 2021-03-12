package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.model.UserDelivery;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.DeliveryPage;
import com.qaprosoft.carina.demo.web.citrus.ua.service.UserDeliveryCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryLocationTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0008")
    private void selectDeliveryLocation() {
        UserDelivery userDelivery = UserDeliveryCreator.withCredentialsFromProperty();
        DeliveryPage deliveryPage = new DeliveryPage(getDriver());
        deliveryPage.open();
        Assert.assertTrue(deliveryPage.isPageOpened(), "Laptop page is not opened");

//        deliveryPage.getWeValueAdvertising().closeAdvertisingIfOpen();

        deliveryPage.clickLinkTablets();
        Assert.assertEquals(userDelivery.getTextFromTabletsPage(), deliveryPage.getTitleFromTabletsPage(), "Tablets page is not available");

        deliveryPage.clickButtonBuy();
        Assert.assertTrue(deliveryPage.isDialogPopUpWindowAppears(), "Dialog pop up window is not visible");

        deliveryPage.clickButtonCheckout();
        deliveryPage.switchToNewWindow();
        Assert.assertEquals(userDelivery.getTextFromCheckoutPage(), deliveryPage.getTitleFromCheckoutPage(), "Checkout page is not available");

        deliveryPage.checkoutDeliveryLocation(userDelivery);

        deliveryPage.clickButtonNext();
        Assert.assertEquals(deliveryPage.readFormDescriptionContact(), userDelivery.getFormDescriptionContact(), "Description contact form is not appears!");
        Assert.assertTrue(deliveryPage.isFieldCitiesVisible(), "Field cities is not visible");

        deliveryPage.clickLinkDeliveryCity();
        Assert.assertEquals(deliveryPage.readSelectedFormDeliveryCity(), userDelivery.getFormDeliveryCity(), "Delivery city form is not appears!");

        deliveryPage.clickFieldDelivery();
        Assert.assertTrue(deliveryPage.isDropDownMenuVisible(), "Drop down menu is not visible");

        deliveryPage.clickDeliveryDepartment();
        Assert.assertEquals(deliveryPage.readSelectedFormDeliveryDepartment(), userDelivery.getFormDeliveryDepartment(), "Delivery department form is not appears");

        deliveryPage.clickButtonConfirm();
        Assert.assertEquals(deliveryPage.readFormDeliveryLocation(), userDelivery.getFormDeliveryLocation(), "Delivery location form is not appears");

    }


}
