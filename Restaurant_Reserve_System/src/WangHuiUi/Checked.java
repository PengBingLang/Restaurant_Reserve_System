package WangHuiUi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;

import WangHuiService.CheckService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTable;

import pengbinglang.ui.Login;

public class Checked extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JTable table;
	private String[] cols = { "¶©µ¥±àºÅ", "²ËÆ·Ãû³Æ", "²ËÆ·ÊýÁ¿", "²ËÆ·µ¥¼Û" };
	private DefaultTableModel dTM = new DefaultTableModel();
	CheckService cs = new CheckService();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Checked frame = new Checked();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public Checked() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// ¹Ø±ÕÊÂ¼þ
				Login.pageOne.setVisible(true);
			}
		});
		setTitle("\u7ED3\u8D26");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 661, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u8BA2\u5355\u8BE6\u60C5",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0,
						0)));
		panel.setBounds(14, 13, 615, 263);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel orderID = new JLabel("\u8BA2\u5355\u53F7");
		orderID.setForeground(new Color(0, 0, 0));
		orderID.setBounds(45, 35, 53, 18);
		panel.add(orderID);

		final JComboBox comboBox = new JComboBox();
		String[] s = cs.getOrderNumber();
		comboBox.setModel(new DefaultComboBoxModel(s));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(128, 32, 124, 24);
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String OrderNumber = comboBox.getSelectedItem().toString();
				if (!OrderNumber.equals("ÇëÑ¡Ôñ")) {
					btnNewButton.setEnabled(true);
					String[][] s1 = cs.getAll(OrderNumber);
					dTM.setDataVector(s1, cols);
					String price = cs.getPrice(OrderNumber) + "";
					textField.setText(price);
					textField_1.setText(null);
					textField_2.setText(null);
				} else {
					btnNewButton.setEnabled(false);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					dTM.setDataVector(null, cols);
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 77, 587, 178);
		panel.add(scrollPane);
		// ÏÔÊ¾Êý¾Ý
		table = new JTable(dTM);
		table.setFont(new Font("ËÎÌå", Font.BOLD, 15));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\u5408\u8BA1\u91D1\u989D\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 283, 86, 39);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(177, 289, 86, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5143");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblNewLabel_1.setBounds(274, 289, 72, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u6536       \u94F6\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblNewLabel_2.setBounds(90, 335, 86, 25);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 335, 86, 25);
		contentPane.add(textField_1);

		JLabel label = new JLabel("\u5143");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		label.setBounds(274, 336, 72, 25);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u627E       \u96F6\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		label_1.setBounds(90, 385, 86, 18);
		contentPane.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 383, 86, 25);
		contentPane.add(textField_2);

		JLabel label_2 = new JLabel("\u5143");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		label_2.setBounds(274, 386, 72, 25);
		contentPane.add(label_2);

		btnNewButton = new JButton("\u7ED3\u8D26");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double money2 = Double.parseDouble(textField_1.getText());
				double money1 = Double.parseDouble(textField.getText());
				double outMoney = money2 - money1;
				String money3 = money2 - money1 + "";
				if ((money2 - money1) < 0) {
					JOptionPane.showMessageDialog(Checked.this, "Ç®²»¹»");
				} else {
					textField_2.setText(money3);
					JOptionPane.showMessageDialog(Checked.this, "»¶Ó­ÏÂ´Î¹âÁÙ");
				}
				String OrderNumber = comboBox.getSelectedItem().toString();
				if (!OrderNumber.equals("ÇëÑ¡Ôñ")) {
					cs.serviceMoney(money2, outMoney, OrderNumber);
				}
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnNewButton.setBounds(394, 299, 173, 49);
		contentPane.add(btnNewButton);

		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CheckSystem cs = new CheckSystem();
				// cs.setVisible(true);
				// Checked.this.setVisible(false);
				Checked.this.dispose();
				Login.pageOne.setVisible(true);// ·µ»Ø¹¦ÄÜ²Ëµ¥
			}
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button.setBounds(394, 359, 173, 49);
		contentPane.add(button);
	}
}
