package com.chinasoft.service;

import java.sql.SQLException;

import com.chinasoft.dao.Jdbc_Menu;

public class Insert_service {
	//	int MenuID,String FoodName,double UnitPrice, int FoodTypeID , int SaleState
	Jdbc_Menu jM = new Jdbc_Menu();
	public void Insert_Service(int MenuID,String FoodName,double UnitPrice, int FoodTypeID , int SaleState) throws SQLException {
		
		jM.Insert_Food(MenuID, FoodName, UnitPrice, FoodTypeID, SaleState);

	}
}
