package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.pages.LoginPage;


/**
 * Created by Rifad on 5/21/18.
 */
public class Login {

    private Login() {
    }

    public static final LoginPage loginPage = new LoginPage();

    //Set the Username and Password
    public static void enterUserDetails(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    //Click Login Button
    public static void clickLogin() {
        loginPage.clickLogin();
    }

    public static void refreshBrowser() {
        loginPage.refreshBrowser();
    }

}