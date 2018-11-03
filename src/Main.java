import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public Main() {
        init();
    }

    private Container ct;
//    private JProgressBar jProgressBar = new JProgressBar(1, 0, 100);//進度表
    private int
            x = 0,
            y = 0,
            step = 10,
            Textlength,
            count;
    private String
            Text = " private JLabelLabel_Backgrund = new JLabel()," +
            "jLabel_Dialogue = new JLabel(private JButton deBUG = new JButton(" +
            "private Timer timer;private JMenuBar jMenuBar = new JMenuBar();" +
            "private JMenu";
    private boolean
            flag = true,
            U = false,
            D = false,
            L = false,
            R = false;
    private JLabel
            jLabel_Man = new JLabel(new ImageIcon("ManDown.png")),
            jLabel_Dialogue = new JLabel("");
    private JButton
            deBUG = new JButton("22");
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
    private Image image1 = Toolkit.getDefaultToolkit().getImage("NewMap.png");
    private String string[]={"ManUp.png","ManDown.png","ManLeft.png","ManRight.png"};
    private ImageIcon imageIcon[] = new ImageIcon[4];
    private JLayeredPane
            JLayeredPane_Game = new JLayeredPane();
    private JPanel jPanel_Drw;
    private Dimension scr_size = Toolkit.getDefaultToolkit().getScreenSize();
    private void init() {
//        this.setBounds(0, 0, 1843, 1096);
        this.setLocation(50,0);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jMenuBar);
        this.addKeyListener(new myKey());
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //視窗最大化
        ct = this.getContentPane();
        ct.setLayout(new BorderLayout());
        for(int i=0;i<=3;i++){
            imageIcon[i]=new ImageIcon(string[i]);
        }

        /*------------------------Panel_Layout WEST-----------------------*/
        deBUG.setBounds(400,700,50,50);
        deBUG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel_Dialogue.setText("");
                speak();
                timer.start();
            }
        });
        /*------------------------Panel_Layout CENTER-----------------------*/
        JLayeredPane_Game.setPreferredSize(new Dimension(1920,1080));
        jPanel_Drw=new JPanel(){
            public void paintComponent(Graphics g){
                run();
                    g.drawImage(image1,x,y,image1.getWidth(this),
                            image1.getHeight(this),this);
                    repaint();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };
//        jPanel=new JPanel();
//        jPanel.setBackground(Color.YELLOW);
        jPanel_Drw.setBounds(0,0,1920,1080);
        jLabel_Man.setBounds(((int)scr_size.getWidth()/2)-30,((int)scr_size.getHeight()/2)-30,60,60);
//        System.out.println(image1.getWidth(this));
        System.out.println(scr_size.getHeight()+"W:"+scr_size.getWidth());
        /*------------------------Panel_Layout SOUTH-----------------------*/
        jLabel_Dialogue.setBounds(550,700,700,300);
        jLabel_Dialogue.setBackground(Color.WHITE);
        jLabel_Dialogue.setOpaque(true);
        jLabel_Dialogue.setFont(new Font(null,Font.BOLD,20));
        jLabel_Dialogue.setVerticalAlignment(SwingConstants.TOP);
//        jLabel_Dialogue.setPreferredSize(new Dimension(500,100));
        jLabel_Dialogue.setBorder(BorderFactory.createLineBorder(Color.black,5,true));


        /*------------------------Add-----------------------*/
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
        JLayeredPane_Game.add(jPanel_Drw,JLayeredPane.DEFAULT_LAYER);
        JLayeredPane_Game.add(deBUG,JLayeredPane.MODAL_LAYER);
        JLayeredPane_Game.add(jLabel_Man,JLayeredPane.MODAL_LAYER);
        JLayeredPane_Game.add(jLabel_Dialogue,JLayeredPane.DRAG_LAYER);
        ct.add(JLayeredPane_Game,BorderLayout.CENTER);
        this.pack();

    }




    public void speak(){
        count=0;
        Textlength=Text.length();
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count<=Textlength){
                    jLabel_Dialogue.setText("<html><body><p >"+Text.substring(0,count)+"<br/></p></body></html>");
                }
                else{
                    timer.stop();
                }
            }
        });
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


//    private void CheckMap() {  //判斷是否換地圖
//        if(x<-5 || y<-5 || x>1780 || y>1020){
//            BKboolean = !BKboolean;
//            x=700;
//            y=500;
//            if (BKboolean == false) {
//                jLabel_Map.setIcon(new ImageIcon("Map1.png"));
//            } else {
//                jLabel_Map.setIcon(new ImageIcon("a1.jpg"));
//            }
//        }
//    }
    class myKey extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    jLabel_Man.setIcon(imageIcon[2]);
                    L=true;
                    break;
                case KeyEvent.VK_D:
                    jLabel_Man.setIcon(imageIcon[3]);
                    R=true;
                    break;
                case KeyEvent.VK_W:
                    jLabel_Man.setIcon(imageIcon[0]);
                    U=true;
                    break;
                case KeyEvent.VK_S:
                    jLabel_Man.setIcon(imageIcon[1]);
                    D=true;
                    break;
            }
            System.out.println("X:"+x+"Y:"+y);
//            CheckMap();
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
            jLabel_Man.setIcon(imageIcon[1]);
        }

    }
    public void run() {
            if(!U&&!D&&!L&&R){
                if(x>=-2230){
                    x-=step;
                }
            }else if(!U&&!D&&L&&!R){
                if(x<=-10){
                    x+=step;
                }
            }else if(!U&&D&&!L&&!R){
                if(y>=-3120)
                y-=step;
            }else if(U&&!D&&!L&&!R){
                if(y<=-20){
                    y+=step;
                }
            }else if(U&&!D&&L&&!R){
                if(x<=-10&&y<=-20){
                    x+=step;
                    y+=step;
                }
            }else if(!U&&D&&L&&!R){
                if(x<-10&&y>=-3120){
                    x+=step;
                    y-=step;
                }
            }else if(U&&!D&&!L&&R){
                if(x>=-2230&&y<=-20){
                    x-=step;
                    y+=step;
                }

            }else if(!U&&D&&!L&&R){
                if(x>=-2230&&y>=-3120)
                    x-=step;
                    y-=step;

            }
        }
    public static void main(String[] args) {
        new Main();
    }
}