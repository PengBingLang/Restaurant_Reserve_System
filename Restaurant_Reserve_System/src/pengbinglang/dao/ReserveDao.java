package pengbinglang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pengbinglang.entity.OrderTab;

public class ReserveDao extends SqlServer {

	/**
	 * 得到指定日期的所有订单时间信息
	 * 
	 * @param date
	 * @return *彭秉浪*
	 */
	public List<OrderTab> getReserveList(String date) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select convert(varchar(50),[ReserveDate],120),[TimeLong],[TableID] from [OrderTab] where convert(varchar(50),[ReserveDate],120) like '"
				+ date + "%'";
		List<OrderTab> list = new ArrayList<OrderTab>();

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderTab order = new OrderTab();
				order.setReserveDate(rs.getString(1));
				order.setTimeLong(rs.getInt(2));
				order.setTableID(rs.getInt(3));
				list.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps, rs);
		}
		return list;
	}

	/**
	 * 得到所有座子的数量
	 * 
	 * @return *彭秉浪*
	 */
	public int getTablecount() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count([TableID]) from [dbo].[TableTab]";
		int a = 0;

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				a = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps, rs);
		}
		return a;
	}
}
