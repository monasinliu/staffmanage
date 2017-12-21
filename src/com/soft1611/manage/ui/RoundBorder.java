package com.soft1611.manage.ui;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * 圆角
 * @author sun
 * @date 2017/12/19
 */
public class RoundBorder implements Border {

    public RoundBorder(){

    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHints(rh);
        g2.setColor(new Color(255,255,255,100));
        g2.drawRoundRect(0, 0, c.getWidth()-1, c.getHeight()-1, 10, 10);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

}
