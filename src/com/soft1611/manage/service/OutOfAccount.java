package com.soft1611.manage.service;

/**
 * Created by mona on 2017/12/28.
 */
public class OutOfAccount {
    private int basicSalary;
    private int titleAdd1;
    private int titleAdd2;
    private int manageAdd;
    private int timeAdd;

    public OutOfAccount(int basicSalary ,int titleAdd1,int titleAdd2, int manageAdd, int timeAdd) {
        this.basicSalary = basicSalary;
        this.titleAdd1 = titleAdd1;
        this.titleAdd2 = titleAdd2;
        this.manageAdd = manageAdd;
        this.timeAdd = timeAdd;
    }

    public OutOfAccount() {
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public int getTitleAdd1() {
        return titleAdd1;
    }

    public void setTitleAdd1(int titleAdd1) {
        this.titleAdd1 = titleAdd1;
    }

    public int getTitleAdd2() {
        return titleAdd2;
    }

    public void setTitleAdd2(int titleAdd2) {
        this.titleAdd2 = titleAdd2;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "OutOfAccount{" +
                "titleAdd=" + titleAdd1 +
                ", manageAdd=" + manageAdd +
                ", timeAdd=" + timeAdd +
                '}';
    }

    public int getManageAdd() {
        return manageAdd;
    }

    public void setManageAdd(int manageAdd) {
        this.manageAdd = manageAdd;
    }

    public int getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(int timeAdd) {
        this.timeAdd = timeAdd;
    }
}
