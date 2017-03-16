package pengbinglang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlServer {

	private final String URL = "jdbc:sqlserver://localhost:1433;databasename=Restaurant_Reserve_System";
	private final String USER = "sa";
	private final String PWD = "sasa";

	/**
	 * 获得数据库连接
	 * 
	 * @return *彭秉浪*
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载异常");
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("数据库驱动连接异常");
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 断开所有数据库连接
	 * 
	 * @param con
	 * @param ps
	 * @param rs
	 *            *彭秉浪*
	 */
	public void closeAll(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("数据库断开异常");
			e.printStackTrace();
		}
	}

	/**
	 * 断开所有数据库连接
	 * 
	 * @param con
	 * @param ps
	 *            *彭秉浪*
	 */
	public void closeAll(Connection con, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("数据库断开异常");
			e.printStackTrace();
		}
	}
}
