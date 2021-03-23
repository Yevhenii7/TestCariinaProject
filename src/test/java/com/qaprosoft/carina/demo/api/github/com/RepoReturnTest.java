package com.qaprosoft.carina.demo.api.github.com;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.GetAllRepoMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RepoReturnTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "JIRA#DEMO-001")
    @MethodOwner(owner = "qpsdemo")
    public void returnAllRepoTest() {
        GetAllRepoMethod allRepoMethod = new GetAllRepoMethod();
        allRepoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        allRepoMethod.callAPI();
        allRepoMethod.validateResponse();
        LOGGER.info("Repo returned");
    }


}
