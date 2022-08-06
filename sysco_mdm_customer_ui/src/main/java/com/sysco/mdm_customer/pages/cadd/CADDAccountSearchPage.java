package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDAccountSearchPage {

    protected By txtAccountName = By.xpath("//input[@name='searchAccountName']");
    protected By btnSearchAccount = By.xpath("//button[text()='Search']");
    protected By rdBtnRecord = By.xpath("(//button[@name='select_account'])[1]");
//    protected By rdBtnRecord = By.xpath("(//button[@class='slds-button slds-button_text-destructive'])[1]");
    protected By txtFirstRecord = By.xpath("//tbody/tr[1]/td[1]");
    protected By imgLoadingSpinner = By.xpath("//img[@alt='Loading']");


    //Search for an Existing Account
    public void searchAccountToActivate(String existingAccountName) {

        syscoLabUI.waitTillElementLoaded(txtAccountName, 20);
        syscoLabUI.sendKeys(txtAccountName, existingAccountName);
        syscoLabUI.click(btnSearchAccount);
        syscoLabUI.waitTillElementDisappear(imgLoadingSpinner);
    }


    //Select an Existing Account from the record
    public void isRecordMatch(String existingAccountName) {

        syscoLabUI.waitTillElementLoaded(txtFirstRecord);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(syscoLabUI.getText(txtFirstRecord), existingAccountName);
        LoggerUtil.logINFO("Assertion Success");
    }


    //Click the First Record
    public void selectRecord() {

        syscoLabUI.waitTillElementLoaded(rdBtnRecord);
        syscoLabUI.moveToAndClick(rdBtnRecord);
        LoggerUtil.logINFO("Click the first record");
    }
}
