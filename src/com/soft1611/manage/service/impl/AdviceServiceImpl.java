package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.AdviceDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Advice;
import com.soft1611.manage.service.AdviceService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class AdviceServiceImpl implements AdviceService {
    private AdviceDAO adviceDAO= DAOFactory.getAdviceDAOInstance();
    @Override
    public List<Advice> getAdvice(String account) {
        List<Advice>advices=null;
        try {
            advices=adviceDAO.getAdvice(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Advice> queryFilter(String condition) {
        List<Advice> advices = null;
        try {
            advices= adviceDAO.queryFilter(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advices;
    }

    @Override
    public int insert(Advice advice) {
        int n = 0 ;
        try {
            n = adviceDAO.insert(advice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}


