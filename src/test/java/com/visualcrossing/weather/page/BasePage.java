package com.visualcrossing.weather.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BasePage {

    //Nav-links
    SelenideElement weatherDataNavButton = $("#navbarNav a[href=\"/weather-data\"]");

    public void clickOnWeatherDataButton() {
        weatherDataNavButton.should(appear).click();
        webdriver().shouldHave(url("https://www.visualcrossing.com/weather-data"));
    }

     public void acceptCookies() {
        $("#errorModal button.btn-primary.col-lg-3").should(appear).click();
    }

}
