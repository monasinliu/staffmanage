package com.soft1611.manage.factory;

import com.soft1611.manage.service.AnnounceService;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.service.WageService;
import com.soft1611.manage.service.impl.AnnounceServiceImpl;
import com.soft1611.manage.service.impl.StaffServiceImpl;
import com.soft1611.manage.service.impl.UserServiceImpl;
import com.soft1611.manage.service.impl.WageServiceImpl;

/**
 *  Service工厂
 * @author sry
 * @date 2017/12/21
 */
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }

    public static AnnounceService getAnnounceServiceInstance(){
        return new AnnounceServiceImpl();
    }

    public static WageService getWageServiceInstance(){
        return new WageServiceImpl();
    }

    public static StaffService getStaffService() {
        return new StaffServiceImpl();
    }
}
