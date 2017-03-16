package pengbinglang.ui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ClickFood extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickFood frame = new ClickFood();
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
	public ClickFood() {
		setTitle("\u6B63\u5728\u70B9\u83DC");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// ¹Ø±ÕÊÂ¼þ
				Login.pageOne.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5BA2\u4EBA\u4FE1\u606F",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 424, 77);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u684C\u5B50\u7F16\u53F7\uFF1A");
		label.setBounds(10, 22, 70, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u9884\u5B9A\u65F6\u6BB5\uFF1A");
		label_1.setBounds(187, 22, 70, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u9884 \u5B9A \u4EBA\uFF1A");
		label_2.setBounds(10, 50, 70, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u7528\u9910\u4EBA\u6570\uFF1A");
		label_3.setBounds(187, 47, 70, 15);
		panel.add(label_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(74, 19, 83, 21);
		panel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(253, 19, 83, 21);
		panel.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(253, 44, 83, 21);
		panel.add(comboBox_2);

		textField = new JTextField();
		textField.setText("123");
		textField.setEditable(false);
		textField.setBounds(74, 47, 83, 21);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u53EF\u9009\u83DC\u54C1",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 97, 424, 238);
		contentPane.add(panel_1);
	}
}
