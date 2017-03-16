package com.chinasoft.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaidanXuanXiang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.f
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { CaidanXuanXiang frame = new
	 * CaidanXuanXiang(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public CaidanXuanXiang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(28, 28, 553, 385);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u83DC\u5355");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select_Salestate_view s = new Select_Salestate_view();
				s.setVisible(true);
				CaidanXuanXiang.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(146, 159, 215, 51);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(
				"\u8FD4\u56DE\u4E3B\u83DC\u5355\u754C\u9762");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaidanXuanXiang.this.dispose();
			}
		});
		btnNewButton_2.setBounds(121, 240, 263, 61);
		panel.add(btnNewButton_2);

		JButton button = new JButton("\u6DFB\u52A0\u83DC\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_view i = new Insert_view();
				i.setVisible(true);
				CaidanXuanXiang.this.setVisible(false);

			}
		});
		button.setBounds(146, 72, 215, 51);
		panel.add(button);
	}
}
