package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.AssessmentDAO;
import com.soft1611.manage.model.Assessment;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author honglei
 * @date 2017/12/26
 */
public class AssessmentDAOImpl implements AssessmentDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public int[] batchDelete(List<Integer> ids) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_assessment WHERE id = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Integer id : ids) {
            ps.setInt(1, id);
            ps.addBatch();
        }
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public List<Assessment> getAssessment(String account) throws SQLException {
        String sql = "SELECT * FROM t_assessment WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{account});
        return getAssessmentList(list);
    }




    @Override
    public List<Assessment> getAll() throws SQLException {
        String sql = "SELECT * FROM t_assessment";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAssessmentList(list);
    }

    @Override
    public List<Assessment> queryLike(String keywords) throws SQLException {
        String sql = "SELECT * FROM t_assessment WHERE CONCAT(account,assess_case,assess_item) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getAssessmentList(list);
    }

    @Override
    public List<Assessment> queryFilter(String condition) throws SQLException {
        String sql = "SELECT * FROM t_assessment " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAssessmentList(list);
    }


    @Override
    public int insert(Assessment assessment) throws SQLException {
        String sql = "INSERT INTO t_assessment VALUES (null,?,?,?,?,?) ";
        Object[] params = {assessment.getAccount(), assessment.getAssess_case(),assessment.getAssess_item(),
                assessment.getAssess_describe(),assessment.getTime()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int update(Assessment assessment) throws SQLException {
        String sql =  "UPDATE t_assessment SET assess_case = ?,assess_item = ?,assess_describe = ?,time = ? WHERE account = ?";
        Object[] params ={assessment.getAssess_case(),assessment.getAssess_item(),assessment.getAssess_describe()
                ,assessment.getTime(),assessment.getAccount()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public Assessment getA(int id) throws SQLException {
        String sql = "SELECT * FROM t_assessment WHERE id = ?";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{id});
        Assessment rp = null;
        if (map.size()!= 0 ){
            rp = new Assessment(map.get("account").toString(),map.get("assess_case").toString()
                    ,map.get("assess_item").toString(),map.get("assess_describe").toString()
                    ,(Date)map.get("time"));
            rp.setId(id);
        }
        return rp;
    }

    /**
     * 封装一个将List<Object>集合转换成奖惩集合的方法
     *
     * @param list
     * @return
     */
    private List<Assessment> getAssessmentList(List<Object> list) {
        List<Assessment> assessmentList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Assessment assessment = new Assessment( map.get("account").toString(),
                    map.get("assess_case").toString(), map.get("assess_item").toString(),
                    map.get("assess_describe").toString(),(Date) map.get("time"));
            //给id设置值

            assessment.setId((Integer) map.get("id"));
            assessmentList.add(assessment);
        }
        return assessmentList;
    }
}
