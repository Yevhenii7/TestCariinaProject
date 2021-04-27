package com.qaprosoft.carina.demo.api.github.com;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.GetRepoMethod;
import com.qaprosoft.carina.demo.methods.api.PostIssueCreateMethod;
import com.qaprosoft.carina.demo.methods.api.PostRepoCreateMethod;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class IssueCreateTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "JIRA#DEMO-005")
    @MethodOwner(owner = "qpsdemo")
    public void createNewIssueTest() {
        PostIssueCreateMethod apiIssue = new PostIssueCreateMethod();
        apiIssue.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        apiIssue.callAPI().asString();
        apiIssue.validateResponse();
        LOGGER.info("Issue created");

    }

}
