package com.sysco.mdm_customer.models;

import com.sysco.mdm_customer.models.request.GetCADDAccountRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommonModelGETCADDAccountDetails {
    private String referenceKey;
    private GetCADDAccountRequest request;
}