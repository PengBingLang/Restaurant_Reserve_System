package WangHuiDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionSql {
	String url = "jdbc:sqlserver://localhost:1433;databaseName = Restaurant_Reserve_System";
	String use = "sa";
	String pwd = "sasa";
	public Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url,use,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeAll(Connection con, PreparedStatement ps,ResultSet rs) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
	}
}
