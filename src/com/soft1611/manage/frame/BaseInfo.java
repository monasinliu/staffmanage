package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.utils.DialogDatePicker;
import com.soft1611.manage.utils.ExcelUtil;
import com.soft1611.manage.utils.FileUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**@author yangmeng
 * Created by DELL on 2017/12/25.
 */
public class BaseInfo extends JPanel {

    private JPanel MainPanel;
    private JButton AddButton;
    private JComboBox sexBox;
    private JTextField SearchField;
    private JButton SearchButton;
    private JButton ModificationButton;
    private JButton DeleteButton;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JTable table1;
    private JButton BatchButton;
    private JTextField accountField;
    private JComboBox departmentBox;
    private JTextField nameField;
    private JRadioButton boyButton;
    private JRadioButton girlButton;
    private JComboBox nationBox;
    private JComboBox proviceBox;
    private JComboBox cityBox;
    private JTextField addressField;
    private JComboBox educationBox;
    private JComboBox dutyBox;
    private JComboBox titleBox;
    private JComboBox psBox;
    private JButton confirmButton;
    private JTextField intimeField;
    private JPanel rightPanel;
    private JTextField textField5;
    private JTextField phoneField;
    private JLabel photoLabel;
    private JComboBox deptBox;
    private String  department;
    private int[] rows;
    private int row;
    private int col;
    private DefaultTableModel dtm, dtm2;
    private Staff staff;
    private java.util.List<Staff> staffs;
    private StringBuffer condition = new StringBuffer();
    private StaffService staffService = ServiceFactory.getStaffService();
    private boolean flag = false;
    private ExcelUtil excelUtil = new ExcelUtil();

    String sex = "";
    byte[] b;
    ButtonGroup group = new ButtonGroup();


    public BaseInfo() {
        showStaffTable();
        group.add(boyButton);
        group.add(girlButton);
        boyButton.isSelected();
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag) {
                    rightPanel.setVisible(true);
                    flag = true;
                } else {
                    rightPanel.setVisible(false);
                    flag = false;
                }
            }

        });

        sexBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        sex = sexBox.getSelectedItem().toString().trim();
                        if (condition.length() == 0) {  //没选籍贯，那只需要按照性别筛选
                            condition = new StringBuffer();
                            condition.append("WHERE sex = '" + sex + "'");
                        } else {   //先选了籍贯， 那再加上性别一起筛选
                            condition.append(" AND sex = '" + sex + "'");
                        }
                        //更新数据
                        updateModel();
                    }
                }
            }
        });

        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = SearchField.getText().trim();
                staffs = staffService.queryLike(keywords);
                int count = dtm.getRowCount();
                for (int i = count - 1; i >= 0; i--) {
                    dtm.removeRow(i);
                }
                for (Staff staff : staffs) {
                    addStaff(staff);
                }
            }
        });

        ModificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> ids = new ArrayList<>();
                //遍历选中的多行
                System.out.println(rows);
                for (int i : rows) {
                    System.out.println(i);
                    ids.add(table1.getValueAt(i, 0).toString());
                }
                //result容量最大就是记录总数
                int[] result;
                //调用批量删除方法，得到一个整型数组（受影响的记录行）
                result = staffService.batchDelete(ids);
                if (result.length != 0) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    //从表格模型中移除掉已经删除的记录
                    for (int i = rows.length - 1; i >= 0; i--) {
                        dtm.removeRow(rows[i]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }
        });

        BatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int n = chooser.showOpenDialog(BaseInfo.this);
                if (n == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        InputStream is = new FileInputStream(file);
                        //调用excel工具类，得到List<Staff>数据集合
                        java.util.List<Staff> staffList = excelUtil.readExcelContent(is);
                        System.out.println(staffList);
                        //调用批量插入方法
                        int[] result = staffService.batchInsert(staffList);
                        System.out.println("1:"+result.length);
                        //至少一行记录受影响
                        if (result.length != 0) {
                            JOptionPane.showMessageDialog(null, "批量导入成功！");
                            showStaffTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "批量导入失败！");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        //还原表格、重置查询条件
        centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                condition = new StringBuffer();
                updateModel();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rows = table1.getSelectedRows();
                row = table1.getEditingRow();
                col = table1.getEditingColumn();
                if (table1.isEditing()){

                }
            }
        });
        deptBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    department = deptBox.getSelectedItem().toString().trim();
                    if (condition.length() == 0) {
                        condition = new StringBuffer();
                        condition.append("WHERE department = '" + department + "'");
                    } else {
                        condition.append(" AND department = '" + department + "'");
                    }
                    //更新数据
                    updateModel();
                }
            }
        });

        topPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                condition = new StringBuffer();
                updateModel();
            }
        });


        proviceBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        cityBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String accountString = accountField.getText();
                String departmentString = departmentBox.getActionCommand();
                String nameString = nameField.getText();
                String sexString = null;
                if (boyButton.isSelected()) {
                    sexString = "男";
                }
                if (girlButton.isSelected()) {
                    sexString = "女";
                }
                String nationString = nationBox.getActionCommand();
                String provice = (String) proviceBox.getSelectedItem() + (String)cityBox.getSelectedItem();
                String address = addressField.getText();
                String edu = (String) educationBox.getSelectedItem();
                String duty = (String) dutyBox.getSelectedItem();
                String title = (String) titleBox.getSelectedItem();
                String ps = (String) psBox.getSelectedItem();
                String time = intimeField.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(time);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date enrollment = new java.sql.Date(date.getTime());
                String phone = phoneField.getText();
                String email = textField5.getText();
                Staff staff = new Staff(accountString, departmentString, nameString ,sexString, nationString, provice,
                        address, edu, duty, title,ps,enrollment,phone,email,b);

                int n = 0;
                n = staffService.insert(staff);
                if (n != 0) {
                    JOptionPane.showMessageDialog(null, "新增员工成功");
                    rightPanel.setVisible(false);
                    flag = false;
                    addStaff(staff);
                } else {
                    JOptionPane.showMessageDialog(null, "新增员工失败");
                }
            }
        });
        photoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser chooser = new JFileChooser();
                int n = chooser.showOpenDialog(BaseInfo.this);
                if (n == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    b = FileUtils.fileToBytes(file);
                    photoLabel.setIcon(new ImageIcon(b));
                }
            }
        });
        intimeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (intimeField.getText().equals("")){
                    JTextField txtDate = new JTextField();
                    //弹出时间选择框
                    new DialogDatePicker(true, txtDate, 750, 450);
                    //获得日期
                    intimeField.setText(txtDate.getText());
                }
            }
        });
        add(MainPanel);
    }

    public void showStaffTable() {
        dtm = new DefaultTableModel();

        String[] titles = {"工号", "姓名", "性别", "联系方式", "部门", "邮箱", "入职时间"};
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
        String[] content = new String[7];
        //获取到数据库中所有用户信息
        staffs = staffService.getAll();
        Iterator<Staff> iterator = staffs.iterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            content[0] = staff.getAccount();
            content[1] = staff.getName();
            content[2] = staff.getSex();
            content[3] = staff.getPhone();
            content[4] = staff.getDepartment();
            content[5] = staff.getEmail();
            content[6] = staff.getSignInTime().toString();
            dtm.addRow(content);
        }
    }


    /**
     * 表格增加一行学生数据
     *
     * @param staff
     */
    public void addStaff(Staff staff) {
        Object[] rowData = {staff.getAccount(), staff.getName(), staff.getSex()
                , staff.getPhone(), staff.getDepartment(), staff.getEmail()
                , staff.getSignInTime()};
        dtm.addRow(rowData);
    }

    /**
     * 更新学生表格模型数据
     */
    public void updateModel() {
        staffs = staffService.queryFilter(condition.toString());
        int count = dtm.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (Staff staff : staffs) {
            addStaff(staff);
        }
    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("基本信息管理");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setContentPane((new BaseInfo()).MainPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);


}
}