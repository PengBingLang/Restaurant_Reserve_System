package com.chinasoft.service;
import java.util.List;
import com.chinasoft.dao.Jdbc_Menu;
import com.chinasoft.entity.FoodMenu;


public class Menu_service {

	private	 Jdbc_Menu jm = new Jdbc_Menu();
	//  �������е�����
	public String [][] selectAll(){

		List<FoodMenu> list =jm.food();
		//  ����һ����ά���鱣�������
		String [][] data = new String [list.size()][5]; 

		for(int i = 0 ; i < list.size(); i++){
			//  �����еı�Ŷ����ڵ�һ��
			data [i][0] = list.get(i).getFoodID()+"";
			//  �����е�name�����ڵ�2��
			data [i][1] = list.get(i).getFoodName();
			//  �����еĽ��ܶ����ڵ�3��
			data [i][2] = list.get(i).getUnitPrice()+"";
			//  �����е�ԭ�۶����ڵ�4��
			data [i][3] = list.get(i).getFoodTypeID()+"";
			//  �����е��ż۶����ڵ�5��
			data [i][4] = list.get(i).getSaleState()+"";
		}
		return data;
	}
	
	
	
	public String [][] selectTop(int ys){
        
		List<FoodMenu> list =jm.ys_dao(ys);
		//  ����һ����ά���鱣�������
		String [][] data = new String [list.size()][5]; 

		for(int i = 0 ; i < list.size(); i++){
			//  �����еı�Ŷ����ڵ�һ��
			data [i][0] = list.get(i).getFoodID()+"";
			//  �����е�name�����ڵ�2��
			data [i][1] = list.get(i).getFoodName();
			//  �����еĽ��ܶ����ڵ�3��
			data [i][2] = list.get(i).getUnitPrice()+"";
			//  �����е�ԭ�۶����ڵ�4��
			data [i][3] = list.get(i).getFoodTypeID()+"";
			//  �����е��ż۶����ڵ�5��
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




