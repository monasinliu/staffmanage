package com.soft1611.manage.model;


import java.sql.Timestamp;

/**
 *
 * @author honglei
 * @date 2017/12/20
 */
public class Advice {
    private Integer id;
    private String anonymity;//是否匿名
    private String account;//员工号
    private String content;//建议内容
    private Timestamp time;//建议时间

    public Advice( String anonymity, String account, String content, Timestamp time) {
        this.anonymity = anonymity;
        this.account = account;
        this.content = content;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(String anonymity) {
        this.anonymity = anonymity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", anonymity='" + anonymity + '\'' +
                ", account='" + account + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
