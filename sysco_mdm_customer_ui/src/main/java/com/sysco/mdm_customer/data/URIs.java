package com.sysco.mdm_customer.data;

public class URIs {

    /*
     * QCenter
     * */
    public static final String URI_QCENTER_PROJECTS = "projects/name/{text}";
    public static final String URI_QCENTER_ENVS = "environments/project/{text}";
    public static final String URI_QCENTER_BUILDS_BY_PROJ_ENV = "builds/project/{project}/environment/{env}";
    public static final String URI_QCENTER_BUILD_INFO = "builds/{text}";

}
