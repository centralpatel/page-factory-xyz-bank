package com.bank.testsuite;
/*

 */

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

        AccountPage accountPage;
        AddCustomerPage addCustomerPage;
        BankManagerLoginPage bankManagerLoginPage;
        CustomerLoginPage customerLoginPage;
        CustomersPage customersPage;
        HomePage homePage;
        OpenAccountPage openAccountPage;

    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException{
        //Click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLogInButton();
        //Click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //enter FirstName
        addCustomerPage.enterFirstName("Nehal");
        //enter LastName
        addCustomerPage.enterLastName("Patel");
        //enter PostCode
        addCustomerPage.enterPostcode("HA0 4RE");
        //click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        //popup displayed verify message "Customer added successfully"
        Thread.sleep(2000);
        String expectedMessage = "Customer added successfully";
        String actualMessage = addCustomerPage.textFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage, "Invalid Customer Error");
        //click on "ok" button on popup.
       addCustomerPage.acceptAlert();
    }

    @Test(priority = 2, groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException{
        //Click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLogInButton();
        //Click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccountButton();
        //Search customer that created in first test
        openAccountPage.selectCustomerFieldDropDown("Hermoine Granger");
        //Select currency "Pound"
        openAccountPage.selectCurrencyFieldDropDown("Pound");
        //click on "process" button
        openAccountPage.clickOnProcessButton();
        //popup displayed verify message "Account created successfully"
        Thread.sleep(2000);
        String expectedMessage = "Account created successfully";
        String actualMessage = openAccountPage.textFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual text does not match expected text");
        //click on "ok" button on popup.
        openAccountPage.clickOkOnAlert();
    }

    @Test(priority = 3, groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        //click on "Customer Login"Tab
        homePage.clickOnCustomerLoginButton();
        //search customer that you created
        customerLoginPage.selectYourNameField("Hermoine Granger");
        // click on "Login"Button
        customerLoginPage.clickOnLoginButton();
        //verify "Logout" Tab displayed.
        String expectedMessage = "logout";
        String actualMessage = customersPage.verifyLogoutButton();
        Assert.assertEquals(expectedMessage, actualMessage, "LogOut text not displayed");
        //click on "Logout"
        accountPage.clickOnLogOutButton();
        //verify "Your Name" text displayed
        String expectedMessage1 = "Your Name";
        String actualMessage1 = customerLoginPage.getVerifyYourNameText();
        Assert.assertEquals(expectedMessage1, actualMessage1, "Your Name text not displayed");
    }

    @Test(priority = 4, groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() {
        //click on "Customer Login"Tab
        homePage.clickOnCustomerLoginButton();
        //search customer that you created
        customerLoginPage.selectYourNameField("Hermoine Granger");
        //click on "Login"Button
        customerLoginPage.clickOnLoginButton();
        //click on "Deposit"Tab
        accountPage.clickOnDepositTab();
        //Enter amount 100
        accountPage.enterDepositAmount("100");
        //click on "Deposit"Button
        accountPage.clickOnDepositButton();
        //verify message "Deposit Successful"
        String expectedMessage = "Deposit Successful";
        String actualMessage = accountPage.getVerifyDepositSuccessfulText();
        Assert.assertEquals(expectedMessage, actualMessage, "Invalid Error message");
    }

    @Test(priority = 5, groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException{
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //search customer that you created
        customerLoginPage.selectYourNameField("Hermoine Granger");
        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        //click on "Withdrawal" Tab
        accountPage.clickOnWithdrawalTab();
        //Enter amount 50
        accountPage.enterWithdrawalAmount("50");
        //click on "Withdraw" Button
        accountPage.clickOnWithdrawalButton();
        //verify message "Transaction Successful"
        String expectedMessage = "Transaction successful";
        String actualMessage = accountPage.verifyWithdrawalSuccessfulText();
        Assert.assertEquals(expectedMessage, actualMessage, "Invalid Transaction");
    }
}
