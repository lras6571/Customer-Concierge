package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDAccountInfoScreenPage {

    protected By lblAccountInfoScreen = By.xpath("//div[contains(text(),'Concept Id: CAKECAKE')]");
    protected By txtAccountName = By.xpath("//input[@name='accountName']");
    protected By txtPhoneNumber = By.xpath("//input[@name='accountPhone']");
    protected By txtStoreNumber = By.xpath("//input[@name='storeNumber']");
    protected By txtShippingStreet = By.xpath("//textarea[@name='street']");
    protected By txtShippingCity = By.xpath("//input[@name='city']");
    protected By txtShippingZip = By.xpath("//input[@name='postalCode']");
    protected By drpDwnState = By.xpath("//input[@name='province']");
    protected By drpDwnCountry = By.xpath("//input[@name='country']");
    protected By drpDwnStateSelect = By.xpath("//div[@class='slds-media slds-media_center slds-listbox__option slds-listbox__option_entity slds-listbox__option_has-meta']");
    protected By btnNextAccountInfo = By.xpath("//button[contains(text(),'Next')]");
    protected By lblConfirmAddress = By.xpath("//div[contains(text(),'Confirm Address')]");
    protected By lblContactInfo = By.xpath("//div[contains(text(),'Select Owner or Principal Officer')]");
    String generatedAccountName;


    //Enter Account Name in Account Info - CADD Wizard
    public void enterAccountName(String accountName) {

        generatedAccountName = RandomStringUtils.randomAlphabetic(10);
        syscoLabUI.waitTillElementLoaded(txtAccountName);
        syscoLabUI.sendKeys(txtAccountName, accountName + generatedAccountName);
        LoggerUtil.logINFO("Enter the Account Name");
    }

    //Retrieve Account Name
    public String retrieveAccountName(String accountName) {
        generatedAccountName = RandomStringUtils.randomAlphabetic(10);
        return accountName + generatedAccountName;

    }

    //Enter Phone Number in Account Info - CADD Wizard
    public void enterPhoneNumber(String phoneNumber) {

        syscoLabUI.sendKeys(txtPhoneNumber, phoneNumber);
        LoggerUtil.logINFO("Enter the Phone Number");
    }

    //Enter Store Number in Account Info - CADD Wizard
    public void enterStoreNumber(String storeNumber) {

        syscoLabUI.sendKeys(txtStoreNumber, storeNumber);
        LoggerUtil.logINFO("Enter the Store Number");
        syscoLabUI.scrollBottom();
    }


    //Enter Shipping Street in Account Info - CADD Wizard
    public void enterShippingStreet(String shippingStreet) {

        syscoLabUI.sendKeys(txtShippingStreet, shippingStreet);
        LoggerUtil.logINFO("Enter Shipping Street");
    }

    //Enter Shipping City in Account Info - CADD Wizard
    public void enterShippingCity(String shippingCity) {

        syscoLabUI.sendKeys(txtShippingCity, shippingCity);
        LoggerUtil.logINFO("Enter Shipping City");
    }

    //Enter Shipping Zip in Account Info - CADD Wizard
    public void enterShippingZip(String shippingZip) {

        syscoLabUI.sendKeys(txtShippingZip, shippingZip);
        LoggerUtil.logINFO("Enter Shipping Zip");
    }


    //Enter State in Account Info - CADD Wizard
    public void enterState(String state) {

        syscoLabUI.sendKeys(drpDwnState, state);
        LoggerUtil.logINFO("Enter State in the Field");
//        syscoLabUI.clickWithJavascript(drpDwnStateSelect);
//        LoggerUtil.logINFO("Click State in the Fields");
    }


    //Enter Country in Account Info - CADD Wizard
    public void enterCountry(String country) {

        syscoLabUI.sendKeys(drpDwnCountry,country);
        LoggerUtil.logINFO("Enter Country in the Field");
    }


    //Enter Next Button in Account Info - CADD Wizard
    public void clickNextAccountInfo() {

        syscoLabUI.clickWithJavascript(btnNextAccountInfo);
        LoggerUtil.logINFO("Click next in Account info Screen");
    }


    //Enter Next Button in Account Info Confirmation - CADD Wizard
    public void clickNextAddressConfirm() {

        try {
            syscoLabUI.waitTillElementLoaded(lblConfirmAddress,8);
            syscoLabUI.clickWithJavascript(btnNextAccountInfo);
            LoggerUtil.logINFO("Click next in Address Confirm Screen");
            syscoLabUI.waitTillElementLoaded(lblContactInfo);
        } catch (Exception e) {

            LoggerUtil.logINFO("Address Confirm Screen is not available");
        }
    }
}
