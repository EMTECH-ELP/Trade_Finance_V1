package com.encode.fresh.utils.HttpInterceptor;

public class UserDetailsRequestContext {

    private static ThreadLocal<String> currentUserDetails = new InheritableThreadLocal<>();

    public static String getCurrentUserDetails() {
        return currentUserDetails.get();
    }

    public static void setCurrentUserDetails(String userDetails) {
        currentUserDetails.set(userDetails);
    }

    public static void clear() {
        currentUserDetails.set(null);
    }
}