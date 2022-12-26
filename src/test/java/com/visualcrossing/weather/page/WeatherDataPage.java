package com.visualcrossing.weather.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WeatherDataPage extends BasePage {

    SelenideElement inputLocationField = $("input#wxlocation");
    SelenideElement buttonSearchLocation = $("#wxdataform button[type=\"submit\"]");

    public WeatherDataPage setLocationInSearchFieldAndSearch(String location) {
        inputLocationField.should(appear).setValue(location);
        buttonSearchLocation.should(appear).click();
        return this;
    }

    /**
     * Check of location name in topic h1, h3, and in "Location and station map" table
     * @param location name of city or region.
     */
    public void checkSearchResultTopics(String location) {
        $("h1")
                .should(appear)
                .shouldHave(text("Weather History Dashboard for "+location));
        $("#weatherSummary .d-flex h3")
                .should(appear)
                .shouldHave(text("Weather History for "+location));
        $$("div.widget.twocols table.table-striped.fs-xs tbody td")
                .shouldHave(size(55))
                .get(0).getText().equals(location.toUpperCase()+", EN");
    }

}
