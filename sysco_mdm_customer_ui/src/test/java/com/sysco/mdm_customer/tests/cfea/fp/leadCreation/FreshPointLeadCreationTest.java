package com.sysco.mdm_customer.tests.cfea.fp.leadCreation;

import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.cfealead.CFEALeadCreation;
import com.sysco.mdm_customer.models.CommonModelGETFreshPointLeadDetails;
import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class FreshPointLeadCreationTest extends TestBase {

    CommonModelGETFreshPointLeadDetails fpLeadDetailsGETData;
    FPLeadAccountRequest expectFPLeadRequest;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_FP_LEAD_CREATION);
    }

    @Test(description = "MDMC-TC-5162")
    public void testVerifyCFEAFreshPointLeadFlow(ITestContext context) {

        //FP user login
        fpLeadDetailsGETData = DataUtil.getFPLeadModelForReferenceKey(SFDC_CFEA_FP_LEAD_USER, commonModelGETFreshPointLeadDetailsList);
        expectFPLeadRequest = fpLeadDetailsGETData.getRequest();
        setupMAUserLogin(expectFPLeadRequest.getMarketingAssociate());

        ConciergeLobby.clickCFEALeadCreationIcon();
        CFEALeadCreation.enterCompanyName(expectFPLeadRequest.getCompanyName());
        CFEALeadCreation.selectSalutation();
        CFEALeadCreation.enterCompanyContactDetails(expectFPLeadRequest.getFirstName(), expectFPLeadRequest.getLastName());
        CFEALeadCreation.enterContactEmail(expectFPLeadRequest.getContactEmail());
        CFEALeadCreation.enterWeeklySales(expectFPLeadRequest.getWeeklySales());
        CFEALeadCreation.enterCommunicationMethod();
        CFEALeadCreation.enterPhoneNumber(expectFPLeadRequest.getMobileNumber());
        CFEALeadCreation.enterTitle();
        CFEALeadCreation.selectLeadRating();
        CFEALeadCreation.selectBusinessStructure();
        CFEALeadCreation.saveLeadDetails();

        //Set Lead name to context
        context.setAttribute("FPLeadName", CFEALeadCreation.retrieveLeadName(expectFPLeadRequest.getCompanyName()));

    }

}
