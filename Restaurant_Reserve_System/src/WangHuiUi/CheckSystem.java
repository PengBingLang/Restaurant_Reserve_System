package WangHuiUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckSystem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckSystem frame = new CheckSystem();
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
	public CheckSystem() {
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 12));
		setTitle("\u6536\u94F6\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\\u97E9\u987A\u5E73\u6EE1\u6C49\u697C\u7BA1\u7406\u7CFB\u7EDF\uFF08\u5305\u62EC\u6570\u636E\u5E93\uFF0C\u6E90\u4EE3\u7801\uFF09\\\u7D20\u6750\\image\\jm1_icon1.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBounds(14, 13, 623, 390);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u7ED3\u8D26");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checked c = new Checked();
				c.setVisible(true);
				CheckSystem.this.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnNewButton.setBounds(207, 84, 171, 56);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setForeground(Color.MAGENTA);
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button.setBackground(Color.WHITE);
		button.setBounds(207, 199, 171, 56);
		panel.add(button);
	}
}
