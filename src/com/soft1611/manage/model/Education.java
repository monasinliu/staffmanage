package com.soft1611.manage.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author yangmeng
 * Created by DELL on 2017/12/27.
 */
public class Education {
    private int id;
    private String project;
    private String content;
    private Timestamp time;
    private Date begin;
    private Date end;


    public Education(String project, String content, Timestamp time, Date begin, Date end) {
        this.project = project;
        this.content = content;
        this.time = time;
        this.begin = begin;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
