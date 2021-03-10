package com.qaprosoft.carina.demo.web.ui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.ui.model.User;
import com.qaprosoft.carina.demo.web.ui.pages.LoginPage;
import com.qaprosoft.carina.demo.web.ui.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserRegistrationTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001")
    public void createUser() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(getDriver())
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(loggedInUserName, (testUser.getUserName()));

    }


}
