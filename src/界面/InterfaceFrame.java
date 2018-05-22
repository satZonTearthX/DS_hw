package 界面;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import 方法.Music;
import 方法.SortScore;

public class InterfaceFrame extends JFrame {
	/** 版本控制标识 **/
	private static final long serialVersionUID = 1L;
	
	/** 业务逻辑对象 **/
	
	private final static int PANEL_WIGHT = 800;
	private final static int PANEL_HEIGHT =600;
	private final static String PANEL_TITLE_NAME = "连连看大作战";
	
	
	
	public JFrame f2;
	public JButton jb3;
	public JButton jb4;
	public  JButton jb5;
	public JButton jb6;
	public JButton jb7;
	public JButton jb8;
	public JLabel jl1;
	public ImageIcon im;
	
	 int count = 1;
	
	public InterfaceFrame(){
		f2 = new JFrame("消消乐大作战");
		jb3 = new JButton("开始游戏");
		jb4 = new JButton("PvP对战");
		jb5 = new JButton("查看战绩");
		jb6 = new JButton("播放音乐");
		jb7 = new JButton("退出游戏");
		jb8 = new JButton("关闭音乐");
		im = new ImageIcon("选择界面.gif");
		jl1 = new JLabel(im);
	}
	
	public void InterfaceLanch(){
		f2.setSize(1000,700);
    	f2.setLocation(500,300);
    	
    	Font font4 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb3.setFont(font4);
    	
    	Font font5 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb4.setFont(font5);
    	
    	Font font6 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb5.setFont(font6);
    	
    	Font font7 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb6.setFont(font7);
    	
    	Font font8 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb7.setFont(font8);
    	
    	Font font9 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb8.setFont(font9);
    	//字体美化
    	
        f2.getLayeredPane().add(jl1, new Integer(Integer.MIN_VALUE));
	    jl1.setBounds(0,0,im.getIconWidth(), im.getIconHeight());
	    	
	    Container cp1=f2.getContentPane();
	    cp1.setLayout(null);
	    	
	    ((JPanel)cp1).setOpaque(false);//添加背景图片

    	f2.setLayout(null);
    	
    	f2.add(jb3);
    	f2.add(jb4);
    	f2.add(jb5);
    	f2.add(jb6);
    	f2.add(jb7);
    	f2.add(jb8);

    	
    	jb3.setBounds(50,0,300,80);
    	jb4.setBounds(50,100,300,80);
    	jb5.setBounds(50,200,300,80);
    	jb6.setBounds(50,300,300,80);
    	jb7.setBounds(50,500,300,80);
    	jb8.setBounds(50,400,300,80);
    	//操作界面
    	
    	 
  
	
	jb3.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			 f2.setVisible(false);
			 StartGame itf = new StartGame();
			 itf.sendMain(itf);
			 itf.StartLanch();;
		   }
 	});//开始游戏
	
	jb5.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			 f2.setVisible(false);
			 try{
			 SortScore.lllist();
			 SortScore.sortscore();
			 ScoreFrame sf = new ScoreFrame();
			 sf.ScoreLanch();
			 }catch (ClassNotFoundException|IOException e1) {

					e1.printStackTrace();
				}
		   }
	});//查看排行榜
 
	jb6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Music mc = new Music();
			
				mc.playmusic();
			
		}
		
	});//播放音乐
	
	jb7.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		   System.exit(0);
			
		}
	});
	
	jb8.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Music mc2 = new Music();
			
			mc2.stopmusic();
		}
	});//停止播放音乐
	f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f2.setVisible(true);
}
	
	
}
