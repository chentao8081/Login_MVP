package com.tonyapp.login_mvp.Bean;

/**
 * Created by 涛 on 2016/8/8 0008.
 */
public class User {
    private String tFirstName;
    private String tLastName;
    public User (String firstName, String lastName) {
        this .tFirstName = firstName;
        this .tLastName = lastName;
    }
    public String getFirstName() {
        return tFirstName;
    }
    public String getLastName() {
        return tLastName;
    }
}
