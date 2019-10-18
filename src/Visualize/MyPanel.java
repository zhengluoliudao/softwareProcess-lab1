package Visualize;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Generate.Generate;
import Main.Calculate;
import Operator.Operator;

import javax.swing.*;

public class MyPanel extends JFrame{

    // 定义组件
    JPanel jp1, jp2, jp3, jp4, imagePanel;
    JLabel jlb1, jlb2, jlb3, jlb4, ansLabel, imageLabel;
    JButton jb1, jb2;
    JTextField jtf1, jtf2, jtf3, jtf4;

    // 构造函数
    public MyPanel() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        imagePanel = new JPanel();

        jlb1 = new JLabel("数1");
        jlb2 = new JLabel("运算符");
        jlb3 = new JLabel("数2");
        jlb4 = new JLabel("你的计算结果：");
        imageLabel = new JLabel();
        ansLabel = new JLabel("");

        jb1 = new JButton("判断");
        jb2 = new JButton("出题");

        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jtf4 = new JTextField(10);

        ImageIcon img = new ImageIcon("src/images/logo.jpg");// 创建图片对象
        imageLabel.setIcon(img);

        // 设置布局管理
        this.setLayout(new GridLayout(5,1));

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp1.add(jlb2);
        jp1.add(jtf2);

        jp1.add(jlb3);
        jp1.add(jtf3);

        jp2.add(jlb4);
        jp2.add(jtf4);

        jp3.add(jb1);
        jp3.add(jb2);

        jp4.add(ansLabel);

        imagePanel.add(imageLabel,BorderLayout.CENTER);

        JFrame This = this;

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operator operator = Generate.generateOperator();
                int num1 = Generate.generateNumber();
                int num2 = Generate.generateNumber();
                if (operator.equals(Operator.SUBTRACT)) {
                    while (num1 - num2 < 0) {
                        num1 = Generate.generateNumber();
                        num2 = Generate.generateNumber();
                    }
                }
                jtf1.setText(String.valueOf(num1));
                jtf2.setText(operator.toString());
                jtf3.setText(String.valueOf(num2));
                jtf1.setEditable(false);
                jtf2.setEditable(false);
                jtf3.setEditable(false);
            }
        });

        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s1 = jtf1.getText();
                String opString = jtf2.getText();
                String s2 = jtf3.getText();
                String yourAnsString = jtf4.getText();
                // 处理空输入
                if (s1.equals("") || opString.equals("") || s2.equals("")) {
                    JOptionPane.showMessageDialog(This, "请输入数1、数2及运算符", "警告", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (yourAnsString.equals("")) {
                    JOptionPane.showMessageDialog(This, "请输入结果", "警告", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int num1 = 0, num2 = 0, yourAns = 0;
                Operator op = null;
                try {
                    num1 = Integer.valueOf(s1);
                    op = Operator.getOp(opString);
                    num2 = Integer.valueOf(s2);
                    yourAns = Integer.valueOf(yourAnsString);
                } catch (Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(This, "非法输入", "警告", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // 计算
                int ans = Calculate.calculate(num1, num2, op);
                String ansText="";
                if(ans == yourAns){
                    ansText = "正确结果为："+ ans +" 计算正确!";
                }else{
                    ansText = "正确结果为："+ ans + "   " + " 计算错误!";
                }
                ansLabel.setText(ansText);
                jtf1.setEditable(true);
                jtf2.setEditable(true);
                jtf3.setEditable(true);
            }
        });

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        //this.add(imagePanel);

        this.setSize(800, 800);
        this.setTitle("计算器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);// JFrame最大化
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 让JFrame的关闭按钮起作用
        this.pack();
    }
}
