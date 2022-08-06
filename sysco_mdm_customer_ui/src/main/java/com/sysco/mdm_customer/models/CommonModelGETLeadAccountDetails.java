package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.GetLeadAccountRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//Lead details from Lead Json
public class CommonModelGETLeadAccountDetails {

    private String referenceKey;
    private GetLeadAccountRequest request;
}
