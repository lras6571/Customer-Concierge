package com.sysco.mdm_customer.functions.lead;

import com.sysco.mdm_customer.pages.lead.LeadsHomePage;

public class LeadsHome {

     private LeadsHome(){
        }

    public static final LeadsHomePage leadsHomePage = new LeadsHomePage();

    //Select the My Leads from Leads Tab
    public static void viewList(String strView) {

        leadsHomePage.viewList(strView);
    }

    //Sort the Record based on the Last Modified Date
    public static void sortLeadList(){

        leadsHomePage.sortLeadList();
    }

    //Select the Latest Record
    public static void selectFirstRecord(){

        leadsHomePage.selectFirstRecord();
    }
}
