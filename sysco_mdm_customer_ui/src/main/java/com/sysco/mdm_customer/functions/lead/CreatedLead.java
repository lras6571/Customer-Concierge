package com.sysco.mdm_customer.functions.lead;

import com.sysco.mdm_customer.pages.lead.CreatedLeadPage;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CreatedLead {


    private CreatedLead(){
    }
    public static final CreatedLeadPage createdLeadPage = new CreatedLeadPage();


    //Verify the Lead Owner Name
    public static String verifyLeadOwnerName() {

        return createdLeadPage.verifyLeadOwnerName();
    }

    //Verify the Company Name
    public static String verifyCompanyName() {

        return createdLeadPage.verifyCompanyName();
    }
    //Verify the Rating
    public static String verifyRating() {

        return createdLeadPage.verifyRating();
    }

    //Verify the Email Address
    public static String verifyEmailAddress() {

        return createdLeadPage.verifyEmailAddress();
    }


    //Verify the Business Structure
    public static String verifyBusinessStructure() {

        return createdLeadPage.verifyBusinessStructure();
    }


    //Verify the Conversion Type
    public static String verifyConversionType() {

        return createdLeadPage.verifyConversionType();
    }
    //Verify the Billing Street
    public static String verifyBillingStreet() {

        return createdLeadPage.verifyBillingStreet();
    }

    //Verify the Billing State
    public static String verifyBillingState() {

        return createdLeadPage.verifyBillingState();
    }


    //Verify the Billing City
    public static String verifyBillingCity() {

        return createdLeadPage.verifyBillingCity();
    }


    //Verify the Billing Country
    public static String verifyBillingCountry() {

        return createdLeadPage.verifyBillingCountry();
    }
    //Verify the Billing Postal Code
    public static String verifyBillingPostalCode() {

        return createdLeadPage.verifyBillingPostalCode();
    }

}
