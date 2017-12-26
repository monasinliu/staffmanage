package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.WageDAO;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  WageDAO实现
 * @author sry
 * @date 2017/12/25
 */
public class WageDAOImpl implements WageDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    @Override
    public List<Wage> getAll() throws SQLException {
        String sql = "SELECT * FROM t_wages ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        List<Wage> wages = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Wage wage = new Wage(map.get("account").toString(),(double)map.get("base_wage")
                    ,(double)map.get("perfect_attend"),(double)map.get("good_assess")
                    ,(double)map.get("attend_deduction"),(double)map.get("assess_deduction")
                    ,(double)map.get("should_pay"),(double)map.get("tax"),(double)map.get("social_security")
                    ,(double)map.get("fund") ,(double)map.get("should_deduct") ,(double)map.get("real_wages")
                    ,(Date) map.get("time"));
            wages.add(wage);
        }
        return wages;
    }

    @Override
    public int[] batchInsert(List<Wage> list) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_wages VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Wage wage : list) {
            ps.setString(1, wage.getAccount());
            ps.setDouble(2,wage.getBaseWage());
            ps.setDouble(3,wage.getPerfectAttend());
            ps.setDouble(4,wage.getGoodAssess());
            ps.setDouble(5,wage.getAttendDeduction());
            ps.setDouble(6,wage.getAssessDeduction());
            ps.setDouble(7,wage.getShouldPay());
            ps.setDouble(8,wage.getTax());
            ps.setDouble(9,wage.getSocialSecurity());
            ps.setDouble(10,wage.getFund());
            ps.setDouble(11,wage.getShouldDeduct());
            ps.setDouble(12,wage.getRealWage());
            ps.setDate(13,wage.getTime());
            ps.addBatch();
        }
        // 执行批量更新操作
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public int[] batchDelete(List<String> list) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_wages WHERE account = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String account : list) {
            ps.setString(1, account);
            ps.addBatch();
        }
        // 执行批量更新操作
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public List<Wage> queryLike(String keywords) throws SQLException {
        String sql = "SELECT * FROM t_wages t1 ,t_archives t2 WHERE t1.account = t2.account and CONCAT(name,sex,time) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        List<Wage> wages = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Wage wage = new Wage(map.get("account").toString(),(double)map.get("base_wage")
                    ,(double)map.get("perfect_attend"),(double)map.get("good_assess")
                    ,(double)map.get("attend_deduction"),(double)map.get("assess_deduction")
                    ,(double)map.get("should_pay"),(double)map.get("tax"),(double)map.get("social_security")
                    ,(double)map.get("fund") ,(double)map.get("should_deduct") ,(double)map.get("real_wages")
                    ,(Date) map.get("time"));
            wages.add(wage);
        }
        return wages;
    }

    @Override
    public List<Wage> getWages(String account) throws SQLException {
        String sql = "SELECT * FROM t_wages WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{account});
        List<Wage> wagesList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Wage wages = new Wage(map.get("account").toString(),
                    (Double) map.get("base_wage"),
                    (Double) map.get("perfect_attend"),
                    (Double) map.get("good_assess"),
                    (Double) map.get("attend_deduction"),
                    (Double) map.get("assess_deduction"),
                    (Double) map.get("should_pay"),
                    (Double) map.get("tax"),
                    (Double) map.get("social_security"),
                    (Double) map.get("fund"),
                    (Double) map.get("should_deduct"),
                    (Double) map.get("real_wages"),
                    (Date) map.get("time"));

            //给id设置值
            wages.setId((Integer) map.get("id"));
            wagesList.add(wages);
        }
        return wagesList;
    }
}
