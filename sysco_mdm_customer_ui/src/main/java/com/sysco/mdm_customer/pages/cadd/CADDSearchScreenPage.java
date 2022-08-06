package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDSearchScreenPage {

    protected By txtConceptIDSearch = By.xpath("//input[@name=\"searchAccountName\"]");
    protected By btnConceptSearch = By.xpath("//button[normalize-space()='Search']");
    protected By rdBtnConceptRecordItem = By.xpath("//span[@class='slds-radio_faux']");
    protected By lblConceptSearch = By.xpath("//div[@class='slds-text-heading_medium slds-m-left_small']");
    protected By txtTerritoryAssignment = By.xpath("//div[contains(text(),'Territory Assignment')]");
    protected By drpDownAccountOwner = By.xpath("(//span[@role='option'])[1]");
    protected By txtAccountOwner = By.xpath("//input[@class='slds-input slds-combobox__input has-custom-height slds-combobox__input-value']");
    protected By btnNextTerritoryAssignment = By.xpath("//button[contains(text(),'Next')]");
    protected By txtTerritoryErrorMessage = By.xpath("//div[contains(text(),'No territories found, contact your sales administr')]");

    //Search CADD Concept ID in Search Wizard
    public void searchConceptID(String conceptID) {

        syscoLabUI.waitTillElementLoaded(lblConceptSearch, 10);
        LoggerUtil.logINFO("Wait till the Concept Search box appears");
        syscoLabUI.clickWithJavascript(txtConceptIDSearch);
        syscoLabUI.sendKeys(txtConceptIDSearch, conceptID);
        LoggerUtil.logINFO("Enter the Concept ID in the Search Box");
        syscoLabUI.waitTillElementLoaded(btnConceptSearch);
        syscoLabUI.sleep(2);
        syscoLabUI.clickWithJavascript(btnConceptSearch);
        syscoLabUI.waitTillElementLoaded(rdBtnConceptRecordItem);
        syscoLabUI.click(rdBtnConceptRecordItem);
        LoggerUtil.logINFO("Select a Record from the table - Radio Button");
    }

    //Select the Site and the MA from the Search Wizard
    public void searchTerritory(String site, String marketingAssociate) {

        syscoLabUI.waitTillElementLoaded(txtTerritoryErrorMessage);
        while (syscoLabUI.isDisplayed(txtTerritoryErrorMessage)) {

            syscoLabUI.waitTillElementLoaded(txtTerritoryAssignment, 10);
            LoggerUtil.logINFO("Wait till the Territory Assignment Label Appears");
            syscoLabUI.clickWithJavascript(txtAccountOwner);
            syscoLabUI.sendKeys(txtAccountOwner, marketingAssociate);
            syscoLabUI.sleep(2);
            LoggerUtil.logINFO("Enter the Marketing Associate Name");
            syscoLabUI.waitTillElementLoaded(drpDownAccountOwner, 2);
            syscoLabUI.clickWithJavascript(drpDownAccountOwner);
            LoggerUtil.logINFO("Select the MA");
            syscoLabUI.sleep(2);
        }

        syscoLabUI.waitTillElementLoaded(btnNextTerritoryAssignment);
        syscoLabUI.clickWithJavascript(btnNextTerritoryAssignment);
        LoggerUtil.logINFO("Click Next button in Territory Assignment Screen");

    }


    //Select the Site and the MA from the Search Wizard
    public void searchTrsMaTerritory(String site, String marketingAssociate) {

        syscoLabUI.waitTillElementLoaded(txtTerritoryAssignment, 10);
        LoggerUtil.logINFO("Wait till the Territory Assignment Label Appears");
        syscoLabUI.clickWithJavascript(txtAccountOwner);
        syscoLabUI.sendKeys(txtAccountOwner, marketingAssociate);
        syscoLabUI.sleep(2);
        LoggerUtil.logINFO("Enter the Marketing Associate Name");
        syscoLabUI.waitTillElementLoaded(drpDownAccountOwner, 2);
        syscoLabUI.clickWithJavascript(drpDownAccountOwner);
        LoggerUtil.logINFO("Select the MA");
        syscoLabUI.sleep(2);

        syscoLabUI.waitTillElementLoaded(btnNextTerritoryAssignment);
        syscoLabUI.clickWithJavascript(btnNextTerritoryAssignment);
        LoggerUtil.logINFO("Click Next button in Territory Assignment Screen");

    }
}
