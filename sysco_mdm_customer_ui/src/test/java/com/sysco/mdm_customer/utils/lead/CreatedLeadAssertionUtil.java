package com.sysco.mdm_customer.utils.lead;

import com.sysco.mdm_customer.functions.lead.CreatedLead;
import com.sysco.mdm_customer.models.request.GetLeadAccountRequest;
import com.sysco.mdm_customer.models.request.GetMRTAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;
import org.stringtemplate.v4.ST;

public class CreatedLeadAssertionUtil extends TestBase {


    //Created Lead Assertion
    public static void assertCreatedLead(GetLeadAccountRequest expectedLeadAccountRequest) {

        softAssert.assertEquals(CreatedLead.verifyLeadOwnerName(), expectedLeadAccountRequest.getMarketingAssociate(), "Invalid Account Owner");
        softAssert.assertEquals(CreatedLead.verifyEmailAddress(), expectedLeadAccountRequest.getContactEmail(), "Invalid Email Address");
        softAssert.assertEquals(CreatedLead.verifyBillingCity(), expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingCity(), "Invalid Billing City");
        softAssert.assertEquals(CreatedLead.verifyBillingState(), expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingState(), "Invalid Billing State");
        softAssert.assertEquals(CreatedLead.verifyBillingCountry(), expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingCountry(), "Invalid Billing Country");
        softAssert.assertEquals(CreatedLead.verifyBusinessStructure(), expectedLeadAccountRequest.getBusinessStructure(), "Invalid Business Structure");
        softAssert.assertEquals(CreatedLead.verifyConversionType(), expectedLeadAccountRequest.getConversionType(), "Invalid Conversion Type");
        softAssert.assertAll();
    }

    //Common Created Lead Assertion
    public static void assertCreatedMRTLead(String companyName, String contactEmail, String leadOwnerName, String rating,String billingStreet, String billingState,String billingCity,String billingCountry,String billingPostalCode) {

        softAssert.assertEquals(CreatedLead.verifyCompanyName(), companyName, "Invalid Company Name");
        softAssert.assertEquals(CreatedLead.verifyEmailAddress(), contactEmail, "Invalid Email Address");
        softAssert.assertEquals(CreatedLead.verifyLeadOwnerName(), leadOwnerName, "Invalid Owner Name");
        softAssert.assertEquals(CreatedLead.verifyRating(), rating, "Invalid Lead Rating");
        softAssert.assertEquals(CreatedLead.verifyBillingStreet(),billingStreet, "Invalid Billing Street");
        softAssert.assertEquals(CreatedLead.verifyBillingState(), billingState, "Invalid Billing State");
        softAssert.assertEquals(CreatedLead.verifyBillingCity(), billingCity, "Invalid Billing City");
        softAssert.assertEquals(CreatedLead.verifyBillingCountry(), billingCountry, "Invalid Billing Country");
        softAssert.assertEquals(CreatedLead.verifyBillingPostalCode(), billingPostalCode, "Invalid Billing Postal Code");
        softAssert.assertAll();
    }
}
