package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

/**
 * @author 拔牙不打麻药
 *
 * @time 2020年5月26日
 */

public class TrainingRecord {
	UserHome UserHome;
	TrainingRecord window;
	static JFrame TrainingFrame;
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
					TrainingRecord window = new TrainingRecord();
					TrainingFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrainingRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TrainingFrame = new JFrame();
		TrainingFrame.setTitle("POWER");
		TrainingFrame.setBounds(100, 100, 930, 560);
		TrainingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TrainingFrame.getContentPane().setLayout(null);
		
		JLabel label_power = new JLabel("POWER");
		label_power.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label_power.setBounds(0, 0, 80, 24);
		TrainingFrame.getContentPane().add(label_power);
		
		JLabel label = new JLabel("\u5F53\u524D\u4F7F\u7528\u7528\u6237\uFF1A\u8BF7\u524A\u7334\u5B50");
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		label.setBounds(627, 0, 281, 21);
		TrainingFrame.getContentPane().add(label);
		
		JButton button_return = new JButton("\u8FD4\u56DE");
		
		button_return.setIcon(new ImageIcon(TrainingRecord.class.getResource("/Power/return.png")));
		button_return.setForeground(Color.GRAY);
		button_return.setFont(new Font("黑体", Font.PLAIN, 22));
		button_return.setContentAreaFilled(false);
		button_return.setBorderPainted(false);
		button_return.setBounds(736, 452, 172, 52);
		TrainingFrame.getContentPane().add(button_return);
		
		JButton button_trainingrecord = new JButton("\u8BAD\u7EC3\u8BB0\u5F55\u67E5\u8BE2");
		
		button_trainingrecord.setIcon(new ImageIcon(TrainingRecord.class.getResource("/Power/trainingrecords.png")));
		button_trainingrecord.setVerifyInputWhenFocusTarget(false);
		button_trainingrecord.setToolTipText("");
		button_trainingrecord.setRolloverEnabled(false);
		button_trainingrecord.setRequestFocusEnabled(false);
		button_trainingrecord.setOpaque(false);
		button_trainingrecord.setFont(new Font("黑体", Font.PLAIN, 18));
		button_trainingrecord.setFocusTraversalKeysEnabled(false);
		button_trainingrecord.setFocusPainted(false);
		button_trainingrecord.setDefaultCapable(false);
		button_trainingrecord.setContentAreaFilled(false);
		button_trainingrecord.setBorderPainted(false);
		button_trainingrecord.setBounds(34, 83, 215, 57);
		TrainingFrame.getContentPane().add(button_trainingrecord);
		
		JButton button_desc = new JButton("\u964D\u5E8F");
		
		button_desc.setIcon(new ImageIcon(TrainingRecord.class.getResource("/Power/trainingrecordtime.png")));
		button_desc.setToolTipText("");
		button_desc.setFont(new Font("黑体", Font.PLAIN, 18));
		button_desc.setContentAreaFilled(false);
		button_desc.setBorderPainted(false);
		button_desc.setBounds(34, 223, 139, 57);
		TrainingFrame.getContentPane().add(button_desc);
		
		JButton button_orderbydate = new JButton("\u5347\u5E8F");
		
		button_orderbydate.setIcon(new ImageIcon(TrainingRecord.class.getResource("/Power/trainingrecorddate.png")));
		button_orderbydate.setToolTipText("");
		button_orderbydate.setFont(new Font("黑体", Font.PLAIN, 18));
		button_orderbydate.setContentAreaFilled(false);
		button_orderbydate.setBorderPainted(false);
		button_orderbydate.setBounds(34, 363, 139, 57);
		TrainingFrame.getContentPane().add(button_orderbydate);
		
		JPanel panel_trainingrecord = new JPanel();
		panel_trainingrecord.setBounds(264, 110, 566, 327);
		TrainingFrame.getContentPane().add(panel_trainingrecord);
		panel_trainingrecord.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea.setBounds(15, 15, 535, 284);
		panel_trainingrecord.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(15, 15, 535, 284);
		panel_trainingrecord.add(scrollPane);
		
		JComboBox comboBox_trainingrecord = new JComboBox();
		comboBox_trainingrecord.setBorder(null);
		comboBox_trainingrecord.setFocusable(false);
		comboBox_trainingrecord.setLightWeightPopupEnabled(false);
		comboBox_trainingrecord.setFont(new Font("Cambria", Font.PLAIN, 18));
		comboBox_trainingrecord.setModel(new DefaultComboBoxModel(new String[] {"stime", "rdate"}));
		comboBox_trainingrecord.setBounds(447, 77, 139, 27);
		TrainingFrame.getContentPane().add(comboBox_trainingrecord);
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u6392\u5E8F\u7684\u5217\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(264, 83, 148, 21);
		TrainingFrame.getContentPane().add(label_1);
		
		button_trainingrecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from trainingrecord";
//				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea.setText("");
				     while(rs.next()) {
				      result = "训练记录编号："+rs.getString("rno")+"\t用户ID："+rs.getString("uno")+"\t训练编号："
				          +rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时长："+rs.getString("stime")+"\t训练日期："+rs.getString("rdate");
				      textArea.setText(textArea.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_desc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from trainingrecord order by "+comboBox_trainingrecord.getSelectedItem()+" desc;";
//				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea.setText("");
				     while(rs.next()) {
				      result = "训练记录编号："+rs.getString("rno")+"\t用户ID："+rs.getString("uno")+"\t训练编号："
				          +rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时长："+rs.getString("stime")+"\t训练日期："+rs.getString("rdate");
				      textArea.setText(textArea.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		button_orderbydate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				     conn=DriverManager.getConnection(dbURL,userName,userPwd);
				     sqlStr="select * from trainingrecord order by "+comboBox_trainingrecord.getSelectedItem()+" asc;";
//				     System.out.println(sqlStr);
				     st= conn.createStatement();
				     rs=st.executeQuery(sqlStr);
				     String result = "";
				     textArea.setText("");
				     while(rs.next()) {
				      result = "训练记录编号："+rs.getString("rno")+"\t用户ID："+rs.getString("uno")+"\t训练编号："
				          +rs.getString("sno")+"\t训练名称："+rs.getString("sname")+"\t训练时长："+rs.getString("stime")+"\t训练日期："+rs.getString("rdate");
				      textArea.setText(textArea.getText()+result+"\n");
				      //JOptionPane.showMessageDialog(null, "查询成功！建议北大青鸟录取！","古德！",JOptionPane.INFORMATION_MESSAGE);
				     }
				    }
				    catch(Exception e1) {
				     JOptionPane.showMessageDialog(null, "数据库连接失败"+e1.getMessage());
				    }
			}
		});
		
		//返回用户主页面
		button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingFrame.dispose();
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
