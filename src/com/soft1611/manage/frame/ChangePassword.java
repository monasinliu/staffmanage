package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.UserService;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by mona on 2017/12/26.
 */
public class ChangePassword extends JPanel {
    private JPanel mainPanel;
    private JButton 确认保存Button;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private User user;

    private UserService userService = ServiceFactory.getUserServiceInstance();

    public ChangePassword(User user) {
        this.user = user;
        add(mainPanel);
        String oldPassword = new String(passwordField1.getPassword());
        String newPassword = new String(passwordField2.getPassword());
        String confirmPassword = new String(passwordField3.getPassword());

        确认保存Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oldPassword.equals(user.getPassword())){
                    if (newPassword!=null){
                        if (newPassword.equals(oldPassword)){
                            JOptionPane.showConfirmDialog(null, "不能与原密码一致！");
                        }else {
                            if (confirmPassword.equals(newPassword)){
                                userService.changePassword(user.getAccount(),newPassword);
                                JOptionPane.showConfirmDialog(null, "重置成功！");
                            }else {
                                JOptionPane.showConfirmDialog(null, "两次输入密码不一致");
                            }
                        }
                    }else {
                        JOptionPane.showConfirmDialog(null, "不能为空！");
                    }
                } else{
                    JOptionPane.showConfirmDialog(null, "原密码错误！");
                }
            }
        });
    }

}
