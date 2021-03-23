/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.api.reqres.in;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.GetRegisteredUserMethod;
import com.qaprosoft.carina.demo.methods.api.PostUserRegistrationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class UserRegistrationTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test(description = "JIRA#DEMO-001")
    @MethodOwner(owner = "qpsdemo")
    public void createUserTest() throws Exception {
        LOGGER.info("test");
        PostUserRegistrationMethod api = new PostUserRegistrationMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

    @Test(description = "JIRA#DEMO-002")
    @MethodOwner(owner = "qpsdemo")
    public void getUserRegisteredTest() {
        GetRegisteredUserMethod getUsersMethod = new GetRegisteredUserMethod();
        getUsersMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsersMethod.callAPI();
        getUsersMethod.validateResponse();
    }


}
