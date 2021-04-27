package com.qaprosoft.carina.demo.api.github.com;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.PatchRepoMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RepoUpdateTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "JIRA#DEMO-003")
    @MethodOwner(owner = "qpsdemo")
    public void updateRepoTest() {
        PatchRepoMethod apiPatch = new PatchRepoMethod();
        apiPatch.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiPatch.callAPI();
        apiPatch.validateResponse();
        LOGGER.info("Repo updated");
    }
}
