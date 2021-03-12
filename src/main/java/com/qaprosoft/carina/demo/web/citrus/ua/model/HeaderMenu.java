package com.qaprosoft.carina.demo.web.citrus.ua.model;

import java.util.Objects;

public class HeaderMenu {
    private final String textFromBunsPage;
    private final String textFromGiftsCardsPage;

    public HeaderMenu(String titleFromBunsPage, String titleFromGiftsCardsPage) {
        this.textFromBunsPage = titleFromBunsPage;
        this.textFromGiftsCardsPage = titleFromGiftsCardsPage;
    }

    public String getTextFromBunsPage() {
        return textFromBunsPage;
    }

    public String getTextFromGiftsCardsPage() {
        return textFromGiftsCardsPage;
    }

    @Override
    public String toString() {
        return "HeaderMenu{" +
                "textFromBunsPage='" + textFromBunsPage + '\'' +
                ", textFromGiftsCardsPage='" + textFromGiftsCardsPage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeaderMenu headerMenu = (HeaderMenu) o;
        return Objects.equals(getTextFromBunsPage(), headerMenu.getTextFromBunsPage())
                && Objects.equals(getTextFromGiftsCardsPage(), headerMenu.getTextFromGiftsCardsPage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTextFromBunsPage(), getTextFromGiftsCardsPage());
    }
}
