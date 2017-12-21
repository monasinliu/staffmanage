package com.soft1611.manage.ui;

import javax.swing.*;
import java.awt.*;


/**
 * 绘图面板，可将指定宽度、高度、名称的图片自适应绘制到面板上
 * @author mona
 * @since 2017.9.20
 * @version 1.0
 */
public class ImagePanel extends JPanel{
    private int width;  //宽
    private int height; //高
    private String imgPath;  //图片路径

    public ImagePanel(int width,int height,String imgPath){
        this.height=height;
        this.width=width;
        this.imgPath = imgPath;
        this.setPreferredSize(new Dimension(this.width,this.height));//设置当前面板合适大小
    }

    public ImagePanel(){
        super();    //调用父类构造方法
    }

    /**
     * 重写父类JComponent的paintComponent(Grapghics g)方法，用来进行绘制
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/"+imgPath)); //根据指定图片路径生成图标对象
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.width,this.height,Image.SCALE_FAST));  //将图片按照当前大小自适应
        imageIcon.paintIcon(this,g,0,0);//将图片以填充方式绘制到整个面板上
    }
}
