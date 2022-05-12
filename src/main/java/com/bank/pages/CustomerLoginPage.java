package com.bank.pages;
/*

 */

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourNameField;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement verifyYourNameText;

    public void selectYourNameField(String yourName) {
        selectByVisibleTextFromDropDown(yourNameField, yourName);
        CustomListeners.node.log(Status.PASS, "Select Name from Drop Down '" + yourName + "'");
        Reporter.log("Select Name from Drop Down '" + yourName + "'" + "<br>");
    }
    public void clickOnLoginButton() {
        CustomListeners.node.log(Status.PASS, "Click on 'Login' button");
        Reporter.log("Click on 'Login' button" + "<br>");
        clickOnElement(loginButton);
    }

//    public String getVerifyYourNameText() {
//        String message = getTextFromElement(verifyYourNameText);
//        String actualYourNameText= getVerifyYourNameText().substring(0,9);
//        CustomListeners.node.log(Status.PASS, "Get 'Your Name' text : " + verifyYourNameText.getText());
//        Reporter.log("Get 'Your Name' text : " + verifyYourNameText.getText() + "<br>");
//        return message;
//    }
    public String getVerifyYourNameText(){
        String getYourNameText = getTextFromElement(verifyYourNameText);
        String actualYourNameText= getYourNameText.substring(0,9);
        CustomListeners.node.log(Status.PASS, "Get Your Name text : " + actualYourNameText);
        Reporter.log("Get Your Name text : " + actualYourNameText + "<br>");
        return actualYourNameText;
    }

}
