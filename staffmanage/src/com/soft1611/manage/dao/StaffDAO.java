package com.soft1611.manage.dao;

import com.soft1611.manage.model.Staff;

import java.sql.SQLException;

/**
 *
 * @author 朱广旭
 * @date 2017/12/19
 *   员工类
 */
public interface StaffDAO {
    /**
     * 根据员工账号查询员工
     *
     * @param account
     * @return
     * @throws SQLException
     */
    Staff get(String account) throws SQLException;

}
