package com.sysco.mdm_customer.pages.street;


import com.sysco.mdm_customer.pages.LoginPage;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class ContactInfoPage extends LoginPage {

    //Additional Location
    private final By txtFirstName = By.xpath("//input[contains(@name,'contactFirstName')]");
    private final By txtLastName = By.xpath("//input[contains(@name,'contactLastName')]");
    private final By txtEmailAddress = By.xpath("//input[contains(@name,'contactEmail')]");
    private final By txtPhoneNumber = By.xpath("//input[contains(@name,'contactPhone')]");
    private final By lblLanguage = By.xpath("//select[@name='Reactivation_Language']");

    /*
     * Enter Contact Info Screen Data (FirstName,LastName,EmailAddress,TelephoneNumber)
     * */
    public void enterFirstName(String firstName) {

        syscoLabUI.sendKeys(txtFirstName, firstName);
        LoggerUtil.logINFO("Enter First Name in Account Maintenance");
    }

    public void enterLastName(String lastName) {

        syscoLabUI.sendKeys(txtLastName, lastName);
        LoggerUtil.logINFO("Enter Last Name in Account Maintenance");
    }

    public void enterEmailAddress(String emailAddress) {

        syscoLabUI.sendKeys(txtEmailAddress, emailAddress);
        LoggerUtil.logINFO("Enter Email Address in Account Maintenance");
    }

    public void enterPhoneNumber(String phoneNumber) {

        syscoLabUI.sendKeys(txtPhoneNumber, phoneNumber);
        LoggerUtil.logINFO("Enter Phone Number in Account Maintenance");
    }

    //Select the Customer Language Preference
    public void enterCustomerLanguagePreference(String strLanguage) {

        Select drpCountry = new Select(syscoLabUI.findElement(lblLanguage));
        drpCountry.selectByVisibleText(strLanguage);
        LoggerUtil.logINFO("Select the Language as English");
    }

    public boolean isContactInfoFieldDisplayed() {
        return isElementDisplayed(txtFirstName) && isElementDisplayed(txtLastName) && isElementDisplayed(txtEmailAddress) && isElementDisplayed(txtPhoneNumber);
    }
    public boolean isElementDisplayed(By element) {
        return syscoLabUI.waitTillElementLoaded(element).isDisplayed();
    }
}