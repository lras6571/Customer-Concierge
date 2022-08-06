package com.sysco.mdm_customer.models.request;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class GetLoginRequest implements Serializable {

    private String username;
    private String password;

}