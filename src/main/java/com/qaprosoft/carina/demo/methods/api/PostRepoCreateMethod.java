package com.qaprosoft.carina.demo.methods.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostRepoCreateMethod extends AbstractApiMethodV2 {

    public PostRepoCreateMethod() {
        super("api.github/_post/rq.json","api.github/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_urls"));
        request.header("Authorization", "Basic RXZnZW5peTc3N0s6NDRmNzUwYzY1ODE2YzNmMTFkZDJiNGM1ZDEyYWE2N2E5NmIwODZiYg==");

    }
}
