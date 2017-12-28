package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.AdviceDAO;
import com.soft1611.manage.model.Advice;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author honglei
 * @date 2017/12/20
 */
public class AdviceDAOImpl implements AdviceDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public int[] batchDelete(List<Integer> ids) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_advice WHERE id = ? ";
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
    public List<Advice> getAdvice(String account) throws SQLException {
        String sql = "SELECT * FROM t_advice WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{account});
        return getAdviceList(list);
    }




    @Override
    public List<Advice> getAll() throws SQLException {
        String sql = "SELECT * FROM t_advice";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAdviceList(list);
    }

    @Override
    public List<Advice> queryLike(String keywords) throws SQLException {
        String sql = "SELECT * FROM t_advice WHERE CONCAT(anonymity,account,content) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getAdviceList(list);
    }

    @Override
    public List<Advice> queryFilter(String condition) throws SQLException {
        String sql = "SELECT * FROM t_advice " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAdviceList(list);
    }


    @Override
    public int insert(Advice advice) throws SQLException {
        String sql = "INSERT INTO t_advice VALUES (null,?,?,?,?) ";
        Object[] params = {advice.getAccount(),advice.getAnonymity(),advice.getContent(),advice.getTime()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    /**
     * 封装一个将List<Object>集合转换成奖惩集合的方法
     *
     * @param list
     * @return
     */
    private List<Advice> getAdviceList(List<Object> list) {
        List<Advice> adviceList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Advice advice = new Advice( map.get("anonymity").toString(),
                    map.get("account").toString(), map.get("content").toString(),
                   (Timestamp) map.get("time"));
            //给id设置值

            advice.setId((Integer) map.get("id"));
            adviceList.add(advice);
        }
        return adviceList;
    }
}
