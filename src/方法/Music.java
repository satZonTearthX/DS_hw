package 方法;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Music {
	    public static AudioClip aau1;
	    public static AudioClip aau2;
		public static void playmusic(){
			try{
				URL cb1;
				File f1 = new File("背景音乐.wav");
				cb1=f1.toURL();
				//AudioClip aau;
				aau1 = Applet.newAudioClip(cb1);
				aau1.play(); 
				//aau1.loop();
				//System.out.println("可以播放"); 
			}catch(MalformedURLException e){
				
			}
		}
	
	public void stopmusic(){
			try{
				URL cb2;
				File f2 = new File("背景音乐.wav");
				cb2=f2.toURL();
				//AudioClip aau;
				aau2 = Applet.newAudioClip(cb2);
				aau2.stop(); 
				//aau1.loop();
				//System.out.println("可以播放"); 
			}catch(MalformedURLException e){
				   e.printStackTrace();  
			}
	}
}

	

