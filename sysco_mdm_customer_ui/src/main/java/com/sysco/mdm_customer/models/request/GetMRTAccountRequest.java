package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetMRTAccountRequest implements Serializable {

    private String marketingAssociate;
    private String mobileNumber;
    private String companyName;
    private String weeklySales;
    private String firstName;
    private String lastName;
    private String fullName;
    private String dsm;
    private String leadRating;
    private String opCo;
    private String territory;
    private String contactEmail;
    private String businessStructure;
    private String conversionType;
    private List<GetMRTAccountRequest.LeadBillToInfo> leadBillToInfo;
    private List<GetMRTAccountRequest.LeadShipToInfo> leadShipToInfo;
    private List<GetCADDAccountRequest.ContactInfo> contactInfo;


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
    public static class LeadShipToInfo implements Serializable {


        private String shippingStreet;
        private String shippingCity;
        private String shippingState;
        private String shippingPostalCode;
        private String shippingCountry;
        private String shippingPhone;
        private String shipToAccountName;
    }

    @Setter
    @Getter
    public static class ContactInfo implements Serializable {

        private String firstName;
        private String lastName;
        private String caddEmail;
        private String mobileNumber;
        private String fullName;
    }

}