package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.WagesDAO;
import com.soft1611.manage.model.Wages;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 朱广旭 on 2017/12/20.
 */
public class WagesDAOImpl implements WagesDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<Wages> getWages(String account) throws SQLException {
        String sql = "SELECT * FROM t_wages WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{account});
        List<Wages> wagesList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Wages wages = new Wages(map.get("account").toString(),
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
