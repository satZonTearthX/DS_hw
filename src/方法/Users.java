package 方法;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable{

	private String intergral = null;
	private String ID = null;
	private String pw = null;
	public static ArrayList<Users> list= new ArrayList<Users>();
	
	
	public Users(String ID,String pw,String intergral){
		this.ID = ID;
		this.pw = pw;
		this.intergral = intergral;
	}//构造方法写入，传参为账号的用户名及密码还有用户积分
	
	
	public static void Olis() throws IOException,ClassNotFoundException{
		File f1 = new File("E:/java/作业/连连看java大作业/id.txt");
		File f2 = new File("E:/java/作业/连连看java大作业/pw.txt");
		File f3 = new File("E:/java/作业/连连看java大作业/intergral.txt");
		
		
		PrintWriter pwr1 = new PrintWriter((new FileWriter(f1,false)));
		PrintWriter pwr2 = new PrintWriter((new FileWriter(f2,false)));
		PrintWriter pwr3 = new PrintWriter((new FileWriter(f3,false)));
		
		for(int i = 0;i<list.size();i++){
			Users tempaccount = new Users(null,null,null);
			tempaccount = list.get(i);
			
			pwr1.append(tempaccount.ID+"\r\n");
			pwr1.flush();
			
			
			pwr2.append(tempaccount.pw+ "\r\n");
			pwr2.flush();
			
			
			pwr3.append(tempaccount.intergral +"\r\n");
			pwr3.flush();
			
			
		}
		
		
		
		
		pwr1.close();
		pwr2.close();
		pwr3.close();
		
	}//将集合储存到文件中
	

	
	public static void llist() throws IOException, ClassNotFoundException{
		String oneline1 = null;
		String oneline2 = null;
		String oneline3 = null;
		
		
		File f1 = new File("E:/java/作业/连连看java大作业/id.txt");
		File f2 = new File("E:/java/作业/连连看java大作业/pw.txt");
		File f3 = new File("E:/java/作业/连连看java大作业/intergral.txt");
		
		InputStream is1 = new FileInputStream(f1);
		InputStream is2 = new FileInputStream(f2);
		InputStream is3 = new FileInputStream(f3);
		
		InputStreamReader isr1 = new InputStreamReader(is1);
		InputStreamReader isr2 = new InputStreamReader(is2);
		InputStreamReader isr3 = new InputStreamReader(is3);
		
		BufferedReader br1 = new BufferedReader(isr1);
		BufferedReader br2 = new BufferedReader(isr2);
		BufferedReader br3 = new BufferedReader(isr3);
		
		oneline1 = br1.readLine();
		oneline2 = br2.readLine();
		oneline3 = br3.readLine();
		
		while(oneline1 != null&&oneline2 != null&&oneline3 != null){
			Users tempaccount = new Users(oneline1,oneline2,oneline3);
			list.add(tempaccount);
			oneline1 = br1.readLine();
			oneline2 = br2.readLine();
			oneline3 = br3.readLine();
			
		}
		br1.close();
		br2.close();
		br3.close();
	}//读取
	
	public static void qlis(String yh,String mm,String m) throws IOException,ClassNotFoundException{

		for(int i = 0;i<list.size();i++){
           if(list.get(i).ID.equals(yh)&&list.get(i).pw.equals(mm)){
        	   Integer p = Integer.parseInt(m) ;
        	   list.get(i).intergral = p.toString();
           }

		}
	}//修改用户的游戏成绩
	
	public static ArrayList<Users>  getlist(){
	       return list;
		}
	
		public String getPasswords(){
			return pw;
		}
		public String getCardID(){
			return ID;
		}
		public String getintergral(){
			return intergral;
		}
		
		
	public static int boolaccount(String yh,String pwd){
		for(int n=0;n<list.size();n++){
			if(list.get(n).ID.equals(yh)&&list.get(n).pw.equals(pwd)){
				return n;
			}
		}		
		return -2;	
	}//判断用户密码是否对应

	
}
