package com.soft1611.manage.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sry
 * @date 2017/12/25
 */
public class SetOfAccountManagePanel extends JPanel {
    private JPanel mainPanel;
    private JTable table1;
    private JButton 增加Button;
    private JButton 删除Button;
    private JButton 修改Button;
    private JTextField textField1;
    private JButton 搜索Button;
    private JPanel cardPanel;
    private JPanel card1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton 新增Button;
    private JPanel card2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JSpinner spinner3;
    private JButton 保存Button;
    private CardLayout cardLayout;
    private boolean flag = false;

    public SetOfAccountManagePanel() {
        add(mainPanel);
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        cardPanel.add(card1,"add");
        cardPanel.add(card2,"update");
        增加Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag){
                    cardPanel.setVisible(true);
                    flag = true;
                }else {
                    cardPanel.setVisible(false);
                    flag = false;
                }
                cardLayout.show(cardPanel,"add");
            }
        });
        修改Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag){
                    cardPanel.setVisible(true);
                    flag = true;
                }else {
                    cardPanel.setVisible(false);
                    flag = false;
                }
                cardLayout.show(cardPanel,"update");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SetOfAccountManagePanel");
        frame.setContentPane(new SetOfAccountManagePanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
