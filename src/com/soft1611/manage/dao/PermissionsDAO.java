package com.soft1611.manage.dao;

import com.soft1611.manage.model.Permissions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *  权限实现接口
 * @author mona
 * @date 2017/12/20
 */
public interface PermissionsDAO {

    /**
     * 获取权限
     * @param userID
     * @return
     * @throws SQLException
     */
    Map<String,List<Permissions>> getPermissions(String userID) throws SQLException;
}
