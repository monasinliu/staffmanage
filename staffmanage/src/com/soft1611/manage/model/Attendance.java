package com.soft1611.manage.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 *
 *    出勤实体类
 */
public class Attendance {
    private Integer id;
    private String account;
    private String attend_case;
    private Timestamp attend_time;

    public Attendance(String account, String attend_case, Timestamp attend_time) {
        this.account = account;
        this.attend_case = attend_case;
        this.attend_time = attend_time;
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

    public String getAttend_case() {
        return attend_case;
    }

    public void setAttend_case(String attend_case) {
        this.attend_case = attend_case;
    }

    public Timestamp getAttend_time() {
        return attend_time;
    }

    public void setAttend_time(Timestamp attend_time) {
        this.attend_time = attend_time;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", attend_case='" + attend_case + '\'' +
                ", attend_time='" + attend_time + '\'' +
                '}';
    }
}
