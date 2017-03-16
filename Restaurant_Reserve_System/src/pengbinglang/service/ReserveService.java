package pengbinglang.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import pengbinglang.dao.ReserveDao;
import pengbinglang.entity.OrderTab;

public class ReserveService {

	private ReserveDao rDao = new ReserveDao();
	private SimpleDateFormat timeF = new SimpleDateFormat("HH:mm");

	/**
	 * �õ�����ÿ�����ӵ�Ԥ��ʱ���б�
	 * 
	 * @param dateS
	 * @return *�����*
	 */
	public String[] getReserveString(String dateS) {
		List<OrderTab> list = rDao.getReserveList(dateS);
		int len = rDao.getTablecount();
		String[] str = new String[len];
		for (int i = 0; i < len; i++) {
			str[i] = "";// ��ʼ��
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getTableID() == i + 1) {
					// ��ʱ�䣺
					String a = list.get(j).getReserveDate().substring(11, 16);
					// ����ʱ�䣺
					String f = "";
					try {
						int b = list.get(j).getTimeLong();// Ԥ��ʱ��
						long c = timeF.parse(a).getTime() + b * 60 * 60 * 1000;
						f = timeF.format(new Date(c));
					} catch (ParseException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					str[i] += a;
					str[i] += "-";
					str[i] += f;
					str[i] += " ; ";
				}
			}
		}
		return str;
	}
}
