package pengbinglang.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pengbinglang.dao.UserSelectDao;
import pengbinglang.entity.UserTab;
import pengbinglang.service.UserSelectService;
import com.chinasoft.view.CaidanXuanXiang;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SetSystem extends JFrame {

	private JPanel contentPane;
	private JTextField uID;
	private JTextField name;
	private JTextField pwd;
	private JComboBox comboBox = null;
	private JTable table;
	private JLabel Label_I = null;// 显示是否删除成功
	private DefaultTableModel model = new DefaultTableModel();
	private UserSelectService uss = new UserSelectService();
	private String[] tabTitle = { "工号", "权限", "姓名", "密码" };
	private int delID;// 要删除的员工ID

	/**
	 * Create the frame.
	 */
	public SetSystem() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// 关闭事件
				Login.pageOne.setVisible(true);
			}
		});
		setTitle("\u7CFB\u7EDF\u8BBE\u7F6E");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u5458\u5DE5",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 414, 143);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel NewLabel = new JLabel("\u5DE5\u3000\u53F7\uFF1A");
		NewLabel.setBounds(10, 27, 54, 15);
		panel.add(NewLabel);

		JLabel label = new JLabel("\u59D3\u3000\u540D\uFF1A");
		label.setBounds(198, 27, 54, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6743\u3000\u9650\uFF1A");
		label_1.setBounds(10, 72, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u521D\u59CB\u5BC6\u7801\uFF1A");
		label_2.setBounds(198, 72, 68, 15);
		panel.add(label_2);

		uID = new JTextField();
		uID.setBounds(74, 24, 92, 21);
		panel.add(uID);
		uID.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(262, 24, 92, 21);
		panel.add(name);

		pwd = new JTextField();
		pwd.setColumns(10);
		pwd.setBounds(262, 69, 92, 21);
		panel.add(pwd);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"\u5E97\u957F", "\u670D\u52A1\u5458", "\u6536\u94F6\u5458" }));
		comboBox.setBounds(74, 69, 92, 21);
		panel.add(comboBox);

		JButton button_1 = new JButton("\u6DFB\u3000\u52A0");// 添加按钮
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ID = Integer.parseInt(uID.getText());
					String n = name.getText();
					String p = pwd.getText();
					int tID = comboBox.getSelectedIndex() + 1;
					UserSelectDao d = new UserSelectDao();
					int i = d.InsertUser(ID, tID, n, p);
					if (i == 1) {
						Label_I.setText("添加成功");
					} else {
						Label_I.setText("添加失败");
					}
				} catch (Exception exc) {
					Label_I.setText("输入有误，添加失败");
				}
				bettering();
			}
		});
		button_1.setBounds(261, 110, 93, 23);
		panel.add(button_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5176\u4ED6",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 352, 414, 78);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton button = new JButton("\u83DC\u5355\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 菜单管理
				CaidanXuanXiang frame = new CaidanXuanXiang();
				frame.setVisible(true);
			}
		});
		button.setBounds(45, 28, 93, 23);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u5458\u5DE5\u5217\u8868",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 163, 414, 179);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 394, 115);
		panel_2.add(scrollPane);

		model.setDataVector(uss.getUserString(), tabTitle);
		table = new JTable(model);// 显示员工信息
		table.addMouseListener(new MouseAdapter() {// 鼠标点击事件
			public void mouseClicked(MouseEvent e) {
				delID = Integer.parseInt((String) model.getValueAt(
						table.getSelectedRow(), 0));
			}
		});
		scrollPane.setViewportView(table);

		JButton button_2 = new JButton("\u5220\u9664\u5458\u5DE5");// 删除按钮
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSelectDao d = new UserSelectDao();
				int i = d.deleteUser(delID);
				if (i == 1) {
					Label_I.setText("删除成功");
				} else {
					Label_I.setText("删除失败");
				}
				bettering();// 刷新
			}
		});
		button_2.setBounds(273, 150, 93, 23);
		panel_2.add(button_2);

		JButton button_3 = new JButton("\u5237\u3000\u65B0");// 刷新按钮
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Label_I.setText("");
				bettering();
			}
		});
		button_3.setBounds(155, 150, 93, 23);
		panel_2.add(button_3);

		Label_I = new JLabel("");
		Label_I.setBounds(20, 154, 125, 15);
		panel_2.add(Label_I);
	}

	/**
	 * 刷新员工显示列表
	 * 
	 * *彭秉浪*
	 */
	public void bettering() {
		model.setDataVector(uss.getUserString(), tabTitle);
	}

}
