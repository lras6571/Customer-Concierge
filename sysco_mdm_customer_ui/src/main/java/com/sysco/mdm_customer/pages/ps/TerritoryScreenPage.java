package com.sysco.mdm_customer.pages.ps;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class TerritoryScreenPage {

    protected By btnNextTerritoryScreenPage = By.xpath("//button[normalize-space()='Next']");



    //Click Next in Prospect Shop Flow Territory Screen Page
    public void clickNext() {

        syscoLabUI.sleep(5);
        syscoLabUI.waitTillElementLoaded(btnNextTerritoryScreenPage);
        syscoLabUI.clickWithJavascript(btnNextTerritoryScreenPage);
        LoggerUtil.logINFO("Click Next Button in the Territory Screen Page");
    }

}
