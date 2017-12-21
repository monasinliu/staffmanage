package com.soft1611.manage.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MoQi on 2017-12-18.
 * 自定义对话框
 */
public class ConfirmDialog extends JDialog {
    private String info;
    private JLabel infoLabel;
    private JButton okButton;
    private JButton cancelButton;
    private static boolean flag = false;

    public ConfirmDialog(String info, Color color) {

        this.info = info;
        //设置为模态框
        setModal(true);
        setSize(500, 300);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(color);
        infoLabel = new JLabel(info);
        Style.setLabelStyle(infoLabel);
        infoLabel.setBounds(200, 50, 200, 50);
        add(infoLabel);
        okButton = new JButton("确定");
        cancelButton = new JButton("取消");
        Style.setConfirmButtonStyle(okButton);
        Style.setEvenMainButtonStyle(cancelButton);
        okButton.setBounds(130, 140, 120, 50);
        cancelButton.setBounds(300, 140, 120, 50);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                ConfirmDialog.this.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmDialog.this.dispose();
            }
        });
        add(okButton);
        add(cancelButton);
        setVisible(true);
    }

    public static int openDialog(String info, Color color) {
        int n = 0;
        new ConfirmDialog(info,color);
        if (flag){
            n = 1;
        }
        return n;
    }
}
