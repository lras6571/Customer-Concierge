package com.sysco.mdm_customer.pages.cfeataxapproval;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class TaxConfirmationScreenPage {

    protected By lblLeadApprove = By.xpath("//b[contains(text(),\"Please click 'Next' to approve the lead.\")]");
    protected By lblAccountID = By.xpath("(//span[normalize-space()='Account ID'])[1]");
    protected By lblLeadOwner = By.xpath("(//span[normalize-space()='Lead Owner'])[1]");
    protected By lblDetails = By.xpath("(//a[normalize-space()='Details'])[1]");
    protected By lblAccountName = By.xpath("//span[@id='window']");
    protected By lblFreshPointAccountNumber = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[28]");
    protected By lblAsianFoodsAccountNumber = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[31]");


    //Refresh the Browser
    public void refreshBrowser() {

        syscoLabUI.waitTillElementDisappear(lblLeadApprove);
        syscoLabUI.getText(lblAccountID);
        syscoLabUI.sleep(30);
        syscoLabUI.refreshBrowser();
    }

    //Get CFEA FP New Account ID
    public void getFreshPointAccountID() {

        try {

            syscoLabUI.waitTillElementLoaded(lblDetails, 15);
            syscoLabUI.clickWithJavascript(lblDetails);
            syscoLabUI.waitTillElementLoaded(lblLeadOwner, 10);
            String freshPointAccountID = syscoLabUI.getText(lblFreshPointAccountNumber);
            LoggerUtil.logINFO("CFEA Fresh Point Account ID is : " + freshPointAccountID);
        } catch (Exception e) {

            syscoLabUI.isDisplayed(lblAccountName);
            LoggerUtil.logINFO("CFEA FreshPoint Account ID is Not Available");
        }

    }


    //Get CFEA AF New Account ID
    public void getAsianFoodsAccountID() {

        try {

            syscoLabUI.waitTillElementLoaded(lblDetails, 15);
            syscoLabUI.clickWithJavascript(lblDetails);
            syscoLabUI.waitTillElementLoaded(lblLeadOwner, 10);
            String asianFoodsAccountID = syscoLabUI.getText(lblAsianFoodsAccountNumber);
            LoggerUtil.logINFO("CFEA Asian Foods Account ID is : " + asianFoodsAccountID);
        } catch (Exception e) {

            syscoLabUI.isDisplayed(lblAccountName);
            LoggerUtil.logINFO("CFEA Asian Foods Account ID is Not Available");
        }

    }

}

