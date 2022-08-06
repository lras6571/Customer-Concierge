package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.GetInitiateShipToScreenAssertionRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommonModelGETInitiateShipToScreenAssertionDetails {
    private String referenceKey;
    private GetInitiateShipToScreenAssertionRequest request;
}
