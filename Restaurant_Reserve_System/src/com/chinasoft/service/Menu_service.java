package com.chinasoft.service;
import java.util.List;
import com.chinasoft.dao.Jdbc_Menu;
import com.chinasoft.entity.FoodMenu;


public class Menu_service {

	private	 Jdbc_Menu jm = new Jdbc_Menu();
	//  遍历所有的内容
	public String [][] selectAll(){

		List<FoodMenu> list =jm.food();
		//  创建一个二维数组保存的内容
		String [][] data = new String [list.size()][5]; 

		for(int i = 0 ; i < list.size(); i++){
			//  把所有的编号都放在第一列
			data [i][0] = list.get(i).getFoodID()+"";
			//  把所有的name都放在第2列
			data [i][1] = list.get(i).getFoodName();
			//  把所有的介绍都放在第3列
			data [i][2] = list.get(i).getUnitPrice()+"";
			//  把所有的原价都放在第4列
			data [i][3] = list.get(i).getFoodTypeID()+"";
			//  把所有的团价都放在第5列
			data [i][4] = list.get(i).getSaleState()+"";
		}
		return data;
	}
	
	
	
	public String [][] selectTop(int ys){
        
		List<FoodMenu> list =jm.ys_dao(ys);
		//  创建一个二维数组保存的内容
		String [][] data = new String [list.size()][5]; 

		for(int i = 0 ; i < list.size(); i++){
			//  把所有的编号都放在第一列
			data [i][0] = list.get(i).getFoodID()+"";
			//  把所有的name都放在第2列
			data [i][1] = list.get(i).getFoodName();
			//  把所有的介绍都放在第3列
			data [i][2] = list.get(i).getUnitPrice()+"";
			//  把所有的原价都放在第4列
			data [i][3] = list.get(i).getFoodTypeID()+"";
			//  把所有的团价都放在第5列
			data [i][4] = list.get(i).getSaleState()+"";
		}
		return data;
	}
	
	public int Zys(){
		int num = jm.Zhs();
		int i = num % 3 == 0 ? (num/3) : (num/3+1) ;
		return i;
	}
	
	
	
	
	
	


}




