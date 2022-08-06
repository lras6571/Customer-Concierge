package com.sysco.mdm_customer.tests.usbl.accountCreation.mrt;

import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.lead.LeadCreation;
import com.sysco.mdm_customer.functions.mrt.MRTLeadScreen;
import com.sysco.mdm_customer.functions.mrt.MRTTerritoryScreen;
import com.sysco.mdm_customer.functions.ps.AddressDetailsScreen;
import com.sysco.mdm_customer.functions.ps.ContactInformationScreen;
import com.sysco.mdm_customer.models.CommonModelGETInitiateShipToScreenAssertionDetails;
import com.sysco.mdm_customer.models.CommonModelGETMRTAccountDetails;
import com.sysco.mdm_customer.models.request.GetInitiateShipToScreenAssertionRequest;
import com.sysco.mdm_customer.models.request.GetMRTAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.lead.ApprovedLeadAssertionUtil;
import com.sysco.mdm_customer.utils.lead.CreatedLeadAssertionUtil;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class SingleOpCoMRTTest extends TestBase {
    CommonModelGETMRTAccountDetails mrtAccountDetailsGETData;
    GetMRTAccountRequest expectedMRTAccountRequest;
    CommonModelGETInitiateShipToScreenAssertionDetails screenAssertionDetailsGETData;
    GetInitiateShipToScreenAssertionRequest screenAssertionRequest;
    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_LEAD_CREATION);
    }


    //Click Lead Creation and start
    @Test(description = "MDMC-TC-5079")
    public void verifyLeadCreationFlow(){
        mrtAccountDetailsGETData = DataUtil.getMRTModelForReferenceKey("SFDC_MRT_USER", commonModelGETMRTAccountDetailsList);
        expectedMRTAccountRequest = mrtAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedMRTAccountRequest.getMarketingAssociate());
        //Create the Lead for MRT User
        ConciergeLobby.clickLeadCreation();
        LeadCreation.selectSalutation();
        LeadCreation.enterCompanyName(expectedMRTAccountRequest.getCompanyName());
        LeadCreation.enterWeeklySales(expectedMRTAccountRequest.getWeeklySales());
        LeadCreation.enterContactEmail(expectedMRTAccountRequest.getContactEmail());
        LeadCreation.enterCompanyContactDetails(expectedMRTAccountRequest.getFirstName(), expectedMRTAccountRequest.getLastName());
        LeadCreation.assignToDSM(expectedMRTAccountRequest.getDsm());
        LeadCreation.selectLeadRating(expectedMRTAccountRequest.getLeadRating());
        LeadCreation.enterBillToAddress(expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingStreet(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingState(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingCity(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingCountry(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingPostalCode());
        LeadCreation.saveLeadDetails();
        LeadCreation.clickDetailTab();
        CreatedLeadAssertionUtil.assertCreatedMRTLead(expectedMRTAccountRequest.getCompanyName(),expectedMRTAccountRequest.getContactEmail(),expectedMRTAccountRequest.getDsm(),expectedMRTAccountRequest.getLeadRating(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingStreet(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingState(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingCity(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingCountry(),expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingPostalCode());

        //Start the MRT Account Creation Flow
        MRTLeadScreen.clickProspectShop();
        MRTTerritoryScreen.selectTerritory();
        MRTTerritoryScreen.clickNext();

        //Enter Data in the Address Details Screen - Ship To
        AddressDetailsScreen.enterShipToAddressDetails(expectedMRTAccountRequest.getLeadShipToInfo().get(0).getShippingStreet(), expectedMRTAccountRequest.getLeadShipToInfo().get(0).getShippingCity());
        AddressDetailsScreen.enterShipToPostalDetails(expectedMRTAccountRequest.getLeadShipToInfo().get(0).getShippingState(), expectedMRTAccountRequest.getLeadShipToInfo().get(0).getShippingPostalCode());
        AddressDetailsScreen.enterShipToCountryDetails(expectedMRTAccountRequest.getLeadShipToInfo().get(0).getShippingCountry());

        //Enter Data in the Address Details Screen - Bill To
        AddressDetailsScreen.enterBillToNameDetails(expectedMRTAccountRequest.getLeadShipToInfo().get(0).getShipToAccountName());
        AddressDetailsScreen.enterBillToAddressDetails(expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingStreet(), expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingCity());
        AddressDetailsScreen.enterBillToPostalDetails(expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingState(), expectedMRTAccountRequest.getLeadBillToInfo().get(0).getBillingPostalCode());

        AddressDetailsScreen.clickNextProspectShopAddressScreen();
        AddressDetailsScreen.clickNextAddressConfirmation();

        //Enter Data in the Contact Details Screen
        ContactInformationScreen.enterContactNameInfoDetails(expectedMRTAccountRequest.getContactInfo().get(0).getFirstName(),expectedMRTAccountRequest.getContactInfo().get(0).getLastName());
        ContactInformationScreen.enterContactInfoDetails(expectedMRTAccountRequest.getContactInfo().get(0).getCaddEmail(),expectedMRTAccountRequest.getContactInfo().get(0).getMobileNumber());
        ContactInformationScreen.clickNextContactInfo();
        screenAssertionDetailsGETData = DataUtil.getAssertionForReferenceKey("USER_ASSERTION_01", commonModelGetScreenAssertionDetailsGETDataList);
        screenAssertionRequest = screenAssertionDetailsGETData.getRequest();
        ApprovedLeadAssertionUtil.assertInitiateShipToScreen(screenAssertionRequest.getMRTInitiateShipTo().get(0).getAccountCreateMaintain(),screenAssertionRequest.getMRTInitiateShipTo().get(0).getStatus(),screenAssertionRequest.getMRTInitiateShipTo().get(0).getCreditApplicationStatus(),screenAssertionRequest.getMRTInitiateShipTo().get(0).getAccountRole(),screenAssertionRequest.getMRTInitiateShipTo().get(0).getApplicationRequestType());
    }
}
