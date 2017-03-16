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
	 * ������ݿ�����
	 * 
	 * @return *�����*
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ����������쳣");
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("���ݿ����������쳣");
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * �Ͽ��������ݿ�����
	 * 
	 * @param con
	 * @param ps
	 * @param rs
	 *            *�����*
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
			System.out.println("���ݿ�Ͽ��쳣");
			e.printStackTrace();
		}
	}

	/**
	 * �Ͽ��������ݿ�����
	 * 
	 * @param con
	 * @param ps
	 *            *�����*
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
			System.out.println("���ݿ�Ͽ��쳣");
			e.printStackTrace();
		}
	}
}
