package com.soft1611.manage.dao;

import com.soft1611.manage.model.Assessment;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2017/12/26.
 */
public interface AssessmentDAO {
    int[] batchDelete(List<Integer> ids) throws SQLException;

    List<Assessment> getAssessment(String account) throws SQLException;

    List<Assessment> getAll() throws SQLException;

    List<Assessment> queryLike(String keywords) throws SQLException;

    List<Assessment> queryFilter(String condition) throws SQLException;

    int insert(Assessment assessment) throws SQLException;

    int update(Assessment assessment) throws SQLException;

    Assessment getA(int id) throws SQLException;
}
