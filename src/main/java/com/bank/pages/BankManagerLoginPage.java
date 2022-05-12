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
public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement openAccount;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[3]")
    WebElement customers;

    public void clickOnAddCustomerButton() {
        clickOnElement(addCustomer);
        CustomListeners.node.log(Status.PASS, "Click on 'Add Customer' Button");
        Reporter.log("Click on 'Add Customer' Button" + "<br>");
    }

    public void clickOnOpenAccountButton() {
        clickOnElement(openAccount);
        CustomListeners.node.log(Status.PASS, "Click on 'Open Account' Button");
        Reporter.log("Click on 'Open Account' Button" + "<br>");
    }

    public void clickOnCustomersButton() {
        clickOnElement(customers);
        CustomListeners.node.log(Status.PASS, "Click on 'Customers' Button");
        Reporter.log("Click on 'Customers' Button" + "<br>");
    }

}
