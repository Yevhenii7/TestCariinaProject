package com.qaprosoft.carina.demo.methods.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostIssueCreateMethod extends AbstractApiMethodV2 {

    public PostIssueCreateMethod() {
        super("api.github/post.repo/rq.json","api.github/post.repo/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_urls"));
        request.header("Authorization", "Basic RXZnZW5peTc3N0s6NDRmNzUwYzY1ODE2YzNmMTFkZDJiNGM1ZDEyYWE2N2E5NmIwODZiYg==");

    }
}
