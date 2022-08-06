package com.sysco.mdm_customer.utils;

import com.sysco.mdm_customer.exceptions.ReferenceKeyNotFound;
import com.sysco.mdm_customer.models.*;
import java.util.List;

public class DataUtil {
    private static final String INPUT_REFERENCE_KEY = "Input reference key ";

    DataUtil() {
    }

    public static List<CommonModelGETStreetAccountDetails> getCommonModelGETStreetAccountDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETStreetAccountDetails.class);
    }

    public static CommonModelGETStreetAccountDetails getEmployeeModelForReferenceKey(String referenceKey, List<CommonModelGETStreetAccountDetails> commonEmployeeModelList) {
        for (int i = 0; i < commonEmployeeModelList.size(); i++) {
            if (referenceKey.equals(commonEmployeeModelList.get(i).getReferenceKey())) {
                return commonEmployeeModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Employee Request");
    }


    //Get Login details
    public static List<CommonModelGETLoginDetails> getCommonModelGETLoginDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETLoginDetails.class);
    }

    //Get Login details through a Reference Key
    public static CommonModelGETLoginDetails getLoginModelReferenceKey(String referenceKey, List<CommonModelGETLoginDetails> commonLoginModelList) {

        for (int i = 0; i < commonLoginModelList.size(); i++) {
            if (referenceKey.equals(commonLoginModelList.get(i).getReferenceKey())) {
                return commonLoginModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Login Request");
    }


    //Get Lead details
    public static List<CommonModelGETLeadAccountDetails> getCommonModelGETLeadDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETLeadAccountDetails.class);
    }

    //Get Lead details through a Reference Key
    public static CommonModelGETLeadAccountDetails getLeadModelForReferenceKey(String referenceKey, List<CommonModelGETLeadAccountDetails> commonLeadAccountModelList) {

        for (int i = 0; i < commonLeadAccountModelList.size(); i++) {
            if (referenceKey.equals(commonLeadAccountModelList.get(i).getReferenceKey())) {
                return commonLeadAccountModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Lead Request");
    }


    //Get CADD details
    public static List<CommonModelGETCADDAccountDetails> getCommonModelGETCADDDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETCADDAccountDetails.class);
    }

    //Get CADD details through a Reference Key
    public static CommonModelGETCADDAccountDetails getCADDModelForReferenceKey(String referenceKey, List<CommonModelGETCADDAccountDetails> commonCADDAccountModelList) {

        for (int i = 0; i < commonCADDAccountModelList.size(); i++) {
            if (referenceKey.equals(commonCADDAccountModelList.get(i).getReferenceKey())) {
                return commonCADDAccountModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Lead Request");
    }


    //Get SBS User details
    public static List<CommonModelGETSBSApprovalDetails> getsbsApprovalDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETSBSApprovalDetails.class);
    }

    //Get SBS User details through a Reference Key
    public static CommonModelGETSBSApprovalDetails getSBSModelForReferenceKey(String referenceKey, List<CommonModelGETSBSApprovalDetails> commonSBSApprovalModelList) {

        for (int i = 0; i < commonSBSApprovalModelList.size(); i++) {
            if (referenceKey.equals(commonSBSApprovalModelList.get(i).getReferenceKey())) {
                return commonSBSApprovalModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Login Request");
    }


    //Get Asian Foods Lead details
    public static List<CommonModelGETAsianFoodsLeadDetails> getAsianFoodsLeadDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETAsianFoodsLeadDetails.class);
    }

    //Get Asian Foods Lead details through a Reference Key
    public static CommonModelGETAsianFoodsLeadDetails getAFLeadModelForReferenceKey(String referenceKey, List<CommonModelGETAsianFoodsLeadDetails> commonAFLeadApprovalModelList) {

        for (int i = 0; i < commonAFLeadApprovalModelList.size(); i++) {
            if (referenceKey.equals(commonAFLeadApprovalModelList.get(i).getReferenceKey())) {
                return commonAFLeadApprovalModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Login Request");
    }



    //Get Fresh Point Lead details
    public static List<CommonModelGETFreshPointLeadDetails> getFreshPointLeadDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETFreshPointLeadDetails.class);
    }

    //Get Fresh Point Lead details through a Reference Key
    public static CommonModelGETFreshPointLeadDetails getFPLeadModelForReferenceKey(String referenceKey, List<CommonModelGETFreshPointLeadDetails> commonFPLeadApprovalModelList) {

        for (int i = 0; i < commonFPLeadApprovalModelList.size(); i++) {
            if (referenceKey.equals(commonFPLeadApprovalModelList.get(i).getReferenceKey())) {
                return commonFPLeadApprovalModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Login Request");
    }



    //Get MRT details
    public static List<CommonModelGETMRTAccountDetails> getCommonModelGETMRTDetailsList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETMRTAccountDetails.class);
    }


    //Get MRT details through a Reference Key
    public static CommonModelGETMRTAccountDetails getMRTModelForReferenceKey(String referenceKey, List<CommonModelGETMRTAccountDetails> commonMRTAccountModelList) {

        for (int i = 0; i < commonMRTAccountModelList.size(); i++) {
            if (referenceKey.equals(commonMRTAccountModelList.get(i).getReferenceKey())) {
                return commonMRTAccountModelList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Lead Request");
    }


    //Get Assertion details through a Reference Key
    public static CommonModelGETInitiateShipToScreenAssertionDetails getAssertionForReferenceKey(String referenceKey, List<CommonModelGETInitiateShipToScreenAssertionDetails> screenAssertionDetailsGETDataList) {

        for (int i = 0; i < screenAssertionDetailsGETDataList.size(); i++) {
            if (referenceKey.equals(screenAssertionDetailsGETDataList.get(i).getReferenceKey())) {
                return screenAssertionDetailsGETDataList.get(i);
            }
        }

        throw new ReferenceKeyNotFound(INPUT_REFERENCE_KEY + referenceKey + " not found for Lead Request");
    }
    //Get Assertion details
    public static List<CommonModelGETInitiateShipToScreenAssertionDetails> screenAssertionDetailsGETDataList(String filePath, String fileName) {
        return JacksonUtil.getObjectArray(FileOperationsUtils.readFileToString(filePath, fileName), CommonModelGETMRTAccountDetails.class);
    }
}
