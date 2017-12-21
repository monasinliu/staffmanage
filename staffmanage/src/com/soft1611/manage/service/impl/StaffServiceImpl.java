package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.AttendanceDAO;
import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.dao.WagesDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wages;
import com.soft1611.manage.service.StaffService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 朱广旭 on 2017/12/20.
 */
public class StaffServiceImpl implements StaffService{
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
    private WagesDAO wagesDAO = DAOFactory.getWagesDAOInstance();
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();

    @Override
    public Staff getStaff(String account) {
        Staff staff = null;
        try{
            staff = staffDAO.get(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public List<Attendance> getAttendance(String account) {
        List<Attendance> list = null;
        try{
            list = attendanceDAO.getAttendance(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Wages> getWages(String account) {
        List<Wages> list = null;
        try{
            list = wagesDAO.getWages(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
