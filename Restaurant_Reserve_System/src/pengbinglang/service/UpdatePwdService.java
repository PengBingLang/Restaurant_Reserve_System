package pengbinglang.service;

import pengbinglang.dao.LoginDao;

public class UpdatePwdService {

	private LoginDao ld = new LoginDao();

	/**
	 * �жϲ��޸�����
	 * 
	 * @param id
	 * @param p
	 * @param p1
	 * @param p2
	 * @return *�����*
	 */
	public String updatePWD(int id, String p, String p1, String p2) {
		if (p1.equals(p2)) {
			if (ld.getLogin(id + "", p) == 1) {
				if (ld.upDatePwd(id, p1) == 1) {
					return "�޸ĳɹ�";
				} else {
					return "�޸�ʧ��";
				}
			} else {
				return "ԭ�������";
			}
		} else {
			return "�����������벻һ��";
		}
	}
}
