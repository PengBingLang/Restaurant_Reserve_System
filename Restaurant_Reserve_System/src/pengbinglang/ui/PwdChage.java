package pengbinglang.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

import pengbinglang.service.UpdatePwdService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PwdChage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel UserId = null;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the dialog.
	 */
	public PwdChage(final int id) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {// 窗口打开
				UserId.setText(id + "");
			}

			public void windowClosing(WindowEvent e) {// 窗口关闭
				Login.pageOne.setVisible(true);// 显示原窗口
			}
		});
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 294, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label = new JLabel("\u5DE5\u3000\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(34, 28, 75, 15);
		contentPanel.add(label);

		UserId = new JLabel("01");
		UserId.setBounds(119, 28, 159, 15);
		contentPanel.add(UserId);

		JLabel label_1 = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(34, 72, 75, 15);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(34, 118, 75, 15);
		contentPanel.add(label_2);

		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(34, 168, 75, 15);
		contentPanel.add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(119, 66, 114, 21);
		contentPanel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(119, 112, 114, 21);
		contentPanel.add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(119, 162, 114, 21);
		contentPanel.add(passwordField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {// 确认修改
						String p = passwordField.getText();
						String p1 = passwordField_1.getText();
						String p2 = passwordField_2.getText();

						UpdatePwdService up = new UpdatePwdService();
						UserId.setText(up.updatePWD(id, p, p1, p2));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
