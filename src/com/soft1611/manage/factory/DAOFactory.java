package com.soft1611.manage.factory;

import com.soft1611.manage.dao.*;
import com.soft1611.manage.dao.impl.*;

/**
 *  DAO工厂
 * @author sry
 * @date 2017/12/20
 */
public class DAOFactory {
    public static UserDAO getUserDAOInstance(){
        return new UserDAOImpl();
    }

    public static PermissionsDAO getPermissionsDAOInstance(){
        return new PermissionsDAOImpl();
    }

    public static AnnounceDAO getAnnounceDAOInstance(){
        return new AnnounceDAOImpl();
    }

    public static StaffDAO getStaffDAOInstance(){
        return new StaffDAOImpl();
    }

    public static WageDAO getWageDAOInstance(){
        return new WageDAOImpl();
    }

    public static AttendanceDAO getAttendanceDAOInstance(){
        return new AttendanceDAOImpl();
    }

    public static AdviceDAO getAdviceDAOInstance() {
        return new AdviceDAOImpl();
    }

    public static AssessmentDAO getAssessmentDAOInstance() {

        return new AssessmentDAOImpl();
    }

    public static EducationDAO getEducationInstance(){
        return new EducationDAOImpl();
    }

    public static DepartmentDAO getDepartmentInstance(){
        return new DepartmentDAOImpl();
    }
}
