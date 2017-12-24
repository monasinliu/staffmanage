package com.soft1611.manage.service;

import com.soft1611.manage.model.Announcement;

import java.util.List;

/**
 *  公告服务
 * @author sry
 * @date 2017/12/24
 */
public interface AnnounceService {
    List<Announcement> readAnnouncement();
}
