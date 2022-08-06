package com.sysco.mdm_customer.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.syscolab.qe.core.common.LoggerUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JacksonUtil {

    public static <T> List<T> getObjectArray(String response, Class<?> c) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            TypeFactory typeFactory = mapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, c);
            return (List)mapper.readValue(response, collectionType);
        } catch (IOException var5) {
            LoggerUtil.logERROR(var5.getMessage(), var5);
            return Collections.emptyList();
        }
    }

    public static String convertObjectToJsonString(Object obj) {
        try {
            return (new ObjectMapper()).configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).writerFor(obj.getClass()).writeValueAsString(obj);
        } catch (IOException var2) {
            LoggerUtil.logERROR(var2.getMessage(), var2);
            return "";
        }
    }

    JacksonUtil() {
    }
}
