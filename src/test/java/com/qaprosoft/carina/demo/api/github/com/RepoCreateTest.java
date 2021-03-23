package com.qaprosoft.carina.demo.api.github.com;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.GetAllRepoMethod;
import com.qaprosoft.carina.demo.methods.api.GetRepoMethod;
import com.qaprosoft.carina.demo.methods.api.PostRepoCreateMethod;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RepoCreateTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "JIRA#DEMO-002")
    @MethodOwner(owner = "qpsdemo")
    public void createNewRepoTest() {
        PostRepoCreateMethod apiRepo = new PostRepoCreateMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String rs = apiRepo.callAPI().asString();
        apiRepo.validateResponse();
        LOGGER.info("Repo created");
        String repoName = new JsonPath(rs).getString("name");
        GetRepoMethod getRepoMethod = new GetRepoMethod(String.valueOf(repoName));
        getRepoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getRepoMethod.callAPI();
    }

}
