package com.sysco.mdm_customer.functions.street;

import com.sysco.mdm_customer.pages.street.CuisineInfoPage;


public class CuisineInfo {

    static CuisineInfoPage cuisineInfoPage = new CuisineInfoPage();

    private CuisineInfo() {
    }

    /*
     * Enter Cuisine Info Screen Data
     * */
    public static void setCuisineInfo(String strCuisine, String strOperation, String strLocalOperationType) {
        cuisineInfoPage.setCuisineInfo(strCuisine, strOperation, strLocalOperationType);
    }
    /*
     * Assert Street Account CCA Flow Cuisine Info Screen
     * */
    public static boolean isCuisineInfoFieldDisplayed() {
        return cuisineInfoPage.isCuisineInfoFieldDisplayed();
    }
}