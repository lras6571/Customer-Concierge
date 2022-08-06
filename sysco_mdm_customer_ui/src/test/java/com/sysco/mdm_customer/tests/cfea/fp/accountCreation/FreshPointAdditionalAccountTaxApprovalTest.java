package com.sysco.mdm_customer.tests.cfea.fp.accountCreation;

import com.sysco.mdm_customer.functions.cfeataxapproval.TaxApprovalScreen;
import com.sysco.mdm_customer.functions.cfeataxapproval.TaxApproverHome;
import com.sysco.mdm_customer.functions.cfeataxapproval.TaxConfirmationScreen;
import com.sysco.mdm_customer.models.CommonModelGETFreshPointLeadDetails;
import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class FreshPointAdditionalAccountTaxApprovalTest extends TestBase {

    CommonModelGETFreshPointLeadDetails fpLeadDetailsGETData;
    FPLeadAccountRequest expectFPLeadRequest;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_FP_ACC_CREATION);
    }

    @Test(description = "MDMC-TC-5181")
    public void testVerifyFreshPointAdditionalAccountTaxApprovalFlow(ITestContext context) {

        //Get Account name from context
        String accountName = (String) context.getAttribute("FPAdditionalAccountName");

        //FP user login
        fpLeadDetailsGETData = DataUtil.getFPLeadModelForReferenceKey(SFDC_CFEA_FP_LEAD_USER, commonModelGETFreshPointLeadDetailsList);
        expectFPLeadRequest = fpLeadDetailsGETData.getRequest();
        setupMAUserLogin(expectFPLeadRequest.getTaxApprover());

        TaxApproverHome.clickLeadTab();
        TaxApproverHome.selectFreshPointFilter(expectFPLeadRequest.getFilter());
        TaxApproverHome.selectRecord(accountName, FP_NCOB_QUEUE);

        TaxApprovalScreen.clickUpdateTax();
        TaxApprovalScreen.clickTaxInformation();
        TaxApprovalScreen.clickNextAddressVerification();
        TaxApprovalScreen.clickNextShippingAddressVerification();
        TaxApprovalScreen.enterTaxDetails(expectFPLeadRequest.getState());
        TaxApprovalScreen.clickNextFinalApprovalScreen();

        TaxConfirmationScreen.refreshBrowser();
        TaxConfirmationScreen.getFreshPointAccountID();


    }
}
