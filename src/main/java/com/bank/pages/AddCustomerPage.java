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
public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]")
    WebElement postcodeField;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement addCustomerButton;

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
        CustomListeners.node.log(Status.PASS, "Enter Firstname : '" + firstName + "' to firstName field");
        Reporter.log("Enter Firstname : '" + firstName + "' to firstName field" + "<br>");
    }
    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
        CustomListeners.node.log(Status.PASS, "Enter Lastname : '" + lastName + "' to lastName field");
        Reporter.log("Enter Lastname : '" + lastName + "' to lastName field" + "<br>");
    }
    public void enterPostcode(String postcode) {
        sendTextToElement(postcodeField, postcode);
        CustomListeners.node.log(Status.PASS, "Enter Lastname : '" + postcode + "' to lastName field");
        Reporter.log("Enter Lastname : '" + postcode + "' to lastName field" + "<br>");
    }
    public void clickOnAddCustomerButton() {
        CustomListeners.node.log(Status.PASS, "Click on 'Add Customer' button");
        Reporter.log("Click on 'Add Customer' button" + "<br>");
        clickOnElement(addCustomerButton);
    }
    public String textFromAlert(){
        String successfullyAddedMessage = getTextFromAlert();
        String actualSuccessfullyAddedMessage = successfullyAddedMessage.substring(0,27);
        CustomListeners.node.log(Status.PASS, "Get Customer added successfully text : " + actualSuccessfullyAddedMessage);
        Reporter.log("Get Customer added successfully text : " + actualSuccessfullyAddedMessage + "<br>");
        return actualSuccessfullyAddedMessage;
    }

    public void clickOkOnAlert(){
        acceptAlert();
    }


}
