package com.soft1611.manage.dao;

import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Wages;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 朱广旭 on 2017/12/20.
 */
public class WagesDAOTest {
    private WagesDAO wagesDAO;

    @Before
    public void setUp() throws Exception {
        wagesDAO = DAOFactory.getWagesDAOInstance();

    }

    @Test
    public void getWages() throws Exception {
        List<Wages> list = wagesDAO.getWages("20010101");
        list.forEach(wages -> System.out.println(wages));

    }

}