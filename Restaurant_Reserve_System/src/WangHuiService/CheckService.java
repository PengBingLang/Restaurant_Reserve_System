package WangHuiService;

import java.util.List;

import WangHuiDao.CheckDao;
import WangHuiEntity.Entity;

public class CheckService {
	public String[] getOrderNumber(){
		CheckDao cd = new CheckDao();
		List<Entity> list = cd.selectOrderNumber();
		String[] s = new String[list.size()+1];
		for(int i = 1;i<list.size()+1;i++){
			s[0] = "ÇëÑ¡Ôñ";
			s[i] = list.get(i-1).getOrderNumber();
		}
		return s;
	}
	public String[][] getAll(String orderNumber){
		CheckDao cd = new CheckDao();
		List<Entity> list = cd.selectAll(orderNumber);
		String[][] s = new String[list.size()][4];
		for(int i = 0;i<list.size();i++){
			s[i][0] = list.get(i).getOrderNumber();
			s[i][1] = list.get(i).getFoodName();
			s[i][2] = list.get(i).getFoodNumber()+"";
			s[i][3] = list.get(i).getUnitPrice()+"";
		}
		return s;
	}
	public double getPrice(String orderNumber){
		CheckDao cd = new CheckDao();
		List<Entity> list = cd.selectAll(orderNumber);
		double[][] s = new double[list.size()][4];
		double price = 0;
		double sum = 0;
		for(int i = 0;i<list.size();i++){
			s[i][2] = list.get(i).getFoodNumber();
			s[i][3] = list.get(i).getUnitPrice();
			price = s[i][2]*s[i][3];
			sum = sum + price;
		}
		return sum;
	}
	public void serviceMoney(double inMoney,double outMoney,String orderNumber){
		CheckDao cd = new CheckDao();
		if(outMoney>0){
			cd.setMoney(inMoney, outMoney, orderNumber);
		}
	}
}
