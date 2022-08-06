package com.sysco.mdm_customer.pages.cfeataxapproval;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class TaxApprovalScreenPage {


    protected By lblLeadOwner = By.xpath("(//span[normalize-space()='Lead Owner'])[1]");
    protected By btnUpdateTax = By.xpath("(//button[normalize-space()='Update Credit or Tax'])[1]");
    protected By lblTaxInformation = By.xpath("(//div[contains(text(),'Tax Information')])[1]");
    protected By lblOpCoName = By.xpath("//strong[contains(text(),'OpCo Name ID:')]");
    protected By btnNextAddressVerification = By.xpath("(//button[normalize-space()='Next'])[1]");
    //protected By lblShippingAddressVerification = By.xpath("(//b[contains(text(),'Please be aware that the entered shipping address')])[1]");
    protected By lblShippingAddressVerification = By.xpath("//strong[contains(text(),'Please be aware that the entered shipping address ')]");
    protected By lblConfirmShippingAddress = By.xpath("(//b[contains(text(),'Confirm Shipping Address')])[1]");
    //protected By lblBillingAddressVerification = By.xpath("(//b[contains(text(),'Please be aware that the entered billing address m')])[1]");
    protected By lblBillingAddressVerification = By.xpath("//strong[contains(text(),'Please be aware that the entered billing address m')]");
    protected By lblConfirmBillingAddress = By.xpath("(//b[contains(text(),'Confirm Billing Address')])[1]");
    protected By txtState = By.xpath("(//input[@name='input_State_Tax'])[1]");
    protected By lblDetails = By.xpath("(//a[normalize-space()='Details'])[1]");
    //protected By lblApproveLead = By.xpath("(//b[normalize-space()=\"Please click 'Next' to approve the lead.\"])[1]");
    protected By lblApproveLead = By.xpath("//strong[contains(text(),\"Please click 'Next' to approve the lead.\")]");


    //Click Update Credit or Tax
    public void clickUpdateTax() {

        syscoLabUI.waitTillElementLoaded(lblDetails, 20);
        LoggerUtil.logINFO("Current URL is : " + syscoLabUI.getCurrentURL());
        syscoLabUI.clickWithJavascript(lblDetails);
        syscoLabUI.waitTillElementLoaded(lblLeadOwner, 20);
        LoggerUtil.logINFO("Tax Approval Screen Loaded");
        syscoLabUI.waitTillElementLoaded(btnUpdateTax);
        syscoLabUI.clickWithJavascript(btnUpdateTax);
    }


    //Click Update Credit or Tax
    public void clickTaxInformation() {

        syscoLabUI.waitTillElementLoaded(lblTaxInformation, 20);
        LoggerUtil.logINFO("Tax Information Screen Loaded");
        syscoLabUI.clickWithJavascript(lblTaxInformation);
        LoggerUtil.logINFO("Tax Information Screen Loaded");
    }


    //Click Next in Address Verification Screen
    public void clickNextAddressVerification() {

        syscoLabUI.waitTillElementLoaded(lblOpCoName, 20);
        LoggerUtil.logINFO("Address Verification Screen Loaded");
        syscoLabUI.clickWithJavascript(btnNextAddressVerification);
        LoggerUtil.logINFO("Address Verification Screen - Click Next");
    }


    //Click Next in Shipping Address Verification
    public void clickNextShippingAddressVerification() {

        try {
            syscoLabUI.waitTillElementLoaded(lblShippingAddressVerification, 5);
        } catch (Exception e) {
            syscoLabUI.waitTillElementLoaded(lblConfirmShippingAddress, 5);
        }

        LoggerUtil.logINFO("Address Verification  Screen Loaded");
        syscoLabUI.clickWithJavascript(btnNextAddressVerification);

    }

    //Click Next in Billing Address Verification
    public void clickNextBillingAddressVerification() {

        try {
            syscoLabUI.waitTillElementLoaded(lblBillingAddressVerification, 5);
        } catch (Exception e) {
            syscoLabUI.waitTillElementLoaded(lblConfirmBillingAddress, 5);
        }

        LoggerUtil.logINFO("Click Next in Address Verification Screen");
        syscoLabUI.clickWithJavascript(btnNextAddressVerification);
        LoggerUtil.logINFO("Click Next in Address Verification Screen");

    }

    //Enter Tax Details
    public void enterTaxDetails(String strState) {

        syscoLabUI.waitTillElementLoaded(lblOpCoName, 20);
        LoggerUtil.logINFO("Tax Details Screen Loaded");
        syscoLabUI.sendKeys(txtState, strState);
        LoggerUtil.logINFO("Entered Tax Details");
        syscoLabUI.clickWithJavascript(btnNextAddressVerification);
    }


    //Click Next in the Final Approval
    public void clickNextFinalApprovalScreen() {

        syscoLabUI.waitTillElementLoaded(lblApproveLead, 20);
        LoggerUtil.logINFO("Final Approval Screen Loaded");
        syscoLabUI.clickWithJavascript(btnNextAddressVerification);
        LoggerUtil.logINFO("Click Next in Final Approval Screen");
        syscoLabUI.waitTillElementLoaded(lblLeadOwner, 20);
        syscoLabUI.sleep(5);
        LoggerUtil.logINFO("Current URL is : " + syscoLabUI.getCurrentURL());
    }
}
