package com.qaprosoft.carina.demo.web.citrus.ua.service;

import com.qaprosoft.carina.demo.web.citrus.ua.model.UserDelivery;

public class UserDeliveryCreator {
    public static final String TESTDATA_USER_NAME_AND_SURNAME = "testdata.user.name.and.surname";
    public static final String TESTDATA_USER_MOBILE_PHONE = "testdata.user.mobile.phone";
    public static final String TESTDATA_USER_MAIL = "testdata.user.mail";
    public static final String TESTDATA_TEXT_FROM_TABLETS_PAGE = "testdata.text.from.tablets.page";
    public static final String TESTDATA_TEXT_FROM_CHECKOUT_PAGE = "testdata.text.from.checkout.page";
    public static final String TESTDATA_DESCRIPTION_CONTACT = "testdata.description.contact";
    public static final String TESTDATA_DELIVERY_CITY = "testdata.delivery.city";
    public static final String TESTDATA_DELIVERY_DEPARTMENT = "testdata.delivery.department";
    public static final String TESTDATA_DELIVERY_LOCATION = "testdata.delivery.location";

    public static UserDelivery withCredentialsFromProperty() {
        return new UserDelivery(TestDataReader.getTestData(TESTDATA_USER_NAME_AND_SURNAME),
                TestDataReader.getTestData(TESTDATA_USER_MOBILE_PHONE),
                TestDataReader.getTestData(TESTDATA_USER_MAIL),
                TestDataReader.getTestData(TESTDATA_TEXT_FROM_TABLETS_PAGE),
                TestDataReader.getTestData(TESTDATA_TEXT_FROM_CHECKOUT_PAGE),
                TestDataReader.getTestData(TESTDATA_DESCRIPTION_CONTACT),
                TestDataReader.getTestData(TESTDATA_DELIVERY_CITY),
                TestDataReader.getTestData(TESTDATA_DELIVERY_DEPARTMENT),
                TestDataReader.getTestData(TESTDATA_DELIVERY_LOCATION));
    }

    public static UserDelivery withEmptyUserNameAndSurname() {
        return new UserDelivery("", TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE, TESTDATA_DESCRIPTION_CONTACT,
                TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyUserMobilePhone() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, "", TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE, TESTDATA_DESCRIPTION_CONTACT,
                TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyUserMail() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, "",
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE, TESTDATA_DESCRIPTION_CONTACT,
                TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyTextFromTabletsPage() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                "", TESTDATA_TEXT_FROM_CHECKOUT_PAGE, TESTDATA_DESCRIPTION_CONTACT,
                TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyTextFromCheckoutPage() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, "", TESTDATA_DESCRIPTION_CONTACT,
                TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyDescriptionContact() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE, "",
                TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyDeliveryCity() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE,
                TESTDATA_DESCRIPTION_CONTACT, "", TESTDATA_DELIVERY_DEPARTMENT,TESTDATA_DELIVERY_LOCATION);
    }

    public static UserDelivery withEmptyDeliveryDepartment() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE,
                TESTDATA_DESCRIPTION_CONTACT, TESTDATA_DELIVERY_CITY, "",TESTDATA_DELIVERY_LOCATION);
    }
    public static UserDelivery withEmptyDeliveryLocation() {
        return new UserDelivery(TESTDATA_USER_NAME_AND_SURNAME, TESTDATA_USER_MOBILE_PHONE, TESTDATA_USER_MAIL,
                TESTDATA_TEXT_FROM_TABLETS_PAGE, TESTDATA_TEXT_FROM_CHECKOUT_PAGE,
                TESTDATA_DESCRIPTION_CONTACT, TESTDATA_DELIVERY_CITY, TESTDATA_DELIVERY_DEPARTMENT,"");
    }
}
