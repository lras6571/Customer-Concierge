package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetStreetAccountRequest implements Serializable {
    private String email;
    private String marketingAssociate;
    private String firstName;
    private String lastName;
    private String prospectName;
    private String activeAccountName;
    private String activeAccountID;

    private List<DeliveryPreference> deliveryPreference;
    private List<CuisineAndOperation> cuisineAndOperation;
    private List<AccountTypes> accountTypes;
    private List<AccountRoles> accountRoles;
    private List<AccountInfo> accountInfo;
    private List<ContactInfo> contactInfo;
    private List<BillToInfo> billToInfo;
    private List<SupportRequest> supportRequest;

    @Setter
    @Getter
    public static class DeliveryPreference implements Serializable {
        private String deliveryDay;
        private String deliveryWindow1Start;
        private String deliveryWindow1End;
        private String backdoorOpen;
        private String backdoorClose;


    }

    @Setter
    @Getter
    public static class CuisineAndOperation implements Serializable {
        private String typeOfCuisine;
        private String typeOfOperation;
        private String localTypeOfOperation;

    }

    @Setter
    @Getter
    public static class AccountTypes implements Serializable {
        private String accountType;

    }

    @Setter
    @Getter
    public static class AccountRoles implements Serializable {
        private String accountRole;

    }

    @Setter
    @Getter
    public static class AccountInfo implements Serializable {
        private String accountName;
        private String accountStreet;
        private String accountCity;
        private String accountState;
        private String accountPostalCode;
        private String accountCountry;
        private String accountPhone;
        private String accountGroup;

    }

    @Setter
    @Getter
    public static class ContactInfo implements Serializable {
        private String firstName;
        private String lastName;
        private String streetEmail;
        private String mobileNumber;


    }

    @Setter
    @Getter
    public static class SupportRequest implements Serializable {
        private String supportRequestOwner;
        private String status;
        private String caseRequestType;
        private String creditApplicationStatus;
        private String creditApplicationStatusAfterApproval;

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
}