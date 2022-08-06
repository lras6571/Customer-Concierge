package com.sysco.mdm_customer.pages.ps;

import com.syscolab.qe.core.common.LoggerUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class AddressDetailsScreenPage {

    protected String generatedString;
    protected String generatedWordString;
    protected Random random;

    protected By txtShipToName = By.xpath("//input[@name='inp_ShipTo_Name']");
    protected By txtShipToAddress = By.xpath("(//textarea[@class='slds-textarea'])[1]");
    protected By txtShipToCity = By.xpath("//input[@name='inp_ShippingCity']");
    protected By txtShipToState = By.xpath("//input[@name='inp_ShippingState']");
    protected By txtShipToZip = By.xpath("//input[@name='inp_ShippingZipCode']");
    protected By txtBillToName = By.xpath("//input[@name='inp_BillTo_Name']");
    protected By txtBillToAddress = By.xpath("(//textarea[@class='slds-textarea'])[2]");
    protected By txtBillToCity = By.xpath("//input[@name='inp_BillingCity']");
    protected By txtBillToZip = By.xpath("//input[@name='inp_BillingZipCode']");
    protected By txtBillToState = By.xpath("//input[@name='inp_BillingState']");
    protected By txtShipToCountry = By.xpath("//input[@name='inp_ShippingCountry']");
    protected By btnNextProspectShopShipTo = By.xpath("//button[normalize-space()='Next']");
    protected By txtAddressConfirmation = By.xpath("//p[contains(text(),'Please be aware that the entered address may be in')]");
    protected By btnNextAddressConfirmation = By.xpath("//button[contains(text(),'Next')]");

    //Enter Ship To Name in the Prospect Shop Flow - Using a Random Value and Append it
    public void enterShipToName(String shipToName) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(10);
        random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        generatedString = sb.toString();
        generatedWordString = RandomStringUtils.randomAlphabetic(10);

        syscoLabUI.waitTillElementLoaded(txtShipToName, 20);
        syscoLabUI.sendKeys(txtShipToName, shipToName+generatedString);
        LoggerUtil.logINFO("Enter Ship To Name in the Prospect Shop Flow as :" + shipToName+generatedString);
    }


    //Retrieve Account Name
    public String retrieveAccountName(String accountName) {

        generatedString = org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(10);
        return accountName + generatedString;
    }


    //Enter Shipping Street Name in the Prospect Shop Flow
    public void enterShipToAddress(String shipToStreet) {

        syscoLabUI.click(txtShipToAddress );
        syscoLabUI.clear(txtShipToAddress );
        syscoLabUI.sendKeys(txtShipToAddress,shipToStreet);
        LoggerUtil.logINFO("Enter Shipping Street Name in the Prospect Shop Flow");
    }


    //Enter Shipping City Name in the Prospect Shop Flow
    public void enterShipToCity(String shipToCity) {

        syscoLabUI.sendKeys(txtShipToCity,shipToCity);
        LoggerUtil.logINFO("Enter Shipping City in the Prospect Shop Flow");
    }


    //Enter Shipping State Name in the Prospect Shop Flow
    public void enterShipToState(String shipToState) {

        syscoLabUI.sendKeys(txtShipToState,shipToState);
        LoggerUtil.logINFO("Enter Shipping State in the Prospect Shop Flow");
    }


    //Enter Shipping Zip Code Name in the Prospect Shop Flow
    public void enterShipToZipCode(String shipToZipCode) {

        syscoLabUI.sendKeys(txtShipToZip,shipToZipCode);
        LoggerUtil.logINFO("Enter Shipping Zip Code in the Prospect Shop Flow");
    }

    //Enter Shipping Country Code Name in the Prospect Shop Flow
    public void enterShipToCountryDetails(String shipToCounty) {

        syscoLabUI.scrollToElement(txtShipToCountry);
        syscoLabUI.sendKeys(txtShipToCountry,shipToCounty);
        LoggerUtil.logINFO("Enter Shipping Country Code in the Prospect Shop Flow");
    }


    //Enter Bill To Name in the Prospect Shop Flow
    public void enterBillToName(String billToName) {

        syscoLabUI.sendKeys(txtBillToName, billToName);
        LoggerUtil.logINFO("Enter Ship To Name in the Prospect Shop Flow");
    }


    //Enter Billing Street Name in the Prospect Shop Flow
    public void enterBillToStreet(String billToStreet) {

        syscoLabUI.sleep(5);
        syscoLabUI.sendKeys(txtBillToAddress,billToStreet);
        LoggerUtil.logINFO("Enter Billing Street Name in the Prospect Shop Flow");
    }


    //Enter Billing City Name in the Prospect Shop Flow
    public void enterBillToCity(String billToCity) {

        syscoLabUI.sendKeys(txtBillToCity,billToCity);
        LoggerUtil.logINFO("Enter Billing City in the Prospect Shop Flow");
    }


    //Enter Billing State Name in the Prospect Shop Flow
    public void enterBillToState(String billToState) {

        syscoLabUI.sendKeys(txtBillToState,billToState);
        LoggerUtil.logINFO("Enter Billing State in the Prospect Shop Flow");
    }


    //Enter Billing Zip Code Name in the Prospect Shop Flow
    public void enterBillToZipCode(String billToZipCode) {

        syscoLabUI.sendKeys(txtBillToZip,billToZipCode);
        LoggerUtil.logINFO("Enter Billing Zip Code in the Prospect Shop Flow");
    }


    //Click Next in Prospect Shop Flow Address Screen
    public void clickNextAddressScreen() {

        syscoLabUI.clickWithJavascript(btnNextProspectShopShipTo);
        LoggerUtil.logINFO("Click Next Button in the Prospect Shop Flow Address Screen");
    }

    //Click Next in Address Confirmation Screen
    public void clickNextAddressConfirmation(){

        syscoLabUI.waitTillElementLoaded(txtAddressConfirmation);
        syscoLabUI.clickWithJavascript(btnNextAddressConfirmation);
        LoggerUtil.logINFO("Click Next Button in the Prospect Shop Flow Address Confirmation Screen");
    }
}

