package com.sysco.mdm_customer.pages.lead;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class LeadsHomePage {


    protected By drpDwnViewList = By.xpath("(//span[@data-aura-class='uiOutputText'])[1]");
    protected By txtSearchDropDown = By.xpath("//input[@data-aura-class='uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']");
    protected By lblSearchResult = By.xpath("//li[1]//a[1]//span[1]//mark[1]");
    protected By lblFirstRecord = By.xpath("(//a[@data-refid='recordId'])[1]");
    protected By lblLastModifiedName = By.xpath("//thead/tr[1]/th[11]/div[1]/a[1]");



    //Select the My Leads from Leads Tab
    public void viewList(String strView) {

        syscoLabUI.waitTillElementLoaded(drpDwnViewList);
        syscoLabUI.clickWithJavascript(drpDwnViewList);
        syscoLabUI.sendKeys(txtSearchDropDown,strView);
        LoggerUtil.logINFO("Enter My Lead Word in the Search Box");
        syscoLabUI.waitTillElementLoaded(lblSearchResult);
        syscoLabUI.sendKeys(txtSearchDropDown, Keys.DOWN);
        syscoLabUI.sendKeys(txtSearchDropDown, Keys.ENTER);
        LoggerUtil.logINFO("Click Enter and Select the My Leads");
    }


    //Sort the Record based on the Last Modified Date
    public void sortLeadList(){

        syscoLabUI.waitTillElementLoaded(lblFirstRecord);
        syscoLabUI.clickWithJavascript(lblLastModifiedName);
        LoggerUtil.logINFO("Click Last Modified and Sort the Order");
        syscoLabUI.sleep(2);
    }

    //Select the Latest Record
    public void selectFirstRecord(){

        syscoLabUI.waitTillElementLoaded(lblFirstRecord);
        syscoLabUI.clickWithJavascript(lblFirstRecord);
        LoggerUtil.logINFO("Click First Record");
    }

}
