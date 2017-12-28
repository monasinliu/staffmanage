package com.soft1611.manage.factory;

import com.soft1611.manage.service.*;
import com.soft1611.manage.service.impl.*;

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

    public static AttendanceManageService getAttendanceManageServiceInstance(){
        return new AttendanceManageServiceImpl();
    }

    public static AdviceService getAdviceServiceInstance() {
        return  new AdviceServiceImpl();
    }

    public static AssessmentService getAssessmentServiceInstance(){
        return new AssessmentServiceImpl();
    }

    public static EducationService getEducationService(){
        return new EducationServiceImpl();
    }

    public static DepartmentService getDepartmentServiceInstance(){
        return new DepartmentServiceImpl();
    }

    public static PermissionService getPermissionServiceInstance() {
        return new PermissionServiceImpl();
    }
}
