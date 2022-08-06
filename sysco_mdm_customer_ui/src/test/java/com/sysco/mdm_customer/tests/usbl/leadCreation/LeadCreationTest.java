package com.sysco.mdm_customer.tests.usbl.leadCreation;

import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.Home;
import com.sysco.mdm_customer.functions.NavigateToAccountsProspects;
import com.sysco.mdm_customer.functions.lead.LeadCreation;
import com.sysco.mdm_customer.functions.NavigateToCustomerConcierge;
import com.sysco.mdm_customer.models.CommonModelGETLeadAccountDetails;
import com.sysco.mdm_customer.models.request.GetLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.lead.CreatedLeadAssertionUtil;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class LeadCreationTest extends TestBase {
    CommonModelGETLeadAccountDetails leadAccountDetailsGETData;
    GetLeadAccountRequest expectedLeadAccountRequest;


    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_LEAD_CREATION);
    }


    /*
     * Login as USBL-MA User Thomas Flynn
     * Navigate to Customer Concierge Lobby
     *
     * */

    //Click Lead Creation and start the Flow
    @Test(description = "MDMC-TC-5079", priority=1)
    public void verifyLeadCreationFlow(){

        leadAccountDetailsGETData = DataUtil.getLeadModelForReferenceKey("SFDC_LEAD_USER", commonModelGETLeadAccountDetailsList);
        expectedLeadAccountRequest = leadAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedLeadAccountRequest.getMarketingAssociate());
        NavigateToCustomerConcierge.selectCustomerConcierge();
        ConciergeLobby.clickLeadCreation();
        LeadCreation.selectSalutation();
        LeadCreation.enterCompanyName(expectedLeadAccountRequest.getCompanyName());
        LeadCreation.enterWeeklySales(expectedLeadAccountRequest.getWeeklySales());
        LeadCreation.enterContactEmail(expectedLeadAccountRequest.getContactEmail());
        LeadCreation.enterCompanyContactDetails(expectedLeadAccountRequest.getFirstName(), expectedLeadAccountRequest.getLastName());
        LeadCreation.assignToDSM(expectedLeadAccountRequest.getDsm());
        LeadCreation.selectLeadRating(expectedLeadAccountRequest.getLeadRating());
        LeadCreation.enterBillToAddress(expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingStreet(),expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingState(),expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingCity(),expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingCountry(),expectedLeadAccountRequest.getLeadBillToInfo().get(0).getBillingPostalCode());
        LeadCreation.saveLeadDetails();

    }

    //Assert the Screen after the Lead Creation
    @Test(description = "MDMC-TC-5080",priority=2)
    public void verifyCratedLead(){

      //  CreatedLeadAssertionUtil.assertCreatedLead(expectedLeadAccountRequest);
    }
}