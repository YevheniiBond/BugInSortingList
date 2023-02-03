package com.rest;

/*Якщо зробити імпорти не статичні,
то постійно потрібно буде просписувати
назву класу перед методом*/

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*Якщо написати статік в імпорті,
 то не потрібно буде постійно
  прописувати назву класу "RestAssured"*/

public class AutomateGet {

    @Test
    public void validateGetStatusCode() {

       String name = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key",
                        "PMAK-63a6c597f6d13f4ddf5f3a00-282fa4fc0954b209fd7d2efefc6bc5e3fb").
        when().
                get("/workspaces").
        then().
//                log().all(). //дуже важливо писати налаштування логу перед "асертом", а не після
                assertThat().
                statusCode(200).
               extract().
               response().path("workspaces[0].name");
        System.out.println("workspace name =   " + name);

        assertThat(name, equalTo("My Workspace"));

    }
}
