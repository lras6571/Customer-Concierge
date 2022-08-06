package com.sysco.mdm_customer.pages.cfea;

import com.syscolab.qe.core.common.LoggerUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEAContactInfoScreenPage {


    protected By txtFirstName = By.xpath("//input[@name='txtFirstName_0_0']");
    protected By txtLastName= By.xpath("//input[@name='txtLastName_0_0']");
    protected By txtEmail= By.xpath("//input[@name='txtEmail_0_0']");
    protected By txtPhone= By.xpath("//input[@name='txtPhone_0_0']");
    protected By btnNextContactInfo= By.xpath("//button[contains(text(),'Next')]");
    protected By lblLanguagePreference= By.xpath("(//select[@name='var_application_language'])[1]");
    String generatedLeadFirstName;

    //Enter First Name in Contact Info Screen- CADD Wizard
    public void enterFirstName(String firstName) {

        generatedLeadFirstName = RandomStringUtils.randomAlphabetic(5);
        syscoLabUI.waitTillElementLoaded(txtFirstName,5);
        syscoLabUI.sendKeys(txtFirstName, generatedLeadFirstName + firstName);
        LoggerUtil.logINFO("Enter First Name in the Contact Info Screen as: "+ generatedLeadFirstName + firstName);
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


    //Select the Customer Language Preference
    public void selectLanguagePreference(String strLanguage) {

        Select language = new Select(syscoLabUI.findElement(lblLanguagePreference));
        language.selectByVisibleText(strLanguage);
        LoggerUtil.logINFO("Select the Customer Language Preference");
    }


    //Enter Next Button in Contact Info Screen - CADD Wizard
    public void clickNextContactInfo() {

        syscoLabUI.clickWithJavascript(btnNextContactInfo);
        LoggerUtil.logINFO("Click next in Contact Info Screen");

    }

    //Retrieve Name Info
    public String retrieveNameInfo(String firstName, String lastName) {

        return generatedLeadFirstName + firstName + " " + lastName;
    }

}
