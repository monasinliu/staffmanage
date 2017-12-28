package com.soft1611.manage.model;

import java.sql.Date;

/**
 * Created by lenovo on 2017/12/26.
 */
public class Assessment {
    private Integer id;
    private String account;
    private String assess_case;
    private String assess_item;
    private String assess_describe;
    private Date time;

    public Assessment( String account, String assess_case, String assess_item, String assess_describe, Date time) {
        this.account = account;
        this.assess_case = assess_case;
        this.assess_item = assess_item;
        this.assess_describe = assess_describe;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAssess_case() {
        return assess_case;
    }

    public void setAssess_case(String assess_case) {
        this.assess_case = assess_case;
    }

    public String getAssess_item() {
        return assess_item;
    }

    public void setAssess_item(String assess_item) {
        this.assess_item = assess_item;
    }

    public String getAssess_describe() {
        return assess_describe;
    }

    public void setAssess_describe(String assess_describe) {
        this.assess_describe = assess_describe;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", assess_case='" + assess_case + '\'' +
                ", assess_item='" + assess_item + '\'' +
                ", assess_describe='" + assess_describe + '\'' +
                ", time=" + time +
                '}';
    }
}
