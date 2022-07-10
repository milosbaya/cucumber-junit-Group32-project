package com.cydeo.pages.Vytrack_pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage {

    public VehiclesPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Reset")
    public WebElement resetBtn;

//    @FindBy(xpath="//a[@title=\"Grid Settings\"]")
//    public WebElement gridSetting;

    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement Grid;


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

    @FindBy(xpath = "//h1[.='Cars']")
    public WebElement carsTitle;

    @FindBy (xpath = "//h1[@class='oro-subtitle']")
    public WebElement carsTitleSM;

    @FindBy(partialLinkText = "Export Grid")
    public  WebElement exportGridBth;
    //"(//a[@href='#'])[12]"
    @FindBy(xpath = "(//a[@class='no-hash'])[2]")
    public WebElement CSV;

    @FindBy(xpath ="(//a[@class='no-hash'])[3]")
    public WebElement XLSX;

//    @FindBy(xpath = "//div[@class='btn-group open']/a")
//    public WebElement exportGridBtnDropDown;




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



    public boolean isTheElementOnTheLeftSideOfPage(WebElement element){

        int xElement = element.getLocation().getX();
        int winWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int xCenter = winWidth/2;
        return xCenter>xElement;

    }

    public boolean isTheElementOnTheRIGHTSideOfPage(WebElement element){

        int xElement = element.getLocation().getX();
        int winWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int xCenter = winWidth/2;
        return xCenter<xElement;

    }
}
