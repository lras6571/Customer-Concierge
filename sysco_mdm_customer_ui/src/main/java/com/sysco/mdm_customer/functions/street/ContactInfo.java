package com.sysco.mdm_customer.functions.street;


import com.sysco.mdm_customer.pages.street.ContactInfoPage;


public class ContactInfo {

    public static final ContactInfoPage contactInfoPage = new ContactInfoPage();


    private ContactInfo() {
    }

    /*
     * Enter Contact Info Screen Data (FirstName,LastName,EmailAddress,TelephoneNumber)
     * */
    public static void enterFirstName(String firstName) {
        contactInfoPage.enterFirstName(firstName);
    }

    public static void enterLastName(String lastName) {
        contactInfoPage.enterLastName(lastName);
    }

    public static void enterEmailAddress(String emailAddress) {
        contactInfoPage.enterEmailAddress(emailAddress);
    }

    public static void enterTelephoneNumber(String telNumber) {
        contactInfoPage.enterPhoneNumber(telNumber);
    }


    public static void enterCustomerLanguagePreference(String strLanguage) {

        contactInfoPage.enterCustomerLanguagePreference(strLanguage);
    }

    public static boolean isContactInfoFieldDisplayed() {
        return contactInfoPage.isContactInfoFieldDisplayed();
    }
}