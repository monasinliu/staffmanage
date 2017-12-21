package com.soft1611.manage.factory;

import com.soft1611.manage.service.UserService;
import com.soft1611.manage.service.impl.UserServiceImpl;

/**
 *  Service工厂
 * @author sry
 * @date 2017/12/21
 */
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
