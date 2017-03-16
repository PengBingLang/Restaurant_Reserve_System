package com.chinasoft.service;



import java.util.List;

import com.chinasoft.dao.Jdbc_Menu;
import com.chinasoft.entity.FoodMenu;

public class Select_Salestate {

	Jdbc_Menu jm = new Jdbc_Menu();

	public void S_Salastate(){

		List<FoodMenu> list = jm.food();
	}



}
