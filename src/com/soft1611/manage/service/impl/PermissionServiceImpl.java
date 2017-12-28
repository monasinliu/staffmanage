package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.PermissionsDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.service.PermissionService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sry
 * @date 2017/12/28
 */
public class PermissionServiceImpl implements PermissionService {
    PermissionsDAO permissionsDAO = DAOFactory.getPermissionsDAOInstance();
    @Override
    public Map<String, List<String>> getAllPermission() {
        Map<String, List<String>> map = null;
        try {
            map = permissionsDAO.getAllPermission();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
