package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.AttendanceDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.service.AttendanceManageService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/27
 */
public class AttendanceManageServiceImpl implements AttendanceManageService {
    AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();
    @Override
    public int[] batchInsert(List<Attendance> list) {
        int[] n = null;
        try {
            n = attendanceDAO.batchInsert(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Attendance> getAttendance(String account) {
        List<Attendance>attendances=null;
        try {
            attendances=attendanceDAO.getAttendance(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    @Override
    public List<Attendance> queryFilter(String condition) {
        List<Attendance> attendances = null;
        try {
            attendances = attendanceDAO.queryFilter(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }
}
