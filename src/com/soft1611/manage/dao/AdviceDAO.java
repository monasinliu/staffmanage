package com.soft1611.manage.dao;

import com.soft1611.manage.model.Advice;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author honglei
 * @date 2017/12/19
 */
public interface AdviceDAO {
    int[] batchDelete(List<Integer> ids) throws SQLException;

    List<Advice> getAdvice(String account) throws SQLException;

    List<Advice> getAll() throws SQLException;

    List<Advice> queryLike(String keywords) throws SQLException;

    List<Advice> queryFilter(String condition) throws SQLException;

    int insert(Advice advice) throws SQLException;
}
