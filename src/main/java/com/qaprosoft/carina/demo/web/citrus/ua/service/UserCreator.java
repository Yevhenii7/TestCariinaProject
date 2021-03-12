package com.qaprosoft.carina.demo.web.citrus.ua.service;

import com.qaprosoft.carina.demo.web.citrus.ua.model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_MOBILE_NUMBER = "testdata.user.mobile.number";
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_MOBILE_NUMBER),
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyUserName() {
        return new User("", TESTDATA_USER_MOBILE_NUMBER, TESTDATA_USER_EMAIL, TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyUserMobilePhone() {
        return new User(TESTDATA_USER_NAME, "", TESTDATA_USER_EMAIL, TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyEmail() {
        return new User(TESTDATA_USER_NAME, TESTDATA_USER_MOBILE_NUMBER, "", TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(TESTDATA_USER_NAME, TESTDATA_USER_MOBILE_NUMBER, TESTDATA_USER_EMAIL, "");
    }
}
