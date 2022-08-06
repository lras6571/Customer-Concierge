package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDBillToConfirmationScreenPage {

    protected By txtBillToName = By.xpath("//input[@name='txt_Edit_Bill_To_Name']");
    protected By txtBillToAddress = By.xpath("//input[@name='txt_Edit_Bill_To_BillingStreet']");
    protected By txtBillToCity = By.xpath("//input[@name='txt_Edit_Bill_To_BillingCity']");
    protected By txtBillToState = By.xpath("//input[@name='txt_Edit_Bill_To_BillingState']");
    protected By txtBillToPostalCode = By.xpath("//input[@name='txt_Edit_Bill_To_BillingZip']");
    protected By btnNextBillToConfirmation = By.xpath("//button[contains(text(),'Next')]");
    protected By lblSelectAttribute = By.xpath("//div[contains(text(),'Select Attributes')]");
    protected By btnSaveAttribute = By.xpath("//button[contains(text(),'Save')]");
    protected By btnSendCreditApplication = By.xpath("(//div[@class='slds-welcome-mat__tile-title slds-text-heading_small'])[1]");


    //Enter Bill To Name in Bill To Screen
    public void enterBillToName(String billToName) {

        syscoLabUI.waitTillElementLoaded(txtBillToName, 35);
        syscoLabUI.sendKeys(txtBillToName, billToName);
        LoggerUtil.logINFO("Enter Bill To Name in the Bill To Screen");
    }


    //Enter Bill To Address in Bill To Screen
    public void enterBillToAddress(String shippingStreet) {

        syscoLabUI.sendKeys(txtBillToAddress, shippingStreet);
        LoggerUtil.logINFO("Enter Bill To Address in the Bill To Screen");
    }


    //Enter Bill To City in Bill To Screen
    public void enterBillToCity(String shippingCity) {

        syscoLabUI.sendKeys(txtBillToCity, shippingCity);
        LoggerUtil.logINFO("Enter Bill To City in the Bill To Screen");
    }


    //Enter Bill To Zip in Bill To Screen
    public void enterBillToPostalCode(String shippingZip) {

        syscoLabUI.sendKeys(txtBillToPostalCode, shippingZip);
        LoggerUtil.logINFO("Enter Bill To Zip in the Bill To Screen");
    }


    //Enter Bill To state in Bill To Screen
    public void enterBillToState(String state) {

        syscoLabUI.sendKeys(txtBillToState, state);
        LoggerUtil.logINFO("Enter Bill To State in the Bill To Screen");
    }


    //Click Next in Bill To Screen
    public void clickNextBillToScreen() {

        syscoLabUI.clickWithJavascript(btnNextBillToConfirmation);
        LoggerUtil.logINFO("Click Next Button in the Bill To Screen");
        syscoLabUI.waitTillElementLoaded(lblSelectAttribute, 25);
    }


    //Click Save in Bill To Screen
    public void clickSaveAttribute() {

        syscoLabUI.waitTillElementLoaded(btnSaveAttribute, 25);
        syscoLabUI.clickWithJavascript(btnSaveAttribute);
        LoggerUtil.logINFO("Click Save Button in the Attribute Saving");
    }


    //Click Finish in Final Screen
    public void clickSendCreditApplication() {

        syscoLabUI.waitTillElementLoaded(btnSendCreditApplication);
        syscoLabUI.clickWithJavascript(btnSendCreditApplication);
        LoggerUtil.logINFO("Click Send Credit Application Button");


    }

    //Click Save in Bill To Screen
    public void clickSaveAttributeAdditional() {

        syscoLabUI.waitTillElementLoaded(btnSaveAttribute, 25);
        syscoLabUI.clickWithJavascript(btnSaveAttribute);
        LoggerUtil.logINFO("Click Save Button in the Attribute Saving - Additional");
    }

}
