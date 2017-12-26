package com.soft1611.manage.dao;

import com.soft1611.manage.model.Staff;

import java.sql.SQLException;

/**
 *
 * @author sry
 * @date 2017/12/24
 */
public interface StaffDAO {
    Staff getArchives(String account) throws SQLException;

    int updateStaff(Staff staff) throws SQLException;
}
