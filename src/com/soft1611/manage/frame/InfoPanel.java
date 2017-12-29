package com.soft1611.manage.frame;

import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.StaffService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 * 基本信息
 */
public class InfoPanel extends JPanel{
    private Staff staff;
    private InfoPanel infoPanel;
    private JPanel bigPanel;
    private JLabel[] labels;

    private JTextField accountField;
    private JTextField departmentField;
    private JTextField nameField;
    private JTextField sexField;
    private JTextField nationField;
    private JTextField proviceField;
    private JTextField addressField;
    private JTextField educationField;
    private JTextField dutyField;
    private JTextField titleField;
    private JTextField political_statusField;
    private JTextField sign_in_timeField;
    private JTextField phoneField;
    private JTextField emailField;
    private JButton jButton1;
    private String[] info = {"基本资料","工     号：","部     门: ","姓     名: "
            ,"性     别：","民     族：","籍     贯：","住     址：","学     历：",
            "职     务：","职     称：","政治面貌：","入职时间：","联系方式：",
            "电子邮箱："};
    Font font  = new Font("微软雅黑",Font.BOLD,22);
    Font font1 = new Font("微软雅黑",Font.BOLD,18);
    Font font2  = new Font("微软雅黑",Font.BOLD,20);
    Color color = new Color(51,102,153);
    private StaffService staffService = ServiceFactory.getStaffService();
    public InfoPanel(Staff staff) {
        this.staff = staff;
        labels = new JLabel[15];
        for(int i = 0; i < labels.length ; i++){
            labels[i] = new JLabel(info[i]);
            labels[i].setPreferredSize(new Dimension(160,50));
            labels[i].setFont(font2);
        }
        bigPanel = new JPanel();
        bigPanel.setBackground(Color.white);
        bigPanel.setPreferredSize(new Dimension(1630,1000));

        add(getBigPanel());

    }

    public JPanel getBigPanel() {

        bigPanel.setLayout(new GridLayout(16,1));
        JPanel[] panels = new JPanel[16];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new FlowLayout(FlowLayout.LEFT, 60, 0));
            panels[i].setBackground(Color.WHITE);

        }
        panels[0].add(labels[0]);
        labels[0].setFont(font);
        labels[0].setForeground(color);
        //第一行面板
        panels[1].add(labels[1]);
        accountField = new JTextField();
        accountField.setFont(font1);
        accountField.setPreferredSize(new Dimension(400, 40));
        panels[1].add(accountField);
        accountField.setEditable(false);
        //第二行面板
        panels[2].add(labels[2]);
        departmentField = new JTextField();
        departmentField.setFont(font1);
        departmentField.setPreferredSize(new Dimension(400, 40));
        panels[2].add(departmentField);
        departmentField.setEditable(false);
        //3
        panels[3].add(labels[3]);
        nameField = new JTextField();
        nameField.setFont(font1);
        nameField.setPreferredSize(new Dimension(400, 40));
        panels[3].add(nameField);
        nameField.setEditable(false);
        //4
        panels[4].add(labels[4]);
        sexField = new JTextField();
        sexField.setFont(font1);
        sexField.setPreferredSize(new Dimension(400, 40));
        panels[4].add(sexField);
        sexField.setEditable(false);
        //5
        panels[5].add(labels[5]);
        nationField = new JTextField();
        nationField.setFont(font1);
        //去掉文本框外框
        //accountField.setBorder(BorderFactory.createLineBorder(Color.white));
        nationField.setPreferredSize(new Dimension(400, 40));
        panels[5].add(nationField);
        nationField.setEditable(false);
        //6
        panels[6].add(labels[6]);
        proviceField = new JTextField();
        proviceField.setFont(font1);
        proviceField.setPreferredSize(new Dimension(400, 40));
        panels[6].add(proviceField);
        proviceField.setEditable(false);
        //7
        panels[7].add(labels[7]);
        addressField = new JTextField();
        addressField.setFont(font1);
        addressField.setPreferredSize(new Dimension(400, 40));
        panels[7].add(addressField);
        //8
        panels[8].add(labels[8]);
        educationField = new JTextField();
        educationField.setFont(font1);
        educationField.setPreferredSize(new Dimension(400, 40));
        panels[8].add(educationField);
        educationField.setEditable(false);
        //9
        panels[9].add(labels[9]);
        dutyField = new JTextField();
        dutyField.setFont(font1);
        dutyField.setPreferredSize(new Dimension(400, 40));
        panels[9].add(dutyField);
        dutyField.setEditable(false);
        //10
        panels[10].add(labels[10]);
        titleField = new JTextField();
        titleField.setFont(font1);
        titleField.setPreferredSize(new Dimension(400, 40));
        panels[10].add(titleField);
        titleField.setEditable(false);
        //11
        panels[11].add(labels[11]);
        political_statusField = new JTextField();
        political_statusField.setFont(font1);
        political_statusField.setPreferredSize(new Dimension(400, 40));
        panels[11].add(political_statusField);
        political_statusField.setEditable(false);
        //12
        panels[12].add(labels[12]);
        sign_in_timeField = new JTextField();
        sign_in_timeField.setFont(font1);
        sign_in_timeField.setPreferredSize(new Dimension(400, 40));
        panels[12].add(sign_in_timeField);
        sign_in_timeField.setEditable(false);
        //13
        panels[13].add(labels[13]);
        phoneField = new JTextField();
        phoneField.setFont(font1);
        phoneField.setPreferredSize(new Dimension(400, 40));
        panels[13].add(phoneField);

        //14
        panels[14].add(labels[14]);
        emailField = new JTextField();
        emailField.setFont(font1);
        emailField.setPreferredSize(new Dimension(400, 40));
        panels[14].add(emailField);
        //15
        jButton1 = new JButton();
        //给jbutton1添加监听
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                // System.out.println(address + "11" + phone);
                if( address != ""){
                    if(phone != ""){
                        if(email != ""){
                            JOptionPane.showMessageDialog(null,"修改成功！");
                            staff.setAddress(address);
                            staff.setPhone(phone);
                            staff.setEmail(email);
                            staffService.updateStaff(staff);
                        }else{
                            JOptionPane.showMessageDialog(null,"信息未填写完整！");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"信息未填写完整！");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "信息未填写完整！");
                }
            }
        });
        jButton1.setFont(font2);
        jButton1.setBackground(color);
        jButton1.setForeground(Color.white);
        jButton1.setPreferredSize(new Dimension(160,60));
        jButton1.setText("保存修改");
        jButton1.setBorderPainted(false);
        jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
        panels[15].add(jButton1);

        //获取信息显示
        accountField.setText(staff.getAccount());
        departmentField.setText(staff.getDepartment());
        nameField.setText(staff.getName());
        sexField.setText(staff.getSex());
        nationField.setText(staff.getNation());
        proviceField.setText(staff.getProvice());
        addressField.setText(staff.getAddress());
        educationField.setText(staff.getEducation());
        dutyField.setText(staff.getDuty());
        titleField.setText(staff.getTitle());
        political_statusField.setText(staff.getPoliticalStatus());
        sign_in_timeField.setText(String.valueOf(staff.getSignInTime()));
        phoneField.setText(staff.getPhone());
        emailField.setText(staff.getEmail());

        for (int i = 0; i < panels.length; i++) {
            bigPanel.add(panels[i]);
        }
        return bigPanel;
    }
    public static void main(String[] args) {
        StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
        try {
            System.out.println(staffDAO.getArchives("20010101").getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(1600, 1000);
        frame.setLocationRelativeTo(null);
        try {
            frame.add(new InfoPanel(staffDAO.getArchives("20010101")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);

    }

}
