package com.soft1611.manage.ui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;

/**
 * Created by DELL on 2017/12/19.
 */
public class Style {
    public final static Dimension BUTTON_PRIMARY_SIZE = new Dimension(160, 50);
    public final static Dimension BUTTON_SMALL_SIZE = new Dimension(130,60);
    public final static Dimension BUTTON_BIG_SIZE = new Dimension(270,70);

    public final static Color LightBlue = new Color(225,255,255);
    public final static Color Blue = new Color(135,206,235);
    public final static Color Red = new Color(250, 128, 128);
    public final static Color DeepBlue = new Color(70,130,180);
    public final static Color Orange = new Color(255,127,80);
    public final static Color LightDeepBule = new Color(100,149,237);
    public final static Color BigDeepBule = new Color(65,105,225);
    public final static Color Green = new Color(60,179,113);
    public final static Color White = new Color(240,255,255);

    public static RoundBorder roundBorder = new RoundBorder();

    public final static Font NOMAL_FONT = new Font("微软雅黑", Font.PLAIN, 20);

    /**
     * 主页面偶数
     * @param button
     */
    public static void setEvenMainButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_BIG_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(LightBlue);
        button.setBorder(roundBorder);
    }

    /**
     * 主页面奇数
     * @param button
     */
    public static void setOddMainButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(Blue);
        button.setBorder(roundBorder);
    }

    /**
     * 删除按钮
     * @param button
     */
    public static void setDeleteButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(Red);
        button.setBorder(roundBorder);
    }


    /**
     * 惩按钮
     * @param button
     */
    public static void setPunishButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(DeepBlue);
        button.setBorder(roundBorder);
    }

    /**
     * 奖 按钮
     * @param button
     */
    public static void setRewardButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(Orange);
        button.setBorder(roundBorder);
    }

    /**
     * 修改按钮
     * @param button
     */
    public static void setModificationButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(LightDeepBule);
        button.setBorder(roundBorder);
    }

    /**
     * 确认按钮
     * @param button
     */
    public static void setConfirmButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setBackground(BigDeepBule);
        button.setBorder(roundBorder);
    }

    /**
     * 新增按钮
     * @param button
     */
    public static void setAddButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SMALL_SIZE);
        button.setFont(NOMAL_FONT);
        button.setForeground(Color.white);
        button.setBackground(Green);
        button.setBorder(roundBorder);
    }

    public static void setLabelStyle(JLabel label) {
        label.setForeground(BLUE);
        label.setFont(NOMAL_FONT);
    }

}

