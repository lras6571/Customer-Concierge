package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//Lead details from Lead Json
public class CommonModelGETFreshPointLeadDetails {

    private String referenceKey;
    private FPLeadAccountRequest request;
}
