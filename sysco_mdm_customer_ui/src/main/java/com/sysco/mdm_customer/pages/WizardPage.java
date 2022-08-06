package com.sysco.mdm_customer.pages;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class WizardPage {


    //Customer Experience
    private final By tabChooseExperience = By.xpath("//span[text()='Choose Experience']/parent::a");
    private final By lnkProspectShop = By.xpath("//*[text()='Prospect Shop']//ancestor::a");
    private final By lnkProspect = By.xpath("//*[text()='Prospect']//ancestor::a");
    private By txtSearchAccount = By.xpath("//input[@name='searchAccountName']");
    private By btnAccountRole = By.xpath("//button[@name='searchType']");
    private final By txtOptionAccountType = By.xpath("//span[@title='#']");
    private By btnSearchAccount = By.xpath("//button[text()='Search']");
    private By btnRecordSelect = By.xpath("(//button[text()='Select'])[1]");
//    private By btnRecordSelect = By.xpath("//span[text()='Select Item 1']//parent::label");
    //Common
    private final By btnPrevious = By.xpath("//button[text()='Previous']");
    private final By btnNext = By.xpath("//button[text()='Next']");
    //Wizard customer type
    protected By btnYesBut = By.xpath("//div[text()='Yes, but']");
    protected By btnYes = By.xpath("//div[text()='Yes']");
    protected By btnNo = By.xpath("//div[text()='No']");

    //Select the path of Sysco Customer or Not
    public void identifyCustomer(boolean bExistingCustomer) {

        syscoLabUI.waitTillElementLoaded(btnYes);
        if (bExistingCustomer) {
            syscoLabUI.click(btnYes);
        } else {
            syscoLabUI.click(btnNo); //Yes, but option can also be clicked
        }

        syscoLabUI.sleep(2);
        LoggerUtil.logINFO("Click the Customer Choosing Path");
    }
    //Select Bill-to or Ship-to value
    public void searchBillToOrShipTo(String sBillToNameId,String accountRole){
        By txtAccountRole = DriverSetUpUtil.replaceInLocator(txtOptionAccountType, "#", accountRole);
        syscoLabUI.sendKeys(txtSearchAccount, sBillToNameId);
        syscoLabUI.clickWithJavascript(btnAccountRole);
        syscoLabUI.clickWithJavascript(txtAccountRole);
        syscoLabUI.clickWithJavascript(btnSearchAccount);
        syscoLabUI.waitTillElementLoaded(btnRecordSelect, 20);
        syscoLabUI.clickWithJavascript(btnRecordSelect);
        LoggerUtil.logINFO("Click the first record");
    }


    //Select Prospect or Prospect Shop
    public void chooseExperience(String customerProceed) {
        syscoLabUI.waitTillElementLoaded(lnkProspectShop);
        switch (customerProceed) {
            case "Prospect Shop":
                syscoLabUI.click(lnkProspectShop);
                break;
            case "Prospect":
                syscoLabUI.click(lnkProspect);
                break;
        }
        syscoLabUI.waitTillElementLoaded(btnNext);
        syscoLabUI.sleep(2);
        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Click the CProspect or Prospect Shop Path ");
    }

    public void chooseShipTo(boolean bProspectAvailable) {
        syscoLabUI.waitTillElementLoaded(btnYes);
        if (bProspectAvailable) {
            syscoLabUI.click(btnYes);
            LoggerUtil.logINFO("Click Yes in Is this customer currently doing business with Sysco, at this site? ");

        } else {
            syscoLabUI.click(btnNo);
        }
    }
}