package ÍøÂç;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PvPGame {
	int time;
	String st=null;
	public PvPGame(int time){
		this.time=time;
	}
	public void run(){
	Socket s=null;
	try {
		 s = new Socket("127.0.0.1",22222);
		//·¢ËÍ¶Ë¿ÚºÅ
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeInt(time);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		 st = dis.readUTF();
		 System.out.print(st);
	
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}}
}
