package com.sysco.mdm_customer.pages;


import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

/**
 * Created by Lasan on 01/03/2022.
 */
public class LoginPage {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("Login");
    protected By btnProfileImage = By.xpath("//header/div[2]/span[1]/div[2]/ul[1]/li[8]/span[1]/button[1]/div[1]/span[1]/div[1]/span[1]");
    protected By lblUserName = By.xpath("//label[contains(text(),'Username')]");


    //Driver Close
    public static void quitDriver() {

        if (syscoLabUI != null) {
            syscoLabUI.quit();
        }
    }


    //Enter email Address as the Username
    public void setEmail(String email) {

        syscoLabUI.waitTillElementLoaded(lblUserName,15);
        LoggerUtil.logINFO("Wait Till User Name Label is Visible in the Screen");
        syscoLabUI.click(txtUserName);
        syscoLabUI.sendKeys(txtUserName, email);
        LoggerUtil.logINFO("Entered the Username");
    }

    //Enter Password to Login
    public void setPassword(String password) {

        syscoLabUI.click(txtPassword);
        syscoLabUI.sendKeys(txtPassword, password);
        LoggerUtil.logINFO("Entered the Password");
        syscoLabUI.sleep(2);
        LoggerUtil.logINFO("Wait 2 Seconds after entering the Password");
        syscoLabUI.waitTillElementLoaded(btnLogin,5);
        LoggerUtil.logINFO("Wait Till Login Button is Visible in the Screen");
    }

    //Click Login Button
    public void clickLogin() {

        LoggerUtil.logINFO("Ready to click the Login Button");
        syscoLabUI.clickWithJavascript(btnLogin);
        LoggerUtil.logINFO("Click Login Button");
        try {
            syscoLabUI.waitTillElementLoaded(btnProfileImage,15);
            LoggerUtil.logINFO("Waiting Till Profile Image Loaded");


        } catch (Exception e) {

            syscoLabUI.refreshBrowser();
            LoggerUtil.logINFO("Refresh Browser");

        }

    }

    public void refreshBrowser() {
        syscoLabUI.refreshBrowser();
        LoggerUtil.logINFO("Refresh the Browser");
    }

}
