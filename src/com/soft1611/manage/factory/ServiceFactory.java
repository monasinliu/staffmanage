package com.soft1611.manage.factory;

import com.soft1611.manage.service.UserService;
import com.soft1611.manage.service.impl.UserServiceImpl;

/**
 * Created by mona on 2017/12/21.
 */
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
