package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.DarkSkyMainPage;
import org.testng.Assert;

public class DarkskySD {

    private DarkSkyMainPage HomePage = new DarkSkyMainPage();

    @Given("^I am on Darksky homepage$")
    public void iAmOnDarkskyHomePage() {
        Assert.assertTrue(HomePage.isDarkSkyTitleDisplayed());
    }

    @And("^The current timeline is displayed correctly with 2 hour increment$")
    public void isCurrentTimelineDisplayedCorrectly() {
        Assert.assertTrue(HomePage.isHourTimelineDisplayedCorrectly());
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void isLowestAndHighestTemperatureDisplayedCorrectly() throws InterruptedException {
        Assert.assertTrue(HomePage.isLowestAndHighestTempDisplayedCorrectly());
    }

    @Then("^I verify that the current temperature is within the timeline$")
    public void isCurrentTemperatureWithinTimeline() {
       Assert.assertTrue(HomePage.isCurrentTemperatureWithinTheTimeline());
    }


}
