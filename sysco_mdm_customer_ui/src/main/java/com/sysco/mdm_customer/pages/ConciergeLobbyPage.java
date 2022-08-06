package com.sysco.mdm_customer.pages;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class ConciergeLobbyPage {

    protected By btnStreetAccount = By.xpath("//div[text()='Account Create Wizard']//following::button[text()='Start Wizard'][1]");
    protected By btnCADDAccount = By.xpath("//div[text()='Account Create Wizard']//following::button[text()='Start Wizard'][2]");
    protected By btnLeadAccount = By.xpath("//div[text()='Lead']//following::button[text()='Create Lead']");
    protected By txtLeadText = By.xpath("//div[contains(text(),'Select this option to search for an existing lead')]");
    protected By btnLeadCreation = By.xpath("//button[contains(text(),'Create Lead')]");
    protected By btnAppLauncher = By.xpath("//div[@aria-label='App']//button[@type='button']");
    protected By txtSearchApps = By.xpath("//input[@placeholder='Search apps and items...']");
    protected By lblCustomerConcierge = By.xpath("//a[@data-label='Customer Concierge']");
    protected By btnTabClose = By.xpath("(//button[@tabindex='0'])[2]");
    protected By btnErrorMessage = By.xpath("(//button[@title='Close this window'])[1]");
    protected By btnErrorMessageIframe = By.xpath("//span[@class='oneIframeMessageManager']");
    protected By btnCFEALead = By.xpath("//button[contains(text(),'Create Lead')]");
    protected By btnCFEAAccountCreate = By.xpath("//button[contains(text(),'Start Wizard')]");

    //Click Lead Icon
    public void clickLeadCreationIcon() {

        syscoLabUI.waitTillElementLoaded(txtLeadText, 25);
        syscoLabUI.scrollToElement(txtLeadText);
        syscoLabUI.clickWithJavascript(txtLeadText);
        LoggerUtil.logINFO("Select Text Lead Icon");
        syscoLabUI.scrollDown(200);
        syscoLabUI.clickWithJavascript(btnLeadAccount);
        LoggerUtil.logINFO("Click Lead Icon");

    }

    //Click Street Icon
    public void clickStreetAccountIcon() {

        syscoLabUI.scrollDown(200);
        syscoLabUI.waitTillElementLoaded(btnStreetAccount);
        syscoLabUI.clickWithJavascript(btnStreetAccount);
        LoggerUtil.logINFO("Click Street Account Creation Icon");

    }


    //Click CADD Icon
    public void clickCADDAccountIcon() {


        try {
            syscoLabUI.waitTillElementLoaded(btnTabClose, 12);
            while (syscoLabUI.isDisplayed(btnTabClose)) {
                syscoLabUI.clickWithJavascript(btnTabClose);
                LoggerUtil.logINFO("Remove Old Tabs");
            }

            syscoLabUI.waitTillElementLoaded(btnAppLauncher);
            syscoLabUI.clickWithJavascript(btnAppLauncher);
            syscoLabUI.sendKeys(txtSearchApps, "Customer Concierge");
            syscoLabUI.waitTillElementLoaded(lblCustomerConcierge, 25);
            syscoLabUI.clickWithJavascript(lblCustomerConcierge);
            if (syscoLabUI.isDisplayed(btnErrorMessage)) {
                syscoLabUI.switchToFrame(btnErrorMessageIframe);
                syscoLabUI.clickWithJavascript(btnErrorMessage);
            }


        } catch (Exception e) {

            if (syscoLabUI.isDisplayed(btnErrorMessage)) {
                syscoLabUI.switchToFrame(btnErrorMessageIframe);
                syscoLabUI.clickWithJavascript(btnErrorMessage);
            }
            syscoLabUI.waitTillElementLoaded(btnCADDAccount, 5);
            syscoLabUI.waitTillElementLoaded(btnCADDAccount);
            syscoLabUI.scrollDown(200);
            syscoLabUI.clickWithJavascript(btnCADDAccount);
            LoggerUtil.logINFO("Click CADD Account Creation Icon");

        }


        try {
            syscoLabUI.waitTillElementLoaded(btnCADDAccount, 5);
            syscoLabUI.waitTillElementLoaded(btnCADDAccount);
            syscoLabUI.scrollDown(200);
            syscoLabUI.clickWithJavascript(btnCADDAccount);
            LoggerUtil.logINFO("Click CADD Account Creation Icon--");
            }
        catch (Exception e) {

        }

    }


    //Click CFEA Lead Icon
    public void clickCFEALeadCreationIcon() {

        syscoLabUI.waitTillElementLoaded(btnCFEALead, 25);
        syscoLabUI.scrollToElement(btnCFEALead);
        syscoLabUI.clickWithJavascript(btnCFEALead);
        LoggerUtil.logINFO("Click CFEA Lead Icon");

    }


    //Click CFEA Account Create
    public void clickCFEAAccountIcon() {

        syscoLabUI.waitTillElementLoaded(btnCFEAAccountCreate,20);
        syscoLabUI.scrollToElement(btnCFEAAccountCreate);
        syscoLabUI.clickWithJavascript(btnCFEAAccountCreate);
        LoggerUtil.logINFO("Click CFEA Account Create Icon");

    }

}
