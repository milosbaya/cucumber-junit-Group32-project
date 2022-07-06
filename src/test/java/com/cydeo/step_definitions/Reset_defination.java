package com.cydeo.step_definitions;

import com.cydeo.pages.Vytrack_pages.DashboardPage;
import com.cydeo.pages.Vytrack_pages.LoginPage;
import com.cydeo.pages.Vytrack_pages.VehiclesPage;
import com.cydeo.pages.Vytrack_pages.resetPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reset_defination {
    WebDriver driver = Driver.getDriver();

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage=new DashboardPage();

    VehiclesPage vehiclesPage = new VehiclesPage();

    resetPage resetPage = new resetPage();

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("User is on VyTrack homepage")
    public void user_is_on_vyTrack_homepage() {
        driver.get(ConfigurationReader.getProperty("vytrack_login_url"));

        loginPage.login(ConfigurationReader.getProperty("vytrack_username"),ConfigurationReader.getProperty("vytrack_password"));
    }
    @When("User clicks on Fleet")

    public void user_clicks_on_fleet() {
        if (ConfigurationReader.getProperty("vytrack_username").equals("user185")) {
            resetPage.fleetBtn1.click();
        } else {
            resetPage.fleetBtn2.click();
        }
    }
    @Then("User clicks on Vehicles under Fleet dropdown")
    public void user_clicks_on_vehicles_under_fleet_dropdown() {
        dashboardPage.vehiclesBtn.click();
    }

    @Then("user see title of page as {string}")
    public void user_see_title_of_page_as(String string)  {
        if (ConfigurationReader.getProperty("vytrack_username").equals("user185")){

            String expectedTitle = string.replace("All - ","");
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
        }
        else {
            wait.until(ExpectedConditions.titleIs(string));
            Assert.assertEquals(string, Driver.getDriver().getTitle());
        }
    }

    @When("User sees Grid settings on the right side of the page")
    public void user_sees_grid_settings_on_the_right_side_of_the_page() {
        System.out.println("resetPage.gridSetting.isDisplayed() = " + resetPage.gridSetting.isDisplayed());
        boolean isOnLeft = vehiclesPage.IfBtnOnTheLeft("Reset","Refresh");

        Assert.assertTrue("Verification of Refresh button position failed!", isOnLeft);
    }
    @Then("User click Grid setting")
    public void user_click_grid_setting() throws InterruptedException {
        resetPage.gridSetting.click();

        Thread.sleep(2000);
    }

    @Then("User see section with {string} heading")
    public void user_see_section_with_heading(String string) {
        String actualGrid = resetPage.gridMsg.getText();

        Assert.assertEquals(string,actualGrid);
    }

    @When("User click on Id from checkbox")
    public void user_click_on_id_from_checkbox() throws InterruptedException {
        resetPage.idButton.click();
        Thread.sleep(2000);
    }

    @Then("User see id column on vehicle page")
    public void user_see_id_column_on_vehicle_page() throws InterruptedException {
        if(ConfigurationReader.getProperty("vytrack_username").equals("storemanager220")) {

            String idMsg = resetPage.idColumn.getText();
            System.out.println("resetPage.idColumn.isDisplayed() = " + resetPage.idColumn.isDisplayed());
            Assert.assertEquals("ID", idMsg);
            Thread.sleep(2000);
        }
        else{

            String idMsg = resetPage.idColumn1.getText();
            System.out.println("resetPage.idColumn1.isDisplayed() = " + resetPage.idColumn1.isDisplayed());
            Assert.assertEquals("ID", idMsg);
            Thread.sleep(2000);
        }
    }


    @When("User clicks the reset button")
    public void user_clicks_the_reset_button() throws InterruptedException {

        resetPage.resetButton.click();
        Thread.sleep(2000);
    }

    @Then("Id checkbox is unselected")
    public void id_checkbox_is_unselected() throws InterruptedException {
        if(ConfigurationReader.getProperty("vytrack_username").equals("storemanager220")) {
            String idMsg = resetPage.idColumn.getText();
            Assert.assertEquals("LICENSE PLATE", idMsg);
            Thread.sleep(2000);
        }
        else{
            String idMsg = resetPage.idColumn1.getText();
            Assert.assertEquals("LICENSE PLATE", idMsg);
            Thread.sleep(2000);
        }
    }
}

