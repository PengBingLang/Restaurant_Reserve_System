package pengbinglang.service;

import java.util.List;

import pengbinglang.entity.UserTab;
import pengbinglang.dao.UserSelectDao;

public class UserSelectService {

	public String[][] getUserString() {
		UserSelectDao d = new UserSelectDao();
		List<UserTab> list = d.getUserList();
		String[][] arrS = new String[list.size()][4];

		for (int i = 0; i < list.size(); i++) {
			arrS[i][0] = list.get(i).getUserID() + "";
			arrS[i][1] = d.getUserTypeName(list.get(i).getUserTypeID());
			arrS[i][2] = list.get(i).getUserName();
			arrS[i][3] = list.get(i).getUserPwd();
		}
		return arrS;
	}
}
