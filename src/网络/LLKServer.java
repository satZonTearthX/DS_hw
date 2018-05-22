package 网络;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LLKServer {
	public void start(){
		int x=0;
		int y=0;
		int i=0;
		boolean win =false;
		Socket s1 =null;
		Socket s2 =null;
		ServerSocket ss=null;
		DataOutputStream dos;
		   try{
			    ss=new ServerSocket(22222);

		   }catch(IOException e){
			   e.printStackTrace();
		   }
		   while(true){
			   
			   try{
				   if(i==0){

			    s1 = ss.accept();
			    System.out.println("玩家一连接成功");
			   DataInputStream dis = new DataInputStream(s1.getInputStream());

			   int time =dis.readInt();
			   x=time;
			   dos = new DataOutputStream(s1.getOutputStream());
			   dos.writeInt(time);
			   System.out.println("玩家1所用时间："+x+ "s");

			   i++;
			   //System.out.println("有一个玩家连接成功");}
				   if(i==1){
					    s2 = ss.accept();
					    System.out.println("玩家二连接成功");
						   DataInputStream dis1 = new DataInputStream(s2.getInputStream());

						   int time1 =dis1.readInt();
						   y=time1;
						   System.out.println("玩家2所用时间："+y+ "s");
						   if(x>y){
							   win=true;
						   DataOutputStream dos1 = new DataOutputStream(s2.getOutputStream());
						   dos.writeUTF("玩家2获胜");
						   dos1.writeUTF("玩家2获胜");
						   }
						   if(x<y){
							   win=false;
						   DataOutputStream dos1 = new DataOutputStream(s2.getOutputStream());
						   dos.writeUTF("玩家1获胜");
						   dos1.writeUTF("玩家1获胜");}

						   //System.out.println("另一个玩家连接成功");
				   }}
		   }catch(IOException e){
			   e.printStackTrace();
		   }
		   }
	}
   public static void main(String[] args){
         new LLKServer().start();
   }
}
