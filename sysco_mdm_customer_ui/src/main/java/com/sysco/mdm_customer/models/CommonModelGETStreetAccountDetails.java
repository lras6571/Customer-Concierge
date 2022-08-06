package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommonModelGETStreetAccountDetails {
    private String referenceKey;
    private GetStreetAccountRequest request;
}
