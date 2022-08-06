package com.sysco.mdm_customer.pages.cfea;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEASearchScreenPage {

    protected By txtLeadSearch = By.xpath("//input[@placeholder='Enter search criteria']");
    protected By btnSearchLead = By.xpath("//button[normalize-space()='Search']");
    protected By btnFirstRecord = By.xpath("(//button[@title='Click to select account'][normalize-space()='Select'])[1]");
    protected By lblSearchIcon = By.xpath("//input[@placeholder='--Select One--']");
    protected By btnNext = By.xpath("//button[normalize-space()='Next']");
    protected By drpDownTerritory = By.xpath("//input[@placeholder='--Select One--']");
    protected By lblTerritoryOptionIncorrect = By.xpath("(//span[contains(text(),'115_Mario_Arzapalo - 115T0022')])[1]");
    protected By lblTerritoryOption = By.xpath("(//span[contains(text(),'T0022 - 115T0022')])[1]");


    //Fill the Lead Name and click Search
    public void enterCreatedLeadName(String strLeadName) {

        syscoLabUI.waitTillElementLoaded(txtLeadSearch);
        syscoLabUI.sendKeys(txtLeadSearch, strLeadName);
        LoggerUtil.logINFO("Enter the Lead Name");
        syscoLabUI.clickWithJavascript(btnSearchLead);
        LoggerUtil.logINFO("Click the Search Button");
    }

    //Select the First Record from the Search Result
    public void selectLead() {

        syscoLabUI.waitTillElementLoaded(btnFirstRecord);
        syscoLabUI.clickWithJavascript(btnFirstRecord);
        LoggerUtil.logINFO("Select the First Record");

    }


    //Select the First Record from the Territory
    public void selectFreshPointTerritory() {

        syscoLabUI.waitTillElementLoaded(drpDownTerritory);
        syscoLabUI.clickWithJavascript(drpDownTerritory);
        LoggerUtil.logINFO("Click the Territory Drop Down");
        syscoLabUI.waitTillElementLoaded(lblTerritoryOption);
        syscoLabUI.clickWithJavascript(lblTerritoryOption);
        LoggerUtil.logINFO("Select the Territory");
        syscoLabUI.sleep(5);
        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Click Next Button in Select Territory");

    }


    //Click Next for Select Territory - Asian Foods
    public void clickNext() {

        syscoLabUI.waitTillElementLoaded(lblSearchIcon,5);
        syscoLabUI.sleep(5);
        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Click Next Button in the Select Territory");
    }

}
