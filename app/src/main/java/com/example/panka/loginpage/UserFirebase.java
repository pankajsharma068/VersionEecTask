package com.example.panka.loginpage;

/**
 * Created by panka on 28-03-2021.
 */

public class UserFirebase {
    String username, name, password, email, mobile;

    public UserFirebase() {
    }

    public UserFirebase(String college, String name, String password, String email, String mobile) {
        this.username=username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String college) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
