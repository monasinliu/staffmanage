package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.service.OutOfAccount;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.service.WageService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.*;
import java.util.List;

/**
 *
 * @author sry
 * @date 2017/12/25
 */
public class SetOfAccountManagePanel extends JPanel {
    private JPanel mainPanel;
    private JButton button1;
    private JButton 一键生成工资单Button;
    private WageService wageService = ServiceFactory.getWageServiceInstance();
    private StaffService staffService = ServiceFactory.getStaffService();
    private java.util.List<Staff> staffList;
    private List<Wage> wageList = new ArrayList<>();

    public SetOfAccountManagePanel(Dimension dimension) {
        add(mainPanel);
        setPreferredSize(dimension);
        OutOfAccount outOfAccount = new OutOfAccount(3500,500,1000,1000,500);
        一键生成工资单Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffList = staffService.getAll();
                for (Staff staff:staffList) {
                    double basic = wageService.calBasicSalary(outOfAccount,staff);
                    double tax = wageService.calNetSalary(basic,500,3000);
                    double shouldPay = basic - 50;
                    double truePay = shouldPay - tax;
                    Wage wage = new Wage(staff.getAccount(),basic,0,0,50,0,shouldPay
                            ,tax,500,0,50,truePay,new Date(new java.util.Date().getTime()));
                    wageList.add(wage);
                }
                int[] n = null;
                n = wageService.batchInsert(wageList);
                if (n != null){
                    JOptionPane.showMessageDialog(null,"生成成功！");
                }else {
                    JOptionPane.showMessageDialog(null,"生成失败！");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SetOfAccountManagePanel");
        frame.setContentPane(new SetOfAccountManagePanel(new Dimension(500,500)).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
