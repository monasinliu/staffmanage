package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.AttendanceDAO;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 */
public class AttendanceDAOImpl implements AttendanceDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<Attendance> getAttendance(String account) throws SQLException {
        String sql = "SELECT * FROM t_attendance WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{account});
        return getAttendanceList(list);
    }

    @Override
    public int[] batchInsert(List<Attendance> list) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_attendance VALUES (NULL ,?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Attendance attendance : list) {
            ps.setString(1, attendance.getAccount());
            ps.setString(2, attendance.getAttend_case());
            ps.setTimestamp(3, attendance.getAttend_time());
            ps.addBatch();
        }
        // 执行批量更新操作
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public List<Attendance> queryFilter(String condition) throws SQLException {
        String sql = "SELECT * FROM t_attendance " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAttendanceList(list);
    }


    /**
     * 封装一个将List<Object>集合转换成奖惩集合的方法
     *
     * @param list
     * @return
     */
    public List<Attendance> getAttendanceList(List<Object> list) {
        List<Attendance>  attendanceList = new ArrayList<>();
        for(Object object : list){
            Map<String, Object> map = (Map<String, Object>) object;
            Attendance attendance = new Attendance(map.get("account").toString(),
                    map.get("attend_case").toString(),
                    (Timestamp) map.get("attend_time"));
            //给id设置值
            attendance.setId(Integer.parseInt(map.get("id").toString()));
            attendanceList.add(attendance);
        }
        return attendanceList;
    }
}
