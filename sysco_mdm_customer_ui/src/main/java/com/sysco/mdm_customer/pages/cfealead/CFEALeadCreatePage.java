package com.sysco.mdm_customer.pages.cfealead;

import com.syscolab.qe.core.common.LoggerUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEALeadCreatePage {

    protected String generatedString;
    protected String generatedFirstName;
    protected String sb;
    protected Random random;


    protected By txtLeadForm = By.xpath("//span[contains(text(),'Lead Owner')]");
    protected By txtCompanyName = By.xpath("//input[@name='Company']");
    protected By txtFirstName = By.xpath("//input[@name='firstName']");
    protected By txtLastName = By.xpath("//input[@name='lastName']");
    protected By txtPotentialAvgWklySalesOpportunity = By.xpath("//input[@name='Potential_Average_Weekly_Sales__c']");
    protected By btnSave = By.xpath("//button[text()='Save']");
    protected By lblLeadRating = By.xpath("//button[@aria-label='Rating, --None--']");
    protected By lblLeadBusinessStructure = By.xpath("//button[@aria-label='Business Structure, --None--']");
    protected By drpDownSalutation = By.xpath("//button[@aria-label='Salutation, --None--']");
    protected By txtEmail = By.xpath("//input[@name='Email']");
    protected By lblSalutation = By.xpath("//lightning-base-combobox-item[2]");
    protected By lblCreatedLead = By.xpath("//flexipage-component2[@data-component-id='force_highlightsPanel']//div[contains(text(),'Lead')]");
    protected By lblRatingOption = By.xpath("//span[@title='Hot']");
    protected By lblBusinessStructureOption = By.xpath("//span[@title='Corporate']");
    protected By lblTitle = By.xpath("//button[@aria-label='Title, --None--']");
    protected By lblTitleOption = By.xpath("//span[@title='Business Owner']");
    protected By lblCommunicationMethod = By.xpath("//button[@aria-label='Preferred Communication Method, --None--']");
    protected By lblCommunicationMethodOption = By.xpath("//span[@title='Phone']");
    protected By txtPhone = By.xpath("//input[@name='Phone']");


    //Fill the Company Name Text field by generating a random word and append it
    public void enterCompanyName(String strCompanyName) {

        sb = RandomStringUtils.randomAlphabetic(5);
        generatedString = sb.toString();
        LoggerUtil.logINFO("Generated String is :" + generatedString);
        syscoLabUI.waitTillElementLoaded(txtLeadForm,20);
        syscoLabUI.sendKeys(txtCompanyName, generatedString + " " + strCompanyName);
        LoggerUtil.logINFO("Enter the Company Name as: "+ generatedString + " " + strCompanyName);
    }

    //Retrieve Lead Name
    public String retrieveLeadName(String companyName) {
        return generatedString + " " + companyName;
    }

    //Select the Salutation
    public void selectSalutation() {

        syscoLabUI.waitTillElementLoaded(drpDownSalutation,10);
        syscoLabUI.click(drpDownSalutation);
        syscoLabUI.waitTillElementLoaded(lblSalutation,10);
        syscoLabUI.clickWithJavascript(lblSalutation);
        LoggerUtil.logINFO("Select the Salutation of the Lead");
    }


    //Fill the Company Contact Details
    public void enterCompanyContactDetails(String strFirstName, String strLastName) {

        generatedFirstName = RandomStringUtils.randomAlphabetic(3);
        syscoLabUI.sendKeys(txtFirstName, generatedFirstName + strFirstName);
        LoggerUtil.logINFO("Enter Owner Details - First Name");
        syscoLabUI.sendKeys(txtLastName, "A" + generatedString + strLastName);
        LoggerUtil.logINFO("Enter Owner Details - Last Name");
    }


    //Fill the Phone Number
    public void enterPhoneNumber(String strPhoneNumber) {

        syscoLabUI.sendKeys(txtPhone, strPhoneNumber);
        LoggerUtil.logINFO("Enter Phone Number");
    }

    //Fill the Title
    public void enterTitle() {

        syscoLabUI.clickWithJavascript(lblTitle);
        syscoLabUI.waitTillElementLoaded(lblTitleOption, 5);
        syscoLabUI.clickWithJavascript(lblTitleOption);
        LoggerUtil.logINFO("Select Title from the Drop Down");
    }


    //Fill the Weekly Sales Value
    public void enterWeeklySales(String strWeeklySales) {

        syscoLabUI.sendKeys(txtPotentialAvgWklySalesOpportunity, strWeeklySales);
        LoggerUtil.logINFO("Enter Details of Weekly Sales");
    }


    //Fill the Contact Email
    public void enterContactEmail(String contactEmail) {

        syscoLabUI.sendKeys(txtEmail, contactEmail);
        LoggerUtil.logINFO("Enter Email Address of the Lead");
    }

    //Select the Preferred Communication Method
    public void enterCommunicationMethod() {

        syscoLabUI.clickWithJavascript(lblCommunicationMethod);
        syscoLabUI.waitTillElementLoaded(lblCommunicationMethodOption, 5);
        syscoLabUI.clickWithJavascript(lblCommunicationMethodOption);
        LoggerUtil.logINFO("Select Preferred Communication Method from Drop Down");
    }


    //Select the Rating
    public void selectLeadRating() {

        syscoLabUI.scrollToElement(lblLeadRating);
        syscoLabUI.clickWithJavascript(lblLeadRating);
        syscoLabUI.waitTillElementLoaded(lblRatingOption, 5);
        syscoLabUI.clickWithJavascript(lblRatingOption);
        LoggerUtil.logINFO("Select Lead Value from Drop Down");
    }


    //Select the Business Structure
    public void selectBusinessStructure() {

        syscoLabUI.clickWithJavascript(lblLeadBusinessStructure);
        syscoLabUI.waitTillElementLoaded(lblBusinessStructureOption, 5);
        syscoLabUI.clickWithJavascript(lblBusinessStructureOption);
        LoggerUtil.logINFO("Select Lead Business Structure from Drop Down");
    }


    //Save the Lead Form
    public void saveLeadDetails() {

        syscoLabUI.scrollToElement(btnSave);
        syscoLabUI.clickWithJavascript(btnSave);
        LoggerUtil.logINFO("Click Save Button in Lead Form");
        syscoLabUI.waitTillElementLoaded(lblCreatedLead, 40);
        if (syscoLabUI.isAlertDisplayed()) {
            syscoLabUI.clickOkInWindowsAlert();
        }
        LoggerUtil.logINFO(syscoLabUI.getCurrentURL());
    }


}
