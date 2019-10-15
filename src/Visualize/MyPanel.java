package Visualize;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Main.Calculate;
import javax.swing.*;

public class MyPanel extends JFrame{

    // 定义组件
    JPanel jp1, jp2, jp3, jp4, jp5;
    JLabel jlb1, jlb2, jlb3, ansLabel;
    JButton jb1, jb2;
    JTextField jtf1, jtf2, jtf3;

    // 构造函数
    public MyPanel() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jlb1 = new JLabel("数1");
        jlb2 = new JLabel("运算符");
        jlb3 = new JLabel("数2");
        ansLabel = new JLabel("");

        jb1 = new JButton("计算");
        jb2 = new JButton("取消");

        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        // 设置布局管理
        this.setLayout(new GridLayout(3, 1));

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jb1);
        jp4.add(jb2);

        jp5.add(ansLabel);

        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.valueOf(jtf1.getText());
                String op = jtf2.getText();
                int num2 = Integer.valueOf(jtf3.getText());
                int ans = Calculate.calculate(num1, num2, op);
                String ansText = "计算结果为："+ans;
                ansLabel.setText(ansText);
            }
        });

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setSize(400, 400);
        this.setTitle("计算器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
