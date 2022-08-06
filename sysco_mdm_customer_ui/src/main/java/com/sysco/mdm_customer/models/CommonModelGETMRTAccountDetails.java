package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.GetLeadAccountRequest;
import com.sysco.mdm_customer.models.request.GetMRTAccountRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//Lead details from Lead Json
public class CommonModelGETMRTAccountDetails {

    private String referenceKey;
    private GetMRTAccountRequest request;
}
