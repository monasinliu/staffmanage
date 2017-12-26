package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.WageDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.service.WageService;

import java.sql.SQLException;
import java.util.List;

/**
 * WageService实现
 * @author mona
 * @date 2017/12/25
 */
public class WageServiceImpl implements WageService{
    WageDAO wageDAO = DAOFactory.getWageDAOInstance();
    @Override
    public List<Wage> readWage()  {
        List<Wage> wageList = null;
        try {
           wageList  = wageDAO.getAll();
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
}
