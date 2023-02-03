package com.rest;

import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class DownloadFile {
    @Test
    public void downloadFile() throws IOException {
        byte[] bytes = given().
                baseUri("https://raw.githubusercontent.com/appium-boneyard/sample-code/master/sample-code/apps/ApiDemos/bin/ApiDemos-debug.apk").
                log().all().
        when().get("https://raw.githubusercontent.com/appium-boneyard/sample-code/master/sample-code/apps/ApiDemos/bin/ApiDemos-debug.apk").
                then().
                log().all().
                extract().
                response().asByteArray();

        OutputStream os = new FileOutputStream(new File("ApiDemos-debug.apk"));
        os.write(bytes);
        os.close();
    }
}
