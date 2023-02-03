package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecificationExample {

        @BeforeClass
        public void beforeClass(){
            RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
            requestSpecBuilder.setBaseUri("https://api.postman.com");
            requestSpecBuilder.addHeader("X-Api-Key","PMAK-63a6c597f6d13f4ddf5f3a00-282fa4fc0954b209fd7d2efefc6bc5e3fb");
            requestSpecBuilder.log(LogDetail.ALL);

            RestAssured.requestSpecification  = requestSpecBuilder.build();

//            responseSpecification = RestAssured.expect().
//                    statusCode(200).
//                    contentType(ContentType.JSON).
//                    log().all();

            ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                    expectStatusCode(200).
                    expectContentType(ContentType.JSON).
                    log(LogDetail.ALL);
            RestAssured.responseSpecification = responseSpecBuilder.build();
        }

        @Test
        public void validateStatusCode() {
            get("/workspaces");
        }

        @Test
        public void validateResponseBody() {
            Response response = get("/workspaces").
            then().
                    extract().
                    response();
            assertThat(response.path("workspaces[0].name"), equalTo("My Workspace"));
        }
    }

