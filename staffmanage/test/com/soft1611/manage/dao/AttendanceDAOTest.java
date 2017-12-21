package com.soft1611.manage.dao;

import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Attendance;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 朱广旭 on 2017/12/20.
 */
public class AttendanceDAOTest {
    private AttendanceDAO attendanceDAO;

    @Before
    public void setUp() throws Exception {
        attendanceDAO = DAOFactory.getAttendanceDAOInstance();
    }

    @Test
    public void getAttendance() throws Exception {
        List<Attendance> list = attendanceDAO.getAttendance("20010101");
        list.forEach(attendance -> System.out.println(attendance));
    }

}