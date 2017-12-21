package com.soft1611.manage.model;

import java.sql.Date;
import java.util.Arrays;

/**
 *   员工实体类
 * @author 朱广旭
 * @date 2017/12/19
 */
public class Staff {
    private Integer id;
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
    private String political_status;
    private Date sign_in_time;
    private String phone;
    private String email;
    private byte[] photo;

    public Staff(String account, String department,
                 String name, String sex, String nation,
                 String provice, String address, String education,
                 String duty, String title, String political_status,
                 Date sign_in_time, String phone, String email, byte[] photo) {
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
        this.political_status = political_status;
        this.sign_in_time = sign_in_time;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
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

    public String getPolitical_status() {
        return political_status;
    }

    public void setPolitical_status(String political_status) {
        this.political_status = political_status;
    }

    public Date getSign_in_time() {
        return sign_in_time;
    }

    public void setSign_in_time(Date sign_in_time) {
        this.sign_in_time = sign_in_time;
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
                "account='" + account + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", provice='" + provice + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", duty='" + duty + '\'' +
                ", title='" + title + '\'' +
                ", political_status='" + political_status + '\'' +
                ", sign_in_time=" + sign_in_time +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
