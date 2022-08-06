package request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.CORARequestData;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.syscolab.qe.core.api.request.RequestBase;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CORARequest extends RequestBase {

    public String Application_Status__c;
    public String Name;
    public String LegalCompanyName__c;

    public String Bill_to_RiskCode__c;
    public String Bill_to_Collector__c;
    public String Credit_Limit__c;

    public String Federal_Tax_ID__c;
    public String Credit_Analyst_CCA__c;
    public String Payment_Terms_Policy_Text__c;

    public String Annual_Sales__c;
    public String Tax_Exempt__c;
    public String Year_Business_Founded__c;
    public String Number_of_Employees__c;
    public String Ship_to_GPC__c;
    public String Profit_Non_Profit__c;
    public String Registered__c;
    public String Operation_on_Tribal_Land__c;
    public String Style_of_Business__c;
    public String REQ_Number__c;
    public String Tax_Exempt_Number__c;
    public String Number_of_Years_in_Business__c;

    public String Autocash_Control__c;
    public String Cash_Receipts_Autocash__c;
    public String Aging_Policy__c;
    public String Auto_Cash_Policy__c;
    public String Cash_Tolerance_Policy__c;
    public String CORAResponseJSON__c;
//    public String appStatus = Constants.APP_STATUS;
//    public String coraResponse = Constants.CORA_RESPONSE_JSON;


    public CORARequest getSubmissionPatchRequest (String key){

        CORARequest coraRequest = new CORARequest();
        CORARequestData coraRequestData = ExcelUtil.getCORARequestData(key);
        coraRequest.Application_Status__c = coraRequestData.Application_Status;
        return coraRequest;
    }

    public CORARequest getShopShipToPatchRequest(String key, String accountName){

        CORARequest coraRequest = new CORARequest();
        CORARequestData coraRequestData = ExcelUtil.getCORARequestData(key);
        coraRequest.Application_Status__c = coraRequestData.Application_Status;
        coraRequest.Name = accountName;
        coraRequest.LegalCompanyName__c = accountName;
        coraRequest.Annual_Sales__c = coraRequestData.Annual_Sales;
        coraRequest.Tax_Exempt__c = coraRequestData.Tax_Exempt;
        coraRequest.Federal_Tax_ID__c = coraRequestData.Federal_Tax_ID;
        coraRequest.Year_Business_Founded__c = coraRequestData.Year_Business_Founded;
        coraRequest.Number_of_Employees__c = coraRequestData.Number_of_Employees;
        coraRequest.Credit_Analyst_CCA__c = coraRequestData.Credit_Analyst_CCA;
        coraRequest.Payment_Terms_Policy_Text__c = coraRequestData.Payment_Terms_Policy_Text;
        coraRequest.Ship_to_GPC__c = coraRequestData.Ship_to_GPC;
        coraRequest.Registered__c = coraRequestData.Registered;
        coraRequest.Operation_on_Tribal_Land__c = coraRequestData.Operation_on_Tribal_Land;
        coraRequest.Style_of_Business__c = coraRequestData.Style_of_Business;
        coraRequest.Tax_Exempt_Number__c = coraRequestData.Tax_Exempt_Number;
        coraRequest.Number_of_Years_in_Business__c = coraRequestData.Number_of_Years_in_Business;

        return coraRequest;
    }

    public CORARequest getLegacyShipToPatchRequest(String key, String accountName){

        CORARequest coraRequest = new CORARequest();
        CORARequestData coraRequestData = ExcelUtil.getCORARequestData(key);
        coraRequest.Application_Status__c = coraRequestData.Application_Status;

        coraRequest.Name = accountName;
        coraRequest.LegalCompanyName__c = accountName;
        coraRequest.Federal_Tax_ID__c = coraRequestData.Federal_Tax_ID;
        coraRequest.Credit_Analyst_CCA__c = coraRequestData.Credit_Analyst_CCA;
        coraRequest.Payment_Terms_Policy_Text__c = coraRequestData.Payment_Terms_Policy_Text;
        coraRequest.Autocash_Control__c = coraRequestData.Autocash_Control;
        coraRequest.Cash_Receipts_Autocash__c = coraRequestData.Cash_Receipts_Autocash;
        coraRequest.Aging_Policy__c = coraRequestData.Aging_Policy;

        return coraRequest;
    }

    public CORARequest getBillToPatchRequest(String key){
        CORARequest coraRequest = new CORARequest();
        CORARequestData coraRequestData = ExcelUtil.getCORARequestData(key);

        coraRequest.Bill_to_RiskCode__c = coraRequestData.Bill_to_RiskCode;
        coraRequest.Bill_to_Collector__c = coraRequestData.Bill_to_Collector;
        coraRequest.Credit_Limit__c = coraRequestData.Credit_Limit;
        coraRequest.Federal_Tax_ID__c = coraRequestData.Federal_Tax_ID;
        coraRequest.Credit_Analyst_CCA__c = coraRequestData.Credit_Analyst_CCA;
        coraRequest.Payment_Terms_Policy_Text__c = coraRequestData.Payment_Terms_Policy_Text;

        return coraRequest;
    }


    //CFEA Credit Approval Patch Request Body
    public CORARequest getCreditApprovePatchRequest(String key){

        CORARequest coraRequest = new CORARequest();
        CORARequestData coraRequestData = ExcelUtil.getCORARequestData(key);
        coraRequest.Application_Status__c = coraRequestData.Application_Status;
        coraRequest.Annual_Sales__c = coraRequestData.Annual_Sales;
        coraRequest.Tax_Exempt__c = coraRequestData.Tax_Exempt;
        coraRequest.Federal_Tax_ID__c = coraRequestData.Federal_Tax_ID;
        coraRequest.Year_Business_Founded__c = coraRequestData.Year_Business_Founded;
        coraRequest.Number_of_Employees__c = coraRequestData.Number_of_Employees;
        coraRequest.Credit_Analyst_CCA__c = coraRequestData.Credit_Analyst_CCA;
        coraRequest.Payment_Terms_Policy_Text__c = coraRequestData.Payment_Terms_Policy_Text;
        coraRequest.Ship_to_GPC__c = coraRequestData.Ship_to_GPC;
        coraRequest.Registered__c = coraRequestData.Registered;
        coraRequest.Style_of_Business__c = coraRequestData.Style_of_Business;
        coraRequest.Number_of_Years_in_Business__c = coraRequestData.Number_of_Years_in_Business;

        return coraRequest;
    }


    //Inactivation Patch Request Body Creation
    public CORARequest getInactivationPatchRequest(String appStatus,String coraResponse){

        CORARequest coraRequest = new CORARequest();
        coraRequest.Application_Status__c = appStatus;
        coraRequest.CORAResponseJSON__c = coraResponse;

        return coraRequest;
    }


    //Reactivation Patch Request Body Creation
    public CORARequest getReactivationPatchRequest(String appStatus,String coraResponse,String paymentTerms,String tax,String collector,String registered, String tribal, String creditAnalyst){

        CORARequest coraRequest = new CORARequest();
        coraRequest.Application_Status__c = appStatus;
        coraRequest.CORAResponseJSON__c = coraResponse;
        coraRequest.Payment_Terms_Policy_Text__c = paymentTerms;
        coraRequest.Tax_Exempt__c = tax;
        coraRequest.Bill_to_Collector__c = collector;
        coraRequest.Registered__c = registered;
        coraRequest.Operation_on_Tribal_Land__c = tribal;
        coraRequest.Credit_Analyst_CCA__c = creditAnalyst;

        return coraRequest;
    }
}
