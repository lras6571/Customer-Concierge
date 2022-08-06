package com.sysco.mdm_customer.pages.street;

import com.sysco.mdm_customer.data.StreetAccountData;
import com.sysco.mdm_customer.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


/*
 * Ship-To Confirmation page data validation
 * */
public class ShipToConfirmationPage extends LoginPage {

    private static Map<String, String> businessInformationDataMap;
    private static Map<String, String> shippingAddressDataMap;
    private static Map<String, String> newContactInfoMap;
    private static Map<String, String> deliveryPreferenceMap;
    private static List<String> deliveryPreferenceList;
    private static List<String> businessInformationList;
    private final By lblSTREETBusinessInformation = By.xpath("//b[text()='Account Information:']//following-sibling::dl/*[position()>=1 and position()<=5]");//For STREET flows ignore 2
    private final By lblShippingAddress = By.xpath("//b[text()='Shipping Information:']//following-sibling::dl/*[position()>=1 and position()<=3]");
    private final By lblNewContactInformation = By.xpath("//b[text()='Contact Information:']//following-sibling::dl/*[position()>=1 and position()<=5]");
    private final By lblDeliveryPreferences = By.xpath("//*[contains(text(),'New Delivery Preferences')]/following-sibling::dl");
    private final ArrayList<String> additionalInfoList = new ArrayList<>();
    private final ArrayList<String> newContactInfoList = new ArrayList<>();
    private ArrayList<String> shippingAddressDataList;

    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Business Info For STREET primary and STREET secondary Ship-To
     *
     * @param
     * @return
     */
    public void collectBusinessInformationDataForSTREETAccounts() {
        syscoLabUI.waitTillElementLoaded(lblSTREETBusinessInformation);
        List<WebElement> businessInformationElements = syscoLabUI.findElements(lblSTREETBusinessInformation);
        businessInformationList = new ArrayList<>();
        for (int i = 0; i <= businessInformationElements.size(); i += 2) {
            businessInformationList.add(syscoLabUI.getText(businessInformationElements.get(i)));
        }
        businessInformationDataMap = new HashMap<>();
        businessInformationDataMap.put(StreetAccountData.CONFIRM_ACCOUNT_NAME, businessInformationList.get(0).split(":")[1].trim());
        businessInformationDataMap.put(StreetAccountData.CONFIRM_ACCOUNT_TYPE, businessInformationList.get(1).split(":")[1].trim());
        businessInformationDataMap.put(StreetAccountData.CONFIRM_ACCOUNT_PHONE, businessInformationList.get(2).split(":")[1].trim());
    }

    public String getBusinessInformation(String fieldName) {
        return businessInformationDataMap.get(fieldName);
    }

    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Shipping address details of all account types
     *
     * @param
     * @return
     */
    public void collectShippingAddressInformation() {
        syscoLabUI.sleep(1);
        syscoLabUI.waitTillElementLoaded(lblShippingAddress);
        List<WebElement> shippingAddressElements = syscoLabUI.findElements(lblShippingAddress);
        shippingAddressDataList = new ArrayList<>();
        for (int i = 0; i <= shippingAddressElements.size(); i += 2) {
            shippingAddressDataList.add(syscoLabUI.getText(shippingAddressElements.get(i)));
        }
        shippingAddressDataMap = new HashMap<>();
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_STREET, shippingAddressDataList.get(0));
        String addressSecondLine = shippingAddressDataList.get(1);
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_CITY, addressSecondLine.split(",")[0]);
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_STATE, addressSecondLine.split(",")[1].trim().split(" ")[0]);
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_POSTAL_CODE, addressSecondLine.split(",")[1].trim().split(" ")[1]);
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_COUNTRY, addressSecondLine.split(",")[1].trim().split(" ")[2]);
    }

    public String getShippingAddress(String fieldName) {
        return shippingAddressDataMap.get(fieldName);
    }

    /*
     * collectNewContactInformation - To collect contact information of all account types
     *
     * @param
     * @return
     */
    public void collectNewContactInformation() {
        syscoLabUI.sleep(1);
        syscoLabUI.waitTillElementLoaded(lblNewContactInformation);
        List<WebElement> principalContactInformationElements = syscoLabUI.findElements(lblNewContactInformation);

        for (int i = 0; i <= principalContactInformationElements.size(); i += 2) {
            newContactInfoList.add(syscoLabUI.getText(principalContactInformationElements.get(i)));
        }
        newContactInfoMap = new HashMap<>();
        newContactInfoMap.put(StreetAccountData.CONFIRM_PRINCIPAL_CONTACT_NAME, newContactInfoList.get(0).split(":")[1].trim());
        newContactInfoMap.put(StreetAccountData.CONFIRM_PRINCIPAL_CONTACT_EMAIL, newContactInfoList.get(1).split(":")[1].trim());
        newContactInfoMap.put(StreetAccountData.CONFIRM_PRINCIPAL_CONTACT_PHONE, newContactInfoList.get(2).split(":")[1].trim());
    }

    public String getNewContactInformation(String fieldName) {
        return newContactInfoMap.get(fieldName);
    }


    /*
     * collectDeliveryPreferenceData - To collect contact information of all account types
     *
     * @param
     * @return
     */
    public void collectDeliveryPreferenceData() {
        syscoLabUI.sleep(1);
        String deliveryDetails = syscoLabUI.getText(lblDeliveryPreferences);
        deliveryPreferenceList = new ArrayList<>();
        deliveryPreferenceList = Arrays.asList(deliveryDetails.split("\n"));
        deliveryPreferenceMap = new HashMap<>();
        deliveryPreferenceMap.put(StreetAccountData.DELIVERY_DAY, deliveryPreferenceList.get(0).split(":")[1].trim());
        String standardDeliveryWindow = deliveryPreferenceList.get(1);
        deliveryPreferenceMap.put(StreetAccountData.STANDARD_DELIVERY_WINDOW_START, standardDeliveryWindow.substring(standardDeliveryWindow.indexOf(':') + 1).split("-")[0].trim());
        deliveryPreferenceMap.put(StreetAccountData.STANDARD_DELIVERY_WINDOW_END, standardDeliveryWindow.substring(standardDeliveryWindow.indexOf(':') + 1).split("-")[1].trim());
        String backdoorDeliveryWindow = deliveryPreferenceList.get(2);
        deliveryPreferenceMap.put(StreetAccountData.STANDARD_BACKDOOR_START, backdoorDeliveryWindow.substring(backdoorDeliveryWindow.indexOf(':') + 1).split("-")[0].trim());
        deliveryPreferenceMap.put(StreetAccountData.STANDARD_BACKDOOR_END, backdoorDeliveryWindow.substring(backdoorDeliveryWindow.indexOf(':') + 1).split("-")[1].trim());

    }

    //For All account types
    public String getDeliveryPreferenceData(String fieldName) {
        return deliveryPreferenceMap.get(fieldName);
    }


}