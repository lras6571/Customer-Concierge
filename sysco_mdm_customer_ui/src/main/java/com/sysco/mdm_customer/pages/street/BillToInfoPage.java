package com.sysco.mdm_customer.pages.street;


import com.sysco.mdm_customer.pages.LoginPage;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class BillToInfoPage extends LoginPage {

    private final By txtBillToName = By.xpath("//input[contains(@name,'txt_Edit_Bill_To_Name')]");
    private final By txtBillingStreet = By.xpath("//input[contains(@name,'txt_Edit_Bill_To_BillingStreet')]");
    private final By txtBillingCity = By.xpath("//input[contains(@name,'txt_Edit_Bill_To_BillingCity')]");
    private final By txtBillingState = By.xpath("//input[contains(@name,'txt_Edit_Bill_To_BillingState')]");
    private final By txtBillingPostalCode = By.xpath("//input[contains(@name,'txt_Edit_Bill_To_BillingZip')]");
    private final By imgLoading = By.xpath("//div[@role='status']//span[text()='Loading...']");
    private final By btnSendCreditApplication = By.xpath("//a//div[contains(text(),'Send Credit Application')]");
    private final By btnCreditApplicationSent = By.xpath("//a//div[contains(text(),'Already Sent')]");
    private final By btnInitiateAccount = By.xpath("//button[contains(text(),'Initiate')]");
    private final By btnInPageEdit = By.xpath("//button[@name='Edit']");




    /*
     * Enter Bill To Confirmation Screen Data
     * */

    public void createNewBillTo(String billName, String billToStreet, String billCity, String billState, String postalCode) {
        syscoLabUI.waitTillElementLoaded(txtBillToName);
        syscoLabUI.sendKeys(txtBillToName, billName);
        syscoLabUI.sendKeys(txtBillingStreet, billToStreet);
        syscoLabUI.sendKeys(txtBillingCity, billCity);
        syscoLabUI.sendKeys(txtBillingState, billState);
        syscoLabUI.sendKeys(txtBillingPostalCode, postalCode);

    }

    /*
     * Select the Send Credit Application Option
     * */
    public void sendCreditApplication(boolean bSend) {
        syscoLabUI.sleep(2);
        if (bSend) {
            syscoLabUI.clickWithJavascript(btnSendCreditApplication);
        } else {
            syscoLabUI.clickWithJavascript(btnCreditApplicationSent);
        }
        syscoLabUI.waitTillElementDisappear(imgLoading);

    }

    /*
     * Verify the Initiate Account
     * */
    public void initiateAccount() {
        syscoLabUI.waitTillElementLoaded(btnInitiateAccount);
        syscoLabUI.clickWithJavascript(btnInitiateAccount);
        syscoLabUI.waitTillElementLoaded(btnInPageEdit, 30);

    }

}