import javax.swing.*;
import java.awt.event.*;

public  class LoginJFame extends JFrame implements MouseListener {
    //通过fg来判断鼠标是按下还是松开
    int fg=1;

    public LoginJFame(){
        //界面框
        initJFame();
        //背景
        initImage();
        //界面可见
        this.setVisible(true);
    }

    //背景
    private void initImage() {
        //清空原先的图片
        this.getContentPane().removeAll();
        //载入图片
        ImageIcon icon1 = new ImageIcon("image/0"+fg+".jpg");
        JLabel label1 = new JLabel(icon1);
        label1.setBounds(0, 0, 1080, 607);
        this.getContentPane().add(label1);
        //重新把图片画入界面
        this.getContentPane().repaint();
    }

    //界面框
    private void initJFame() {
        this.setSize(1080,607);
        this.setTitle("我勒个豆");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    //按下鼠标
    @Override
    public void mousePressed(MouseEvent e) {
        //获取鼠标所在位置
        int codex=e.getX();
        int codey=e.getY();
        //判断是否在start的位置
        if(codex>=490&&codey>=377||codex<=822&&codey<=430){
            //更新fg为第2张图片
            fg=2;
            //更新图片
            initImage();
        }
    }

    //松开鼠标
    @Override
    public void mouseReleased(MouseEvent e) {
        //获取鼠标位置
        int codex=e.getX();
        int codey=e.getY();
        //判断是否在start的位置
        if(codex>=490&&codey>=377||codex<=822&&codey<=430){
            //更新fg为第3张图片
            fg=1;
            //更新图片
            initImage();
            this.setVisible(false);
            //进入游戏界面
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
