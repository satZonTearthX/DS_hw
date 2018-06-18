package 界面;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;

import 方法.Users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class MainFrame{
	/** 版本控制标识 **/
	private static final long serialVersionUID = 1L;
	
	/** 业务逻辑对象 **/
	
	private final static int PANEL_WIGHT = 800;
	private final static int PANEL_HEIGHT =600;
	private final static String PANEL_TITLE_NAME = "连连看大作战";
	
	
	/** 登陆面板中的控件 **/
	private JFrame f1;
	private JButton jb1;
	private JButton jb2;
	private JTextField jt1;
	private JTextField jt2;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private ImageIcon im;
	private static String[] yu = new String[3];
	
	public MainFrame(){
		f1 = new JFrame("消消乐大作战");
		jb1 = new JButton("登陆游戏");
		jb2 = new JButton("退出游戏");
		jt1 = new JTextField(50);
		jt2 = new JTextField(50);
		jl1 = new JLabel("账号");
		jl2 = new JLabel("密码");
		im = new ImageIcon("登录界面.gif");	
		jl3 = new JLabel(im);
	}
	
	public void LanchFrame(){
    	f1.setSize(1000, 600);
    	f1.setLocation(500,300);
    	
    
    	
    	f1.getLayeredPane().add(jl3, new Integer(Integer.MIN_VALUE));
    	jl3.setBounds(0, 0, f1.getWidth(), f1.getHeight());// 设置背景标签的位置
     	jl3.setBounds(0, 0, im.getIconWidth(), im.getIconHeight());// 设置背景标签的位置
     	
    	Container cp=f1.getContentPane();
    	cp.setLayout(null);
    	((JPanel)cp).setOpaque(false); 
    	
    	Font font1 = new Font("宋体",Font.PLAIN,25);
    	jl1.setFont(font1);
    	
    	Font font2 = new Font("宋体",Font.PLAIN,25);
    	jl2.setFont(font2);
    	
    	Font font3 = new Font("宋体",Font.PLAIN,15);
    	jb1.setFont(font3);
    	
    	Font font4 = new Font("宋体",Font.PLAIN,15);
    	jb2.setFont(font4);
    	
    	
    	f1.setLayout(null);
    	
    	jl1.setBounds(370,150,100,100);
    	jl2.setBounds(370,200,100,100);
    	jt1.setBounds(430,185,200,30);
    	jt2.setBounds(430,235,200,30);
    	jb1.setBounds(450,300,150,30);
    	jb2.setBounds(450,350,150,30);
    
    	
    	f1.add(jl1);
    	f1.add(jt1);
    	f1.add(jl2);
    	f1.add(jt2);
    	f1.add(jb1);
    	f1.add(jb2);
    	
    	

    	
    	jb1.addActionListener(new ActionListener(){
  		   public void actionPerformed(ActionEvent e){
  			  String yh = jt1.getText();//sc1.nextInt();
   			  String mm = jt2.getText();//sc2.nextInt();
   			  
   			  //ButtonMusic bm = new ButtonMusic();
   			  
   			 
  			  try{
  				  Users.llist();
  			  if(Users.boolaccount(yh,mm) != -2){
  				  yu[1] = yh;
  				  yu[2] = mm;
  				  //bm.playmusic();
  				  
  				  InterfaceFrame ifm = new InterfaceFrame();
		 
  				  f1.setVisible(false);
  				  ifm.InterfaceLanch();
  				  
  			  }
  			  else{ 
     			        JOptionPane.showMessageDialog(null, "密码或者账号输入错误", "错误", JOptionPane.ERROR_MESSAGE);
  			  }

  			   }catch (ClassNotFoundException|IOException e1) {

  					e1.printStackTrace();
  				}

  	    			   }
  	    			   });//登录
  	    	
    	
    	jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

    	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}//登陆界面的组件位置的设定
	
	public static String[] getyu(){
		return yu;
	}
	
	

}
