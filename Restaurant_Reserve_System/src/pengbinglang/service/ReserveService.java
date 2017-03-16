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
	 * 得到当天每个桌子的预定时间列表
	 * 
	 * @param dateS
	 * @return *彭秉浪*
	 */
	public String[] getReserveString(String dateS) {
		List<OrderTab> list = rDao.getReserveList(dateS);
		int len = rDao.getTablecount();
		String[] str = new String[len];
		for (int i = 0; i < len; i++) {
			str[i] = "";// 初始化
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getTableID() == i + 1) {
					// 起订时间：
					String a = list.get(j).getReserveDate().substring(11, 16);
					// 结束时间：
					String f = "";
					try {
						int b = list.get(j).getTimeLong();// 预定时长
						long c = timeF.parse(a).getTime() + b * 60 * 60 * 1000;
						f = timeF.format(new Date(c));
					} catch (ParseException e) {
						// TODO 自动生成的 catch 块
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
