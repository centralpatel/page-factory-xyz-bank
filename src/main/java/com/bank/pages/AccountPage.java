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
public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/button[2]")
    WebElement verifyLogOutButton ;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/button[2]")
    WebElement logoutButton;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[1]")
    WebElement transactionsButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement depositTab;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdrawTab;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement enterDepositAmount;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement verifyDepositSuccessText;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement enterWithdrawAmount;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement withdrawButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement withdrawalSuccessText;


    public void clickOnTransactionsButton() {
        clickOnElement(transactionsButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Transactions' Button");
        Reporter.log("Click on 'Transactions' Button" + "<br>");
    }

    public void clickOnDepositTab() {
        clickOnElement(depositTab);
        CustomListeners.node.log(Status.PASS, "Click on 'Deposit' Button");
        Reporter.log("Click on 'Deposit' Button" + "<br>");
    }

    public void clickOnWithdrawalTab() {
        clickOnElement(withdrawTab);
        CustomListeners.node.log(Status.PASS, "Click on 'Withdrawal' Button");
        Reporter.log("Click on 'Withdrawal' Button" + "<br>");
    }

    public void enterDepositAmount(String depositAmount) {
        sendTextToElement(enterDepositAmount, depositAmount);
        CustomListeners.node.log(Status.PASS, "Enter Deposit Amount '" + depositAmount + "' to Deposit Amount field : " + enterDepositAmount.getText());
        Reporter.log("Enter Deposit Amount " + depositAmount + " to Deposit Amount field " + enterDepositAmount.getText() + "<br>");
    }

    public void clickOnDepositButton() {
        clickOnElement(depositButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Deposit' Button");
        Reporter.log("Click on 'Deposit' Button" + "<br>");
    }

    public String getVerifyDepositSuccessfulText(){
        String depositSuccessfulMessage = getTextFromElement(verifyDepositSuccessText);
        CustomListeners.node.log(Status.PASS, "Find Deposit Successful Message : " + depositSuccessfulMessage);
        Reporter.log("Find Deposit Successful Message : " + depositSuccessfulMessage + "<br>");
        return depositSuccessfulMessage;
    }

    public void enterWithdrawalAmount(String withdrawalAmount) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(enterWithdrawAmount, withdrawalAmount);
        CustomListeners.node.log(Status.PASS, "Enter Withdrawal Amount '" + withdrawalAmount + "' to Withdrawal Amount field : " + enterWithdrawAmount.getText());
        Reporter.log("Enter Withdrawal Amount " + withdrawalAmount + " to Withdrawal Amount field " + enterWithdrawAmount.getText() + "<br>");
    }

    public void clickOnWithdrawalButton() {
        clickOnElement(withdrawButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Withdrawal' Button");
        Reporter.log("Click on 'Withdrawal' Button" + "<br>");
    }

    public String verifyWithdrawalSuccessfulText(){
        String withdrawalSuccessfulMessage = getTextFromElement(withdrawalSuccessText);
        CustomListeners.node.log(Status.PASS, "Find Withdrawal Successful Message : " + withdrawalSuccessfulMessage);
        Reporter.log("Find Withdrawal Successful Message : " + withdrawalSuccessfulMessage + "<br>");
        return withdrawalSuccessfulMessage;
    }
    public String getVerifyLogOutButton() {
        String message = getTextFromElement(verifyLogOutButton);
        CustomListeners.node.log(Status.PASS, "Get Logout Button text : " + verifyLogOutButton.getText());
        Reporter.log("Get Logout Button text : " + verifyLogOutButton.getText() + "<br>");
        return message;
    }
    public void clickOnLogOutButton() {
        CustomListeners.node.log(Status.PASS, "Click on 'Logout' button");
        Reporter.log("Click on 'Logout' button" + "<br>");
        clickOnElement(logoutButton);
    }
}
