package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/*

 */
public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerFieldDropDown;
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyFieldDropDown;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processButton;

    public void selectCustomerFieldDropDown(String customer) {
        selectByVisibleTextFromDropDown(customerFieldDropDown, customer);
        CustomListeners.node.log(Status.PASS, "Select from Customer field drop down '" + customer + "'");
        Reporter.log("Select from Customer field drop down '" + customer + "'" + "<br>");
    }
    public void selectCurrencyFieldDropDown(String currency) {
        selectByVisibleTextFromDropDown(currencyFieldDropDown, currency);
        CustomListeners.node.log(Status.PASS, "Select Currency from drop down '" + currency + "'");
        Reporter.log("Select Currency from drop down '" + currency + "'" + "<br>");
    }
    public void clickOnProcessButton() {
        CustomListeners.node.log(Status.PASS, "Click on 'Process' button");
        Reporter.log("Click on 'Process' button" + "<br>");
        clickOnElement(processButton);
    }
    public String textFromAlert() {
        String successfullyCreatedMessage = getTextFromAlert();
        String actualSuccessfullyCreatedMessage = successfullyCreatedMessage.substring(0,28);
        CustomListeners.node.log(Status.PASS, "Get Account created successfully text : " + actualSuccessfullyCreatedMessage);
        Reporter.log("Get Account created successfully text : " + actualSuccessfullyCreatedMessage + "<br>");
        return actualSuccessfullyCreatedMessage;
    }

    public void clickOkOnAlert() {
        acceptAlert();
    }


}
