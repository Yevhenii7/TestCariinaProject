package com.qaprosoft.carina.demo.web.citrus.ua.service;

import com.qaprosoft.carina.demo.web.citrus.ua.model.Banner;

public class BannerCreator {
    public static final String TESTDATA_TEXT_FROM_BANNER = "testdata.title.from.banner";
    public static final String TESTDATA_TEXT_FROM_BANNER_PAGE = "testdata.text.from.banner.page";

    public static Banner withCredentialsFromProperty() {
        return new Banner(TestDataReader.getTestData(TESTDATA_TEXT_FROM_BANNER),
                TestDataReader.getTestData(TESTDATA_TEXT_FROM_BANNER_PAGE));
    }

    public static Banner withEmptyTextFromBanner() {
        return new Banner("", TESTDATA_TEXT_FROM_BANNER_PAGE);
    }

    public static Banner withEmptyTextFromBannerText() {
        return new Banner(TESTDATA_TEXT_FROM_BANNER, "");
    }
}
