package pengbinglang.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pengbinglang.service.ReserveService;

public class ShowReserve extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox = null;
	private JComboBox comboBox_1 = null;
	private JComboBox comboBox_2 = null;
	private JLabel label_3 = null;// ��ʾ���ڼ��ı�ǩ
	private JButton btnNewButton = null;
	private JButton btnNewButton_1 = null;
	private JTextField Tabl_1;
	private JTextField Tabl_2;
	private JTextField Tabl_3;
	private JTextField Tabl_4;
	private JTextField Tabl_5;// ��ʾԤ������
	private SimpleDateFormat date_Format = new SimpleDateFormat("yyyy-MM-dd");
	private ReserveService reserveServer = new ReserveService();
	private boolean b = true;

	/**
	 * Create the frame.
	 */
	public ShowReserve() {
		setResizable(false);// ���ڴ�С���ɱ�
		addWindowListener(new WindowAdapter() {
			// ���ڴ�ʱ��
			public void windowOpened(WindowEvent e) {
				onLoad();
			}

			public void windowClosing(WindowEvent e) {// ���ڹر�ʱ
				Login.pageOne.setVisible(true);
			}
		});
		setTitle("\u5EA7\u4F4D\u9884\u8BA2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ùرշ�ʽ
		setBounds(100, 100, 864, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u9884\u5B9A\u65E5\u671F",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 834, 67);
		contentPane.add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("\u524D\u4E00\u5929");// ǰһ�찴ť
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.setSelectedIndex(comboBox_2.getSelectedIndex() - 1);
				b = false;
				updateInformation();
				b = true;
			}
		});
		btnNewButton.setBounds(367, 22, 93, 23);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("\u540E\u4E00\u5929");// ��һ�찴ť
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.setSelectedIndex(comboBox_2.getSelectedIndex() + 1);
				b = false;
				updateInformation();
				b = true;
			}
		});
		btnNewButton_1.setBounds(470, 22, 93, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u4ECA\u3000\u5929");// ���찴ť
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onLoad();
			}
		});
		btnNewButton_2.setBounds(612, 22, 93, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u5237\u3000\u65B0");// ˢ�°�ť
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInformation();
			}
		});
		btnNewButton_3.setBounds(715, 22, 93, 23);
		panel.add(btnNewButton_3);

		comboBox = new JComboBox();// ��
		comboBox.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {// ʧȥ�����¼�
				updateInformation();
			}
		});
		comboBox.setBounds(36, 23, 57, 21);
		panel.add(comboBox);

		comboBox_1 = new JComboBox();// ��
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_1.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {// ʧȥ�����¼�
				updateInformation();
			}
		});
		comboBox_1.setBounds(137, 23, 44, 21);
		panel.add(comboBox_1);

		comboBox_2 = new JComboBox();// ��
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28" }));
		comboBox_2.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {// ʧȥ�����¼�
				b = false;
				updateInformation();
				b = true;
			}
		});
		comboBox_2.setBounds(220, 23, 44, 21);
		panel.add(comboBox_2);

		JLabel label = new JLabel("\u5E74");
		label.setBounds(108, 24, 19, 19);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6708");
		label_1.setBounds(191, 24, 19, 19);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u6708");
		label_2.setBounds(274, 24, 19, 19);
		panel.add(label_2);

		label_3 = new JLabel("\u661F\u671F");
		label_3.setBounds(303, 26, 54, 15);
		panel.add(label_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5EA7\u4F4D",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 87, 834, 232);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton button = new JButton("\u9884\u5B9A\u672C\u684C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ���Ԥ��1
				showBginReserve("1");
			}
		});
		button.setBounds(6, 19, 81, 41);
		panel_1.add(button);

		JLabel label_4 = new JLabel("1\u53F7\u684C");
		label_4.setBounds(97, 19, 42, 41);
		panel_1.add(label_4);

		Tabl_1 = new JTextField();
		Tabl_1.setBounds(149, 19, 668, 41);
		Tabl_1.setText("\u672A\u9884\u5B9A");
		Tabl_1.setColumns(10);
		panel_1.add(Tabl_1);

		JButton button_1 = new JButton("\u9884\u5B9A\u672C\u684C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ���Ԥ��2
				showBginReserve("2");
			}
		});
		button_1.setBounds(6, 60, 81, 41);
		panel_1.add(button_1);

		JLabel label_5 = new JLabel("2\u53F7\u684C");
		label_5.setBounds(97, 60, 42, 41);
		panel_1.add(label_5);

		Tabl_2 = new JTextField();
		Tabl_2.setBounds(149, 60, 668, 41);
		Tabl_2.setText("\u672A\u9884\u5B9A");
		Tabl_2.setColumns(10);
		panel_1.add(Tabl_2);

		JButton button_2 = new JButton("\u9884\u5B9A\u672C\u684C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ���Ԥ��3
				showBginReserve("3");
			}
		});
		button_2.setBounds(6, 101, 81, 41);
		panel_1.add(button_2);

		JLabel label_6 = new JLabel("3\u53F7\u684C");
		label_6.setBounds(97, 101, 42, 41);
		panel_1.add(label_6);

		Tabl_3 = new JTextField();
		Tabl_3.setBounds(149, 101, 668, 41);
		Tabl_3.setText("\u672A\u9884\u5B9A");
		Tabl_3.setColumns(10);
		panel_1.add(Tabl_3);

		JButton button_3 = new JButton("\u9884\u5B9A\u672C\u684C");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ���Ԥ��4
				showBginReserve("4");
			}
		});
		button_3.setBounds(6, 142, 81, 41);
		panel_1.add(button_3);

		JLabel label_7 = new JLabel("4\u53F7\u684C");
		label_7.setBounds(97, 142, 42, 41);
		panel_1.add(label_7);

		Tabl_4 = new JTextField();
		Tabl_4.setBounds(149, 142, 668, 41);
		Tabl_4.setText("\u672A\u9884\u5B9A");
		Tabl_4.setColumns(10);
		panel_1.add(Tabl_4);

		JButton button_4 = new JButton("\u9884\u5B9A\u672C\u684C");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ���Ԥ��5
				showBginReserve("5");
			}
		});
		button_4.setBounds(6, 183, 81, 41);
		panel_1.add(button_4);

		JLabel label_8 = new JLabel("5\u53F7\u684C");
		label_8.setBounds(97, 183, 42, 41);
		panel_1.add(label_8);

		Tabl_5 = new JTextField();
		Tabl_5.setBounds(149, 183, 668, 41);
		Tabl_5.setText("\u672A\u9884\u5B9A");
		Tabl_5.setColumns(10);
		panel_1.add(Tabl_5);
	}

	/**
	 * ���������б���ÿ���µ�����
	 * 
	 * @param y
	 * @param m
	 *            *�����*
	 */
	private void setDay(int y, int m) {
		switch (m) {
		case 4:
		case 6:
		case 9:
		case 11:// 30��
			while ((comboBox_2.getItemCount() - 28) > 0) {
				comboBox_2.removeItemAt(comboBox_2.getItemCount() - 1);
			}
			comboBox_2.addItem(29);
			comboBox_2.addItem(30);
			break;
		case 2:// �����ж�
			if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
				while ((comboBox_2.getItemCount() - 28) > 0) {
					comboBox_2.removeItemAt(comboBox_2.getItemCount() - 1);
				}
				comboBox_2.addItem(29);
			} else {
				while ((comboBox_2.getItemCount() - 28) > 0) {
					comboBox_2.removeItemAt(comboBox_2.getItemCount() - 1);
				}
			}
			break;
		default:
			while ((comboBox_2.getItemCount() - 28) > 0) {
				comboBox_2.removeItemAt(comboBox_2.getItemCount() - 1);
			}
			comboBox_2.addItem(29);
			comboBox_2.addItem(30);
			comboBox_2.addItem(31);
			break;
		}
	}

	/**
	 * �������������ڼ�
	 * 
	 * @param date
	 *            *�����*
	 */
	public void setForWeek(String date) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(date_Format.parse(date));
			int dayForWeek = 0;
			if (c.get(Calendar.DAY_OF_WEEK) == 1) {
				dayForWeek = 7;
			} else {
				dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
			}
			switch (dayForWeek) {
			case 1:
				label_3.setText("����һ");
				break;
			case 2:
				label_3.setText("���ڶ�");
				break;
			case 3:
				label_3.setText("������");
				break;
			case 4:
				label_3.setText("������");
				break;
			case 5:
				label_3.setText("������");
				break;
			case 6:
				label_3.setText("������");
				break;
			case 7:
				label_3.setText("������");
				break;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ʾԤ����Ϣ
	 * 
	 * @param date
	 *            *�����*
	 */
	public void showReserveInformation(String date) {
		String[] str = reserveServer.getReserveString(date);
		Tabl_1.setText(ISnull(str[0]));
		Tabl_2.setText(ISnull(str[1]));
		Tabl_3.setText(ISnull(str[2]));
		Tabl_4.setText(ISnull(str[3]));
		Tabl_5.setText(ISnull(str[4]));
	}

	/**
	 * �ж�Ԥ����Ϣ�Ǹ���Ϊ��
	 * 
	 * @param s
	 * @return *�����*
	 */
	public String ISnull(String s) {
		if (s.equals("")) {
			return "������Ԥ��";
		} else {
			return s;
		}
	}

	/**
	 * �������ʱ����ʾ�������Ϣ
	 * 
	 * *�����*
	 */
	public void onLoad() {
		String str = date_Format.format(new Date());
		int nowDateYY = Integer.parseInt(str.substring(0, 4));
		int nowDateMM = Integer.parseInt(str.substring(5, 7));
		int nowDateDD = Integer.parseInt(str.substring(8));
		comboBox.addItem(nowDateYY - 1);
		comboBox.addItem(nowDateYY);
		comboBox.addItem(nowDateYY + 1);// ʵ����ݵ����
		comboBox.setSelectedIndex(1);// ������������ݵ���ʾ
		comboBox_1.setSelectedIndex(nowDateMM - 1);// �����������·ݵ���ʾ
		setDay(nowDateYY, nowDateMM);
		comboBox_2.setSelectedIndex(nowDateDD - 1);// �������������ڵ���ʾ
		setForWeek(str);
		showReserveInformation(str);
		// ���ð�ť״̬��
		if (comboBox_2.getSelectedIndex() == 0) {
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(true);
		} else if (comboBox_2.getSelectedIndex() + 1 == comboBox_2
				.getItemCount()) {
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(false);
		} else {
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(true);
		}

	}

	/**
	 * ���������б�����ˢ�£����жϰ�ť״̬
	 * 
	 * *�����*
	 */
	public void updateInformation() {
		int year = Integer.parseInt(comboBox.getSelectedItem().toString());
		int month = Integer.parseInt(comboBox_1.getSelectedItem().toString());
		if (b) {
			setDay(year, month);
		}
		String str = year + "-" + month;
		str += "-" + comboBox_2.getSelectedItem().toString();
		setForWeek(str);
		showReserveInformation(str);
		// ���ð�ť״̬
		if (comboBox_2.getSelectedIndex() == 0) {
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(true);
		} else if (comboBox_2.getSelectedIndex() + 1 == comboBox_2
				.getItemCount()) {
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(false);
		} else {
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(true);
		}

	}

	/**
	 * ��ת��ȷ��Ԥ��ҳ��
	 * 
	 * @param tab
	 *            *�����*
	 */
	public void showBginReserve(String tab) {
		String a = comboBox.getSelectedItem().toString();
		String b = comboBox_1.getSelectedItem().toString();
		String c = comboBox_2.getSelectedItem().toString();
		String d = label_3.getText();
		ReserveBgin frame = new ReserveBgin(tab, a, b, c, d);
		frame.setVisible(true);// ��һ��ҳ��
		ShowReserve.this.dispose();// ���ٵ�ǰ����
	}
}
