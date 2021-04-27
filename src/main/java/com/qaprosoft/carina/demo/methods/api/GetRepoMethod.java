package com.qaprosoft.carina.demo.methods.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetRepoMethod extends AbstractApiMethodV2 {

    public GetRepoMethod(String repoName) {
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_urls"));
        request.header("Authorization", "Basic RXZnZW5peTc3N0s6NDRmNzUwYzY1ODE2YzNmMTFkZDJiNGM1ZDEyYWE2N2E5NmIwODZiYg==");
        addParameterIfNotNull("id", repoName);
    }

}
