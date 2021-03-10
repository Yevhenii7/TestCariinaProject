package com.qaprosoft.carina.demo.web.ui.service;

import com.qaprosoft.carina.demo.web.ui.model.User;

public class UserCreator {
    public static final String USER_NAME = "Yevheniy";
    public static final String USER_MOBILE_NUMBER = "0679581455";
    public static final String USER_EMAIL = "ladiatdordgd@gmail.com";
    public static final String USER_PASSWORD = "qwerty1235565789796393";

    public static User withCredentialsFromProperty() {
        return new User(USER_NAME, USER_MOBILE_NUMBER, USER_EMAIL, USER_PASSWORD);
    }

    public static User withEmptyUserName() {
        return new User("", USER_MOBILE_NUMBER, USER_EMAIL, USER_PASSWORD);
    }

    public static User withEmptyUserMobilePhone() {
        return new User(USER_NAME, "", USER_EMAIL, USER_PASSWORD);
    }

    public static User withEmptyEmail() {
        return new User(USER_NAME, USER_MOBILE_NUMBER, "", USER_PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(USER_NAME, USER_MOBILE_NUMBER, USER_EMAIL, "");
    }
}
