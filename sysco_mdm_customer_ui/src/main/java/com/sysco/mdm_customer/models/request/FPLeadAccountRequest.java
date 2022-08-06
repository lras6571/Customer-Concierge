package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FPLeadAccountRequest implements Serializable {

    private String marketingAssociate;
    private String taxApprover;
    private String mobileNumber;
    private String companyName;
    private String weeklySales;
    private String firstName;
    private String lastName;
    private String fullName;
    private String leadName;
    private String leadRating;
    private String opCo;
    private String territory;
    private String contactEmail;
    private String businessStructure;
    private String conversionType;
    private String language;
    private String filter;
    private String state;
    private String routingInformation;
    private String nationalID;
    private String activeAccountName;
    private String activeAccountID;
    private String existingAccountName;
    private List<FPLeadAccountRequest.LeadBillToInfo> leadBillToInfo;
    private List<FPLeadAccountRequest.AccountInfo> accountInfo;
    private List<GetStreetAccountRequest.BillToInfo> billToInfo;
    private List<GetStreetAccountRequest.ContactInfo> contactInfo;

    @Setter
    @Getter
    public static class LeadBillToInfo implements Serializable {
        private String billingStreet;
        private String billingCity;
        private String billingState;
        private String billingPostalCode;
        private String billingCountry;
    }

    @Setter
    @Getter
    public static class AccountInfo implements Serializable {
        private String accountName;
        private String accountPhone;
        private String storeNumber;
        private String accountStreet;
        private String accountCity;
        private String accountState;
        private String accountPostalCode;
        private String accountCountry;
        private String accountGroup;
    }

    @Setter
    @Getter
    public static class BillToInfo implements Serializable {
        private String billToAccountName;
        private String billingStreet;
        private String billingCity;
        private String billingState;
        private String billingPostalCode;
        private String billingCountry;
        private String billToOwner;
    }

    @Setter
    @Getter
    public static class ContactInfo implements Serializable {
        private String firstName;
        private String lastName;
        private String streetEmail;
        private String mobileNumber;
    }

}