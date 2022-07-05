package com.cydeo.pages.Vytrack_pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetBtn;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehiclesBtn;

}
