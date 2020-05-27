package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UserTizhiFrame {

	UserHome UserHome;
	static JFrame TizhiFrame;
	UserTizhiFrame window;
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	final String userName="sa";
	final String userPwd="123";
	String sqlStr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTizhiFrame window = new UserTizhiFrame();
					TizhiFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserTizhiFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TizhiFrame = new JFrame();
		TizhiFrame.setTitle("POWER");
		TizhiFrame.setBounds(100, 100, 930, 560);
		TizhiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TizhiFrame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("POWER");
		label.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label.setBounds(0, 0, 64, 22);
		TizhiFrame.getContentPane().add(label);
		
		JButton button_Return = new JButton("返 回");
		
		button_Return.setIcon(new ImageIcon(UserTizhiFrame.class.getResource("/Power/return.png")));
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		button_Return.setBounds(735, 455, 169, 56);
		TizhiFrame.getContentPane().add(button_Return);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		label_1.setBounds(735, 1, 169, 21);
		TizhiFrame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		ImageIcon ico_tzl = new ImageIcon(Login.class.getResource("体脂率2.png")) ;//背景图案
		ico_tzl.setImage(ico_tzl.getImage().getScaledInstance(ico_tzl.getIconWidth(),
															  ico_tzl.getIconHeight(), 
															  Image.SCALE_DEFAULT));
		label_2.setIcon(ico_tzl);
		label_2.setBounds(24, 20, 880, 401);
		TizhiFrame.getContentPane().add(label_2);
		
		JLabel lbl_Xtime = new JLabel("January      February        March          April         May           June           July");
		lbl_Xtime.setFont(new Font("Consolas", Font.PLAIN, 16));
		lbl_Xtime.setBounds(44, 430, 870, 15);
		TizhiFrame.getContentPane().add(lbl_Xtime);
		
		JLabel label_3 = new JLabel("0.25");
		label_3.setBounds(0, 32, 54, 15);
		TizhiFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("0.20");
		label_4.setBounds(0, 179, 54, 15);
		TizhiFrame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("0.15");
		label_5.setBounds(0, 323, 54, 15);
		TizhiFrame.getContentPane().add(label_5);
		
		JButton btnpower = new JButton("\u70B9\u51FB\u83B7\u53D6POWER\u5EFA\u8BAE");
		
		btnpower.setIcon(new ImageIcon(UserTizhiFrame.class.getResource("/Power/getsuggest.png")));
		btnpower.setForeground(Color.GRAY);
		btnpower.setFont(new Font("黑体", Font.PLAIN, 22));
		btnpower.setContentAreaFilled(false);
		btnpower.setBorderPainted(false);
		btnpower.setBounds(44, 455, 306, 56);
		TizhiFrame.getContentPane().add(btnpower);
		
		//获取建议
		btnpower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * from suggest where uno='u009'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					if(rs.next()) {
						JOptionPane.showMessageDialog(TizhiFrame, "POWER在这给出建议 ： "+rs.getString("tsuggest"),"尊敬的 请削猴子 用户您好：",JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(TizhiFrame, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//返回用户主页面
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TizhiFrame.dispose();
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
