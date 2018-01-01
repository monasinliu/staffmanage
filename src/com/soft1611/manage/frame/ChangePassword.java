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

    private UserService userService = ServiceFactory.getUserServiceInstance();

    public ChangePassword(User user) {
        add(mainPanel);

        确认保存Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(passwordField1.getPassword());
                String newPassword = new String(passwordField2.getPassword());
                String confirmPassword = new String(passwordField3.getPassword());
                if (oldPassword.equals(user.getPassword())){
                    if (newPassword!=null){
                        if (newPassword.equals(oldPassword)){
                            JOptionPane.showMessageDialog(null, "不能与原密码一致！");
                        }else {
                            if (confirmPassword.equals(newPassword)){
                                int n = userService.changePassword(user.getAccount(),newPassword);
                                if (n == 1){
                                    JOptionPane.showMessageDialog(null, "重置成功！");
                                }else {
                                    JOptionPane.showMessageDialog(null, "重置失败！");
                                }
                            }else {
                                JOptionPane.showMessageDialog(null, "两次输入密码不一致");
                            }
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "不能为空！");
                    }
                } else{
                    System.out.println("错误密码："+user.getPassword());
                    JOptionPane.showMessageDialog(null,"原密码错误");
                }
            }
        });
    }

}
