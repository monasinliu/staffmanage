package com.soft1611.manage.dao;

import com.soft1611.manage.model.User;

import java.sql.SQLException;

/**
 *  用户接口
 * @author sry
 * @date 2017/12/18
 */
public interface UserDAO {
    /**
     * 获取用户信息
     * @param account
     * @return
     * @throws SQLException
     */
    User getUser(String account) throws SQLException;

    int update(User user) throws SQLException;
}
