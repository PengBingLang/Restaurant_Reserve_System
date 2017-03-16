package pengbinglang.service;

import pengbinglang.dao.LoginDao;

public class UpdatePwdService {

	private LoginDao ld = new LoginDao();

	/**
	 * 判断并修改密码
	 * 
	 * @param id
	 * @param p
	 * @param p1
	 * @param p2
	 * @return *彭秉浪*
	 */
	public String updatePWD(int id, String p, String p1, String p2) {
		if (p1.equals(p2)) {
			if (ld.getLogin(id + "", p) == 1) {
				if (ld.upDatePwd(id, p1) == 1) {
					return "修改成功";
				} else {
					return "修改失败";
				}
			} else {
				return "原密码错误";
			}
		} else {
			return "两次密码输入不一致";
		}
	}
}
