package com.soft1611.manage.service;

import com.soft1611.manage.model.Attendance;

import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/27
 */
public interface AttendanceManageService {
    int[] batchInsert(List<Attendance> list);

    List<Attendance> getAttendance(String account);

    List<Attendance> queryFilter(String condition);
}
