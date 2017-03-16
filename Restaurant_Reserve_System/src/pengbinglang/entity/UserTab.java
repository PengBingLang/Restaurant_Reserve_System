package pengbinglang.entity;

public class UserTab {

	private int UserID;
	private int UserTypeID;
	private String UserName;
	private String UserPwd;

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getUserTypeID() {
		return UserTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		UserTypeID = userTypeID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPwd() {
		return UserPwd;
	}

	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}

}
