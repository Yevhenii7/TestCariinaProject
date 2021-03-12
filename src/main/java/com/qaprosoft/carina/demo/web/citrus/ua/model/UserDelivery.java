package com.qaprosoft.carina.demo.web.citrus.ua.model;

import java.util.Objects;

public class UserDelivery {
    private final String nameAndSurname;
    private final String mobilePhone;
    private final String email;
    private final String textFromTabletsPage;
    private final String textFromCheckoutPage;
    private final String descriptionContact;
    private final String deliveryCity;
    private final String deliveryDepartment;
    private final String deliveryLocation;


    public UserDelivery(String nameAndSurname, String mobilePhone, String email, String textFromTabletsPage, String textFromCheckoutPage, String descriptionContact, String deliveryCity, String deliveryDepartment, String deliveryLocation) {
        this.nameAndSurname = nameAndSurname;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.textFromTabletsPage = textFromTabletsPage;
        this.textFromCheckoutPage = textFromCheckoutPage;
        this.descriptionContact = descriptionContact;
        this.deliveryCity = deliveryCity;
        this.deliveryDepartment = deliveryDepartment;
        this.deliveryLocation = deliveryLocation;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getTextFromTabletsPage() {
        return textFromTabletsPage;
    }

    public String getTextFromCheckoutPage() {
        return textFromCheckoutPage;
    }

    public String getFormDescriptionContact() {
        return descriptionContact;
    }

    public String getFormDeliveryCity() {
        return deliveryCity;
    }

    public String getFormDeliveryDepartment() {
        return deliveryDepartment;
    }

    public String getFormDeliveryLocation() {
        return deliveryLocation;
    }

    @Override
    public String toString() {
        return "UserDelivery{" +
                "nameAndSurname='" + nameAndSurname + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", textFromTabletsPage='" + textFromTabletsPage + '\'' +
                ", textFromCheckoutPage='" + textFromCheckoutPage + '\'' +
                ", descriptionContact='" + descriptionContact + '\'' +
                ", deliveryCity='" + deliveryCity + '\'' +
                ", deliveryDepartment='" + deliveryDepartment + '\'' +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDelivery userDelivery = (UserDelivery) o;
        return Objects.equals(getNameAndSurname(), userDelivery.getNameAndSurname())
                && Objects.equals(getMobilePhone(), userDelivery.getMobilePhone())
                && Objects.equals(getEmail(), userDelivery.getEmail())
                && Objects.equals(getTextFromTabletsPage(), userDelivery.getTextFromTabletsPage())
                && Objects.equals(getTextFromCheckoutPage(), userDelivery.getTextFromCheckoutPage())
                && Objects.equals(getFormDescriptionContact(), userDelivery.getFormDescriptionContact())
                && Objects.equals(getFormDeliveryCity(), userDelivery.getFormDeliveryCity())
                && Objects.equals(getFormDeliveryDepartment(), userDelivery.getFormDeliveryDepartment())
                && Objects.equals(getFormDeliveryLocation(), userDelivery.getFormDeliveryLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameAndSurname(), getMobilePhone(), getEmail(), getTextFromTabletsPage(),
                getTextFromCheckoutPage(), getFormDescriptionContact(), getFormDeliveryCity(), getFormDeliveryDepartment(), getFormDeliveryLocation());
    }
}

