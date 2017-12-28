package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Department;
import com.soft1611.manage.model.Permissions;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.DepartmentService;
import com.soft1611.manage.service.PermissionService;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sry
 * @date 2017/12/28
 */
public class PermissionsManagePanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox departmentBox;
    private JTable table1;
    private JLabel accountLabel;
    private JLabel nameLabel;
    private JPanel downPanel;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    private JCheckBox checkBox13;
    private JCheckBox checkBox14;
    private JCheckBox checkBox15;
    private JCheckBox checkBox16;
    private JCheckBox checkBox17;
    private JCheckBox checkBox18;
    private JCheckBox checkBox19;
    private JCheckBox checkBox20;
    private JCheckBox checkBox21;
    private JCheckBox checkBox22;
    private JCheckBox checkBox23;
    private JCheckBox checkBox24;
    private JCheckBox checkBox25;
    private JCheckBox checkBox26;
    private JCheckBox checkBox27;
    private JCheckBox checkBox28;
    private JCheckBox checkBox29;
    private JCheckBox checkBox30;
    private JCheckBox checkBox31;
    private JCheckBox checkBox32;
    private JCheckBox[] checkBoxes = new JCheckBox[]{checkBox1,checkBox2,checkBox3,checkBox4
            ,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12
            ,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,checkBox19,checkBox20
            ,checkBox21,checkBox22,checkBox23,checkBox24,checkBox25,checkBox26,checkBox27,checkBox28
            ,checkBox29,checkBox30,checkBox31,checkBox32};
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel[] labels = new JLabel[]{ label1,label2,label3,label4,label5,label6,label7,label8};
    private JButton 保存Button;
    private JPanel permissionShowPanel;
    private JComboBox comboBox1;
    private JPanel contentPanel;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JPanel card2;
    private JPanel cardPanel;
    private CardLayout cardLayout = new CardLayout();
    private JComboBox[] comboBoxes = new JComboBox[]{comboBox1,comboBox2
            ,comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox8};
    private DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();
    private List<Department> departments;
    private StaffService staffService = ServiceFactory.getStaffService();
    private List<Staff> staffList;
    private UserService userService = ServiceFactory.getUserServiceInstance();
    private PermissionService permissionService = ServiceFactory.getPermissionServiceInstance();
    private Map<String,List<Permissions>> map ;
    private Map<String,List<String>> allPermissions;
    DefaultTableModel dtm = new DefaultTableModel();

    public PermissionsManagePanel(){
        init();
        add(mainPanel);

        departmentBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setTable();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                downPanel.setVisible(true);
                int row = table1.getSelectedRow();
                String account = table1.getValueAt(row,0).toString();
                Staff staff = staffService.getStaff(account);
                accountLabel.setText(account);
                nameLabel.setText(staff.getName());
                map = userService.userPermission(account);
                showPermission();
            }
        });
    }

    private void showPermission() {
        Iterator<Map.Entry<String, List<Permissions>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Permissions>> entry = iterator.next();
            String groupName = entry.getKey();
            List<Permissions> list = map.get(groupName);
            JLabel label = new JLabel(groupName+"：");
            contentPanel.add(label);
            for (Permissions permissions: list ) {
                String itemString = permissions.getItemID();
                JLabel itemLabel  = new JLabel(itemString+"     ");
                contentPanel.add(itemLabel);
            }
//            for (int i = 0 ; i < labels.length ; i ++){
//                if (groupName.equals(labels[i].getText())){
//                    List<Permissions> list = map.get(groupName);
//
//                    for (int j = 0; j < checkBoxes.length/labels.length ; j ++){
//
//                    }
//                }
//            }
        }
    }

    private void init() {
        cardPanel.setLayout(cardLayout);
        cardPanel.add(card2,"2");
        cardLayout.show(cardPanel,"2");
        departments = departmentService.getAll();
        for (Department department:departments) {
            departmentBox.addItem(department.getName());
        }
        setTable();
        showPermissionPanel();
    }

    private void showPermissionPanel() {
        allPermissions = permissionService.getAllPermission();
        int i = 0;
        for (String groupName:allPermissions.keySet()) {
//            labels[i].setText(groupName);
            comboBoxes[i].addItem(groupName);
            int j = 0;
            for (String itemName:allPermissions.get(groupName)) {
                comboBoxes[i].addItem(itemName);
//                checkBoxes[j].setText(itemName);
//                j++;
            }
            i++;
        }
    }

    private void setTable() {
        staffList = staffService.queryFilter(" WHERE department = '"+departmentBox.getSelectedItem()+"' ");
        dtm = new DefaultTableModel();

        String[] titles = {"工号", "姓名", "性别", "联系方式","职位","职称","邮箱", "入职时间"};
        // 设置表头的标题列
        dtm.setColumnIdentifiers(titles);
        //给表格设置数据模型
        table1.setModel(dtm);
        // 将单元格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        // 设置水平方向居中
        r.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table1.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[8];
        //获取到数据库中所有用户信息
        Iterator<Staff> iterator = staffList.iterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            content[0] = staff.getAccount();
            content[1] = staff.getName();
            content[2] = staff.getSex();
            content[3] = staff.getPhone();
            content[4] = staff.getDuty();
            content[5] = staff.getTitle();
            content[6] = staff.getEmail();
            content[7] = staff.getSignInTime().toString();
            dtm.addRow(content);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PermissionsManagePanel");
        frame.setContentPane(new PermissionsManagePanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
