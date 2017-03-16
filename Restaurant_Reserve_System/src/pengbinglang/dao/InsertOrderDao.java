package pengbinglang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pengbinglang.entity.OrderTab;

public class InsertOrderDao extends SqlServer {

	/**
	 * 将新增的订单添加到数据库
	 * 
	 * @param o
	 * @return *彭秉浪*
	 */
	public int insertOrder(OrderTab o) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "Insert [OrderTab] values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = 0;

		con = super.getConnection();
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, o.getOrderNumber());
			ps.setInt(2, o.getTableID());
			ps.setString(3, o.getReserveDate());
			ps.setInt(4, o.getTimeLong());
			ps.setInt(5, o.getGuestNumber());
			ps.setInt(6, o.getGusetID());
			ps.setString(7, o.getGusetName());
			ps.setString(8, o.getGusetPhome());
			ps.setDouble(9, o.getReserveMoney());
			ps.setDouble(10, o.getConsumptionMoney());
			ps.setDouble(11, o.getInMoney());
			ps.setDouble(12, o.getOutMoney());
			ps.setString(13, o.getMoneyType());
			ps.setString(14, o.getOrder_State());

			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps);
		}
		return i;
	}
}
