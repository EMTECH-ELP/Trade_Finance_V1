package com.encode.fresh.utils.HttpInterceptor;
public class UserRequestContext {
    private static ThreadLocal<String> currentUser = new InheritableThreadLocal<>();

    public static String getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(String tenant) {
        currentUser.set(tenant);
    }

    public static void clear() {
        currentUser.set(null);
    }
}
