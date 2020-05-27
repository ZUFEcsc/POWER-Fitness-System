package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * @author 拔牙不打麻药
 *
 * @time 2020年5月26日
 */
//体育锻炼
public class PEtraining {

	static JFrame PEFrame;
	
	PEtraining window;
	
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	final String userName="sa";
	final String userPwd="123";
	String sqlStr;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PEtraining window = new PEtraining();
					PEFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PEtraining() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PEFrame = new JFrame();
		PEFrame.setTitle("POWER");
		PEFrame.setBounds(100, 100, 930, 560);
		PEFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PEFrame.getContentPane().setLayout(null);
		
		JLabel label_power = new JLabel("POWER");
		label_power.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label_power.setBounds(0, 0, 80, 24);
		PEFrame.getContentPane().add(label_power);
		
		JLabel label = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label.setFont(new Font("幼圆", Font.PLAIN, 14));
		label.setBounds(741, 24, 163, 21);
		PEFrame.getContentPane().add(label);
		
		JButton button_return = new JButton("\u8FD4\u56DE");
		
		button_return.setIcon(new ImageIcon(PEtraining.class.getResource("/Power/return.png")));
		button_return.setForeground(Color.GRAY);
		button_return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_return.setContentAreaFilled(false);
		button_return.setBorderPainted(false);
		button_return.setBounds(702, 445, 172, 52);
		PEFrame.getContentPane().add(button_return);
		
		JButton button_movecheck = new JButton("\u8BAD\u7EC3\u67E5\u8BE2");
		
		button_movecheck.setIcon(new ImageIcon(PEtraining.class.getResource("/Power/user_training.png")));
		button_movecheck.setVerifyInputWhenFocusTarget(false);
		button_movecheck.setToolTipText("");
		button_movecheck.setRolloverEnabled(false);
		button_movecheck.setRequestFocusEnabled(false);
		button_movecheck.setOpaque(false);
		button_movecheck.setFont(new Font("黑体", Font.PLAIN, 18));
		button_movecheck.setFocusTraversalKeysEnabled(false);
		button_movecheck.setFocusPainted(false);
		button_movecheck.setDefaultCapable(false);
		button_movecheck.setContentAreaFilled(false);
		button_movecheck.setBorderPainted(false);
		button_movecheck.setBounds(10, 106, 215, 57);
		PEFrame.getContentPane().add(button_movecheck);
		
		JButton button_addtrainingset = new JButton("\u52A0\u5165\u8BAD\u7EC3\u96C6");
		
		button_addtrainingset.setIcon(new ImageIcon(PEtraining.class.getResource("/Power/user_trainingset.png")));
		button_addtrainingset.setToolTipText("");
		button_addtrainingset.setFont(new Font("黑体", Font.PLAIN, 18));
		button_addtrainingset.setContentAreaFilled(false);
		button_addtrainingset.setBorderPainted(false);
		button_addtrainingset.setBounds(10, 298, 215, 57);
		PEFrame.getContentPane().add(button_addtrainingset);
		
		JPanel panel_trainingset = new JPanel();
		panel_trainingset.setLayout(null);
		panel_trainingset.setBounds(222, 55, 652, 364);
		PEFrame.getContentPane().add(panel_trainingset);
		
		JLabel label_1 = new JLabel("\u8BB0\u5F55\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(15, 36, 90, 21);
		panel_trainingset.add(label_1);
		
		textField = new JTextField();
		textField.setToolTipText("\u5982\uFF1Ar012");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(110, 32, 282, 25);
		panel_trainingset.add(textField);
		
		JButton button_1 = new JButton("\u5B8C\u6210");
		
		button_1.setIcon(new ImageIcon(PEtraining.class.getResource("/Power/training_check.png")));
		button_1.setToolTipText("\u5B8C\u6210");
		button_1.setFont(new Font("黑体", Font.PLAIN, 18));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(487, 295, 124, 29);
		panel_trainingset.add(button_1);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		label_2.setBounds(15, 88, 90, 21);
		panel_trainingset.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u5982u009");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(110, 84, 282, 25);
		panel_trainingset.add(textField_1);
		
		JLabel label_3 = new JLabel("\u8BAD\u7EC3\u7F16\u53F7\uFF1A");
		label_3.setFont(new Font("黑体", Font.PLAIN, 18));
		label_3.setBounds(15, 144, 90, 21);
		panel_trainingset.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("\u5982s004");
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(110, 140, 282, 25);
		panel_trainingset.add(textField_2);
		
		JLabel label_4 = new JLabel("\u8BAD\u7EC3\u52A8\u4F5C\uFF1A");
		label_4.setFont(new Font("黑体", Font.PLAIN, 18));
		label_4.setBounds(15, 195, 90, 21);
		panel_trainingset.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("\u5982\u6DF1\u8E72");
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(110, 191, 282, 25);
		panel_trainingset.add(textField_3);
		
		JLabel label_5 = new JLabel("\u8BAD\u7EC3\u65F6\u957F\uFF1A");
		label_5.setFont(new Font("黑体", Font.PLAIN, 18));
		label_5.setBounds(15, 249, 90, 21);
		panel_trainingset.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("\u598220");
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(110, 245, 282, 25);
		panel_trainingset.add(textField_4);
		
		JLabel label_6 = new JLabel("\u8BAD\u7EC3\u65E5\u671F\uFF1A");
		label_6.setFont(new Font("黑体", Font.PLAIN, 18));
		label_6.setBounds(15, 299, 90, 21);
		panel_trainingset.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("\u59822020-05-26");
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(110, 295, 282, 25);
		panel_trainingset.add(textField_5);
		
		JPanel panel_training = new JPanel();
		panel_training.setBounds(222, 55, 652, 364);
		PEFrame.getContentPane().add(panel_training);
		panel_training.setLayout(null);
		
		JTextArea textArea_training = new JTextArea();
		textArea_training.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea_training.setBounds(15, 82, 609, 267);
		panel_training.add(textArea_training);
		
		JScrollPane scrollPane_training = new JScrollPane(textArea_training);
		scrollPane_training.setBounds(15, 82, 609, 267);
		panel_training.add(scrollPane_training);
		
		JLabel label_training = new JLabel("\u8BF7\u9009\u62E9\u953B\u70BC\u90E8\u4F4D\uFF1A");
		label_training.setFont(new Font("黑体", Font.PLAIN, 18));
		label_training.setBounds(15, 32, 148, 21);
		panel_training.add(label_training);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u80CC\u90E8", "\u817F\u90E8\u81C0\u90E8", "\u81C0\u90E8", "\u80F8\u90E8", "\u8179\u90E8", "\u6838\u5FC3", "\u80A9\u90E8", "\u5168\u8EAB"}));
		comboBox.setLightWeightPopupEnabled(false);
		comboBox.setFont(new Font("黑体", Font.PLAIN, 18));
		comboBox.setFocusable(false);
		comboBox.setBorder(null);
		comboBox.setBounds(198, 26, 139, 27);
		panel_training.add(comboBox);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setVerifyInputWhenFocusTarget(false);
		button.setOpaque(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setDefaultCapable(false);
		
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(PEtraining.class.getResource("/Power/training_check.png")));
		button.setFont(new Font("黑体", Font.PLAIN, 18));
		button.setBounds(376, 9, 156, 44);
		panel_training.add(button);
		panel_training.setVisible(true);
		panel_trainingset.setVisible(false);
		button_movecheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_training.setVisible(true);
				panel_trainingset.setVisible(false);
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from sport";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_training.setText("");
				     while(rs.next()) {
				      result = "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb")+"\t训练部位："+rs.getString("spart");
				      textArea_training.setText(textArea_training.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button_addtrainingset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_training.setVisible(false);
				panel_trainingset.setVisible(true);
			}
		});
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from sport where spart='"+comboBox.getSelectedItem()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_training.setText("");
				     while(rs.next()) {
				      result = "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb")+"\t训练部位："+rs.getString("spart");
				      textArea_training.setText(textArea_training.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="insert into trainingrecord values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"',"+textField_4.getText()+",'"+textField_5.getText()+"')";
				     
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     JOptionPane.showMessageDialog(null, "加入成功！开始训练吧！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     st.executeQuery(sqlStr);
				    // JOptionPane.showMessageDialog(null, "注销成功！常来玩呀~","古德！",JOptionPane.INFORMATION_MESSAGE);
				    }
				    catch(Exception e1) {
				     //JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		//返回按钮
		button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PEFrame.dispose();
				UserHome UserHome = new UserHome();
				try {
					UserHome.UserHomeFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
				
		
	}
}
