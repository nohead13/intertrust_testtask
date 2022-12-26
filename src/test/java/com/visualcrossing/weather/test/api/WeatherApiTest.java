package com.visualcrossing.weather.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.visualcrossing.weather.test.api.Specifications.*;
import static io.restassured.RestAssured.given;

public class WeatherApiTest {

    private final String unitGroupMetric = "metric";
    private String key = "8KGP8Q526UJPKHTA399UZNUA6";
    private final String contentTypeJson = "json";
    private String location;

   private final String URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    @Test
    public void checkNotExistLocationTest() {
        location = "Lasnalinn";
        installSpecification(requestSpecification(URL),responseSpecError400());
        String message = given()
                .when()
                .get(location+"?unitGroup="+ unitGroupMetric +"&key="+key+"&contentType="+ contentTypeJson)
                .then()
                .extract().body().asString();
        Assertions.assertEquals("Invalid location found. Please check your location parameter:"+location, message);
    }

    @Test
    public void checkCorrectLocationTest() {
        location = "Tallinn";
        installSpecification(requestSpecification(URL),responseSpecOK200());
        String city = given()
                .when()
                .get(location+"?unitGroup="+unitGroupMetric+"&key="+key+"&contentType="+contentTypeJson)
                .then()//.log().status()
                .extract().body().jsonPath()
                .getJsonObject("resolvedAddress");
        Assertions.assertEquals("Tallinn, Eesti", city);
    }
}
