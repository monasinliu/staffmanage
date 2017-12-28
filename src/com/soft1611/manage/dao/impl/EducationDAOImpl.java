package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.EducationDAO;
import com.soft1611.manage.model.Education;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ym
 * @date 2017/12/27
 */
public class EducationDAOImpl implements EducationDAO{

    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Education get(int id) throws SQLException {
       String sql = " SELECT * FROM t_education WHERE id = ? " ;
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{id});
        if (map.size() != 0) {
            Education education = new Education(
                    map.get("project").toString(),
                    map.get("content").toString(),
                    (Timestamp) map.get("time"),
                    (Date)map.get("begin"),
                    (Date)map.get("end")
            );
            education.setId(id);
            return education;
        } else {
            return null;
        }
    }

    @Override
    public List<Education> getAll() throws SQLException {
        String sql = "SELECT * FROM t_education ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getEducationList(list);
    }

    @Override
    public int insert(Education education) throws SQLException {
        String sql = "INSERT INTO t_education VALUES (null,?,?,?,?,?,?) ";
        Object[] params = { education.getId(),education.getProject(),education.getContent(),education.getTime(),education.getBegin(),education.getEnd()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    private List<Education> getEducationList (List < Object > list) {
        List<Education> educations = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
           Education education = new Education(
                   map.get("project").toString(),
                   map.get("content").toString(),
                   (Timestamp) map.get("time"),
                   (Date)map.get("begin"),
                   (Date)map.get("end")
            );
            educations.add(education);
        }
        return educations;
    }

}
