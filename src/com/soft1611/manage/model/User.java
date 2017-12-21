package com.soft1611.manage.model;

import java.util.Arrays;

/**
 *  用户
 * @author sry
 * @date 2017/12/19
 */
public class User {
    private String account;
    private String password;
    private byte[] profile;

    public User() {
    }

    public User(String account, String password, byte[] profile) {

        this.account = account;
        this.password = password;
        this.profile = profile;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + Arrays.toString(profile) +
                '}';
    }
}
