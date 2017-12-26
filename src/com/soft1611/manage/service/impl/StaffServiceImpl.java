package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.AttendanceDAO;
import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.dao.WageDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.service.StaffService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 朱广旭 on 2017/12/20.
 */
public class StaffServiceImpl implements StaffService {
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
    private WageDAO wageDAO = DAOFactory.getWageDAOInstance();
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();

    @Override
    public Staff getStaff(String account) {
        Staff staff = null;
        try{
            staff = staffDAO.getArchives(account);
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
    public List<Wage> getWages(String account) {
        List<Wage> list = null;
        try{
            list = wageDAO.getWages(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        boolean flag = false;
        int n = 0;
        try{
            n = staffDAO.updateStaff(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(n == 1){
            flag = true;
        }
        return flag;
    }
}
