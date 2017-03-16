package pengbinglang.ui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GuestAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestAdd frame = new GuestAdd();
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
	public GuestAdd() {
		setTitle("\u4F1A\u5458\u6CE8\u518C");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// ¹Ø±ÕÊÂ¼þ
				Login.pageOne.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 242, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		label.setBounds(10, 10, 73, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u521D\u59CB\u79EF\u5206\uFF1A");
		label_1.setBounds(10, 49, 73, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		label_2.setBounds(10, 90, 73, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_3.setBounds(10, 135, 73, 15);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u9884\u5B58\u91D1\u989D\uFF1A");
		label_4.setBounds(10, 180, 73, 15);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("123");
		textField.setBounds(80, 7, 126, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(80, 46, 126, 21);
		contentPane.add(comboBox);

		textField_1 = new JTextField();
		textField_1.setBounds(80, 87, 126, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 132, 126, 21);
		contentPane.add(textField_2);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(80, 177, 126, 21);
		contentPane.add(comboBox_1);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u6CE8\u518C");
		btnNewButton.setBounds(80, 228, 93, 23);
		contentPane.add(btnNewButton);
	}
}
