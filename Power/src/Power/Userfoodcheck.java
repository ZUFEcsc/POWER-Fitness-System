package Power;


//食物查询
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * @author 拔牙不打麻药
 *
 * @time 2020年5月26日
 */

public class Userfoodcheck {
	
	UserHome UserHome;
	Userfoodcheck window;
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	final String userName="sa";
	final String userPwd="123";
	String sqlStr;

	private JFrame frame;
	static JFrame UserFoodFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userfoodcheck window = new Userfoodcheck();
					UserFoodFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Userfoodcheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("POWER");
		label.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label.setBounds(0, 0, 80, 24);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_1.setBounds(627, 0, 281, 21);
		frame.getContentPane().add(label_1);
		
		JButton button_return = new JButton("\u8FD4\u56DE");
		button_return.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/return.png")));
		button_return.setForeground(Color.GRAY);
		button_return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_return.setContentAreaFilled(false);
		button_return.setBorderPainted(false);
		button_return.setBounds(736, 452, 172, 52);
		frame.getContentPane().add(button_return);
		
		UserFoodFrame = new JFrame();
		UserFoodFrame.setTitle("POWER");
		UserFoodFrame.setBounds(100, 100, 930, 560);
		UserFoodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserFoodFrame.getContentPane().setLayout(null);
		
		JPanel panelFind = new JPanel();
		panelFind.setBounds(286, 10, 618, 432);
		UserFoodFrame.getContentPane().add(panelFind);
		panelFind.setLayout(null);
		
		JLabel label_12 = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("宋体", Font.PLAIN, 12));
		label_12.setBounds(476, 1, 140, 15);
		panelFind.add(label_12);
		
		JButton button = new JButton("\u5237\u65B0\u67E5\u8BE2\u7ED3\u679C");
		button.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/user_food.png")));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(408, 378, 200, 44);
		panelFind.add(button);
		
		JLabel label_power = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label_power.setForeground(Color.DARK_GRAY);
		label_power.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_power.setBounds(0, 26, 151, 15);
		//panelFind.add(label);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(0, 51, 618, 295);
		panelFind.add(textAreaResult);
		
		JScrollPane scrollPaneReturn = new JScrollPane(textAreaResult);
		scrollPaneReturn.setBounds(0, 40, 618, 330);
		panelFind.add(scrollPaneReturn);
		
		//------------------
		
		JLabel label_13 = new JLabel("POWER");
		label_13.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label_13.setBounds(0, 0, 64, 22);
		UserFoodFrame.getContentPane().add(label_13);
		
		JButton button_Return = new JButton("\u8FD4 \u56DE");
		button_Return.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/return.png")));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Return.setBounds(718, 452, 190, 52);
		UserFoodFrame.getContentPane().add(button_Return);
		ImageIcon ico_fruit = new ImageIcon(Login.class.getResource("fruit.png")) ;//背景图案
		ico_fruit.setImage(ico_fruit.getImage().getScaledInstance(ico_fruit.getIconWidth(),
																  ico_fruit.getIconHeight(), 
																  Image.SCALE_DEFAULT));
		
		JButton button_2 = new JButton("\u6C34\u679C\u67E5\u8BE2");
		button_2.setFocusTraversalPolicyProvider(true);
		button_2.setFocusPainted(false);
		button_2.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/fruit.png")));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		
		button_2.setFont(new Font("黑体", Font.PLAIN, 16));
		button_2.setBounds(40, 46, 181, 48);
		UserFoodFrame.getContentPane().add(button_2);
		ImageIcon ico_zs = new ImageIcon(Login.class.getResource("zs.png")) ;//背景图案
		ico_zs.setImage(ico_zs.getImage().getScaledInstance(ico_zs.getIconWidth(),
															ico_zs.getIconHeight(), 
															Image.SCALE_DEFAULT));
		
		JButton button_3 = new JButton("\u4E3B\u98DF\u67E5\u8BE2");
		button_3.setFocusTraversalPolicyProvider(true);
		button_3.setFocusPainted(false);
		button_3.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/newfood.png")));
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		
		button_3.setFont(new Font("黑体", Font.PLAIN, 16));
		button_3.setBounds(40, 140, 181, 48);
		UserFoodFrame.getContentPane().add(button_3);
		ImageIcon ico_sc = new ImageIcon(Login.class.getResource("sc.png")) ;//背景图案
		ico_sc.setImage(ico_sc.getImage().getScaledInstance(ico_sc.getIconWidth(),
															ico_sc.getIconHeight(), 
															Image.SCALE_DEFAULT));
		
		JButton button_4 = new JButton("\u852C\u83DC\u67E5\u8BE2");
		button_4.setFocusTraversalPolicyProvider(true);
		button_4.setFocusPainted(false);
		button_4.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/qt.png")));
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		
		button_4.setFont(new Font("黑体", Font.PLAIN, 16));
		button_4.setBounds(40, 234, 181, 48);
		UserFoodFrame.getContentPane().add(button_4);
		ImageIcon ico_qt = new ImageIcon(Login.class.getResource("qt.png")) ;//背景图案
		ico_qt.setImage(ico_qt.getImage().getScaledInstance(ico_qt.getIconWidth(),
															ico_qt.getIconHeight(), 
															Image.SCALE_DEFAULT));
		
		JButton button_5 = new JButton("\u5176\u4ED6\u98DF\u7269\u67E5\u8BE2");
		button_5.setFocusPainted(false);
		button_5.setFocusTraversalPolicyProvider(true);
		button_5.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/sc.png")));
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setFont(new Font("黑体", Font.PLAIN, 16));
		button_5.setBounds(40, 328, 203, 48);
		UserFoodFrame.getContentPane().add(button_5);
		ImageIcon ico_kll = new ImageIcon(Login.class.getResource("kll.png")) ;//背景图案
		ico_kll.setImage(ico_kll.getImage().getScaledInstance(ico_kll.getIconWidth(),
															ico_kll.getIconHeight(), 
															Image.SCALE_DEFAULT));
		
		JButton button_6 = new JButton("\u5361\u8DEF\u91CC\u67E5\u8BE2");
		button_6.setFocusPainted(false);
		button_6.setFocusTraversalPolicyProvider(true);
		button_6.setIcon(new ImageIcon(Userfoodcheck.class.getResource("/Power/qsdc.png")));
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		
		button_6.setFont(new Font("黑体", Font.PLAIN, 16));
		button_6.setBounds(40, 422, 190, 48);
		UserFoodFrame.getContentPane().add(button_6);
		ImageIcon ico_newfood = new ImageIcon(Login.class.getResource("newfood.png")) ;//背景图案
		ico_newfood.setImage(ico_newfood.getImage().getScaledInstance(ico_newfood.getIconWidth(),
															ico_newfood.getIconHeight(), 
															Image.SCALE_DEFAULT));
		
		//返回主页面
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				window.FoodFrame.setVisible(false);
				frame.dispose();

				UserFoodFrame.dispose();
				UserHome UserHome = new UserHome();
				try {
					UserHome.UserHomeFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//查询水果
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				panelFind.setVisible(true);
				textAreaResult.setText("");
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct fno,fname,fin,fcal From food where ftype='水果'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "水果编号："+rs.getString("fno")+"\t水果名称："+rs.getString("fname")+"\t建议摄入量："+rs.getString("fin")+"\t卡路里："+rs.getString("fcal");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询主食
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFind.setVisible(true);
				textAreaResult.setText("");
//				select distinct fno,fname,fin,fcal From food where ftype='主食'
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct fno,fname,fin,fcal From food where ftype='主食'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "主食编号："+rs.getString("fno")+"\t主食名称："+rs.getString("fname")+"\t建议摄入量："+rs.getString("fin")+"\t卡路里："+rs.getString("fcal");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询蔬菜
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFind.setVisible(true);

				textAreaResult.setText("");
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct fno,fname,fin,fcal From food where ftype='蔬菜'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "蔬菜编号："+rs.getString("fno")+"\t蔬菜名称："+rs.getString("fname")+"\t建议摄入量："+rs.getString("fin")+"\t卡路里："+rs.getString("fcal");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询其他食物
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFind.setVisible(true);

				textAreaResult.setText("");
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct * From food where ftype='蛋白质' or ftype='豆类'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "食物编号："+rs.getString("fno")+"\t食物名称："+rs.getString("fname")+"\n建议摄入量："
										+rs.getString("fin")+"\t卡路里："+rs.getString("fcal")+"\t食物类别："+rs.getString("ftype");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询卡路里
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFind.setVisible(true);

				textAreaResult.setText("");
				//select * From food Order by fcal desc
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From food Order by fcal desc";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "食物编号："+rs.getString("fno")+"\t食物名称："+rs.getString("fname")+"\n建议摄入量："
										+rs.getString("fin")+"\t卡路里："+rs.getString("fcal")+"\t食物类别："+rs.getString("ftype");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		panelFind.setVisible(true);
				
	}
	
}
