package com.cydeo.step_definitions;

import com.cydeo.pages.Vytrack_pages.DashboardPage;
import com.cydeo.pages.Vytrack_pages.LoginPage;
import com.cydeo.pages.Vytrack_pages.VehiclesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClickGridSetStepDef {

    WebDriver driver = Driver.getDriver();

    WebDriverWait wait;

    String username = ConfigurationReader.getProperty("vytrack_username");

    DashboardPage dashboardPage = new DashboardPage();
    VehiclesPage vehiclesPage = new VehiclesPage();




    @Given("User is on VyTrack homepage")
    public void user_is_on_vy_track_homepage() {
        String expectedTitle = "Dashboard";
        wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }
    @Given("User clicks on Fleet")
    public void user_clicks_on_fleet() {
        BrowserUtils.waitForClickablility(dashboardPage.getFleetBtn(username), 20);
        BrowserUtils.waitFor(5);
       dashboardPage.getFleetBtn(username).click();
    }
    @Given("User clicks on Vehicles under Fleet dropdown")
    public void user_clicks_on_vehicles_under_fleet_dropdown() {
        BrowserUtils.waitForClickablility(dashboardPage.vehiclesBtn, 20);
        dashboardPage.vehiclesBtn.click();

    }
    @Given("the Store manager is on Vehicle page")
    public void the_store_manager_is_on_vehicle_page() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("All - Car - Entities - System - Car - Entities - System"));
        Assert.assertTrue(driver.getTitle().equals("All - Car - Entities - System - Car - Entities - System"));
    }
    @When("the Store manager sees Grid Settings is on the right side of the Reset button and on the right side of the page")
    public void the_store_manager_sees_grid_settings_is_on_the_right_side_of_the_reset_button_and_on_the_right_side_of_the_page() {
        boolean btn = vehiclesPage.isTheElementOnTheRIGHTSideOfPage(vehiclesPage.Grid);
        Assert.assertTrue("Grid Settings Button position is  failed " , vehiclesPage.isTheElementOnTheRIGHTSideOfPage(vehiclesPage.Grid) );
        Assert.assertTrue(" Grid Settings Button assertion failed", btn );

    }
    @Then("the Store manager should be able to click Grid Settings button")
    public void the_store_manager_should_be_able_to_click_grid_settings_button() {
        BrowserUtils.waitForClickablility(vehiclesPage.Grid, 20);
    vehiclesPage.Grid.click();
    }




    @And("the Store manager sees {string}, {string}, {string}")
    public void theStoreManagerSees(String arg0, String arg1, String arg2) {
        Assert.assertEquals("Verification failed","NAME",vehiclesPage.nameSM.getText());
        Assert.assertEquals("Verification failed","SORT",vehiclesPage.sortS.getText());
       Assert.assertEquals("Verification failed","SHOW",vehiclesPage.show.getText());

       Assert.assertTrue(vehiclesPage.nameSM.isDisplayed());
        Assert.assertTrue(vehiclesPage.show.isDisplayed());
        Assert.assertTrue(vehiclesPage.sortS.isDisplayed());



    }
}