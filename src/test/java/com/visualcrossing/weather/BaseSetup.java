package com.visualcrossing.weather;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.visualcrossing.weather.page.BasePage;
import com.visualcrossing.weather.page.WeatherDataPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.System.setProperty;

@ExtendWith({TextReportExtension.class})
public class BaseSetup {

    protected BasePage basePage = new BasePage();
    protected WeatherDataPage weatherDataPage = new WeatherDataPage();
    public static final String WEATHER_DATA = "/weather-data";
    /**
     * Setup for future use with pages:
     * public static final String WEATHER_API = "/weather-api";
     * public static final String QUERY_BUILDER = "/weather/weather-data-services";
     */

    public static void getBaseUrl() {
        baseUrl = "https://www.visualcrossing.com";
    }

    protected void openTestApplication() {
        getBaseUrl();
        open("");
        basePage.acceptCookies();
    }

    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    private static void initChromeBrowser() {
        setProperty("selenide.browser", "chrome");
        Configuration.headless = false;
    }

    @BeforeAll
    public static void init() {
        setupAllureReports();
        initChromeBrowser();
    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }

}
