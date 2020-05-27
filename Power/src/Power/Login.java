package Power;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class Login extends JFrame {

	JPanel contentPane;
	
	Login frame;
	UserHome UserHome;
	Home homeFrame;
	
	JTextField textField_Name;
	public JButton button_1;
	JPasswordField passwordField;
	String name;
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	final String userName="sa";
	final String userPwd="123";
	String sqlStr;
	
	ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login frame = new Login();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("POWER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/Power/login.png")));
		label_2.setBounds(0, 0, 390, 201);
		
		contentPane.setLayout(null);
		
		contentPane.add(label_2);
		
		JLabel lblPower = new JLabel("POWER");
		lblPower.setBounds(5, 207, 64, 24);
		lblPower.setFont(new Font("French Script MT", Font.PLAIN, 20));
		contentPane.add(lblPower);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(58, 237, 79, 23);
		contentPane.add(label);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(127, 239, 155, 21);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 272, 155, 21);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u6CE8 \u518C");
		button.setIcon(new ImageIcon(Login.class.getResource("/Power/signup.png")));
		button.setFont(new Font("幼圆", Font.PLAIN, 22));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(147, 330, 109, 51);
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u767B \u5F55");
		button_1.setIcon(new ImageIcon(Login.class.getResource("/Power/similing.png")));
		button_1.setFont(new Font("幼圆", Font.PLAIN, 22));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(266, 330, 109, 51);
		
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("\u5BC6 \u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(58, 270, 79, 23);
		contentPane.add(label_3);
		
		JRadioButton rdbtnAdmin = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnAdmin.setSelected(true);
		rdbtnAdmin.setBounds(127, 299, 64, 23);
		contentPane.add(rdbtnAdmin);
		
		JRadioButton rdbtnUser = new JRadioButton("\u7528\u6237");
		rdbtnUser.setBounds(218, 299, 64, 23);
		contentPane.add(rdbtnUser);
		
		bg.add(rdbtnUser);
		bg.add(rdbtnAdmin);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=textField_Name.getText();
				char[] password=passwordField.getPassword();
				String str=String.valueOf(password); //将char数组转化为string类型
				
				if(rdbtnAdmin.isSelected())
				{
					if(name.equals("csnb")&&str.equals("123"))
					{
						   
						System.out.println("管理员登录\n用户名："+name);
						System.out.println("密    码："+str);
						Home homeFrame = new Home();
						dispose();
						try {
							homeFrame.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "输入的管理员名称或者密码有误，请重新输入~","提 示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(rdbtnUser.isSelected())
				{
					try {
						//select * from userlog where uno='u001'
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						conn=DriverManager.getConnection(dbURL,userName,userPwd);
						sqlStr="select * from userlog where uno='"+name+"'";
						st=conn.createStatement();
						rs=st.executeQuery(sqlStr);
						if(rs.next())
						{
//							System.out.println(rs.getString("upass"));
//							System.out.println(str);
							if(str.toString().equals(rs.getString("upass").trim().toString()))
							{
								try {
									UserHome UserHome = new UserHome();
									
									dispose();
									UserHome.UserHomeFrame.setVisible(true);
//									UserHome.label_NowUser.setText("当前操作用户："+name);
//									System.out.println(str);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(contentPane, "用户id或密码输入有误！","提 示",JOptionPane.INFORMATION_MESSAGE);
//								JOptionPane.showMessageDialog(null, "","警告！！",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
					}
					
				}
				
			}
		});
	}
}
