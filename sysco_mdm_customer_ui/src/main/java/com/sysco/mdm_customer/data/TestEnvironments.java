package com.sysco.mdm_customer.data;

public enum TestEnvironments {
    DEV_ENVIRONMENT("DEV"),
    STG_ENVIRONMENT("STG");

    private final String environment;

    TestEnvironments(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }
}
