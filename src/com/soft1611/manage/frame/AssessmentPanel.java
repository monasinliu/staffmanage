package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Assessment;
import com.soft1611.manage.service.AssessmentService;
import com.soft1611.manage.service.StaffService;

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
    private StaffService staffService = ServiceFactory.getStaffService();
    private Assessment assessment;
    private JPanel mainPanel;
    private JPanel panel3;
    private JTable table1;
    private JScrollPane rewardPanel;
    private JLabel Label1;
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

    String account;
    Color color = new Color(66, 139, 202);
    Font font3 = new Font("微软雅黑",Font.PLAIN,20);
    Font font1 = new Font("微软雅黑",Font.PLAIN,16);
    Font font2  = new Font("微软雅黑",Font.PLAIN,16);


    public AssessmentPanel(String acount) {
        this.account = acount;
        mainPanel.setPreferredSize(new Dimension(1400,900));
        add(mainPanel);
        Showtable1();
        //Showtable2();
    }
    public void Showtable1(){


        table1.setRowHeight(25);
        table1.setPreferredSize(new Dimension(1400,900));
        table1.getTableHeader().setPreferredSize(new Dimension(1,40));
        table1.getTableHeader().setFont(font3);
        table1.setFont(font1);
        dtm = new DefaultTableModel();
        String[] titles = {"工号","奖惩类别","奖惩原因", "奖惩时间"};
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
        r1.setFont(font3);
        r1.setBackground(color);
        r1.setForeground(Color.white);
        //r.setForeground(Color.white);
        table1.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[4];

        assessments = assessmentService.getAssessment(account);

        Iterator<Assessment> iterator = assessments.iterator();
        while (iterator.hasNext()) {
            Assessment assessment = iterator.next();
            content[0] = assessment.getAccount();
            content[1] = assessment.getAssess_case();
            content[2] = assessment.getAssess_describe();
            content[3] = String.valueOf(assessment.getTime());

            dtm.addRow(content);
        }
        panel3.revalidate();
    }
    public void addAssessment(Assessment assessment) {
        Object[] rowData = {assessment.getAssess_describe(), assessment.getTime()};
        dtm1.addRow(rowData);
    }

}
