package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.DepartmentDAO;
import com.soft1611.manage.model.Department;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sry
 * @date 2017/12/28
 */
public class DepartmentDAOImpl implements DepartmentDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    @Override
    public List<Department> getAll() throws SQLException {
        String sql = "SELECT * FROM t_department ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        List<Department> departmentList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Department department = new Department(map.get("name").toString());
            departmentList.add(department);
        }
        return departmentList;
    }
}
