package pengbinglang.ui;

import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import pengbinglang.dao.LoginDao;
import WangHuiUi.Checked;

public class PageOne extends JFrame {

	private JPanel contentPane;
	private JLabel label = null;
	private JButton Button1 = null;
	private JButton Button2 = null;
	private JButton Button3 = null;
	private JButton Button4 = null;
	private JButton Button5 = null;
	private JButton Button6 = null;
	private LoginDao ld = new LoginDao();

	static ShowReserve showRese = null;

	/**
	 * Create the frame.
	 */
	public PageOne(final int ID) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {// 窗口打开时：
				boolean[] b = ld.getJurisdiction(ID);
				Button1.setEnabled(b[0]);
				Button2.setEnabled(b[1]);
				Button3.setEnabled(b[2]);
				Button4.setEnabled(b[3]);
				Button5.setEnabled(b[4]);
			}
		});
		setTitle("\u529F\u80FD\u83DC\u5355");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u672C\u7CFB\u7EDF");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setBounds(29, 10, 395, 30);
		contentPane.add(label);

		Button1 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 修改密码
				PwdChage dialog = new PwdChage(ID);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				PageOne.this.setVisible(false);// pageOne
			}
		});
		Button1.setBounds(29, 64, 93, 23);
		contentPane.add(Button1);

		Button2 = new JButton("\u9884\u5B9A\u5EA7\u4F4D");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 预订座位
				showRese = new ShowReserve();
				showRese.setVisible(true);
				PageOne.this.setVisible(false);// 隐藏当前窗口
			}
		});
		Button2.setBounds(163, 64, 93, 23);
		contentPane.add(Button2);

		Button3 = new JButton("\u5F00\u59CB\u70B9\u83DC");// 开始点菜
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClickFood cf = new ClickFood();
				cf.setVisible(true);
				PageOne.this.setVisible(false);
			}
		});
		Button3.setBounds(29, 116, 93, 23);
		contentPane.add(Button3);

		Button4 = new JButton("\u6536\u94F6\u7CFB\u7EDF");
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 收银系统
				Checked frame = new Checked();
				frame.setVisible(true);
				PageOne.this.setVisible(false);// 隐藏当前窗口
			}
		});
		Button4.setBounds(163, 116, 93, 23);
		contentPane.add(Button4);

		Button5 = new JButton("\u7CFB\u7EDF\u8BBE\u7F6E");
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 系统设置
				SetSystem frame = new SetSystem();
				frame.setVisible(true);
				PageOne.this.setVisible(false);// 隐藏当前窗口
			}
		});
		Button5.setBounds(29, 168, 93, 23);
		contentPane.add(Button5);

		Button6 = new JButton("\u9000\u51FA\u767B\u5F55");// 退出按钮
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 要将每一个子窗口销毁
				if (PageOne.showRese != null) {
					PageOne.showRese.dispose();
				}

				Login login = new Login();
				login.setVisible(true);// 返回上一页面
				// 修改关闭方式
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				PageOne.this.dispose();
			}
		});
		Button6.setBounds(331, 223, 93, 23);
		contentPane.add(Button6);

		JButton btnNewButton = new JButton("\u4F1A\u5458\u6CE8\u518C");// 会员注册
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestAdd ad = new GuestAdd();
				ad.setVisible(true);
				PageOne.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(163, 168, 93, 23);
		contentPane.add(btnNewButton);
	}
}
