package com.cydeo.step_definitions;

import com.cydeo.pages.Vytrack_pages.DashboardPage;
import com.cydeo.pages.Vytrack_pages.LoginPage;
import com.cydeo.pages.Vytrack_pages.VehiclesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RefreshBtn_StepDefinitions {

    WebDriver driver = Driver.getDriver();

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage=new DashboardPage();

    VehiclesPage vehiclesPage = new VehiclesPage();

    WebDriverWait wait;

    String username = ConfigurationReader.getProperty("vytrack_username");
    String password = ConfigurationReader.getProperty("vytrack_password");

    /*
    @Given("the truck driver is on Vytrack homepage")
    public void the_truck_driver_is_on_vytrack_homepage() {

        driver.get(ConfigurationReader.getProperty("vytrack_login_url"));

        loginPage.login(username,password);

    }
    @When("the truck driver clicks on Fleet dropdown")
    public void the_truck_driver_clicks_on_fleet_dropdown() {


        BrowserUtils.waitForClickablility(dashboardPage.fleetBtn, 10);
        dashboardPage.fleetBtn.click();
    }
    @Then("the truck driver clicks on Vehicles under fleet dropdown")
    public void the_truck_driver_clicks_on_vehicles_under_fleet_dropdown() {

        BrowserUtils.waitForClickablility(dashboardPage.vehiclesBtn, 10);
        dashboardPage.vehiclesBtn.click();
    }

     */
    @Then("the truck driver sees the title of the page {string}")
    public void the_truck_driver_sees_the_title_of_the_page(String expectedTitle) {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertEquals(expectedTitle, driver.getTitle());

    }



    @When("the driver sees Refresh button on the left side of Reset button")
    public void the_driver_sees_refresh_button_on_the_left_side_of_reset_button() {

        boolean isOnLeft = vehiclesPage.IfBtnOnTheLeft("Reset","Refresh");

        Assert.assertTrue("Verification of Refresh button position failed!", isOnLeft);
    }
    @Then("the truck driver should be able to click Refresh button")
    public void the_truck_driver_should_be_able_to_click_refresh_button() {

        BrowserUtils.waitForClickablility(vehiclesPage.refreshBtn, 10);
        vehiclesPage.refreshBtn.click();
    }
    @Then("the truck driver should see refreshing element is present on the page")
    public void the_truck_driver_should_see_refreshing_element_is_present_on_the_page() {


        Assert.assertTrue("Visibility of element is failed!", vehiclesPage.loadingElement.isDisplayed());


    }

    //Background:
    @Given("the user is on Vytrack homepage")
    public void theUserIsOnVytrackHomepage() {

        String expectedTitle = "Dashboard";

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("the user clicks on Fleet dropdown")
    public void theUserClicksOnFleetDropdown() {
        BrowserUtils.waitForClickablility(dashboardPage.getFleetBtn(username), 10);
        dashboardPage.getFleetBtn(username).click();
    }

    @Then("the user clicks on Vehicles under fleet dropdown")
    public void theUserClicksOnVehiclesUnderFleetDropdown() {
        BrowserUtils.waitForClickablility(dashboardPage.vehiclesBtn, 10);
        dashboardPage.vehiclesBtn.click();
    }

    // a store manager

    @Then("the store manager sees the title of the page {string}")
    public void the_store_manager_sees_the_title_of_the_page(String expectedtitle) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(expectedtitle));
        Assert.assertTrue(driver.getTitle().equals(expectedtitle));
    }

    @When("the store manager sees Refresh button on the left side of Reset button")
    public void the_store_manager_sees_refresh_button_on_the_left_side_of_reset_button() {

    }
    @Then("the store manager should be able to click Refresh button")
    public void the_store_manager_should_be_able_to_click_refresh_button() {

    }
    @Then("the store manager should see refreshing element is present on the page")
    public void the_store_manager_should_see_refreshing_element_is_present_on_the_page() {

    }
}
