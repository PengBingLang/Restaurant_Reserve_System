package pengbinglang.ui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import pengbinglang.dao.LoginDao;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user_Txt;
	private JPasswordField pwd_Txt;
	private JLabel label_2;
	private LoginDao log = new LoginDao();

	public static PageOne pageOne = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("\u767B\u5F55");// 主窗体
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u5DE5\u3000\u53F7");
		label.setBounds(81, 28, 47, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u3000\u7801");
		label_1.setBounds(81, 77, 54, 15);
		contentPane.add(label_1);

		user_Txt = new JTextField();
		user_Txt.setBounds(140, 25, 171, 21);
		contentPane.add(user_Txt);
		user_Txt.setColumns(10);

		pwd_Txt = new JPasswordField();
		pwd_Txt.setBounds(140, 74, 171, 21);
		contentPane.add(pwd_Txt);

		JButton Login_Button = new JButton("\u767B\u3000\u5F55");// 按钮
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = user_Txt.getText();
				String p = pwd_Txt.getText();
				int i = log.getLogin(u, p);
				if (i == 1) {
					label_2.setText("登录成功");
					pageOne = new PageOne(Integer.parseInt(u));
					pageOne.setVisible(true);// 此处跳转
					// 修改关闭方式
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Login.this.dispose();
				} else if (i == 0) {
					label_2.setText("工号或密码错误");
					pwd_Txt.setText("");
				} else {
					label_2.setText("服务器或网络故障");
				}
			}
		});
		Login_Button.setBounds(149, 165, 93, 23);
		contentPane.add(Login_Button);

		label_2 = new JLabel("");
		label_2.setBounds(140, 124, 171, 15);
		contentPane.add(label_2);
	}
}
