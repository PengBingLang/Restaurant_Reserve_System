package com.chinasoft.service;



import com.chinasoft.dao.Jdbc_Menu;


public class Update_set_service {
	
	Jdbc_Menu jm = new Jdbc_Menu();
	
	public void U_set(double money , int num1 ,int num2){
		
		jm.update_Set(money, num1, num2);
		
		
	}

}
