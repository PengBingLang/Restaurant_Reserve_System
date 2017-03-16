package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chinasoft.entity.FoodMenu;

public class Jdbc_Menu extends JDBC_XiangMu {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public List<FoodMenu> food() {
		List<FoodMenu> list = new ArrayList<FoodMenu>();
		try {
			// SQL语句
			String sql = "select * from [dbo].[AllFoodMenuTab]";
			// 获取数据库连接
			con = super.getConnection();
			// 创建处理SQL 语句的对象
			ps = con.prepareStatement(sql);
			// 执行SQL语句，并处理结果集
			rs = ps.executeQuery();
			// 循环取出所有的结果集
			while (rs.next()) {
				FoodMenu f = new FoodMenu();
				f.setFoodID(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setUnitPrice(rs.getInt(3));
				f.setFoodTypeID(rs.getInt(4));
				f.setSaleState(rs.getInt(5));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.closeAll(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public void Insert_Food(int MenuID, String FoodName, double UnitPrice,
			int FoodTypeID, int SaleState) throws SQLException {
		try {
			// SQL语句
			String sql = "insert [dbo].[AllFoodMenuTab] values (?,?,?,?,?)";
			// 获取数据库连接
			con = super.getConnection();
			// 创建处理SQL 语句的对象
			ps = con.prepareStatement(sql);
			ps.setInt(1, MenuID);
			ps.setString(2, FoodName);
			ps.setDouble(3, UnitPrice);
			ps.setInt(4, FoodTypeID);
			ps.setInt(5, SaleState);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps, rs);
		}
	}

	public List<FoodMenu> ys_dao(int j) {
		List<FoodMenu> list = new ArrayList<FoodMenu>();
		try {
			String sql = "select top 3 * from [dbo].[AllFoodMenuTab] where [FoodID] not in (select top (3*?) [FoodID] from [dbo].[AllFoodMenuTab])";
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, j);
			rs = ps.executeQuery();
			while (rs.next()) {
				FoodMenu f = new FoodMenu();
				f.setFoodID(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setUnitPrice(rs.getInt(3));
				f.setFoodTypeID(rs.getInt(4));
				f.setSaleState(rs.getInt(5));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int Zhs() {
		int num = 0;
		try {
			String sql = "select count(*) from [dbo].[AllFoodMenuTab]";
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.closeAll(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

	public void update_Set(double money, int num1, int num2) {

		try {
			String sql = "update [dbo].[AllFoodMenuTab] set [UnitPrice] = ? , [SaleState] = ? where [FoodID] = ? ";
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, money);
			ps.setInt(2, num1);
			ps.setInt(3, num2);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
