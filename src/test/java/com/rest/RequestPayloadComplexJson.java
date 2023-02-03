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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestPayloadComplexJson {
    ResponseSpecification customResponseSpecification;

    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://8d42fb32-1009-423d-87f1-cc45890ce951.mock.pstmn.io").
                addHeader("x-mock-match-request-body", "true").
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
    public void requestPayloadComplexJson() {

        List<Integer> idArrayList = new ArrayList<>();
        idArrayList.add(5);
        idArrayList.add(9);

        HashMap<String, Object> batterHashMa2 = new HashMap<>();
        batterHashMa2.put("id", idArrayList);
        batterHashMa2.put("type", "Chocolate");

        HashMap<String, Object> batterHashMa1 = new HashMap<>();
        batterHashMa1.put("id", "1001");
        batterHashMa1.put("type", "Regular");

        List<HashMap<String, Object>> batterArrayList = new ArrayList<>();
        batterArrayList.add(batterHashMa1);
        batterArrayList.add(batterHashMa2);

        HashMap<String, List<HashMap<String, Object>>> battersHashMap =
                new HashMap<>();
        battersHashMap.put("batter", batterArrayList);

        List<String> typeArrayList = new ArrayList<>();
        typeArrayList.add("test1");
        typeArrayList.add("test2");

        HashMap<String, Object> toppingHashMap2 = new HashMap<>();
        toppingHashMap2.put("id", "5002");
        toppingHashMap2.put("type", typeArrayList);

        HashMap<String, Object> toppingHashMap1 = new HashMap<>();
        toppingHashMap1.put("id", "5001");
        toppingHashMap1.put("type", "None");

        List<HashMap<String, Object>> toppingArrayList = new ArrayList<>();
        toppingArrayList.add(toppingHashMap1);
        toppingArrayList.add(toppingHashMap2);

        HashMap<String, Object> mainHashMap = new HashMap<>();
        mainHashMap.put("id", "001");
        mainHashMap.put("type", "donut");
        mainHashMap.put("name", "Cake");
        mainHashMap.put("ppu", 0.55);
        mainHashMap.put("batters", battersHashMap);
        mainHashMap.put("topping", toppingArrayList);

        given().
                body(mainHashMap).
                when().
                post("/postComplexJson").
                then().spec(customResponseSpecification).
                assertThat().
                body("msg", equalTo("Success"));
    }
}