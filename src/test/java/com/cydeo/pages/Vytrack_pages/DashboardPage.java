package com.cydeo.pages.Vytrack_pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetBtn_truckDriver;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehiclesBtn;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetBtn_manager;

    public WebElement getFleetBtn(String username){


        if(username.equals("user185") || username.equals("user186")){

            WebElement fleetBtn_truckDriver = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
            return fleetBtn_truckDriver;
        }else{
            WebElement fleetBtn_managers = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

            return fleetBtn_managers;
        }
    }

}
