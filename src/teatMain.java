import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teatMain extends JFrame{
    public teatMain(){
        init();
    }

    protected JLabel jLabel =new JLabel("f");
    private JButton jButton =new JButton(">");
    private JPanel
            jPanel1 =new JPanel(),
            jPanel2 = new JPanel();
    private JLayeredPane jLayeredPane =new JLayeredPane();
    private Timer timer;
    private int Width=30;
    private boolean flag=true;
    private Container cp =new Container();


    private void init(){
        this.setVisible(true);
        this.setResizable(true);
        this.setBounds(500,0,600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        jLabel.setBounds(0,0,600,600);
        jLabel.setBackground(Color.orange);
        jLabel.setOpaque(true);
        jPanel1.setBounds(0,0,30,600);
        jPanel1.setBackground(Color.GREEN);
        jButton.setBounds(0,0,30,600);
        jPanel1.setLayout(null);
        jPanel1.add(jButton);
        jLayeredPane.setSize(this.getWidth(),this.getHeight());
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=!flag;
                System.out.println(flag);
                timer.start();
            }
        });
        timer =new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag==false){
                    if(Width<=200){
                        Width=Width+10;
                        jPanel1.setSize(Width,600);
                    }else {
                        timer.stop();
                        System.out.println("STOP"+Width);
                    }
                }else if(flag==true){
                    if(Width>=40){
                        Width=Width-10;
                        jPanel1.setSize(Width,600);
                    }else {
                        timer.stop();
                        System.out.println("STOP"+Width);
                    }
                }
            }
        });
        jLayeredPane.add(jLabel,JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(jPanel1,JLayeredPane.POPUP_LAYER);
        cp.add(jLayeredPane,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new teatMain();
    }

}

