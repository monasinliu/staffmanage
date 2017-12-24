package com.soft1611.manage.dao;

import com.soft1611.manage.model.Announcement;

import java.sql.SQLException;
import java.util.List;

/**
 *  公告DAO
 * @author mona
 * @date 2017/12/24
 */
public interface AnnounceDAO {
    List<Announcement> getAll() throws SQLException;
}
