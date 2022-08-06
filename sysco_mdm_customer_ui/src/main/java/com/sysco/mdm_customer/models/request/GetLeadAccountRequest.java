package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetLeadAccountRequest implements Serializable {

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
    private List<GetLeadAccountRequest.LeadBillToInfo> leadBillToInfo;


    @Setter
    @Getter
    public static class LeadBillToInfo implements Serializable {


        private String billingStreet;
        private String billingCity;
        private String billingState;
        private String billingPostalCode;
        private String billingCountry;
    }

}