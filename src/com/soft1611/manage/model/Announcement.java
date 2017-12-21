package com.soft1611.manage.model;

import java.sql.Timestamp;

/**
 *  通知
 * @author mona
 * @date 2017/12/19
 */
public class Announcement {
    private int id;
    private String title;
    private String content;
    private String account;
    private Timestamp time;

    public Announcement(String title, String content, String account, Timestamp time) {
        this.title = title;
        this.content = content;
        this.account = account;
        this.time = time;
    }

    public Announcement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", account='" + account + '\'' +
                ", time=" + time +
                '}';
    }
}
