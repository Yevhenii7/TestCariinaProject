package com.qaprosoft.carina.demo.api.github.com;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.UpdateIssueMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class IssueUpdateTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "JIRA#DEMO-003")
    @MethodOwner(owner = "qpsdemo")
    public void updateRepoTest() {
        UpdateIssueMethod apiPatchIssue = new UpdateIssueMethod();
        apiPatchIssue.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiPatchIssue.callAPI();
        apiPatchIssue.validateResponse();
        LOGGER.info("Issue updated");
    }
}
