package Power;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 拔牙不打麻药
 *
 * @time 2020年5月24日
 */

public class VipFrame {
	 static VipFrame window;
	 JFrame VipFrame;
	 Home Home;
	 UserHome UserHome;
	 
	 JButton button_vipname;
	 JButton button_vipnum;
	 JButton button_viplevel;
	 JButton button_xuqi;
	 JButton button_register;
	 JButton button_logout;
	 
	 JPanel panel_vipnum;
	 JPanel panel_viplevel;
	 JPanel panel_vipxuqi;
	 JPanel panel_vipname;
	 JPanel panel_vipregister;
	 JPanel panel_logout;
	 
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_viplevel;
	 private JTextField textfield_vipname;
	 private JTextField textField_vipnum;
	 private JTextField textField_level;
	 private JTextField textField_date;
	 private JTextField textField_xuqi_vipnum;
	 private JTextField textField_xuqi_date;
	 private JLabel lblcsnb;
	 private JButton button_back;
	 
	 String sq;
	 Connection conn;
	 Statement st;
	 ResultSet rs;
	 final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	 final String userName="sa";
	 final String userPwd="123";
	 String sqlStr;
	 String sqlStr1;
	 private JTextField textField_logout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VipFrame window = new VipFrame();
					window.VipFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VipFrame() {
		initialize();
		button_vipname.setVisible(true);
		button_vipnum.setVisible(true);
		button_viplevel.setVisible(true);
		button_xuqi.setVisible(false);
		button_register.setVisible(false);
		button_logout.setVisible(false);
		
		panel_vipnum.setVisible(false);
		panel_viplevel.setVisible(false);
		panel_vipxuqi.setVisible(false);
		panel_vipname.setVisible(true);
		panel_vipregister.setVisible(false);
		panel_logout.setVisible(false);
		this.button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home Home=new Home();
				Home.setVisible(true);
				VipFrame.dispose();
				
			}
		});
	}
	
	public VipFrame(int i) {
		initialize();
		this.lblcsnb.setText("当前使用用户：请削猴子");
		button_vipname.setVisible(false);
		button_vipnum.setVisible(false);
		button_viplevel.setVisible(false);
		button_xuqi.setVisible(true);
		button_register.setVisible(true);
		button_logout.setVisible(true);
		
		panel_vipnum.setVisible(false);
		panel_viplevel.setVisible(false);
		panel_vipxuqi.setVisible(true);
		panel_vipname.setVisible(false);
		panel_vipregister.setVisible(false);
		panel_logout.setVisible(false);
		
		this.button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHome UserHome=new UserHome();
				UserHome.UserHomeFrame.setVisible(true);
				VipFrame.dispose();
							
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VipFrame = new JFrame();
		VipFrame.setTitle("POWER");
		VipFrame.setBounds(100, 100, 930, 560);
		VipFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VipFrame.getContentPane().setLayout(null);
		
		button_vipname = new JButton("\u67E5\u8BE2\u4F1A\u5458\u59D3\u540D");
		
		button_vipname.setFont(new Font("黑体", Font.PLAIN, 18));
		button_vipname.setVerifyInputWhenFocusTarget(false);
		button_vipname.setOpaque(false);
		button_vipname.setRolloverEnabled(false);
		button_vipname.setRequestFocusEnabled(false);
		button_vipname.setFocusTraversalKeysEnabled(false);
		button_vipname.setFocusPainted(false);
		button_vipname.setDefaultCapable(false);
		button_vipname.setContentAreaFilled(false);
		button_vipname.setBorderPainted(false);
		button_vipname.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/vipname.png")));
		button_vipname.setBounds(31, 32, 215, 57);
		VipFrame.getContentPane().add(button_vipname);
		
		button_vipnum = new JButton("\u67E5\u8BE2\u4F1A\u5458\u7F16\u53F7");
		
		button_vipnum.setBorderPainted(false);
		button_vipnum.setFont(new Font("黑体", Font.PLAIN, 18));
		button_vipnum.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/vipnum.png")));
		button_vipnum.setContentAreaFilled(false);
		button_vipnum.setBounds(31, 112, 215, 57);
		VipFrame.getContentPane().add(button_vipnum);
		
		button_viplevel = new JButton("\u67E5\u8BE2\u4F1A\u5458\u7B49\u7EA7");
		
		button_viplevel.setBorderPainted(false);
		button_viplevel.setFont(new Font("黑体", Font.PLAIN, 18));
		button_viplevel.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/viplevel.png")));
		button_viplevel.setContentAreaFilled(false);
		button_viplevel.setBounds(31, 192, 215, 57);
		VipFrame.getContentPane().add(button_viplevel);
		
		button_xuqi = new JButton("\u4F1A\u5458\u7EED\u671F");
		
		button_xuqi.setBorderPainted(false);
		button_xuqi.setFont(new Font("黑体", Font.PLAIN, 18));
		button_xuqi.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/vipxuqi.png")));
		button_xuqi.setContentAreaFilled(false);
		button_xuqi.setBounds(31, 32, 215, 57);
		VipFrame.getContentPane().add(button_xuqi);
		
		button_register = new JButton("\u4F1A\u5458\u6CE8\u518C");
		
		button_register.setBorderPainted(false);
		button_register.setFont(new Font("黑体", Font.PLAIN, 18));
		button_register.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/vipregister.png")));
		button_register.setContentAreaFilled(false);
		button_register.setBounds(31, 112, 215, 57);
		VipFrame.getContentPane().add(button_register);
		
		JLabel label = new JLabel("POWER");
		label.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label.setBounds(0, 0, 80, 24);
		VipFrame.getContentPane().add(label);
		
		panel_logout = new JPanel();
		panel_logout.setBounds(273, 37, 597, 395);
		VipFrame.getContentPane().add(panel_logout);
		panel_logout.setLayout(null);
		
		JTextArea textArea_logout = new JTextArea();
		textArea_logout.setBounds(28, 94, 537, 261);
		panel_logout.add(textArea_logout);
		
		JLabel label_6 = new JLabel("\u4F1A\u5458\u6CE8\u9500\uFF1A");
		label_6.setFont(new Font("黑体", Font.PLAIN, 18));
		label_6.setBounds(15, 36, 90, 21);
		panel_logout.add(label_6);
		
		textField_logout = new JTextField();
		textField_logout.setToolTipText("\u4F1A\u5458\u7F16\u53F7\uFF0C\u5982v030");
		textField_logout.setForeground(Color.BLACK);
		textField_logout.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_logout.setColumns(10);
		textField_logout.setBounds(110, 32, 150, 25);
		panel_logout.add(textField_logout);
		
		JButton button_logoutcheck = new JButton("\u6CE8\u9500");
		
		button_logoutcheck.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/search.png")));
		button_logoutcheck.setFont(new Font("黑体", Font.PLAIN, 18));
		button_logoutcheck.setBounds(302, 29, 117, 29);
		panel_logout.add(button_logoutcheck);
		
		panel_vipxuqi = new JPanel();
		panel_vipxuqi.setBounds(273, 37, 597, 395);
		VipFrame.getContentPane().add(panel_vipxuqi);
		panel_vipxuqi.setLayout(null);
		
		JTextArea textArea_xuqi = new JTextArea();
		textArea_xuqi.setBounds(28, 94, 537, 261);
		panel_vipxuqi.add(textArea_xuqi);
		
		JLabel label_5 = new JLabel("\u4F1A\u5458\u7EED\u671F\uFF1A");
		label_5.setFont(new Font("黑体", Font.PLAIN, 18));
		label_5.setBounds(15, 36, 90, 21);
		panel_vipxuqi.add(label_5);
		
		textField_xuqi_vipnum = new JTextField();
		textField_xuqi_vipnum.setToolTipText("\u4F1A\u5458\u7F16\u53F7,\u5982\uFF1Av002");
		textField_xuqi_vipnum.setForeground(Color.BLACK);
		textField_xuqi_vipnum.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_xuqi_vipnum.setColumns(10);
		textField_xuqi_vipnum.setBounds(110, 32, 150, 25);
		panel_vipxuqi.add(textField_xuqi_vipnum);
		
		textField_xuqi_date = new JTextField();
		textField_xuqi_date.setToolTipText("\u5230\u671F\u65F6\u95F4,\u5982\uFF1A2070-12-30");
		textField_xuqi_date.setForeground(Color.BLACK);
		textField_xuqi_date.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_xuqi_date.setColumns(10);
		textField_xuqi_date.setBounds(275, 32, 150, 25);
		panel_vipxuqi.add(textField_xuqi_date);
		
		JButton button_xuqi_check = new JButton("\u7EED\u671F");
		JButton button_3 = new JButton("\u6CE8\u518C");
		
		
		button_xuqi_check.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/search.png")));
		button_xuqi_check.setBounds(460, 28, 122, 29);
		panel_vipxuqi.add(button_xuqi_check);
		
		
		
		panel_vipregister = new JPanel();
		panel_vipregister.setBounds(273, 37, 597, 395);
		VipFrame.getContentPane().add(panel_vipregister);
		panel_vipregister.setLayout(null);
		
		JTextArea textArea_register = new JTextArea();
		textArea_register.setBounds(28, 94, 537, 261);
		panel_vipregister.add(textArea_register);
		
		JLabel label_4 = new JLabel("\u4F1A\u5458\u6CE8\u518C\uFF1A");
		label_4.setFont(new Font("黑体", Font.PLAIN, 18));
		label_4.setBounds(15, 39, 90, 21);
		panel_vipregister.add(label_4);
		
		
		
		textfield_vipname = new JTextField();
		textfield_vipname.setToolTipText("\u7528\u6237ID\uFF0C\u5982\uFF1A\u8FDE\u7FD8");
		textfield_vipname.setForeground(Color.BLACK);
		textfield_vipname.setFont(new Font("宋体", Font.PLAIN, 16));
		textfield_vipname.setColumns(10);
		textfield_vipname.setBounds(110, 35, 80, 25);
		panel_vipregister.add(textfield_vipname);
		
		textField_vipnum = new JTextField();
		textField_vipnum.setToolTipText("\u7528\u6237\u7F16\u53F7\uFF0C\u5982\uFF1Av030");
		textField_vipnum.setForeground(Color.BLACK);
		textField_vipnum.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_vipnum.setColumns(10);
		textField_vipnum.setBounds(205, 35, 80, 25);
		panel_vipregister.add(textField_vipnum);
		
		textField_level = new JTextField();
		textField_level.setToolTipText("\u7528\u6237\u7B49\u7EA7\uFF0C\u5982\uFF1A\u9EC4\u91D1");
		textField_level.setForeground(Color.BLACK);
		textField_level.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_level.setColumns(10);
		textField_level.setBounds(300, 35, 80, 25);
		panel_vipregister.add(textField_level);
		
		textField_date = new JTextField();
		textField_date.setToolTipText("\u5230\u671F\u65F6\u95F4\uFF0C\u5982\uFF1A2020-12-31");
		textField_date.setForeground(Color.BLACK);
		textField_date.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_date.setColumns(10);
		textField_date.setBounds(395, 35, 80, 25);
		panel_vipregister.add(textField_date);
		
		
		button_3.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/search.png")));
		button_3.setBounds(484, 31, 113, 29);
		panel_vipregister.add(button_3);
		
		panel_viplevel = new JPanel();
		panel_viplevel.setBounds(273, 37, 597, 395);
		VipFrame.getContentPane().add(panel_viplevel);
		panel_viplevel.setLayout(null);
		
		textField_viplevel = new JTextField();
		textField_viplevel.setToolTipText("\u4F1A\u5458\u7B49\u7EA7\uFF0C\u5982\uFF1A\u94BB\u77F3");
		textField_viplevel.setColumns(10);
		textField_viplevel.setBounds(110, 29, 150, 27);
		panel_viplevel.add(textField_viplevel);
		
		JLabel label_3 = new JLabel("\u4F1A\u5458\u7B49\u7EA7\uFF1A");
		label_3.setFont(new Font("黑体", Font.PLAIN, 18));
		label_3.setBounds(15, 35, 90, 21);
		panel_viplevel.add(label_3);
		
		JButton button_viplevelcheck = new JButton("\u67E5\u8BE2");
		
		button_viplevelcheck.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/search.png")));
		button_viplevelcheck.setBounds(319, 27, 122, 29);
		panel_viplevel.add(button_viplevelcheck);
		
		JTextArea textArea_viplevel = new JTextArea();
		textArea_viplevel.setBounds(28, 94, 537, 261);
		panel_viplevel.add(textArea_viplevel);
		
		panel_vipnum = new JPanel();
		panel_vipnum.setBounds(273, 37, 597, 395);
		VipFrame.getContentPane().add(panel_vipnum);
		panel_vipnum.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u4F1A\u5458\u59D3\u540D");
		textField_1.setColumns(10);
		textField_1.setBounds(110, 29, 150, 27);
		panel_vipnum.add(textField_1);
		
		JLabel label_2 = new JLabel("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		label_2.setToolTipText("\u4F1A\u5458\u7F16\u53F7\uFF0C\u5982v003");
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		label_2.setBounds(15, 35, 90, 21);
		panel_vipnum.add(label_2);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		

		button_1.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/search.png")));
		button_1.setBounds(319, 27, 114, 29);
		panel_vipnum.add(button_1);
		

		
		JTextArea textArea_vipnum = new JTextArea();
		textArea_vipnum.setBounds(28, 94, 537, 261);
		panel_vipnum.add(textArea_vipnum);
		
		panel_vipname = new JPanel();
		panel_vipname.setBounds(273, 37, 597, 395);
		VipFrame.getContentPane().add(panel_vipname);
		panel_vipname.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("\u4F1A\u5458\u59D3\u540D,\u5982\u8BF7\u524A\u7334\u5B50");
		textField.setColumns(10);
		textField.setBounds(110, 29, 150, 27);
		panel_vipname.add(textField);
		
		JLabel label_1 = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(15, 35, 90, 21);
		panel_vipname.add(label_1);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/search.png")));
		button.setBounds(319, 27, 114, 29);
		panel_vipname.add(button);
		
		
		
		JTextArea textArea_vipname = new JTextArea();
		textArea_vipname.setBounds(28, 94, 537, 261);
		panel_vipname.add(textArea_vipname);
		//滚动条
		JScrollPane scrollPane_username = new JScrollPane(textArea_vipname);
		scrollPane_username.setBounds(28, 94, 537, 261);
		panel_vipname.add(scrollPane_username);
		
		JScrollPane scrollPane_vipnum = new JScrollPane(textArea_vipnum);
		scrollPane_vipnum.setBounds(28, 94, 537, 261);
		panel_vipnum.add(scrollPane_vipnum);
		
		JScrollPane scrollPane = new JScrollPane(textArea_viplevel);
		scrollPane.setBounds(28, 94, 537, 261);
		panel_viplevel.add(scrollPane);
		
		JScrollPane scrollPane_xuqi = new JScrollPane(textArea_xuqi);
		scrollPane_xuqi.setBounds(28, 94, 537, 261);
		panel_vipxuqi.add(scrollPane_xuqi);
		
		JScrollPane scrollPane_register = new JScrollPane(textArea_register);
		scrollPane_register.setBounds(28, 94, 537, 261);
		panel_vipregister.add(scrollPane_register);
		
		JScrollPane scrollPane_logout = new JScrollPane(textArea_logout);
		scrollPane_logout.setBounds(28, 94, 537, 261);
		panel_logout.add(scrollPane_logout);
		
		button_back = new JButton("\u8FD4\u56DE");
		button_back.setBorderPainted(false);
		
		button_back.setContentAreaFilled(false);
		button_back.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/return.png")));
		button_back.setBounds(736, 447, 172, 52);
		button_back.setForeground(Color.GRAY);
		button_back.setFont(new Font("黑体", Font.PLAIN, 22));
		VipFrame.getContentPane().add(button_back);
		
		lblcsnb = new JLabel("\u60A8\u6B63\u5728\u767B\u5F55\u7684\u5E10\u53F7\u662F\uFF1Acsnb");
		lblcsnb.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblcsnb.setBounds(639, 15, 281, 21);
		VipFrame.getContentPane().add(lblcsnb);
		
		button_logout = new JButton("\u4F1A\u5458\u6CE8\u9500");
		
		button_logout.setIcon(new ImageIcon(VipFrame.class.getResource("/Power/logout.png")));
		button_logout.setFont(new Font("黑体", Font.PLAIN, 18));
		button_logout.setContentAreaFilled(false);
		button_logout.setBorderPainted(false);
		button_logout.setBounds(31, 192, 215, 57);
		VipFrame.getContentPane().add(button_logout);
		
//		panel_viplevel.setVisible(false);
//		panel_vipname.setVisible(true);
//		panel_vipnum.setVisible(false);
//		panel_vipregister.setVisible(false);
//		panel_vipxuqi.setVisible(false);
//		panel_logout.setVisible(false);
		
		textArea_logout.setFont(new Font("宋体",Font.PLAIN,16));
		
		
		textArea_register.setFont(new Font("宋体",Font.PLAIN,16));
		textArea_viplevel.setFont(new Font("宋体",Font.PLAIN,16));
		textArea_vipname.setFont(new Font("宋体",Font.PLAIN,16));
		textArea_vipnum.setFont(new Font("宋体",Font.PLAIN,16));
		textArea_xuqi.setFont(new Font("宋体",Font.PLAIN,16));
		
		button_vipname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_viplevel.setVisible(false);
				panel_vipname.setVisible(true);
				panel_vipnum.setVisible(false);
				panel_vipregister.setVisible(false);
				panel_vipxuqi.setVisible(false);
				panel_logout.setVisible(false);
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     while(rs.next()) {
				      result = "会员信息总览\n"+"会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_vipname.setText(textArea_vipname.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button_vipnum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_viplevel.setVisible(false);
				panel_vipname.setVisible(false);
				panel_vipnum.setVisible(true);
				panel_vipregister.setVisible(false);
				panel_vipxuqi.setVisible(false);
				panel_logout.setVisible(false);
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_vipnum.setText("");
				     while(rs.next()) {
				      result = "会员信息总览\n"+"会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_vipnum.setText(textArea_vipnum.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button_viplevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_viplevel.setVisible(true);
				panel_vipname.setVisible(false);
				panel_vipnum.setVisible(false);
				panel_vipregister.setVisible(false);
				panel_vipxuqi.setVisible(false);
				panel_logout.setVisible(false);
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_viplevel.setText("");
				     while(rs.next()) {
				      result = "会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_viplevel.setText(textArea_viplevel.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button_xuqi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_viplevel.setVisible(false);
				panel_vipname.setVisible(false);
				panel_vipnum.setVisible(false);
				panel_vipregister.setVisible(false);
				panel_vipxuqi.setVisible(true);
				panel_logout.setVisible(false);
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_xuqi.setText("");
				     while(rs.next()) {
				      result = "会员信息总览\n"+"会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_xuqi.setText(textArea_xuqi.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_viplevel.setVisible(false);
				panel_vipname.setVisible(false);
				panel_vipnum.setVisible(false);
				panel_vipregister.setVisible(true);
				panel_vipxuqi.setVisible(false);
				panel_logout.setVisible(false);
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_register.setText("");
				     while(rs.next()) {
				      result = "会员信息总览\n"+"会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_register.setText(textArea_register.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
			
		});
		
		button_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_viplevel.setVisible(false);
				panel_vipname.setVisible(false);
				panel_vipnum.setVisible(false);
				panel_vipregister.setVisible(false);
				panel_vipxuqi.setVisible(false);
				panel_logout.setVisible(true);
				
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_logout.setText("");
				     while(rs.next()) {
				      result = "请选择需要注销的用户：\n"+"会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_logout.setText(textArea_logout.getText()+result+"\n");
				      
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//select * From food Order by fcal desc
			    try {
			     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			     conn=DriverManager.getConnection(dbURL,userName,userPwd);
			     sqlStr="select * from vip where uname="+"'"+textField.getText()+"'";
			     System.out.println(sqlStr);
			     st= conn.createStatement();
			     rs=st.executeQuery(sqlStr);
			     String result = "";
			     textArea_vipname.setText("");
			     while(rs.next()) {
			      result = "会员编号："+rs.getString("vno")+"用户编号："+rs.getString("uno")+"用户ID："
			          +rs.getString("uname")+"会员等级："+rs.getString("iclass")+"会员到期："+rs.getString("vdate");
			      textArea_vipname.setText(textArea_vipname.getText()+result+"\n");
			      JOptionPane.showMessageDialog(VipFrame, "查询成功！不愧是你！","古德！",JOptionPane.INFORMATION_MESSAGE);
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
				     sqlStr="select * from vip where vno="+"'"+textField_1.getText()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_vipnum.setText("");
				     while(rs.next()) {
				      result = "会员编号："+rs.getString("vno")+"用户编号："+rs.getString("uno")+"用户ID："
				          +rs.getString("uname")+"会员等级："+rs.getString("iclass")+"会员到期："+rs.getString("vdate");
				      textArea_vipnum.setText(textArea_vipnum.getText()+result+"\n");
				      JOptionPane.showMessageDialog(VipFrame, "查询成功！csnb！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_viplevelcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from vip where iclass="+"'"+textField_viplevel.getText()+"'";
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea_viplevel.setText("");
				     while(rs.next()) {
				      result = "会员编号："+rs.getString("vno")+"\t用户编号："+rs.getString("uno")+"\t用户ID："
				          +rs.getString("uname")+"\t会员等级："+rs.getString("iclass")+"\t会员到期："+rs.getString("vdate");
				      textArea_viplevel.setText(textArea_viplevel.getText()+result+"\n");
				      
				     }
				     JOptionPane.showMessageDialog(VipFrame, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_xuqi_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="update vip set vdate='"+textField_xuqi_date.getText()+"' where vno='"+textField_xuqi_vipnum.getText()+"'";
				     textArea_xuqi.setText("");
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     textArea_xuqi.setText("更新成功！"+"\n");
				     st.executeQuery(sqlStr);
				      
				     JOptionPane.showMessageDialog(VipFrame, "续期成功！老客户打七点骨折！","古德！",JOptionPane.INFORMATION_MESSAGE);
				    }
				    catch(Exception e1) {
				     //JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="insert into vip values('"+textField_vipnum.getText()+"','','"+textfield_vipname.getText()+"','"+textField_level.getText()+"','"+textField_date.getText()+"')";
				     textArea_register.setText("");
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     textArea_register.setText("");
				     textArea_register.setText("注册成功！"+"\n");
				     st.executeQuery(sqlStr);

				      
				      
				     
				     JOptionPane.showMessageDialog(VipFrame, "注册成功！游泳健身了解一下？","古德！",JOptionPane.INFORMATION_MESSAGE);
				    }
				    catch(Exception e1) {
				     //JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_logoutcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="delete from vip where vno='"+textField_logout.getText()+"';";
				     textArea_logout.setText("");
				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     textArea_logout.setText("");
				     textArea_logout.setText(textField_logout.getText()+"用户注销成功！"+"\n");
				     st.executeQuery(sqlStr);
				    // JOptionPane.showMessageDialog(null, "注销成功！常来玩呀~","古德！",JOptionPane.INFORMATION_MESSAGE);
				    }
				    catch(Exception e1) {
				     //JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});

		
	}
}