package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Assessment;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.AssessmentService;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.utils.DialogDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 *
 * @author mona
 * @date 2017/12/28
 */
public class AssessmentManagePanel extends JPanel{
    private JPanel mainPanel;
    private JTable table1;
    private JButton addButton;
    private JComboBox comboBox1;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton changeButton;
    private JButton deleteButton;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JButton 选择时间Button;
    private JLabel dataLabel;
    private JTextField textField2;
    private JComboBox comboBox3;
    private JButton 新增Button;
    private JPanel card1;
    private JPanel cardPanel;
    private JPanel card2;
    private JLabel Label1;
    private JTextField accountField;
    private JTextField caseField;
    private JTextField itemField;
    private JTextField describeField;
    private JLabel xsLabel;
    private JButton saveButton;
    private JButton 选择时间;
    private JPanel upPanel;
    private AssessmentService assessmentService;
    private UserService userService;
    private StringBuffer condition = new StringBuffer();
    private int[] rows;
    int row ;

    DefaultTableModel dtm ;
    java.util.List<Assessment> assessmentList;
    boolean flag = false;

    public AssessmentManagePanel() {
        assessmentService = ServiceFactory.getAssessmentServiceInstance();
        userService = ServiceFactory.getUserServiceInstance();
        CardLayout card = new CardLayout();
        cardPanel.setLayout(card);
        cardPanel.add(card1,"1");
        cardPanel.add(card2,"2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dataLabel.setText(sdf.format(new Date()));
        init();
        add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(cardPanel,"1");
                if (!flag){
                    cardPanel.setVisible(true);
                    flag = true;
                }else {
                    cardPanel.setVisible(false);
                    flag = false;
                }
            }
        });
        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = textField1.getText();
                String assess_case = comboBox2.getSelectedItem().toString();
                String assess_item = comboBox3.getSelectedItem().toString();
                String assess_describe = textField2.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                try {
                    date = sdf.parse(dataLabel.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date time = new java.sql.Date(date.getTime());
                Assessment assessment = new Assessment(account, assess_case, assess_item, assess_describe, time);
                int n = 0;
                n = assessmentService.insert(assessment);
                if (n != 0) {
                    JOptionPane.showMessageDialog(null, "新增记录成功!");
                } else {
                    JOptionPane.showMessageDialog(null, "新增记录失败！");
                }
                updateModel();
                cardPanel.setVisible(false);
                flag = false;
            }
        });
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //先根据学号单元格的值查出这条记录
                Assessment assessment = assessmentService.getA(Integer.parseInt((String) table1.getValueAt(row, 0)));
                accountField.setText(assessment.getAccount());
                caseField.setText(assessment.getAssess_case());
                itemField.setText(assessment.getAssess_item());
                describeField.setText(assessment.getAssess_describe());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                xsLabel.setText(sdf.format(assessment.getTime()));
//

                card.show(cardPanel,"2");
                if (!flag){
                    cardPanel.setVisible(true);
                    flag = true;
                }else {
                    cardPanel.setVisible(false);
                    flag = false;
                }
            }
        });
        选择时间.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate,750,450);
                //获得日期
                xsLabel.setText(txtDate.getText());
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Assessment assessment = assessmentService.getA(Integer.parseInt((String) table1.getValueAt(row, 0)));
                String account = accountField.getText();
                String rpCase = caseField.getText();
                String item = itemField.getText();
                String describe = describeField.getText();
                String time = xsLabel.getText();
                java.util.Date date = null;
                try {
                    date =  sdf.parse(time);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                assessment.setAccount(account);
                assessment.setAssess_case(rpCase);
                assessment.setAssess_item(item);
                assessment.setAssess_describe(describe);
                assessment.setTime(sqlDate);
                int n = 0;
                n = assessmentService.update(assessment);
                if (n != 0) {
                    //更新一下
                    JOptionPane.showMessageDialog(null, "修改成功！");
                    card2.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "修改失败！");
                }
                updateModel();
                cardPanel.setVisible(false);
                flag = false;
            }
        });
        选择时间Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate,750,450);
                //获得日期
                dataLabel.setText(txtDate.getText());
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rows = table1.getSelectedRows();
                row = rows[0];
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Integer> ids = new ArrayList<>();
                for (int i : rows) {
                    ids.add(Integer.valueOf(table1.getValueAt(i, 0).toString()));
                }
                int[] result;
                result = assessmentService.batchDelete(ids);
                if (result.length != 0) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    for (int i = rows.length - 1; i >= 0; i--) {
                        dtm.removeRow(rows[i]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }
        });
        搜索Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = searchField.getText().trim();
                assessmentList = assessmentService.queryLike(keywords);
                int count = dtm.getRowCount();
                for (int i = count - 1; i >= 0; i--) {
                    dtm.removeRow(i);
                }
                for (Assessment assessment : assessmentList) {
                    add(assessment);
                }
            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                condition.append("WHERE assess_case = '"
                        +(String) comboBox1.getSelectedItem()
                        +"' ");
                System.out.println(condition);
                updateModel();
            }
        });
        upPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                condition = new StringBuffer();
                updateModel();
            }
        });
    }

    private void updateModel(){
        assessmentList = assessmentService.queryFilter(condition.toString());
        int count = dtm.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (Assessment assessment : assessmentList) {
            add(assessment);
        }
    }

    private void add(Assessment assessment) {
        Object[] rowData = {assessment.getId(),assessment.getAccount(),userService.getArchives(assessment.getAccount()).getName()
                ,assessment.getAssess_case(), assessment.getAssess_item(),assessment.getAssess_describe()
                ,assessment.getTime()};
        dtm.addRow(rowData);
    }

    private void init() {
        Dimension size = new Dimension(100, 30);
        addButton.setPreferredSize(size);
        changeButton.setPreferredSize(size);
        deleteButton.setPreferredSize(size);
        新增Button.setPreferredSize(size);
        setTable();
    }

    private void setTable() {
        dtm = new DefaultTableModel();
        table1.setModel(dtm);
        assessmentList = assessmentService.getAll();
        String[] titles = {"编号","工号","姓名", "奖惩类", "奖惩项", "描述", "录入时间"};
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class,dtcr);
        table1.getTableHeader().setDefaultRenderer(dtcr);
        dtm.setColumnIdentifiers(titles);
        String[] content = new String[7];
        Iterator<Assessment> iterator = assessmentList.iterator();
        while (iterator.hasNext()){
            Assessment assessment = iterator.next();
            Staff archives = userService.getArchives(assessment.getAccount());
            content[0] = String.valueOf(assessment.getId());
            content[2] = archives.getName();
            content[3] = assessment.getAssess_case();
            content[1] = assessment.getAccount();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            content[6] = sdf.format(assessment.getTime());
            content[5] = assessment.getAssess_describe();
            content[4] = assessment.getAssess_item();
            dtm.addRow(content);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AssessmentManagePanel");
        frame.setContentPane(new AssessmentManagePanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
