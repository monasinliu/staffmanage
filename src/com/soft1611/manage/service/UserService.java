package com.soft1611.manage.service;

import com.soft1611.manage.model.Permissions;

import java.util.List;
import java.util.Map;

/**
 *  用户Service
 * @author sry
 * @date 2017/12/20
 */
public interface UserService {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    Map<String,Object> userLogin(String account, String password);

    /**
     * 权限获取
     * @param userID
     * @return
     */
    Map<String,List<Permissions>> userPermission(String userID);
}
