package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Component;

public class ShopFrame {
	Home MainPanel;
	JFrame ShopFrame;
	static ShopFrame window;
	private JTextField textField_iname;
	private JTextField textField_iprice;
	private JTextField textField_itype;
	private JTextField textField_istorage;
	private JTextField textField_ino;
	
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
					ShopFrame window = new ShopFrame();
					window.ShopFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ShopFrame = new JFrame();
		ShopFrame.setTitle("Power");
		ShopFrame.setBounds(100, 100, 930, 560);
		ShopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ShopFrame.getContentPane().setLayout(null);
		
		JPanel panelNew = new JPanel();
		panelNew.setBounds(286, 25, 618, 410);
		ShopFrame.getContentPane().add(panelNew);
		panelNew.setLayout(null);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5546\u54C1\u540D\u79F0\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(38, 104, 160, 19);
		panelNew.add(label_2);
		
		textField_iname = new JTextField();
		textField_iname.setColumns(10);
		textField_iname.setBounds(202, 102, 153, 21);
		panelNew.add(textField_iname);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(38, 26, 0, 0);
		panelNew.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u5546\u54C1\u7684\u5355\u4EF7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(38, 172, 192, 19);
		panelNew.add(label_4);
		
		textField_iprice = new JTextField();
		textField_iprice.setColumns(10);
		textField_iprice.setBounds(201, 170, 154, 21);
		panelNew.add(textField_iprice);
		
		JLabel label_5 = new JLabel("\u793A\u4F8B\uFF1APOWER\u667A\u80FD\u624B\u73AF");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		label_5.setBounds(365, 108, 153, 15);
		panelNew.add(label_5);
		
		JLabel label_6 = new JLabel("\u793A\u4F8B\uFF1A169 , \u5355\u4F4D\uFF1A\u5143");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		label_6.setBounds(365, 176, 177, 15);
		panelNew.add(label_6);
		
		JLabel label_7 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u5546\u54C1\u7684\u7C7B\u522B\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(38, 240, 192, 19);
		panelNew.add(label_7);
		
		textField_itype = new JTextField();
		textField_itype.setColumns(10);
		textField_itype.setBounds(202, 238, 153, 21);
		panelNew.add(textField_itype);
		
		JLabel label_8 = new JLabel("<html><body>\u793A\u4F8B\uFF1A\u667A\u80FD\u786C\u4EF6 , <br>\u9009\u9879\u8303\u56F4\uFF1A\u667A\u80FD\u786C\u4EF6/\u8FD0\u52A8\u88C5\u5907/\u8F7B\u98DF\u4EE3\u9910/\u5065\u8EAB\u670D\u9970/\u5176\u4ED6</body></html>");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("宋体", Font.PLAIN, 12));
		label_8.setBounds(365, 237, 228, 53);
		panelNew.add(label_8);
		
		JLabel label_9 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u5546\u54C1\u7684\u5E93\u5B58\u6570\u91CF\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 16));
		label_9.setBounds(38, 308, 192, 19);
		panelNew.add(label_9);
		
		textField_istorage = new JTextField();
		textField_istorage.setColumns(10);
		textField_istorage.setBounds(238, 306, 117, 21);
		panelNew.add(textField_istorage);
		
		JLabel label_10 = new JLabel("\u793A\u4F8B\uFF1A2000");
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("宋体", Font.PLAIN, 12));
		label_10.setBounds(365, 312, 198, 15);
		panelNew.add(label_10);
		
		JButton button_1 = new JButton("\u65B0\u589E\u5546\u54C1");
		
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(453, 338, 125, 44);
		panelNew.add(button_1);
		
		JLabel label_11 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_11.setFont(new Font("宋体", Font.PLAIN, 16));
		label_11.setBounds(38, 36, 160, 19);
		panelNew.add(label_11);
		
		textField_ino = new JTextField();
		textField_ino.setColumns(10);
		textField_ino.setBounds(202, 34, 153, 21);
		panelNew.add(textField_ino);
		
		JLabel label_12 = new JLabel("\u793A\u4F8B\uFF1Ai001");
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("宋体", Font.PLAIN, 12));
		label_12.setBounds(365, 40, 153, 15);
		panelNew.add(label_12);
		
		JPanel panelFind = new JPanel();
		panelFind.setBounds(286, 25, 618, 410);
		ShopFrame.getContentPane().add(panelFind);
		panelFind.setLayout(null);
		
		JButton button = new JButton("\u5237\u65B0\u67E5\u8BE2\u7ED3\u679C");
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(457, 355, 151, 44);
		panelFind.add(button);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(0, 51, 618, 295);
		panelFind.add(textAreaResult);
		
		JScrollPane scrollPaneReturn = new JScrollPane(textAreaResult);
		scrollPaneReturn.setBounds(0, 51, 618, 295);
		panelFind.add(scrollPaneReturn);
		
		JLabel label = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("幼圆", Font.PLAIN, 16));
		label.setBounds(0, 30, 151, 15);
		panelFind.add(label);
		
		JLabel label1 = new JLabel("POWER");
		label1.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label1.setBounds(0, 0, 64, 22);
		ShopFrame.getContentPane().add(label1);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u64CD\u4F5C\u7528\u6237\uFF1Acsnb");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(793, 10, 111, 15);
		ShopFrame.getContentPane().add(label_1);
		
		JButton button_Return = new JButton("\u8FD4 \u56DE");
		button_Return.setIcon(new ImageIcon(ShopFrame.class.getResource("/Power/return.png")));
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		button_Return.setBounds(732, 445, 172, 52);
		
		ShopFrame.getContentPane().add(button_Return);
		
		JButton button_znyj = new JButton("\u667A\u80FD\u786C\u4EF6");
		
		button_znyj.setIcon(new ImageIcon(ShopFrame.class.getResource("/Power/znyj.png")));
		button_znyj.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_znyj.setFocusTraversalKeysEnabled(false);
		button_znyj.setFocusPainted(false);
		button_znyj.setDefaultCapable(false);
		button_znyj.setContentAreaFilled(false);
		button_znyj.setBorderPainted(false);
		button_znyj.setBackground(SystemColor.info);
		button_znyj.setBounds(58, 26, 187, 72);
		ShopFrame.getContentPane().add(button_znyj);
		
		JButton button_jsfs = new JButton("\u5065\u8EAB\u670D\u9970");
		
		button_jsfs.setIcon(new ImageIcon(ShopFrame.class.getResource("/Power/jsfs.png")));
		button_jsfs.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_jsfs.setFocusTraversalKeysEnabled(false);
		button_jsfs.setFocusPainted(false);
		button_jsfs.setDefaultCapable(false);
		button_jsfs.setContentAreaFilled(false);
		button_jsfs.setBorderPainted(false);
		button_jsfs.setBackground(SystemColor.info);
		button_jsfs.setBounds(58, 124, 187, 72);
		ShopFrame.getContentPane().add(button_jsfs);
		
		JButton button_qsdc = new JButton("\u8F7B\u98DF\u4EE3\u9910");
		
		button_qsdc.setIcon(new ImageIcon(ShopFrame.class.getResource("/Power/qsdc.png")));
		button_qsdc.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_qsdc.setFocusTraversalKeysEnabled(false);
		button_qsdc.setFocusPainted(false);
		button_qsdc.setDefaultCapable(false);
		button_qsdc.setContentAreaFilled(false);
		button_qsdc.setBorderPainted(false);
		button_qsdc.setBackground(SystemColor.info);
		button_qsdc.setBounds(58, 222, 187, 72);
		ShopFrame.getContentPane().add(button_qsdc);
		
		JButton button_ydzb = new JButton(" \u8FD0\u52A8\u88C5\u5907");
		
		button_ydzb.setIcon(new ImageIcon(ShopFrame.class.getResource("/Power/ydzb.png")));
		button_ydzb.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_ydzb.setFocusTraversalKeysEnabled(false);
		button_ydzb.setFocusPainted(false);
		button_ydzb.setDefaultCapable(false);
		button_ydzb.setContentAreaFilled(false);
		button_ydzb.setBorderPainted(false);
		button_ydzb.setBackground(SystemColor.info);
		button_ydzb.setBounds(58, 320, 187, 72);
		ShopFrame.getContentPane().add(button_ydzb);
		
		JButton button_xzcp = new JButton("\u65B0\u589E\u4EA7\u54C1");
		
		button_xzcp.setIcon(new ImageIcon(ShopFrame.class.getResource("/Power/xjsp.png")));
		button_xzcp.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_xzcp.setFocusTraversalKeysEnabled(false);
		button_xzcp.setFocusPainted(false);
		button_xzcp.setDefaultCapable(false);
		button_xzcp.setContentAreaFilled(false);
		button_xzcp.setBorderPainted(false);
		button_xzcp.setBackground(SystemColor.info);
		button_xzcp.setBounds(58, 418, 187, 72);
		ShopFrame.getContentPane().add(button_xzcp);
		
		//返回主页面
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopFrame.dispose();
				MainPanel = new Home();
				try {
					MainPanel.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//查询智能硬件
		button_znyj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFind.setVisible(true);
				textAreaResult.setText("");
				//select distinct * From item where itype='智能硬件'
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct * From item where itype='智能硬件' ";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品单价："
										+rs.getString("iprice")+"\t商品库存量："+rs.getString("istorage");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询健身服饰
		button_jsfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFind.setVisible(true);
				textAreaResult.setText("");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct * From item where itype='健身服饰' ";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品单价："
										+rs.getString("iprice")+"\t商品库存量："+rs.getString("istorage");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询轻食代餐
		button_qsdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFind.setVisible(true);
				textAreaResult.setText("");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct * From item where itype='轻食代餐' ";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品单价："
										+rs.getString("iprice")+"\t商品库存量："+rs.getString("istorage");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查询运动装备
		button_ydzb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFind.setVisible(true);
				textAreaResult.setText("");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select distinct * From item where itype='运动装备' ";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "商品编号："+rs.getString("ino")+"\t商品名称："+rs.getString("iname")+"\t商品单价："
										+rs.getString("iprice")+"\t商品库存量："+rs.getString("istorage");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//新建商品panel切换
		button_xzcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(true);
				panelFind.setVisible(false);
			}
		});
		
		//新建商品
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert into item values('i001','POWER智能手环',169,'智能硬件',2000);
				String iname = textField_iname.getText();
				String ino = textField_ino.getText();
				String iprice = textField_iprice.getText();
				String itype = textField_itype.getText();
				String istorage = textField_istorage.getText();
				
//				JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					
					sqlStr="insert into item values('"+ino+"','"+iname+"',"+iprice+",'"+itype+"',"+istorage+")";
					st=conn.createStatement();
					st.execute(sqlStr);
					JOptionPane.showMessageDialog(ShopFrame, "新增 "+iname+" 商品成功！","新增商品成功~",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		panelFind.setVisible(true);
		panelNew.setVisible(false);
		
	}

}
