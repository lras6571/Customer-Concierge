package com.sysco.mdm_customer.pages.sbsuser;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class SBSApprovalPage {


    protected By btnAcceptCase = By.xpath("//button[contains(text(),'Accept Case')]");
    protected By lblDataServiceTab = By.xpath("//a[@id='customTab__item']");
    protected By lblTabDataService = By.xpath("(//a[normalize-space()='Data Services'])[1]");
    protected By btnSave = By.xpath("//button[contains(text(),'Save')]");
    protected By btnNext = By.xpath("//button[normalize-space()='Next']");
    protected By btnNewTaxEntry = By.xpath("//button[text()='New Tax Entry']");
    protected By txtTaxAuthorityGroup = By.xpath("//input[@name='Group__c']");
    protected By txtTaxAuthoritySupplement = By.xpath("//input[@name='Sup__c']");
    protected By btnApprove = By.xpath("//button[text()='Approve']");
    protected By txtComments = By.xpath("//textarea[@name='ApprovalComments']");
    protected By btnFinish = By.xpath("//button[normalize-space()='Finish']");
    protected By lblAccountID = By.xpath("//span[normalize-space()='Account ID']");
    protected By btnAppLauncher = By.xpath("//div[@aria-label='App']//button[@type='button']");
    protected By txtSearchApps = By.xpath("//input[@placeholder='Search apps and items...']");
    protected By lblSupportRequest = By.xpath("(//a[@data-label='Support Requests'])[last()]");
    protected By lblFirstSR = By.xpath("(//a[@data-refid='recordId'])[1]");
    protected By lblSecondSR = By.xpath("(//a[@data-refid='recordId'])[3]");
    protected By lblSR = By.xpath("(//a[@data-refid='recordId'])[#]");
    protected By lblName = By.xpath("(//td//a[@data-refid='recordId'])[#]");
    protected By lblAllSR = By.xpath("//table/tbody/tr");



    //Accept Case SR by SBS User
    public void selectAcceptCase() {

        syscoLabUI.sleep(5);
        syscoLabUI.waitTillElementLoaded(btnAcceptCase, 20);
        LoggerUtil.logINFO("URL of the SR is : " + syscoLabUI.getCurrentURL());
        syscoLabUI.click(btnAcceptCase);
        LoggerUtil.logINFO("Click Accept Case Button");
    }


    //Click Data Service Tab
    public void clickDataServiceTab() {

        try {

            syscoLabUI.sleep(15);
            syscoLabUI.click(lblDataServiceTab);
            LoggerUtil.logINFO("Click Data Service Tab - Try");
        } catch (Exception e) {

            syscoLabUI.waitTillElementLoaded(lblTabDataService, 10);
            syscoLabUI.click(lblTabDataService);
            LoggerUtil.logINFO("Click Data Service Tab - Catch");
        }
    }


    //Click Save the Address Details
    public void clickSaveAddresses() {

        syscoLabUI.sleep(5);
        syscoLabUI.scrollToElement(btnSave);
        syscoLabUI.clickWithJavascript(btnSave);
        LoggerUtil.logINFO("Click Data Service Tab");
    }


    //Click Next in Address Verification Screen
    public void clickNextAddressVerification() {

        syscoLabUI.sleep(5);
        syscoLabUI.waitTillElementLoaded(btnNext, 15);
        syscoLabUI.scrollToElement(btnNext);
        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Click Next Button in Address Verification");
    }


    //Enter Tax Details
    public void enterTaxDetails(String strTaxGroup, String strTaxSupplement) {

        if (syscoLabUI.isDisplayed(btnNewTaxEntry)) {
            syscoLabUI.clickWithJavascript(btnNewTaxEntry);
        }
        syscoLabUI.sendKeys(txtTaxAuthorityGroup, strTaxGroup);
        syscoLabUI.sendKeys(txtTaxAuthoritySupplement, strTaxSupplement);
    }


    //Click Save Button in Tax Screen
    public void saveTaxDetails() {

        syscoLabUI.sleep(5);
        syscoLabUI.scrollToElement(btnSave);
        syscoLabUI.waitTillElementLoaded(btnSave);
        syscoLabUI.clickWithJavascript(btnSave);
        syscoLabUI.sleep(5);
    }


    //Click Next Button in Tax Screen
    public void navigateToNextTab() {

        syscoLabUI.scrollToElement(btnNext);
        syscoLabUI.clickWithJavascript(btnNext);
        syscoLabUI.sleep(5);
    }


    //Approve the Support Request
    public void approveSupportRequest(String approveComment) {

        syscoLabUI.waitTillElementLoaded(txtComments);
        syscoLabUI.sendKeys(txtComments, approveComment);
        syscoLabUI.clickWithJavascript(btnApprove);
        syscoLabUI.waitTillElementLoaded(btnFinish, 15);
        syscoLabUI.clickWithJavascript(btnFinish);
        syscoLabUI.waitTillElementLoaded(lblAccountID, 30);
    }

    //Search the Support Request
    public void searchSupportRequest() {

        syscoLabUI.waitTillElementLoaded(btnAppLauncher);
        syscoLabUI.clickWithJavascript(btnAppLauncher);
        syscoLabUI.sendKeys(txtSearchApps, "Support Request");
        syscoLabUI.waitTillElementLoaded(lblSupportRequest, 25);
        syscoLabUI.clickWithJavascript(lblSupportRequest);
    }
    //Select the Record by name
    public void selectRecordByName(String name){

        syscoLabUI.waitTillElementLoaded(lblFirstSR);

        int noOfRecords = syscoLabUI.findElements(lblAllSR).size();
        LoggerUtil.logINFO("Total records: " + noOfRecords);
        int recordNo = 1;
        for (int i = 1; i<noOfRecords+1; i++)
        {
            String recordName = syscoLabUI.getAttribute(DriverSetUpUtil.replaceInLocator(lblName, "#", i), "title");
            if (recordName.equals(name))
            {
                recordNo = i;
                break;
            }
        }

        syscoLabUI.clickWithJavascript(DriverSetUpUtil.replaceInLocator(lblSR, "#", recordNo));
        LoggerUtil.logINFO("Select the Record");

    }
}
