package com.qaprosoft.carina.demo.web.citrus.ua.service;

import com.qaprosoft.carina.demo.web.citrus.ua.model.HeaderMenu;

public class HeaderMenuCreator {
    public static final String TESTDATA_TEXT_FROM_BUNS_PAGE = "testdata.title.from.buns.page";
    public static final String TESTDATA_TEXT_FROM_GIFTS_CARDS_PAGE = "testdata.title.from.gifts.cards.page";

    public static HeaderMenu withCredentialsFromProperty() {
        return new HeaderMenu(TestDataReader.getTestData(TESTDATA_TEXT_FROM_BUNS_PAGE),
                TestDataReader.getTestData(TESTDATA_TEXT_FROM_GIFTS_CARDS_PAGE));
    }

    public static HeaderMenu withEmptyTitleFromBunsPage() {
        return new HeaderMenu("", TESTDATA_TEXT_FROM_GIFTS_CARDS_PAGE);
    }

    public static HeaderMenu withEmptyTitleFromGiftsCardsPage() {
        return new HeaderMenu(TESTDATA_TEXT_FROM_BUNS_PAGE, "");
    }


}
