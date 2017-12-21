package com.soft1611.manage.frame;

import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.StaffService;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 *
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
    private String[] info = {"基本资料","工   号：","部   门: ","姓   名: "
            ,"性   别：","民   族：","籍   贯：","住   址：","学   历：",
            "职   务：","职   称：","政治面貌：","入职时间：","联系方式：",
            "电子邮箱："};
    Font font  = new Font("微软雅黑",Font.PLAIN,18);
    Font font1 = new Font("微软雅黑",Font.PLAIN,14);
    Color color = new Color(51,102,153);
    private StaffService staffService = ServiceFactory.getStaffService();
    public InfoPanel(Staff staff) {
        this.staff = staff;
        labels = new JLabel[15];
        for(int i = 0; i < labels.length ; i++){
            labels[i] = new JLabel(info[i]);
            labels[i].setPreferredSize(new Dimension(100,30));
            labels[i].setFont(font1);
        }
        bigPanel = new JPanel();
        bigPanel.setBackground(Color.white);
        bigPanel.setPreferredSize(new Dimension(800,700));

        add(getBigPanel());

    }

    public JPanel getBigPanel() {

        bigPanel.setLayout(new GridLayout(16,1));
        JPanel[] panels = new JPanel[16];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new FlowLayout(FlowLayout.LEFT, 40, 0));
            panels[i].setBackground(Color.WHITE);
        }
        panels[0].add(labels[0]);
        labels[0].setFont(font);
        labels[0].setForeground(color);
        //第一行面板
        panels[1].add(labels[1]);
        accountField = new JTextField();
        accountField.setPreferredSize(new Dimension(200, 30));
        panels[1].add(accountField);
        //第二行面板
        panels[2].add(labels[2]);
        departmentField = new JTextField();
        departmentField.setPreferredSize(new Dimension(200, 30));
        panels[2].add(departmentField);
        //3
        panels[3].add(labels[3]);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));
        panels[3].add(nameField);
        //4
        panels[4].add(labels[4]);
        sexField = new JTextField();
        sexField.setPreferredSize(new Dimension(200, 30));
        panels[4].add(sexField);
        //5
        panels[5].add(labels[5]);
        nationField = new JTextField();
        nationField.setPreferredSize(new Dimension(200, 30));
        panels[5].add(nationField);
        //6
        panels[6].add(labels[6]);
        proviceField = new JTextField();
        proviceField.setPreferredSize(new Dimension(200, 30));
        panels[6].add(proviceField);
        //7
        panels[7].add(labels[7]);
        addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 30));
        panels[7].add(addressField);



        //8
        panels[8].add(labels[8]);
        educationField = new JTextField();
        educationField.setPreferredSize(new Dimension(200, 30));
        panels[8].add(educationField);
        //9
        panels[9].add(labels[9]);
        dutyField = new JTextField();
        dutyField.setPreferredSize(new Dimension(200, 30));
        panels[9].add(dutyField);
        //10
        panels[10].add(labels[10]);
        titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(200, 30));
        panels[10].add(titleField);
        //11
        panels[11].add(labels[11]);
        political_statusField = new JTextField();
        political_statusField.setPreferredSize(new Dimension(200, 30));
        panels[11].add(political_statusField);
        //12
        panels[12].add(labels[12]);
        sign_in_timeField = new JTextField();
        sign_in_timeField.setPreferredSize(new Dimension(200, 30));
        panels[12].add(sign_in_timeField);
        //13
        panels[13].add(labels[13]);
        phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 30));
        panels[13].add(phoneField);
        //14
        panels[14].add(labels[14]);
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));
        panels[14].add(emailField);
        //15
        jButton1 = new JButton("编   辑");
        jButton1.setForeground(color);
        panels[15].add(jButton1);
        accountField.setText(staff.getAccount());
        for (int i = 0; i < panels.length; i++) {
            bigPanel.add(panels[i]);
        }

        return bigPanel;
    }
    public static void main(String[] args) {
        StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
        try {
            System.out.println(staffDAO.get("20010101").getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        try {
            frame.add(new InfoPanel(staffDAO.get("20010101")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);

    }
}