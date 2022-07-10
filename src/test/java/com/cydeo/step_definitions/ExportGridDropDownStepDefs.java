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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExportGridDropDownStepDefs {
LoginPage loginPage=new LoginPage();
DashboardPage dashboardPage=new DashboardPage();

VehiclesPage vehiclesPage=new VehiclesPage();
//    @Given("the user is on Vytrack homepage")
//    public void the_user_is_on_vytrack_homepage() {
//    }
String username = ConfigurationReader.getProperty("vytrack_username");
    @When("the user clicks on Vehicles under Fleet module dropdown")
    public void the_user_clicks_on_vehicles_under_fleet_module_dropdown() {

       BrowserUtils.waitForClickablility(dashboardPage.getFleetBtn(username),5);
        //update project get fleet button method
        dashboardPage.getFleetBtn(username).click();
        BrowserUtils.waitForClickablility(dashboardPage.vehiclesBtn,5);
        dashboardPage.vehiclesBtn.click();

    }
    @And("the user is on Vehicles page")
    public void theUserIsOnVehiclesPage() {
        vehiclesPage.carsTitle.getText();
        Assert.assertEquals("Cars", vehiclesPage.carsTitle.getText());
    }

    @And("the Export Grid dropdown is on the left of the page")
    public void theExportGridDropdownIsOnTheLeftOfThePage() {
       // BrowserUtils.waitFor(10);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Export Grid")));
      //  int exportGridBtnPosition=vehiclesPage.exportGridBth.getLocation().getX();
       // System.out.println("ExportGrid Button position:"+exportGridBtnPosition);
       // int x = vehiclesPage.exportGridBth.getLocation().getX();//x=12
        Assert.assertTrue(vehiclesPage.isTheElementOnTheLeftSideOfPage(vehiclesPage.exportGridBth));
    }
    @Then("user should be able to click Export Grid dropdown")
    public void user_should_be_able_to_click_export_grid_dropdown() throws InterruptedException {
       // vehiclesPage.exportGridBth.click();
        BrowserUtils.waitForClickablility(vehiclesPage.exportGridBth,10);
        vehiclesPage.exportGridBth.click();
    }
    @Then("the user sees CSV and XLSX options on the dropdown menu")
    public void the_user_sees_csv_and_xlsx_options_on_the_dropdown_menu() {
//       vehiclesPage.CSV.getText();
//        System.out.println("vehiclesPage.CSV.getText() = " + vehiclesPage.CSV.getText());
//        vehiclesPage.XLSX.getText();
//        System.out.println("vehiclesPage.XLSX.getText() = " + vehiclesPage.XLSX.getText());

Assert.assertTrue("CSV assertion failed!", vehiclesPage.CSV.isDisplayed());
Assert.assertTrue("XLSX assertion failed!",vehiclesPage.XLSX.isDisplayed());

    }



}
