package com.sysco.mdm_customer.pages.ps;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class ProspectSearchPage {


    protected By txtProspectAccount = By.xpath("//input[@placeholder='Enter search criteria']");
    protected By btnSearch = By.xpath("(//button[normalize-space()='Search'])[1]");
    protected By firstRecord = By.xpath("(//button[@title='Click to select account'][normalize-space()='Select'])[1]");


    //Search Existing Prospect Account
    public void searchProspect(String prospectName) {

        syscoLabUI.waitTillElementLoaded(txtProspectAccount, 15);
        syscoLabUI.sendKeys(txtProspectAccount, prospectName);
        LoggerUtil.logINFO("Enter a Prospect Name in the search Box");
    }


    //Search Existing Prospect Account
    public void clickSearch() {

        syscoLabUI.waitTillElementLoaded(btnSearch, 15);
        syscoLabUI.clickWithJavascript(btnSearch);
        LoggerUtil.logINFO("Click Search Button");
    }

    //Select the First Record
    public void selectFirstRecord() {

        syscoLabUI.waitTillElementLoaded(firstRecord, 15);
        syscoLabUI.clickWithJavascript(firstRecord);
        LoggerUtil.logINFO("Select the First Record");
    }
}
