package com.sysco.mdm_customer.pages.cfeataxapproval;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class TaxApproverHomePage {

    protected By btnLead = By.xpath("(//a[@title='Leads'])[1]");
    protected By lblTableHeaderName = By.xpath("//span[@title='Name']");
    protected By txtFilter = By.xpath("(//input[contains(@role,'combobox')])[1]");
    protected By btnFilterArrow = By.xpath("//div[@class='triggerLinkTextAndIconWrapper slds-page-header__name']");
    protected By lblAsianFoodsFilter = By.xpath("//mark[normalize-space()='Asian Foods NCOB Queue']");
    protected By lblFreshPointFilter = By.xpath("//mark[normalize-space()='FreshPoint NCOB Queue']");
    protected By lblCreatedDate = By.xpath("//span[@title='Created Date']");
    protected By lblFirstSR = By.xpath("(//a[@data-refid='recordId'])[1]");
    protected By lblSecondSR = By.xpath("(//a[@data-refid='recordId'])[3]");
    protected By lblFilteredBy = By.xpath("//span[contains(text(),'Filtered by #')]");
    protected By lblSR = By.xpath("(//a[@data-refid='recordId'])[#]");
    protected By lblAllSR = By.xpath("//table/tbody/tr");


    //Click Lead Tab
    public void clickLeadTab() {

        syscoLabUI.waitTillElementLoaded(btnLead, 10);
        syscoLabUI.clickWithJavascript(btnLead);
        LoggerUtil.logINFO("Click Lead Tab");
        syscoLabUI.waitTillElementLoaded(lblTableHeaderName, 10);
    }


    //Select the Asian Foods NCOB Queue Filter
    public void selectAsianFoodsFilter(String strAsianFoodsFilter) {

        syscoLabUI.click(btnFilterArrow);
        LoggerUtil.logINFO("Click Filter Icon");
        syscoLabUI.waitTillElementLoaded(txtFilter);
        syscoLabUI.sendKeys(txtFilter, strAsianFoodsFilter);
        syscoLabUI.sleep(5);
        LoggerUtil.logINFO("Enter Asian Foods NCOB Queue Text Box");
        syscoLabUI.waitTillElementLoaded(lblAsianFoodsFilter, 6);
        syscoLabUI.clickWithJavascript(lblAsianFoodsFilter);
        LoggerUtil.logINFO("Asian Foods NCOB Queue from the Drop Down");
    }


    //Select the Asian Foods NCOB Queue Filter
    public void selectFreshPointFilter(String strFreshPointFilter) {

        syscoLabUI.click(btnFilterArrow);
        LoggerUtil.logINFO("Click Filter Icon");
        syscoLabUI.waitTillElementLoaded(txtFilter);
        syscoLabUI.sendKeys(txtFilter, strFreshPointFilter);
        syscoLabUI.sleep(5);
        LoggerUtil.logINFO("Enter Fresh Point NCOB Queue Text Box");
        syscoLabUI.waitTillElementLoaded(lblFreshPointFilter, 6);
        syscoLabUI.clickWithJavascript(lblFreshPointFilter);
        LoggerUtil.logINFO("Fresh Point NCOB Queue from the Drop Down");
    }


    //Select the Records by Time
    public void clickTimeColumn() {

        syscoLabUI.waitTillElementLoaded(lblCreatedDate);
        syscoLabUI.clickWithJavascript(lblCreatedDate);
        LoggerUtil.logINFO("Select the Records by Time");
    }


    //Select the First Record
    public void selectFirstRecord() {

        syscoLabUI.waitTillElementLoaded(lblFirstSR);
        syscoLabUI.sleep(5);
        syscoLabUI.clickWithJavascript(lblFirstSR);
        LoggerUtil.logINFO("Select the First Record");
    }


    //Select the Record by Name
    public void selectRecordByName(String name, String queueName){

        syscoLabUI.waitTillElementLoaded(DriverSetUpUtil.replaceInLocator(lblFilteredBy, "#", queueName));

        int noOfRecords = syscoLabUI.findElements(lblAllSR).size();
        LoggerUtil.logINFO("Total records: " + noOfRecords);
        int recordNo = 1;
        for (int i = 1; i<noOfRecords+1; i++)
        {
            String recordName = syscoLabUI.getAttribute(DriverSetUpUtil.replaceInLocator(lblSR, "#", i), "title");
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