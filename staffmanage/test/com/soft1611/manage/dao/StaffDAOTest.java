package com.soft1611.manage.dao;

import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 朱广旭 on 2017/12/20.
 */
public class StaffDAOTest {
    private StaffDAO staffDAO;

    @Before
    public void setUp() throws Exception {
         staffDAO = DAOFactory.getStaffDAOInstance();
    }

    @Test
    public void get() throws Exception {
        Staff staff = staffDAO.get("20010101");
        System.out.println(staff);
    }

}