package com.sysco.mdm_customer.pages;

import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.sysco.mdm_customer.common.GUIConstants.APP_BROWSER;


public class GUIPageBase {

    public static SyscoLabWUI syscoLabUI;

    private GUIPageBase() {
    }

    public static void loadLoginPage(String url, DesiredCapabilities capabilities) {

        syscoLabUI = new SyscoLabWUI(APP_BROWSER, capabilities);
        syscoLabUI.navigateTo(url);
        syscoLabUI.maximizeWindow();
    }

    public static void quitDriver() {

        if (syscoLabUI != null) {
            syscoLabUI.quit();
        }
    }

}
