package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author 朱广旭
 * @date 2017/12/19
 */
public class StaffDAOImpl implements StaffDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Staff get(String account) throws SQLException {
        String sql = "SELECT * FROM t_archives WHERE account = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{account});
        if(map.size() != 0){
            Staff staff = new Staff(map.get("account").toString(),
                    map.get("department").toString(),
                    map.get("name").toString(),
                    map.get("sex").toString(),
                    map.get("nation").toString(),
                    map.get("provice").toString(),
                    map.get("address").toString(),
                    map.get("education").toString(),
                    map.get("duty").toString(),
                    map.get("title").toString(),
                    map.get("political_status").toString(),
                    (Date) map.get("sign_in_time"),
                    map.get("phone").toString(),
                    map.get("email").toString(),
                    (byte[]) map.get("photo"));
            return staff;
        }else{
            return null;
        }
    }
}
