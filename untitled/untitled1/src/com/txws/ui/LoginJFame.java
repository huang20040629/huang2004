package com.txws.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginJFame extends JFrame {
    public LoginJFame() {
        initJfame();

        ImageIcon icon1=new ImageIcon("C:\\Users\\黄浩瀚\\Desktop\\lol\\untitled\\untitled1\\image\\backgroud2.jpg");
        JLabel  jbl=new JLabel(icon1);
        jbl.setBounds(0,25,600,675);
        this.getContentPane().add(jbl);
        this.getContentPane().repaint();
        JButton jtb=new JButton("登录");
        jtb.setBounds(50,500,100,50);
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点我啊");
            }
        });
        this.getContentPane().add(jtb);

        this.setVisible(true);
    }

    private void initJfame() {
        this.setSize(600,675);
        this.setTitle("天下无敌消消乐");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }
}
