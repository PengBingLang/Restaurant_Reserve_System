package pengbinglang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GuestAddDao extends SqlServer {

	public void getGuestID(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select [GusetID] from [GusetTab]";
		
		try{
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1;
			while (rs.next()){
				//if(i!=){
					
				//}
				//i++;
			}
			
			
		}
		catch(Exception e){}
		finally{}
	}
}
