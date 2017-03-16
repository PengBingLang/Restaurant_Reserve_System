package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_XiangMu {
	//  ˽�л����ǵ� URL  USER  PWD
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Restaurant_Reserve_System";
	private final String USER = "sa";
	private final String PWD = "sasa";
	
	public Connection getConnection(){
		Connection con = null;
		try {
			//  ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//  �������ݿ������
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeAll(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs != null){
			rs.close();
		}
		if(ps != null){
			ps.close();
		}
		if(con != null){
			con.close();
		}
	}
	
}
