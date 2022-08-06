package com.sysco.mdm_customer.tests.cfea.af.leadCreation;

import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.cfealead.CFEALeadCreation;
import com.sysco.mdm_customer.models.CommonModelGETAsianFoodsLeadDetails;
import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class AsianFoodsLeadCreationTest extends TestBase {

    CommonModelGETAsianFoodsLeadDetails afLeadDetailsGETData;
    AFLeadAccountRequest expectAFLeadRequest;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_AF_LEAD_CREATION);
    }

    @Test(description = "MDMC-TC-5255")
    public void testVerifyCFEAAsianFoodsLeadFlow(ITestContext context) {

        //AF user login
        afLeadDetailsGETData = DataUtil.getAFLeadModelForReferenceKey(SFDC_CFEA_AF_LEAD_USER, commonModelGETAsianFoodsLeadDetailsList);
        expectAFLeadRequest = afLeadDetailsGETData.getRequest();
        setupMAUserLogin(expectAFLeadRequest.getMarketingAssociate());

        ConciergeLobby.clickCFEALeadCreationIcon();
        CFEALeadCreation.enterCompanyName(expectAFLeadRequest.getCompanyName());
        CFEALeadCreation.selectSalutation();
        CFEALeadCreation.enterWeeklySales(expectAFLeadRequest.getWeeklySales());
        CFEALeadCreation.enterContactEmail(expectAFLeadRequest.getContactEmail());
        CFEALeadCreation.enterCompanyContactDetails(expectAFLeadRequest.getFirstName(), expectAFLeadRequest.getLastName());
        CFEALeadCreation.selectLeadRating();
        CFEALeadCreation.selectBusinessStructure();
        CFEALeadCreation.saveLeadDetails();

        //Set Lead name to context
        context.setAttribute("AFLeadName", CFEALeadCreation.retrieveLeadName(expectAFLeadRequest.getCompanyName()));

    }
}
