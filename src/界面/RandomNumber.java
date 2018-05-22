package 界面;
import javax.swing.JButton;

import java.util.*;
public class RandomNumber{
	int index;
	
	public RandomNumber(int index){
		this.index = index;
	}
		
    public ArrayList Random(){
        //生成 [0-n) 个不重复的随机数
        // st 用来保存这些随机数
        ArrayList list = new ArrayList();
        
        Random rand = new Random();
        boolean[] bool = new boolean[index];
        
        int num =0;
        
        for (int i = 0; i<index; i++){
            
            do{
                //如果产生的数相同继续循环
                num = rand.nextInt(index);    
             
            }while(bool[num]);
            
            bool[num] =true;
            
            list.add(num);
        
        
        }
        return list;     
}   
    } 
    