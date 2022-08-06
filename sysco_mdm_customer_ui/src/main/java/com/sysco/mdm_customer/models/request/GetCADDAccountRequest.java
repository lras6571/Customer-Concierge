package com.sysco.mdm_customer.models.request;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetCADDAccountRequest implements Serializable {
    private String email;
    private String sbsUser;
    private String firstName;
    private String lastName;
    private String conceptName;
    private String caddAccountType;
    private String existingAccountName;

    private List<DeliveryPreference> deliveryPreference;
    private List<CuisineAndOperation> cuisineAndOperation;
    private List<AccountTypes> accountTypes;
    private List<AccountInfo> accountInfo;
    private List<ContactInfo> contactInfo;
    private List<BillToInfo> billToInfo;
    private List<TerritoryAssignment> territoryAssignment;


    @Setter
    @Getter
    public static class DeliveryPreference implements Serializable {

        private String deliveryDate;
        private String startTime;
        private String endTime;
        private String openTime;
        private String closeTime;
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
    public static class AccountInfo implements Serializable {

        private String accountName;
        private String accountPhone;
        private String storeNumber;
        private String accountStreet;
        private String accountCity;
        private String accountState;
        private String accountPostalCode;
        private String accountCountry;
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
    public static class TerritoryAssignment implements Serializable {

        private String site;
        private String marketingAssociate;
        private String territoryCode;
    }


}
