package com.sysco.mdm_customer.pages.street;


import com.sysco.mdm_customer.pages.LoginPage;
import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class AccountSearchPage extends LoginPage {


    private final By btnNext = By.xpath("//button[normalize-space()='Next']");
    private final By imgSmallWait = By.xpath("//img[@class='waitingImage']");
    private final By btnNewLocation = By.xpath("//button[normalize-space()='Create New Location']");
    private final By lblSearchedAccountName = By.xpath("//table[@class ='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols']/tbody");
//    private final By btnAddSecondaryShipTo = By.xpath("//th[@data-label='Name']//a[text()='#']//ancestor::th[@data-label='Name']//following-sibling::td/..//label");
    private final By btnAddSecondaryShipTo = By.xpath("(//button[text()='Select'])[1]");
   private By btnRecordSelect = By.xpath("(//button[@name='select_account'])[1]");
    private By lblExistingLocation = By.xpath("//div[text()='Select from existing location(s) below']");
    private final By lnlAccountInfo = By.xpath("//span[normalize-space()='Account Info']");


     //Navigate To the Next Page
    public void navigateToNextTab() {

        try {
            syscoLabUI.waitTillElementDisappear(imgSmallWait);
            syscoLabUI.clickWithJavascript(btnNext);
            LoggerUtil.logINFO("Click the Next Button");
            syscoLabUI.waitTillElementDisappeared(imgSmallWait, 18);
        }
        catch(Exception e) {
            LoggerUtil.logINFO("Unable to Click the Next Button");
        }
    }

    /*
     * Already Active Account Search
     * */
    public boolean isAccountSearched(String searchedAccountName) {
        syscoLabUI.waitTillElementLoaded(lblSearchedAccountName);
        return syscoLabUI.getText(lblSearchedAccountName).contains(searchedAccountName);
    }

    /*
     * Select Secondary Location Account
     * */
    public void selectSecondaryLocationAddShipTo(String primaryAccountName) {
        syscoLabUI.waitTillElementLoaded(lblExistingLocation);
        syscoLabUI.waitTillElementLoaded(btnRecordSelect, 20);
        syscoLabUI.clickWithJavascript(btnRecordSelect);
        LoggerUtil.logINFO("Click the first record");
        syscoLabUI.waitTillElementLoaded(lnlAccountInfo);

//        syscoLabUI.clickWithJavascript(DriverSetUpUtil.replaceInLocator(btnAddSecondaryShipTo, "#", primaryAccountName));
    }

    /*
     * Select New Location Button
     * */
    public void selectNewLocation() {
        syscoLabUI.waitTillElementLoaded(btnNewLocation);
        syscoLabUI.clickWithJavascript(btnNewLocation);
    }
}