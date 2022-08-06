package com.sysco.mdm_customer.pages.lead;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.Random;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class LeadCreatePage {

    protected String generatedString;
    protected String generatedFirstName;
    protected Random random;

    protected By txtCompanyName = By.xpath("//input[@name='Company']");
    protected By txtFirstName = By.xpath("//input[@name='firstName']");
    protected By txtLastName = By.xpath("//input[@name='lastName']");
    protected By drpDwnLeadStatus = By.xpath("//label[contains(text(),'Lead Status')]//following::input[1]");
    protected By optionValue = By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[7]");
    protected By txtPotentialAvgWklySalesOpportunity = By.xpath("//input[@name='Potential_Average_Weekly_Sales__c']");
    protected By txtDSMName = By.xpath("//label[contains(text(),'Assign to DSM')]//following::input[1]");
    protected By btnSave = By.xpath("//button[text()='Save']");
    protected By lblLead = By.xpath("//div[text()='Lead']");
    protected By txtLeadForm = By.xpath("//h2[contains(text(),'New Lead: Sysco360')]");
    protected By drpDownSalutation = By.xpath("//button[@aria-label='Salutation, --None--']");
    protected By txtEmail = By.xpath("//input[@name='Email']");
    protected By lblSalutation = By.xpath("//records-record-layout-input-name[@data-input-element-id='input-field']//lightning-base-combobox-item[2]");
    protected By lblCreatedLead = By.xpath("//flexipage-component2[@data-component-id='force_highlightsPanel']//div[contains(text(),'Lead')]");
    protected By txtBillingStreet = By.xpath("(//input[@name='Billing_Street__c'])[1]");
    protected By txtBillingState = By.xpath("//input[@name='Billing_State__c']");
    protected By txtBillingCity = By.xpath("//input[@name='Billing_City__c']");
    protected By txtBillingCountry = By.xpath("//input[@name='Billing_Country__c']");
    protected By txtBillingZipCode = By.xpath("//input[@name='Billing_Zipcode__c']");
    protected By lblDsmName = By.xpath("//li[@role='presentation']//lightning-base-combobox-item[@role='option']");
    protected By lblDetails = By.xpath("(//a[normalize-space()='Details'])[1]");

    //Select the Salutation
    public void selectSalutation(){

        syscoLabUI.waitTillElementLoaded(drpDownSalutation);
        syscoLabUI.clickWithJavascript(drpDownSalutation);
        syscoLabUI.waitTillElementLoaded(lblSalutation);
        syscoLabUI.click(lblSalutation);
        LoggerUtil.logINFO("Select the Salutation of the Lead");
    }


    //Fill the Company Name Text field by generating a random word and append it
    public void enterCompanyName(String strCompanyName){

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(8);
        random = new Random();
        for (int i = 0; i < 8; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        generatedString = sb.toString();
        LoggerUtil.logINFO("generatedString is :" + generatedString);
        syscoLabUI.waitTillElementLoaded(txtLeadForm);
        syscoLabUI.sendKeys(txtCompanyName,strCompanyName +generatedString);
        LoggerUtil.logINFO("Enter the Company Name");
    }


    //Fill the Company Contact Details
    public void enterCompanyContactDetails(String strFirstName, String strLastName){

        generatedFirstName = RandomStringUtils.randomAlphabetic(5);
        syscoLabUI.sendKeys(txtFirstName,generatedFirstName+strFirstName);
        LoggerUtil.logINFO("Enter Owner Details - First Name");
        syscoLabUI.sendKeys(txtLastName,"A"+generatedString+strLastName);
        LoggerUtil.logINFO("Enter Owner Details - Last Name");
    }


    //Fill the Weekly Sales Value
    public void enterWeeklySales(String strWeeklySales){

        syscoLabUI.sendKeys(txtPotentialAvgWklySalesOpportunity,strWeeklySales);
        LoggerUtil.logINFO("Enter Details of Weekly Sales");
    }


    //Fill the Contact Email
    public void enterContactEmail(String contactEmail){

        syscoLabUI.sendKeys(txtEmail,contactEmail);
        LoggerUtil.logINFO("Enter Email Address of the Lead");
    }


    //Fill the DSM Name from the Drop Down
    public void assignToDSM(String dsmName){

        while (!syscoLabUI.isDisplayed(drpDwnLeadStatus)){
            syscoLabUI.scrollBottom();
        }
        syscoLabUI.sendKeys(txtDSMName,dsmName);
        LoggerUtil.logINFO("Enter the DSM Name");
        syscoLabUI.click(txtDSMName);
        syscoLabUI.waitTillElementLoaded(lblDsmName,20);
        syscoLabUI.clickWithJavascript(lblDsmName);
        LoggerUtil.logINFO("Select DSM Name");
    }


    //Select the Rating
    public void selectLeadRating(String strRating){

        syscoLabUI.moveToAndClick(lblLead);
        syscoLabUI.scrollDown(500);
        By txtOption = DriverSetUpUtil.replaceInLocator(optionValue,"#",strRating);
        syscoLabUI.clickWithJavascript(txtOption);
        syscoLabUI.sendKeys(txtOption, Keys.DOWN);
        syscoLabUI.sendKeys(txtOption, Keys.DOWN);
        syscoLabUI.sendKeys(txtOption, Keys.ENTER);
        LoggerUtil.logINFO("Select Lead Value from Drop Down");
    }


    //Fill the Bill to Address
    public void enterBillToAddress(String billingStreet, String billingState, String billingCity, String billingCountry, String billingZipCode){

        syscoLabUI.sendKeys(txtBillingStreet,billingStreet);
        LoggerUtil.logINFO("Enter Billing Street of the Lead");
        syscoLabUI.sendKeys(txtBillingState,billingState);
        LoggerUtil.logINFO("Enter Billing State of the Lead");
        syscoLabUI.sendKeys(txtBillingCity,billingCity);
        LoggerUtil.logINFO("Enter Billing City of the Lead");
        syscoLabUI.sendKeys(txtBillingCountry,billingCountry);
        LoggerUtil.logINFO("Enter Billing Country of the Lead");
        syscoLabUI.sendKeys(txtBillingZipCode,billingZipCode);
        LoggerUtil.logINFO("Enter Billing Zip Code of the Lead");
    }


    //Save the Lead Form
    public void saveLeadDetails(){

        syscoLabUI.clickWithJavascript(btnSave);
        LoggerUtil.logINFO("Click Save Button in Lead Form");
        syscoLabUI.waitTillElementLoaded(lblCreatedLead,40);
        if (syscoLabUI.isAlertDisplayed()) {
            syscoLabUI.clickOkInWindowsAlert();
        }
        LoggerUtil.logINFO(syscoLabUI.getCurrentURL());
    }
//Click Detail Tab
public void clickDetailTab(){
    syscoLabUI.waitTillElementLoaded(lblDetails,40);
    syscoLabUI.clickWithJavascript(lblDetails);
}
}
