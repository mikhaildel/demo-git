package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobilePages.AboutMenu;
import framework.mobilePages.HomeScreen;
import org.testng.Assert;

public class MobileAboutSD {

    private HomeScreen homeScreen = new HomeScreen();
    private AboutMenu aboutMenu = new AboutMenu();

    @When("^I tap on skip button again$")
    public void clickOnSkipButton() {
        homeScreen.tapOnSkipButton();
    }

    @When("^I tap on about button$")
    public void clickOnMenuButton() throws InterruptedException {
        Thread.sleep(30000);
        homeScreen.tapOnAboutButton();
    }

    @Then("^I verify about menu is displayed$")
    public void verifyAboutMenu() {
        Assert.assertTrue(aboutMenu.isAboutMenuPresent());
    }
}
