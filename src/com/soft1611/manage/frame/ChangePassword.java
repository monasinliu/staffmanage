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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton 确认保存Button;
    private User user;

    private UserService userService = ServiceFactory.getUserServiceInstance();

    public ChangePassword(User user){

        add(mainPanel);


        确认保存Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals(user.getPassword())){
                    if(textField2.getText().equals(textField1.getText())){
                        JOptionPane.showConfirmDialog(null,"不能与原密码一致！");
                    }else if(textField2.getText().equals(textField3.getText())){
                        if(textField2.getText() == null){
                            JOptionPane.showConfirmDialog(null,"不能为空！");
                        }else{
                            userService.changePassword()
                            JOptionPane.showConfirmDialog(null,"重置成功！");
                        }
                    }
                }else{
                    JOptionPane.showConfirmDialog(null,"密码错误！");
                }
            }
        });
    }

}
