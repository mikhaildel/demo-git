@web @regression @darkSky
Feature: DarkSky feature

  Background:
    Given I am on Darksky homepage
    And The current timeline is displayed correctly with 2 hour increment

    @task
    Scenario: Verify how the temperature is displayed
    Then I verify lowest and highest temp is displayed correctly
    Then I verify that the current temperature is within the timeline