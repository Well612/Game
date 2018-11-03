import javafx.scene.layout.Border;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class test extends JFrame {
    public test() {
        init();
    }

    private Container ct = new Container();
    //    private JProgressBar jProgressBar = new JProgressBar(1, 0, 100);//進度表
//    private JLayeredPane jLayeredPane = new JLayeredPane();
    private JLabel
            jLabel_Backgrund = new JLabel(),
            jLabel_Dialogue = new JLabel("");
    private JButton deBUG = new JButton("22");
    private int
            x = 150,
            y = 150,
            step = 5,
            Textlength,
            count;
    private String
            Text = "从零开始的整数，指示对象列表中要格式化的元素。" +
            "如果由索引指定的对象是空引用（Visual Basic 中为 Not";
    //            Textlength;
    private boolean
            changbackgrund = true,
            U=false,
            D=false,
            L=false,
            R=false;
    private Timer timer;
    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu
            jMenu1 = new JMenu("選單"),
            jMenu2 = new JMenu("工具"),
            jMenu3 = new JMenu("關於");
    private JMenuItem
            Item1 = new JMenuItem("存檔"),
            Item2 = new JMenuItem("讀取"),
            Item3 = new JMenuItem("設定"),
            Item4 = new JMenuItem("離開"),
            Item5 = new JMenuItem("筆記"),
            Item6 = new JMenuItem("圖鑑"),
            Item7 = new JMenuItem("金手指"),
            Item8 = new JMenuItem("作者介紹"),
            Item9 = new JMenuItem("Null");
    private Image image = Toolkit.getDefaultToolkit().getImage("aa.png");


    private JPanel
            Panel_Layout = new JPanel(new BorderLayout()),
            Panel_Game = new JPanel(null);

    private void init() {
        this.setBounds(100, 10, 1200, 900);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new myKey());
        this.setJMenuBar(jMenuBar);
        ct = this.getContentPane();
        ct.setLayout(new BorderLayout());
//        Panel_Layout.setBounds(0, 0, 1100, 850);
//        jLayeredPane.setPreferredSize(new Dimension(500, 450));
//        jLabel_Backgrund.setPreferredSize(new Dimension(500,500));
//        jLabel_Backgrund.setLocation(0,0);

        jLabel_Dialogue.setPreferredSize(new Dimension(500,100));
        jLabel_Backgrund.setBounds(100,90,800,800);
        jLabel_Backgrund.setIcon(new ImageIcon("a1.jpg"));
//        jLabel_Backgrund.setBackground(Color.YELLOW);
        jLabel_Backgrund.setOpaque(true);
        Panel_Game.setPreferredSize(new Dimension(500,500));
        Panel_Game.setLocation(0,0);
        Panel_Game.setBackground(Color.BLACK);
        deBUG.setBounds(0,0,121,121);
        jLabel_Dialogue.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        count=0;
        Textlength=Text.length();
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count<=Textlength){
                    jLabel_Dialogue.setText("<html><body><p align=\"left\">"+Text.substring(0,count)+"<br/></p></body></html>");
                }
                else{
                    timer.stop();
                }
            }
        });
        deBUG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jMenu1.add(Item1);
        jMenu1.add(Item2);
        jMenu1.add(Item3);
        jMenu1.add(Item4);
        Item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu2.add(Item5);
        jMenu2.add(Item6);
        jMenu2.add(Item7);
        jMenu3.add(Item8);
        jMenu3.add(Item9);
//        jLayeredPane.add(jLabel_Man, JLayeredPane.DRAG_LAYER);
        Panel_Game.add(jLabel_Backgrund);
//        Panel_Game.add()
        ct.add(Panel_Game,BorderLayout.CENTER);
        ct.add(jLabel_Dialogue,BorderLayout.SOUTH);
        ct.add(deBUG,BorderLayout.WEST);
//        ct.add(jLayeredPane, BorderLayout.CENTER);
//        ct.add(Panel_Layout);
    }
//    private Image offScreenImage = null;
//    public void update(Graphics g) { //雙緩衝
//        if(offScreenImage == null)
//        {
//            offScreenImage = this.createImage(800, 600);
//        }
//        Graphics gOffScreen = offScreenImage.getGraphics();
//        Color c = gOffScreen.getColor();
//        gOffScreen.setColor(Color.GREEN);
//        gOffScreen.fillRect(0, 0, 800, 600);
//        gOffScreen.setColor(c);paint(gOffScreen);
//        g.drawImage(offScreenImage, 0, 0, null);
//        }


    public void paint(Graphics g){
        g.setClip(100,100,500,500);
//        jLabel_Backgrund.getGraphicsConfiguration();
        jLabel_Backgrund.paint(g);
//        Panel_Game.getGraphics();
//        Panel_Game.getGraphics();
//        Panel_Layout.paint(g);
        g.drawImage(image,x,y,image.getWidth(this),image.getHeight(this),this);
        repaint();
//        Panel_Game.repaint();
        run();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    public void paint1(Graphics g){
//        jLabel_Backgrund.paint(g);
//        g.drawImage(image,x,y,image.getWidth(this),image.getHeight(this),this);
//        repaint();
//        run();
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public void CheckMap() {  //判斷是否換地圖
        if(x<-5 || y<-5 || x>470 || y>435){
            changbackgrund = !changbackgrund;
            x=200;
            y=200;
            if (changbackgrund == false) {
                jLabel_Backgrund.setIcon(new ImageIcon("a2.jpg"));
            } else {
                jLabel_Backgrund.setIcon(new ImageIcon("a1.jpg"));
            }
        }
    }

    class myKey extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    System.out.println(".Panel_Layout  :  "+Panel_Layout.getBounds());
                    System.out.println(".jLabel_Dialogue  :  "+jLabel_Dialogue.getPreferredSize());
                    System.out.println(".jLabel_Backgrund  :  "+jLabel_Backgrund.getPreferredSize());
                    System.out.println(".Panel_Game  :  "+Panel_Game.getPreferredSize());
                    Panel_Layout.setBounds(0, 0, 1100, 850);
//        jLayeredPane.setPreferredSize(new Dimension(500, 450));
                    L=true;
                    break;
                case KeyEvent.VK_D:
                    R=true;
                    break;
                case KeyEvent.VK_W:
                    U=true;
                    break;
                case KeyEvent.VK_S:
                    D=true;
                    break;
            }
            CheckMap();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    L=false;
                    break;
                case KeyEvent.VK_D:
                    R=false;
                    break;
                case KeyEvent.VK_W:
                    U=false;
                    break;
                case KeyEvent.VK_S:
                    D=false;
                    break;
            }
        }
    }
    public void run() {
        if(!U&&!D&&L&&!R){
            x-=step;
        }else if(!U&&!D&&!L&&R){
            x+=step;
        }else if(U&&!D&&!L&&!R){
            y-=step;
        }else if(!U&&D&&!L&&!R){
            y+=step;
        }else if(U&&!D&&L&&!R){
            x-=step;
            y-=step;
        }else if(!U&&D&&L&&!R){
            x-=step;
            y+=step;
        }else if(U&&!D&&!L&&R){
            x+=step;
            y-=step;
        }else if(!U&&D&&!L&&R){
            x+=step;
            y+=step;
        }
    }
    public static void main(String[] args) {
        new test();
    }
}