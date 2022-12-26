package com.visualcrossing.weather.test;

import com.codeborne.selenide.Selenide;
import com.visualcrossing.weather.BaseSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WeatherForecastFromUITests extends BaseSetup {

    @BeforeEach
    void setupTests() {
        Selenide.clearBrowserCookies();
        openTestApplication();
    }

    @Test
    @Tag("weatherData")
    @DisplayName("Weather forecast for Tallinn city")
    void checkWeatherForTallinnCity() {
        String testLocationTallinn = "Tallinn";

        basePage.clickOnWeatherDataButton();
        weatherDataPage
                .setLocationInSearchFieldAndSearch(testLocationTallinn)
                .checkSearchResultTopics(testLocationTallinn);
    }

}
