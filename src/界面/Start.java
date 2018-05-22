package 界面;

import java.awt.Frame;

import 方法.Music;

public class Start {
  
	public static void main(String[] args){
		MainFrame fm = new MainFrame();
		Music music = new Music();
		fm.LanchFrame();
		music.playmusic();
	}//启动
}
