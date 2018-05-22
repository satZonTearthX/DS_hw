package 界面;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import 方法.SortScore;

public class ScoreFrame{

	private JFrame f4;
	private JPanel jp;
	private JPanel jp1;
	private JPanel jp2;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel[] jls1;
	private JLabel[] jls2;
	private ImageIcon im;
	private JButton jb;
	
	public ScoreFrame(){
		f4 = new JFrame("排行榜");
		jp = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		im = new ImageIcon("排行榜界面.jpg");
		jl1 = new JLabel(im);
		jl2 = new JLabel("用户");
		jl3 = new JLabel("用时");
		jls1 = new JLabel[5];
		jls2 = new JLabel[5];
		
		jb = new JButton("返回");
	}
	
	public void ScoreLanch(){
		f4.setSize(900,700);
		f4.setLocation(500,300);
		
    	f4.setLayout(null);
    	
    	
		//jp.setSize(800,600);
		//jp.setLocation(100,100);
		
		
		jl2.setSize(100,50);
		jl2.setLocation(200,50);
		
		jp1.setSize(200,600);
		jp1.setLocation(150,100);
		
		jl3.setSize(100,50);
		jl3.setLocation(650,50);
		
		jp2.setSize(200,600);
		jp2.setLocation(600,100);
		
		jb.setSize(100,50);
		jb.setLocation(400,550);
		
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		
	    SortScore[] value = SortScore.getVl();
	    for(int i = 0;i<5;i++){
	     jls1[i] = new JLabel(value[i].getID());
	     jls2[i] = new JLabel(value[i].getIntergral() + "s");
	     jp1.add(jls1[i]);
	     jp2.add(jls2[i]);
	    }
	    jp1.setLayout(new GridLayout(5,1));
	    jp2.setLayout(new GridLayout(5,1));
	    
		
		Font font1 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jl2.setFont(font1);
    	
    	Font font2 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jl3.setFont(font2);
    	
    	Font font3 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jb.setFont(font3);
    	
    	Font font4 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls1[1].setFont(font4);
    	
    	Font font5 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls1[2].setFont(font5);
    	
    	Font font6 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls1[3].setFont(font6);
    	
    	Font font7 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls1[4].setFont(font7);
    	
    	Font font8 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls1[0].setFont(font8);
    	
       	Font font9 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls2[1].setFont(font9);
    	
    	Font font10 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls2[2].setFont(font10);
    	
    	Font font11 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls2[3].setFont(font11);
    	
    	Font font12 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls2[4].setFont(font12);
    	
    	Font font13 = new Font("宋体",Font.BOLD |Font.ITALIC,30);
    	jls2[0].setFont(font13);
    	
    	
		
	    f4.getLayeredPane().add(jl1, new Integer(Integer.MIN_VALUE));
	    jl1.setBounds(0,0,im.getIconWidth(), im.getIconHeight());
	    	
	    Container cp1=f4.getContentPane();
	    cp1.setLayout(null);
	    	
	    ((JPanel)cp1).setOpaque(false);

	    f4.add(jp1);
	    f4.add(jp2);
	    f4.add(jp);
	    f4.add(jl2);
	    f4.add(jl3);
	    f4.add(jb);
	    
    	f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f4.setVisible(true);
    	
	}

}
