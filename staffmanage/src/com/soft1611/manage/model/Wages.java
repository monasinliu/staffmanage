package com.soft1611.manage.model;

import java.sql.Date;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 *
 *    工资实体类
 */
public class Wages {
    private Integer id;
    private String account;
    private Double base_wage;
    private Double perfect_attend;
    private Double good_assess;
    private Double attend_deduction;
    private Double assess_deduction;
    private Double should_pay;
    private Double tax;
    private Double social_security;
    private Double fund;
    private Double should_deduct;
    private Double real_wages;
    private Date time;

    public Wages(String account, Double base_wage,
                 Double perfect_attend, Double good_assess,
                 Double attend_deduction, Double assess_deduction,
                 Double should_pay, Double tax, Double social_security,
                 Double fund, Double should_deduct, Double real_wages,
                 Date time) {
        this.account = account;
        this.base_wage = base_wage;
        this.perfect_attend = perfect_attend;
        this.good_assess = good_assess;
        this.attend_deduction = attend_deduction;
        this.assess_deduction = assess_deduction;
        this.should_pay = should_pay;
        this.tax = tax;
        this.social_security = social_security;
        this.fund = fund;
        this.should_deduct = should_deduct;
        this.real_wages = real_wages;
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

    public Double getBase_wage() {
        return base_wage;
    }

    public void setBase_wage(Double base_wage) {
        this.base_wage = base_wage;
    }

    public Double getPerfect_attend() {
        return perfect_attend;
    }

    public void setPerfect_attend(Double perfect_attend) {
        this.perfect_attend = perfect_attend;
    }

    public Double getGood_assess() {
        return good_assess;
    }

    public void setGood_assess(Double good_assess) {
        this.good_assess = good_assess;
    }

    public Double getAttend_deduction() {
        return attend_deduction;
    }

    public void setAttend_deduction(Double attend_deduction) {
        this.attend_deduction = attend_deduction;
    }

    public Double getAssess_deduction() {
        return assess_deduction;
    }

    public void setAssess_deduction(Double assess_deduction) {
        this.assess_deduction = assess_deduction;
    }

    public Double getShould_pay() {
        return should_pay;
    }

    public void setShould_pay(Double should_pay) {
        this.should_pay = should_pay;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getSocial_security() {
        return social_security;
    }

    public void setSocial_security(Double social_security) {
        this.social_security = social_security;
    }

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }

    public Double getShould_deduct() {
        return should_deduct;
    }

    public void setShould_deduct(Double should_deduct) {
        this.should_deduct = should_deduct;
    }

    public Double getReal_wages() {
        return real_wages;
    }

    public void setReal_wages(Double real_wages) {
        this.real_wages = real_wages;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Wages{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", base_wage=" + base_wage +
                ", perfect_attend=" + perfect_attend +
                ", good_assess=" + good_assess +
                ", attend_deduction=" + attend_deduction +
                ", assess_deduction=" + assess_deduction +
                ", should_pay=" + should_pay +
                ", tax=" + tax +
                ", social_security=" + social_security +
                ", fund=" + fund +
                ", should_deduct=" + should_deduct +
                ", real_wages=" + real_wages +
                ", time=" + time +
                '}';
    }
}
