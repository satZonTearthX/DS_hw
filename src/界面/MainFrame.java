package 界面;

import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.font.GraphicAttribute;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.IntPredicate;

import javax.jws.Oneway;
import javax.sql.rowset.WebRowSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.xml.ws.Response;

import org.omg.CORBA.PUBLIC_MEMBER;

import 方法.Users;
import 网络.PvPGame;
import algorithm.Array;
import algorithm.Judge;
import algorithm.Replay;
import algorithm.StepUnit;
import algorithm.Hint;

import javax.swing.JToolBar;

public class StartGame extends JPanel{

	private JFrame f3;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl4;
	private JLabel jl5;
	private JButton jb9;
	private ImageIcon im;
	private Curtain cur;
	private ProgressBar pb;
	
	private JToolBar jtb;
	private JButton jb10;
	private JButton jb11;
	private JButton jb12;
	private JButton jbhint;
	
	private JButton[][] jbs;
	//private JButton[] jbs1;
	private JButton[] jbs2;
	private Replay rp;//each time the way you play
	
	private boolean is_pause = false;
	private GameTimer gt=new GameTimer();
	private AutoPlay ap=new AutoPlay();
	private static String[] yu = new String[10];
 
	private Timer timer  = new Timer();
	private Timer aTimer = new Timer();
	private JLabel jl3 ;
	
	public int[][] matrix;
	public int md,nd,nump,pd;
    private int[] bool;
    private int[] bool1;
    private int[] array;
    private int[] array1;
    
    public static int r = 0;
    public static int rr = 0;
    public static int l = 0;
    public static int ll = 0;
    public static int p = 0;
    public static int x1 = 0;
    public static int y1 = 0;
    public static int x2 = 0;
    public static int y2 = 0;
    public static int pp = 0;
    public static int q = 0;
    public static int qq = 0;
    public static int m = 0;
    public static int ml = 0;
    public static int k = 0;
    public static int kk = 0;
    public static int ss = 0;
    public static String mm = null;

    
    public StartGame sg;
	private JButton jbauto;
	
	 public void sendMain(StartGame s){
		 this.sg = s;
	 }
	//private static final int IMAGE_NUMBER=2;
	//private Image[] image=new Image[IMAGE_NUMBER];
	
	
	
	public StartGame(String[] yu){
		StartGame.yu=yu;
		f3 = new JFrame("连连看大作战");
		jp2 = new JPanel();
		jp1 =  new JPanel();
		jb9 = new JButton("返回大厅");
		jl1 = new JLabel("所用时间:");
		
		im = new ImageIcon("游戏界面.jpg");
		jl2 = new JLabel(im);
		jbs = new JButton[20][20];
		//jbs1 = new JButton[20];	
		jbs2 = new JButton[40];
		jtb = new JToolBar();
		jb10 = new JButton("难度一");
		jb11 = new JButton("难度二");
		jb12 = new JButton("难度三");
		jbhint=new JButton("提示");
		jbauto=new JButton("自动");
		jl4 = new JLabel("                  请开始游戏");
		jl5 = new JLabel("                  游戏中");
		
		

		jl3 = new JLabel("test");
		jp3 = new JPanel();
		
		
		bool = new int[2];
		bool[0] = -1;
		bool[1] = -2;
		
		bool1 = new int[2];
		bool1[0] = -1;
		bool1[1] = -2;
		
		
//		 RandomNumber rn = new RandomNumber(20);
//	        ArrayList list = rn.Random();
	        array = new int[20];
	        Array arr=new Array(4,5,10);
			arr.init();
			md=arr.m;
			nd=arr.n;
			matrix=arr.data;
			for(int i = 1;i<=md;i++){
	        	for(int j = 1;j<=nd;j++){
	        		System.out.printf("%d\t",matrix[i][j]);
	        	}
	        	System.out.println();
			}
	        int count=0;
	        for(int i = 1;i<=md;i++){
	        	for(int j = 1;j<=nd;j++){
	        	//array[i] = (int)list.get(i);
	            
	        		ImageIcon oneIcon1=new ImageIcon("D:/整理好的java作业/数据结构实践大作业/final/连连看java大作业/image/"+ (matrix[i][j]-1)+".png");
	            
	            jbs[i][j] = new JButton(oneIcon1);
	            
	           // jbs1[count]=new JButton(oneIcon1);
	            count++;
	        	}
	        }//难度一
	        
	      RandomNumber rn1 = new RandomNumber(40);
	      ArrayList list1 = rn1.Random();
	        array1 = new int[40];
	        for(int i = 0;i<list1.size();i++){ 
	        	array1[i] = (int)list1.get(i);
	            ImageIcon oneIcon2=new ImageIcon("E:/java/作业/连连看java大作业/image2/"+ array1[i]+".png");
	            jbs2[i] = new JButton(oneIcon2);
	        }//难度二
	        
	     
	}
	
	
	public void StartLanch(){
		f3.setSize(1100,850);
    	f3.setLocation(400,300);
    	f3.setLayout(null);
    	
    	jp1.setLocation(60,110);
        jp1.setSize(600,600);
        
        jp2.setLocation(700,200);
        jp2.setSize(200,40);
        
        jb9.setLocation(750,500);
        jb9.setSize(200,100);
        
        jbhint.setLocation(750,400);
        jbhint.setSize(200, 100);
        
        jbauto.setLocation(750,300);
        jbauto.setSize(200, 100);
        
        jp3.setLocation(10,50);
        jp3.setSize(600,600);
        
        
        jtb.setLocation(0,0);
        jtb.setSize(1000,50);
        
        jb10.setSize(100,50);
        jb11.setSize(100,50);
        jb12.setSize(100,50);
        
        for(int i = 1;i<=md;i++){
        	for(int j = 1;j<=nd;j++){
        
            jbs[i][j].setSize(50,50);
        	}
        }
        for(int i = 0 ; i < 20 ; i++){
     	   jbs2[i].setSize(50,50);
        }

        
        jl1.setBounds(700,300,100,100);
        jp2.setOpaque(false);
        
        f3.getLayeredPane().add(jl2, new Integer(Integer.MIN_VALUE));
    	jl2.setBounds(0, 0, f3.getWidth(), f3.getHeight());// 设置背景标签的位置
     	jl2.setBounds(0, 0, im.getIconWidth(), im.getIconHeight());// 设置背景标签的位置
     	
    	Container cp=f3.getContentPane();
    	cp.setLayout(null);
    	((JPanel)cp).setOpaque(false); //添加背景图片
    	
    	

    	Font font1 = new Font("宋体",Font.PLAIN,25);
    	jl3.setFont(font1);
    	jl3.setForeground(Color.RED);
    	
    	Font font2 = new Font("宋体",Font.PLAIN,25);
    	jl1.setFont(font2);
    	jl1.setForeground(Color.RED);
        
    	Font font4 = new Font("宋体",Font.PLAIN,25);
    	jb10.setFont(font4);
    	
    	Font font5 = new Font("宋体",Font.PLAIN,25);
    	jb11.setFont(font5);
    	
    	Font font6 = new Font("宋体",Font.PLAIN,25);
    	jb12.setFont(font6);
    	
    	Font font7 = new Font("宋体",Font.PLAIN,25);
    	jb9.setFont(font7);
    	
    	Font font111 = new Font("宋体",Font.PLAIN,25);
    	jbhint.setFont(font111);
    	
    	//Font font111 = new Font("宋体",Font.PLAIN,25);
    	jbauto.setFont(font111);
    	Font font8 = new Font("宋体",Font.PLAIN,25);
    	jl4.setFont(font8);
    	
    	Font font9 = new Font("宋体",Font.PLAIN,25);
    	jl5.setFont(font9);//美化字体
    	
    	jl5.setVisible(false);
        
        
        TextButton tb = new TextButton();
     
       for(int i = 1;i<=md;i++){
       	for(int j = 1;j<=nd;j++){
       
           jbs[i][j].addActionListener(tb);
       	}
       }
//       for(int i = 1;i<=md;i++){
//          	for(int j = 1;j<=nd;j++){
//       jbs[i][j].setOpaque(false);  
//       jbs[i][j].setContentAreaFilled(false);  
//       jbs[i][j].setMargin(new Insets(0, 0, 0, 0));  
//       jbs[i][j].setFocusPainted(false);  
//       jbs[i][j].setBorderPainted(false);  
//       jbs[i][j].setBorder(null);  
//          	}}
       TextButtonlevel2 tb2 = new TextButtonlevel2();
       for(int i = 0 ; i < jbs2.length ; i++){
    	   jbs2[i].addActionListener(tb2);
       }//将按钮数组中添加监听器

    
    	
    	
    	jp1.setLayout(new GridLayout(4,5));
    	jp3.setLayout(new GridLayout(5,8));

    	
    	chooselevel1 ch1 = new chooselevel1();
    	jb10.addActionListener(ch1);
    	jb11.addActionListener(ch1);
    	jb12.addActionListener(ch1);
    	
    	chooselevel2 ch2 = new chooselevel2();
    	jb10.addActionListener(ch2);
    	jb11.addActionListener(ch2);
    	jb12.addActionListener(ch2);
    	
    	 jbauto.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				ap = new AutoPlay();
 				aTimer.scheduleAtFixedRate(ap, 0, 1000);
                ap.run();      
			  
 				
 		
 				  
 				  
 			}
 		});//提示按钮
    	 
    	 jbhint.addActionListener(new ActionListener() {
  			
 			@Override
 			public void actionPerformed(ActionEvent e) {
// 				  f3.setVisible(false);
// 				  InterfaceFrame itff =  new InterfaceFrame(yu);
// 				  itff.InterfaceLanch();
 				  Hint ht=new Hint(matrix,md,nd);
 				  ht.giveHint();
 				 jbs[ht.hx1][ht.hy1].setBackground(Color.RED);
 				 jbs[ht.hx2][ht.hy2].setBackground(Color.RED);
 		
 				  
 			}
 		});//返回按钮
    	
            jb9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				  f3.setVisible(false);
				  InterfaceFrame itff =  new InterfaceFrame(yu);
				  itff.InterfaceLanch();
			}
		});//返回按钮
            
//            for(int i=0 ; i<20;i++){
//            	jp1.add(jbs1[i]);
//            }
            for(int i = 1;i<=md;i++){
               	for(int j = 1;j<=nd;j++){
               		jp1.add(jbs[i][j]);
                   //jbs[i][j].addActionListener(tb);
               	}
               }//难度一
            
            for(int i=0 ; i<40;i++){
            	jp3.add(jbs2[i]);
            }
            
         
        jtb.add(jb10);   
        jtb.add(jb11);        
        jtb.add(jb12);    
        jtb.add(jl4);
        jtb.add(jl5);
        
        f3.add(jtb);
        f3.add(jp1);
        f3.add(jp3);
        jp2.add(jl1);
    	f3.add(jb9);
    	f3.add(jbhint);
    	f3.add(jbauto);
    	
    	f3.add(jp2);
    	jp2.add(jl3);
    	
    	jp1.setVisible(false);
    	jp3.setVisible(false);

	      //System.out.println(timer);
    	f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	jp2.setVisible(false);
    	f3.setVisible(true);
    	timer.scheduleAtFixedRate(gt, 0, 1000);
        
	}
	
	 class TextButton implements ActionListener
    {
		 
			public void actionPerformed(ActionEvent e){
				if(l % 2 == 0){
					for(int i = 1;i<=md;i++){
						for (int j=1;j<=nd;j++) {
					if(e.getSource() == jbs[i][j]){
						     jbs[i][j].setBackground(Color.RED);
				             //sg.bool[0] = sg.array[i];
				             x1 = i;
				             y1 = j;
				             
						}
					}
					}
					l++;
				}else{
					for(int i = 1;i<=md;i++){
						for (int j=1;j<=nd;j++) {
					if(e.getSource() == jbs[i][j]){
						     jbs[i][j].setBackground(Color.RED);
				             //sg.bool[0] = sg.array[i];
				             x2 = i;
				             y2 = j;
				             
						}
					}
					}
//					for(int i = 0;i<20;i++){
//					
//						if(e.getSource() == jbs1[i]){
//							jbs1[i].setBackground(Color.RED);
//					          sg.bool[1] = sg.array[i];
//					          p = i;
//						}
//					}
					Judge jg=new Judge(matrix,md,nd);
					pd=jg.pd_xiao(x1, y1, x2, y2);
					if(pd!=0){
						jbs[x1][y1].setVisible(false);
						jbs[x2][y2].setVisible(false);
						k=k+2;
						matrix[x1][y1]=0;
						matrix[x2][y2]=0;
						StepUnit sp= new StepUnit(x1, y1, x2, y2, pd, jg.cutx1, jg.cuty1, jg.cutx2, jg.cuty2);
						rp.add(sp);
					}//判断按钮上的图片是否一致
					else{
						m++;
					}
					jbs[x1][y1].setBackground(null);
					jbs[x2][y2].setBackground(null);
					x1 = 0;
					x2 = 0;
					y1=0;
					y2=0;
					
					sg.bool[0] = -1;
					
					sg.bool[1] = -2;
					l++;
				}
				if(k == md*nd){
					int option = JOptionPane.YES_OPTION;
					JOptionPane.showConfirmDialog(null, "您所用的时间" + ss+"s , 点击确定返回大厅", "游戏结束", JOptionPane.YES_OPTION);
					if(option == JOptionPane.YES_OPTION){
						PvPGame pv= new PvPGame(ss);
						pv.run();
						
						try{
							//MainFrame mf = new MainFrame();
							mm = String.valueOf(ss);
							String[] mn = getyu();
	                		 if((Users.boolaccount(mn[1],mn[2]) != -2)){
	                			Users.qlis(mn[1],mn[2],mm); 
	                			Users.Olis();
	                		 }//修改用户的游戏成绩
	                	 }catch (ClassNotFoundException|IOException e1) {

	         				e1.printStackTrace();
	         			}
                        k = 0;
						f3.setVisible(false);
						InterfaceFrame itf = new InterfaceFrame(yu);
						itf.InterfaceLanch();
					}
				}
				
			}
    }//难度一的游戏规则设定
	 
	 class TextButtonlevel2 implements ActionListener
	    {
			 
				public void actionPerformed(ActionEvent e){
					if(ll % 2 == 0){
						for(int i = 0;i<40;i++){
							
						if(e.getSource() == jbs2[i]){
							     jbs2[i].setBackground(Color.RED);
					             sg.bool1[0] = sg.array1[i];
					             qq = i;
							}
						}
						ll++;
					}else{
						for(int i = 0;i<40;i++){
						
							if(e.getSource() == jbs2[i]){
								jbs2[i].setBackground(Color.RED);
						          sg.bool1[1] = sg.array1[i];
						          pp = i;
							}
						}
						if((sg.bool1[0] == sg.bool1[1] + 20)||(sg.bool1[0] == sg.bool1[1]- 20)){
							jbs2[qq].setVisible(false);
							jbs2[pp].setVisible(false);
							kk++;
						}
						else{
							ml++;
						}
						jbs2[pp].setBackground(null);
						jbs2[qq].setBackground(null);
						pp = 0;
						qq = 0;
						sg.bool1[0] = -1;
						
						sg.bool1[1] = -2;
						ll++;
					}
					if(kk == 20){
						int option = JOptionPane.YES_OPTION;
						JOptionPane.showConfirmDialog(null, "您所用的时间" + ss+"s , 点击确定返回大厅", "游戏结束", JOptionPane.YES_OPTION);
						
				
						if(option == JOptionPane.YES_OPTION){
							try{


								//MainFrame mf = new MainFrame();
								mm = String.valueOf(ss);
								String[] mn = getyu();
		                		 if((Users.boolaccount(mn[1],mn[2]) != -2)){
		                			 Users.qlis(mn[1],mn[2],mm);
		                			 Users.Olis();
		                			 
		                		 }
		                	 }catch (ClassNotFoundException|IOException e1) {

		         				e1.printStackTrace();
		         			}
	                        k = 0;
							f3.setVisible(false);
							InterfaceFrame itf = new InterfaceFrame(yu);
							itf.InterfaceLanch();
						}
					}
					
				}
	    }//难度二的游戏规则设定
	 
	 class GameTimer extends TimerTask{
		  private int count_time=0;  
	      private String date;  
		
		public int getTime() {
			return count_time;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 if(!is_pause){ 
	                count_time++;  
	                date=String.valueOf(count_time);  
	                jl3.setText(date);  
	                ss = count_time;
	                
			 }
			 if(k == 10){
				 is_pause = true;
				 
		}//倒计时功能

		
		}
	 }
	 
	 class chooselevel1 implements ActionListener
	 {
		public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == jb10){
					jl4.setVisible(false);
					jl5.setVisible(true);
					jp1.setVisible(true);
	                //cur=new Curtain();
	                
					gt = new GameTimer();
	                  gt.run();      
				      jp2.setVisible(true);
				      rr++;
				}
			
			
		}
		 
	 }
	 
	 class chooselevel2 implements ActionListener
	 {
		public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == jb11){
					jl5 = new JLabel("               游戏中");
					  jp3.setVisible(true);
	                  GameTimer gt = new GameTimer();
	                  gt.run();      
				      jp2.setVisible(true);
				      rr++;
				}
			
			
		}
		 
	 }
	 public static String[] getyu(){
			return yu;
		}
	 
	 class AutoPlay extends TimerTask{
		  private int count_time=0;  
	      private String date;  
		  private int flag;
		  private int count=md*nd;
		public int getTime() {
			return count_time;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int countcopytime=count_time; 
			if(!is_pause){ 
	                count_time++;
	                //countcopytime=count_time;
	              //  date=String.valueOf(count_time);  
	              //  jl3.setText(date);   
	              //  ss = count_time;
	               // int count=md*nd;
	                flag=0;
	                if (count_time % 2 ==0 && countcopytime!=count_time) {
	            	
	   				  Hint ht=new Hint(matrix,md,nd);
	   				  
	   				//  int time;
	   				  while (count>0 && countcopytime!=count_time && count_time % 2 ==0) {
	   						  ht.giveHint();
	   						  jbs[ht.hx1][ht.hy1].setVisible(false);
	   						  jbs[ht.hx2][ht.hy2].setVisible(false);
	   						  matrix[ht.hx1][ht.hy1]=0;
	   						 matrix[ht.hx2][ht.hy2]=0;
	   						  count=count-2;
	   						  System.out.println("++");
	   						  flag=1;
	   						  countcopytime++;
	   				  }
	                }
	                
			 }
			 if(k == 10){
				 is_pause = true;
				 
		}//倒计时功能

		
		}
	 }
 }

	
