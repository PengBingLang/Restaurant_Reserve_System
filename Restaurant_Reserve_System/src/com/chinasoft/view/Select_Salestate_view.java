package com.chinasoft.view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

import com.chinasoft.service.Menu_service;
import com.chinasoft.service.Update_set_service;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Select_Salestate_view extends JFrame {

	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_name;
	private JTextField text_money;
	private JTextField text_style;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private Menu_service ms = new  Menu_service();
	private String[] cols = {"id","菜名","价格","类型id","是否出售"};
	private	Menu_service service = new Menu_service();
	private JRadioButton rd1;
	private JRadioButton rd2;
	private int ys = 0 ;
	private JButton bb3 ;
	private JButton bb2 ;
	private JButton bb1 ;
	private JButton bb4 ;
	private Update_set_service uss = new Update_set_service();
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_Salestate_view frame = new Select_Salestate_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Select_Salestate_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(41, 23, 610, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("\u6B22\u8FCE\u60A8\u4FEE\u6539\u83DC\u5355\uFF0C\u8BF7\u70B9\u51FB\u4F60\u8981\u4FEE\u6539\u7684\u83DC");
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(104, 10, 365, 64);
		panel.add(label_3);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E0A\u7EA7\u83DC\u5355");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaidanXuanXiang c = new  CaidanXuanXiang();
				c.setVisible(true);
				Select_Salestate_view.this.setVisible(false);
			}
		});
		button_1.setBounds(1, 0, 134, 23);
		panel.add(button_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 117, 608, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 588, 160);
		panel_1.add(scrollPane);

		table = new JTable();
		//创建一个二维数组去接收
		String [][] data = ms.selectTop(ys);
		model.setDataVector(data, cols);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			// 鼠标单击事件
			public void mouseClicked(MouseEvent e) {
				// 获取选中的行
				int row = table.getSelectedRow();
				// 获取选中行的某列内容
				text_id.setText(model.getValueAt(row, 0) + "");
				text_name.setText(model.getValueAt(row, 1) + "");
				text_money.setText(model.getValueAt(row, 2) + "");
				text_style.setText(model.getValueAt(row, 3) + "");
				String str = model.getValueAt(row, 4)+"";
				textField.setText(str);
				if(str.equals("1")){
					rd2.setSelected(false);
					rd1.setSelected(true);
				}
				if(str.equals("0")){
					rd1.setSelected(false);
					rd2.setSelected(true);
				}
			}
		});




		JPanel panel_2 = new JPanel();
		panel_2.setBounds(41, 336, 610, 148);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		text_id = new JTextField();
		text_id.setEnabled(false);
		text_id.setBounds(104, 26, 66, 24);
		panel_2.add(text_id);
		text_id.setColumns(10);

		text_style = new JTextField();
		text_style.setEnabled(false);
		text_style.setBounds(104, 88, 66, 24);
		panel_2.add(text_style);
		text_style.setColumns(10);

		text_name = new JTextField();
		text_name.setEnabled(false);
		text_name.setBounds(272, 25, 125, 26);
		panel_2.add(text_name);
		text_name.setColumns(10);

		rd1 = new JRadioButton("\u662F");
		rd1.setBounds(260, 88, 42, 23);
		panel_2.add(rd1);

		rd2 = new JRadioButton("\u5426");
		rd2.setBounds(304, 88, 42, 23);
		panel_2.add(rd2);

		JLabel label_4 = new JLabel("\u662F\u5426\u5728\u552E:");
		label_4.setBounds(188, 89, 66, 21);
		panel_2.add(label_4);

		JLabel lblde = new JLabel("\u83DC\u7684\u7C7B\u578B:");
		lblde.setBounds(25, 89, 66, 21);
		panel_2.add(lblde);

		JLabel label = new JLabel("\u83DC\u5355\u7F16\u53F7:");
		label.setBounds(25, 27, 66, 21);
		panel_2.add(label);

		JLabel label_1 = new JLabel("\u83DC\u7684\u540D\u5B57:");
		label_1.setBounds(195, 27, 66, 21);
		panel_2.add(label_1);



		JLabel label_2 = new JLabel("\u83DC\u7684\u4EF7\u683C:");
		label_2.setBounds(429, 27, 71, 21);
		panel_2.add(label_2);

		text_money = new JTextField();
		text_money.setBounds(502, 25, 77, 26);
		panel_2.add(text_money);
		text_money.setColumns(10);

		textField = new JTextField();
		textField.setBounds(352, 89, 45, 21);
		panel_2.add(textField);
		textField.setColumns(10);

		bb2 = new JButton("\u4E0A\u4E00\u9875");
		bb2.setEnabled(false);
		bb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Menu_service service = new Menu_service();
				int i =	service.Zys();
				ys--;
				if(ys < 1){
					bb2.setEnabled(false);
				}
				bb3.setEnabled(true);

				String [][] data =service.selectTop(ys);
				model.setDataVector(data, cols);
				table = new JTable(model);
				scrollPane.setViewportView(table);
				table.addMouseListener(new MouseAdapter() {
					// 鼠标单击事件
					public void mouseClicked(MouseEvent e) {
						// 获取选中的行
						int row = table.getSelectedRow();
						// 获取选中行的某列内容
						text_id.setText(model.getValueAt(row, 0) + "");
						text_name.setText(model.getValueAt(row, 1) + "");
						text_money.setText(model.getValueAt(row, 2) + "");
						text_style.setText(model.getValueAt(row, 3) + "");
						String str = model.getValueAt(row, 4)+"";
						textField.setText(str);
						if(str.equals("1")){
							rd2.setSelected(false);
							rd1.setSelected(true);
						}
						if(str.equals("0")){
							rd1.setSelected(false);
							rd2.setSelected(true);
						}
					}
				});


			}
		});
		bb2.setBounds(177, 307, 93, 23);
		contentPane.add(bb2);

		bb3 = new JButton("\u4E0B\u4E00\u9875");
		bb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i =	service.Zys();
				ys++;

				if(ys == (i-1)){
					bb3.setEnabled(false);
				}
				bb2.setEnabled(true);

				String [][] data =service.selectTop(ys);
				model.setDataVector(data, cols);
				table = new JTable(model);
				scrollPane.setViewportView(table);
				table.addMouseListener(new MouseAdapter() {
					// 鼠标单击事件
					public void mouseClicked(MouseEvent e) {
						// 获取选中的行
						int row = table.getSelectedRow();
						// 获取选中行的某列内容
						text_id.setText(model.getValueAt(row, 0) + "");
						text_name.setText(model.getValueAt(row, 1) + "");
						text_money.setText(model.getValueAt(row, 2) + "");
						text_style.setText(model.getValueAt(row, 3) + "");
						String str = model.getValueAt(row, 4)+"";
						textField.setText(str);
						if(str.equals("1")){
							rd2.setSelected(false);
							rd1.setSelected(true);
						}
						if(str.equals("0")){
							rd1.setSelected(false);
							rd2.setSelected(true);
						}
					}
				});

			}
		});
		bb3.setBounds(384, 307, 93, 23);
		contentPane.add(bb3);

		bb1 = new JButton("\u9996\u9875");
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ys = 0 ;
				bb3.setEnabled(true);
				bb2.setEnabled(false);
				String [][] data =service.selectTop(ys);
				model.setDataVector(data, cols);
				table = new JTable(model);
				scrollPane.setViewportView(table);
				table.addMouseListener(new MouseAdapter() {
					// 鼠标单击事件
					public void mouseClicked(MouseEvent e) {
						// 获取选中的行
						int row = table.getSelectedRow();
						// 获取选中行的某列内容
						text_id.setText(model.getValueAt(row, 0) + "");
						text_name.setText(model.getValueAt(row, 1) + "");
						text_money.setText(model.getValueAt(row, 2) + "");
						text_style.setText(model.getValueAt(row, 3) + "");
						String str = model.getValueAt(row, 4)+"";
						textField.setText(str);
						if(str.equals("1")){
							rd2.setSelected(false);
							rd1.setSelected(true);
						}
						if(str.equals("0")){
							rd1.setSelected(false);
							rd2.setSelected(true);
						}
					}
				});
				
			}
		});
		bb1.setBounds(41, 308, 93, 23);
		contentPane.add(bb1);

		bb4 = new JButton("\u5C3E\u9875");
		bb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int i =	ms.Zys();
			ys = i - 1 ;
			bb2.setEnabled(true);
			bb3.setEnabled(false);
			String [][] data =service.selectTop(ys);
			model.setDataVector(data, cols);
			table = new JTable(model);
			scrollPane.setViewportView(table);
			table.addMouseListener(new MouseAdapter() {
				// 鼠标单击事件
				public void mouseClicked(MouseEvent e) {
					// 获取选中的行
					int row = table.getSelectedRow();
					// 获取选中行的某列内容
					text_id.setText(model.getValueAt(row, 0) + "");
					text_name.setText(model.getValueAt(row, 1) + "");
					text_money.setText(model.getValueAt(row, 2) + "");
					text_style.setText(model.getValueAt(row, 3) + "");
					String str = model.getValueAt(row, 4)+"";
					textField.setText(str);
					if(str.equals("1")){
						rd2.setSelected(false);
						rd1.setSelected(true);
					}
					if(str.equals("0")){
						rd1.setSelected(false);
						rd2.setSelected(true);
					}
				}
			});
				
				
			}
		});
		bb4.setBounds(538, 308, 93, 23);
		contentPane.add(bb4);
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String money = text_money.getText();
				double Money = Double.parseDouble(money);
				
				String num1 = textField.getText();
				int Num1 = Integer.parseInt(num1);
				
				String num2 = text_id.getText();	
				int Num2 = Integer.parseInt(num2);
				
				uss.U_set(Money, Num1, Num2);
				JOptionPane.showMessageDialog(Select_Salestate_view.this.getContentPane(),
						"修改成功", "提示框", JOptionPane.INFORMATION_MESSAGE);
				String [][] data = ms.selectTop(ys);
				model.setDataVector(data, cols);
				table = new JTable(model);
				scrollPane.setViewportView(table);
				

			}
		});
		button.setBounds(418, 77, 125, 45);
		panel_2.add(button);
	}
}
