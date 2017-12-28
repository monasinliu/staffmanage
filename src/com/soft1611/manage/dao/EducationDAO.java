package com.soft1611.manage.dao;

import com.soft1611.manage.model.Education;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yangmeng
 * Created by DELL on 2017/12/27.
 */
public interface EducationDAO {

    /**
     * 获取一个培训信息
     * @return
     * @throws SQLException
     */
   Education get(int id) throws SQLException;

    /**
     * 获取所有培训信息
     * @return
     * @throws SQLException
     */
    List<Education> getAll() throws SQLException;


    /**
     * 新增一个培训信息
     * @param education
     * @return
     * @throws SQLException
     */
    int insert(Education education) throws SQLException;
}
