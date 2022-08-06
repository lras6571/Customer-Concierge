package com.sysco.mdm_customer.pages;


import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class NavigateToAccountsProspectsPage {
    private final By lnkMainAccountsProspect = By.xpath("//a[@title='Accounts/Prospects']");
    private final By lnkMore = By.xpath("//span[contains(text(),'More')]//parent::a");
    private final By lnkAccountProspect = By.xpath("//span[text()='Accounts/Prospects']//ancestor::a[@role='menuitem']");
    private final By lnkAccountProspectInAppLauncher = By.xpath("//p[text()='Accounts/Prospects']//ancestor::a");
    private final By lblAccountProspect = By.xpath("//h2[text()='Accounts/Prospects']");
    //App Launcher
    private final By btnAppLauncher = By.xpath("//div[@role='navigation']//button");
    private final By btnViewAllOptions = By.xpath("//button[text()='View All']");
    private final By btnAppLauncherItemList = By.xpath("//span[@title='All Items']//ancestor::button");
    private final By btnClosePopup = By.xpath("//button[@title='Close this window']");
    //Active Account
    private final By lnkAccountId = By.xpath("//span[text()='#']//ancestor::tr//th//a");
    private final By txtAccountStatus = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[5]");
    private final By txtStatus = By.xpath("//lightning-formatted-text[text()='#']");
    private final By btnAccountDetails = By.xpath("//a[@data-tab-value='detailTab']");
    private final By btnListView = By.xpath("//button[@title='Select a List View']");
    private final By lnkActiveAccountList = By.xpath("(//li[(@role='presentation')]//a[not(contains(@id,'virtualAutoCompleteMenuOption'))]//span[text()='#'])[1]");
    private final By lnkActiveAccount = By.xpath("//tbody/tr[1]//th//a");
    protected By lnkMainLeads = By.xpath("//a[@title='Leads']");
    protected By lblTableColumnName = By.xpath("//th[@title='Name']//a[@class='toggle slds-th__action slds-text-link--reset ']");
    protected By lnkLeadsInAppLauncher = By.xpath("//p[text()='Leads']//ancestor::a");


    /*
     * Navigate to Accounts/Prospects
     * */
    public void selectAccountsProspectTab() {
        try {
            waitForSomeTime(5);
            LoggerUtil.logINFO("Selecting Customer Concierge menu");
            syscoLabUI.waitTillElementLoaded(btnAppLauncher);
            if (syscoLabUI.isDisplayed(lnkMainAccountsProspect)) {
                syscoLabUI.sleep(3);
                syscoLabUI.clickWithJavascript(lnkMainAccountsProspect);
            } else {
                if (syscoLabUI.isDisplayed(lnkMore)) {
                    clickVisibleElement(lnkMore);
                    new WebDriverWait(SyscoLabUI.driver, 10).until(ExpectedConditions.attributeToBe(lnkMore, "aria-expanded", "true"));
                }
                if (syscoLabUI.isDisplayed(lnkAccountProspect)) {
                    syscoLabUI.clickWithJavascript(lnkAccountProspect);
                } else {
                    clickVisibleElement(lnkMore);
                    openAppLauncher();
                    syscoLabUI.scrollBottom();
                    syscoLabUI.waitTillElementLoaded(lnkAccountProspectInAppLauncher);
                    syscoLabUI.clickWithJavascript(lnkAccountProspectInAppLauncher);
                }
            }
            syscoLabUI.waitTillElementLoaded(lblAccountProspect);
            LoggerUtil.logINFO("Concierge lobby loaded");
        } catch (Exception e) {
            LoggerUtil.logINFO(e.getMessage());
        }
    }

    public void waitForSomeTime(int timeInSeconds) {
        syscoLabUI.sleep(timeInSeconds);
    }

    public void clickVisibleElement(By xpath) {
        syscoLabUI.clickWithJavascript(syscoLabUI.findVisibleElements(xpath).get(0));
    }

    public void openAppLauncher() {
        syscoLabUI.clickWithJavascript(btnAppLauncher);
        syscoLabUI.waitTillElementLoaded(btnViewAllOptions);
        syscoLabUI.clickWithJavascript(btnViewAllOptions);
        waitForSomeTime(5);
        if (!syscoLabUI.isClickable(btnAppLauncherItemList)) {
            closeAppLauncher();
            syscoLabUI.clickWithJavascript(btnAppLauncher);
            syscoLabUI.waitTillElementLoaded(btnViewAllOptions);
            syscoLabUI.clickWithJavascript(btnViewAllOptions);
            new WebDriverWait(SyscoLabUI.driver, 15).until(ExpectedConditions.elementToBeClickable(btnAppLauncherItemList));
        }
        LoggerUtil.logINFO("App launcher opened");
        if (!Boolean.TRUE.equals(Boolean.valueOf(syscoLabUI.getAttribute(btnAppLauncherItemList, "aria-expanded")))) {
            syscoLabUI.click(btnAppLauncherItemList);
        }
    }

    public void closeAppLauncher() {
        if (syscoLabUI.isDisplayed(btnClosePopup)) {
            LoggerUtil.logINFO("Closing App Launcher window");
            syscoLabUI.clickWithJavascript(btnClosePopup);
            syscoLabUI.sleep(1);
        }
    }

    /*
     * Select the Active Account
     * */
    public void selectActiveAccount(String listFilter) {

        syscoLabUI.waitTillElementLoaded(btnListView, 15);
        syscoLabUI.clickWithJavascript(btnListView);
        syscoLabUI.waitTillElementLoaded(DriverSetUpUtil.replaceInLocator(lnkActiveAccountList, "#", listFilter));
        syscoLabUI.clickWithJavascript(DriverSetUpUtil.replaceInLocator(lnkActiveAccountList, "#", listFilter));
        syscoLabUI.sleep(5);
        syscoLabUI.waitTillElementLoaded(lnkActiveAccount, 15);
        syscoLabUI.clickWithJavascript(lnkActiveAccount);
        syscoLabUI.waitTillElementLoaded(btnAccountDetails, 15);
        syscoLabUI.clickWithJavascript(btnAccountDetails);
        LoggerUtil.logINFO("Click the Account Details");
        LoggerUtil.logINFO("Ship to URL is : " + syscoLabUI.getCurrentURL());
    }


    /*
     * Verify the Active Account Status
     * */
    public boolean isAccountStatusActive(String activeAccountName) {
        syscoLabUI.waitTillElementDisappear(DriverSetUpUtil.replaceInLocator(txtStatus, "#", activeAccountName));
        return syscoLabUI.isDisplayed(txtAccountStatus);
    }


    //Click the Lead Tab
    public void selectLeads() {

        syscoLabUI.waitTillElementLoaded(lnkMainLeads, 15);
        syscoLabUI.clickWithJavascript(lnkMainLeads);
        LoggerUtil.logINFO("Click the My Lead Lists");
        syscoLabUI.waitTillElementLoaded(lblTableColumnName);
    }

}