package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class RequestPayloadAsJsonArray {
    ResponseSpecification customResponseSpecification;
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://8d42fb32-1009-423d-87f1-cc45890ce951.mock.pstmn.io").
                addHeader("x-mock-match-request-body","true").
                setContentType("application/json;charset=utf-8").
                log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);

        customResponseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void validate_post_request_payload_json_array_as_list(){
        HashMap<String,String> obj5001 = new HashMap<String,String>();
        obj5001.put("id","5001");
        obj5001.put("type","None");

        HashMap<String,String> obj5002 = new HashMap<String,String>();
        obj5002.put("id","5002");
        obj5002.put("type","Glazed");

        List<Map> jsonList = new ArrayList<Map>();
        jsonList.add(obj5001);
        jsonList.add(obj5002);
        given().
                body(jsonList).
        when().
                post("/post").
        then().spec(customResponseSpecification).
                assertThat().
                body("msg",equalTo("Success"));
    }
}
