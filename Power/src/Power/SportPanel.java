package Power;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SportPanel extends JPanel {
//	JTextField textField;
	
	JPanel panelNew;
	JPanel panelSort;
	JPanel panelFindxlbw;
	JPanel panelFindxlsj;
	JPanel panelFIndxlmb;
	
	private JTextField textFieldCX;
	Home MainPanel;
	JButton button_Return;
	private JTextField textField_sname;
	private JTextField textField_stime;
	private JTextField textField_sgoal;
	private JTextField textField_srmb;
	private JTextField textField_spart;
	private JTextField textField_sno;
	private JTextField textField_find_slxj;
	private JTextField textField_find_slmb;
	private JTextField textField_find_xlbw;
	
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
	 * Create the panel.
	 */
	public SportPanel() {
		
		JPanel panelSort = new JPanel();
		panelSort.setBounds(281, 50, 618, 380);
		add(panelSort);
		panelSort.setLayout(null);
		
		JButton button_Sort = new JButton("\u5237\u65B0\u67E5\u8BE2\u7ED3\u679C");
		
		button_Sort.setFont(new Font("宋体", Font.PLAIN, 16));
		button_Sort.setBounds(457, 330, 151, 44);
		panelSort.add(button_Sort);
		
		JLabel label = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("幼圆", Font.PLAIN, 16));
		label.setBounds(0, 26, 151, 15);
		panelSort.add(label);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("宋体", Font.PLAIN, 14));
		textAreaResult.setBounds(0, 51, 618, 295);
		panelSort.add(textAreaResult);
		
		JScrollPane scrollPaneReturn = new JScrollPane(textAreaResult);
		scrollPaneReturn.setBounds(0, 51, 618, 275);
		panelSort.add(scrollPaneReturn);
		
		//----------------------------------------		
		JPanel panelNew = new JPanel();
		panelNew.setBounds(281, 50, 618, 380);
		add(panelNew);
		panelNew.setLayout(null);
		
		
		JLabel label1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u8FD0\u52A8\u540D\u79F0\uFF1A");
		label1.setBounds(38, 75, 160, 19);
		label1.setFont(new Font("宋体", Font.PLAIN, 16));
		panelNew.add(label1);
		
		textField_sname = new JTextField();
		textField_sname.setBounds(203, 73, 153, 21);
		textField_sname.setColumns(10);
		panelNew.add(textField_sname);
		
		JLabel lbls = new JLabel("\u793A\u4F8B\uFF1As001");
		lbls.setBounds(366, 26, 111, 15);
		lbls.setForeground(Color.GRAY);
		lbls.setFont(new Font("宋体", Font.PLAIN, 12));
		panelNew.add(lbls);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u8FD0\u52A8\u6240\u9700\u7684\u65F6\u95F4\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(38, 128, 192, 19);
		panelNew.add(label_3);
		
		textField_stime = new JTextField();
		textField_stime.setColumns(10);
		textField_stime.setBounds(240, 126, 117, 21);
		panelNew.add(textField_stime);
		
		JLabel label_4 = new JLabel("\u793A\u4F8B\uFF1A\u9AD8\u4F4D\u4E0B\u62C9");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(366, 77, 111, 15);
		panelNew.add(label_4);
		
		JLabel label_5 = new JLabel("\u793A\u4F8B\uFF1A20 , \u5355\u4F4D\uFF1A\u5206\u949F");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		label_5.setBounds(366, 129, 177, 15);
		panelNew.add(label_5);
		
		JLabel label_6 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u8FD0\u52A8\u7684\u953B\u70BC\u76EE\u6807\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(38, 181, 192, 19);
		panelNew.add(label_6);
		
		textField_sgoal = new JTextField();
		textField_sgoal.setColumns(10);
		textField_sgoal.setBounds(239, 179, 117, 21);
		panelNew.add(textField_sgoal);
		
		JLabel label_7 = new JLabel("\u793A\u4F8B\uFF1A\u589E\u808C");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("宋体", Font.PLAIN, 12));
		label_7.setBounds(366, 181, 177, 15);
		panelNew.add(label_7);
		
		JLabel label_8 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u8FD0\u52A8\u7684\u96BE\u5EA6\u7CFB\u6570\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(38, 234, 192, 19);
		panelNew.add(label_8);
		
		textField_srmb = new JTextField();
		textField_srmb.setColumns(10);
		textField_srmb.setBounds(239, 232, 117, 21);
		panelNew.add(textField_srmb);
		
		JLabel label_9 = new JLabel("\u793A\u4F8B\uFF1A0.2 , \u6570\u503C\u8303\u56F4\uFF1A0.1~1.0");
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("宋体", Font.PLAIN, 12));
		label_9.setBounds(366, 233, 198, 15);
		panelNew.add(label_9);
		
		JLabel label_10 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u8FD0\u52A8\u7684\u953B\u70BC\u90E8\u4F4D\uFF1A");
		label_10.setFont(new Font("宋体", Font.PLAIN, 16));
		label_10.setBounds(38, 287, 192, 19);
		panelNew.add(label_10);
		
		textField_spart = new JTextField();
		textField_spart.setColumns(10);
		textField_spart.setBounds(240, 285, 117, 21);
		panelNew.add(textField_spart);
		
		JLabel label_11 = new JLabel("\u793A\u4F8B\uFF1A\u80CC\u90E8");
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("宋体", Font.PLAIN, 12));
		label_11.setBounds(366, 285, 198, 15);
		panelNew.add(label_11);
		
		JButton button1 = new JButton("\u65B0\u589E\u8FD0\u52A8");
		
		button1.setFont(new Font("宋体", Font.PLAIN, 16));
		button1.setBounds(454, 321, 125, 44);
		panelNew.add(button1);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u8FD0\u52A8\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(38, 22, 160, 19);
		panelNew.add(label_1);
		
		textField_sno = new JTextField();
		textField_sno.setColumns(10);
		textField_sno.setBounds(203, 20, 153, 21);
		panelNew.add(textField_sno);
		setLayout(null);
		
		//-----------------------------------------
		JPanel panelFindxlsj = new JPanel();
		panelFindxlsj.setBounds(281, 50, 618, 380);
		add(panelFindxlsj);
		panelFindxlsj.setLayout(null);
		
		JButton button_findxlsj = new JButton("\u5F00\u59CB\u67E5\u8BE2");
				
		button_findxlsj.setFont(new Font("宋体", Font.PLAIN, 16));
		button_findxlsj.setBounds(457, 325, 151, 44);
		panelFindxlsj.add(button_findxlsj);
		
		JTextArea textAreaResult_xlsj = new JTextArea();
		textAreaResult_xlsj.setFont(new Font("宋体", Font.PLAIN, 14));
		textAreaResult_xlsj.setBounds(0, 71, 618, 255);
		panelFindxlsj.add(textAreaResult_xlsj);
		
		JScrollPane scrollPaneReturn_xlsj = new JScrollPane(textAreaResult_xlsj);
		scrollPaneReturn_xlsj.setBounds(0, 71, 618, 235);
		panelFindxlsj.add(scrollPaneReturn_xlsj);
		
		JLabel label_xlsj = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label_xlsj.setForeground(Color.DARK_GRAY);
		label_xlsj.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_xlsj.setBounds(0, 50, 151, 15);
		panelFindxlsj.add(label_xlsj);
		
		textField_find_slxj = new JTextField();
		textField_find_slxj.setBounds(128, 10, 488, 21);
		panelFindxlsj.add(textField_find_slxj);
		textField_find_slxj.setColumns(10);
		
		JLabel label_xlsjcx = new JLabel("\u8BAD\u7EC3\u65F6\u95F4\u67E5\u8BE2 \uFF1A");
		label_xlsjcx.setForeground(Color.DARK_GRAY);
		label_xlsjcx.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_xlsjcx.setBounds(0, 15, 200, 15);
		panelFindxlsj.add(label_xlsjcx);
		
		//----------------------------------
		JPanel panelFindxlbw = new JPanel();
		panelFindxlbw.setBounds(281, 50, 618, 380);
		add(panelFindxlbw);
		panelFindxlbw.setLayout(null);
		
		JButton button_findxlbw = new JButton("\u5F00\u59CB\u67E5\u8BE2");
				
		button_findxlbw.setFont(new Font("宋体", Font.PLAIN, 16));
		button_findxlbw.setBounds(457, 325, 151, 44);
		panelFindxlbw.add(button_findxlbw);
		
		JTextArea textAreaResult_xlbw = new JTextArea();
		textAreaResult_xlbw.setFont(new Font("宋体", Font.PLAIN, 14));
		textAreaResult_xlbw.setBounds(0, 71, 618, 255);
		panelFindxlbw.add(textAreaResult_xlbw);
		
		JScrollPane scrollPaneReturn_xlbw = new JScrollPane(textAreaResult_xlbw);
		scrollPaneReturn_xlbw.setBounds(0, 71, 618, 235);
		panelFindxlbw.add(scrollPaneReturn_xlbw);
		
		JLabel label_xlbw = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label_xlbw.setForeground(Color.DARK_GRAY);
		label_xlbw.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_xlbw.setBounds(0, 50, 151, 15);
		panelFindxlbw.add(label_xlbw);
		
		textField_find_xlbw = new JTextField();
		textField_find_xlbw.setBounds(128, 10, 488, 21);
		panelFindxlbw.add(textField_find_xlbw);
		textField_find_xlbw.setColumns(10);
		
		JLabel label_xlbwcx = new JLabel("\u8BAD\u7EC3\u90E8\u4F4D\u67E5\u8BE2 \uFF1A");
		label_xlbwcx.setForeground(Color.DARK_GRAY);
		label_xlbwcx.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_xlbwcx.setBounds(0, 15, 200, 15);
		panelFindxlbw.add(label_xlbwcx);
		
		//-------------------------------------
		JPanel panelFindxlmb = new JPanel();
		panelFindxlmb.setBounds(281, 50, 618, 380);
		add(panelFindxlmb);
		panelFindxlmb.setLayout(null);
		
		JButton button_findxlmb = new JButton("\u5F00\u59CB\u67E5\u8BE2");
				
		button_findxlmb.setFont(new Font("宋体", Font.PLAIN, 16));
		button_findxlmb.setBounds(457, 325, 151, 44);
		panelFindxlmb.add(button_findxlmb);
		
		JTextArea textAreaResult_xlmb = new JTextArea();
		textAreaResult_xlmb.setFont(new Font("宋体", Font.PLAIN, 14));
		textAreaResult_xlmb.setBounds(0, 71, 618, 255);
		panelFindxlmb.add(textAreaResult_xlmb);
		
		JScrollPane scrollPaneReturn_xlmb = new JScrollPane(textAreaResult_xlmb);
		scrollPaneReturn_xlmb.setBounds(0, 71, 618, 235);
		panelFindxlmb.add(scrollPaneReturn_xlmb);
		
		JLabel label_xlmb = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C \uFF1A");
		label_xlmb.setForeground(Color.DARK_GRAY);
		label_xlmb.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_xlmb.setBounds(0, 50, 151, 15);
		panelFindxlmb.add(label_xlmb);
		
		textField_find_slmb = new JTextField();
		textField_find_slmb.setBounds(128, 10, 488, 21);
		panelFindxlmb.add(textField_find_slmb);
		textField_find_slmb.setColumns(10);
		
		JLabel label_xlmbcx = new JLabel("\u8BAD\u7EC3\u76EE\u6807\u67E5\u8BE2 \uFF1A");
		label_xlmbcx.setForeground(Color.DARK_GRAY);
		label_xlmbcx.setFont(new Font("幼圆", Font.PLAIN, 16));
		label_xlmbcx.setBounds(0, 15, 200, 15);
		panelFindxlmb.add(label_xlmbcx);
		
		JLabel label1111 = new JLabel("POWER");
		label1111.setBounds(30, 0, 64, 22);
		label1111.setFont(new Font("French Script MT", Font.PLAIN, 20));
		add(label1111);
		
		
		JLabel lbl_target = new JLabel("");
		lbl_target.setBounds(53, 32, 48, 48);
		
		ImageIcon ico_target = new ImageIcon(Login.class.getResource("target.png")) ;//背景图案
		ico_target.setImage(ico_target.getImage().getScaledInstance(ico_target.getIconWidth(),
															   ico_target.getIconHeight(), 
															   Image.SCALE_DEFAULT)); 
		lbl_target.setIcon(ico_target);
		add(lbl_target);
		
		JButton button_xlmb = new JButton("\u8BAD\u7EC3\u76EE\u6807\u67E5\u8BE2");
		button_xlmb.setBounds(111, 32, 139, 48);
		
		button_xlmb.setFont(new Font("宋体", Font.PLAIN, 14));
		add(button_xlmb);
		
		JLabel lbl_part = new JLabel("");
		lbl_part.setBounds(53, 133, 48, 48);
		ImageIcon ico_part = new ImageIcon(Login.class.getResource("part.png")) ;//背景图案
		ico_part.setImage(ico_part.getImage().getScaledInstance(ico_part.getIconWidth(),
															   ico_part.getIconHeight(), 
															   Image.SCALE_DEFAULT)); 
		lbl_part.setIcon(ico_part);
		add(lbl_part);
		
		JButton button_xlbw = new JButton("\u8BAD\u7EC3\u90E8\u4F4D\u67E5\u8BE2");
		
		button_xlbw.setBounds(111, 133, 139, 48);
		button_xlbw.setFont(new Font("宋体", Font.PLAIN, 14));
		add(button_xlbw);
		
		JLabel lbl_time = new JLabel("");
		lbl_time.setBounds(53, 234, 48, 48);
		ImageIcon ico_time = new ImageIcon(Login.class.getResource("time.png")) ;//背景图案
		ico_time.setImage(ico_time.getImage().getScaledInstance(ico_time.getIconWidth(),
															   ico_time.getIconHeight(), 
															   Image.SCALE_DEFAULT)); 
		lbl_time.setIcon(ico_time);
		add(lbl_time);
		
		JButton button_xlsj = new JButton("\u8BAD\u7EC3\u65F6\u95F4\u67E5\u8BE2");
		
		button_xlsj.setBounds(111, 234, 139, 48);
		button_xlsj.setFont(new Font("宋体", Font.PLAIN, 14));
		add(button_xlsj);
		
		JLabel lbl_hreat = new JLabel("");
		lbl_hreat.setBounds(53, 335, 48, 48);
		ImageIcon ico_hreat = new ImageIcon(Login.class.getResource("hreat.png")) ;//背景图案
		ico_hreat.setImage(ico_hreat.getImage().getScaledInstance(ico_hreat.getIconWidth(),
															   ico_hreat.getIconHeight(), 
															   Image.SCALE_DEFAULT)); 
		lbl_hreat.setIcon(ico_hreat);
		add(lbl_hreat);
		
		JButton button_xlqd = new JButton("\u8BAD\u7EC3\u5F3A\u5EA6\u67E5\u8BE2");
		
		button_xlqd.setBounds(111, 335, 139, 48);
		button_xlqd.setFont(new Font("宋体", Font.PLAIN, 14));
		add(button_xlqd);
		
		JLabel lbl_new = new JLabel("");
		lbl_new.setBounds(53, 436, 48, 48);
		ImageIcon ico_new = new ImageIcon(Login.class.getResource("new.png")) ;//背景图案
		ico_new.setImage(ico_new.getImage().getScaledInstance(ico_new.getIconWidth(),
															  ico_new.getIconHeight(), 
															  Image.SCALE_DEFAULT)); 
		lbl_new.setIcon(ico_new);
		add(lbl_new);
		
		JButton button_new = new JButton("\u65B0\u589E\u8FD0\u52A8\u7BA1\u7406");
		button_new.setBounds(111, 436, 139, 48);
		
		button_new.setFont(new Font("宋体", Font.PLAIN, 14));
		add(button_new);
		
		button_Return = new JButton("\u8FD4 \u56DE");
		button_Return.setIcon(new ImageIcon(SportPanel.class.getResource("/Power/return.png")));
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		button_Return.setBounds(727, 459, 172, 52);
		
		button_Return.setFont(new Font("黑体", Font.PLAIN, 22));
		add(button_Return);
		
		JLabel label_121 = new JLabel("\u5F53\u524D\u64CD\u4F5C\u7528\u6237\uFF1Acsnb");
		label_121.setForeground(Color.GRAY);
		label_121.setFont(new Font("宋体", Font.PLAIN, 12));
		label_121.setBounds(794, 25, 111, 15);
		add(label_121);
		
		//切换训练目标panel
		button_xlmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFindxlsj.setVisible(false);
				panelSort.setVisible(false);
				panelFindxlbw.setVisible(false);
				panelFindxlmb.setVisible(true);
			}
		});
		
		//查询训练目标
		button_findxlmb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaResult_xlmb.setText("");
				String xlmbStr = textField_find_slmb.getText();

				//select * From sport where sgoal='增肌'
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From sport where sgoal='"+xlmbStr+"'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb")+"\t训练部位："+rs.getString("spart");
						textAreaResult_xlmb.setText(textAreaResult_xlmb.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//切换新建运动panel
		button_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFindxlsj.setVisible(false);
				panelNew.setVisible(true);
				panelSort.setVisible(false);
				panelFindxlbw.setVisible(false);
				panelFindxlmb.setVisible(false);
			}
		});
		
		//新增运动
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				create table sport(sno char(10),sname char(20),stime int,sgoal char(5), srmb float,spart char(20),primary key(sno))
//				--sport表：训练编号，训练名称，训练时间，训练目标，训练强度，训练部位，主键：训练编号

				String sname = textField_sname.getText();
				String sno = textField_sno.getText();
				String stime = textField_stime.getText();
				String sgoal = textField_sgoal.getText();
				String srmb = textField_srmb.getText();
				String spart = textField_spart.getText();
				
//				JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					
//					insert into sport values('s001','高位下拉',20,'增肌','0.2','背部')
					sqlStr="insert into sport values('"+sno+"','"+sname+"',"+stime+",'"+sgoal+"','"+srmb+"','"+spart+"')";
					st=conn.createStatement();
					st.execute(sqlStr);
					JOptionPane.showMessageDialog(panelNew, "新增 "+sname+" 运动成功！","新增运动成功~",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//切换训练部位panel
		button_xlbw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFindxlsj.setVisible(false);
				panelSort.setVisible(false);
				panelFindxlbw.setVisible(true);
				panelFindxlmb.setVisible(false);
			}
		});
		
		//查询训练部位
		button_findxlbw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaResult_xlbw.setText("");
				String xlbwStr = textField_find_xlbw.getText();
				System.out.print(xlbwStr);
				//select * From sport where spart='背部'
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From sport where spart='"+xlbwStr+"'";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb");
						textAreaResult_xlbw.setText(textAreaResult_xlbw.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//切换训练时间panel
		button_xlsj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFindxlsj.setVisible(true);
				panelSort.setVisible(false);
				panelFindxlbw.setVisible(false);
				panelFindxlmb.setVisible(false);
			}
		});
		
		//查询训练时间
		button_findxlsj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaResult_xlsj.setText("");
				String xlsjStr = textField_find_slxj.getText();
//				System.out.printf(xlsjStr);
				//select * From sport where stime=20
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From sport where stime = "+xlsjStr;
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb")+"\t训练部位："+rs.getString("spart");
						textAreaResult_xlsj.setText(textAreaResult_xlsj.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//更新查询
		button_Sort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaResult.setText("");
				
				//select * From food Order by fcal desc
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From sport Order by srmb desc";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result =  "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb")+"\t训练部位："+rs.getString("spart");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		//切换训练强度panel
		button_xlqd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNew.setVisible(false);
				panelFindxlsj.setVisible(false);
				panelSort.setVisible(true);
				panelFindxlbw.setVisible(false);
				panelFindxlmb.setVisible(false);
				
				textAreaResult.setText("");
				
				//select * From food Order by fcal desc
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From sport Order by srmb desc";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "训练编号："+rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时间："+rs.getString("stime")+
								"\t训练目标："+rs.getString("sgoal")+"\t训练强度："+rs.getString("srmb")+"\t训练部位："+rs.getString("spart");
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				}
			}
		});
		
		panelNew.setVisible(false);
		panelFindxlsj.setVisible(false);
		panelSort.setVisible(false);
		panelFindxlbw.setVisible(false);
		panelFindxlmb.setVisible(true);
	}

}
