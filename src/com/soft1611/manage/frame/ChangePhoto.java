package com.soft1611.manage.frame;

import com.soft1611.manage.dao.StaffDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.StaffService;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.utils.FileUtils;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.xml.ws.Service;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

/**
 * Created by 朱广旭 on 2017/12/26.
 */
public class ChangePhoto extends JFrame{
    private JPanel mainPanel;
    private JButton photoButton;
    private JButton 确认修改Button;
    private JLabel photoLabel;
    private JLabel oldLabel;
    private JLabel newLabel;
    private byte[] b;
    private User user;
    private byte[] photo;
    private UserService userService = ServiceFactory.getUserServiceInstance();

    public ChangePhoto(User user) {
        this.user = user;
        setTitle("修改头像");
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);

        if(user.getProfile()!=null){
            oldLabel.setIcon(new ImageIcon(user.getProfile()));
        }else{
            oldLabel.setIcon(new ImageIcon("src/img/default.png"));
        }

        photoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int n = chooser.showOpenDialog(ChangePhoto.this);
                if (n == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    b = FileUtils.fileToBytes(file);
                    newLabel.setIcon(new ImageIcon(b));
                }
            }
        });
        确认修改Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            userService.changeProfile(user.getAccount(),b);
            JOptionPane.showMessageDialog(null,"修改成功");
        }
        });
    }

}
