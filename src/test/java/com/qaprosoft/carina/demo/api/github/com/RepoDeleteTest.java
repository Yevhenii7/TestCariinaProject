package com.qaprosoft.carina.demo.api.github.com;

import com.jayway.jsonpath.JsonPath;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.methods.api.DeleteRepoMethod;
import com.sun.jersey.core.spi.factory.ResponseBuilderHeaders;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.restassured.builder.ResponseBuilder;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.ResponseSpecification;
import javassist.tools.web.BadHttpRequest;
import org.apache.http.client.ResponseHandler;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.jsoup.helper.HttpConnection;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RepoDeleteTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test(description = "JIRA#DEMO-004")
    @MethodOwner(owner = "qpsdemo")
    public void deleteCurrentRepoTest() {
        DeleteRepoMethod apiDelete = new DeleteRepoMethod();
        apiDelete.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
//        String response = apiDelete.callAPI().asString();
//        response = ResponseData(response);
//        Assert.assertEquals(JsonPath.read(response, "204"), "No Content", "Invalid status in response!");

        apiDelete.callAPI();
        apiDelete.validateResponse();
    }
}
