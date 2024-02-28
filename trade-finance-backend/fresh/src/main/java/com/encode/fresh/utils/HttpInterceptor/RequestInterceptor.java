package com.encode.fresh.utils.HttpInterceptor;//package ke.co.waterquality.backend.utils.HttpInterceptor;//package com.emtechhouse.Utils.HttpInterceptor;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class RequestInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object object) throws Exception {
//        System.out.println("In preHandle we are Intercepting the Request");
//        System.out.println("____________________________________________");
//        String requestURI = request.getRequestURI();
//        String  userName = request.getHeader("userName");
////        String  entityId = request.getHeader("entityId");
////        String headerAuth = request.getHeader("accessToken");
//        System.out.println("RequestURI::" + requestURI +" || Search for USERNAME  :: " + userName);
////        System.out.println("RequestURI::" + requestURI +" || Search for ENTITY ID  :: " + entityId);
////        System.out.println("HeAder  :: " + headerAuth);
//        System.out.println("____________________________________________");
//        UserRequestContext.setCurrentUser(userName);
////        EntityRequestContext.setCurrentEntityId(entityId);
////        AccessTokenContext.setCurrentAccessToken(headerAuth);
//        return true;
//    }
//
//    @Override
//    public void postHandle(
//            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
//            throws Exception {
//        UserRequestContext.clear();
//    }
//
//}
