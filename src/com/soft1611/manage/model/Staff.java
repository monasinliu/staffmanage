package com.soft1611.manage.model;

import java.sql.Date;
import java.util.Arrays;

/**
 *  员工信息类
 * @author mona
 * @date 2017/12/24
 */
public class Staff {
    private int id;
    private String account;
    private String department;
    private String name;
    private String sex;
    private String nation;
    private String provice;
    private String address;
    private String education;
    private String duty;
    private String title;
    private String politicalStatus;
    private Date signInTime;
    private String phone;
    private String email;
    private byte[] photo;

    public Staff(String account, String department, String name, String sex
            , String nation, String provice, String address, String education
            , String duty, String title, String politicalStatus
            , Date signInTime, String phone, String email, byte[] photo) {
        this.account = account;
        this.department = department;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.provice = provice;
        this.address = address;
        this.education = education;
        this.duty = duty;
        this.title = title;
        this.politicalStatus = politicalStatus;
        this.signInTime = signInTime;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }

    public Staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", provice='" + provice + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", duty='" + duty + '\'' +
                ", title='" + title + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", signInTime=" + signInTime +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
