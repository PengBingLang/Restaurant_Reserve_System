package WangHuiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WangHuiEntity.Entity;

public class CheckDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<Entity> selectOrderNumber(){
		String sql = "select OrderNumber from v_check group by OrderNumber";
		ConnectionSql cs = new ConnectionSql();
		con = cs.getConnection();
		List<Entity> list = new ArrayList<Entity>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Entity e = new Entity();
				e.setOrderNumber(rs.getString(1));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cs.closeAll(con, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Entity> selectAll(String orderNumber){
		String sql = "select *from v_check where [OrderNumber] = ?";
		ConnectionSql cs = new ConnectionSql();
		con = cs.getConnection();
		List<Entity> list = new ArrayList<Entity>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orderNumber);
			rs = ps.executeQuery();
			while(rs.next()){
				Entity e = new Entity();
				e.setOrderNumber(rs.getString(1));
				e.setFoodName(rs.getString(2));
				e.setFoodNumber(rs.getInt(3));
				e.setUnitPrice(rs.getDouble(4));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cs.closeAll(con, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void setMoney(double inMoney,double outMoney,String orderNumber){
		String sql = "update [dbo].[OrderTab] set [InMoney] = ? ,[OutMoney] = ? where [OrderNumber] = ?";
		ConnectionSql cs = new ConnectionSql();
		con = cs.getConnection();
		try{
			ps = con.prepareStatement(sql);
			ps.setDouble(1, inMoney);
			ps.setDouble(2, outMoney);
			ps.setString(3, orderNumber);
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				cs.closeAll(con, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
