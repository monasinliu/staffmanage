package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Assessment;
import com.soft1611.manage.service.AssessmentService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 * @author 洪磊
 * @date 2017/12/26
 */
public class AssessmentPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel panel3;
    private JTable table1;
    private JTable table2;
    private JScrollPane rewardPanel;
    private JScrollPane publishPanel;
    private JComboBox comboBox1;
    private java.util.List<Assessment>assessments;
    private byte[] b;
    private StringBuffer condition = new StringBuffer();
    private StringBuffer condition1 = new StringBuffer();
    private String flag = null;
    private DefaultTableModel dtm;
    private DefaultTableModel dtm1;
    private int[] rows;
    private int[] rows1;
    private AssessmentService assessmentService= ServiceFactory.getAssessmentServiceInstance();
    java.util.List<Assessment> list;

    public AssessmentPanel() {
        add(mainPanel);
        Showtable1();
        Showtable2();

    }
    public void Showtable1(){
        dtm = new DefaultTableModel();
        String[] titles = {"工号","奖惩原因", "奖惩时间"};
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
        String[] content = new String[3];
        //获取到数据库中所有用户信息
        assessments = assessmentService.queryFilter(" WHERE assess_case = '奖' ");
        Iterator<Assessment> iterator = assessments.iterator();
        while (iterator.hasNext()) {
            Assessment assessment = iterator.next();
            content[0] = assessment.getAccount();
            content[1] = assessment.getAssess_describe();
            content[2] = String.valueOf(assessment.getTime());

            dtm.addRow(content);
        }
        panel3.revalidate();
     //   mainPanel.revalidate();
    }
    public void Showtable2(){
        dtm1 = new DefaultTableModel();
        String[] titles = {"工号","原因", "时间"};
        // 设置表头的标题列
        dtm1.setColumnIdentifiers(titles);
        //给表格设置数据模型
        table2.setModel(dtm1);
        // 将单元格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        // 设置水平方向居中
        r.setHorizontalAlignment(JLabel.CENTER);
        table2.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table2.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[3];
        //获取到数据库中所有用户信息
        assessments = assessmentService.queryFilter(" WHERE assess_case = '惩' ");
        Iterator<Assessment> iterator = assessments.iterator();
        while (iterator.hasNext()) {
            Assessment assessment = iterator.next();
            content[0] = assessment.getAccount();
            content[1] = assessment.getAssess_describe();
            content[2] = String.valueOf(assessment.getTime());

            dtm1.addRow(content);
        }
        panel3.revalidate();
        //   mainPanel.revalidate();
    }
    public void addAssessment(Assessment assessment) {
        Object[] rowData = {assessment.getAssess_describe(), assessment.getTime()};
        dtm1.addRow(rowData);
    }

}
