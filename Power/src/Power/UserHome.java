package Power;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

/**
 * @author 拔牙不打麻药 & csnb
 *
 * @time 2020年5月25日
 */

public class UserHome {
//	UserHome uhframe;
	static JFrame UserHomeFrame;
	UserHome window;
	JPanel MainPanel;
	Login LoginFrame;
	UserPrdFrame Prd;
	UserPowerShop UserShop;
	TrainingRecord Training;
	UserTizhiFrame UserTizhi;
	VipFrame Vip;
	Userfoodcheck UserFood;
	PEtraining PE;
	
	JLabel label_NowUser;
	
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
					UserHome window = new UserHome();
					UserHomeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserHomeFrame = new JFrame();
		UserHomeFrame.setBounds(100, 100, 450, 300);
		UserHomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UserHomeFrame.setTitle("POWER");
		UserHomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserHomeFrame.setBounds(100, 100, 930, 560);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		UserHomeFrame.setContentPane(MainPanel);
		MainPanel.setLayout(null);
		ImageIcon img1 = new ImageIcon(Login.class.getResource("1.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img1.setImage(img1.getImage().getScaledInstance(img1.getIconWidth(),
				                    		 		   	img1.getIconHeight(), 
				                    		 		   	Image.SCALE_DEFAULT)); 
		ImageIcon img2 = new ImageIcon(Login.class.getResource("2.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img2.setImage(img2.getImage().getScaledInstance(img2.getIconWidth(),
														img2.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		ImageIcon img3 = new ImageIcon(Login.class.getResource("3.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img3.setImage(img3.getImage().getScaledInstance(img3.getIconWidth(),
														img3.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		
		JButton button_tizhichange = new JButton("");
		
		button_tizhichange.setBounds(59, 51, 150, 150);
		
		button_tizhichange.setIcon(new ImageIcon(UserHome.class.getResource("/Power/tzcxun.gif")));
		button_tizhichange.setContentAreaFilled(false);//对JButton透明的设置
		button_tizhichange.setBorderPainted(false);
		MainPanel.add(button_tizhichange);
		
		JButton button_trainingrecord = new JButton("");
				
		button_trainingrecord.setBounds(483, 51, 150, 150);
		button_trainingrecord.setIcon(new ImageIcon(UserHome.class.getResource("/Power/\u8BAD\u7EC3\u8BB0\u5F55.gif")));
		button_trainingrecord.setContentAreaFilled(false);
		button_trainingrecord.setBorderPainted(false);
		MainPanel.add(button_trainingrecord);
		
		JLabel label_tizhichange = new JLabel("\u4F53\u8102\u53D8\u5316");
		label_tizhichange.setHorizontalAlignment(SwingConstants.CENTER);
		label_tizhichange.setBounds(87, 211, 94, 29);
		label_tizhichange.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(label_tizhichange);
		ImageIcon img4 = new ImageIcon(Login.class.getResource("4.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img4.setImage(img4.getImage().getScaledInstance(img4.getIconWidth(),
														img4.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		ImageIcon img5 = new ImageIcon(Login.class.getResource("5.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img5.setImage(img5.getImage().getScaledInstance(img5.getIconWidth(),
														img5.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		
		JLabel label_trainingrecord = new JLabel("\u8BAD\u7EC3\u8BB0\u5F55");
		label_trainingrecord.setHorizontalAlignment(SwingConstants.CENTER);
		label_trainingrecord.setBounds(511, 211, 94, 29);
		label_trainingrecord.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(label_trainingrecord);
		
		JButton btn_prendrelease = new JButton("");
				
		btn_prendrelease.setBounds(695, 51, 150, 150);
		btn_prendrelease.setIcon(new ImageIcon(UserHome.class.getResource("/Power/dbdongt.gif")));
		btn_prendrelease.setContentAreaFilled(false);
		btn_prendrelease.setBorderPainted(false);
		MainPanel.add(btn_prendrelease);
		
		JButton button_powershop = new JButton("");
		
		button_powershop.setBounds(645, 267, 150, 150);
		button_powershop.setIcon(new ImageIcon(UserHome.class.getResource("/Power/POWER\u5546\u57CE.gif")));
		button_powershop.setContentAreaFilled(false);
		button_powershop.setBorderPainted(false);
		MainPanel.add(button_powershop);
		
		JLabel label_prendrelease = new JLabel("\u52A8\u6001\u53D1\u5E03");
		label_prendrelease.setHorizontalAlignment(SwingConstants.CENTER);
		label_prendrelease.setBounds(723, 211, 94, 29);
		label_prendrelease.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(label_prendrelease);
		
		JLabel lblPower = new JLabel("POWER\u5546\u57CE");
		lblPower.setHorizontalAlignment(SwingConstants.CENTER);
		lblPower.setBounds(666, 427, 94, 19);
		lblPower.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(lblPower);
		
		JButton button_Unload = new JButton("退出登录");
		button_Unload.setIcon(new ImageIcon(UserHome.class.getResource("/Power/exitProject.png")));

		button_Unload.setContentAreaFilled(false);
		button_Unload.setBorderPainted(false);
		button_Unload.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		button_Unload.setMargin(new Insets(0, 0, 0, 0));
		button_Unload.setForeground(Color.GRAY);
		button_Unload.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Unload.setBounds(695, 456, 209, 55);
		MainPanel.add(button_Unload);
		
		JLabel label = new JLabel("POWER");
		label.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label.setBounds(0, 0, 87, 36);
		MainPanel.add(label);
		
		JButton button_tydl = new JButton("");
		
		button_tydl.setIcon(new ImageIcon(UserHome.class.getResource("/Power/MYorder.gif")));
		button_tydl.setContentAreaFilled(false);
		button_tydl.setBorderPainted(false);
		button_tydl.setBounds(271, 51, 150, 150);
		MainPanel.add(button_tydl);
		
		JLabel label_tydl = new JLabel("\u4F53\u80B2\u953B\u70BC");
		label_tydl.setHorizontalAlignment(SwingConstants.CENTER);
		label_tydl.setFont(new Font("宋体", Font.PLAIN, 20));
		label_tydl.setBounds(299, 211, 94, 29);
		MainPanel.add(label_tydl);
		
		JButton button_yscx = new JButton("");
		
		button_yscx.setIcon(new ImageIcon(UserHome.class.getResource("/Power/findeat.gif")));
		button_yscx.setContentAreaFilled(false);
		button_yscx.setBorderPainted(false);
		button_yscx.setBounds(113, 267, 150, 150);
		MainPanel.add(button_yscx);
		
		JLabel label_yscx = new JLabel("\u996E\u98DF\u67E5\u8BE2");
		label_yscx.setHorizontalAlignment(SwingConstants.CENTER);
		label_yscx.setFont(new Font("宋体", Font.PLAIN, 20));
		label_yscx.setBounds(148, 422, 94, 29);
		MainPanel.add(label_yscx);
		
		JLabel lblVip = new JLabel("VIP\u5145\u503C/\u7EED\u8D39");
		lblVip.setHorizontalAlignment(SwingConstants.CENTER);
		lblVip.setFont(new Font("宋体", Font.PLAIN, 20));
		lblVip.setBounds(393, 422, 122, 29);
		MainPanel.add(lblVip);
		
		JButton button_VIPgogogo = new JButton("");
		
		button_VIPgogogo.setIcon(new ImageIcon(UserHome.class.getResource("/Power/VIPcomeon.gif")));
		button_VIPgogogo.setContentAreaFilled(false);
		button_VIPgogogo.setBorderPainted(false);
		button_VIPgogogo.setBounds(379, 267, 150, 150);
		MainPanel.add(button_VIPgogogo);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		label_1.setBounds(745, -2, 169, 21);
		MainPanel.add(label_1);
		
		//体脂变化
		button_tizhichange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				UserTizhi = new UserTizhiFrame();
				try {
					UserTizhi.TizhiFrame.setVisible(true);
//					Prd.label_NowUser.setText("当前操作用户：");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//体育锻炼
		button_tydl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				PE = new PEtraining();
				try {
					PE.PEFrame.setVisible(true);
//					Prd.label_NowUser.setText("当前操作用户：");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
								
			}
		});
		
		//饮食查询
		button_yscx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				UserFood = new Userfoodcheck();
				try {
					UserFood.UserFoodFrame.setVisible(true);
//					Prd.label_NowUser.setText("当前操作用户：");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//动态发布
		btn_prendrelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				Prd = new UserPrdFrame();
				try {
					Prd.PrdFrame.setVisible(true);
//					Prd.label_NowUser.setText("当前操作用户：");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//训练查询
		button_trainingrecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				Training = new TrainingRecord();
				try {
					Training.TrainingFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//Vip充值
		button_VIPgogogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				Vip = new VipFrame(1);
				try {
					Vip.VipFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//power商城
		button_powershop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHomeFrame.dispose();
				UserShop = new UserPowerShop();
				try {
					UserShop.UserShopFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
				
		//退出登录
		button_Unload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login LoginFrame = new Login();
				UserHomeFrame.dispose();
				try {
					LoginFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
