package com.soft1611.manage.frame;

import com.soft1611.manage.dao.AttendanceDAO;
import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.utils.ExportExcel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * Created by 朱广旭 on 2017/12/21.
 * 考勤管理
 */
public class InfoPanel2 extends JPanel{
    private JLabel jLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTable table;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer renderer,renderer1;
    protected java.util.List<Attendance> attendance;
    Iterator<Attendance> iterator = null;
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();
    private Staff staff;
    private StaffService staffService = ServiceFactory.getStaffService();
    private InfoPanel2 infoPanel2;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottonPanel;
    private JLabel titleLabel;
    private JButton[] jButtons;
    private String[] info = {"上一页","下一页","导  出","打  印"};
    Font font  = new Font("微软雅黑",Font.PLAIN,26);
    Font font3 = new Font("微软雅黑",Font.PLAIN,22);
    Font font1 = new Font("微软雅黑",Font.PLAIN,18);
    Font font2  = new Font("微软雅黑",Font.PLAIN,18);
    Color color = new Color(66, 139, 202);

    public InfoPanel2(Staff staff){
        this.staff=staff;

        setLayout(new BorderLayout());
        //setBackground(Color.WHITE);
        setSize(1600,1000);
        topPanel=new JPanel();
        topPanel.setBackground(Color.white);
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);
        bottonPanel = new JPanel();
        bottonPanel.setBackground(Color.white);
        add(getTopPanel(),BorderLayout.NORTH);
        add(getCenterPanel(),BorderLayout.CENTER);
        add(getBottonPanel(),BorderLayout.SOUTH);
    }

    public JPanel getTopPanel(){
        titleLabel = new JLabel("个人出勤记录");
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setFont(font);
        setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(1600,80));
        topPanel.add(titleLabel,BorderLayout.SOUTH);
        return topPanel;
    }
    public JPanel getCenterPanel() {
        centerPanel.setLayout(new FlowLayout());
        table = new JTable();
        table.setRowHeight(25);
        table.setPreferredSize(new Dimension(1400,900));
        table.getTableHeader().setPreferredSize(new Dimension(1,40));
        table.getTableHeader().setFont(font3);
        table.setFont(font1);
        renderer = new DefaultTableCellRenderer();
        renderer1 = new DefaultTableCellRenderer();
        dtm = new DefaultTableModel();
        String[] titles = {"日   期","姓   名","工   号","部   门","出勤记录"};
        dtm.setColumnIdentifiers(titles);
        table.setModel(dtm);
        renderer.setHorizontalAlignment(JLabel.CENTER);
        renderer.setFont(font1);
        table.setDefaultRenderer(Object.class,renderer);
        renderer1.setHorizontalAlignment(JLabel.CENTER);
        renderer1.setBackground(color);
        renderer1.setForeground(Color.white);
        renderer.setBackground(Color.white);
        table.getTableHeader().setDefaultRenderer(renderer1);
        String[] content = new String[5];
        attendance = staffService.getAttendance(staff.getAccount());
        iterator = attendance.iterator();
        while(iterator.hasNext()){
            Attendance attendance = iterator.next();
            content[0] = String.valueOf(attendance.getAttend_time());
            content[1] = staff.getName();
            content[2] = attendance.getAccount();
            content[3] = staff.getDepartment();
            content[4] = attendance.getAttend_case();
//            if(content[0] != null){
//                content[4] = "已出勤";
//           }else{
//                content[4] = null;
//            }
            dtm.addRow(content);
        }
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1400,900));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        centerPanel.add(scrollPane);
        return centerPanel;
    }
    public JPanel getBottonPanel() {
        //用来当弹簧使的
        jLabel = new JLabel("label");
        jLabel1 = new JLabel("label1");
        jLabel2 = new JLabel("label2");

        jLabel.setPreferredSize(new Dimension(600,50));
        jLabel1.setPreferredSize(new Dimension(60,50));
        jLabel2.setPreferredSize(new Dimension(60,50));

        jLabel.setBackground(Color.white);
        jLabel.setForeground(Color.white);
        jLabel1.setBackground(Color.white);
        jLabel1.setForeground(Color.white);
        jLabel2.setBackground(Color.white);
        jLabel2.setForeground(Color.white);

        bottonPanel.setLayout(new FlowLayout());
        jButtons = new JButton[4];
        for(int i = 0; i < jButtons.length ; i++){
            jButtons[i] = new JButton(info[i]);
            jButtons[i].setPreferredSize(new Dimension(160,50));
            jButtons[i].setFont(font2);
            jButtons[i].setBackground(color);
            jButtons[i].setForeground(Color.white);
        }
        //导出按钮添加监听
        jButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //调用工具类，将list数据写入指定路径的excel中
                ExportExcel.exportData(attendance);
                JOptionPane.showMessageDialog(null,"导出成功！");
            }
        });
        bottonPanel.setPreferredSize(new Dimension(1400,90));

        bottonPanel.add(jButtons[3],FlowLayout.LEFT);
        bottonPanel.add(jLabel2,FlowLayout.LEFT);
        bottonPanel.add(jButtons[2],FlowLayout.LEFT);
        bottonPanel.add(jLabel,FlowLayout.LEFT);
        bottonPanel.add(jButtons[1],FlowLayout.LEFT);
        bottonPanel.add(jLabel1,FlowLayout.LEFT);
        bottonPanel.add(jButtons[0],FlowLayout.LEFT);
        return bottonPanel;
    }
    public static void main(String[] args) throws SQLException {
        StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
//        try {
//            System.out.println(staffDAO.get("20010101").getAccount());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(1600, 1000);
        frame.setLocationRelativeTo(null);
//        frame.add(new InfoPanel2());
//        try {
        frame.add(new InfoPanel2(staffDAO.getArchives("20010101")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        frame.setVisible(true);

    }
}
