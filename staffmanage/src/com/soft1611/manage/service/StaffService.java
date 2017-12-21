package com.soft1611.manage.service;

import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wages;

import java.util.List;
import java.util.Map;

/**
 * Created by 朱广旭 on 2017/12/19.
 */
public interface StaffService {
    /**
     * 获取某个员工基本信息
     *
     * @param account
     * @return  student
     */
   Staff getStaff(String account);

    /**
     * 获取某个员工考勤信息
     *
     * @param account
     * @return
     */
   List<Attendance> getAttendance(String account);

    /**
     *  获取某个员工工资信息
     *
     * @param account
     * @return
     */
   List<Wages> getWages(String account);

}
