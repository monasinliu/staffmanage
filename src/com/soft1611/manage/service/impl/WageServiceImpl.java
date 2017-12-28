package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.WageDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.service.OutOfAccount;
import com.soft1611.manage.service.WageService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * WageService实现
 *
 * @author mona
 * @date 2017/12/25
 */
public class WageServiceImpl implements WageService {
    WageDAO wageDAO = DAOFactory.getWageDAOInstance();

    @Override
    public List<Wage> readWage() {
        List<Wage> wageList = null;
        try {
            wageList = wageDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wageList;
    }

    @Override
    public int[] batchDelete(List<String> strings) {
        int[] n = null;
        try {
            n = wageDAO.batchDelete(strings);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Wage> queryLike(String keywords) {
        List<Wage> wageList = null;
        try {
            wageList = wageDAO.queryLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wageList;
    }

    @Override
    public double calNetSalary(double salary, int insurance, int basicWage) {
        //应纳个人所得税税额=应纳税所得额×适用税率-速算扣除数
        //应纳税所得额=收入-保险-3000
        int taxIncome;
        taxIncome = (new   Double(salary)).intValue() - insurance - basicWage;
        double tax = .0d;
        if (taxIncome <= 1500) {
            tax = taxIncome * 0.03d;
        } else if (taxIncome > 1500 && taxIncome <= 4500) {
            tax = taxIncome * 0.1d - 105;
        } else if (taxIncome > 4500 && taxIncome <= 9000) {
            tax = taxIncome * 0.2d - 555;
        } else if (taxIncome > 9000 && taxIncome <= 35000) {
            tax = taxIncome * 0.25d - 1005;
        } else if (taxIncome > 35000 && taxIncome <= 55000) {
            tax = taxIncome * 0.3d - 2775;
        } else if (taxIncome > 55000 && taxIncome <= 80000) {
            tax = taxIncome * 0.35d - 5505;
        } else if (taxIncome > 80000) {
            tax = taxIncome * 0.45d - 13505;
        }

        return tax;
    }

    @Override
    public double calBasicSalary(OutOfAccount outOfAccount, Staff staff) {
        double salary = outOfAccount.getBasicSalary();
        if (staff.getTitle().equals("经理")) {
            salary += outOfAccount.getManageAdd();
        }
        if (staff.getTitle().equals("中级")) {
            salary += outOfAccount.getTitleAdd1();
        } else if (staff.getTitle().equals("高级")) {
            salary += outOfAccount.getTitleAdd2();
        }
        int add = getYear(staff.getSignInTime()) / 5;
        if (add!=0){
            salary += outOfAccount.getTimeAdd()*add;
        }
        return salary;
    }

    @Override
    public int[] batchInsert(List<Wage> list) {
        int[] n = null;
        try {
            n = wageDAO.batchInsert(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    private int getYear(Date signInTime) {
        java.util.Date date = new java.util.Date(signInTime.getTime());
        long timeMillion = new java.util.Date().getTime() - date.getTime();
        return (int) (timeMillion / (365*24 * 60 * 60 * 1000));
    }
}
