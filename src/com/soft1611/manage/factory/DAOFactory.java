package com.soft1611.manage.factory;

import com.soft1611.manage.dao.AnnounceDAO;
import com.soft1611.manage.dao.PermissionsDAO;
import com.soft1611.manage.dao.UserDAO;
import com.soft1611.manage.dao.impl.AnnounceDAOImpl;
import com.soft1611.manage.dao.impl.PermissionsDAOImpl;
import com.soft1611.manage.dao.impl.UserDAOImpl;

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
}
