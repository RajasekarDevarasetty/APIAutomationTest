package StepDefinitions;

import POM.WeatherDataPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
//import org.testng.annotations.Test;


public class WeatherDataStepDef {

    WeatherDataPage weatherDataPage = new WeatherDataPage();

    @Given("The weather data service endpoint")
    public void getWeatherDataEndPoint()
    {
        weatherDataPage.getWeatherDataService();
    }

    @When("The user access want to see weather data info based on city")
    public void getWeatherData()
    {
        weatherDataPage.getWeatherData();
    }

    @Then("Validate the response of weather data service")
    public void validateWeatherData()
    {
        weatherDataPage.validateWeatherData();
    }



}
