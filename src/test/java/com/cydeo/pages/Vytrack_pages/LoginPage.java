package com.cydeo.pages.Vytrack_pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        public LoginPage(){

            PageFactory.initElements(Driver.getDriver(), this);
        }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement username_box;

    @FindBy (xpath = "//input[@id='prependedInput2']")
    public WebElement password_box;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginBtn;


    public void login(String username, String Password){

        username_box.sendKeys(username);
        password_box.sendKeys(Password);
        loginBtn.click();

    }

}
