package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.GetLoginRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//Login details from Login Json
public class CommonModelGETLoginDetails {
    private String referenceKey;
    private GetLoginRequest request;
}
