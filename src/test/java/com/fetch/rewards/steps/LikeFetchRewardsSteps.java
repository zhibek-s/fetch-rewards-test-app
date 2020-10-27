package com.fetch.rewards.steps;

import com.fetch.rewards.driver.Driver;
import com.fetch.rewards.pages.FacebookScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LikeFetchRewardsSteps {

    private FacebookScreen facebookScreen;
    private WebDriver driver;

    @Given("setup for device {string}")
    public void setup_for_device(String device) throws InterruptedException {
        driver = Driver.getDriver(device);
        facebookScreen = new FacebookScreen(driver);
    }

    @Given("user logins to facebook app with credentials {string}, {string}")
    public void user_logins_to_facebook_app_with_credentials(String username, String password) throws InterruptedException {
        facebookScreen.loginFacebook(username, password);
        Thread.sleep(20000);
    }

    @When("user searches and opens page {string}")
    public void user_searches_and_opens_page(String page) throws InterruptedException {
        facebookScreen.searchFetchRewards(page);
        Thread.sleep(30000);
    }

    @Then("user clicks on like button")
    public void user_clicks_on_like_button() throws InterruptedException {
        facebookScreen.likeFetchRewards();
        System.out.println("-----End");
        Thread.sleep(30000);
    }
}
