package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Education;
import com.soft1611.manage.service.EducationService;
import com.soft1611.manage.utils.DialogDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 2017/12/25.
 */
public class EducationPanel extends JPanel {
    private JPanel MainPanel;
    private JButton addButton;
    private JPanel rightPanel;
    private JTextField titleField;
    private JButton confirmButton;
    private JTextArea contentArea;
    private JTextField beginField;
    private JTextField endField;
    private JPanel centerPanel;
    private EducationService educationService = ServiceFactory.getEducationService();
    private List<Education> educations;
    private boolean flag = false;
    private JPanel[] panels;
    private int i;
    private JPanel topPanel, contentPanel, belowPanel;

    private void setCenterPanel(JPanel panel) {
        educations = educationService.getAll();

        panels = new JPanel[3];
        centerPanel.setLayout(new GridLayout(3,1));
        for (i = 0; i < panels.length; i++) {
            panels[i] = new JPanel(new BorderLayout());
            panels[i].setPreferredSize(new Dimension(300,100));
            topPanel = new JPanel(new FlowLayout());
            JLabel titleLabel = new JLabel();
            titleLabel.setText(educations.get(i).getProject());
            topPanel.add(titleLabel);
            panels[i].add(topPanel,BorderLayout.NORTH);
            contentPanel = new JPanel(new BorderLayout());
            JLabel contentLabel = new JLabel();
            contentLabel.setText(educations.get(i).getContent());
            contentPanel.add(contentLabel);
            panels[i].add(contentPanel,BorderLayout.CENTER);
            belowPanel = new JPanel(new FlowLayout());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date beginDate = educations.get(i).getBegin();
            java.sql.Date endDate = educations.get(i).getEnd();
            StringBuffer dateString = new StringBuffer();
            dateString.append(sdf.format(beginDate));
            dateString.append("    --    ");
            dateString.append(sdf.format(endDate));
            JLabel beginLabel = new JLabel();
            beginLabel.setText(dateString.toString());
            belowPanel.add(beginLabel);
            panels[i].add(belowPanel,BorderLayout.SOUTH);
            panel.add(panels[i]);
        }
        add(MainPanel);
    }


    public EducationPanel(Dimension dimension) {

        setCenterPanel(centerPanel);
        centerPanel.revalidate();
        setPreferredSize(dimension);
        addButton.addActionListener(new ActionListener() {
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


        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tilteString = titleField.getText();
                String contentAreaString = contentArea.getText();
                String begin = beginField.getText();
                String end = endField.getText();
                SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                java.sql.Timestamp enrollment = new java.sql.Timestamp(date.getTime());

                SimpleDateFormat sdf1 = new SimpleDateFormat(" yyyy-MM-dd ");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = sdf.parse(beginField.getText());
                    date2 = sdf1.parse(endField.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date beginDate = new java.sql.Date(date.getTime());
                java.sql.Date endDate = new java.sql.Date(date.getTime());

                Education edu = new Education(tilteString,contentAreaString,enrollment,beginDate,endDate);
                educationService.insert(edu);
            }
        });
        beginField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (beginField.getText().equals("")) {
                    JTextField txtDate = new JTextField();
                    //弹出时间选择框
                    new DialogDatePicker(true, txtDate, 750, 450);
                    //获得日期
                    beginField.setText(txtDate.getText());
                }
            }
        });

        endField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (endField.getText().equals("")) {
                    JTextField txtDate = new JTextField();
                    //弹出时间选择框
                    new DialogDatePicker(true, txtDate, 750, 450);
                    //获得日期
                    endField.setText(txtDate.getText());
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("教育培训");
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setContentPane((new EducationPanel(new Dimension(500,500))).MainPanel);
        frame.setLocationRelativeTo(null);


    }
}


