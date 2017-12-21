package com.soft1611.manage.model;

import java.sql.Date;

/**
 *  工资
 * @author sry
 * @date 2017/12/19
 */
public class Wage {
    private int id;
    private String account;
    private double baseWage;
    private double perfectAttend;
    private double goodAssess;
    private double attendDeduction;
    private double assessDeduction;
    private double shouldPay;
    private double tax;
    private double socialSecurity;
    private double fund;
    private double shouldDeduct;
    private double realWage;
    private Date time;

    public Wage() {
    }

    public Wage(String account, double baseWage, double perfectAttend, double goodAssess, double attendDeduction, double assessDeduction, double shouldPay, double tax, double socialSecurity, double fund, double shouldDeduct, double realWage, Date time) {

        this.account = account;
        this.baseWage = baseWage;
        this.perfectAttend = perfectAttend;
        this.goodAssess = goodAssess;
        this.attendDeduction = attendDeduction;
        this.assessDeduction = assessDeduction;
        this.shouldPay = shouldPay;
        this.tax = tax;
        this.socialSecurity = socialSecurity;
        this.fund = fund;
        this.shouldDeduct = shouldDeduct;
        this.realWage = realWage;
        this.time = time;
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

    public double getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(double baseWage) {
        this.baseWage = baseWage;
    }

    public double getPerfectAttend() {
        return perfectAttend;
    }

    public void setPerfectAttend(double perfectAttend) {
        this.perfectAttend = perfectAttend;
    }

    public double getGoodAssess() {
        return goodAssess;
    }

    public void setGoodAssess(double goodAssess) {
        this.goodAssess = goodAssess;
    }

    public double getAttendDeduction() {
        return attendDeduction;
    }

    public void setAttendDeduction(double attendDeduction) {
        this.attendDeduction = attendDeduction;
    }

    public double getAssessDeduction() {
        return assessDeduction;
    }

    public void setAssessDeduction(double assessDeduction) {
        this.assessDeduction = assessDeduction;
    }

    public double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(double socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public double getShouldDeduct() {
        return shouldDeduct;
    }

    public void setShouldDeduct(double shouldDeduct) {
        this.shouldDeduct = shouldDeduct;
    }

    public double getRealWage() {
        return realWage;
    }

    public void setRealWage(double realWage) {
        this.realWage = realWage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", baseWage=" + baseWage +
                ", perfectAttend=" + perfectAttend +
                ", goodAssess=" + goodAssess +
                ", attendDeduction=" + attendDeduction +
                ", assessDeduction=" + assessDeduction +
                ", shouldPay=" + shouldPay +
                ", tax=" + tax +
                ", socialSecurity=" + socialSecurity +
                ", fund=" + fund +
                ", shouldDeduct=" + shouldDeduct +
                ", realWage=" + realWage +
                ", time=" + time +
                '}';
    }
}
