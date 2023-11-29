package com.example.lectionusersbd;

import androidx.annotation.NonNull;

public class User {
    private String login;
    private String password;
    private String email;
    private String phone;

    public User(String login, String password, String email, String phone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return login+" "+password+" "+email+" "+phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
