package com.sysco.mdm_customer.models;


import com.sysco.mdm_customer.models.request.GetLoginRequest;
import com.sysco.mdm_customer.models.request.GetSBSApprovalRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//Login details from Login Json
public class CommonModelGETSBSApprovalDetails {
    private String referenceKey;
    private GetSBSApprovalRequest request;
}
