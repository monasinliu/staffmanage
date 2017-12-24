package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.AnnounceDAO;
import com.soft1611.manage.model.Announcement;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  公告DAO实现
 * @author mona
 * @date 2017/12/24
 */
public class AnnounceDAOImpl implements AnnounceDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    @Override
    public List<Announcement> getAll() throws SQLException {
        String sql = "SELECT * FROM t_announcement";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        List<Announcement> announcements = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Announcement announcement = new Announcement(map.get("title").toString(),map.get("content").toString()
                    ,map.get("account").toString(),(Timestamp) map.get("time"));
            announcements.add(announcement);
        }
        return announcements;
    }
}
