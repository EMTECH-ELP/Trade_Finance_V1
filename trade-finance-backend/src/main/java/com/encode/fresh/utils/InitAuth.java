package com.encode.fresh.utils;//package ke.co.waterquality.backend.utils;
//
//import com.google.gson.Gson;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class InitAuth {
//
//    public List<Privilege> getAllPriviledges(){
//        String json = "{ \"privileges\": [\n" +
//                "        {\n" +
//                "            \"code\": 0,\n" +
//                "            \"name\": \"DASHBOARD\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 1,\n" +
//                "            \"name\": \"CONFIGURATIONS\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 2,\n" +
//                "            \"name\": \"CHARGE PARAMS\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 3,\n" +
//                "            \"name\": \"INTEREST MAINTENANCE\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 4,\n" +
//                "            \"name\": \"PRODUCTS\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 5,\n" +
//                "            \"name\": \"MEMBERSHIP MANAGEMENT\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 6,\n" +
//                "            \"name\": \"ACCOUNTS MANAGEMENT\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 7,\n" +
//                "            \"name\": \"COLLATERALS MANAGEMENT\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 8,\n" +
//                "            \"name\": \"TRANSACTION MAINTENANCE\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 9,\n" +
//                "            \"name\": \"SHARE CAPITAL MAINTAINANCE\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 10,\n" +
//                "            \"name\": \"EOD MANAGEMENT\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 11,\n" +
//                "            \"name\": \"REPORTS\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 12,\n" +
//                "            \"name\": \"ACCESS MANAGEMENT\",\n" +
//                "            \"selected\": true\n" +
//                "        }\n" +
//                "    ]}";
//        List<Privilege> privilegeList = new ArrayList<>();
//        JSONObject jo = new JSONObject(json);
//        JSONArray ja = jo.getJSONArray("privileges");
//        for (Object obj : ja) {
//            JSONObject jo2 = new JSONObject(obj.toString());
//            Privilege privilege = new Gson().fromJson(jo2.toString(),Privilege.class);
//            privilegeList.add(privilege);
//        }
//        return privilegeList;
//    }
//
//    public List<Basicactions> getAllBasicActions(){
//        List<Basicactions> basicactionsList = new ArrayList<>();
//
//        String strbasicactions = "{    \"basicActions\": [\n" +
//                "        {\n" +
//                "            \"code\": 0,\n" +
//                "            \"name\": \"ADD\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 1,\n" +
//                "            \"name\": \"ENTER\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 2,\n" +
//                "            \"name\": \"POST\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 3,\n" +
//                "            \"name\": \"MODIFY\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 4,\n" +
//                "            \"name\": \"INQUIRE\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 5,\n" +
//                "            \"name\": \"VERIFY\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 6,\n" +
//                "            \"name\": \"DELETE\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 7,\n" +
//                "            \"name\": \"DISBURSE\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 8,\n" +
//                "            \"name\": \"ATTACH\",\n" +
//                "            \"selected\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"code\": 9,\n" +
//                "            \"name\": \"DETACH\",\n" +
//                "            \"selected\": true\n" +
//                "        }\n" +
//                "    ]}";
//        JSONObject jo = new JSONObject(strbasicactions);
//        JSONArray ja = jo.getJSONArray("basicActions");
//        for (Object obj : ja) {
//            JSONObject jo2 = new JSONObject(obj.toString());
//            Basicactions basicActions = new Gson().fromJson(jo2.toString(),Basicactions.class);
//            basicactionsList.add(basicActions);
//        }
//        return basicactionsList;
//    }
//}
