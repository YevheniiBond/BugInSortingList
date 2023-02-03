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

public class AutomatePut {
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
    public void validate_post_request_bdd_style(){
        String workspaceId = "9cb6c20b-ac2b-4d57-be17-d43ae50f6152";
        String payload = "{\n" +
                "    \"workspace\": {\n" +
                "        \"name\": \"newWorkspaceName\",\n" +
                "        \"type\": \"personal\",\n" +
                "        \"description\": \"Rest Assured created this\"\n" +
                "    }\n" +
                "}";
        given().
                body(payload).
        when().
                put("/workspaces/" + workspaceId).
        then().
                log().all().
                assertThat().
                        body("workspace.id", equalTo(workspaceId),
                                "workspace.name", equalTo("newWorkspaceName"));
    }
}

