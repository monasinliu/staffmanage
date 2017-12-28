package com.soft1611.manage.dao.impl;

import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @modifier ym,zgx
 * @author sry
 * @date 2017/12/25
 */
public class StaffDAOImpl implements StaffDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    @Override
    public Staff getArchives(String account) throws SQLException {
        String sql = "SELECT * FROM t_archives WHERE account = ? ";
        Map<String,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{account});
        if (map.size() != 0 ){
            Staff archives = new Staff(map.get("account").toString(),map.get("department").toString()
                    ,map.get("name").toString(),  map.get("sex").toString(),map.get("nation").toString()
                    ,map.get("provice").toString(), map.get("address").toString(),map.get("education").toString()
                    ,map.get("duty").toString(),map.get("title").toString(),map.get("political_status").toString()
                    ,(Date) map.get("sign_in_time"),map.get("phone").toString(),map.get("email").toString()
                    ,(byte[]) map.get("photo"));
            return archives;
        }else {
            return null;
        }
    }

    @Override
    public int updateStaff(Staff staff) throws SQLException {
        String sql = "UPDATE t_archives SET address = ?,phone = ?,email= ? WHERE account = ?";
        Object[] params = {staff.getAddress(),staff.getPhone(),staff.getEmail(),staff.getAccount()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public List<Staff> queryFilter(String condition) throws SQLException {
        String sql = "SELECT * FROM t_archives " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        List<Staff> staffs = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Staff staff = new Staff(map.get("account").toString(),map.get("department").toString()
                    ,map.get("name").toString(),  map.get("sex").toString(),map.get("nation").toString()
                    ,map.get("provice").toString(), map.get("address").toString(),map.get("education").toString()
                    ,map.get("duty").toString(),map.get("title").toString(),map.get("political_status").toString()
                    ,(Date) map.get("sign_in_time"),map.get("phone").toString(),map.get("email").toString()
                    ,(byte[]) map.get("photo"));
            staffs.add(staff);
        }
        return staffs;
    }

    @Override
    public List<Staff> getAll() throws SQLException {
        String sql = "SELECT * FROM t_archives ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getStaffList(list);
    }

    @Override
    public int insert(Staff staff) throws SQLException {
        String sql = "INSERT INTO t_archives VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] params = {staff.getAccount(), staff.getDepartment(), staff.getName(), staff.getSex(),
                staff.getNation(),staff.getProvice(),staff.getAddress(), staff.getEducation(),staff.getDuty(),
                staff.getTitle(),staff.getPoliticalStatus(), staff.getSignInTime(),  staff.getPhone(),
                staff.getEmail(),staff.getPhoto()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int[] batchInsert(List<Staff> staffs) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_archives VALUES (NULL ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Staff staff : staffs) {
            ps.setString(1, staff.getAccount());
            ps.setString(2, staff.getDepartment());
            ps.setString(3, staff.getName());
            ps.setString(4, staff.getSex());
            ps.setString(5, staff.getNation());
            ps.setString(6, staff.getProvice());
            ps.setString(7, staff.getAddress());
            ps.setString(8, staff.getEducation());
            ps.setString(9, staff.getDuty());
            ps.setString(10, staff.getTitle());
            ps.setString(11, staff.getPoliticalStatus());
            ps.setDate(12, staff.getSignInTime());
            ps.setString(13, staff.getPhone());
            ps.setString(14, staff.getEmail());
            ps.setBytes(15, staff.getPhoto());
            ps.addBatch();
        }
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public int[] batchDelete(List<String> ids) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_archives WHERE account = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String account : ids) {
            ps.setString(1, account);
            ps.addBatch();
        }
        // 执行批量更新操作
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        System.out.println(result);
        return result;
    }

    @Override
    public List<Staff> queryLike(String keywords) throws SQLException {
        String sql = "SELECT * FROM t_archives WHERE CONCAT(account,name,sex,department,sign_in_time) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getStaffList(list);
    }

    private List<Staff> getStaffList (List < Object > list) {
        List<Staff> staffs = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Staff staff = new Staff(map.get("account").toString(),
                    map.get("department").toString(),
                    map.get("name").toString(),
                    map.get("sex").toString(),
                    map.get("nation").toString(),
                    map.get("provice").toString(),
                    map.get("address").toString(),
                    map.get("education").toString(),
                    map.get("duty").toString(),
                    map.get("title").toString(),
                    map.get("political_status").toString(),
                    (Date)map.get("sign_in_time"),
                    map.get("phone").toString(),
                    map.get("email").toString(),
                    (byte[])map.get("photo")
            );
            staffs.add(staff);
        }
        return staffs;
    }
}
