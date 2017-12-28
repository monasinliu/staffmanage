package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.AnnounceService;
import com.soft1611.manage.service.AttendanceManageService;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.utils.DialogDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/26
 */
public class CheckAttendance extends JPanel {
    private JPanel mainPanel;
    private JComboBox selectBox;
    private JButton shortcutButton;
    private JPanel centerPanel;
    private JLabel overtimeLabel;
    private JLabel leaveLabel;
    private JLabel lateLabel;
    private JLabel absentLabel;
    private JLabel okLabel;
    private JLabel outLabel;
    private JLabel vacateLabel;
    private JButton selectButton;
    private JLabel timeLabel;
    private CardLayout cardLayout;
    private StaffService staffService = ServiceFactory.getStaffService();
    private AttendanceManageService attendanceManageService = ServiceFactory.getAttendanceManageServiceInstance();
    private java.util.List<Staff> staffList;
    private List<Attendance> aDayList;

    String selectItem;
    Font labelFont = new Font("微软雅黑",Font.BOLD,14);
    Font nameFont = new Font("微软雅黑",Font.ITALIC,20);
    Color leaveOrange = new Color(239,179,54);
    Color addGreen = new Color(124,186,89);
    Color labelBlue = new Color(100,149,237);
    Color absentRed = new Color(237,64,64);
    Color okGreen = new Color(122,185,0);
    Color anotherBlack = new Color(72,72,72);
    String[] items = new String[]{"加班","早退","迟到","旷工","到勤","出差","请假"};
    Color[] colors = new Color[]{addGreen,leaveOrange,leaveOrange,absentRed,okGreen,labelBlue,absentRed};
    int[] marks = {-1};
    Map<String,String> map = new HashMap<>();
    List<Attendance> attendanceList = new ArrayList<>();

    public CheckAttendance(){
        add(mainPanel);
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        timeLabel.setText(sdf.format(new Date()));
        selectBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selectItem = (String)selectBox.getSelectedItem();
                staffList = staffService.queryFilter(" WHERE department = '"
                        +selectItem+"' ");
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,40));
                setCheckPanel(panel);
                centerPanel.add(panel,selectItem);
                cardLayout.show(centerPanel,selectItem);
            }
        });

        shortcutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(timeLabel.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
                Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> entry = iterator.next();
                    String account = entry.getKey();
                    String attendCase = map.get(account);
                    Attendance attendance = new Attendance(account,attendCase,sqlDate);
                    attendanceList.add(attendance);
                }
                int[] n = attendanceManageService.batchInsert(attendanceList);
                if (n != null ){
                    JOptionPane.showMessageDialog(null,"提交成功！");
                }else {
                    JOptionPane.showMessageDialog(null,"提交失败！");
                }
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate, 750, 450);
                //获得日期
                timeLabel.setText(txtDate.getText());
            }
        });
    }

    private void setCheckPanel(JPanel panel) {
        marks= new int[staffList.size()];
        for (int i = 0 ; i < staffList.size() ; i ++ ){
            Staff staff = staffList.get(i);
            JPanel personPanel = new JPanel();
            personPanel.setPreferredSize(new Dimension(200,100));
            personPanel.setBackground(Color.white);
            personPanel.setLayout(new BorderLayout());
            JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            upPanel.setPreferredSize(new Dimension(200,30));
            upPanel.setBackground(Color.BLACK);
            JLabel label = new JLabel("到勤");
            label.setFont(labelFont);
            label.setForeground(okGreen);
            upPanel.add(label);
            personPanel.add(upPanel,BorderLayout.NORTH);
            JPanel centerPanel = new JPanel(new GridLayout(2,1));
            centerPanel.setBackground(Color.white);
            JLabel nameLabel = new JLabel();
            nameLabel.setText(staff.getName());
            nameLabel.setFont(nameFont);
            nameLabel.setForeground(anotherBlack);
            centerPanel.add(nameLabel);
            JPanel downPanel = new JPanel(new GridLayout(1,7));
            downPanel.setBackground(Color.white);
            JLabel[] labels = new JLabel[7];
            for (int j = 0 ; j < labels.length ; j ++){
                labels[j] = new JLabel();
                labels[j].setToolTipText(items[j]);
                if (labels[j].getToolTipText().equals("到勤")){
                    labels[j].setIcon(new ImageIcon(getClass().getResource("/img/new"+String.valueOf(j+1)+".png")));
                    marks[i] = j;
                }else {
                    labels[j].setIcon(new ImageIcon(getClass().getResource("/img/"+String.valueOf(j+1)+".png")));
                }
                downPanel.add(labels[j]);
                int index = j;
                int in = i;
                labels[j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        label.setText(items[index]);
                        label.setForeground(colors[index]);
                        labels[index].setIcon(new ImageIcon(getClass().getResource("/img/new"+String.valueOf(index+1)+".png")));
                        if (marks[in] != -1){
                            labels[marks[in]].setIcon(new ImageIcon(getClass().getResource("/img/"+String.valueOf(marks[in]+1)+".png")));
                        }
                        marks[in] = index;
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        labels[index].setBorder(BorderFactory.createLineBorder(labelBlue));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        labels[index].setBorder(BorderFactory.createEmptyBorder());
                    }
                });
            }
            map.put(staff.getAccount(),label.getText());
            centerPanel.add(downPanel);
            personPanel.add(centerPanel);
            panel.add(personPanel);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckAttendance");
        frame.setContentPane(new CheckAttendance().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
