package com.cbnuke.testeverything.apimodel;

/**
 * Created by Amnart on 11/2/2559.
 */
public class ApiLogin {
    private String userEmail;
    private String userPassword;

    public ApiLogin(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
