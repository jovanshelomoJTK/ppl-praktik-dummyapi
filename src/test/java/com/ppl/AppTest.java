package com.ppl;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */

    // set domain for rest assured
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";

        // set headers
        RestAssured.requestSpecification = RestAssured.given().header("app-id", "6627162d6cae03ed2fdee7a5");
    }

    @Test
    void testApp() {

        /*
         * test that the JSON schema is correct
         * {
         * id: string(autogenerated)
         * title: string("mr", "ms", "mrs", "miss", "dr", "")
         * firstName: string(length: 2-50)
         * lastName: string(length: 2-50)
         * gender: string("male", "female", "other", "")
         * email: string(email)
         * dateOfBirth: string(ISO Date - value: 1/1/1900 - now)
         * registerDate: string(autogenerated)
         * phone: string(phone number - any format)
         * picture: string(url)
         * location: object(Location)
         * }
         */


        // ...

        get("/user/60d0fe4f5311236168a109fa").then().assertThat().body("id", org.hamcrest.Matchers.notNullValue())
            .body("id", org.hamcrest.Matchers.instanceOf(String.class))
            .body("title", org.hamcrest.Matchers.instanceOf(String.class))
            .body("firstName", org.hamcrest.Matchers.instanceOf(String.class))
            .body("lastName", org.hamcrest.Matchers.instanceOf(String.class))
            .body("gender", org.hamcrest.Matchers.instanceOf(Gender.class))
                
                
    }
}
