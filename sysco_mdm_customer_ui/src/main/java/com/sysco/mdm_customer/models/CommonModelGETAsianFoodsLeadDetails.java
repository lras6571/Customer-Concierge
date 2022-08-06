package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//Lead details from Lead Json
public class CommonModelGETAsianFoodsLeadDetails {

    private String referenceKey;
    private AFLeadAccountRequest request;
}
