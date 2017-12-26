package com.soft1611.manage.dao;

import com.soft1611.manage.model.Wage;

import java.sql.SQLException;
import java.util.List;

/**
 *  wageDAO
 * @author sry
 * @date 2017/12/25
 */
public interface WageDAO {
    /**
     * 工资表
     * @return
     * @throws SQLException
     */
    List<Wage> getAll() throws SQLException;

    int[] batchInsert(List<Wage> list) throws SQLException;

    int[] batchDelete(List<String> list) throws SQLException;

    List<Wage> queryLike(String keywords) throws SQLException;

    /**
     *   获取某个员工工资信息
     * @param account
     * @return
     * @throws SQLException
     */
    List<Wage> getWages(String account) throws SQLException;
}
