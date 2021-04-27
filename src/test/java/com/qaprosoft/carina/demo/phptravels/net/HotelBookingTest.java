package com.qaprosoft.carina.demo.phptravels.net;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.phptravels.net.pages.DetailInfoPage;
import com.qaprosoft.carina.demo.phptravels.net.pages.HomePage;
import com.qaprosoft.carina.demo.phptravels.net.pages.HotelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HotelBookingTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001")
    public void bookingRoomTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HotelsPage hotelsPage = homePage.selectHotel("Alzer Hotel Istanbul, Istanbul");
        hotelsPage.clickNextPage();
        DetailInfoPage detailInfoPage = hotelsPage.selectHotel("Rendezvous Hotels");
        Assert.assertEquals(detailInfoPage.readNameHotel(), "Rendezvous Hotels", "The hotel is not available");


    }


}
