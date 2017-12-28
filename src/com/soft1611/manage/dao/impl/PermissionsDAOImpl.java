package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.PermissionsDAO;
import com.soft1611.manage.model.Permissions;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *  权限接口实现类
 * @author sry
 * @date 2017/12/20
 */
public class PermissionsDAOImpl implements PermissionsDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    String[] strings = {"基本信息管理","奖惩管理","教育培训",
            "考勤管理","统计报表","套账管理","权限管理"};

    @Override
    public Map<String, List<Permissions>> getPermissions(String userID) throws SQLException {
        String sql = "SELECT group_name , t3.`account` ,item_name "
                + " FROM t_permissions_group t1,t_permissions_item t2,t_permissions_mapping t3 "
                + " WHERE group_id = t1.`id` AND t2.`id`= t3.`item_id` AND t3.`account` = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{userID});
        Map<String,List<Permissions>> permissions = new HashMap<>();
        List<Permissions>[] lists = new List[7];
        for (int i = 0 ; i < lists.length ; i ++ ){
            lists[i] = new ArrayList<>();
        }
        for (Object object:list) {
            Map<String,Object> map = (Map<String, Object>) object;
            Permissions permissions1 = new Permissions(map.get("group_name").toString(),map.get("account").toString(),
                    map.get("item_name").toString());
            for (int i = 0 ; i < lists.length ; i ++ ){
                if (permissions1.getGroupName().equals(strings[i])){
                    lists[i].add(permissions1);
                }
            }
        }
        for (int i = 0; i < lists.length; i++) {
            if (lists[i].size() != 0) {
                permissions.put(strings[i], lists[i]);
            } else {
                continue;
            }
        }
        return permissions;
    }

    @Override
    public Map<String, List<String>> getAllPermission() throws SQLException {
        Connection connection =jdbcUtil.getConnection();
        String sql = "SELECT group_name,item_name FROM t_permissions_group t1,t_permissions_item t2 WHERE group_id = t1.`id` ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Map<String,List<String>> map = new HashMap<>();
        List<String>[] lists = new List[strings.length];
        for (int i = 0 ; i < lists.length ; i ++){
            lists[i] = new ArrayList<>();
        }
        Set<String> nameSet = new HashSet<>();
        int i = 0;
        while (rs.next()){
            String group_name = rs.getString("group_name");
            nameSet.add(group_name);
            String item_name = rs.getString("item_name");
            if (group_name.equals(strings[i/8])){
                lists[i/8].add(item_name);
            }
            i ++ ;
        }
        for (int k = 0 ; k < lists.length ; k ++ ){
            if (lists[k].size() != 0) {
                map.put(strings[k], lists[k]);
            } else {
                continue;
            }
        }
        return map;
    }
}
