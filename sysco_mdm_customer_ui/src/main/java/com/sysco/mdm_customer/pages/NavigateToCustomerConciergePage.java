package com.sysco.mdm_customer.pages;

import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class NavigateToCustomerConciergePage {
    private final By lnkMainCustomerConcierge = By.xpath("//a[@title='Customer Concierge']");
    private final By lnkMore = By.xpath("//span[contains(text(),'More')]//parent::a");
    private final By lnkCustomerConcierge = By.xpath("//span[text()='Customer Concierge']//ancestor::a[@role='menuitem']");
    private final By lnkCustomerConciergeInAppLauncher = By.xpath("//p[text()='Customer Concierge']//ancestor::a");
    private final By lblConciergeLobby = By.xpath("//h2[text()='Customer Concierge']");
    //App Launcher
    private final By btnAppLauncher = By.xpath("//div[@role='navigation']//button");
    private final By btnViewAllOptions = By.xpath("//button[text()='View All']");
    private final By btnAppLauncherItemList = By.xpath("//span[@title='All Items']//ancestor::button");
    private final By btnClosePopup = By.xpath("//button[@title='Close this window']");
    private final By lblHome = By.xpath("//span[text()='Home']");
    Logger logger = Logger.getLogger(NavigateToCustomerConciergePage.class.getName());

    /*
     * Navigate to Customer Concierge Lobby
     *
     * */
    public void selectCustomerConcierge() {
        try {
            waitForSomeTime(5);
            LoggerUtil.logINFO("Selecting the Customer Concierge Menu");
            syscoLabUI.waitTillElementLoaded(lblHome,30);
            if (syscoLabUI.isDisplayed(lnkMainCustomerConcierge)) {
                syscoLabUI.clickWithJavascript(lnkMainCustomerConcierge);
            } else {
                if (syscoLabUI.isDisplayed(lnkMore)) {
                    clickVisibleElement(lnkMore);
                    new WebDriverWait(SyscoLabUI.driver, 10).until(ExpectedConditions.attributeToBe(lnkMore, "aria-expanded", "true"));
                }
                if (syscoLabUI.isDisplayed(lnkCustomerConcierge)) {
                    syscoLabUI.clickWithJavascript(lnkCustomerConcierge);
                } else {
                    clickVisibleElement(lnkMore);
                    openAppLauncher();
                    syscoLabUI.scrollBottom();
                    syscoLabUI.waitTillElementLoaded(lnkCustomerConciergeInAppLauncher);
                    syscoLabUI.clickWithJavascript(lnkCustomerConciergeInAppLauncher);
                }
            }
            syscoLabUI.waitTillElementLoaded(lblConciergeLobby);
            LoggerUtil.logINFO("Concierge lobby loaded");
        } catch (Exception e) {
            LoggerUtil.logINFO(e.getMessage());
        }
    }

    public void clickVisibleElement(By xpath) {
        syscoLabUI.clickWithJavascript(syscoLabUI.findVisibleElements(xpath).get(0));
    }

    public void openAppLauncher() {
        syscoLabUI.clickWithJavascript(btnAppLauncher);
        syscoLabUI.waitTillElementLoaded(btnViewAllOptions);
        syscoLabUI.clickWithJavascript(btnViewAllOptions);
        waitForSomeTime(5);
        if (!syscoLabUI.isClickable(btnAppLauncherItemList)) {
            closeAppLauncher();
            syscoLabUI.clickWithJavascript(btnAppLauncher);
            syscoLabUI.waitTillElementLoaded(btnViewAllOptions);
            syscoLabUI.clickWithJavascript(btnViewAllOptions);
            new WebDriverWait(SyscoLabUI.driver, 15).until(ExpectedConditions.elementToBeClickable(btnAppLauncherItemList));
        }
        logger.info("App launcher opened");
        if (!Boolean.TRUE.equals(Boolean.valueOf(syscoLabUI.getAttribute(btnAppLauncherItemList, "aria-expanded")))) {
            syscoLabUI.click(btnAppLauncherItemList);
        }
    }

    public void waitForSomeTime(int timeInSeconds) {
        syscoLabUI.sleep(timeInSeconds);
    }

    public void closeAppLauncher() {
        if (syscoLabUI.isDisplayed(btnClosePopup)) {
            logger.info("Closing App Launcher window");
            syscoLabUI.clickWithJavascript(btnClosePopup);
            syscoLabUI.sleep(1);
        }
    }

}
