package com.sysco.mdm_customer.pages.lead;

import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CreatedLeadPage {

    //    protected By lblLeadOwner = By.xpath("(//div[@class='slds-grid'])[10]");
//    protected By lblEmail = By.xpath("//a[@data-aura-class='emailuiFormattedEmail']");
//    protected By lblConversionType = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[21]");
//    protected By lblBusinessStructure = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[13]");
//    protected By lblBillingState = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[14]");
//    protected By lblBillingCity = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[16]");
//    protected By lblBillingCountry = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[17]");
    protected By lblLeadOwner = By.xpath("//span[text()='Lead Owner']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot[@force-lookup_lookup]//span");
    protected By lblCompanyName = By.xpath("//span[text()='Company']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    protected By lblContactEmail = By.xpath("//span[text()='Contact Email']//ancestor::div[contains(@class,'slds-grid slds-size')]//child::div[@class='slds-show_inline']//a");
    protected By lblRating = By.xpath("//span[text()='Rating']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    protected By lblConversionType = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[21]");
    protected By lblBusinessStructure = By.xpath("(//lightning-formatted-text[contains(@data-output-element-id,'output-field')])[13]");
    protected By lblBillingStreet = By.xpath("//span[text()='Billing City']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    protected By lblBillingState = By.xpath("//span[text()='Billing State']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    protected By lblBillingCity = By.xpath("//span[text()='Billing Street']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    protected By lblBillingCountry = By.xpath("//span[text()='Billing Country']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    protected By lblBillingPostalCode = By.xpath("//span[text()='Billing Zip code']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");

    //Verify the Lead Owner Name
    public String verifyLeadOwnerName() {

        syscoLabUI.waitTillElementLoaded(lblLeadOwner,15);
        return syscoLabUI.getText(lblLeadOwner);
    }

    //Verify the Company Name
    public String verifyCompanyName() {

        syscoLabUI.waitTillElementLoaded(lblCompanyName);
        return syscoLabUI.getText(lblCompanyName);
    }
    //Verify the Rating
    public String verifyRating() {

        syscoLabUI.waitTillElementLoaded(lblRating);
        return syscoLabUI.getText(lblRating);
    }

    //Verify the Email Address
    public String verifyEmailAddress() {

        syscoLabUI.waitTillElementLoaded(lblContactEmail);
        syscoLabUI.scrollToElement(lblContactEmail);
        return syscoLabUI.getText(lblContactEmail);
    }


    //Verify the Business Structure.
    public String verifyBusinessStructure() {

        syscoLabUI.waitTillElementLoaded(lblBusinessStructure);
        return syscoLabUI.getText(lblBusinessStructure);
    }


    //Verify the Conversion Type
    public String verifyConversionType() {

        syscoLabUI.waitTillElementLoaded(lblConversionType);
        return syscoLabUI.getText(lblConversionType);
    }

    //Verify the Billing Street
    public String verifyBillingStreet() {

        syscoLabUI.waitTillElementLoaded(lblBillingStreet);
        return syscoLabUI.getText(lblBillingStreet);
    }
    //Verify the Billing State
    public String verifyBillingState() {

        syscoLabUI.waitTillElementLoaded(lblBillingState);
        return syscoLabUI.getText(lblBillingState);
    }


    //Verify the Billing City
    public String verifyBillingCity() {

        syscoLabUI.scrollToElement(lblBillingCity);
        syscoLabUI.waitTillElementLoaded(lblBillingCity);
        return syscoLabUI.getText(lblBillingCity);
    }


    //Verify the Billing Country
    public String verifyBillingCountry() {

        syscoLabUI.waitTillElementLoaded(lblBillingCountry);
        return syscoLabUI.getText(lblBillingCountry);
    }
    //Verify the Billing Postal Code
    public String verifyBillingPostalCode() {

        syscoLabUI.waitTillElementLoaded(lblBillingPostalCode);
        return syscoLabUI.getText(lblBillingPostalCode);
    }
}
