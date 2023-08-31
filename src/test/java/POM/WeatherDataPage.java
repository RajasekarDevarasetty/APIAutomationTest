package POM;

import Configuration.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class WeatherDataPage {

    String weatherDataService = "";
    Response apiResponse = null;
    public void getWeatherDataService()
    {
        weatherDataService = ConfigReader.getWeatherDataEndpoint();
    }

    public void getWeatherData()
    {
        RequestSpecification apiRequest = RestAssured.given();
        apiRequest.header("contentType", "json");
        apiResponse = apiRequest.get(weatherDataService);
    }

    public void validateWeatherData()
    {
        //System.out.println("apiResponse.getStatusCode() :"+ apiResponse.getStatusCode());
        //System.out.println("apiResponse.jsonPath().get(\"address\") :"+ apiResponse.jsonPath().get("address"));
        Assert.assertEquals(apiResponse.getStatusCode(),200);
        Assert.assertEquals(apiResponse.jsonPath().get("address"),"Bangalore");
    }
}
