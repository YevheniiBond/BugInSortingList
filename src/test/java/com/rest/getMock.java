package com.rest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getMock {
    @Test
    public void multipleHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "value1");
        headers.put("x-mock-match-request-headers", "header");

       Headers extractedHeaders = given().
                baseUri("https://8d42fb32-1009-423d-87f1-cc45890ce951.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200).
                extract().
                headers();

        List<String> values = extractedHeaders.getValues("multiValueHeader");
        for(String value:values){
            System.out.println(value);
        }

    }
}
