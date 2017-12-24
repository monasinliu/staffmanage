package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Announcement;
import com.soft1611.manage.service.AnnounceService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  公告面板
 * @author sry
 * @date 2017/12/24
 */
public class AnnouncePanel extends JPanel{
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel moreLabel;
    private JTable table;
    private JPanel[] panels;
    private AnnounceService announceService = ServiceFactory.getAnnounceServiceInstance();
    private java.util.List<Announcement> announcements;
    private boolean flag = false;

    Color lightBlack = new Color(51,51,51);
    Color anotherBlack = new Color(72,72,72);
    Color lightGrey = new Color(204,204,204);

    public AnnouncePanel() {
        announcements = announceService.readAnnouncement();
        initTable();
        panels = new JPanel[]{panel1,panel2,panel3,panel4};
        for (int i = 0 ; i < panels.length ; i ++){
            JLabel upLabel = new JLabel(announcements.get(i).getTitle());
            JLabel centerLabel = new JLabel(announcements.get(i).getContent());
            upLabel.setFont(new Font("微软雅黑",Font.BOLD,13));
            centerLabel.setFont(new Font("微软雅黑",Font.PLAIN,13));
            if (i/2 == 0 ){
                panels[i].setBackground(Color.white);
                upLabel.setForeground(lightBlack);
                centerLabel.setForeground(lightBlack);
            }else {
                panels[i].setBackground(anotherBlack);
                upLabel.setForeground(lightGrey);
                centerLabel.setForeground(lightGrey);
            }
            JPanel upPanel = new JPanel();
            upPanel.setBackground(panels[i].getBackground());
            JPanel centerPanel = new JPanel();
            centerPanel.setBackground(panels[i].getBackground());
            upPanel.setPreferredSize(new Dimension(panels[i].getWidth(),56));
            centerPanel.setPreferredSize(new Dimension(panels[i].getWidth(),165));
            upPanel.add(upLabel);
            centerPanel.add(centerLabel);
            panels[i].add(upLabel,BorderLayout.NORTH);
            panels[i].add(centerLabel,BorderLayout.CENTER);
        }
        moreLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (flag){
                    rightPanel.setVisible(false);
                }else {
                    rightPanel.setVisible(true);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });
    }

    private void initTable() {
        DefaultTableModel dtm = new DefaultTableModel();
        table.setModel(dtm);
        String[] titles = {"公告标题","公告内容","发布人","发布时间"};
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,dtcr);
        table.getTableHeader().setDefaultRenderer(dtcr);
        dtm.setColumnIdentifiers(titles);
        String[] content = new String[4];
        Iterator<Announcement> iterator = announcements.iterator();
        while (iterator.hasNext()){
            Announcement announcement = iterator.next();
            content[0] = announcement.getTitle();
            content[1] = announcement.getContent();
            content[2] = announcement.getAccount();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            content[3] = sdf.format(announcement.getTime());
            dtm.addRow(content);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AnnouncePanel");
        frame.setContentPane(new AnnouncePanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
