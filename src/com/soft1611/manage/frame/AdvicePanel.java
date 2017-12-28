package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Advice;
import com.soft1611.manage.service.AdviceService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Created by lenovo on 2017/12/25.
 */
public class AdvicePanel extends JPanel{
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton 新增Button;
    private JTable table1;
    private JPanel topPanel;
    private JPanel tyPanel;
    private JPanel centerPanel;
    private JLabel moreLabel;
    private JScrollPane yPanel;
    private JScrollPane nPanel;
    private JCheckBox unNameBox;
    private java.util.List<Advice>advices;
    private byte[] b;
    private StringBuffer condition = new StringBuffer();
    private StringBuffer condition1 = new StringBuffer();
    private String flag = null;
    private DefaultTableModel dtm1;
    private DefaultTableModel dtm2;
    private int[] rows;
    private int[] rows1;
    private AdviceService adviceService= ServiceFactory.getAdviceServiceInstance();
    java.util.List<Advice> list;
    String account;
    String anonymity = "否";
    public AdvicePanel(String account, Dimension dimension) {
        this.account = account;
        add(mainPanel);
        setPreferredSize(dimension);
        advices = adviceService.queryFilter(" WHERE account = '" + account + "' ");
        if (advices.size() != 0){
            Showtable1();
            centerPanel.setLayout(new GridLayout(2,2));
            JPanel[] panels = new JPanel[4];
            for (int i = 0 ; i < panels.length ; i ++) {
                panels[i] = new JPanel(new BorderLayout());
                JPanel contentPanel = new JPanel();
                JLabel contentLabel = new JLabel(advices.get(i).getContent());
                contentLabel.setFont(new Font("微软雅黑",Font.PLAIN,14));
                contentPanel.add(contentLabel);
                JPanel timePanel = new JPanel();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                JLabel timeLabel = new JLabel(sdf.format(advices.get(i).getTime()));
                timeLabel.setFont(new Font("微软雅黑",Font.PLAIN,10));
                timeLabel.setForeground(Color.BLACK);
                timePanel.add(timeLabel);
                panels[i].add(contentPanel);
                panels[i].add(timePanel,BorderLayout.NORTH);
                centerPanel.add(panels[i]);
            }
            moreLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tyPanel.setVisible(true);
                }
            });
        }else {
            centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,600));
            JLabel label = new JLabel("您还未提出建议！");
            centerPanel.add(label);
            moreLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null,"您未曾提出建议！");
                }
            });
        }

        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(unNameBox.isSelected()){
                    anonymity = "是";
                }else{
                    anonymity = "否";
                }
                Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
                Advice advice = new Advice(account,anonymity,textArea1.getText(),timestamp);
                int n = adviceService.insert(advice);
                if(n != 0 ){
                    JOptionPane.showMessageDialog(null,"提交成功");
                    unNameBox.setSelected(false);
                    textArea1.setText("");
                }else {
                    JOptionPane.showMessageDialog(null,"提交失败");
                }
                //new NewAdviceFrame(AdvicePanel.this);
            }
        });
    }
    public void Showtable1() {
        dtm1 = new DefaultTableModel();
        String[] titles = {"工号","内容", "时间"};
        // 设置表头的标题列
        dtm1.setColumnIdentifiers(titles);
        //给表格设置数据模型
        table1.setModel(dtm1);
        // 将单元格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        // 设置水平方向居中
        r.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table1.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[3];
        //获取到数据库中所有用户信息
        Iterator<Advice> iterator = advices.iterator();
        while (iterator.hasNext()) {
            Advice advice = iterator.next();
            content[0] = advice.getAccount();
            content[1] = advice.getContent();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            content[2] = String.valueOf(advice.getTime());

            dtm1.addRow(content);
        }
        tyPanel.revalidate();
    }

    public void addAdvice(Advice advice) {
        Object[] rowData = {advice.getAccount(),advice.getContent()};
        dtm1.addRow(rowData);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AdvicePanel");
        frame.setContentPane(new AdvicePanel("20010101", new Dimension(500,500)).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
