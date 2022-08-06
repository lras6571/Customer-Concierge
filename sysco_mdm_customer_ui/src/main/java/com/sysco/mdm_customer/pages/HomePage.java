package com.sysco.mdm_customer.pages;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class HomePage {

    protected By btnSettings = By.xpath("//div[@class='setupGear']");
    //    protected By btnSetup = By.xpath("(//*[name()='path' and contains(@d,'M46.8 32.4')])[2]");
    protected By btnSetup = By.xpath("//header/div[2]/span[1]/div[2]/ul[1]/li[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]/div[1]/div[1]");
    protected By txtSearchSetup = By.xpath("//input[@placeholder='Search Setup']");
    protected By btnLoginMA = By.xpath("//input[@class='btn' and @name='login']");
    protected By iframe = By.xpath("//iframe[contains(@name,'vfFrame')]");
    protected By btnSettingsIcon = By.xpath("(//*[name()='svg'][@class='slds-icon'])[1]");
    protected By txtHome = By.xpath("//*[contains(@class, 'breadcrumbDetail')]");
    protected By drpDownUserName = By.xpath("(//*[contains(text(),'Thomas Flynn')])[2]");
    protected By txtStreetAccount = By.xpath("//div[contains(text(),'Account Create Wizard')]");
    //    protected By lblUserDropDown = By.xpath("(//li[@data-aura-class='uiAutocompleteOption forceSearchInputDesktopOption'])[2]");
    protected By lblUserDropDown = By.xpath("(//span[@title='#'])");
    //    protected By btnNotification = By.xpath("(//*[name()='svg'][@data-key='notification'])[1]");
    protected By lblNotification = By.xpath("(//h2[normalize-space()='Notifications'])[1]");
    protected By lblUserIcon = By.xpath("(//*[name()='svg'][@data-key='user'])[1]");
    protected By btnAppLauncher = By.xpath("//one-app-launcher-header/button[1]/div[1]");
    protected By txtSearchAppLauncher = By.xpath("//input[@placeholder='Search apps and items...']");
    protected By lblSyscoSales = By.xpath("(//b[contains(text(),'Sysco Sales')])[2]");
    protected By lblSyscoSalesProfile = By.xpath("//span[@title='Sysco Sales']");
    protected By btnNotification = By.xpath("//*[@id=\"oneHeader\"]/div[2]/span/div[2]/ul/li[7]/div[1]/button");


    //Click Settings Icon.
    public void clickSettingsIcon() {

        syscoLabUI.waitTillElementLoaded(btnSettings, 30);
        syscoLabUI.moveToAndClick(btnSettings);
        LoggerUtil.logINFO("Click Settings Icon");
    }

    //Click Setup
    public void clickSetupButton() {

        try {
            syscoLabUI.waitTillElementLoaded(btnSetup, 30);
        } catch (Exception e) {
            LoggerUtil.logINFO("Setup is not visible and yet to be loaded");
        }

        syscoLabUI.clickWithJavascript(btnSetup);

        //Switch to the new tab
        syscoLabUI.switchToTab(1);
        LoggerUtil.logINFO("Switch to the Next Tab in the Browser");

    }


    //Search for MA and Select the Name
    public void clickUserSearch(String marketingAssociate) {

        syscoLabUI.waitTillElementLoaded(txtHome, 25);
        syscoLabUI.moveToAndClick(txtSearchSetup);
        LoggerUtil.logINFO("Click in Search Box");
        syscoLabUI.sendKeys(txtSearchSetup, marketingAssociate);
        LoggerUtil.logINFO("Enter the MA Name as :" + marketingAssociate);
        syscoLabUI.waitTillElementLoaded(DriverSetUpUtil.replaceInLocator(lblUserDropDown, "#", marketingAssociate));
        LoggerUtil.logINFO("Wait Till User's Name displaying as the Suggestions in the Drop Down");
        syscoLabUI.clickWithJavascript(DriverSetUpUtil.replaceInLocator(lblUserDropDown, "#", marketingAssociate));
        LoggerUtil.logINFO("Select the Users Name");
    }


    //Login as MA and clear the Notifications if there are any
    public void clickMAUserLogin() {

        syscoLabUI.waitTillElementLoaded(iframe, 30);
        syscoLabUI.switchToFrame(iframe);
        LoggerUtil.logINFO("Switch To iFrame");
        syscoLabUI.waitTillElementLoaded(btnLoginMA, 20);
        syscoLabUI.clickWithJavascript(btnLoginMA);
        LoggerUtil.logINFO("Click Login button");

        try {
            syscoLabUI.waitTillElementLoaded(lblUserIcon, 35);
            syscoLabUI.clickWithJavascript(btnNotification);
            syscoLabUI.waitTillElementLoaded(lblNotification, 15);
            syscoLabUI.clickWithJavascript(btnNotification);
            LoggerUtil.logINFO("Notifications have been Cleared");
        } catch (Exception e) {

            LoggerUtil.logINFO("Notifications not have been Cleared");
        }


    }


    //Change the Sysco Profile from Header
    public void changeProfile() {

        syscoLabUI.waitTillElementLoaded(btnAppLauncher, 5);
        syscoLabUI.moveToAndClick(btnAppLauncher);
        LoggerUtil.logINFO("Click App Launcher");
        syscoLabUI.waitTillElementLoaded(txtSearchAppLauncher, 5);
        syscoLabUI.sendKeys(txtSearchAppLauncher, "Sysco Sales");
        LoggerUtil.logINFO("Enter Sysco Sales Key Word to search the Profile");
        syscoLabUI.waitTillElementLoaded(lblSyscoSales, 5);
        syscoLabUI.moveToAndClick(lblSyscoSales);
        LoggerUtil.logINFO("Select Sysco Sales Profile");
        syscoLabUI.waitTillElementLoaded(lblSyscoSalesProfile, 15);

    }
}
