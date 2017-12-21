package com.soft1611.manage.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *  透明面板
 * @author mona
 * @date 2017/12/20
 */
public class TranslucencePanel extends JPanel {
    private BufferedImage background;

    private float transparency;

    public TranslucencePanel(){
    }



    /**这个方法用来设置JPanel的透明度
     *
     * @param transparency:透明度
     *
     * @return void
     */
    public void setTransparent(float transparency) {
        this.transparency = transparency;
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D graphics2d = (Graphics2D) g.create();
//        graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));
        graphics2d.setColor(getBackground());
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
        graphics2d.dispose();
    }
}
