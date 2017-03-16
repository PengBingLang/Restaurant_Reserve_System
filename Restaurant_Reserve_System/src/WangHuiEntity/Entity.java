package WangHuiEntity;

public class Entity {
	private String orderNumber;
	private String FoodName;
	private int FoodNumber;
	private double UnitPrice;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public int getFoodNumber() {
		return FoodNumber;
	}
	public void setFoodNumber(int foodNumber) {
		FoodNumber = foodNumber;
	}
	public double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}
	
}
