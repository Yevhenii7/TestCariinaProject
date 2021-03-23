package com.qaprosoft.carina.demo.web.citrus.ua;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.citrus.ua.model.User;
import com.qaprosoft.carina.demo.web.citrus.ua.pages.LoginPage;
import com.qaprosoft.carina.demo.web.citrus.ua.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserRegistrationTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001")
    public void createUser() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(getDriver())
                .openPage()
                .login(testUser)
                .getLoggedUserName();
        Assert.assertEquals(loggedInUserName, (testUser.getUserName()));


    }


}
