package com.cydeo.pages.Vytrack_pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage {

    public VehiclesPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Reset")
    public WebElement resetBtn;

    @FindBy(xpath="//a[@title=\"Grid Settings\"]")
    public WebElement gridSetting;

    @FindBy(xpath ="//div[.=\"Grid Settings\"]")
    public WebElement  gridMsg;

    @FindBy(xpath = "//td[@class=\"visibility-cell\"]")
    public WebElement idButton;

    @FindBy(xpath = "//tr[@class=\"grid-header-row\"]//th[2]")
    public  WebElement idColumn;

    @FindBy(xpath = "//tr[@class=\"grid-header-row\"]//th[1]")
    public  WebElement idColumn1;     // truck driver and sales manager id column verification

    @FindBy(partialLinkText = "Refresh")
    public WebElement refreshBtn;

    @FindBy(xpath = "(//div[@class='loader-frame'])[1]")
    public WebElement loadingElement;


    public boolean IfBtnOnTheLeft(String btnRight, String btnLeft){

        boolean check =false;

        String xpath;

        xpath = "//a[@title='"+btnRight+"']/..//preceding-sibling::a[@title='"+btnLeft+"']";

        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));

        if(element.isDisplayed()){
            check=true;
        }
        return check;
    }

}
