package com.soft1611.manage.dao;

import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Permissions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by mona on 2017/12/20.
 */
public class PermissionsDAOTest {
    PermissionsDAO permissionsDAO;

    @Before
    public void setUp() throws Exception {
        permissionsDAO = DAOFactory.getPermissionsDAOInstance();
    }

    @Test
    public void getPermissions() throws Exception {
        Map<String, List<Permissions>> map = permissionsDAO.getPermissions("20010101");
        System.out.println(map);
        System.out.println(map.size());
    }

}