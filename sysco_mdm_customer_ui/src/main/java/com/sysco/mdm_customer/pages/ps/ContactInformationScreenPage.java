package com.sysco.mdm_customer.pages.ps;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import java.util.Random;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class ContactInformationScreenPage {

    protected By txtFirstName = By.xpath("//input[@name='inp_Contact_First_Name']");
    protected By txtLastName = By.xpath("//input[@name='inp_Contact_Last_Name']");
    protected By txtEmail = By.xpath("//input[@name='inp_Contact_Email']");
    protected By txtPhone = By.xpath("//input[@name='inp_Contact_Phone']");
    protected By txtSalesAmount = By.xpath("//input[@name='inp_Potential_Avg_Weekly_Sales_Amount2']");
    protected By chkEmail = By.xpath("(//label[@class='slds-checkbox__label'])[1]");
    protected By chkPhoneNumber = By.xpath("(//label[@class='slds-checkbox__label'])[2]");
    protected By lblContactInfo = By.xpath("//span[contains(text(),'CONTACT INFORMATION')]");
    protected By btnNextContactInfo = By.xpath("//button[normalize-space()='Next']");
    protected By lblAccountName = By.xpath("(//span[normalize-space()='Account Name'])[1]");
    protected By lblCreatingSupportRequest = By.xpath("//div[contains(text(),'Creating Support Request')]");
    protected By lblDetails = By.xpath("(//a[normalize-space()='Details'])[1]");
    Random random;

    //Enter First Name in Contact Info Screen- CADD Wizard
    public void enterFirstName(String firstName) {

        syscoLabUI.waitTillElementLoaded(lblContactInfo);
        syscoLabUI.sendKeys(txtFirstName, firstName);
        LoggerUtil.logINFO("Enter First Name in the Contact Info Screen");
    }


    //Enter Last Name in Contact Info Screen - Prospect Shop Flow
    public void enterLastName(String lastName) {

        syscoLabUI.sendKeys(txtLastName, lastName);
        LoggerUtil.logINFO("Enter Last Name in the Contact Info Screen");
    }


    //Enter Email in Contact Info Screen - Prospect Shop Flow
    public void enterEmail(String email) {

        syscoLabUI.sendKeys(txtEmail, email);
        LoggerUtil.logINFO("Enter Email in the Contact Info Screen");
    }


    //Enter Phone Number in Contact Info Screen - Prospect Shop Flow
    public void enterPhoneNumber(String phone) {

        syscoLabUI.sendKeys(txtPhone, phone);
        LoggerUtil.logINFO("Enter Phone Number in the Contact Info Screen");
    }


    //Confirm Email Check Box - Prospect Shop Flow
    public void tickEmail() {

        syscoLabUI.click(chkEmail);
        LoggerUtil.logINFO("Click the check box - Email");
    }


    //Confirm Telephone Check Box - Prospect Shop Flow
    public void tickPhoneNumber() {

        syscoLabUI.click(chkPhoneNumber);
        LoggerUtil.logINFO("Click the check box - Telephone");
    }


    //Enter Phone Number in Contact Info Screen - Prospect Shop Flow
    public void enterSalesAmount() {

        // Generate a random integer from 0 to 899, then add 100
        random = new Random();
        int salesAmounts = random.nextInt(900) + 100;
        syscoLabUI.sendKeys(txtSalesAmount, String.valueOf(salesAmounts));
        LoggerUtil.logINFO("Enter Sales Amount in the Contact Info Screen");

    }


    //Enter Next Button in Contact Info Screen - Prospect Shop
    public void clickNextContactInfo() {

        syscoLabUI.clickWithJavascript(btnNextContactInfo);
        LoggerUtil.logINFO("Click Next/Finish in Contact Info Screen");
        syscoLabUI.waitTillElementLoaded(lblCreatingSupportRequest,45);
        LoggerUtil.logINFO("Creating Support Request");
        syscoLabUI.waitTillElementLoaded(lblDetails, 25);
//        syscoLabUI.waitTillElementDisappear(lblDetails);
        LoggerUtil.logINFO("URL is: " + syscoLabUI.getCurrentURL());
    }
}
