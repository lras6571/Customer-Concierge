package com.sysco.mdm_customer.pages.lead;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class LeadRecordPage {

    protected By btnStartLeadConversion = By.xpath("//button[text()='Convert']");
    protected By btnClearAll = By.xpath("//a[text()='Clear All']");
    protected By txtRecordOwner = By.xpath("(//label[text()='Account Owner']//following::input[1])[1]");
    protected By btnCloseAccountOwner1 = By.xpath("(//*[@data-key='close'])[2]");
    protected By btnCloseAccountOwner = By.xpath("(//*[name()='svg'][@class='slds-icon slds-icon-text-default slds-icon_x-small'])[8]");
    protected By txtAccountOwner = By.xpath("(//input[@placeholder='Search Salesforce'])[1]");
    protected By txtAccountOwner1 = By.xpath("//input[@class='slds-input slds-combobox__input has-custom-height slds-combobox__input-value has-custom-error']");
    protected By lblAccountOwner = By.xpath("//span[@data-recordid='0050y00000D7wRpAAJ']");
    protected By txtOpCo = By.xpath("//input[@placeholder='Search By OpCo Name']");
    protected By lblOpCo = By.xpath("//span[@data-recordid='a0tE0000000H6YTIA0']");
    protected By drpDwnAccountName = By.xpath("//button[@type='button'and @data-value='--None--']");
    protected By lblAccountName = By.xpath("(//*[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain'])[1]");
    protected By txtTerritory = By.xpath("//label[text()='Territory']/following::input[1]");
    protected By lblTerritory = By.xpath("(//ul[@role='presentation'])[8]");
    protected By btnTaskReminderTerritory = By.xpath("//span[@title='Task Reminder']");
    protected By chkBoxReminder = By.xpath("//span[text()='Reminder']/parent::label/preceding::input[1]");
    protected By btnFinishLeadConversion = By.xpath("//footer//button[text()='Convert']");
    protected By lblAccountID = By.xpath("(//span[@class='test-id__field-label'])[61]");
    protected By chkBoxReminder2 = By.xpath("(//span[@class='slds-checkbox_faux'])[4]");


    //Click Convert Button
    public void startLeadConversion(){
        syscoLabUI.waitTillElementLoaded(btnStartLeadConversion,25);
        if(syscoLabUI.isDisplayed(btnClearAll))
        {
            syscoLabUI.click(btnClearAll);
        }
        syscoLabUI.click(btnStartLeadConversion);
        LoggerUtil.logINFO("Click Convert Button");
        syscoLabUI.waitTillElementLoaded(txtRecordOwner);
        syscoLabUI.sleep(5);
    }


    //Enter Name and OpCo details to the Lead Convert Window
    public void enterRecordOwner(String strOpCoID,String strOwner){

        syscoLabUI.waitTillElementLoaded(btnCloseAccountOwner,25);
        syscoLabUI.click(btnCloseAccountOwner);
        LoggerUtil.logINFO("Remove the DSM Account Name");
        syscoLabUI.waitTillElementLoaded(txtAccountOwner);
        syscoLabUI.click(txtAccountOwner);
        syscoLabUI.sendKeys(txtAccountOwner1,strOwner);
        syscoLabUI.waitTillElementLoaded(lblAccountOwner);
        syscoLabUI.click(lblAccountOwner);
        LoggerUtil.logINFO("Enter the Account Owner Name");
        syscoLabUI.waitTillElementLoaded(txtOpCo);
        syscoLabUI.sendKeys(txtOpCo,strOpCoID);
        syscoLabUI.waitTillElementLoaded(lblOpCo);
        syscoLabUI.click(lblOpCo);
        LoggerUtil.logINFO("Enter the OpCo Name");
    }


    //Enter the Account Name
    public void setAccountName(){

        syscoLabUI.scrollDown(300);
        syscoLabUI.scrollToElement(drpDwnAccountName);
        syscoLabUI.clickWithJavascript(drpDwnAccountName);
        LoggerUtil.logINFO("Enter the Account Name");
        syscoLabUI.waitTillElementLoaded(lblAccountName);
        syscoLabUI.clickWithJavascript(lblAccountName);
    }


    //Enter the Territory Name
    public void setTerritory(String strTerritory){

        syscoLabUI.sendKeys(txtTerritory,strTerritory);
        syscoLabUI.waitTillElementLoaded(lblTerritory);
        syscoLabUI.sendKeys(txtTerritory, Keys.TAB);
        LoggerUtil.logINFO("Enter the Territory Name");
    }

    //Tick Reminder Check Box
    public void setReminder(boolean strReminder){

        syscoLabUI.waitTillElementLoaded(btnTaskReminderTerritory);
        syscoLabUI.scrollToElement(btnTaskReminderTerritory);
        LoggerUtil.logINFO("Scroll Down to Task Reminder");
        syscoLabUI.click(btnTaskReminderTerritory);
        LoggerUtil.logINFO("Click the Task Reminder");
        if(!strReminder){
            syscoLabUI.scrollToElement(chkBoxReminder2);
            syscoLabUI.waitTillElementLoaded(chkBoxReminder2);
            syscoLabUI.click(chkBoxReminder2);
            LoggerUtil.logINFO("Tick Reminder Check Box");
        }
    }

    //Click Convert Button
    public void finishLeadConversion(){

        syscoLabUI.scrollToElement(btnFinishLeadConversion);
        syscoLabUI.clickWithJavascript(btnFinishLeadConversion);
        LoggerUtil.logINFO("Click Convert Button");
        syscoLabUI.waitTillElementLoaded(lblAccountID,45);
        LoggerUtil.logINFO(syscoLabUI.getCurrentURL());
    }

}
