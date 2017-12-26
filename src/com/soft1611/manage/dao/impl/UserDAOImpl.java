package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.UserDAO;
import com.soft1611.manage.model.User;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.SQLException;
import java.util.Map;

/**
 *  用户接口实现类
 * @author sry
 * @date 2017/12/20
 */
public class UserDAOImpl implements UserDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public User getUser(String account) throws SQLException {
        String sql = "SELECT * FROM t_user WHERE account = ? ";
        Map<String,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{account});
        if (map.size()!=0){
            User user = new User(map.get("account").toString(),map.get("password").toString(),
                    (byte[]) map.get("profile"));
            return user;
        }else {
            return null;
        }
    }

    @Override
    public int update(User user) throws SQLException {
        String sql = "UPDATE t_user SET password = ? , profile = ?  WHERE account = ? ";
        Object[] params = {user.getPassword(),user.getProfile(),user.getAccount()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }
}
