package com.soft1611.manage.frame;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.service.UserService;
import com.soft1611.manage.service.WageService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  统计报表界面
 * @author sry
 * @date 2017/12/25
 */
public class StatisticsPanel extends JPanel {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel cardPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton addMoreButton;
    private JButton outButton;
    private JTable table1;
    private JPanel card1;
    private JPanel upPanel;
    private JPanel card2;
    private JTable table2;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextField textField1;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel card3;
    private CardLayout cardLayout;
    private WageService wageService = ServiceFactory.getWageServiceInstance();
    private UserService userService = ServiceFactory.getUserServiceInstance();
    private java.util.List<Wage> wages = wageService.readWage();
    private JButton[] buttons = new JButton[]{button1,button2,button3};
    private String[] strings = new String[]{"工资报表","其他报表","图形统计"};
    private JPanel[] panels = new JPanel[]{card1,card2,card3};
    private int[] rows;
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm1 = new DefaultTableModel();

    Color labelBlue = new Color(100,149,237);

    public StatisticsPanel() {
        add(mainPanel);
        initTable1();
        initTable2();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        for (int i = 0 ; i < panels.length ; i ++){
            cardPanel.add(panels[i],"card"+ String.valueOf(i+1));
        }

        for (int i = 0; i < buttons.length ; i ++){
            buttons[i].setPreferredSize(new Dimension(100,30));
            buttons[i].setBackground(Color.white);
            buttons[i].setForeground(labelBlue);
            buttons[i].setText(strings[i]);
            buttons[i].setFont(new Font("微软雅黑",Font.PLAIN,16));
            buttons[i].setBorder(BorderFactory.createLineBorder(labelBlue));
            int index = i+1;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel,"card"+ String.valueOf(index));
                }
            });
        }
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> ids = new ArrayList<>();
                //遍历选中的多行
                for (int i : rows) {
                    ids.add(table1.getValueAt(i, 2).toString());
                }
                //result容量最大就是记录总数
                int[] result = new int[wages.size()];
                //调用批量删除方法，得到一个整型数组（受影响的记录行）
                result = wageService.batchDelete(ids);
                if (result.length != 0) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    //从表格模型中移除掉已经删除的记录
                    for (int i = rows.length - 1; i >= 0; i--) {
                        dtm.removeRow(rows[i]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rows = table1.getSelectedRows();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = searchField.getText().trim();
                wages = wageService.queryLike(keywords);
                int count = dtm.getRowCount();
                for (int i = count - 1; i >= 0; i--) {
                    dtm.removeRow(i);
                }
                for (Wage wage : wages) {
                    add(wage);
                }
            }
        });
        upPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateModel();
            }
        });
    }

    private void initTable2() {
        table2.setModel(dtm1);
        String[] titles = {"姓名","性别","工号","日期","考勤补发"
                ,"考核补发","考勤扣款","考核扣款","个人所得税"
                ,"社保","公积金"};
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        table2.setDefaultRenderer(Object.class,dtcr);
        table2.getTableHeader().setDefaultRenderer(dtcr);
        dtm1.setColumnIdentifiers(titles);
        String[] content = new String[11];
        Iterator<Wage> iterator = wages.iterator();
        while (iterator.hasNext()){
            Wage wage = iterator.next();
            Staff archives = userService.getArchives(wage.getAccount());
            content[0] = archives.getName();
            content[1] = archives.getSex();
            content[2] = wage.getAccount();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            content[3] = sdf.format(wage.getTime());
            content[4] = String.valueOf(wage.getPerfectAttend());
            content[5] = String.valueOf(wage.getGoodAssess());
            content[6] = String.valueOf(wage.getAttendDeduction());
            content[7] = String.valueOf(wage.getAssessDeduction());
            content[8] = String.valueOf(wage.getTax());
            content[9] = String.valueOf(wage.getSocialSecurity());
            content[10] = String.valueOf(wage.getFund());
            dtm1.addRow(content);
        }
    }

    private void updateModel() {
        wages = wageService.readWage();
        int count = dtm.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (Wage wage: wages) {
            add(wage);
        }
    }

    public void add(Wage wage) {
        Staff archives = userService.getArchives(wage.getAccount());
        Object[] rowData = {archives.getName(), archives.getSex()
                , wage.getAccount(), wage.getTime(),wage.getBaseWage(), wage.getShouldDeduct()
                ,wage.getRealWage(),"人民币"};
        dtm.addRow(rowData);
    }

    private void initTable1() {
        table1.setModel(dtm);
        String[] titles = {"姓名","性别","工号","日期","基础工资","应发工资","实发工资","币种"};
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class,dtcr);
        table1.getTableHeader().setDefaultRenderer(dtcr);
        dtm.setColumnIdentifiers(titles);
        String[] content = new String[8];
        Iterator<Wage> iterator = wages.iterator();
        while (iterator.hasNext()){
            Wage wage = iterator.next();
            Staff archives = userService.getArchives(wage.getAccount());
            content[0] = archives.getName();
            content[1] = archives.getSex();
            content[2] = wage.getAccount();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            content[3] = sdf.format(wage.getTime());
            content[4] = String.valueOf(wage.getBaseWage());
            content[5] = String.valueOf(wage.getShouldPay());
            content[6] = String.valueOf(wage.getRealWage());
            content[7] = "人民币";
            dtm.addRow(content);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StatisticsPanel");
        frame.setContentPane(new StatisticsPanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
