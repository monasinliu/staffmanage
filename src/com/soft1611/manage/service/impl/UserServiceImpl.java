package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.PermissionsDAO;
import com.soft1611.manage.dao.UserDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Permissions;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mona
 * @date 2017/12/20
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = DAOFactory.getUserDAOInstance();
    private PermissionsDAO permissionsDAO = DAOFactory.getPermissionsDAOInstance();
    @Override
    public Map<String, Object> userLogin(String account, String password) {
        Map<String,Object> map = new HashMap<>();
        User user = null;
        try {
            user = userDAO.getUser(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!=null){
            if (password.equals(user.getPassword())){
                map.put("flag","登录成功");
                map.put("user",user);
            }else {
                map.put("flag","密码错误");
                map.put("user",null);
            }
        }else {
            map.put("flag","账号不存在");
            map.put("user",null);
        }
        return map;
    }

    @Override
    public Map<String, List<Permissions>> userPermission(String userID) {
        Map<String,List<Permissions>> map = null;
        try {
            map = permissionsDAO.getPermissions(userID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
