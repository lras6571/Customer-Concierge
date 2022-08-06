package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetInitiateShipToScreenAssertionRequest implements Serializable {

    private List<GetInitiateShipToScreenAssertionRequest.StreetNewInitiateShipTo> streetNewInitiateShipTo;
    private List<GetInitiateShipToScreenAssertionRequest.StreetNSLInitiateShipTo> streetNSLInitiateShipTo;
    private List<GetInitiateShipToScreenAssertionRequest.StreetNLAInitiateShipTo> streetNLAInitiateShipTo;
    private List<GetInitiateShipToScreenAssertionRequest.MRTInitiateShipTo> MRTInitiateShipTo;

    @Setter
    @Getter
    public static class StreetNewInitiateShipTo implements Serializable {


        private String status;
        private String accountRole;
        private String accountCreateMaintain;
        private String applicationRequestType;
        private String creditApplicationStatus;
    }

    @Setter
    @Getter
    public static class StreetNSLInitiateShipTo implements Serializable {

        private String status;
        private String accountRole;
        private String accountCreateMaintain;
        private String applicationRequestType;
        private String creditApplicationStatus;
    }

    @Setter
    @Getter
    public static class StreetNLAInitiateShipTo implements Serializable {

        private String status;
        private String accountRole;
        private String accountCreateMaintain;
        private String applicationRequestType;
        private String creditApplicationStatus;
    }

    @Setter
    @Getter
    public static class MRTInitiateShipTo implements Serializable {

        private String status;
        private String accountRole;
        private String accountCreateMaintain;
        private String applicationRequestType;
        private String creditApplicationStatus;
    }

}