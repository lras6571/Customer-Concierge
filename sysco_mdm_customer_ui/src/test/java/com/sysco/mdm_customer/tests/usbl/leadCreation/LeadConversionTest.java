package com.sysco.mdm_customer.tests.usbl.leadCreation;

import com.sysco.mdm_customer.functions.NavigateToAccountsProspects;
import com.sysco.mdm_customer.functions.lead.LeadRecord;
import com.sysco.mdm_customer.functions.lead.LeadsHome;
import com.sysco.mdm_customer.models.CommonModelGETLeadAccountDetails;
import com.sysco.mdm_customer.models.request.GetLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.lead.ApprovedLeadAssertionUtil;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class LeadConversionTest extends TestBase {

    CommonModelGETLeadAccountDetails leadAccountDetailsGETData;
    GetLeadAccountRequest expectedLeadAccountRequest;


    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_LEAD_CREATION);
    }


    /*
     * Login as DSM User Joseph Gaudreau
     *
     *
     * */

    //Click Lead Creation and start
    @Test(description = "MDMC-TC-5080", priority = 0)
    public void verifyLeadConversionFlow() {

        leadAccountDetailsGETData = DataUtil.getLeadModelForReferenceKey("SFDC_LEAD_USER", commonModelGETLeadAccountDetailsList);
        expectedLeadAccountRequest = leadAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedLeadAccountRequest.getDsm());

        //Select the Record of the Lead
        NavigateToAccountsProspects.selectLeads();
        LeadsHome.viewList("My Leads");
        LeadsHome.sortLeadList();
        LeadsHome.selectFirstRecord();

        //Convert the Lead into a Prospect
        LeadRecord.startLeadConversion();
        LeadRecord.enterRecordOwner(expectedLeadAccountRequest.getOpCo(), expectedLeadAccountRequest.getMarketingAssociate());
        LeadRecord.setAccountName();
        LeadRecord.setTerritory(expectedLeadAccountRequest.getTerritory());
        LeadRecord.setReminder(false);
        LeadRecord.finishLeadConversion();
    }

    //Assert the Screen after the Lead Creation
    @Test(description = "MDMC-TC-5081", priority = 1)
    public void verifyCratedLead() {

        ApprovedLeadAssertionUtil.assertInitiateShipToScreenProspect(expectedLeadAccountRequest);
    }
}
