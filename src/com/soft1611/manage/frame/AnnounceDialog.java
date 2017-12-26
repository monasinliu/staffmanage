package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Announcement;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

/**
 * 单条公告
 * @author SRY
 */
public class AnnounceDialog extends JDialog {
    private JPanel contentPane;
    private JLabel titleLabel;
    private JLabel contentLabel;
    private JLabel timeLabel;
    private JLabel nameLabel;
    private JLabel exitLabel;
    private UserService userService = ServiceFactory.getUserServiceInstance();
    private Announcement announcement;

    Color newColor = new Color(237,64,64);
    Color anotherBlack = new Color(72,72,72);

    public AnnounceDialog(Announcement announcement) {
        this.announcement = announcement;
        setContentPane(contentPane);
        setUndecorated(true);
        setSize(600,400);
        setModal(true);
        Staff archives = userService.getArchives(announcement.getAccount());
        titleLabel.setText(announcement.getTitle());
        contentLabel.setText(announcement.getContent());
        nameLabel.setText(archives.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeLabel.setText(sdf.format(announcement.getTime()));

        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onOK();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exitLabel.setForeground(newColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitLabel.setForeground(anotherBlack);
            }
        });
    }

    private void onOK() {
        dispose();
    }

}
