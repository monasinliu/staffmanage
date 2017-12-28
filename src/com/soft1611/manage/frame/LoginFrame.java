package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.ui.ConfirmDialog;
import com.soft1611.manage.ui.RoundBorder;
import com.soft1611.manage.ui.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

/**
 *  登录界面
 * @author sry
 * @date 2017/12/20
 */
public class LoginFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel upPanel;
    private JPanel centerPanel;
    private JPanel exitPanel;
    private JPanel loginPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private UserService userService = ServiceFactory.getUserServiceInstance();

    Color oldColor = upPanel.getBackground();
    Color newColor = new Color(237,64,64);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
    RoundBorder roundBorder = new RoundBorder();

    public LoginFrame() {
        init();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
//        setUndecorated(true);
        setVisible(true);

        exitPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = ConfirmDialog.openDialog("是否退出系统 ?",Color.white);
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
    }

    private void init() {
        centerPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/222.jpg")); //根据指定图片路径生成图标对象
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(width,height-50,Image.SCALE_FAST));  //将图片按照当前大小自适应
                imageIcon.paintIcon(this,g,0,0);
            }
        };
        centerPanel.setLayout(null);
        loginPanel = new JPanel();
        loginPanel.setBounds(width/2-30,height/5,width/3+50,height/2+10);
        loginPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        loginPanel.setBackground(new Color(255,255,255,100));
        initLogin();
        upPanel.setPreferredSize(new Dimension(width,50));
        centerPanel.add(loginPanel);
        mainPanel.add(upPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
    }

    private void initLogin() {
        loginPanel.setLayout(new GridLayout(3, 1));
        JPanel[] panels = new JPanel[3];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new FlowLayout(FlowLayout.CENTER,10,40));
        }
        accountField = new JTextField();
        accountField.setBorder(roundBorder);
        Dimension dimension = new Dimension(270, 40);
        accountField.setPreferredSize(dimension);
        passwordField = new JPasswordField();
        passwordField.setBorder(roundBorder);
        passwordField.setPreferredSize(dimension);
        loginButton = new JButton("登 录");
        Style.setAddButtonStyle(loginButton);
        panels[0].add(accountField);
        panels[1].add(passwordField);
        panels[2].add(loginButton);
        for (int i = 0; i < panels.length; i++) {
            panels[i].setOpaque(false);
            loginPanel.add(panels[i]);
        }
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginIn();
            }
        });
    }

    private void loginIn() {
        String account = accountField.getText();
        String password = new String(passwordField.getPassword());
        Map<String, Object> map = userService.userLogin(account, password);
        String info = map.get("flag").toString();
        JOptionPane.showMessageDialog(null, info);
        User user = (User) map.get("user");
        if (user != null) {
            dispose();
                    new MainFrame(user);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
