package com.soft1611.manage.factory;

import com.soft1611.manage.dao.AttendanceDAO;
import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.dao.WagesDAO;
import com.soft1611.manage.dao.impl.AttendanceDAOImpl;
import com.soft1611.manage.dao.impl.StaffDAOImpl;
import com.soft1611.manage.dao.impl.WagesDAOImpl;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 */
public class DAOFactory {

    public static StaffDAO getStaffDAOInstance(){
        return new StaffDAOImpl();
    }
    public static AttendanceDAO getAttendanceDAOInstance(){
        return new AttendanceDAOImpl();
    }
    public static WagesDAO getWagesDAOInstance(){
        return new WagesDAOImpl();
    }
}
