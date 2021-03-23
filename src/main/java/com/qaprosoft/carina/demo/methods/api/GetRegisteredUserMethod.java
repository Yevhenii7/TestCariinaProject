package com.qaprosoft.carina.demo.methods.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetRegisteredUserMethod extends AbstractApiMethodV2 {

    public GetRegisteredUserMethod() {
        super(null, "api.user.registration/_get/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
