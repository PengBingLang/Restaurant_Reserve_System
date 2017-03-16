package com.chinasoft.entity;

public class FoodMenu {

	private int FoodID;
	private String FoodName;
	private double UnitPrice;
	private int FoodTypeID;
	private int SaleState;

	public int getFoodID() {
		return FoodID;
	}

	public void setFoodID(int foodID) {
		FoodID = foodID;
	}

	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public int getFoodTypeID() {
		return FoodTypeID;
	}

	public void setFoodTypeID(int foodTypeID) {
		FoodTypeID = foodTypeID;
	}

	public int getSaleState() {
		return SaleState;
	}

	public void setSaleState(int saleState) {
		SaleState = saleState;
	}

}
