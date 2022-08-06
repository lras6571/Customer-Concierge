package com.sysco.mdm_customer.tests.usbl.accountCreation;

import com.sysco.mdm_customer.functions.Home;
import com.sysco.mdm_customer.functions.sbsuser.SBSApproval;
import com.sysco.mdm_customer.functions.sbsuser.SBSUserHome;
import com.sysco.mdm_customer.models.CommonModelGETSBSApprovalDetails;
import com.sysco.mdm_customer.models.request.GetSBSApprovalRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.SFDC_CFEA_AF_LEAD_USER;

public class SBSApprovalTest extends TestBase {

    CommonModelGETSBSApprovalDetails sbsUserDetailsGETData;
    GetSBSApprovalRequest expectedSBSApprovalRequest;


    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Classic Mode - CADD New Flow");
    }

    /*
     * Login as SBS User Madison Dueitt
     * Click SR for the given Account to dot he approval
     *
     * */

   //MDMC-TC-5245,MDMC-TC-5066
    @Test(description = "MDMC-TC-5066")
    public void verifySBSApprovalFlow(ITestContext context) {

        //Login as SBS User for Approval
        sbsUserDetailsGETData = DataUtil.getSBSModelForReferenceKey("SBS_USER_LOGIN", commonModelGETSBSApprovalDetailsList);
        expectedSBSApprovalRequest = sbsUserDetailsGETData.getRequest();
        setupMAUserLogin(expectedSBSApprovalRequest.getSbsUser());
        changeProfile();

        //Get Account name from context
        String accountName = (String) context.getAttribute("AcceptCaseAccountName");

        //SBSApproval.selectSupportRequest();
        SBSUserHome.clickSupportRequestTab();
        SBSUserHome.selectMasterDataQueue(expectedSBSApprovalRequest.getSupportRequestFilter().get(1).getSupportRequestFilterType());
        SBSApproval.selectRecord(accountName);
        SBSApproval.selectAcceptCase();
        SBSApproval.clickDataServiceTab();
        SBSApproval.clickNextAddressVerification();
        SBSApproval.enterTaxDetails(expectedSBSApprovalRequest.getTaxGroup(), expectedSBSApprovalRequest.getTaxSupplement());
        SBSApproval.approveSupportRequest(expectedSBSApprovalRequest.getApproveComments());
    }

}