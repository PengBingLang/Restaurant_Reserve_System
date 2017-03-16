package pengbinglang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends SqlServer {

	/**
	 * 在数据库查询用户名和密码是否正确
	 * 
	 * @param user
	 * @param pwd
	 * @return *彭秉浪*
	 */
	public int getLogin(String user, String pwd) {
		int userId = 0;
		try {
			userId = Integer.parseInt(user);
		} catch (Exception e) {
			return 0;
		}

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from [UserTab] where [UserID]= ? and [UserPwd] = ?";

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			int u = 0;
			while (rs.next()) {
				u = rs.getInt(1);
			}
			if (u == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		} finally {
			super.closeAll(con, ps, rs);
		}
	}

	/**
	 * 根据ID获取用户权限
	 * 
	 * @param ID
	 * @return *彭秉浪*
	 */
	public boolean[] getJurisdiction(int ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select [Revise_pwd],[Reserve_table],[Order_dishes],[Collect_money],[Set_system] from [UserTypeTab] where [UserTypeId] = (select [UserTypeID] from[dbo].[UserTab] where [UserID] = ?)";
		boolean[] b = new boolean[5];

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			rs = ps.executeQuery();
			while (rs.next()) {
				b[0] = rs.getBoolean(1);
				b[1] = rs.getBoolean(2);
				b[2] = rs.getBoolean(3);
				b[3] = rs.getBoolean(4);
				b[4] = rs.getBoolean(5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps, rs);
		}
		return b;
	}

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param p
	 * @return *彭秉浪*
	 */
	public int upDatePwd(int id, String p) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update [UserTab] set [UserPwd] = '" + p
				+ "' where [UserID] = ?";

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		} finally {
			super.closeAll(con, ps);
		}
	}
}
