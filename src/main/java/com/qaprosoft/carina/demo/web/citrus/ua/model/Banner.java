package com.qaprosoft.carina.demo.web.citrus.ua.model;

import java.util.Objects;

public class Banner {
    private final String textFromBanner;
    private final String textFromBannerPage;

    public Banner(String titleFromBanner, String textFromBannerPage) {
        this.textFromBanner = titleFromBanner;
        this.textFromBannerPage = textFromBannerPage;
    }

    public String getTextFromBanner() {
        return textFromBanner;
    }


    public String getTextFromBannerPage() {
        return textFromBannerPage;
    }


    @Override
    public String toString() {
        return "Banner{" +
                "textFromBanner='" + textFromBanner + '\'' +
                ", textFromBannerPage='" + textFromBannerPage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner banner = (Banner) o;
        return Objects.equals(getTextFromBanner(), banner.getTextFromBanner())
                && Objects.equals(getTextFromBannerPage(), banner.getTextFromBannerPage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTextFromBanner(), getTextFromBannerPage());
    }
}
