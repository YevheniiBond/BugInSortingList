package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;



public class RequestSpecificationExample {
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.postman.com");
        requestSpecBuilder.addHeader("X-Api-Key","PMAK-63a6c597f6d13f4ddf5f3a00-282fa4fc0954b209fd7d2efefc6bc5e3fb");
requestSpecBuilder.log(LogDetail.ALL);

        RestAssured.requestSpecification  = requestSpecBuilder.build();
    }

    @Test
    public void validateStatusCode() {
        Response response = get("/workspaces").
        then().
                log().all().
                contentType(ContentType.JSON).
                extract().
                response();
        assertThat(response.statusCode(), is(equalTo(200)));
    }

    @Test
    public void validateResponseBody() {
        Response response = get("/workspaces").
        then().
                log().
                all().
                contentType(ContentType.JSON).
                extract().
                response();
        assertThat(response.statusCode(), is(equalTo(200)));
        assertThat(response.path("workspaces[0].name"), equalTo("My Workspace"));
    }
}
