//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.event.*;
//import java.util.*;
//import javax.swing.plaf.metal.MetalLookAndFeel;
//import javax.swing.plaf.metal.MetalTheme;
//import javax.swing.plaf.metal.OceanTheme;
//import javax.swing.plaf.metal.DefaultMetalTheme;
//
//public class menutest implements ActionListener {
//    private JFrame f;
//    private JMenuBar mb;
//    private JMenu configMenu,LFmenu,themeMenu;
//    private LinkedHashMap LF;
//    private JRadioButtonMenuItem[] LFitem;
//    private JRadioButtonMenuItem[] themeItem;
//    public static void main(String argv[]) {
//        new menutest();
//    }
//    public menutest() {
//        //Setup JFrame
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        f=new JFrame("JMenuBar Test");
//        f.setSize(400,300);
//        f.setLocationRelativeTo(null);
//        Container cp=f.getContentPane();
//        cp.setLayout(null);
//
//        //Build MenuBar
//        LF=new LinkedHashMap();
//        String plaf="com.sun.java.swing.plaf";
//        LF.put("Metal","javax.swing.plaf.metal.MetalLookAndFeel");
//        LF.put("CDE/Motif", plaf + ".motif.MotifLookAndFeel");
//        LF.put("Windows XP", plaf + ".windows.WindowsLookAndFeel");
//        LF.put("Windows Classic", plaf + ".windows.WindowsClassicLookAndFeel");
//        LF.put("Nimbus","javax.swing.plaf.nimbus.NimbusLookAndFeel");
//        LF.put("GTK+", plaf + ".gtk.GTKLookAndFeel");
//        LF.put("Mac", plaf + ".mac.MacLookAndFeel");
//        mb=new JMenuBar();
//        configMenu=new JMenu("Config");
//        LFmenu=new JMenu("Look & Feel");
//        LFitem=new JRadioButtonMenuItem[LF.size()];
//        ButtonGroup LFgroup=new ButtonGroup(); //包裹選項形成單選效果
//        int i=0;
//        for (String key:LF.keySet()) {
//            LFitem[i]=new JRadioButtonMenuItem(key);
//            LFitem[i].setEnabled(isLookAndFeelSupported(LF.get(key)));  //是否有支援此介面
//            LFmenu.add(LFitem[i]);   //加入選單
//            LFgroup.add(LFitem[i]);  //加入單選群組
//            LFitem[i].addActionListener(this);  //註冊動作事件
//            if (i==0) {LFitem[i].setSelected(true);}  //預設為 Metal 介面
//            ++i;
//        }
//        configMenu.add(LFmenu);
//        themeMenu=new JMenu("Theme");
//        ButtonGroup themeGroup=new ButtonGroup();
//        themeItem=new JRadioButtonMenuItem[2];
//        themeItem[0]=new JRadioButtonMenuItem("Metal");
//        themeItem[1]=new JRadioButtonMenuItem("Ocean");
//        themeItem[0].addActionListener(this);
//        themeItem[1].addActionListener(this);
//        themeItem[0].setSelected(true);
//        themeMenu.add(themeItem[0]);
//        themeMenu.add(themeItem[1]);
//        themeGroup.add(themeItem[0]);
//        themeGroup.add(themeItem[1]);
//        configMenu.add(themeMenu);
//        mb.add(configMenu);
//        f.setJMenuBar(mb);
//        f.setVisible(true);
//
//        //Close JFrame
//        f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        f.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                int result=JOptionPane.showConfirmDialog(f,
//                        "確定要結束程式嗎?",
//                        "確認訊息",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.WARNING_MESSAGE);
//                if (result==JOptionPane.YES_OPTION) {System.exit(0);}
//            }
//        });
//    }
//    public void actionPerformed(ActionEvent e) {
//        String cmd=e.getActionCommand();
//        boolean isLF=cmd.equals("Metal")||cmd.equals("CDE/Motif")||
//                cmd.equals("Windows XP")||cmd.equals("Windows Classic")||
//                cmd.equals("Nimbus")||cmd.equals("GTK+")||
//                cmd.equals("Mac");
//        JOptionPane.showConfirmDialog(f,cmd,"Info",-1);
//        if (isLF) {
//            if (cmd.equals("Metal")) {  //此 if-else 無效可刪除
//                JFrame.setDefaultLookAndFeelDecorated(true);
//                JDialog.setDefaultLookAndFeelDecorated(true);
//            }
//            else {
//                JFrame.setDefaultLookAndFeelDecorated(false);
//                JDialog.setDefaultLookAndFeelDecorated(false);
//            }
//            try {
//                for (String key:LF.keySet()) {
//                    if (cmd.equals(key)) {
//                        UIManager.setLookAndFeel(LF.get(key));  //設定介面
//                        SwingUtilities.updateComponentTreeUI(f);  //更新 UI 設定
//                        //f.pack();
//                    }
//                }
//            }
//            catch(Exception uie) {uie.printStackTrace();}
//        }
//        boolean isTheme=cmd.equals("Metal")||cmd.equals("Ocean");
//        if (isTheme) {
//            if (cmd.equals("Metal")) { //更新主題
//                MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
//            }
//            else {MetalLookAndFeel.setCurrentTheme(new OceanTheme());}
//            try {
//                UIManager.setLookAndFeel(new MetalLookAndFeel()); //設定 Metal 介面
//                SwingUtilities.updateComponentTreeUI(f); //更新 UI 設定
//            }
//            catch(Exception uie) {uie.printStackTrace();}
//            LFitem[0].setSelected(true);
//        }
//    }
//    public boolean isLookAndFeelSupported(String lnfname) { //檢查作業系統是否支持
//        try {
//            Class lnfclass=Class.forName(lnfname);
//            LookAndFeel lnf=(LookAndFeel)(lnfclass.newInstance());
//            return lnf.isSupportedLookAndFeel();
//        }
//        catch(Exception e) {return false;}
//    }
//}
