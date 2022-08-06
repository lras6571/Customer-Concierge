package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetSBSApprovalRequest implements Serializable {

    private String sbsUser;
    private String taxGroup;
    private String taxSupplement;
    private String approveComments;
    private List<SupportRequestFilter> supportRequestFilter;

    @Setter
    @Getter
    public static class SupportRequestFilter implements Serializable {
        private String supportRequestFilterType;

    }
}