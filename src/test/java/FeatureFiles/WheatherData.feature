

Feature: List of Scenarios for Weather Data Service where user looking for info based on city
  @SmokeTest
  Scenario: Verify that the weather data service works as expected
    Given The weather data service endpoint
    When The user access want to see weather data info based on city
    Then Validate the response of weather data service