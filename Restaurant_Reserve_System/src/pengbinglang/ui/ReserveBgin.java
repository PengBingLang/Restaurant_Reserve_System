package pengbinglang.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import pengbinglang.dao.InsertOrderDao;
import pengbinglang.entity.OrderTab;

public class ReserveBgin extends JFrame {

	private JPanel contentPane;
	private JLabel label_1 = null;// ��ʾ����
	private JComboBox comboBox = null;
	private JComboBox comboBox_1 = null;
	private JComboBox comboBox_2 = null;
	private JComboBox comboBox_3 = null;
	private JTextField GusetName;
	private JTextField GusetPhome;
	private JTextField GusetID;
	private JTextField Money;
	private JTextField textField_1;
	private JTextField textField_2;
	private String shouDate = "";// ������ʾ��ʾ��Ϣ
	private String date = "";// ���ڴ�������
	private int tableNum = 0;// ����

	/**
	 * Create the frame.
	 */
	public ReserveBgin(String tab, String a, String b, String c, String d) {
		shouDate = a + "��" + b + "��" + c + "�գ�" + d + "����" + tab + "����";
		date = a + "-" + b + "-" + c;
		this.tableNum = Integer.parseInt(tab);

		addWindowListener(new WindowAdapter() {// ���һ�����������������ڴ��¼�
			public void windowOpened(WindowEvent e) {
				label_1.setText(shouDate);
			}
		});
		addWindowListener(new WindowAdapter() {// ���һ�����������������ڹر��¼�
			public void windowClosing(WindowEvent e) {
				Object[] options = { "ȷ��", "ȡ��" };
				JOptionPane pane2 = new JOptionPane("�����˳���?",
						JOptionPane.QUESTION_MESSAGE,
						JOptionPane.YES_NO_OPTION, null, options, options[1]);
				JDialog dialog = pane2.createDialog("����");// this,
				dialog.setVisible(true);
				Object selectedValue = pane2.getValue();
				if (selectedValue == null || selectedValue == options[1]) {
					// �û�ѡ��ȡ��
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ����ǹؼ�
				} else if (selectedValue == options[0]) {
					ShowReserve show = new ShowReserve();
					show.setVisible(true);// ������ʾ���棬��ˢ��Ч��
					ReserveBgin.this.dispose();// ���ٵ�ǰ����
				}
			}
		});
		setResizable(false);// ��С���ɱ�
		setTitle("\u786E\u8BA4\u9884\u5B9A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ùرշ�ʽ
		setBounds(100, 100, 450, 551);
		setLocationRelativeTo(null);// ���ô���λ�þ���

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u6B63\u5728\u9884\u5B9A\uFF1A");
		label.setBounds(10, 10, 78, 25);
		contentPane.add(label);

		label_1 = new JLabel("New label");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 19));
		label_1.setBounds(75, 10, 359, 38);
		contentPane.add(label_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 61, 424, 452);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_2 = new JLabel("\u7528\u9910\u65F6\u95F4\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(0, 13, 120, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel(
				"\u9884\u5B9A\u65F6\u957F(\u5C0F\u65F6)\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(0, 51, 120, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\u7528\u9910\u4EBA\u6570\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(0, 95, 120, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\u9884\u5B9A\u4EBA\u59D3\u540D\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("����", Font.PLAIN, 14));
		label_5.setBounds(0, 140, 120, 15);
		panel.add(label_5);

		JLabel label_6 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("����", Font.PLAIN, 14));
		label_6.setBounds(0, 184, 120, 15);
		panel.add(label_6);

		JLabel label_7 = new JLabel("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("����", Font.PLAIN, 14));
		label_7.setBounds(0, 236, 120, 15);
		panel.add(label_7);

		JLabel label_8 = new JLabel(
				"\u8BA2\u3000\u91D1\uFF08\uFFE5\uFF09\uFF1A");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("����", Font.PLAIN, 14));
		label_8.setBounds(0, 291, 120, 15);
		panel.add(label_8);

		JLabel label_9 = new JLabel("\u9884\u5B9A\u65F6\u95F4\uFF1A");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("����", Font.PLAIN, 14));
		label_9.setBounds(0, 338, 120, 15);
		panel.add(label_9);

		JLabel label_10 = new JLabel("\u64CD\u4F5C\u5458\uFF1A");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("����", Font.PLAIN, 14));
		label_10.setBounds(0, 390, 120, 15);
		panel.add(label_10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboBox.setBounds(130, 10, 49, 21);
		panel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "00", "10",
				"20", "30", "40", "50" }));
		comboBox_1.setBounds(189, 10, 55, 21);
		panel.add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4" }));
		comboBox_2.setSelectedIndex(1);
		comboBox_2.setBounds(130, 48, 49, 21);
		panel.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "2", "4",
				"6", "8", "10" }));
		comboBox_3.setBounds(130, 92, 49, 21);
		panel.add(comboBox_3);

		GusetName = new JTextField();
		GusetName.setBounds(130, 137, 114, 21);
		panel.add(GusetName);
		GusetName.setColumns(10);

		GusetPhome = new JTextField();
		GusetPhome.setColumns(10);
		GusetPhome.setBounds(130, 181, 114, 21);
		panel.add(GusetPhome);

		GusetID = new JTextField();
		GusetID.setText("1 (\u6563\u5BA2)");
		GusetID.setColumns(10);
		GusetID.setBounds(130, 233, 114, 21);
		panel.add(GusetID);

		Money = new JTextField();
		Money.setText("20.00");
		Money.setColumns(10);
		Money.setBounds(130, 288, 114, 21);
		panel.add(Money);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(130, 335, 114, 21);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("\u6B64\u529F\u80FD\u7B49\u5F85\u6DFB\u52A0");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(130, 387, 114, 21);
		panel.add(textField_2);

		JButton button = new JButton("\u786E\u8BA4\u9884\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ȷ��Ԥ��
				SimpleDateFormat sqlNum = new SimpleDateFormat("yyyyMMddHHmm");
				String timeS = sqlNum.format(new Date());// ��ǰʱ��

				OrderTab order = new OrderTab();// ���ݶ�����Ϣ
				order.setOrderNumber(timeS + tableNum);// ������
				order.setTableID(tableNum);// ����

				order.setReserveDate(date + " "
						+ comboBox.getSelectedItem().toString() + ":"
						+ comboBox_1.getSelectedItem().toString());// ����ʱ��

				order.setTimeLong(Integer.parseInt(comboBox_2.getSelectedItem()
						.toString()));// ʱ��

				order.setGuestNumber(Integer.parseInt(comboBox_3
						.getSelectedItem().toString()));// ����

				order.setGusetName(GusetName.getText());// Ԥ����
				order.setGusetPhome(GusetPhome.getText());// �绰
				order.setReserveMoney(Double.parseDouble(Money.getText()));// ����

				InsertOrderDao in = new InsertOrderDao();
				in.insertOrder(order);// ����ĳ����ʵ���ύorder

				ShowReserve show = new ShowReserve();
				show.setVisible(true);// ������ʾ���棬��ˢ��Ч��
				ReserveBgin.this.dispose();// ���ٵ�ǰ����
			}
		});
		button.setBounds(278, 287, 93, 23);
		panel.add(button);
	}
}
