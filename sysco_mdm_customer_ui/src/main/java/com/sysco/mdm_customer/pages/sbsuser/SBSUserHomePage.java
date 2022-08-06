package com.sysco.mdm_customer.pages.sbsuser;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class SBSUserHomePage {

    protected By btnSupportRequestTab = By.xpath("//a[@title='Support Requests']");
    protected By btnFilterArrow = By.xpath("//div[@class='triggerLinkTextAndIconWrapper slds-page-header__name']");
    protected By btnMasterDataQueue = By.xpath("(//a[@role='option'])[2]");
    protected By txtFilter = By.xpath("//input[@role='combobox']");
    protected By lblTimeColumn = By.xpath("//span[@title='Date/Time Opened']");
    protected By lblFirstSR = By.xpath("(//a[@data-refid='recordId'])[1]");
    protected By lblSecondSR = By.xpath("(//a[@data-refid='recordId'])[3]");
    protected By btnAppLauncher = By.xpath("//div[@aria-label='App']//button[@type='button']");
    protected By txtSearchApps = By.xpath("//input[@placeholder='Search apps and items...']");
    protected By lblSupportRequest = By.xpath("(//a[(@data-label='Support Requests') and (@id='Case')])");

    //Select the Support Request Tab
    public void clickSupportRequestTab() {
        syscoLabUI.sleep(3);
        if (syscoLabUI.isDisplayed(btnSupportRequestTab)) {
            syscoLabUI.waitTillElementLoaded(btnSupportRequestTab, 40);
            syscoLabUI.clickWithJavascript(btnSupportRequestTab);
            LoggerUtil.logINFO("Select the Support Request Tab");

        } else {

            syscoLabUI.waitTillElementLoaded(btnAppLauncher);
            syscoLabUI.clickWithJavascript(btnAppLauncher);
            syscoLabUI.sendKeys(txtSearchApps, "Support Request");
            syscoLabUI.waitTillElementLoaded(lblSupportRequest, 25);
            syscoLabUI.clickWithJavascript(lblSupportRequest);
        }
    }


    //Select the Master Data Queue Filter
    public void selectMasterDataQueue(String supportRequestFilter) {

        syscoLabUI.sleep(10);
        syscoLabUI.waitTillElementLoaded(lblFirstSR, 20);
        syscoLabUI.click(btnFilterArrow);
        LoggerUtil.logINFO("Click Filter Icon");
        syscoLabUI.waitTillElementLoaded(txtFilter);
        syscoLabUI.sendKeys(txtFilter, supportRequestFilter);
        syscoLabUI.sleep(5);
        LoggerUtil.logINFO("Enter CMU Master Data Queue in the Text Box");
        syscoLabUI.waitTillElementLoaded(btnMasterDataQueue, 6);
        syscoLabUI.clickWithJavascript(btnMasterDataQueue);
        LoggerUtil.logINFO("Select Master Data Queue from the Drop Down");
    }


    //Select the Records by Time
    public void clickTimeColumn() {

        syscoLabUI.waitTillElementLoaded(lblTimeColumn);
        syscoLabUI.click(lblTimeColumn);
        LoggerUtil.logINFO("Select the Records by Time");
        if (Integer.parseInt(syscoLabUI.getText(lblSecondSR)) > Integer.parseInt(syscoLabUI.getText(lblFirstSR))) {
            syscoLabUI.waitTillElementLoaded(lblTimeColumn);
            syscoLabUI.click(lblTimeColumn);
            LoggerUtil.logINFO("Select the Records by Time");

        } else {

            LoggerUtil.logINFO("No need to Sort the Column");
        }
    }


    //Select the First Record
    public void selectFirstRecord() {

        syscoLabUI.waitTillElementLoaded(lblFirstSR);
        syscoLabUI.sleep(5);
        syscoLabUI.click(lblFirstSR);
        LoggerUtil.logINFO("Select the First Record");
    }
}
