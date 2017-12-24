package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.AnnounceDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Announcement;
import com.soft1611.manage.service.AnnounceService;

import java.sql.SQLException;
import java.util.List;

/**
 *  公告服务实现
 * @author sry
 * @date 2017/12/24
 */
public class AnnounceServiceImpl implements AnnounceService {
    AnnounceDAO announceDAO = DAOFactory.getAnnounceDAOInstance();

    @Override
    public List<Announcement> readAnnouncement() {
        List<Announcement> announcements = null;
        try {
           announcements  = announceDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return announcements;
    }
}
