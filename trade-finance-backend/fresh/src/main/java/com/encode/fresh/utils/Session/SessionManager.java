package com.encode.fresh.utils.Session;//package ke.co.waterquality.backend.utils.Session;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//
//@Component
//@Slf4j
//public class SessionManager {
//    HashMap<String, String> map = new HashMap<>();
//
//    public EntityResponse saveSession(String key, String value){
//        EntityResponse response = new EntityResponse();
//        if (map.containsKey(key)){
//            map.replace(key, value);
//            log.info("Session Exist");
//            response.setMessage("Found Active Session for this user!");
//            response.setStatusCode(HttpStatus.OK.value());
//            response.setEntity("");
//            return response;
//        }else{
//            map.put(key, value);
//            response.setMessage("Signed in successfull!");
//            response.setStatusCode(HttpStatus.OK.value());
//            response.setEntity("");
//            return response;
//        }
//    }
//    public EntityResponse clearSession(String key){
//        EntityResponse response = new EntityResponse();
//        if (map.containsKey(key)){
//            map.remove(key);
//            response.setMessage("Session removed!");
//            response.setStatusCode(HttpStatus.OK.value());
//            response.setEntity("");
//            return response;
//        }else{
//            response.setMessage("No session Active Found for this user!");
//            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//            response.setEntity("");
//            return response;
//        }
//    }
//    public EntityResponse getSession(String key){
//        EntityResponse response = new EntityResponse();
//        if (map.containsKey(key)){
//            response.setMessage("Session Found!");
//            response.setStatusCode(HttpStatus.OK.value());
//            response.setEntity(map.get(key));
//            return response;
//        }else{
//            response.setMessage("No session Active Found for this user!");
//            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//            response.setEntity("");
//            return response;
//        }
//    }
//    public EntityResponse getActiveSession(){
//        EntityResponse response = new EntityResponse();
//        if (map.isEmpty()){
//            response.setMessage("No session Active Found!");
//            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//            response.setEntity("");
//            return response;
//        }else{
//            response.setMessage("Session Found!");
//            response.setStatusCode(HttpStatus.OK.value());
//            response.setEntity(map);
//            return response;
//        }
//    }
//
//}
