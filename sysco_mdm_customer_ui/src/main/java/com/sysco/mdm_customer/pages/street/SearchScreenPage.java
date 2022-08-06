package com.sysco.mdm_customer.pages.street;


import com.sysco.mdm_customer.data.ActivateProspectData;
import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class SearchScreenPage {

    private final By txtScreen = By.xpath("//div[contains(text(),\"#\")]");
    private final By txtActiveProspect = By.xpath("//div[contains(@class, 'slds-text-heading_large') and text()='Activate Prospect']");
    private final By txtAccountName = By.xpath("//input[@name='searchAccountName']");
    private final By btnSearchAccount = By.xpath("//button[text()='Search']");
    private final By drpDwnAccountType = By.xpath("//*[contains(@name,'accountType')]");
    private final By txtOptionAccountType = By.xpath("//span[@title='#']");
    private final By btnActivateProspect = By.xpath("(//button[@name='select_account'])[1]");
   // private final By btnActivateProspect = By.xpath("//span[text()='Select Item 1']//parent::label");
    private final By txtTableName = By.xpath("//span[@title='Name']");
    protected By txtConceptIDSearch = By.xpath("//input[@name=\"searchAccountName\"]");
    protected By btnConceptSearch = By.xpath("//button[normalize-space()='Search']");
    protected By btnConceptRecordItem = By.xpath("(//button[contains(text(),'Select')])[1]");
    protected By lblConceptSearch = By.xpath("//div[@class='slds-text-heading_medium slds-m-left_small']");

    /*
     * Verify the Active Prospect Flow display or not
     * */
    public boolean isActivateProspectHomeScreenDisplayed() {
        syscoLabUI.waitTillElementDisappear(txtActiveProspect);
        return syscoLabUI.isDisplayed(DriverSetUpUtil.replaceInLocator(txtScreen, "#", ActivateProspectData.ACTIVATE_PROSPECT_SCREEN_01)) && syscoLabUI.isDisplayed(DriverSetUpUtil.replaceInLocator(txtScreen, "#", ActivateProspectData.ACTIVATE_PROSPECT_SCREEN_02));
    }

    /*
     * Verify the Active Prospect Flow Search Screen Table Column Verification
     * */
    public boolean isSearchScreenTableColumnDisplayed() {
        syscoLabUI.waitTillElementDisappear(txtTableName);
        return syscoLabUI.isDisplayed(txtTableName);
    }

    /*
     * Enter the DSM Approve Prospect and Account Type (TRS)
     * */
    public void searchAccountToActivate(String accountName, String accountType) {
        By txtAccountType = DriverSetUpUtil.replaceInLocator(txtOptionAccountType, "#", accountType);
        syscoLabUI.waitTillElementLoaded(txtAccountName, 20);
        syscoLabUI.sendKeys(txtAccountName, accountName);
        syscoLabUI.clickWithJavascript(drpDwnAccountType);
        syscoLabUI.clickWithJavascript(txtAccountType);
        syscoLabUI.sleep(1);
        syscoLabUI.clickWithJavascript(btnSearchAccount);
        syscoLabUI.sleep(2);
        syscoLabUI.clickWithJavascript(btnActivateProspect);
        syscoLabUI.sleep(10);

    }

    public boolean isAccountNameStreetAddressCityFieldDisplayed() {

        return isElementDisplayed(txtAccountName);
    }
    public boolean isAccountTypeFieldDisplayed() {


        return isElementDisplayed(drpDwnAccountType);
    }
    public boolean isSearchButtonDisplayed() {


        return isElementDisplayed(btnSearchAccount);
    }
    public boolean isElementDisplayed(By element) {

        syscoLabUI.sleep(3);
        return syscoLabUI.waitTillElementLoaded(element).isDisplayed();
    }
}