package 方法;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortScore {

	int[] values = new int[5];
	private String intergral = null;
	private String ID = null;
	private static  SortScore[] values1 = new SortScore[5];
	
	public static ArrayList<SortScore> listm= new ArrayList<SortScore>();
	
	
	public SortScore(String ID,String intergral){
		this.setID(ID);
		this.setIntergral(intergral);
	}//构造方法写入，传参为账号的用户名及密码还有用户积分*/
	
	public static void lllist() throws IOException, ClassNotFoundException{
		String oneline1 = null;
		String oneline3 = null;
		
		
		File f1 = new File("E:/java/作业/连连看java大作业/id.txt");
		File f3 = new File("E:/java/作业/连连看java大作业/intergral.txt");
		
		InputStream is1 = new FileInputStream(f1);
		InputStream is3 = new FileInputStream(f3);
		
		InputStreamReader isr1 = new InputStreamReader(is1);
		InputStreamReader isr3 = new InputStreamReader(is3);
		
		BufferedReader br1 = new BufferedReader(isr1);
		BufferedReader br3 = new BufferedReader(isr3);
		
		oneline1 = br1.readLine();
		oneline3 = br3.readLine();
		
		while(oneline1 != null&&oneline3 != null){
			SortScore tempaccount1 = new SortScore(oneline1,oneline3);
			listm.add(tempaccount1);
			oneline1 = br1.readLine();
			oneline3 = br3.readLine();
		}
		br1.close();
		br3.close();
	}//读取
	
	
	
	public static void sortscore(){
		    SortScore temp;
		    for(int i = 0;i<listm.size();i++){
	        	values1[i] = new SortScore(listm.get(i).ID, listm.get(i).intergral);
		    }
		    
		    for(int i=0;i<values1.length;i++){//趟数
		      for(int j=0;j<values1.length-i-1;j++){//比较次数
		    	  int n1 =Integer.parseInt(values1[j].getIntergral());
		    	  int n2 = Integer.parseInt(values1[j+1].getIntergral());
		        if(Integer.parseInt(values1[j].getIntergral())>(Integer.parseInt(values1[j+1].getIntergral()))){
		          temp=values1[j];
		          values1[j]=values1[j+1];
		          values1[j+1]=temp;
		        }
		      }
		    }

	}//冒泡排序

	public String getIntergral() {
		return intergral;
	}

	public void setIntergral(String intergral) {
		this.intergral = intergral;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public static SortScore[] getVl(){
		return values1;
	}
	
}
