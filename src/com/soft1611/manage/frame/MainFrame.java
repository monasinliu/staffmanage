package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Permissions;
import com.soft1611.manage.model.User;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.ui.ConfirmDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 *  主界面
 * @author sry
 * @date 2017/12/21
 */
public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel upPanel;
    private JPanel centerPanel;
    private JPanel exitPanel;
    private JLabel profileLabel;
    private JLabel nameLabel;
    private JLabel settingLabel;
    private JLabel cancelLabel;
    private JPanel leftPanel;
    private JButton button1;
    private JButton button2;
    private JPanel infoPanel;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel applyPanel;
    private JPanel infoJPanel;
    private JLabel infoLabel;
    private JPanel applyJPanel;
    private JLabel applyLabel;
    private JPanel readAnnouncePanel;
    private JLabel readLabel;
    private UserService userService = ServiceFactory.getUserServiceInstance();
    private CardLayout cardLayout = new CardLayout();
    private User user;
    private int i = 0;
    private Map<String, java.util.List<Permissions>> permissionsMap;
    private List<String> accountManageList = new ArrayList<>();
    private List<String> wageManageList = new ArrayList<>();
    private String permissionManage = "权限管理";
    private boolean permissionFlag = false;
    private Map<String,List<String>> workMap;
    private Staff staff;
    //套账管理
    private SetOfAccountManagePanel setOfAccountManagePanel = new SetOfAccountManagePanel();
    //统计报表
    private StatisticsPanel statisticsPanel = new StatisticsPanel();
    //个人资料
    private InfoPanel selfPanel ;
    //出勤记录
    private InfoPanel2 attendRecordPanel;
    //薪资记录
    private InfoPanel3 wageRecordPanel;

    Color oldColor = upPanel.getBackground();
    Color newColor = new Color(237,64,64);
    Color labelBlue = new Color(100,149,237);
    Color lightBlack = new Color(51,51,51);
    Color anotherBlack = new Color(72,72,72);
    Color beauGreen = new Color(26,188,156);
    JButton[] buttons = new JButton[]{button1,button2,
                        button3,button4,button5,button6};
    String[] strings = new String[]{"个人资料","出勤记录","薪资记录","奖惩信息",
                            "提出建议","提交申请"};
    String[] panelName = new String[]{"个人资料","出勤记录","薪资记录"};
    JPanel[] addPanels;
    JPanel[] showStaticPanels;
    boolean infoFlag = true;
    boolean applyFlag = true;

    public MainFrame(User user) {
        this.user = user;
        staff = userService.getArchives(user.getAccount());
        selfPanel = new InfoPanel(staff);
        attendRecordPanel = new InfoPanel2(staff);
        wageRecordPanel = new InfoPanel3(staff);
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
                int n = ConfirmDialog.openDialog("是否注销登录 ?",Color.white);
                if (n == 1 ){
                    dispose();
                    new LoginFrame();
                }
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
        infoJPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (infoFlag){
                    infoPanel.setVisible(infoFlag);
                    infoFlag = false;
                }else if (!infoFlag){
                    infoPanel.setVisible(infoFlag);
                    infoFlag = true;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                infoLabel.setForeground(beauGreen);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                infoLabel.setForeground(Color.white);
            }
        });
        applyJPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (applyFlag){
                    applyPanel.setVisible(applyFlag);
                    applyFlag = false;
                }else if (!applyFlag){
                    applyPanel.setVisible(applyFlag);
                    applyFlag = true;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                applyLabel.setForeground(beauGreen);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                applyLabel.setForeground(Color.white);
            }
        });
        readAnnouncePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AnnouncePanel announcePanel = new AnnouncePanel(centerPanel);
                announcePanel.setPreferredSize(new Dimension(centerPanel.getWidth(),centerPanel.getHeight()));
                centerPanel.add(announcePanel,"card1");
                cardLayout.show(centerPanel,"card1");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                readLabel.setForeground(beauGreen);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                readLabel.setForeground(Color.white);
            }
        });
    }

    private void init() {
        centerPanel.setLayout(cardLayout);
        showStaticPanels = new JPanel[]{selfPanel,attendRecordPanel,wageRecordPanel};
        for (int i = 0 ; i < showStaticPanels.length ; i ++){
            centerPanel.add(showStaticPanels[i],panelName[i]);
        }
        Staff archives = userService.getArchives(user.getAccount());
        nameLabel.setText("      "+archives.getName());
        profileLabel.setIcon(setImage(user.getProfile(),100,100));
        permissionsMap = userService.userPermission(user.getAccount());
        for (int i = 0 ; i < buttons.length ; i ++){
            buttons[i].setBackground(lightBlack);
            buttons[i].setFont(new Font("微软雅黑",Font.PLAIN,13));
            buttons[i].setText(strings[i]);
            buttons[i].setForeground(Color.white);
            int index = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    buttons[index].setForeground(beauGreen);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    buttons[index].setForeground(Color.white);
                }
            });
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(index < 3){
                        cardLayout.show(centerPanel,panelName[index]);
                    }else {

                    }
                }
            });
        }
        setPermissions();
    }

    private void setPermissions() {
        workMap = new HashMap<>();
        permissionsMap = userService.userPermission(user.getAccount());
        centerPanel.setLayout(cardLayout);
        Iterator<Map.Entry<String, List<Permissions>>> iterator = permissionsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Permissions>> entry = iterator.next();
            String groupName = entry.getKey();
            if ("基本信息管理".equals(groupName)||"奖惩管理".equals(groupName)
                    ||"教育培训".equals(groupName)||"建议反馈".equals(groupName)) {
                accountManageList.add(groupName);
            } else if ("统计报表".equals(groupName)||"套账管理".equals(groupName)
                    ||"人员设置".equals(groupName)) {
                wageManageList.add(groupName);
            } else if (permissionManage.equals(groupName)) {
                permissionFlag = true;
            }
            i++;
        }
        int mapSize = 0;
        if (accountManageList.size() != 0){
            workMap.put("员工管理",accountManageList);
            mapSize ++;
        }
        if (wageManageList.size()!=0){
            workMap.put("财务管理",wageManageList);
            mapSize ++;
        }
        if (permissionFlag){
            workMap.put("权限管理",null);
            mapSize ++;
        }
        leftPanel.setLayout(new GridLayout(mapSize,1));
        addPanels = new JPanel[mapSize];
        final Boolean[] flag  = new Boolean[mapSize];
        int i = 0;
        Iterator<Map.Entry<String, List<String>>> workIterator = workMap.entrySet().iterator();
        while( workIterator.hasNext()){
            flag[i] = false;
            Map.Entry<String, List<String>> entry = workIterator.next();
            String workName = entry.getKey();
            if ("权限管理".equals(workName)){
                addPanels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
                addPanels[i].setPreferredSize(new Dimension(leftPanel.getWidth(),50));
                addPanels[i].setBackground(anotherBlack);
                JLabel label = new JLabel("   "+workName);
                label.setForeground(Color.white);
                label.setFont(new Font("微软雅黑",Font.PLAIN,13));
                addPanels[i].add(label);
                addPanels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setForeground(beauGreen);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setForeground(Color.white);
                    }
                });
                leftPanel.add(addPanels[i]);
            }else {
                addPanels[i] = new JPanel(new GridLayout(2,1));
                addPanels[i].setBackground(anotherBlack);
                JLabel label = new JLabel("    "+workName);
                label.setForeground(Color.white);
                label.setFont(new Font("微软雅黑",Font.PLAIN,13));
                List<String> list = workMap.get(workName);
                JPanel panel = new JPanel(new GridLayout(list.size(),1));
                panel.setBackground(lightBlack);
                JButton[] buttons = new JButton[list.size()];
                addButtons(panel, buttons,list);
                panel.setVisible(false);
                addPanels[i].add(label);
                addPanels[i].add(panel);
                int index = i;
                addPanels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (flag[index]){
                            panel.setVisible(false);
                            flag[index] = false;
                        }else if (!flag[index]){
                            panel.setVisible(true);
                            flag[index] = true;
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setForeground(beauGreen);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setForeground(Color.white);
                    }
                });
                leftPanel.add(addPanels[i]);
            }
            i++;
        }
    }

    private void addButtons(JPanel panel,JButton[] buttons,List<String> list) {
        System.out.println(list);
        for (int i = 0 ; i < buttons.length ; i ++){
            buttons[i] = new JButton(list.get(i));
            buttons[i].setBackground(lightBlack);
            buttons[i].setFont(new Font("微软雅黑",Font.PLAIN,13));
            buttons[i].setForeground(Color.white);
            int index = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    buttons[index].setForeground(beauGreen);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    buttons[index].setForeground(Color.white);
                }
            });
            panel.add(buttons[i]);
        }
    }

    private ImageIcon setImage(byte[] img,int height,int width) {
        ImageIcon imageIcon = new ImageIcon(img);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_FAST));
        //将图片按照当前大小自适应
        return imageIcon;
    }

}
