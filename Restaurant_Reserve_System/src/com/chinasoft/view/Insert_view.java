package com.chinasoft.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import com.chinasoft.service.Insert_service;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Insert_view extends JFrame {

	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_name;
	private JTextField text_money;
	private JTextField text_style;
	private Insert_service is = new Insert_service();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_view frame = new Insert_view();
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
	public Insert_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(129, 80, 563, 332);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u589E\u52A0\u83DC\u7684\u5185\u5BB9\uFF1A");
		lblNewLabel.setBounds(10, 10, 173, 24);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u83DC\u7684\u7F16\u53F7\uFF1A");
		label.setBounds(70, 65, 78, 15);
		panel.add(label);
		
		text_id = new JTextField();
		text_id.setBounds(158, 62, 78, 21);
		panel.add(text_id);
		text_id.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u589E\u83DC\u540D\uFF1A");
		label_1.setBounds(260, 65, 78, 15);
		panel.add(label_1);
		
		text_name = new JTextField();
		text_name.setColumns(10);
		text_name.setBounds(337, 62, 135, 21);
		panel.add(text_name);
		
		JLabel label_2 = new JLabel("\u83DC\u7684\u4EF7\u683C\uFF1A");
		label_2.setBounds(260, 111, 78, 15);
		panel.add(label_2);
		
		text_money = new JTextField();
		text_money.setColumns(10);
		text_money.setBounds(337, 108, 135, 21);
		panel.add(text_money);
		
		JLabel label_3 = new JLabel("\u83DC\u7684\u7C7B\u578B\uFF1A");
		label_3.setBounds(70, 111, 78, 15);
		panel.add(label_3);
		
		text_style = new JTextField();
		text_style.setColumns(10);
		text_style.setBounds(158, 108, 78, 21);
		panel.add(text_style);
		
		JLabel label_5 = new JLabel("\u662F\u5426\u5728\u552E\uFF1A");
		label_5.setBounds(70, 161, 78, 15);
		panel.add(label_5);
		
		JButton button = new JButton("\u786E\u8BA4\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menuID = text_id.getText();
				int MenuID = Integer.parseInt(menuID);
				
				String FoodName = text_name.getText();
				
				String unitPrice = text_money.getText();
				int UnitPrice = Integer.parseInt(unitPrice);
				
				String foodTypeID = text_style.getText();
				int FoodTypeID = Integer.parseInt(foodTypeID);
				
				String saleState = textField.getText();
				int SaleState = Integer.parseInt(saleState);
				JOptionPane.showMessageDialog(Insert_view.this.getContentPane(),
						"添加成功", "提示框", JOptionPane.INFORMATION_MESSAGE);
				Insert_view i = new Insert_view(); 
				i.setVisible(true);
				
				
				
				try {
					is.Insert_Service(MenuID, FoodName, UnitPrice, FoodTypeID, SaleState);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		button.setBounds(112, 249, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88\u65B0\u589E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaidanXuanXiang c = new CaidanXuanXiang();
				c.setVisible(true);
				Insert_view.this .setVisible(false);
			}
		});
		button_1.setBounds(306, 249, 93, 23);
		panel.add(button_1);
		
		JRadioButton rd1 = new JRadioButton("\u662F");
		rd1.setBounds(158, 157, 46, 23);
		panel.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("\u5426");
		rd2.setBounds(206, 157, 46, 23);
		panel.add(rd2);
		
		textField = new JTextField();
		textField.setBounds(259, 158, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
	}
}
