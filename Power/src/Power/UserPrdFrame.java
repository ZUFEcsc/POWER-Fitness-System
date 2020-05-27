package Power;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserPrdFrame {
	UserPrdFrame window;
	JFrame PrdFrame;
	UserHome UserHome;

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
					UserPrdFrame window = new UserPrdFrame();
					window.PrdFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserPrdFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PrdFrame = new JFrame();
		PrdFrame.setTitle("POWER");
		PrdFrame.setBounds(100, 100, 930, 560);
		PrdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrdFrame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("POWER");
		label.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label.setBounds(0, 0, 69, 33);
		PrdFrame.getContentPane().add(label);
		
		JButton button_ckft = new JButton("\u67E5\u770B\u52A8\u6001");
				
		button_ckft.setFocusPainted(false);
		button_ckft.setIcon(new ImageIcon(PrdFrame.class.getResource("/Power/ckdt.png")));
		button_ckft.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_ckft.setFocusTraversalKeysEnabled(false);
		button_ckft.setDefaultCapable(false);
		button_ckft.setContentAreaFilled(false);
		button_ckft.setBorderPainted(false);
		button_ckft.setBackground(SystemColor.info);
		button_ckft.setBounds(47, 307, 222, 119);
		PrdFrame.getContentPane().add(button_ckft);
		
		JButton button_fbdt = new JButton("\u53D1\u5E03\u52A8\u6001");
				
		button_fbdt.setFocusPainted(false);
		button_fbdt.setIcon(new ImageIcon(PrdFrame.class.getResource("/Power/fbdt.png")));
		button_fbdt.setActionCommand("\u53D1\u5E03\u52A8\u6001");
		button_fbdt.setFont(new Font("幼圆", Font.PLAIN, 16));
		button_fbdt.setFocusTraversalKeysEnabled(false);
		button_fbdt.setDefaultCapable(false);
		button_fbdt.setContentAreaFilled(false);
		button_fbdt.setBorderPainted(false);
		button_fbdt.setBackground(SystemColor.info);
		button_fbdt.setBounds(47, 93, 222, 119);
		PrdFrame.getContentPane().add(button_fbdt);
		
		JPanel panel_fbdt = new JPanel();
		panel_fbdt.setBounds(275, 35, 618, 410);
		PrdFrame.getContentPane().add(panel_fbdt);
		panel_fbdt.setLayout(null);
		
		JButton button = new JButton("\u786E\u8BA4\u53D1\u5E03");
				
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(440, 344, 168, 44);
		panel_fbdt.add(button);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u52A8\u6001\u5185\u5BB9\uFF1A");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_4.setBounds(0, 61, 128, 15);
		panel_fbdt.add(label_4);
		
		JTextField textField = new JTextField();
		textField.setAlignmentY(Component.TOP_ALIGNMENT);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField.setMargin(new Insets(10, 10, 2, 2));
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(0, 79, 618, 202);
		panel_fbdt.add(textField);
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		
		String xtsh=df.format(new Date()).toString();
		System.out.println(xtsh.substring(8,11));
		JLabel label_5 = new JLabel("\u7CFB\u7EDF\u65E5\u671F\uFF1A "+xtsh);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_5.setBounds(363, 290, 255, 24);
		panel_fbdt.add(label_5);
		
		JButton btnpower = new JButton("\u6309\u6700\u65B0\u65F6\u95F4\u5F00\u59CB\u770B");
		btnpower.setBounds(440, 344, 168, 44);
		panel_fbdt.add(btnpower);
		btnpower.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JPanel panel_ckdt = new JPanel();
		panel_ckdt.setLayout(null);
		panel_ckdt.setBounds(275, 35, 618, 410);
		PrdFrame.getContentPane().add(panel_ckdt);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(0, 44, 618, 276);
		panel_ckdt.add(textAreaResult);
		
		JScrollPane scrollPaneReturn = new JScrollPane(textAreaResult);
		scrollPaneReturn.setBounds(0, 44, 618, 276);
		panel_ckdt.add(scrollPaneReturn);
		
		JLabel lblPower = new JLabel("Power\u5708\u52A8\u6001\uFF1A");
		lblPower.setForeground(Color.DARK_GRAY);
		lblPower.setFont(new Font("幼圆", Font.PLAIN, 16));
		lblPower.setBounds(0, 25, 151, 15);
		panel_ckdt.add(lblPower);
		
		JButton button_Return = new JButton("\u8FD4 \u56DE");
		button_Return.setIcon(new ImageIcon(UserPrdFrame.class.getResource("/Power/return.png")));
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		button_Return.setBounds(724, 455, 169, 56);
		PrdFrame.getContentPane().add(button_Return);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		label_1.setBounds(735, 0, 169, 21);
		PrdFrame.getContentPane().add(label_1);
		
		//发布动态panel切换
		button_fbdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_fbdt.setVisible(true);
				panel_ckdt.setVisible(false);
			}
		});
		
		//用户发布动态
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dtStr = textField.getText();
				String pno = "p1"+xtsh.substring(8,11);
//				System.out.println(pno);
//				insert into prend values('p020','u017','2020-05-07','为什么要回学校了？？？？？');
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					
					sqlStr="insert into prend values('"+pno+"','u017','"+xtsh+"','"+dtStr+"')";
					st=conn.createStatement();
					st.execute(sqlStr);
					JOptionPane.showMessageDialog(PrdFrame, "发布动态成功！","发布动态成功~",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(PrdFrame, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//查看动态panel切换
		button_ckft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_fbdt.setVisible(false);
				panel_ckdt.setVisible(true);
				textAreaResult.setText("");
				//select * From prend Order by ptime desc
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From prend Order by ptime desc";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "动态编号："+rs.getString("pno")+"\t动态发布者："+rs.getString("uno")+"\n动态发布时间："
										+rs.getString("ptime")+"\n动态内容："+rs.getString("ptext")
										+"\n┄┅┄┅┄┅┄┅┄° ┄┅┄┅┄┅┄┅┄＊ ┄┅┄┅┄┅┄┅┄°  ,•´ ¸,•´`) ";
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(PrdFrame, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//返回按钮
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrdFrame.dispose();
				UserHome UserHome = new UserHome();
				try {
					UserHome.UserHomeFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		panel_fbdt.setVisible(true);
		panel_ckdt.setVisible(false);
	}

}
