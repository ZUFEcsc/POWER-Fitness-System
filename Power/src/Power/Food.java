package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Food {
	Home MainPanel;
	static Food window;
	
	JFrame FoodFrame;
	JTextField textField_fname;
	JTextField textField_fin;
	JTextField textField_fcal;
	JTextField textField_fno;

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
					window = new Food();
					window.FoodFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Food() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FoodFrame = new JFrame();
		FoodFrame.setTitle("POWER");
		FoodFrame.setBounds(100, 100, 930, 560);
		FoodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FoodFrame.getContentPane().setLayout(null);
		
		JPanel panelFind = new JPanel();
		panelFind.setBounds(286, 10, 618, 410);
		FoodFrame.getContentPane().add(panelFind);
		panelFind.setLayout(null);
		
		JLabel label_12 = new JLabel("\u5F53\u524D\u64CD\u4F5C\u7528\u6237\uFF1Acsnb");
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("宋体", Font.PLAIN, 12));
		label_12.setBounds(497, 1, 111, 15);
		panelFind.add(label_12);
		
		JButton button = new JButton("\u5237\u65B0\u67E5\u8BE2\u7ED3\u679C");
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(457, 356, 151, 44);
		panelFind.add(button);
		
		JLabel label = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("幼圆", Font.PLAIN, 16));
		label.setBounds(0, 26, 151, 15);
		panelFind.add(label);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(0, 51, 618, 295);
		panelFind.add(textAreaResult);
		
		JScrollPane scrollPaneReturn = new JScrollPane(textAreaResult);
		scrollPaneReturn.setBounds(0, 51, 618, 295);
		panelFind.add(scrollPaneReturn);
		
		
		//-------------------------------------
		JPanel panelNew = new JPanel();
		panelNew.setLayout(null);
		panelNew.setBounds(286, 10, 618, 410);
		FoodFrame.getContentPane().add(panelNew);
		
		JLabel label1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u98DF\u7269\u540D\u79F0\uFF1A");
		label1.setFont(new Font("宋体", Font.PLAIN, 16));
		label1.setBounds(39, 113, 160, 19);
		panelNew.add(label1);
		
		textField_fname = new JTextField();
		textField_fname.setColumns(10);
		textField_fname.setBounds(204, 111, 153, 21);
		panelNew.add(textField_fname);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(39, 44, 0, 0);
		panelNew.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u98DF\u7269\u7684\u6444\u5165\u91CF\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(39, 175, 192, 19);
		panelNew.add(label_2);
		
		textField_fin = new JTextField();
		textField_fin.setColumns(10);
		textField_fin.setBounds(241, 173, 117, 21);
		panelNew.add(textField_fin);
		
		JLabel label_3 = new JLabel("\u793A\u4F8B\uFF1A\u8349\u8393");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(369, 116, 111, 15);
		panelNew.add(label_3);
		
		JLabel label_4 = new JLabel("\u793A\u4F8B\uFF1A100 , \u5355\u4F4D\uFF1A\u514B");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(369, 178, 177, 15);
		panelNew.add(label_4);
		
		JLabel label_5 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u98DF\u7269\u7684\u5361\u8DEF\u91CC\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(39, 237, 184, 19);
		panelNew.add(label_5);
		
		textField_fcal = new JTextField();
		textField_fcal.setColumns(10);
		textField_fcal.setBounds(240, 235, 117, 21);
		panelNew.add(textField_fcal);
		
		JLabel label_6 = new JLabel("\u793A\u4F8B\uFF1A32");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		label_6.setBounds(369, 240, 177, 15);
		panelNew.add(label_6);
		
		JLabel label_7 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u98DF\u7269\u7684\u79CD\u7C7B\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(39, 299, 192, 19);
		panelNew.add(label_7);
		
		JTextField textField_ftype = new JTextField();
		textField_ftype.setColumns(10);
		textField_ftype.setBounds(204, 297, 153, 21);
		panelNew.add(textField_ftype);
		
		JLabel label_8 = new JLabel("<html><body>示例：水果 , "
				+ "<br>选项范围：水果/主食/蛋白质/豆类/蔬菜</body></html>");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("宋体", Font.PLAIN, 12));
		label_8.setBounds(369, 295, 239, 41);
		panelNew.add(label_8);
		
		JLabel label_11 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u98DF\u7269\u7F16\u53F7\uFF1A");
		label_11.setFont(new Font("宋体", Font.PLAIN, 16));
		label_11.setBounds(39, 51, 160, 19);
		panelNew.add(label_11);
		
		textField_fno = new JTextField();
		textField_fno.setColumns(10);
		textField_fno.setBounds(204, 49, 153, 21);
		panelNew.add(textField_fno);
		
		JLabel lblf = new JLabel("\u793A\u4F8B\uFF1Af001");
		lblf.setForeground(Color.GRAY);
		lblf.setFont(new Font("宋体", Font.PLAIN, 12));
		lblf.setBounds(369, 54, 111, 15);
		panelNew.add(lblf);
		
		JButton button1 = new JButton("\u65B0\u589E\u98DF\u7269");
		button1.setActionCommand("\u65B0\u589E\u98DF\u7269");

		button1.setFont(new Font("宋体", Font.PLAIN, 16));
		button1.setBounds(452, 356, 125, 44);
		panelNew.add(button1);
		
		JLabel lblcsnb = new JLabel("\u5F53\u524D\u64CD\u4F5C\u7528\u6237\uFF1Acsnb");
		lblcsnb.setForeground(Color.GRAY);
		lblcsnb.setFont(new Font("宋体", Font.PLAIN, 12));
		lblcsnb.setBounds(497, 0, 111, 15);
		panelNew.add(lblcsnb);
		
		//------------------
		
		JLabel label_13 = new JLabel("POWER");
		label_13.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label_13.setBounds(0, 0, 64, 22);
		FoodFrame.getContentPane().add(label_13);
		
		JButton button_Return = new JButton("\u8FD4 \u56DE");
		button_Return.setIcon(new ImageIcon(Food.class.getResource("/Power/return.png")));
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		button_Return.setBounds(732, 430, 172, 52);
		
//		button_Return.setForeground(Color.GRAY);
//		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
//		button_Return.setBounds(741, 445, 97, 52);
		FoodFrame.getContentPane().add(button_Return);
		
		JLabel label_fruit = new JLabel("");
		ImageIcon ico_fruit = new ImageIcon(Login.class.getResource("fruit.png")) ;//背景图案
		ico_fruit.setImage(ico_fruit.getImage().getScaledInstance(ico_fruit.getIconWidth(),
																  ico_fruit.getIconHeight(), 
																  Image.SCALE_DEFAULT)); 
		label_fruit.setIcon(ico_fruit);
		
		label_fruit.setBounds(56, 26, 60, 60);
		FoodFrame.getContentPane().add(label_fruit);
		
		JButton button_2 = new JButton("\u6C34\u679C\u67E5\u8BE2");
		
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		button_2.setBounds(126, 26, 139, 48);
		FoodFrame.getContentPane().add(button_2);
		
		JLabel label_zs = new JLabel("");
		ImageIcon ico_zs = new ImageIcon(Login.class.getResource("zs.png")) ;//背景图案
		ico_zs.setImage(ico_zs.getImage().getScaledInstance(ico_zs.getIconWidth(),
															ico_zs.getIconHeight(), 
															Image.SCALE_DEFAULT)); 
		label_zs.setIcon(ico_zs);
		label_zs.setBounds(45, 84, 82, 60);
		FoodFrame.getContentPane().add(label_zs);
		
		JButton button_3 = new JButton("\u4E3B\u98DF\u67E5\u8BE2");
		
		button_3.setFont(new Font("宋体", Font.PLAIN, 14));
		button_3.setBounds(126, 84, 139, 48);
		FoodFrame.getContentPane().add(button_3);
		
		JLabel label_sc = new JLabel("");
		ImageIcon ico_sc = new ImageIcon(Login.class.getResource("sc.png")) ;//背景图案
		ico_sc.setImage(ico_sc.getImage().getScaledInstance(ico_sc.getIconWidth(),
															ico_sc.getIconHeight(), 
															Image.SCALE_DEFAULT)); 
		label_sc.setIcon(ico_sc);
		label_sc.setBounds(61, 142, 50, 50);
		FoodFrame.getContentPane().add(label_sc);
		
		JButton button_4 = new JButton("\u852C\u83DC\u67E5\u8BE2");
		
		button_4.setFont(new Font("宋体", Font.PLAIN, 14));
		button_4.setBounds(126, 144, 139, 48);
		FoodFrame.getContentPane().add(button_4);
		
		JLabel label_qt = new JLabel("");
		ImageIcon ico_qt = new ImageIcon(Login.class.getResource("qt.png")) ;//背景图案
		ico_qt.setImage(ico_qt.getImage().getScaledInstance(ico_qt.getIconWidth(),
															ico_qt.getIconHeight(), 
															Image.SCALE_DEFAULT)); 
		label_qt.setIcon(ico_qt);
		label_qt.setBounds(61, 202, 50, 50);
		FoodFrame.getContentPane().add(label_qt);
		
		JButton button_5 = new JButton("\u5176\u4ED6\u98DF\u7269\u67E5\u8BE2");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setFont(new Font("宋体", Font.PLAIN, 14));
		button_5.setBounds(126, 202, 139, 48);
		FoodFrame.getContentPane().add(button_5);
		
		JLabel label_kll = new JLabel("");
		ImageIcon ico_kll = new ImageIcon(Login.class.getResource("kll.png")) ;//背景图案
		ico_kll.setImage(ico_kll.getImage().getScaledInstance(ico_kll.getIconWidth(),
															ico_kll.getIconHeight(), 
															Image.SCALE_DEFAULT)); 
		label_kll.setIcon(ico_kll);
		label_kll.setBounds(61, 262, 50, 50);
		FoodFrame.getContentPane().add(label_kll);
		
		JButton button_6 = new JButton("\u5361\u8DEF\u91CC\u67E5\u8BE2");
		
		button_6.setFont(new Font("宋体", Font.PLAIN, 14));
		button_6.setBounds(126, 264, 139, 48);
		FoodFrame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("\u65B0\u589E\u98DF\u7269");
		
		button_7.setFont(new Font("宋体", Font.PLAIN, 14));
		button_7.setBounds(126, 328, 139, 48);
		FoodFrame.getContentPane().add(button_7);
		
		JLabel label_newfood = new JLabel("");
		ImageIcon ico_newfood = new ImageIcon(Login.class.getResource("newfood.png")) ;//背景图案
		ico_newfood.setImage(ico_newfood.getImage().getScaledInstance(ico_newfood.getIconWidth(),
															ico_newfood.getIconHeight(), 
															Image.SCALE_DEFAULT)); 
		label_newfood.setIcon(ico_newfood);
		label_newfood.setBounds(54, 322, 65, 65);
		FoodFrame.getContentPane().add(label_newfood);
		
		//返回主页面
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				window.FoodFrame.setVisible(false);
				FoodFrame.dispose();
				MainPanel = new Home();
				try {
					MainPanel.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//查询水果
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
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
				panelNew.setVisible(false);
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
				panelNew.setVisible(false);
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
				panelNew.setVisible(false);
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
				panelNew.setVisible(false);
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
		
		//新增食物panel切换
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(true);
				panelFind.setVisible(false);
			}
		});
		
		//新增食物
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fname = textField_fname.getText();
				String fno = textField_fno.getText();
				String fin = textField_fin.getText();
				String fcal = textField_fcal.getText();
				String ftype = textField_ftype.getText();
				
//				JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					
//					insert into food values('f101','洋芋',50,41,'豆类')
					sqlStr="insert into food values('"+fno+"','"+fname+"',"+fin+","+fcal+",'"+ftype+"')";
					st=conn.createStatement();
					st.execute(sqlStr);
					JOptionPane.showMessageDialog(FoodFrame, "新增 "+fname+" 食物成功！","新增食物成功~",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		panelFind.setVisible(false);
		panelNew.setVisible(true);
				
	}
}
