package pengbinglang.dao;

import pengbinglang.entity.UserTab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSelectDao extends SqlServer {

	/**
	 * ��ѯ����Ա����Ϣ������List
	 * 
	 * @return *�����*
	 */
	public List<UserTab> getUserList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTab> list = new ArrayList<UserTab>();
		String sql = "select * from [UserTab]";

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserTab u = new UserTab();
				u.setUserID(rs.getInt(1));
				u.setUserTypeID(rs.getInt(2));
				u.setUserName(rs.getString(3));
				u.setUserPwd(rs.getString(4));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps, rs);
		}
		return list;
	}

	/**
	 * ����ID��ѯԱ��������
	 * 
	 * @param ID
	 * @return *�����*
	 */
	public String getUserTypeName(int ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select [UserTypeName] from [UserTypeTab] where [UserTypeId] = ?";
		String s = "";

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps, rs);
		}
		return s;
	}

	/**
	 * ɾ��Ա��
	 * 
	 * @param ID
	 * @return *�����*
	 */
	public int deleteUser(int ID) {
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
		String sql = "delete [UserTab] where [UserID] = ?";

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps);
		}
		return i;
	}

	/**
	 * ���Ա��
	 * 
	 * @param ID
	 * @param tID
	 * @param name
	 * @param pwd
	 * @return *�����*
	 */
	public int InsertUser(int ID, int tID, String name, String pwd) {
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
		String sql = "Insert [UserTab] Values (?,?,'";
		sql += name + "','";
		sql += pwd + "')";

		try {
			con = super.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ps.setInt(2, tID);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(con, ps);
		}
		return i;
	}
}
