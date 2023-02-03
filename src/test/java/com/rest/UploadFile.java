package com.rest;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UploadFile {

    @Test
    public void uploadFileMultipartFormData(){
        String attributes = "{\"name\":\"template.txt\",\"parent\":{\"id\":\"123456\"}}";
        given().
                baseUri("https://postman-echo.com").
                multiPart("file",
                        new File("src/main/resources/Api.jsonFile/template.txt")).
                multiPart("attributes",attributes,"application/json").
                log().all().
        when().
                post("/post").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
