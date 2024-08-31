package com.txws.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

//游戏界面
public class GameJFame extends JFrame implements MouseListener, ActionListener {
    //通过二维数组来记录图片的序号
    int[][] data=new int[5][5];
    int x1=0,y1=0,x2=0,y2=0;
    int number=0;
    boolean fg1=false,fg2=false;
    JMenuItem cxyx=new JMenuItem("重新开始");
    JMenuItem tcyx=new JMenuItem("退出游戏");
    JMenuItem bian=new JMenuItem("何志峰  黄浩瀚");

    public GameJFame(){
        //创建窗口
        initJFame();
        //创建菜单
        initJmun();
        //打乱图片顺序
        initDluan();
        //添加图片
        initImage();

        this.setVisible(true);
    }

    private int initnumy(int y) {
        if(y>=108&&y<=208)
        {
            y=0;
        }else if(y>=212&&y<=312)
        {
            y=1;
        }else if(y>=319&&y<=416)
        {
            y=2;
        }else if(y>=423&&y<=525)
        {
            y=3;
        }else if(y>=527&&y<=630)
        {
            y=4;
        }
        return y;
    }

    private int initnumx(int x) {
        if(x>=37&&x<=139)
        {
            x=0;
        }else if(x>=140&&x<=243)
        {
            x=1;
        }else if(x>=247&&x<=348)
        {
            x=2;
        }else if(x>=353&&x<=453)
        {
            x=3;
        }else if(x>=457&&x<=559)
        {
            x=4;
        }
        return x;
    }

    private void initDluan() {
        Random num=new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5; j++) {
                int index= num.nextInt(4);
                data[i][j]=index;
            }
        }
        initxiao();
    }

    private void initxiao() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                panduanxiao(i,j);
            }
        }
    }

    private void panduanxiao(int x,int y){
        Random num=new Random();
        if(x+2<=4&&data[x][y]==data[x+1][y]&&data[x][y]==data[x+2][y])
        {
            number++;
            for (int i = 0; i < 3; i++) {
                int index = num.nextInt(4);
                data[x + i][y] = index;
            }
            initxiao();
            initImage();
        }else if(x-1>=0&&x+1<=4&&data[x-1][y]==data[x][y]&&data[x-1][y]==data[x+1][y])
        {
            number++;
            for (int i = 0; i < 3; i++) {
                int index=num.nextInt(4);
                data[x+i-1][y]=index;
            }
            initxiao();
            initImage();
        }else if(x-2>=0&&data[x-2][y]==data[x][y]&&data[x][y]==data[x-1][y])
        {
            number++;
            for (int i = 0; i < 3; i++) {
                int index=num.nextInt(4);
                data[x+i-2][y]=index;
            }
            initxiao();
            initImage();
        }else if(y+2<=4&&data[x][y]==data[x][y+2]&&data[x][y]==data[x][y+1])
        {
            number++;
            for (int i = 0; i < 3; i++) {
                int index=num.nextInt(4);
                data[x][y+i]=index;
            }
            initxiao();
            initImage();
        }else if(y-1>=0&&y+1<=4&&data[x][y-1]==data[x][y]&&data[x][y]==data[x][y+1])
        {
            number++;
            for (int i = 0; i < 3; i++) {
                int index=num.nextInt(4);
                data[x][y+i-1]=index;
            }
            initxiao();
            initImage();
        }else if(y-2>=0&&data[x][y-2]==data[x][y]&&data[x][y]==data[x][y-1])
        {
            number++;
            for (int i = 0; i < 3; i++) {
                int index=num.nextInt(4);
                data[x][y+i-2]=index;
            }
            initxiao();
            initImage();
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int index= data[i][j];
                ImageIcon icon=new ImageIcon("C:\\Users\\黄浩瀚\\Desktop\\lol\\untitled\\untitled1\\image\\"+index+".jpg");
                JLabel jLabel1=new JLabel(icon);
                jLabel1.setBounds(105*i+30,105*j+55,105,105);
                jLabel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel1);
            }
        }
        ImageIcon icon1=new ImageIcon("C:\\Users\\黄浩瀚\\Desktop\\lol\\untitled\\untitled1\\image\\backgroud.jpg");
        JLabel  jbl=new JLabel(icon1);
        jbl.setBounds(0,35,600,675);
        this.getContentPane().add(jbl);
        JLabel number1=new JLabel("分数："+number);
        number1.setBounds(0,0,100,50);
        this.getContentPane().add(number1);
        this.getContentPane().repaint();
    }

    private void initJFame(){
        this.setSize(600,700);
        this.setTitle("天下无敌消消乐");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addMouseListener(this);
    }

    private void initJmun(){
        JMenuBar jmb = new JMenuBar();
        JMenu functionjmu1=new JMenu("功能");
        JMenu functionjmu2=new JMenu("关于我们");

        functionjmu1.add(cxyx);
        functionjmu1.add(tcyx);
        functionjmu2.add(bian);

        jmb.add(functionjmu1);
        jmb.add(functionjmu2);

        cxyx.addActionListener(this);
        tcyx.addActionListener(this);

        this.setJMenuBar(jmb);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int codex= e.getX();
        int codey=e.getY();
        System.out.println();
        if(fg1==false) {
            x1=codex;
            y1=codey;
            x1=initnumx(x1);
            y1=initnumy(y1);
            fg1 = true;
            initbian();
        }else if(fg1==true){
            x2=codex;
            y2=codey;
            fg1=false;
            y2=initnumy(y2);
            x2=initnumx(x2);
            inithhuan();
            panduan(x1,y1,x2,y2);
        }
    }

    private void inithhuan() {
        if(data[x1][y1]==5){
            data[x1][y1]=1;
            initImage();
        }else if(data[x1][y1]==4){
            data[x1][y1]=0;
            initImage();
        }else if(data[x1][y1]==6){
            data[x1][y1]=2;
            initImage();
        }else if(data[x1][y1]==7){
            data[x1][y1]=3;
            initImage();
        }
    }

    private void initbian() {
        if(data[x1][y1]==1){
            data[x1][y1]=5;
            initImage();
        }else if(data[x1][y1]==0){
            data[x1][y1]=4;
            initImage();
        }else if(data[x1][y1]==2){
            data[x1][y1]=6;
            initImage();
        }else if(data[x1][y1]==3){
            data[x1][y1]=7;
            initImage();
        }
    }

    //判断是否能换位
    private void panduan(int x1, int y1, int x2, int y2) {
        int temp=0;
        if(Math.abs(x2-x1)==0&&Math.abs(y2-y1)==1||Math.abs(x2-x1)==1&&Math.abs(y2-y1)==0){
            temp=data[x1][y1];
            data[x1][y1]=data[x2][y2];
            data[x2][y2]=temp;
            initImage();
            panduanxiao(x2,y2);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if(obj==cxyx){
            number=0;
            //打乱图片顺序
            initDluan();
            //添加图片
            initImage();
        }else if(obj==tcyx){
            System.exit(0);
        }
    }
}
