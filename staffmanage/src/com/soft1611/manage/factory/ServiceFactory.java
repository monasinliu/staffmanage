package com.soft1611.manage.factory;

import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.service.impl.StaffServiceImpl;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 */
public class ServiceFactory {

    public static StaffService getStaffService() {
        return new StaffServiceImpl();
    }

}
