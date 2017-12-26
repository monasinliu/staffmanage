package com.soft1611.manage.service;

import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wage;

import java.util.List;

/**
 *
 * @author 朱广旭
 * @date 2017/12/19
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
   List<Wage> getWages(String account);

    /**
     *  修改员工信息
     *
     * @param staff
     * @return
     */
   boolean updateStaff(Staff staff);

}
