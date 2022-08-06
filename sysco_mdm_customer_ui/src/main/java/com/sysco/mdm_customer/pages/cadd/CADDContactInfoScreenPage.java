package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDContactInfoScreenPage {


    protected By txtFirstName = By.xpath("//input[@name='contactFirstName']");
    protected By txtLastName= By.xpath("//input[@name='contactLastName']");
    protected By txtEmail= By.xpath("//input[@name='contactEmail']");
    protected By txtPhone= By.xpath("//input[@name='contactPhone']");
    protected By btnNextContactInfo= By.xpath("//button[contains(text(),'Next')]");
    protected By lblContactInfo= By.xpath("//div[contains(text(),'Select Owner or Principal Officer')]");
    protected By lblLanguagePreference= By.xpath("(//select[@name='var_application_language'])[1]");


    //Enter First Name in Contact Info Screen- CADD Wizard
    public void enterFirstName(String firstName) {

        syscoLabUI.waitTillElementLoaded(lblContactInfo);
        syscoLabUI.sendKeys(txtFirstName, firstName);
        LoggerUtil.logINFO("Enter First Name in the Contact Info Screen");
    }


    //Enter Last Name in Contact Info Screen - CADD Wizard
    public void enterLastName(String lastName) {

        syscoLabUI.sendKeys(txtLastName, lastName);
        LoggerUtil.logINFO("Enter Last Name in the Contact Info Screen");
    }


    //Enter Email in Contact Info Screen - CADD Wizard
    public void enterEmail(String email) {

        syscoLabUI.sendKeys(txtEmail, email);
        LoggerUtil.logINFO("Enter Email in the Contact Info Screen");
    }


    //Enter Phone Number in Contact Info Screen - CADD Wizard
    public void enterPhoneNumber(String phone) {

        syscoLabUI.waitTillElementLoaded(txtPhone);
        syscoLabUI.sendKeys(txtPhone, phone);
        LoggerUtil.logINFO("Enter Phone Number in the Contact Info Screen");
    }


    //Enter Next Button in Contact Info Screen - CADD Wizard
    public void clickNextAddressConfirm() {

        syscoLabUI.clickWithJavascript(btnNextContactInfo);
        LoggerUtil.logINFO("Click next in Contact Info Screen");
    }


    //Select the Customer Language Preference
    public void selectLanguagePreference() {

        Select language = new Select(syscoLabUI.findElement(lblLanguagePreference));
        language.selectByVisibleText("English");
        LoggerUtil.logINFO("Select the Customer Language Preference");
    }


}
