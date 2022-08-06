package com.sysco.mdm_customer.pages.sr;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class SupportRequestPage {

   // protected By tabRelated = By.xpath("//a[text()='Related']");
   protected By tabRelated = By.xpath("//h2[text()='Related List Quick Links']");
    protected By lnkSupportRequestsList = By.xpath("//span[@title='Support Requests']//parent::a");
    protected By lnkScrollBar = By.xpath("//flexipage-component2[@data-component-id='customerCredit']");
    protected By lnkFirstSupportRequest = By.xpath("//table[@role='grid']//tbody//span[text()='New']//ancestor::tr[1]//th//a");
    protected By lblSRAssignedToMA = By.xpath("(//span[@class='flex-wrap-ie11 owner-name slds-grow'])[3]");
    //    protected By lblSRAssignedToMA = By.xpath("(//span[contains(text(),'MA_NAME')])[5]");
 //   protected By lblSRAssignedToTeam = By.xpath("//span[text()='Support Request Owner']//following::div[1]//span[text()='#']");
    protected By lblSRAssignedToTeam = By.xpath("(//a/..//span[contains(text(),'Support Requests') and (@class='slds-assistive-text')])[2]");

    public void viewSupportRequests() {
        syscoLabUI.sleep(20);
        Actions actions = new Actions(syscoLabUI.driver);
        if (syscoLabUI.isDisplayed(tabRelated)) {
            //syscoLabUI.click(tabRelated);
//            while (!syscoLabUI.isDisplayed(lnkSupportRequestsList)) {
//                actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//                syscoLabUI.sleep(4);
//            }
            syscoLabUI.clickOnVisibleElement(lnkSupportRequestsList);
        } else {
            syscoLabUI.click(lnkScrollBar);
            syscoLabUI.sleep(1);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            syscoLabUI.scrollDown(500000.0);
            int i = 0;
            while (i < 10) {
                actions.sendKeys(Keys.PAGE_DOWN).build().perform();
                i++;
            }
            syscoLabUI.scrollBottom();

            syscoLabUI.clickWithJavascript(lnkScrollBar);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            syscoLabUI.scrollDown(500000.0);
            syscoLabUI.scrollBottom();

            syscoLabUI.move(lnkSupportRequestsList);
            syscoLabUI.sleep(4);
            syscoLabUI.click(lnkSupportRequestsList);
        }
        syscoLabUI.sleep(5);
        LoggerUtil.logINFO("Support Requests list opened");
    }


    public void viewFirstSupportRequest() {

        syscoLabUI.clickOnVisibleElement(lnkFirstSupportRequest);
        syscoLabUI.sleep(2);
    }

    public boolean isRequestAssignedToMA(String accountOwner) {

        syscoLabUI.sleep(5);
        return syscoLabUI.isDisplayed(lblSRAssignedToMA);
//        return syscoLabUI.isDisplayed(DriverSetUpUtil.replaceInLocator(lblSRAssignedToMA,"MA_NAME",accountOwner));
    }


    public boolean isRequestAssignedToTeam(String team) {

        syscoLabUI.sleep(5);
        return syscoLabUI.isDisplayed(DriverSetUpUtil.replaceInLocator(lblSRAssignedToTeam, "#", team));
    }

}
