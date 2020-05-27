package Power;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;

/**
 * @author 拔牙不打麻药
 *
 * @time 2020年5月25日
 */


public class UserPowerShop {
	UserHome UserHome;
	static UserPowerShop window;
	JFrame UserShopFrame;
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	final String userName="sa";
	final String userPwd="123";
	String sqlStr;
	private JTextField textField_harward;
	private JTextField textField_clothes;
	private JTextField textField_food;
	private JTextField textField_tools;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPowerShop window = new UserPowerShop();
					window.UserShopFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserPowerShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserShopFrame = new JFrame();
		UserShopFrame.setTitle("POWER");
		UserShopFrame.setBounds(100, 100, 930, 560);
		UserShopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserShopFrame.getContentPane().setLayout(null);
		
		JLabel label_power = new JLabel("POWER");
		label_power.setToolTipText("POWER\u5065\u8EAB\u8FD0\u52A8\u7BA1\u7406\u7CFB\u7EDF");
		label_power.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label_power.setBounds(0, 0, 80, 24);
		UserShopFrame.getContentPane().add(label_power);
		
		JButton button_hardward = new JButton("\u667A\u80FD\u786C\u4EF6");
		
		button_hardward.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_hardward.png")));
		button_hardward.setToolTipText("\u67E5\u8BE2\u667A\u80FD\u786C\u4EF6\u5206\u7C7B");
		button_hardward.setContentAreaFilled(false);
		button_hardward.setBorderPainted(false);
		button_hardward.setFont(new Font("黑体", Font.PLAIN, 18));
		button_hardward.setBounds(45, 62, 215, 57);
		UserShopFrame.getContentPane().add(button_hardward);
		
		JButton button_clothes = new JButton("\u5065\u8EAB\u670D\u9970");
		
		button_clothes.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_clothes.png")));
		button_clothes.setToolTipText("\u67E5\u8BE2\u5065\u8EAB\u670D\u9970\u5206\u7C7B");
		button_clothes.setFont(new Font("黑体", Font.PLAIN, 18));
		button_clothes.setContentAreaFilled(false);
		button_clothes.setBorderPainted(false);
		button_clothes.setBounds(45, 172, 215, 57);
		UserShopFrame.getContentPane().add(button_clothes);
		
		JButton button_food = new JButton("\u8F7B\u98DF\u4EE3\u9910");
		
		button_food.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_food.png")));
		button_food.setToolTipText("\u67E5\u8BE2\u8F7B\u98DF\u4EE3\u9910\u5206\u7C7B");
		button_food.setFont(new Font("黑体", Font.PLAIN, 18));
		button_food.setContentAreaFilled(false);
		button_food.setBorderPainted(false);
		button_food.setBounds(45, 282, 215, 57);
		UserShopFrame.getContentPane().add(button_food);
		
		JButton button_tools = new JButton("\u8FD0\u52A8\u88C5\u5907");
		
		button_tools.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_tools.png")));
		button_tools.setToolTipText("\u67E5\u8BE2\u8FD0\u52A8\u88C5\u5907\u5206\u7C7B");
		button_tools.setFont(new Font("黑体", Font.PLAIN, 18));
		button_tools.setContentAreaFilled(false);
		button_tools.setBorderPainted(false);
		button_tools.setBounds(45, 392, 215, 57);
		UserShopFrame.getContentPane().add(button_tools);
		
		JLabel lblcsnb = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		lblcsnb.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblcsnb.setBounds(627, 0, 281, 21);
		UserShopFrame.getContentPane().add(lblcsnb);
		
		JButton button = new JButton("\u8FD4\u56DE");
		
		button.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/return.png")));
		button.setForeground(Color.GRAY);
		button.setFont(new Font("黑体", Font.PLAIN, 22));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(685, 459, 172, 52);
		UserShopFrame.getContentPane().add(button);
		
		JPanel panel_tools = new JPanel();
		panel_tools.setLayout(null);
		panel_tools.setBounds(250, 30, 640, 400);
		UserShopFrame.getContentPane().add(panel_tools);
		
		JTextArea textArea_tools = new JTextArea();
		textArea_tools.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea_tools.setBounds(28, 94, 535, 259);
		panel_tools.add(textArea_tools);
		
		JLabel label_tools = new JLabel("\u8FD0\u52A8\u88C5\u5907\uFF1A");
		label_tools.setFont(new Font("黑体", Font.PLAIN, 18));
		label_tools.setBounds(15, 36, 90, 21);
		panel_tools.add(label_tools);
		
		textField_tools = new JTextField();
		textField_tools.setToolTipText("\u8FD0\u52A8\u88C5\u5907\uFF0C\u5982\uFF1A\u901F\u5E72T\u6064");
		textField_tools.setForeground(Color.BLACK);
		textField_tools.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_tools.setColumns(10);
		textField_tools.setBounds(110, 32, 150, 25);
		panel_tools.add(textField_tools);
		
		JButton button_toolscheck = new JButton("\u67E5\u8BE2");
		
		button_toolscheck.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_search.png")));
		button_toolscheck.setFont(new Font("黑体", Font.PLAIN, 18));
		button_toolscheck.setDefaultCapable(false);
		button_toolscheck.setContentAreaFilled(false);
		button_toolscheck.setBorderPainted(false);
		button_toolscheck.setBounds(313, 32, 120, 29);
		panel_tools.add(button_toolscheck);
		
		
		
		JPanel panel_food = new JPanel();
		panel_food.setBounds(250, 30, 640, 400);
		UserShopFrame.getContentPane().add(panel_food);
		panel_food.setLayout(null);
		
		JTextArea textArea_food = new JTextArea();
		textArea_food.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea_food.setBounds(28, 94, 535, 259);
		panel_food.add(textArea_food);
		
		JLabel label_food = new JLabel("\u8F7B\u98DF\u4EE3\u9910\uFF1A");
		label_food.setFont(new Font("黑体", Font.PLAIN, 18));
		label_food.setBounds(15, 36, 90, 21);
		panel_food.add(label_food);
		
		textField_food = new JTextField();
		textField_food.setToolTipText("\u8F7B\u98DF\u4EE3\u9910\uFF0C\u5982\u9B54\u828B\u51C9\u76AE");
		textField_food.setForeground(Color.BLACK);
		textField_food.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_food.setColumns(10);
		textField_food.setBounds(110, 32, 150, 25);
		panel_food.add(textField_food);
		
		JButton button_foodcheck = new JButton("\u67E5\u8BE2");
		
		button_foodcheck.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_search.png")));
		button_foodcheck.setFont(new Font("黑体", Font.PLAIN, 18));
		button_foodcheck.setDefaultCapable(false);
		button_foodcheck.setContentAreaFilled(false);
		button_foodcheck.setBorderPainted(false);
		button_foodcheck.setBounds(313, 32, 120, 29);
		panel_food.add(button_foodcheck);
		
		
		
		JPanel panel_clothes = new JPanel();
		panel_clothes.setBounds(250, 30, 640, 400);
		UserShopFrame.getContentPane().add(panel_clothes);
		panel_clothes.setLayout(null);
		
		JTextArea textArea_clothes = new JTextArea();
		textArea_clothes.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea_clothes.setBounds(28, 94, 537, 261);
		panel_clothes.add(textArea_clothes);
		
		JLabel label_clothes = new JLabel("\u5065\u8EAB\u670D\u9970\uFF1A");
		label_clothes.setFont(new Font("黑体", Font.PLAIN, 18));
		label_clothes.setBounds(15, 36, 90, 21);
		panel_clothes.add(label_clothes);
		
		textField_clothes = new JTextField();
		textField_clothes.setToolTipText("\u5065\u8EAB\u670D\u9970\uFF0C\u5982\u900F\u6C14\u8FD0\u52A8\u5916\u5957");
		textField_clothes.setForeground(Color.BLACK);
		textField_clothes.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_clothes.setColumns(10);
		textField_clothes.setBounds(110, 32, 150, 25);
		panel_clothes.add(textField_clothes);
		
		JButton button_clothescheck = new JButton("\u67E5\u8BE2");
		button_clothescheck.setDefaultCapable(false);
		button_clothescheck.setContentAreaFilled(false);
		button_clothescheck.setBorderPainted(false);
		
		button_clothescheck.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_search.png")));
		button_clothescheck.setFont(new Font("黑体", Font.PLAIN, 18));
		button_clothescheck.setBounds(313, 32, 110, 29);
		panel_clothes.add(button_clothescheck);
		
		
		
		JPanel panel_harward = new JPanel();
		panel_harward.setLayout(null);
		panel_harward.setBounds(250, 30, 640, 400);
		UserShopFrame.getContentPane().add(panel_harward);
		
		JTextArea textArea_harward = new JTextArea();
		textArea_harward.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea_harward.setBounds(45, 93, 537, 261);
		panel_harward.add(textArea_harward);
		
		JLabel label_1 = new JLabel("\u667A\u80FD\u786C\u4EF6\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(15, 36, 90, 21);
		panel_harward.add(label_1);
		
		textField_harward = new JTextField();
		textField_harward.setToolTipText("\u4F1A\u5458\u7F16\u53F7\uFF0C\u5982POWER\u667A\u80FD\u624B\u73AF3");
		textField_harward.setForeground(Color.BLACK);
		textField_harward.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_harward.setColumns(10);
		textField_harward.setBounds(110, 32, 150, 25);
		panel_harward.add(textField_harward);
		
		JButton button_harward = new JButton("\u67E5\u8BE2");
		
		button_harward.setDefaultCapable(false);
		button_harward.setContentAreaFilled(false);
		button_harward.setBorderPainted(false);
		button_harward.setIcon(new ImageIcon(UserPowerShop.class.getResource("/Power/shop_search.png")));
		button_harward.setFont(new Font("黑体", Font.PLAIN, 18));
		button_harward.setBounds(313, 32, 120, 29);
		panel_harward.add(button_harward);
		//滚动条
		JScrollPane scrollPane_hardward = new JScrollPane(textArea_harward);
		scrollPane_hardward.setBounds(45, 93, 537, 261);
		panel_harward.add(scrollPane_hardward);
		
		JScrollPane scrollPane_clothes = new JScrollPane(textArea_clothes);
		scrollPane_clothes.setBounds(45, 93, 537, 261);
		panel_clothes.add(scrollPane_clothes);
		
		JScrollPane scrollPane__food = new JScrollPane(textArea_food);
		scrollPane__food.setBounds(45, 93, 537, 261);
		panel_food.add(scrollPane__food);
		
		JScrollPane scrollPane_tools = new JScrollPane(textArea_tools);
		scrollPane_tools.setBounds(45, 93, 537, 261);
		panel_tools.add(scrollPane_tools);
		
		//切换panel
		button_hardward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_harward.setVisible(true);
				panel_clothes.setVisible(false);
				panel_food.setVisible(false);
				panel_tools.setVisible(false);
				textArea_harward.setText("");
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where itype = '智能硬件'";
//				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_harward.setText(textArea_harward.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_clothes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_harward.setVisible(false);
				panel_clothes.setVisible(true);
				panel_food.setVisible(false);
				panel_tools.setVisible(false);
				textArea_clothes.setText("");
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where itype = '健身服饰'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_clothes.setText(textArea_clothes.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
			
		});
		
		button_food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_harward.setVisible(false);
				panel_clothes.setVisible(false);
				panel_food.setVisible(true);
				panel_tools.setVisible(false);
				textArea_food.setText("");
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where itype = '轻食代餐'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_food.setText(textArea_food.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_tools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_harward.setVisible(false);
				panel_clothes.setVisible(false);
				panel_food.setVisible(false);
				panel_tools.setVisible(true);
				textArea_tools.setText("");
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where itype = '运动装备'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_tools.setText(textArea_tools.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		
		//查询
		
		button_harward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where iname='"+textField_harward.getText()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     textArea_harward.setText("");
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_harward.setText(textArea_harward.getText()+result+"\n");
				      JOptionPane.showMessageDialog(UserShopFrame, "查询成功！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_clothescheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where iname='"+textField_clothes.getText()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     textArea_clothes.setText("");
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_clothes.setText(textArea_clothes.getText()+result+"\n");
				      JOptionPane.showMessageDialog(UserShopFrame, "查询成功！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_foodcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where iname='"+textField_food.getText()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     textArea_food.setText("");
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_food.setText(textArea_food.getText()+result+"\n");
				      JOptionPane.showMessageDialog(UserShopFrame, "查询成功！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_toolscheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from item where iname='"+textField_tools.getText()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     textArea_tools.setText("");
				     String result = "";
				     while(rs.next()) {
				      result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品价格："
				          +rs.getString("iprice")+"\t商品类别："+rs.getString("itype")+"\t商品库存："+rs.getString("istorage");
				      textArea_tools.setText(textArea_tools.getText()+result+"\n");
				      JOptionPane.showMessageDialog(UserShopFrame, "查询成功！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		//返回用户主页面
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserShopFrame.dispose();
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
