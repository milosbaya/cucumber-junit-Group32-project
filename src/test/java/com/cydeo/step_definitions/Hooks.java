package com.cydeo.step_definitions;

import com.cydeo.pages.Vytrack_pages.DashboardPage;
import com.cydeo.pages.Vytrack_pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUpScenario(){
        WebDriver driver = Driver.getDriver();

        LoginPage loginPage = new LoginPage();


        String username = ConfigurationReader.getProperty("vytrack_username");
        String password = ConfigurationReader.getProperty("vytrack_password");

        driver.get(ConfigurationReader.getProperty("vytrack_login_url"));

        loginPage.login(username,password);


    }


    // @After is coming from cucumber. It is running after each scenario
    @After
    public void teardownScenario(Scenario scenario) {


        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

}
