package com.sysco.mdm_customer.tests.cfea.af.accountCreation;

import com.sysco.mdm_customer.functions.cfeataxapproval.TaxApprovalScreen;
import com.sysco.mdm_customer.functions.cfeataxapproval.TaxApproverHome;
import com.sysco.mdm_customer.functions.cfeataxapproval.TaxConfirmationScreen;
import com.sysco.mdm_customer.models.CommonModelGETAsianFoodsLeadDetails;
import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class AsianFoodsAdditionalAccountTaxApprovalTest extends TestBase {

    CommonModelGETAsianFoodsLeadDetails afLeadDetailsGETData;
    AFLeadAccountRequest expectAFLeadRequest;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_AF_ACC_CREATION);
    }

    @Test(description = "MDMC-TC-5251")
    public void testVerifyAsianFoodsAdditionalAccountTaxApprovalFlow(ITestContext context) {

        //Get Account name from context
        String accountName = (String) context.getAttribute("AFAdditionalAccountName");

        //AF user login
        afLeadDetailsGETData = DataUtil.getAFLeadModelForReferenceKey(SFDC_CFEA_AF_LEAD_USER, commonModelGETAsianFoodsLeadDetailsList);
        expectAFLeadRequest = afLeadDetailsGETData.getRequest();
        setupMAUserLogin(expectAFLeadRequest.getTaxApprover());

        TaxApproverHome.clickLeadTab();
        TaxApproverHome.selectAsianFoodsFilter(expectAFLeadRequest.getFilter());
        TaxApproverHome.selectRecord(accountName, AF_NCOB_QUEUE);

        TaxApprovalScreen.clickUpdateTax();
        TaxApprovalScreen.clickTaxInformation();
        TaxApprovalScreen.clickNextAddressVerification();
        TaxApprovalScreen.clickNextShippingAddressVerification();
        TaxApprovalScreen.enterTaxDetails(expectAFLeadRequest.getState());
        TaxApprovalScreen.clickNextFinalApprovalScreen();

        TaxConfirmationScreen.refreshBrowser();
        TaxConfirmationScreen.getAsianFoodsAccountID();

    }
}
