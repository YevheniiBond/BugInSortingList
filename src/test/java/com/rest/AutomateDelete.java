package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AutomateDelete {
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").
                addHeader("X-Api-Key","PMAK-63a6c597f6d13f4ddf5f3a00-282fa4fc0954b209fd7d2efefc6bc5e3fb").
                log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void automateDelete(){
    String workspaceId = "73edcec3-bc53-47ad-8686-c0ddb5b2106b";
    given().
            pathParam("workspaceId", workspaceId).
    when().
            delete("/workspaces/{workspaceId}").
    then().
            log().all().
    assertThat().
            body("workspace.id", equalTo(workspaceId));
}
}
