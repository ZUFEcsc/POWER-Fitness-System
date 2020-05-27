package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class test {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panelNew = new JPanel();
		panelNew.setBounds(51, 28, 618, 365);
		frame.getContentPane().add(panelNew);
		panelNew.setLayout(null);
		
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setBounds(38, 90, 160, 19);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		panelNew.add(label);
		
		textField = new JTextField();
		textField.setBounds(202, 90, 153, 21);
		textField.setColumns(10);
		panelNew.add(textField);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(38, 26, 0, 0);
		panelNew.add(label_2);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u5546\u54C1\u7684\u5355\u4EF7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(38, 154, 192, 19);
		panelNew.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 154, 154, 21);
		panelNew.add(textField_1);
		
		JLabel lblpower = new JLabel("\u793A\u4F8B\uFF1APOWER\u667A\u80FD\u624B\u73AF");
		lblpower.setForeground(Color.GRAY);
		lblpower.setFont(new Font("宋体", Font.PLAIN, 12));
		lblpower.setBounds(365, 93, 153, 15);
		panelNew.add(lblpower);
		
		JLabel label_5 = new JLabel("\u793A\u4F8B\uFF1A169 , \u5355\u4F4D\uFF1A\u5143");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		label_5.setBounds(365, 157, 177, 15);
		panelNew.add(label_5);
		
		JLabel label_6 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u5546\u54C1\u7684\u7C7B\u522B\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(38, 218, 192, 19);
		panelNew.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(202, 218, 153, 21);
		panelNew.add(textField_2);
		
		JLabel label_7 = new JLabel("<html><body>\u793A\u4F8B\uFF1A\u667A\u80FD\u786C\u4EF6 , <br>\u9009\u9879\u8303\u56F4\uFF1A\u667A\u80FD\u786C\u4EF6/\u8FD0\u52A8\u88C5\u5907/\u8F7B\u98DF\u4EE3\u9910/\u5065\u8EAB\u670D\u9970/\u5176\u4ED6</body></html>");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("宋体", Font.PLAIN, 12));
		label_7.setBounds(367, 215, 228, 53);
		panelNew.add(label_7);
		
		JLabel label_8 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u5546\u54C1\u7684\u5E93\u5B58\u6570\u91CF\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(38, 282, 192, 19);
		panelNew.add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(238, 282, 117, 21);
		panelNew.add(textField_3);
		
		JLabel label_9 = new JLabel("\u793A\u4F8B\uFF1A2000");
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("宋体", Font.PLAIN, 12));
		label_9.setBounds(365, 285, 198, 15);
		panelNew.add(label_9);
		
		JButton button = new JButton("\u65B0\u589E\u5546\u54C1");
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(452, 310, 125, 44);
		panelNew.add(button);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(38, 26, 160, 19);
		panelNew.add(label_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(202, 26, 153, 21);
		panelNew.add(textField_5);
		
		JLabel lbli = new JLabel("\u793A\u4F8B\uFF1Ai001");
		lbli.setForeground(Color.GRAY);
		lbli.setFont(new Font("宋体", Font.PLAIN, 12));
		lbli.setBounds(365, 26, 153, 15);
		panelNew.add(lbli);
		frame.getContentPane().setLayout(null);
		
	}

	
}
