package com.soft1611.manage.dao;

import com.soft1611.manage.model.Staff;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/24
 */
public interface StaffDAO {
    Staff getArchives(String account) throws SQLException;

    int updateStaff(Staff staff) throws SQLException;

    List<Staff> queryFilter(String condition) throws SQLException;

    List<Staff> getAll() throws SQLException;

    int insert(Staff staff) throws SQLException;

    int[] batchInsert(List<Staff> staffs) throws SQLException;

    int[] batchDelete(List<String> ids) throws SQLException;

    List<Staff> queryLike(String keywords) throws SQLException;
}
