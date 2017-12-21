package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Permissions;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.ui.ConfirmDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 *
 * @author mona
 * @date 2017/12/21
 */
public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel upPanel;
    private JPanel centerPanel;
    private JPanel exitPanel;
    private JLabel profileLabel;
    private JPanel leftPanel;
    private JLabel nameLabel;
    private JLabel settingLabel;
    private JLabel cancelLabel;
    private UserService userService = ServiceFactory.getUserServiceInstance();
    private CardLayout cardLayout = new CardLayout();
    private User user;
    private Map<String, java.util.List<Permissions>> permissionsMap;

    Color oldColor = upPanel.getBackground();
    Color newColor = new Color(237,64,64);
    Color labelBlue = new Color(100,149,237);

    public MainFrame(User user) {
        this.user = user;
        init();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);

        exitPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = ConfirmDialog.openDialog("是否退出系统 ?", Color.white);
                System.out.println(n);
                if (n == 1 ){
                    dispose();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exitPanel.setBackground(newColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitPanel.setBackground(oldColor);
            }
        });
        settingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                settingLabel.setForeground(labelBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingLabel.setForeground(Color.white);
            }
        });
        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelLabel.setForeground(labelBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelLabel.setForeground(Color.white);
            }
        });
    }

    private void init() {
        nameLabel.setText(user.getAccount());
        profileLabel.setIcon(setImage(user.getProfile(),100,100));
        permissionsMap = userService.userPermission(user.getAccount());
        setPermissions(permissionsMap);
    }

    private void setPermissions(Map<String, List<Permissions>> permissionsMap) {

    }

    private ImageIcon setImage(byte[] img,int height,int width) {
        ImageIcon imageIcon = new ImageIcon(img);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_FAST));
        //将图片按照当前大小自适应
        return imageIcon;
    }

}
