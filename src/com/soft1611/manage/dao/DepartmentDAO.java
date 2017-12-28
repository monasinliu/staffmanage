package com.soft1611.manage.dao;

import com.soft1611.manage.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/28
 */
public interface DepartmentDAO {
    List<Department> getAll() throws SQLException;
}
