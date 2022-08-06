package com.sysco.mdm_customer.functions.common;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.URIs;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.Headers;
import com.syscolab.qe.core.common.SyscoLabCoreConstants;
import com.syscolab.qe.core.util.qcenter.QCenterUtil;
import com.sysco.qeutils.utils.RequestMethods;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class QcenterCommonFunctions {

    public static List<Map<String, String>> getQCenterBuildList() throws JSONException {
        String projectID = QCenterUtil.getProjectID(Constants.TEST_PROJECT);
        String envID = QCenterUtil.getEnvID(Integer.valueOf(projectID), Constants.TEST_ENV);

        String uri = URIs.URI_QCENTER_BUILDS_BY_PROJ_ENV.replace("{project}", projectID).replace("{env}", envID);
        Response response = RestUtil.send(Headers.getAuthorizationHeader(SyscoLabCoreConstants.SYSCO_QCENTER_TOKEN), "", uri, RequestMethods.REQ_METHOD_GET);

        JSONArray jsonArray = new JSONArray(response.getBody().asString());
        List<Map<String, String>> buildInfoList = new ArrayList<>();
        Map<String, String> buildInfo;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            buildInfo = new HashMap<>();
            for (Iterator<?> it = jsonObject.keys(); it.hasNext(); ) {
                String key = it.next().toString();
                String value = jsonObject.getString(key);
                buildInfo.put(key, value);
            }
            buildInfoList.add(i, buildInfo);
        }
        return buildInfoList;
    }

    public static Map<String, String> getBuildInfoByName(List<Map<String, String>> buildList, String buildName) {
        for (Map<String, String> stringStringMap : buildList) {
            if (stringStringMap.get("cake_release").equals(buildName)) {
                return stringStringMap;
            }
        }
        return new HashMap<>();
    }

}
