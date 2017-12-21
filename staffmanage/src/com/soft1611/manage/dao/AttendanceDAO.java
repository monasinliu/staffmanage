package com.soft1611.manage.dao;

import com.soft1611.manage.model.Attendance;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 *
 *   出勤信息接口
 */
public interface AttendanceDAO {
    /**
     *  查询某个员工的出勤信息
     *
     * @param account
     * @return
     * @throws SQLException
     */
    List<Attendance> getAttendance(String account) throws SQLException;
}
