package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.DepartmentDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Department;
import com.soft1611.manage.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/28
 */
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDAO departmentDAO = DAOFactory.getDepartmentInstance();
    @Override
    public List<Department> getAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }
}
