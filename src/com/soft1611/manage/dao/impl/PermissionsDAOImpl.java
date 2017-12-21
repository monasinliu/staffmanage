package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.PermissionsDAO;
import com.soft1611.manage.model.Permissions;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  权限接口实现类
 * @author sry
 * @date 2017/12/20
 */
public class PermissionsDAOImpl implements PermissionsDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Map<String, List<Permissions>> getPermissions(String userID) throws SQLException {
        String sql = "SELECT group_name , t3.`account` ,item_id "
                + " FROM t_permissions_group t1,t_permissions_item t2,t_permissions_mapping t3 "
                + " WHERE group_id = t1.`id` AND t2.`id`= t3.`item_id` AND t3.`account` = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{userID});
        Map<String,List<Permissions>> permissions = new HashMap<>();
        List<Permissions>[] lists = new List[8];
        for (int i = 0 ; i < lists.length ; i ++ ){
            lists[i] = new ArrayList<>();
        }
        String[] strings = {"基本信息管理","奖惩管理","教育培训",
                "建议反馈","统计报表","套账管理","人员管理","权限管理"};
        for (Object object:list) {
            Map<String,Object> map = (Map<String, Object>) object;
            Permissions permissions1 = new Permissions(map.get("group_name").toString(),map.get("account").toString(),
                    map.get("item_id").toString());
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
}
