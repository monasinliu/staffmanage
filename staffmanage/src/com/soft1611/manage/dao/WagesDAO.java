package com.soft1611.manage.dao;

import com.soft1611.manage.model.Wages;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 朱广旭
 * @date 2017/12/20
 *    工资接口类
 */
public interface WagesDAO {
    /**
     *   获取某个员工工资信息
     * @param account
     * @return
     * @throws SQLException
     */
    List<Wages> getWages(String account) throws SQLException;
}
